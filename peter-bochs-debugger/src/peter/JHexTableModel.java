package peter;

import javax.swing.table.AbstractTableModel;

public class JHexTableModel extends AbstractTableModel {
	private String[] columnNames = { Application.language.getString("Offset"), "0", "1", "2", "3", "4", "5", "6", "7", Application.language.getString("String") };
	private String qw[] = new String[(getColumnCount() - 2) * getRowCount()];
	private int radix = 16;
	private long currentAddress;

	public long getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(long currentAddress) {
		this.currentAddress = currentAddress;
	}

	public int getRadix() {
		return radix;
	}

	public void setRadix(int radix) {
		this.radix = radix;
	}

	public Object getValueAt(int row, int column) {
		try {
			if (column == 0) {
				return "0x" + Long.toHexString(currentAddress + (row * (getColumnCount() - 2)));
			} else if (column == getColumnCount() - 1) {
				char c0 = (char) Integer.parseInt(qw[row * (getColumnCount() - 2)], 16);
				char c1 = (char) Integer.parseInt(qw[1 + row * (getColumnCount() - 2)], 16);
				char c2 = (char) Integer.parseInt(qw[2 + row * (getColumnCount() - 2)], 16);
				char c3 = (char) Integer.parseInt(qw[3 + row * (getColumnCount() - 2)], 16);
				char c4 = (char) Integer.parseInt(qw[4 + row * (getColumnCount() - 2)], 16);
				char c5 = (char) Integer.parseInt(qw[5 + row * (getColumnCount() - 2)], 16);
				char c6 = (char) Integer.parseInt(qw[6 + row * (getColumnCount() - 2)], 16);
				char c7 = (char) Integer.parseInt(qw[7 + row * (getColumnCount() - 2)], 16);
				return String.valueOf(c0) + String.valueOf(c1) + String.valueOf(c2) + String.valueOf(c3) + String.valueOf(c4) + String.valueOf(c5) + String.valueOf(c6) + String.valueOf(c7);
			} else {
				long l = Long.parseLong(qw[(column - 1) + row * (getColumnCount() - 2)], 16);
				if (radix == 16) {
					return Long.toHexString(l);
				} else if (radix == 10) {
					return l;
				} else if (radix == 8) {
					return Long.toOctalString(l);
				} else if (radix == 2) {
					return Long.toBinaryString(l);
				} else {
					return "";
				}
			}
		} catch (Exception ex) {
			return "";
		}
	}

	public void set(String qw[]) {
		this.qw = qw;
	}

	public void setValueAt(Object newVal, int row, int column) {
		System.out.println(newVal);
		super.setValueAt(newVal, row, column);
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return 25;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public boolean isCellEditable(int row, int col) {
		if (col == 0 || col == columnNames.length - 1) {
			return false;
		} else {
			return true;
		}
	}

	public Class getColumnClass(int columnIndex) {
		return String.class;
	}
}
