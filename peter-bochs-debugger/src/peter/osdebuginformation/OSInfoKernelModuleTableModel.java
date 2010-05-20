package peter.osdebuginformation;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class OSInfoKernelModuleTableModel extends AbstractTableModel {
	String columnNames[] = { "No.", "Address" };
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

	public void addRow(String key, String field) {
		Vector<String> v = new Vector<String>();
		v.add(key);
		v.add(field);
		data.add(v);
		this.fireTableDataChanged();
	}
}
