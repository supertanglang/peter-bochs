package com.peterbochs.osdebuginformation;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class OSInfoLibraryTableModel extends AbstractTableModel {
	String columnNames[] = { "Name", "Status" };
	Vector<Vector<String>> data = new Vector<Vector<String>>();

	public Vector<Vector<String>> getData() {
		return data;
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.get(rowIndex).get(columnIndex);
	}

	public void addRow(String name, String status) {
		Vector<String> v = new Vector<String>();
		v.add(name);
		v.add(status);
		data.add(v);
		this.fireTableDataChanged();
	}
}
