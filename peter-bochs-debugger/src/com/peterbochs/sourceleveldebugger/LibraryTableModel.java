package com.peterbochs.sourceleveldebugger;

import java.io.File;
import java.util.HashSet;

import javax.swing.table.AbstractTableModel;


import com.peterbochs.MyLanguage;
import com.peterswing.CommonLib;

public class LibraryTableModel extends AbstractTableModel {
	private String[] columnNames = { MyLanguage.getString("Library") + "/" + MyLanguage.getString("Object"), MyLanguage.getString("Size"), MyLanguage.getString("Path") };
	public HashSet<File> data = new HashSet<File>();

	public LibraryTableModel() {
	}

	public Object getValueAt(int row, int column) {
		try {
			if (data != null) {
				Object files[] = (Object[]) data.toArray();
				File file = (File) files[row];
				switch (column) {
				case 0:
					return file.getName();
				case 2:
					return file.getAbsolutePath();
				case 1:
					return CommonLib.convertFilesize(file.length());
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
		return data.size();
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
}
