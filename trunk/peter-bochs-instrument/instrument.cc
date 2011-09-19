/////////////////////////////////////////////////////////////////////////
// $Id: instrument.cc 10491 2011-07-23 19:58:38Z sshwarts $
/////////////////////////////////////////////////////////////////////////
//
//   Copyright (c) 2006-2009 Stanislav Shwartsman
//          Written by Stanislav Shwartsman [sshwarts at sourceforge net]
//
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Lesser General Public
//  License as published by the Free Software Foundation; either
//  version 2 of the License, or (at your option) any later version.
//
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Lesser General Public License for more details.
//
//  You should have received a copy of the GNU Lesser General Public
//  License along with this library; if not, write to the Free Software
//  Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA

#include <assert.h>

#include "bochs.h"
#include "cpu/cpu.h"
#include "disasm/disasm.h"

#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <netinet/tcp.h>
#include <fstream>
using namespace std;
#include <set>
using std::set;

#define PETER_BOCHS_INSTRUMENT_VERSION "20110730"

int memorySockfd;
int jmpSockfd;
int interruptSockfd;

int memoryPortNo = 1980;
int jmpPortNo = 1981;
int interruptPortNo = 1982;

int oslogPort = 0xffff;
char *oslogFile = "os.log";
ofstream oslogStream(oslogFile, ios::app);

#define printHeader

bxInstrumentation *icpu = NULL;

static disassembler bx_disassembler;

#define MAX_SEND_BYTE 500
FILE *log;
unsigned int zonesFrom[MAX_SEND_BYTE];
unsigned int zonesTo[MAX_SEND_BYTE];
unsigned int zonesHit[MAX_SEND_BYTE];
unsigned int zonesTail = 0;
set<unsigned int> zonesHitAddress[MAX_SEND_BYTE];

bx_bool connectedToMemoryServer;
bx_bool connectedToJmpServer;
bx_bool connectedToInterruptServer;
bx_bool triedToContectToServer;

bx_address startRecordJumpAddress = 0x7c00;
bx_bool startRecordJump;

bx_address segmentBegin = startRecordJumpAddress;
bx_address segmentEnd;

void logPeterBochs(char *str) {
	fprintf(log, str);
	fflush(log);
}

void logPeterBochs(char *str1, char *str2, char *str3) {
	fprintf(log, str1);
	fprintf(log, str2);
	fprintf(log, str3);
	fflush(log);
}

void logPeterBochs(unsigned int x) {
	char temp[100];
	sprintf(temp, "%x\n", x);
	fprintf(log, temp);
	fflush(log);
}

void logPeterBochs(char *a, unsigned int x, char *b) {
	fprintf(log, a);
	char temp[100];
	sprintf(temp, "%u", x);
	fprintf(log, temp);
	fprintf(log, b);
	fflush(log);
}

unsigned int convert(unsigned char *inBuffer) {
	return inBuffer[3] + (inBuffer[2] << 8) + (inBuffer[1] << 16)
			+ (inBuffer[0] << 24);
}

void safeRead(int socketFD, unsigned char *inBuffer, unsigned int size) {
	int noOfBytes = 0;
	while (noOfBytes != size) {
		noOfBytes += read(socketFD, inBuffer + noOfBytes, size - noOfBytes);
	}
}

