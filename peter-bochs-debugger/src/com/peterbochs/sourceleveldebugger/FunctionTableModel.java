package com.peterbochs.sourceleveldebugger;

import java.util.TreeSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.peterbochs.MyLanguage;


public class FunctionTableModel extends AbstractTableModel {
	private String[] columnNames = { MyLanguage.getString("File"), MyLanguage.getString("Offset"), MyLanguage.getString("Size"), MyLanguage.getString("Name"),
			MyLanguage.getString("Code"), };

	public TreeSet<Function> functions;

	private String searchPattern;

	public FunctionTableModel() {
		functions = (TreeSet<Function>) MapStructure.functions.clone();
	}

	public Object getValueAt(int row, int column) {
		try {
			if (MapStructure.functions != null) {
				switch (column) {
				case 0:
					return ((Function) functions.toArray()[row]).file.getAbsolutePath();
				case 1:
					return "0x" + Long.toHexString(((Function) functions.toArray()[row]).fileOffset);
				case 2:
					return ((Function) functions.toArray()[row]).size;
				case 3:
					return ((Function) functions.toArray()[row]).name;
				case 4:
					return ((Function) functions.toArray()[row]).code;
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

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		if (searchPattern == null) {
			return functions.size();
		} else {
			int rowCount = 0;
			for (int x = 0; x < functions.size(); x++) {
				Function f = (Function) functions.toArray()[x];
				if (f.file.getName().toLowerCase().contains(searchPattern.toLowerCase()) || String.valueOf(f.fileOffset).toLowerCase().contains(searchPattern.toLowerCase())
						|| String.valueOf(f.size).toLowerCase().contains(searchPattern.toLowerCase()) || f.name.toLowerCase().contains(searchPattern.toLowerCase())
						|| (f.code != null && f.code.toLowerCase().contains(searchPattern.toLowerCase()))) {
					rowCount++;
				}
			}
			return rowCount;
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

	public void setSearchPattern(String searchPattern) {
		if (searchPattern != null && !searchPattern.equals("")) {
			functions.clear();

			for (int x = 0; x < MapStructure.functions.size(); x++) {
				Function f = (Function) MapStructure.functions.toArray()[x];
				if (f.file.getName().toLowerCase().contains(searchPattern.toLowerCase()) || String.valueOf(f.fileOffset).toLowerCase().contains(searchPattern.toLowerCase())
						|| String.valueOf(f.size).toLowerCase().contains(searchPattern.toLowerCase()) || f.name.toLowerCase().contains(searchPattern.toLowerCase())
						|| (f.code != null && f.code.toLowerCase().contains(searchPattern.toLowerCase()))) {

					Function function = new Function();
					function.file = f.file;
					function.fileOffset = f.fileOffset;
					function.size = f.size;
					function.name = f.name;
					function.code = f.code;
					functions.add(function);
				}
			}
		} else {
			functions = (TreeSet<Function>) MapStructure.functions.clone();
		}
		fireTableDataChanged();
	}

	public void reload() {
		setSearchPattern(searchPattern);
	}
}
