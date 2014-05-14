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
	public boolean showAsmLevel = true;

	public Vector<String[]> getData() {
		return data;
	}

	public Object getValueAt(int row, int column) {
		try {
			if (showAsmLevel) {
				if (column == 0) {
					if (data.get(row)[1].startsWith("cCode")) {
						BigInteger address = CommonLib.string2BigInteger(data.get(row)[1].split(":")[1]);
						return getColumn0(address);
					} else {
						BigInteger address = CommonLib.string2BigInteger(data.get(row)[1]);
						return getColumn0(address);
					}
				} else {
					return data.get(row)[column];
				}
			} else {
				int z = 0;
				int temp = -1;
				for (int x = 0; x < data.size(); x++) {
					String str[] = data.get(x);
					if (str[1].startsWith("cCode")) {
						temp++;
					}
					if (temp == row) {
						z = x;
						break;
					}
				}
				System.out.println("row=" + row + ", z=" + z + ", code=" + data.get(z)[0] + "," + data.get(z)[1]);
				if (column == 0) {
					BigInteger address = CommonLib.string2BigInteger(data.get(z)[1].split(":")[1]);
					return getColumn0(address);
				} else {
					return data.get(z)[column];
				}
			}
		} catch (Exception ex) {
			return "";
		}
	}

	public String getColumn0(BigInteger address) {
		if (address.equals(eip) && breakpoint.containsKey(address) && breakpoint.get(address)) {
			return "hereO";
		} else if (address.equals(eip)) {
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
	}

	public void clearData() {
		data.clear();
		this.fireTableDataChanged();
	}

	public void addRow(String[] array) {
		// check exist
		boolean exist = false;
		for (int x = 0; x < data.size(); x++) {
			String arr[] = data.get(x);
			if (arr[1].equals(array[1])) {
				exist = true;
				break;
			}
		}
		if (!exist) {
			data.add(array);
			this.fireTableDataChanged();
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
							breakpoint.put(CommonLib.string2BigInteger(strs.get(2)), true);
						} else {
							breakpoint.put(CommonLib.string2BigInteger(strs.get(2)), false);
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
		if (showAsmLevel) {
			return data.size();
		} else {
			int total = 0;
			for (int x = 0; x < data.size(); x++) {
				String str[] = data.get(x);
				if (str[1].startsWith("cCode")) {
					total++;
				}
			}
			//			System.out.println("total=" + total + ", data.size()=" + data.size());
			return total;
		}
	}

	public String getMemoryAddress(int row) {
		String str = getValueAt(row, 1).toString();
		if (str.startsWith("cCode")) {
			return str.split(":")[1];
		} else {
			return str.split(":")[0];
		}
	}

	public void removeNonOrderInstruction() {
		if (data.size() == 0) {
			return;
		}
		try {
			long lastAddress = CommonLib.string2long(data.get(data.size() - 1)[1]);
			for (int x = data.size() - 2; x >= 0; x--) {
				long address;
				if (data.get(x)[1].contains("cCode")) {
					address = CommonLib.string2long(data.get(x)[1].split(":")[1]);
				} else {
					address = CommonLib.string2long(data.get(x)[1]);
				}
				if (address > lastAddress) {
					data.remove(x);
				} else {
					lastAddress = address;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int findEIPRowNo(BigInteger realEIP) {
		for (int x = 0; x < data.size(); x++) {
			String str = data.get(x)[1];
			BigInteger b;
			if (str.startsWith("cCode")) {
				long l = CommonLib.string2long(str.split(":")[1]);
				b = BigInteger.valueOf(l);
			} else {
				long l = CommonLib.string2long(str);
				b = BigInteger.valueOf(l);
			}
			if (b.equals(realEIP)) {
				return x;
			}
		}
		return 0;
	}
}
