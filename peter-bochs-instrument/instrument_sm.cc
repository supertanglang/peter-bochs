/////////////////////////////////////////////////////////////////////////
// $Id: instrument.cc,v 1.30 2009/10/14 20:45:29 sshwarts Exp $
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
#include <sstream>
#include <stdarg.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>

using namespace std;

#include "bochs.h"
#include "cpu/cpu.h"
#include "disasm/disasm.h"

// maximum size of an instruction
#define MAX_OPCODE_SIZE 16

// maximum physical addresses an instruction can generate
#define MAX_DATA_ACCESSES 1024

// Use this variable to turn on/off collection of instrumentation data
// If you are not using the debugger to turn this on/off, then possibly
// start this at 1 instead of 0.
static bx_bool active = 1;

static disassembler bx_disassembler;

int shmid;
key_t key;
char *shm;
#define SHMSZ 100

static struct instruction_t {
	bx_bool valid; // is current instruction valid
	unsigned opcode_size;
	Bit8u opcode[MAX_OPCODE_SIZE];
	bx_bool is32, is64;
	unsigned num_data_accesses;
	struct {
		bx_address laddr; // linear address
		bx_phy_address paddr; // physical address
		unsigned op; // BX_READ, BX_WRITE or BX_RW
		unsigned size; // 1 .. 8
	} data_access[MAX_DATA_ACCESSES];
	bx_bool is_branch;
	bx_bool is_taken;
	bx_address target_linear;
}*instruction;

static logfunctions *instrument_log = new logfunctions();
#define LOG_THIS instrument_log->

void bx_instr_init_env(void) {
}
void bx_instr_exit_env(void) {
}

void bx_instr_initialize(unsigned cpu) {
	assert(cpu < BX_SMP_PROCESSORS);

	if (instruction == NULL)
		instruction = new struct instruction_t[BX_SMP_PROCESSORS];

	//fprintf(stderr, "Initialize cpu %d\n", cpu);


	/*stringstream ss;
	 ss << "echo -e \"Initialize cpu " << cpu << "\" | nc localhost 1980";*/

	//system(ss.str().c_str());
	//fprintf(stderr, "bx_instr_initialize\n");
	key = 0x2241980;

	if ((shmid = shmget(key, SHMSZ, IPC_CREAT | 0666)) < 0) {
		fprintf(stderr, "shmget");
		exit(1);
	}

	if ((shm = (char *) shmat(shmid, NULL, 0)) == (char *) -1) {
		fprintf(stderr, "shmat");
		exit(1);
	}

	*shm = 'S';
}

void bx_instr_reset(unsigned cpu, unsigned type) {
	instruction[cpu].valid = 0;
	instruction[cpu].num_data_accesses = 0;
	instruction[cpu].is_branch = 0;
}

int ipcount = 0;

void bx_instr_new_instruction(unsigned cpu) {
	/*if (!active)
	 return;
	 instruction_t *i = &instruction[cpu];

	 if (i->valid) {
	 char disasm_tbuf[512]; // buffer for instruction disassembly
	 unsigned length = i->opcode_size, n;

	 bx_disassembler.disasm(i->is32, i->is64, 0, 0, i->opcode, disasm_tbuf);

	 //		stringstream ss;
	 //		ss << "echo -e \"Initialize cpu ";

	 if (length != 0) {
	 //			ss << "CPU:" << cpu << " " << disasm_tbuf;
	 //			ss << "LEN: %d\tBYTES: " << length;

	 for (n = 0; n < length; n++) {
	 //				ss << (int) i->opcode[n];
	 }
	 if (i->is_branch) {
	 //				ss << "\tBRANCH ";

	 if (i->is_taken) {
	 //					ss << "TARGET " FMT_ADDRX " (TAKEN)", i->target_linear;
	 } else {
	 //					ss << "(NOT TAKEN)";
	 }
	 }
	 }
	 //		ss << "\n";
	 for (n = 0; n < i->num_data_accesses; n++) {
	 //			ss << "MEM ACCESS[" << n << "]: " FMT_ADDRX " (linear) 0x" << i->data_access[n].laddr << " (physical) " << i->data_access[n].paddr << " SIZE: "
	 //					<< i->data_access[n].size << "\n";
	 }
	 //		ss << "\n";

	 //		ss << "\" | nc localhost 1980";
	 //fprintf(stderr, "%s", ss.str().c_str());

	 //fprintf(stderr, "%d\n", ipcount++);

	 //fprintf(stderr, "%s\n", ss.str().c_str());
	 //system(ss.str().c_str());

	 if (ipcount % 100000 == 0) {
	 const char *buffer = "peter\n";//ss.str().c_str();
	 write(sockfd, buffer, strlen(buffer));
	 }
	 ipcount++;
	 }

	 instruction[cpu].valid = 0;
	 instruction[cpu].num_data_accesses = 0;
	 instruction[cpu].is_branch = 0;*/
}

static void branch_taken(unsigned cpu, bx_address new_eip) {

}

void bx_instr_cnear_branch_taken(unsigned cpu, bx_address new_eip) {

}

void bx_instr_cnear_branch_not_taken(unsigned cpu) {

}

void bx_instr_ucnear_branch(unsigned cpu, unsigned what, bx_address new_eip) {

}

void bx_instr_far_branch(unsigned cpu, unsigned what, Bit16u new_cs, bx_address new_eip) {

}

void bx_instr_opcode(unsigned cpu, const Bit8u *opcode, unsigned len, bx_bool is32, bx_bool is64) {
	/*if (!active)
	 return;

	 for (unsigned i = 0; i < len; i++) {
	 instruction[cpu].opcode[i] = opcode[i];
	 }

	 instruction[cpu].is32 = is32;
	 instruction[cpu].is64 = is64;
	 instruction[cpu].opcode_size = len;
	 instruction[cpu].valid = 1;*/
}

void bx_instr_interrupt(unsigned cpu, unsigned vector) {

}

void bx_instr_exception(unsigned cpu, unsigned vector, unsigned error_code) {

}

void bx_instr_hwinterrupt(unsigned cpu, unsigned vector, Bit16u cs, bx_address eip) {

}

void bx_instr_mem_data(unsigned cpu, unsigned seg, bx_address offset, unsigned len, unsigned rw) {
	//	const char *buffer = "bx_instr_mem_data\n";
	//	write(sockfd, buffer, strlen(buffer));
}

void bx_instr_mem_data_access(unsigned cpu, unsigned seg, bx_address offset, unsigned len, unsigned rw) {
	stringstream ss;
	//	ss << "bx_instr_mem_data_access ";
	ss << "1:";
	ss << seg;
	ss << "," << len << "," << rw << endl;
	//	if (readCount % 10 == 0) {
	//		const char *buffer = ss.str().c_str();
	//		write(sockfd, buffer, strlen(buffer));
	//		ss.clear();
	//	}
	const char *buffer = ss.str().c_str();
	//	write(sockfd, buffer, strlen(buffer));

	//	while (*shm != 'S')
	//		;

	strcpy(shm + 1, buffer);

	//	for (c = 'a'; c <= 'z'; c++) {
	//		*temp++ = c;
	//		//		printf("c=%c\n", c);
	//	}


	*shm = 'P';

//	printf("shm2=%x\n", &shm);
//	fflush(stdout);

	while (*shm != 'S') {
		//		printf("%c\n", *shm);
		usleep(1);

	}

	//	readCount++;
}
