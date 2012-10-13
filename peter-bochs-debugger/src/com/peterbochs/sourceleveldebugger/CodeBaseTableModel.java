package com.peterbochs.sourceleveldebugger;

import java.io.File;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import org.apache.commons.io.FileUtils;

import com.peterdwarf.dwarf.Dwarf;
import com.peterdwarf.dwarf.DwarfDebugLineHeader;
import com.peterdwarf.dwarf.DwarfLine;
import com.peterdwarf.gui.PeterDwarfPanel;

public class CodeBaseTableModel extends AbstractTableModel {
	private String[] columnNames = { "PC", "Line No.", "Code", "ELF" };
	PeterDwarfPanel peterDwarfPanel;
	Vector<Data> data;

	class Data {
		File file;
		BigInteger PC;
		String[] codeLines;
		int lineNo;
	}

	public CodeBaseTableModel(PeterDwarfPanel peterDwarfPanel) {
		this.peterDwarfPanel = peterDwarfPanel;
	}

	public Object getValueAt(int row, int column) {
		if (data != null) {
			switch (column) {
			case 0:
				return "0x" + data.get(row).PC.toString(16);
			case 1:
				return data.get(row).lineNo;
			case 2:
				if (data.get(row).codeLines == null) {
					return "";
				} else {
					return data.get(row).codeLines[data.get(row).codeLines.length - 1];
				}
			case 3:
				return data.get(row).file;
			default:
				return "";
			}
		} else {
			return "";
		}
	}

	public void refresh() {
		data = new Vector<Data>();
		for (Dwarf dwarf : peterDwarfPanel.dwarfs) {
			for (DwarfDebugLineHeader header : dwarf.headers) {
				loop1: for (int x = 0; x < header.lines.size(); x++) {
					try {
						DwarfLine line = header.lines.get(x);
						File file = header.filenames.get((int) line.file_num).file;
						if (!file.exists()) {
							break loop1;
						}
						List<String> sourceLines = FileUtils.readLines(file);

						int endLineNo = 0;
						if (x == header.lines.size() - 1 || line.file_num != header.lines.get(x + 1).file_num) {
							endLineNo = sourceLines.size() - line.line_num;
						} else {
							endLineNo = header.lines.get(x + 1).line_num - 1;
						}
						if (endLineNo - line.line_num < 0) {
							endLineNo = line.line_num;
						}
						String s[] = new String[endLineNo - line.line_num + 1];
						for (int z = line.line_num - 1, index = 0; z < endLineNo && z < sourceLines.size(); z++, index++) {
							if (z >= sourceLines.size()) {
								System.out.println("ss");
							}
							String cCode = sourceLines.get(z);
							s[index] = cCode;
						}

						Data d = new Data();
						d.file = file;
						d.PC = line.address;
						d.codeLines = s;
						d.lineNo = line.line_num;
						data.add(d);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		this.fireTableDataChanged();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data == null ? 0 : data.size();
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

	public void setFilter(String text) {

		fireTableDataChanged();
	}
}