void initMemorySocket() {
	oslogStream << "initMemorySocket" << endl;
        oslogStream.flush();
	memorySockfd = socket(AF_INET, SOCK_STREAM, 0);
	if (memorySockfd < 0) {
		//fprintf(stderr, "ERROR opening socket\n");
		fprintf(log, "Memory socket server : ERROR opening socket\n");
		return;
	}
	struct sockaddr_in serv_addr;
	struct hostent *server;
	server = gethostbyname("localhost");
	if (server == NULL) {
		//fprintf(stderr, "ERROR, no such host\n");
		fprintf(log, "Memory socket server : ERROR no such host\n");
	}
	bzero((char *) &serv_addr, sizeof(serv_addr));
	serv_addr.sin_family = AF_INET;
	bcopy((char *) server->h_addr, (char *) &serv_addr.sin_addr.s_addr,
			server->h_length);
	serv_addr.sin_port = htons(memoryPortNo);
	if (connect(memorySockfd, (const sockaddr *) &serv_addr, sizeof(serv_addr))
			< 0) {
		fprintf(log, "Memory socket server : ERROR connecting\n");
		connectedToMemoryServer = false;
	} else {
		fprintf(log, "Memory socket server : connected to server\n");
		connectedToMemoryServer = true;
	}

	int flag = 1;
	int ret = setsockopt(memorySockfd, IPPROTO_TCP, TCP_NODELAY,
			(char *) &flag, sizeof(flag));
	if (ret == -1) {
		fprintf(log, "memorySockfd couldn't setsockopt(TCP_NODELAY)\n");
	}
	fflush(log);
	oslogStream << "initMemorySocket2" << endl;
        oslogStream.flush();
}

void initJmpSocket() {
	jmpSockfd = socket(AF_INET, SOCK_STREAM, 0);
	if (jmpSockfd < 0) {
		fprintf(log, "Jmp socket server : ERROR opening socket\n");
		return;
	}
	struct sockaddr_in serv_addr;
	struct hostent *server;
	server = gethostbyname("localhost");
	if (server == NULL) {
		fprintf(log, "Jmp socket server : ERROR no such host\n");
	}
	bzero((char *) &serv_addr, sizeof(serv_addr));
	serv_addr.sin_family = AF_INET;
	bcopy((char *) server->h_addr, (char *) &serv_addr.sin_addr.s_addr,
			server->h_length);
	serv_addr.sin_port = htons(jmpPortNo);
	if (connect(jmpSockfd, (const sockaddr *) &serv_addr, sizeof(serv_addr))
			< 0) {
		fprintf(log, "Jmp socket server : ERROR connecting\n");
		connectedToJmpServer = false;
	} else {
		fprintf(log, "Jmp socket server : connected to server\n");
		connectedToJmpServer = true;
	}

	int flag = 1;
	int ret = setsockopt(jmpSockfd, IPPROTO_TCP, TCP_NODELAY, (char *) &flag,
			sizeof(flag));
	if (ret == -1) {
		fprintf(log, "jmpSockfd couldn't setsockopt(TCP_NODELAY)\n");
	}

	if (connectedToJmpServer) {

	}

	fflush(log);
}

void initInterruptSocket() {
	interruptSockfd = socket(AF_INET, SOCK_STREAM, 0);
	if (interruptSockfd < 0) {
		fprintf(log, "Interrupt socket server : ERROR opening socket\n");
		return;
	}
	struct sockaddr_in serv_addr;
	struct hostent *server;
	server = gethostbyname("localhost");
	if (server == NULL) {
		fprintf(log, "Interrupt socket server : ERROR no such host\n");
	}
	bzero((char *) &serv_addr, sizeof(serv_addr));
	serv_addr.sin_family = AF_INET;
	bcopy((char *) server->h_addr, (char *) &serv_addr.sin_addr.s_addr,
			server->h_length);
	serv_addr.sin_port = htons(interruptPortNo);
	if (connect(interruptSockfd, (const sockaddr *) &serv_addr, sizeof(serv_addr))
			< 0) {
		fprintf(log, "Interrupt socket server : ERROR connecting\n");
		connectedToInterruptServer = false;
	} else {
		fprintf(log, "Interrupt socket server : connected to server\n");
		connectedToInterruptServer = true;
	}

	int flag = 1;
	int ret = setsockopt(interruptSockfd, IPPROTO_TCP, TCP_NODELAY, (char *) &flag,
			sizeof(flag));
	if (ret == -1) {
		fprintf(log, "interruptSockfd couldn't setsockopt(TCP_NODELAY)\n");
	}

	if (connectedToInterruptServer) {

	}

	fflush(log);
}

void bx_instr_init_env(void) {}
void bx_instr_exit_env(void) {}

