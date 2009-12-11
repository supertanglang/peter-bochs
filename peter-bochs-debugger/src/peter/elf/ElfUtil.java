package peter.elf;

import java.io.File;
import java.util.Arrays;

import peter.CommonLib;

public class ElfUtil {

	public static void main(String args[]) {
		System.out.println(getDebugLine(new File(args[0])));
	}

	public static String getDebugLine(File file) {
		String filenameReturnStr = "";
		String returnStr = "";
		int bytesbb[] = { 0x80, 0x70, 0x60, 0x50 };

		int DW_TAG_padding = 0x00;
		int DW_TAG_array_type = 0x01;
		int DW_TAG_class_type = 0x02;
		int DW_TAG_entry_point = 0x03;
		int DW_TAG_enumeration_type = 0x04;
		int DW_TAG_formal_parameter = 0x05;
		int DW_TAG_imported_declaration = 0x08;
		int DW_TAG_label = 0x0a;
		int DW_TAG_lexical_block = 0x0b;
		int DW_TAG_member = 0x0d;
		int DW_TAG_pointer_type = 0x0f;
		int DW_TAG_reference_type = 0x10;
		int DW_TAG_compile_unit = 0x11;
		int DW_TAG_string_type = 0x12;
		int DW_TAG_structure_type = 0x13;
		int DW_TAG_subroutine_type = 0x15;
		int DW_TAG_typedef = 0x16;
		int DW_TAG_union_type = 0x17;
		int DW_TAG_unspecified_parameters = 0x18;
		int DW_TAG_variant = 0x19;
		int DW_TAG_common_block = 0x1a;
		int DW_TAG_common_inclusion = 0x1b;
		int DW_TAG_inheritance = 0x1c;
		int DW_TAG_inlined_subroutine = 0x1d;
		int DW_TAG_module = 0x1e;
		int DW_TAG_ptr_to_member_type = 0x1f;
		int DW_TAG_set_type = 0x20;
		int DW_TAG_subrange_type = 0x21;
		int DW_TAG_with_stmt = 0x22;
		int DW_TAG_access_declaration = 0x23;
		int DW_TAG_base_type = 0x24;
		int DW_TAG_catch_block = 0x25;
		int DW_TAG_const_type = 0x26;
		int DW_TAG_constant = 0x27;
		int DW_TAG_enumerator = 0x28;
		int DW_TAG_file_type = 0x29;
		int DW_TAG_friend = 0x2a;
		int DW_TAG_namelist = 0x2b;
		int DW_TAG_namelist_item = 0x2c;
		int DW_TAG_packed_type = 0x2d;
		int DW_TAG_subprogram = 0x2e;
		int DW_TAG_template_type_param = 0x2f;
		int DW_TAG_template_value_param = 0x30;
		int DW_TAG_thrown_type = 0x31;
		int DW_TAG_try_block = 0x32;
		int DW_TAG_variant_part = 0x33;
		int DW_TAG_variable = 0x34;
		int DW_TAG_volatile_type = 0x35;
		// DWARF3.
		int DW_TAG_dwarf_procedure = 0x36;
		int DW_TAG_restrict_type = 0x37;
		int DW_TAG_interface_type = 0x38;
		int DW_TAG_namespace = 0x39;
		int DW_TAG_imported_module = 0x3a;
		int DW_TAG_unspecified_type = 0x3b;
		int DW_TAG_partial_unit = 0x3c;
		int DW_TAG_imported_unit = 0x3d;
		int DW_TAG_condition = 0x3f;
		int DW_TAG_shared_type = 0x40;

		// SGI/MIPS extensions.
		int DW_TAG_MIPS_loop = 0x4081;

		// HP extensions.
		// See: ftp://ftp.hp.com/pub/lang/tools/WDB/wdb-4.0.tar.gz.
		int DW_TAG_HP_array_descriptor = 0x4090;

		// GNU extensions.
		int DW_TAG_format_label = 0x4101; // For FORTRAN 77 and Fortran 90.
		int DW_TAG_function_template = 0x4102; // For C++.
		int DW_TAG_class_template = 0x4103; // For C++.
		int DW_TAG_GNU_BINCL = 0x4104;
		int DW_TAG_GNU_EINCL = 0x4105;
		// Extensions for UPC. See: http://upc.gwu.edu/~upc.
		int DW_TAG_upc_shared_type = 0x8765;
		int DW_TAG_upc_strict_type = 0x8766;
		int DW_TAG_upc_relaxed_type = 0x8767;

		// PGI (STMicroelectronics) extensions. No documentation available.
		int DW_TAG_PGI_kanji_type = 0xA000;
		int DW_TAG_PGI_interface_block = 0xA020;

		int DW_LNS_extended_op = 0;
		int DW_LNS_copy = 1;
		int DW_LNS_advance_pc = 2;
		int DW_LNS_advance_line = 3;
		int DW_LNS_set_file = 4;
		int DW_LNS_set_column = 5;
		int DW_LNS_negate_stmt = 6;
		int DW_LNS_set_basic_block = 7;
		int DW_LNS_const_add_pc = 8;
		int DW_LNS_fixed_advance_pc = 9;
		// DWARF 3.
		int DW_LNS_set_prologue_end = 10;
		int DW_LNS_set_epilogue_begin = 11;
		int DW_LNS_set_isa = 12;

		char DW_LNE_end_sequence = 1;
		char DW_LNE_set_address = 2;
		char DW_LNE_define_file = 3;
		// HP extensions.
		char DW_LNE_HP_negate_is_UV_update = 0x11;
		char DW_LNE_HP_push_context = 0x12;
		char DW_LNE_HP_pop_context = 0x13;
		char DW_LNE_HP_set_file_line_column = 0x14;
		char DW_LNE_HP_set_routine_name = 0x15;
		char DW_LNE_HP_set_sequence = 0x16;
		char DW_LNE_HP_negate_post_semantics = 0x17;
		char DW_LNE_HP_negate_function_exit = 0x18;
		char DW_LNE_HP_negate_front_end_logical = 0x19;
		char DW_LNE_HP_define_proc = 0x20;

		int bytes[] = CommonLib.readFileUnsigned(file, 0, (int) file.length());
		long e_shoff = CommonLib.getInt(bytes, 32);
		long e_shnum = CommonLib.getInt(bytes, 48) & 0xffff;
		long e_shstrndx = CommonLib.getInt(bytes, 50) & 0xffff;

		// System.out.println(e_shoff);
		// System.out.println(e_shnum);
		// System.out.println(e_shstrndx);

		/*
		 * typedef struct { Elf32_Word sh_name; // Section name (string tbl
		 * index) Elf32_Word sh_type; // Section type Elf32_Word sh_flags; //
		 * Section flags Elf32_Addr sh_addr; // Section virtual addr at
		 * execution Elf32_Off sh_offset; // Section file offset Elf32_Word
		 * sh_size; // Section size in bytes Elf32_Word sh_link; // Link to
		 * another section Elf32_Word sh_info; // Additional section information
		 * Elf32_Word sh_addralign; // Section alignment Elf32_Word sh_entsize;
		 * // Entry size if section holds table } Elf32_Shdr;
		 */

		int strtabOffset = CommonLib.getInt(bytes, (int) (e_shoff + (e_shstrndx * 40) + (4 * 4)));

		long pointer = e_shoff;
		long debugSectionOffset = 0;
		long debugSectionSize = 0;
		for (int x = 0; x < e_shnum; x++) {
			int sh_name = CommonLib.getInt(bytes, (int) pointer);
			int t[] = Arrays.copyOfRange(bytes, strtabOffset + sh_name, strtabOffset + sh_name + 40);
			String sectionName = new String(t, 0, t.length);
			sectionName = sectionName.substring(0, sectionName.indexOf(0));
			pointer += 4;
			int sh_type = CommonLib.getInt(bytes, (int) pointer);
			pointer += 4;
			int sh_flags = CommonLib.getInt(bytes, (int) pointer);
			pointer += 4;
			int sh_addr = CommonLib.getInt(bytes, (int) pointer);
			pointer += 4;
			int sh_offset = CommonLib.getInt(bytes, (int) pointer);
			pointer += 4;
			int sh_size = CommonLib.getInt(bytes, (int) pointer);
			pointer += 4;
			int sh_link = CommonLib.getInt(bytes, (int) pointer);
			pointer += 4;
			int sh_info = CommonLib.getInt(bytes, (int) pointer);
			pointer += 4;
			int sh_addralign = CommonLib.getInt(bytes, (int) pointer);
			pointer += 4;
			int sh_entsize = CommonLib.getInt(bytes, (int) pointer);
			pointer += 4;

			if (sectionName.equals(".debug_line")) {
				debugSectionOffset = sh_offset;
				debugSectionSize = sh_size;
			}
		}

		if (debugSectionOffset != 0 && debugSectionSize != 0) {
			long data = debugSectionOffset;
			long originalData = data;
			// System.out.println("start data=" + data);
			// System.out.println("debugSectionSize=" + debugSectionSize);
			long end = debugSectionOffset + debugSectionSize;
			// System.out.println("end=" + end);
			// byte debugSection[]=Arrays.copyOfRange(bytes, data, end);

			while (data < end) {
				int prev_line = 0;

				// System.out.println("---------------------");
				long hdrptr = data;
				long li_length = CommonLib.getInt(bytes, (int) hdrptr);
				// System.out.println("li_length=" + li_length);
				hdrptr += 4;
				int offset_size;
				int initial_length_size;
				if (li_length == CommonLib.string2decimal("0xffffffff")) {
					li_length = CommonLib.getLong(bytes, (int) hdrptr);
					hdrptr += 8;
					offset_size = 8;
					initial_length_size = 4;
				} else {
					offset_size = 4;
					initial_length_size = 4;
				}
				// System.out.println("init_length_size=" +
				// initial_length_size);

				if (li_length + initial_length_size > debugSectionSize) {
					System.out.println("The line info appears to be corrupt - the section is too small\n");
					return "error";
				}

				/* Get this CU's Line Number Block version number. */
				short li_version = CommonLib.getShort(bytes, (int) hdrptr);
				// System.out.println("li_version=" + li_version);
				hdrptr += 2;
				if (li_version != 2 && li_version != 3) {
					System.out.println("Only DWARF version 2 and 3 line info is currently supported.\n");
					return "error";
				}
				// System.out.println("display_debug_lines_decoded while 1\n");

				long li_prologue_length;

				if (offset_size == 4) {
					li_prologue_length = CommonLib.getInt(bytes, (int) hdrptr);
				} else {
					li_prologue_length = CommonLib.getLong(bytes, (int) hdrptr);
				}
				// System.out.println("li_prologue_length=" +
				// li_prologue_length);

				hdrptr += offset_size;
				int li_min_insn_length = bytes[(int) hdrptr];
				// System.out.println("li_min_insn_length=" +
				// li_min_insn_length);

				hdrptr++;
				int li_default_is_stmt = bytes[(int) hdrptr];
				// System.out.println("li_default_is_stmt=" +
				// li_default_is_stmt);

				hdrptr++;
				int li_line_base = bytes[(int) hdrptr];
				// System.out.println("li_line_base=" + li_line_base);

				hdrptr++;
				int li_line_range = bytes[(int) hdrptr];
				// System.out.println("li_line_range=" + li_line_range);

				hdrptr++;
				int li_opcode_base = bytes[(int) hdrptr];
				// System.out.println("li_opcode_base=" + li_opcode_base);

				hdrptr++;

				/* Sign extend the line base field. */
				li_line_base <<= 24;
				li_line_base >>= 24;

				/* Find the end of this CU's Line Number Information Block. */
				long end_of_sequence = data + li_length + initial_length_size;

				// System.out.println("data=" + data + ", end_of_sequence=" +
				// end_of_sequence);

				reset_state_machine(li_default_is_stmt);

				/* Save a pointer to the contents of the Opcodes table. */
				long standard_opcodes = hdrptr;

				/* Traverse the Directory table just to count entries. */
				// System.out.println("data=" + data + ", hdrptr=" + hdrptr +
				// ", standard_opcodes=" + standard_opcodes +
				// ", li_opcode_base=" + li_opcode_base);
				data = standard_opcodes + li_opcode_base - 1;
				// System.out.println("new data=" + data);
				if (bytes[(int) data] != 0) {
					int n_directories = 0;
					long ptr_directory_table = data;
					int i;

					while (bytes[(int) data] != 0) {
						String tempS = new String(bytes, (int) data, 100);
						tempS = tempS.substring(0, tempS.indexOf(0));
						data += tempS.length() + 1;
						n_directories++;
						// System.out.println("n_directories=" + n_directories);
					}

					/*
					 * Go through the directory table again to save the
					 * directories.
					 */
					String directory_table[] = new String[n_directories];// =
					// (unsigned
					// char
					// **)xmalloc
					// (n_directories
					// *
					// sizeof
					// (unsigned
					// char
					// *));

					i = 0;
					while (ptr_directory_table != 0) {
						String tempS = new String(bytes, (int) ptr_directory_table, 100);
						tempS = tempS.substring(0, tempS.indexOf(0));

						directory_table[i] = tempS;
						ptr_directory_table += tempS.length() + 1;
						i++;
					}
				} else {
					// System.out.println("*data==0\n");
				}
				/* Skip the NUL at the end of the table. */
				data++;

				/* Traverse the File Name table just to count the entries. */
				if (bytes[(int) data] != 0) {
					// System.out.println("===0, data=" + (data -
					// originalData));

					// System.out.println("data!=0, data=" + bytes[(int) data] +
					// ", data=" + (int) data);
					int n_files = 0;

					String tempS = new String(bytes, (int) data, 100);
					tempS = tempS.substring(0, tempS.indexOf(0));
					String ptr_file_name_table = tempS;
					long ptr_file_name_table_pointer = data;
					int i;

					while (bytes[(int) data] != 0) {
						int bytes_read[] = new int[1];

						/*
						 * Skip Name, directory index, last modification time
						 * and length of file.
						 */
						tempS = new String(bytes, (int) data, 100);
						tempS = tempS.substring(0, tempS.indexOf(0));
						data += tempS.length() + 1;

						// System.out.println(">>>>>> data=" + (data -
						// originalData));

						int data2[] = Arrays.copyOfRange(bytes, (int) data, bytes.length);
						read_leb128(data2, bytes_read, 0);
						// System.out.println("bytes_read=" + bytes_read[0]);
						data += bytes_read[0];
						data2 = Arrays.copyOfRange(bytes, (int) data, bytes.length);
						read_leb128(data2, bytes_read, 0);
						data += bytes_read[0];
						data2 = Arrays.copyOfRange(bytes, (int) data, bytes.length);
						read_leb128(data2, bytes_read, 0);
						data += bytes_read[0];

						n_files++;

						// System.out.println("--->>>>>> data=" + (data -
						// originalData));
					}

					// System.out.println("after skip name+directory index, data="
					// + (data - originalData));

					/* Go through the file table again to save the strings. */
					File_Entry file_table[] = new File_Entry[n_files];// =
					// (File_Entry
					// *)
					// xmalloc
					// (n_files
					// *
					// sizeof
					// (File_Entry));
					// System.out.println("ptr_file_name_table=" + (int)
					// ptr_file_name_table_pointer);
					i = 0;
					while (bytes[(int) ptr_file_name_table_pointer] != 0) {
						file_table[i] = new File_Entry();
						int bytes_read[] = new int[1];

						tempS = new String(bytes, (int) ptr_file_name_table_pointer, 100);
						tempS = tempS.substring(0, tempS.indexOf(0));
						ptr_file_name_table = tempS;
						// System.out.println("ptr_file_name_table=" +
						// ptr_file_name_table);
						file_table[i].name = ptr_file_name_table;
						ptr_file_name_table_pointer += ptr_file_name_table.length() + 1;

						/* We are not interested in directory, time or size. */
						int data2[] = Arrays.copyOfRange(bytes, (int) ptr_file_name_table_pointer, bytes.length);
						file_table[i].directory_index = (int) read_leb128(data2, bytes_read, 0);
						ptr_file_name_table_pointer += bytes_read[0];

						data2 = Arrays.copyOfRange(bytes, (int) ptr_file_name_table_pointer, bytes.length);
						file_table[i].modification_date = (int) read_leb128(data2, bytes_read, 0);
						ptr_file_name_table_pointer += bytes_read[0];

						data2 = Arrays.copyOfRange(bytes, (int) ptr_file_name_table_pointer, bytes.length);
						file_table[i].length = (int) read_leb128(data2, bytes_read, 0);
						ptr_file_name_table += bytes_read[0];
						i++;
					}
					i = 0;
					/* Print the Compilation Unit's name and a header. */
					filenameReturnStr += file_table[0].name + ",";

					/* Skip the NUL at the end of the table. */
					data++;
					// System.out.println("start to loop the Line Number Program, data="
					// + (data - originalData));

					/* This loop iterates through the Dwarf Line Number Program. */
					while (data < end_of_sequence) {
						// System.out.println("\ndata=" + data);
						int op_code;
						int adv;
						long uladv;
						int bytes_read[] = new int[1];
						int is_special_opcode = 0;

						op_code = bytes[(int) data++];
						// System.out.println("op_code=" + op_code);
						prev_line = state_machine_regs.line;

						if (op_code >= li_opcode_base) {
							// System.out.println("one");
							// System.out.println("!!!!!!!!! data=" + (data -
							// originalData));
							op_code -= li_opcode_base;
							uladv = (op_code / li_line_range) * li_min_insn_length;
							state_machine_regs.address += uladv;

							adv = (op_code % li_line_range) + li_line_base;
							state_machine_regs.line += adv;
							is_special_opcode = 1;
						} else {
							// System.out.println("two");
							// System.out.println("!!!!!!!!! data=" + (data -
							// originalData));
							if (op_code == DW_LNS_extended_op) {
								int ext_op_code_len;
								// int bytes_read;
								char ext_op_code;
								long op_code_data = data;
								// System.out.println("dataaaaaaaaaa=" + data);
								int data2[] = Arrays.copyOfRange(bytes, (int) op_code_data, bytes.length);
								ext_op_code_len = (int) read_leb128(data2, bytes_read, 0);
								op_code_data += bytes_read[0];
								data2 = Arrays.copyOfRange(bytes, (int) op_code_data, bytes.length);

								if (ext_op_code_len == 0) {
									// System.out.println("badly formed extended line op encountered!\n");
									break;
								}
								ext_op_code_len += bytes_read[0];
								ext_op_code = (char) bytes[(int) op_code_data++];

								if (ext_op_code == DW_LNE_end_sequence) {
									reset_state_machine(li_default_is_stmt);

								} else if (ext_op_code == DW_LNE_set_address) {
									// System.out.println("op_code_data=" +
									// (op_code_data - originalData) + ".." +
									// bytes[(int) (op_code_data)]);
									state_machine_regs.address = bytes[(int) (op_code_data)] + (bytes[(int) (op_code_data + 1)] << 8) + (bytes[(int) (op_code_data + 2)] << 16)
											+ (bytes[(int) (op_code_data + 3)] << 24);
									// byte_get (op_code_data, ext_op_code_len -
									// bytes_read - 1);
									// System.out.println(Long.toHexString(state_machine_regs.address));
								} else if (ext_op_code == DW_LNE_define_file) {
									int dir_index = 0;

									++state_machine_regs.last_file_entry;

									String sectionName = new String(bytes, (int) op_code_data, 100);
									sectionName = sectionName.substring(0, sectionName.indexOf(0));

									op_code_data += sectionName.length() + 1;
									data2 = Arrays.copyOfRange(bytes, (int) op_code_data, bytes.length);
									dir_index = (int) read_leb128(data2, bytes_read, 0);
									op_code_data += bytes_read[0];
									data2 = Arrays.copyOfRange(bytes, (int) op_code_data, bytes.length);
									read_leb128(data2, bytes_read, 0);
									op_code_data += bytes_read[0];
									data2 = Arrays.copyOfRange(bytes, (int) op_code_data, bytes.length);
									read_leb128(data2, bytes_read, 0);
									// System.out.println("hello0 %s:"+
									// directory_table[dir_index]);

								} else {
									System.out.println("UNKNOWN: length " + (ext_op_code_len - bytes_read[0]));

								}
								data += ext_op_code_len;

							} else if (op_code == DW_LNS_copy) {

							} else

							if (op_code == DW_LNS_advance_pc) {
								int data2[] = Arrays.copyOfRange(bytes, (int) data, bytes.length);
								uladv = read_leb128(data2, bytes_read, 0);
								uladv *= li_min_insn_length;
								data += bytes_read[0];
								state_machine_regs.address += uladv;

							} else if (op_code == DW_LNS_advance_line) {
								int data2[] = Arrays.copyOfRange(bytes, (int) data, bytes.length);
								adv = (int) read_leb128(data2, bytes_read, 1);
								data += bytes_read[0];
								state_machine_regs.line += adv;

							} else if (op_code == DW_LNS_set_file) {
								int data2[] = Arrays.copyOfRange(bytes, (int) data, bytes.length);
								adv = (int) read_leb128(data2, bytes_read, 0);
								data += bytes_read[0];
								state_machine_regs.file = adv;
								if (file_table[state_machine_regs.file - 1].directory_index == 0) {
									/*
									 * If directory index is 0, that means
									 * current directory.
									 */
									// printf (_("peter9 \n./%s:[++]\n"),
									// file_table[state_machine_regs.file -
									// 1].name);
								} else {
									/* The directory index starts counting at 1. */
									// printf (_("peter10 \n%s/%s:\n"),
									// directory_table[file_table[state_machine_regs.file
									// - 1].directory_index - 1],
									// file_table[state_machine_regs.file -
									// 1].name);
								}

							} else if (op_code == DW_LNS_set_column) {
								int data2[] = Arrays.copyOfRange(bytes, (int) data, bytes.length);
								uladv = read_leb128(data2, bytes_read, 0);
								data += bytes_read[0];
								state_machine_regs.column = (int) uladv;

							} else if (op_code == DW_LNS_negate_stmt) {
								adv = state_machine_regs.is_stmt;
								if (adv != 0) {
									adv = 0;
								} else {
									adv = 1;
								}
								state_machine_regs.is_stmt = adv;

							} else if (op_code == DW_LNS_set_basic_block) {
								state_machine_regs.basic_block = 1;

							} else if (op_code == DW_LNS_const_add_pc) {
								uladv = (((255 - li_opcode_base) / li_line_range) * li_min_insn_length);
								state_machine_regs.address += uladv;

							} else if (op_code == DW_LNS_fixed_advance_pc) {
								uladv = bytes[(int) data] + bytes[(int) (data + 1)] << 8;
								data += 2;
								state_machine_regs.address += uladv;

							} else if (op_code == DW_LNS_set_prologue_end) {

							} else if (op_code == DW_LNS_set_epilogue_begin) {

							} else if (op_code == DW_LNS_set_isa) {
								int data2[] = Arrays.copyOfRange(bytes, (int) data, bytes.length);
								uladv = read_leb128(data2, bytes_read, 0);
								data += bytes_read[0];
								// printf (_("  Set ISA to %lu\n"), uladv);

							} else {
								System.out.println("  Unknown opcode %d with operands: " + op_code);
								for (i = bytes[(int) (standard_opcodes + op_code - 1)]; i > 0; --i) {
									int data2[] = Arrays.copyOfRange(bytes, (int) data, bytes.length);
									System.out.println(read_leb128(data2, bytes_read, 0));
									data += bytes_read[0];
								}

							}
							// System.out.println("END !!!!!!!!! data=" + (data
							// - originalData));
						}
						/*
						 * Only Special opcodes, DW_LNS_copy and
						 * DW_LNE_end_sequence adds a row to the DWARF
						 * address/line matrix.
						 */
						// System.out.println("is_special_opcode=" +
						// is_special_opcode);
						if ((is_special_opcode != 0) || (op_code == DW_LNE_end_sequence) || (op_code == DW_LNS_copy)) {
							int MAX_FILENAME_LENGTH = 35;
							// char *fileName = (char
							// *)file_table[state_machine_regs.file -
							// 1].name;
							String fileName = file_table[state_machine_regs.file - 1].name;
							// char *newFileName = NULL;
							String newFileName;
							int fileNameLength = fileName.length();

							if ((fileNameLength > MAX_FILENAME_LENGTH)) {
								// newFileName = (char *) xmalloc
								// (MAX_FILENAME_LENGTH + 1);
								/* Truncate file name */
								// strncpy (newFileName,
								// fileName + fileNameLength -
								// MAX_FILENAME_LENGTH,
								// MAX_FILENAME_LENGTH + 1);

								newFileName = fileName.substring(fileNameLength - MAX_FILENAME_LENGTH, MAX_FILENAME_LENGTH + 1);
							} else {
								// newFileName = (char *) xmalloc
								// (fileNameLength + 1);
								// strncpy (newFileName, fileName,
								// fileNameLength + 1);

								newFileName = fileName;
							}

							if ((fileNameLength <= MAX_FILENAME_LENGTH)) {
								returnStr += newFileName + " = " + state_machine_regs.line + " = " + Long.toHexString(state_machine_regs.address) + "\n";
							} else {
								returnStr += newFileName + " = " + state_machine_regs.line + " = " + Long.toHexString(state_machine_regs.address) + "\n";
							}

							if (op_code == DW_LNE_end_sequence) {
								// System.out.println("\n");
							}
							// free (newFileName);
						}
					}

				}
			}

			// free (file_table);
			// file_table = NULL;
			// free (directory_table);
			// directory_table = NULL;
			// putchar ('\n');

		}
		return filenameReturnStr + "\n" + returnStr;
	}

