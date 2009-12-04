package peter;

import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;

public class HistoryTableModel extends DefaultTableModel {
	String view = "reg";

	public void setView(String view) {
		this.view = view;
		this.fireTableStructureChanged();
	}

	public String getColumnName(int column) {
		if (view.equals("reg")) {
			switch (column) {
			case 0:
				return "Time";
			case 1:
				return "eax";
			case 2:
				return "ebx";
			case 3:
				return "ecx";
			case 4:
				return "edx";
			case 5:
				return "esi";
			case 6:
				return "edi";
			case 7:
				return "ebp";
			case 8:
				return "esp";
			case 9:
				return "cs";
			case 10:
				return "eip";
			case 11:
				return "ds";
			case 12:
				return "es";
			case 13:
				return "fs";
			default:
				return "";
			}
		} else if (view.equals("tbl")) {
			switch (column) {
			case 0:
				return "Time";
			case 1:
				return "gdtr";
			case 2:
				return "ldtr";
			case 3:
				return "idtr";
			case 4:
				return "tr";
			case 5:
				return "eflags";
			case 6:
				return "sp+0";
			case 7:
				return "sp+4";
			case 8:
				return "sp+8";
			case 9:
				return "sp+12";
			case 10:
				return "sp+16";
			case 11:
				return "sp+20";
			case 12:
				return "sp+24";
			case 13:
				return "sp+28";
			case 14:
				return "sp+32";
			case 15:
				return "sp+36";
			default:
				return "";
			}
		} else {
			return "";
		}
	}

	public int getColumnCount() {
		if (view.equals("reg")) {
			return 14;
		} else if (view.equals("tbl")) {
			return 16;

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
					return new SimpleDateFormat("hh:mm:ss").format(AllRegisters.time.get(row));
				case 1:
					return Long.toHexString(AllRegisters.eax.get(row));
				case 2:
					return Long.toHexString(AllRegisters.ebx.get(row));
				case 3:
					return Long.toHexString(AllRegisters.ecx.get(row));
				case 4:
					return Long.toHexString(AllRegisters.edx.get(row));
				case 5:
					return Long.toHexString(AllRegisters.esi.get(row));
				case 6:
					return Long.toHexString(AllRegisters.edi.get(row));
				case 7:
					return Long.toHexString(AllRegisters.ebp.get(row));
				case 8:
					return Long.toHexString(AllRegisters.esp.get(row));
				case 9:
					return Long.toHexString(AllRegisters.cs.get(row));
				case 10:
					return Long.toHexString(AllRegisters.eip.get(row));
				case 11:
					return Long.toHexString(AllRegisters.ds.get(row));
				case 12:
					return Long.toHexString(AllRegisters.es.get(row));
				case 13:
					return Long.toHexString(AllRegisters.fs.get(row));
				default:
					return "";
				}
			} else if (view.equals("tbl")) {
				switch (column) {
				case 0:
					return new SimpleDateFormat("hh:mm:ss").format(AllRegisters.time.get(row));
				case 1:
					return Long.toHexString(AllRegisters.gdtr.get(row));
				case 2:
					return Long.toHexString(AllRegisters.ldtr.get(row));
				case 3:
					return Long.toHexString(AllRegisters.idtr.get(row));
				case 4:
					return Long.toHexString(AllRegisters.tr.get(row));
				case 5:
					return AllRegisters.eflags.get(row);
				case 6:
					return Long.toHexString(AllRegisters.stack.get(row).get(0));
				case 7:
					return Long.toHexString(AllRegisters.stack.get(row).get(1));
				case 8:
					return Long.toHexString(AllRegisters.stack.get(row).get(2));
				case 9:
					return Long.toHexString(AllRegisters.stack.get(row).get(3));
				case 10:
					return Long.toHexString(AllRegisters.stack.get(row).get(4));
				case 11:
					return Long.toHexString(AllRegisters.stack.get(row).get(5));
				case 12:
					return Long.toHexString(AllRegisters.stack.get(row).get(6));
				case 13:
					return Long.toHexString(AllRegisters.stack.get(row).get(7));
				case 14:
					return Long.toHexString(AllRegisters.stack.get(row).get(8));
				case 15:
					return Long.toHexString(AllRegisters.stack.get(row).get(9));
				default:
					return Long.toHexString(AllRegisters.stack.get(row).get(10));
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
}