void bx_instr_initialize(unsigned cpu)
{
  assert(cpu < BX_SMP_PROCESSORS);

  if (icpu == NULL)
      icpu = new bxInstrumentation[BX_SMP_PROCESSORS];

  icpu[cpu].set_cpu_id(cpu);

  fprintf(stderr, "Initialize cpu %d\n", cpu);

	// peter-bochs
	log = fopen("peter-bochs.log", "a+");

	fprintf(stderr, "Peter-bochs instrument %s - Initialize cpu %d\n",
			PETER_BOCHS_INSTRUMENT_VERSION, cpu);

	if (connectedToMemoryServer) {
		for (int x = 0; x < MAX_SEND_BYTE; x++) {
			zonesFrom[x] = -1;
			zonesTo[x] = -1;
			zonesHit[x] = 0;
		}
	}
}

void bxInstrumentation::bx_instr_reset(unsigned type)
{
  ready = is_branch = 0;
  num_data_accesses = 0;
  active = 1;
}

void bxInstrumentation::bx_print_instruction(void)
{
  char disasm_tbuf[512];	// buffer for instruction disassembly
  bx_disassembler.disasm(is32, is64, 0, 0, opcode, disasm_tbuf);

  if(opcode_length != 0)
  {
    unsigned n;

    //fprintf(stderr, "----------------------------------------------------------\n");
    //fprintf(stderr, "CPU: %d: %s\n", cpu_id, disasm_tbuf);
    //fprintf(stderr, "LEN: %d\tBYTES: ", opcode_length);
    for(n=0;n < opcode_length;n++) //fprintf(stderr, "%02x", opcode[n]);
    if(is_branch)
    {
      //fprintf(stderr, "\tBRANCH ");

      if(is_taken){
        //fprintf(stderr, "TARGET " FMT_ADDRX " (TAKEN)", target_linear);
      }else{
        //fprintf(stderr, "(NOT TAKEN)");
      }
    }
    //fprintf(stderr, "\n");
if (connectedToMemoryServer) {
    for(n=0;n < num_data_accesses;n++)
    {
      /*fprintf(stderr, "MEM ACCESS[%u]: 0x" FMT_ADDRX " (linear) 0x" FMT_PHY_ADDRX " (physical) %s SIZE: %d\n", n,
                    data_access[n].laddr,
                    data_access[n].paddr,
                    data_access[n].op == BX_READ ? "RD":"WR",
                    data_access[n].size);*/

	//memorySampling(data_access[n].paddr, data_access[n].eip);
    }
}

    //fprintf(stderr, "\n");
  }
}

void bxInstrumentation::bx_instr_before_execution(bxInstruction_c *i)
{
  if (!active) return;

  if (ready) bx_print_instruction();

	if (!triedToContectToServer) {
		initMemorySocket();
		initJmpSocket();
		initInterruptSocket();
		triedToContectToServer = true;
	}

  // prepare instruction_t structure for new instruction
  ready = 1;
  num_data_accesses = 0;
  is_branch = 0;

  is32 = BX_CPU(cpu_id)->sregs[BX_SEG_REG_CS].cache.u.segment.d_b;
  is64 = BX_CPU(cpu_id)->long64_mode();
  opcode_length = i->ilen();
  memcpy(opcode, i->get_opcode_bytes(), opcode_length);

	phyAddress = BX_CPU(cpu_id)->get_instruction_pointer();
	segmentEnd = phyAddress;
	if (phyAddress == startRecordJumpAddress) {
		startRecordJump = true;
	}
}

void bxInstrumentation::bx_instr_after_execution(bxInstruction_c *i)
{
  if (!active) return;

  if (ready) {
    bx_print_instruction();
    ready = 0;
  }
}

void bxInstrumentation::branch_taken(bx_address new_eip)
{
  if (!active || !ready) return;

  // find linear address
  bx_address laddr = BX_CPU(cpu_id)->get_laddr(BX_SEG_REG_CS, new_eip);

  is_branch = 1;
  is_taken = 1;
  target_linear = laddr;
}

