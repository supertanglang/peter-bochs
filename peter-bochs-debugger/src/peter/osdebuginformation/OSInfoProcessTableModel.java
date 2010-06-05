package peter.osdebuginformation;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class OSInfoProcessTableModel extends AbstractTableModel {
	String columnNames[] = { "PID", "name", "tssNo", "backlink", "status", "cmdline" };
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

	public void addRow(String PID, String name, String tssNo, String backlink, String status, String cmdline) {
		Vector<String> v = new Vector<String>();
		v.add(PID);
		v.add(name);
		v.add(tssNo);
		v.add(backlink);
		v.add(status);
		v.add(cmdline);
		data.add(v);
		this.fireTableDataChanged();
	}
}
