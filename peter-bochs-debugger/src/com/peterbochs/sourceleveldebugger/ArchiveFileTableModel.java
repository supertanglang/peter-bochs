package com.peterbochs.sourceleveldebugger;

import java.io.File;
import java.util.Arrays;

import javax.swing.table.AbstractTableModel;

import com.peterbochs.MyLanguage;


public class ArchiveFileTableModel extends AbstractTableModel {
	private String[] columnNames = { MyLanguage.getString("File") };

	public ArchiveFileTableModel() {
	}

	public Object getValueAt(int row, int column) {
		if (MapStructure.archiveAndObjectFiles != null) {
			switch (column) {
			case 0:
				Object objects[] = MapStructure.archiveAndObjectFiles.toArray();
				Arrays.sort(objects);
				File file = (File) objects[row];
				return file.getAbsolutePath();
			default:
				return "";
			}
		} else {
			return "";
		}
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return MapStructure.archiveAndObjectFiles.size();
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
