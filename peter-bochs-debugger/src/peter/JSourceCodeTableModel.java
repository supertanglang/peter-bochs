package peter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.io.FileUtils;

public class JSourceCodeTableModel extends AbstractTableModel {
	private String currentFile;
	private String[] columnNames = { "", Application.language.getString("Line"), Application.language.getString("Address"), Application.language.getString("Source"),
			Application.language.getString("Bytes") };
	private HashMap<String, List<String>> sourceCodes = new HashMap<String, List<String>>();
	private HashMap<String, HashMap<Integer, Long>> debugLineInfo = new HashMap<String, HashMap<Integer, Long>>();
	private HashMap<Long, Boolean> breakpoint = new HashMap<Long, Boolean>();
	private boolean isShowBytes = false;

	public HashMap<String, HashMap<Integer, Long>> getDebugLineInfo() {
		return debugLineInfo;
	}

	public HashMap<String, List<String>> getSourceCodes() {
		return sourceCodes;
	}

	public Object getValueAt(int row, int column) {
		try {
			if (column == 0) {
				if (breakpoint.containsKey(debugLineInfo.get(currentFile).get(new Integer(row)))) {
					if (breakpoint.get(debugLineInfo.get(currentFile).get(new Integer(row)))) {
						return "O";
					} else {
						return "X";
					}
				} else {
					return "";
				}
			} else if (column == 1) {
				return row + 1;
			} else if (column == 2) {
				return "0x" + Long.toHexString(debugLineInfo.get(currentFile).get(new Integer(row)));
			} else {
				return sourceCodes.get(currentFile).get(row);
			}
		} catch (Exception ex) {
			return "";
		}
	}

	public String getCurrentFile() {
		return currentFile;
	}

	public void setCurrentFile(String currentFile) {
		this.currentFile = currentFile;
		this.fireTableDataChanged();
	}

	public int getColumnCount() {
		if (isShowBytes) {
			return columnNames.length;
		} else {
			return columnNames.length - 1;
		}
	}

	public int getRowCount() {
		try {
			return sourceCodes.get(currentFile).size();
		} catch (Exception ex) {
			return 0;
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

	public void setDebugLine(String lines) {
		String linesArr[] = lines.split("\n");
		debugLineInfo.clear();
		for (int x = 1; x < linesArr.length; x++) {
			String arr[] = linesArr[x].split("===");
			String filename = arr[0].trim();
			String line = arr[1].trim();
			Long address = CommonLib.string2decimal("0x" + arr[2].trim());
			if (debugLineInfo.get(filename) == null) {
				HashMap<Integer, Long> h = new HashMap<Integer, Long>();
				h.put(Integer.parseInt(line), address);
				debugLineInfo.put(filename, h);
			} else {
				HashMap<Integer, Long> h = debugLineInfo.get(filename);
				h.put(Integer.parseInt(line), address);
				debugLineInfo.put(filename, h);
			}
		}
	}

	public void updateBreakpoint() {
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

	public void showBytes(boolean selected) {
		isShowBytes = selected;
		this.fireTableStructureChanged();
	}

	public void setELFFile(File elfFile) {
		// read .text bytes
		try {
			byte bytes[] = FileUtils.readFileToByteArray(elfFile);

			byte e_ident[] = Arrays.copyOfRange(bytes, 0, 16);
			int e_type = CommonLib.getShort(bytes[16], bytes[17]);
			
			int e_phoff = CommonLib.getInt(bytes, 28);
			int e_shoff = CommonLib.getInt(bytes, 32);
			System.out.println(e_shoff);

		} catch (IOException e) {
			e.printStackTrace();
		}
		// end read .text bytes
	}
}
