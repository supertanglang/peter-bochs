package peter;

import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;

public class HistoryTableModel extends DefaultTableModel {
	String view = "reg";
	String pattern;
	String regColumn[] = { "No.", "Time", "Ptime", "instruction", "eax", "ebx", "ecx", "edx", "esi", "edi", "ebp", "esp", "cs", "eip", "ds", "es", "fs", "gs", "ss", "cr0", "cr2",
			"cr3", "cr4" };

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
			switch (column) {
			case 0:
				return "No.";
			case 1:
				return "st0";
			case 2:
				return "st1";
			case 3:
				return "st2";
			case 4:
				return "st3";
			case 5:
				return "st4";
			case 6:
				return "st5";
			case 7:
				return "st6";
			case 8:
				return "st7";
			case 9:
				return "status";
			case 10:
				return "control";
			case 11:
				return "tag";
			case 12:
				return "operand";
			default:
				return "";
			}
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
			return 13;
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
					return AllRegisters.instructions.get(row);
				case 4:
					return Long.toHexString(AllRegisters.eax.get(row));
				case 5:
					return Long.toHexString(AllRegisters.ebx.get(row));
				case 6:
					return Long.toHexString(AllRegisters.ecx.get(row));
				case 7:
					return Long.toHexString(AllRegisters.edx.get(row));
				case 8:
					return Long.toHexString(AllRegisters.esi.get(row));
				case 9:
					return Long.toHexString(AllRegisters.edi.get(row));
				case 10:
					return Long.toHexString(AllRegisters.ebp.get(row));
				case 11:
					return Long.toHexString(AllRegisters.esp.get(row));
				case 12:
					return Long.toHexString(AllRegisters.cs.get(row));
				case 13:
					return Long.toHexString(AllRegisters.eip.get(row));
				case 14:
					return Long.toHexString(AllRegisters.ds.get(row));
				case 15:
					return Long.toHexString(AllRegisters.es.get(row));
				case 16:
					return Long.toHexString(AllRegisters.fs.get(row));
				case 17:
					return Long.toHexString(AllRegisters.gs.get(row));
				case 18:
					return Long.toHexString(AllRegisters.ss.get(row));
				case 19:
					return Long.toHexString(AllRegisters.cr0.get(row));
				case 20:
					return Long.toHexString(AllRegisters.cr2.get(row));
				case 21:
					return Long.toHexString(AllRegisters.cr3.get(row));
				case 22:
					return Long.toHexString(AllRegisters.cr4.get(row));
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
					return Long.toHexString(AllRegisters.gdtr.get(row));
				case 3:
					return Long.toHexString(AllRegisters.ldtr.get(row));
				case 4:
					return Long.toHexString(AllRegisters.idtr.get(row));
				case 5:
					return Long.toHexString(AllRegisters.tr.get(row));
				case 6:
					return AllRegisters.eflags.get(row);
				case 7:
					return Long.toHexString(AllRegisters.stack.get(row).get(0));
				case 8:
					return Long.toHexString(AllRegisters.stack.get(row).get(1));
				case 9:
					return Long.toHexString(AllRegisters.stack.get(row).get(2));
				case 10:
					return Long.toHexString(AllRegisters.stack.get(row).get(3));
				case 11:
					return Long.toHexString(AllRegisters.stack.get(row).get(4));
				case 12:
					return Long.toHexString(AllRegisters.stack.get(row).get(5));
				case 13:
					return Long.toHexString(AllRegisters.stack.get(row).get(6));
				case 14:
					return Long.toHexString(AllRegisters.stack.get(row).get(7));
				case 15:
					return Long.toHexString(AllRegisters.stack.get(row).get(8));
				case 16:
					return Long.toHexString(AllRegisters.stack.get(row).get(9));
				default:
					return Long.toHexString(AllRegisters.stack.get(row).get(10));
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
