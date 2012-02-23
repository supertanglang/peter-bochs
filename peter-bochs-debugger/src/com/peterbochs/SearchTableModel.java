package com.peterbochs;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class SearchTableModel extends AbstractTableModel {
	private String[] columnNames = { MyLanguage.getString("Physical_address"), MyLanguage.getString("Bytes"), MyLanguage.getString("String") };
	private int radix = 16;

	Vector<Long> address = new Vector<Long>();
	Vector<String> bytesForDisplay = new Vector<String>();
	Vector<String> bytesStr = new Vector<String>();
	Vector<byte[]> bytes = new Vector<byte[]>();

	public int getRadix() {
		return radix;
	}

	public void setRadix(int radix) {
		this.radix = radix;
	}

	public void addRow(long address, byte bytes[]) {
		for (int x = 0; x < this.address.size(); x++) {
			if (this.address.get(x) == address && Arrays.equals(this.bytes.get(x), bytes)) {
				return;
			}
		}
		this.address.add(address);
		this.bytes.add(bytes);
		String str = "";
		for (int x = 0; x < bytes.length; x++) {
			str += String.format("0x%02x", bytes[x]) + " ";
		}
		this.bytesForDisplay.add(str);
		this.bytesStr.add(new String(bytes));
		this.fireTableDataChanged();
	}

	public Object getValueAt(int row, int column) {
		try {
			if (column == 0) {
				if (radix == 16) {
					return "0x" + Long.toHexString(address.get(row));
				} else if (radix == 10) {
					return address;
				} else if (radix == 8) {
					return Long.toOctalString(address.get(row));
				} else
					return Long.toBinaryString(address.get(row));
			} else if (column == 1) {
				return bytesForDisplay.get(row);
			} else {
				return bytesStr.get(row);
			}
		} catch (Exception ex) {
			return "Error";
		}
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return address.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	public Class getColumnClass(int columnIndex) {
		return String.class;
	}

	public void removeAll() {
		address.removeAllElements();
		bytesForDisplay.removeAllElements();
		bytesStr.removeAllElements();
		bytes.removeAllElements();
		this.fireTableDataChanged();
	}

}
