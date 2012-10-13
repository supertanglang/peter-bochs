package com.peterbochs;

import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;

public class HistoryTableModel extends DefaultTableModel {
	String view = "reg";
	String pattern;
	String regColumn[] = { "No.", "Time", "Ptime", "cs", "eip", "instruction", "c/c++", "eax", "ebx", "ecx", "edx", "esi", "edi", "ebp", "esp", "ds", "es", "fs", "gs", "ss", "cr0",
			"cr2", "cr3", "cr4" };
	String fpuColumn[] = { "No.", "st0", "st1", "st2", "st3", "st4", "st5", "st6", "st7", "status", "control", "tag", "operand", "fip", "fcs", "fdp", "fds" };

	public void setView(String view) {
		this.view = view;
		this.fireTableStructureChanged();
	}

	public String getColumnName(int column) {
		if (view.equals("reg")) {
			return regColumn[column];
		} else if (view.equals("tbl")) {
			switch (column) {
			case 0:
				return "No.";
			case 1:
				return "Time";
			case 2:
				return "gdtr";
			case 3:
				return "ldtr";
			case 4:
				return "idtr";
			case 5:
				return "tr";
			case 6:
				return "eflags";
			case 7:
				return "sp+0";
			case 8:
				return "sp+4";
			case 9:
				return "sp+8";
			case 10:
				return "sp+12";
			case 11:
				return "sp+16";
			case 12:
				return "sp+20";
			case 13:
				return "sp+24";
			case 14:
				return "sp+28";
			case 15:
				return "sp+32";
			case 16:
				return "sp+36";
			default:
				return "";
			}
		} else if (view.equals("fpu")) {
			return fpuColumn[column];
		} else if (view.equals("mmx")) {
			switch (column) {
			case 0:
				return "No.";
			case 1:
				return "mm0";
			case 2:
				return "mm1";
			case 3:
				return "mm2";
			case 4:
				return "mm3";
			case 5:
				return "mm4";
			case 6:
				return "mm5";
			case 7:
				return "mm6";
			case 8:
				return "mm7";
			default:
				return "";
			}
		} else {
			return "";
		}
	}

	public int getColumnCount() {
		if (view.equals("reg")) {
			return regColumn.length;
		} else if (view.equals("tbl")) {
			return 17;
		} else if (view.equals("fpu")) {
			return fpuColumn.length;
		} else if (view.equals("mmx")) {
			return 9;
		} else {
			return 0;
		}
	}

	public int getRowCount() {
		return AllRegisters.time.size();
	}

