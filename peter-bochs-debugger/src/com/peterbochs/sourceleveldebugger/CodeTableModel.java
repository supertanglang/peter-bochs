package com.peterbochs.sourceleveldebugger;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.peterbochs.MyLanguage;


public class CodeTableModel extends AbstractTableModel {
	private String[] columnNames = { MyLanguage.getString("Function"), MyLanguage.getString("File"), MyLanguage.getString("C/C++"), MyLanguage.getString("ASM"),
			MyLanguage.getString("file offset"), MyLanguage.getString("bytecode") };
	Vector<String> functionNames = new Vector<String>();
	Vector<DisassembledCode> codes = new Vector<DisassembledCode>();

	public CodeTableModel() {
	}

	public Object getValueAt(int row, int column) {
		switch (column) {
		case 0:
			return functionNames.get(row);
		case 1:
			return codes.get(row).file.getAbsolutePath();
		case 2:
			return codes.get(row).cCode;
		case 3:
			return codes.get(row).asmCode;
		case 4:
			return codes.get(row).offset;
		case 5:
			String bytes = "";
			for (int b : codes.get(row).bytes) {
				bytes += Integer.toHexString(b) + ",";
			}
			return bytes;
		default:
			return "";
		}
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return codes.size();
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

	public void fireTableDataChanged() {
		functionNames.clear();
		codes.clear();
		for (String key : MapStructure.disassembledCodes.keySet()) {
			Vector<DisassembledCode> v = MapStructure.disassembledCodes.get(key);
			codes.addAll(v);
			for (int x = 0; x < v.size(); x++) {
				functionNames.add(key);
			}
		}
		super.fireTableDataChanged();
	}
}
