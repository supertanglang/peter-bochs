package com.peterbochs;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.peterswing.CommonLib;

public class InstructionTableModel extends AbstractTableModel {
	private String[] columnNames = { "", MyLanguage.getString("Address"), MyLanguage.getString("Instruction"), MyLanguage.getString("Bytes") };
	private HashMap<BigInteger, Boolean> breakpoint = new HashMap<BigInteger, Boolean>();
	private Vector<String[]> data = new Vector<String[]>();
	private BigInteger eip;
	public boolean showSourceLevel = true;

	public Vector<String[]> getData() {
		return data;
	}

	public Object getValueAt(int row, int column) {
		try {
			int z = 0;
			if (showSourceLevel) {
				z = row;
			} else {
				int temp = -1;
				for (int x = 0; x < data.size(); x++) {
					String str[] = data.get(x);
					if (!str[1].startsWith("cCode")) {
						temp++;
					}
					if (temp == row) {
						z = x;
						break;
					}
				}
			}
			if (data.get(z)[1].contains("cCode")) {
				return data.get(z)[column];
			} else {
				BigInteger address = CommonLib.string2decimal("0x" + data.get(z)[1].split(":")[0]);
				if (column == 0) {
					System.out.println(address.toString(16) + "====" + eip.toString(16));
					if (address.equals(eip)) {
						System.out.println("here ar");

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
					return "0x" + data.get(z)[column];
				} else {
					return data.get(z)[column];
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
		// check exist
		boolean exist = false;
		for (int x = 0; x < data.size(); x++) {
			String arr[] = data.get(x);
			if (arr[1].equals(array[1])) {
				exist = true;
				arr[1] = array[1];
				break;
			}
		}
		if (!exist) {
			data.add(array);
		}
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

	public void updateBreakpoint(BigInteger eip) {
		this.eip = eip;
		try {
			// commandReceiver.setCommandNoOfLine(-1);
			PeterBochsDebugger.commandReceiver.clearBuffer();
			PeterBochsDebugger.sendCommand("info break");
			Thread.currentThread().sleep(100);
			String result = PeterBochsDebugger.commandReceiver.getCommandResultUntilEnd();
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
		if (showSourceLevel) {
			return data.size();
		} else {
			int total = 0;
			for (int x = 0; x < data.size(); x++) {
				String str[] = data.get(x);
				if (!str[1].startsWith("cCode")) {
					total++;
				}
			}
			return total;
		}
	}

	public String getMemoryAddress(int row) {
		return getValueAt(row, 1).toString().split(":")[0];
	}

	public void removeNonOrderInstruction() {
		if (data.size() == 0) {
			return;
		}
		long lastAddress = Long.parseLong(data.get(data.size() - 1)[1], 16);
		for (int x = data.size() - 2; x >= 0; x--) {
			try {
				if (Long.parseLong(data.get(x)[1], 16) > lastAddress) {
					data.remove(x);
				} else {
					lastAddress = Long.parseLong(data.get(x)[1], 16);
				}
			} catch (Exception ex) {
			}
		}
	}

	public int findEIPRowNo(BigInteger realEIP) {
		for (int x = 0; x < data.size(); x++) {
			try {
				if (CommonLib.string2decimal("0x" + data.get(x)[1]) == realEIP) {
					return x;
				}
			} catch (Exception ex) {
			}
		}
		return 0;
	}
}
