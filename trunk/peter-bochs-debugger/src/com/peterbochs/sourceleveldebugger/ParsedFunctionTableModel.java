package com.peterbochs.sourceleveldebugger;

import javax.swing.table.AbstractTableModel;

import com.peterbochs.MyLanguage;


public class ParsedFunctionTableModel extends AbstractTableModel {
	private String[] columnNames = { MyLanguage.getString("Function") };

	public ParsedFunctionTableModel() {
	}

	public Object getValueAt(int row, int column) {
		try {
			switch (column) {
			case 0:
				return MapStructure.parsedFunctions.get(row);
			default:
				return "";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return MapStructure.parsedFunctions.size();
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