void bxInstrumentation::bx_instr_cnear_branch_taken(bx_address new_eip)
{
  branch_taken(new_eip);
	if (connectedToJmpServer) {
		jmpSampling(new_eip);
	}
}

void bxInstrumentation::bx_instr_cnear_branch_not_taken()
{
  if (!active || !ready) return;

  is_branch = 1;
  is_taken = 0;
}

void bxInstrumentation::bx_instr_ucnear_branch(unsigned what, bx_address new_eip)
{
  branch_taken(new_eip);
	if (connectedToJmpServer) {
		jmpSampling(new_eip);
	}
}

void bxInstrumentation::bx_instr_far_branch(unsigned what, Bit16u new_cs, bx_address new_eip)
{
  branch_taken(new_eip);
	if (connectedToJmpServer) {
		jmpSampling(new_eip);
	}
}

void bxInstrumentation::bx_instr_interrupt(unsigned vector)
{
  if(active)
  {
    //fprintf(stderr, "CPU %u: interrupt %02xh\n", cpu_id, vector);
		if (connectedToInterruptServer) {
			write(interruptSockfd, &vector, sizeof(vector));
		}
  }
}

void bxInstrumentation::bx_instr_exception(unsigned vector, unsigned error_code)
{
  if(active)
  {
    //fprintf(stderr, "CPU %u: exception %02xh error_code=%x\n", cpu_id, vector, error_code);
  }
}

void bxInstrumentation::bx_instr_hwinterrupt(unsigned vector, Bit16u cs, bx_address eip)
{
  if(active)
  {
    //fprintf(stderr, "CPU %u: hardware interrupt %02xh\n", cpu_id, vector);
  }
}

void bxInstrumentation::bx_instr_mem_data_access(unsigned seg, bx_address offset, unsigned len, unsigned rw)
{
  bx_phy_address phy;

  if(!active || !ready) return;

  if (num_data_accesses >= MAX_DATA_ACCESSES)
  {
    return;
  }

  bx_address lin = BX_CPU(cpu)->get_laddr(seg, offset);
  bx_bool page_valid = BX_CPU(cpu)->dbg_xlate_linear2phy(lin, &phy);
  phy = A20ADDR(phy);

  // If linear translation doesn't exist, a paging exception will occur.
  // Invalidate physical address data for now.
  if (!page_valid) phy = (bx_phy_address) (-1);

  data_access[num_data_accesses].laddr = lin;
  data_access[num_data_accesses].paddr = phy;
  data_access[num_data_accesses].op    = rw;
  data_access[num_data_accesses].size  = len;

  data_access[num_data_accesses].eip = phyAddress;

  num_data_accesses++;

/*if (phy==0x9898){
  fprintf(log, "%x\n",phy);
fflush(log);
}*/

	if (connectedToMemoryServer) {
		memorySampling(phy, phyAddress);
	}

}

unsigned int buffer[MAX_SEND_BYTE];
int pointer = 0;