	static State_Machine_Registers state_machine_regs = new State_Machine_Registers();

	static void reset_state_machine(int is_stmt) {
		state_machine_regs.address = 0;
		state_machine_regs.file = 1;
		state_machine_regs.line = 1;
		state_machine_regs.column = 0;
		state_machine_regs.is_stmt = is_stmt;
		state_machine_regs.basic_block = 0;
		state_machine_regs.end_sequence = 0;
		state_machine_regs.last_file_entry = 0;
	}

	static long read_leb128(int data[], int length_return[], int sign) {
		long result = 0;
		int num_read = 0;
		int shift = 0;
		int b;

		// System.out.print(data[0] + "," + data[1] + "," + data[2] + "," +
		// data[3]);
		// System.out.println();

		int x = 0;
		do {
			b = data[x++];
			num_read++;

			result |= ((long) (b & 0x7f)) << shift;

			shift += 7;

		} while ((b & 0x80) != 0);

		length_return[0] = num_read;
		// System.out.println("length_return=" + length_return);

		if (sign != 0 && shift < 8 * 4 && (b & 0x40) != 0) {
			result |= -1L << shift;
		}

		return result;
	}
}

class File_Entry {
	String name = "";
	int directory_index;
	int modification_date;
	int length;
};

class State_Machine_Registers {
	public long address;
	public int file;
	public int line;
	public int column;
	public int is_stmt;
	public int basic_block;
	public int end_sequence;
	/*
	 * This variable hold the number of the last entry seen in the File Table.
	 */
	public int last_file_entry;
};
