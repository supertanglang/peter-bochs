package com.peterbochs;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class IDTTableModel extends AbstractTableModel {
	private String[] columnNames = { "No", "Type" };
	private Vector<Vector<String>> vector = new Vector<Vector<String>>();

	public IDTTableModel() {
	}

	public Object getValueAt(int row, int column) {
		try {
			return vector.get(row).get(column);
		} catch (Exception ex) {
			return "";
		}
	}

	public void addValue(Vector<String> v) {
		vector.add(v);
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (rowIndex < getRowCount()) {
			vector.get(rowIndex).set(columnIndex, aValue.toString());
		}
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return vector.size();
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

	public void clear() {
		vector.clear();
	}

}