void bxInstrumentation::memorySampling(bx_phy_address paddr, bx_address eip) {
	if (!connectedToMemoryServer) {
		return;
	}
	buffer[pointer] = paddr;
	pointer++;

	// check zone
	for (int x = 0; x < zonesTail; x++) {
		if (zonesFrom[x] <= paddr && paddr <= zonesTo[x]) {
			zonesHit[x]++;
			zonesHitAddress[x].insert(eip);
		}
	}
	// end check zone
	if (pointer == MAX_SEND_BYTE) {
		send(memorySockfd, (char *) buffer, MAX_SEND_BYTE
				* sizeof(unsigned int), 0);

		send(memorySockfd, &zonesTail, sizeof(unsigned int), 0);

		for (int x = 0; x < zonesTail; x++) {
			write(memorySockfd, &zonesFrom[x], sizeof(unsigned int));
			write(memorySockfd, &zonesTo[x], sizeof(unsigned int));
			write(memorySockfd, &zonesHit[x], sizeof(unsigned int));

			unsigned int size;
			if (zonesHitAddress[x].size() < 10) {
				size = zonesHitAddress[x].size();
			} else {
				size = 10;
			}

			//noOfZoneHitAddress
			write(memorySockfd, &size, sizeof(unsigned int));

			set<unsigned int>::iterator theIterator;
			int yy = 0;
			for (theIterator = zonesHitAddress[x].begin(); theIterator
					!= zonesHitAddress[x].end() && yy < size; theIterator++) {
				write(memorySockfd, &*theIterator, sizeof(unsigned int));
				yy++;
			}
		}
		// end send zones back to peter-bochs

		unsigned char inBuffer[10000];
		safeRead(memorySockfd, inBuffer, 1);

		if (inBuffer[0] == 2) {
			safeRead(memorySockfd, inBuffer, 4);

			unsigned int noOfData = convert(inBuffer);
			int readSize = noOfData * sizeof(unsigned int) * 2;

			safeRead(memorySockfd, inBuffer, readSize);

			int offset = 0;
			for (int x = 0; x < noOfData; x++) {
				unsigned int from = convert(&inBuffer[offset]);
				zonesFrom[x] = from;
				offset += 4;

				unsigned int to = convert(&inBuffer[offset]);
				zonesTo[x] = to;
				offset += 4;
			}
			zonesTail = noOfData;
		}
		pointer = 0;
	}
}

void bxInstrumentation::jmpSampling(bx_address new_eip) {
	if (connectedToJmpServer) {
		if (startRecordJump) {
			write(jmpSockfd, &phyAddress, sizeof(bx_address));
			write(jmpSockfd, &new_eip, sizeof(bx_address));
			write(jmpSockfd, &segmentBegin, sizeof(segmentBegin));
			write(jmpSockfd, &segmentEnd, sizeof(segmentBegin));

			write(jmpSockfd, &BX_CPU(0)->gen_reg[BX_32BIT_REG_EAX].dword.erx,
					sizeof(Bit32u));
			write(jmpSockfd, &BX_CPU(0)->gen_reg[BX_32BIT_REG_ECX].dword.erx,
					sizeof(Bit32u));
			write(jmpSockfd, &BX_CPU(0)->gen_reg[BX_32BIT_REG_EDX].dword.erx,
					sizeof(Bit32u));
			write(jmpSockfd, &BX_CPU(0)->gen_reg[BX_32BIT_REG_EBX].dword.erx,
					sizeof(Bit32u));
			write(jmpSockfd, &BX_CPU(0)->gen_reg[BX_32BIT_REG_ESP].dword.erx,
					sizeof(Bit32u));
			write(jmpSockfd, &BX_CPU(0)->gen_reg[BX_32BIT_REG_EBP].dword.erx,
					sizeof(Bit32u));
			write(jmpSockfd, &BX_CPU(0)->gen_reg[BX_32BIT_REG_ESI].dword.erx,
					sizeof(Bit32u));
			write(jmpSockfd, &BX_CPU(0)->gen_reg[BX_32BIT_REG_EDI].dword.erx,
					sizeof(Bit32u));

			write(jmpSockfd, &BX_CPU(0)->sregs[BX_SEG_REG_ES].selector.value,
					sizeof(Bit16u));
			write(jmpSockfd, &BX_CPU(0)->sregs[BX_SEG_REG_CS].selector.value,
					sizeof(Bit16u));
			write(jmpSockfd, &BX_CPU(0)->sregs[BX_SEG_REG_SS].selector.value,
					sizeof(Bit16u));
			write(jmpSockfd, &BX_CPU(0)->sregs[BX_SEG_REG_DS].selector.value,
					sizeof(Bit16u));
			write(jmpSockfd, &BX_CPU(0)->sregs[BX_SEG_REG_FS].selector.value,
					sizeof(Bit16u));
			write(jmpSockfd, &BX_CPU(0)->sregs[BX_SEG_REG_GS].selector.value,
					sizeof(Bit16u));

			segmentBegin = new_eip;
		}
	}
}