	public Object getValueAt(int row, int column) {
		try {
			if (view.equals("reg")) {
				switch (column) {
				case 0:
					return row + 1;
				case 1:
					return new SimpleDateFormat("hh:mm:ss S").format(AllRegisters.time.get(row));
				case 2:
					return AllRegisters.ptime.get(row);
				case 3:
					return AllRegisters.cs.get(row).toString(16);
				case 4:
					return AllRegisters.eip.get(row).toString(16);
				case 5:
					return AllRegisters.instructions.get(row);
				case 6:
					return AllRegisters.cCode.get(row);
				case 7:
					return AllRegisters.eax.get(row).toString(16);
				case 8:
					return AllRegisters.ebx.get(row).toString(16);
				case 9:
					return AllRegisters.ecx.get(row).toString(16);
				case 10:
					return AllRegisters.edx.get(row).toString(16);
				case 11:
					return AllRegisters.esi.get(row).toString(16);
				case 12:
					return AllRegisters.edi.get(row).toString(16);
				case 13:
					return AllRegisters.ebp.get(row).toString(16);
				case 14:
					return AllRegisters.esp.get(row).toString(16);
				case 15:
					return AllRegisters.ds.get(row).toString(16);
				case 16:
					return AllRegisters.es.get(row).toString(16);
				case 17:
					return AllRegisters.fs.get(row).toString(16);
				case 18:
					return AllRegisters.gs.get(row).toString(16);
				case 19:
					return AllRegisters.ss.get(row).toString(16);
				case 20:
					return AllRegisters.cr0.get(row).toString(16);
				case 21:
					return AllRegisters.cr2.get(row).toString(16);
				case 22:
					return AllRegisters.cr3.get(row).toString(16);
				case 23:
					return AllRegisters.cr4.get(row).toString(16);
				default:
					return "";
				}
			} else if (view.equals("tbl")) {
				switch (column) {
				case 0:
					return row + 1;
				case 1:
					return new SimpleDateFormat("hh:mm:ss S").format(AllRegisters.time.get(row));
				case 2:
					return AllRegisters.gdtr.get(row).toString(16);
				case 3:
					return AllRegisters.ldtr.get(row).toString(16);
				case 4:
					return AllRegisters.idtr.get(row).toString(16);
				case 5:
					return AllRegisters.tr.get(row).toString(16);
				case 6:
					return AllRegisters.eflags.get(row);
				case 7:
					return AllRegisters.stack.get(row).get(0).toString(16);
				case 8:
					return AllRegisters.stack.get(row).get(1).toString(16);
				case 9:
					return AllRegisters.stack.get(row).get(2).toString(16);
				case 10:
					return AllRegisters.stack.get(row).get(3).toString(16);
				case 11:
					return AllRegisters.stack.get(row).get(4).toString(16);
				case 12:
					return AllRegisters.stack.get(row).get(5).toString(16);
				case 13:
					return AllRegisters.stack.get(row).get(6).toString(16);
				case 14:
					return AllRegisters.stack.get(row).get(7).toString(16);
				case 15:
					return AllRegisters.stack.get(row).get(8).toString(16);
				case 16:
					return AllRegisters.stack.get(row).get(9).toString(16);
				default:
					return AllRegisters.stack.get(row).get(10).toString(16);
				}
			} else if (view.equals("fpu")) {
				switch (column) {
				case 0:
					return row + 1;
				case 1:
					return AllRegisters.st0.get(row);
				case 2:
					return AllRegisters.st1.get(row);
				case 3:
					return AllRegisters.st2.get(row);
				case 4:
					return AllRegisters.st3.get(row);
				case 5:
					return AllRegisters.st4.get(row);
				case 6:
					return AllRegisters.st5.get(row);
				case 7:
					return AllRegisters.st6.get(row);
				case 8:
					return AllRegisters.st7.get(row);
				case 9:
					return AllRegisters.fpu_status.get(row);
				case 10:
					return AllRegisters.fpu_control.get(row);
				case 11:
					return AllRegisters.fpu_tag.get(row);
				case 12:
					return AllRegisters.fpu_operand.get(row);
				case 13:
					return AllRegisters.fip.get(row);
				case 14:
					return AllRegisters.fcs.get(row);
				case 15:
					return AllRegisters.fdp.get(row);
				case 16:
					return AllRegisters.fds.get(row);
				default:
					return "";
				}
			} else if (view.equals("mmx")) {
				switch (column) {
				case 0:
					return row + 1;
				case 1:
					return AllRegisters.mm0.get(row);
				case 2:
					return AllRegisters.mm1.get(row);
				case 3:
					return AllRegisters.mm2.get(row);
				case 4:
					return AllRegisters.mm3.get(row);
				case 5:
					return AllRegisters.mm4.get(row);
				case 6:
					return AllRegisters.mm5.get(row);
				case 7:
					return AllRegisters.mm6.get(row);
				case 8:
					return AllRegisters.mm7.get(row);
				default:
					return "";
				}
			} else {
				return "";
			}
		} catch (Exception ex) {
			return "";
		}
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public Class getColumnClass(int columnIndex) {
		return String.class;
	}

	public void clear() {
		AllRegisters.clear();
		this.fireTableDataChanged();
	}

	public void setSearchPattern(String pattern) {
		this.pattern = pattern;
		this.fireTableDataChanged();
	}
}
