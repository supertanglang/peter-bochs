package com.peterbochs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.petersoft.CommonLib;

public class JInstructionTableModel extends AbstractTableModel {
	private String[] columnNames = { "", MyLanguage.getString("Address"), MyLanguage.getString("Instruction"), MyLanguage.getString("Bytes") };
	private HashMap<Long, Boolean> breakpoint = new HashMap<Long, Boolean>();
	private Vector<String[]> data = new Vector<String[]>();
	private long eip;

	public Vector<String[]> getData() {
		return data;
	}

	public Object getValueAt(int row, int column) {
		try {
			if (data.get(row)[1].contains("cCode")) {
				return data.get(row)[column];
			} else {
				long address = CommonLib.string2decimal("0x" + data.get(row)[1].split(":")[0]);
				if (column == 0) {
					if (address == eip) {
						return "here";
					} else if (breakpoint.containsKey(address)) {
						if (breakpoint.get(address)) {
							return "O";
						} else {
							return "X";
						}
					} else {
						return "";
					}
				} else if (column == 1) {
					return "0x" + data.get(row)[column];
				} else {
					return data.get(row)[column];
				}
			}
		} catch (Exception ex) {
			return "";
		}
	}

	public void clearData() {
		data.clear();
	}

	public void addRow(String[] array) {
		data.add(array);
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

	public void updateBreakpoint(long eip) {
		this.eip = eip;
		try {
			// commandReceiver.setCommandNoOfLine(-1);
			Application.commandReceiver.clearBuffer();
			Application.sendCommand("info break");
			Thread.currentThread().sleep(100);
			String result = Application.commandReceiver.getCommandResultUntilEnd();
			String[] lines = result.split("\n");

			breakpoint.clear();
			for (int x = 1; x < lines.length; x++) {
				if (lines[x].contains("breakpoint")) {
					Vector<String> strs = new Vector<String>(Arrays.asList(lines[x].trim().split(" \\s")));
					strs.add("0"); // hit count
					if (strs.size() > 1) {
						strs.remove(1);

						if (strs.get(1).contains("y")) {
							breakpoint.put(CommonLib.string2decimal(strs.get(2)), true);
						} else {
							breakpoint.put(CommonLib.string2decimal(strs.get(2)), false);
						}
					}
				}
			}
			this.fireTableDataChanged();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.size();
	}

	public String getMemoryAddress(int row) {
		return getValueAt(row, 1).toString().split(":")[0];
	}
}
