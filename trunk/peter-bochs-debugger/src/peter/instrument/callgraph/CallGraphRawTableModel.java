package peter.instrument.callgraph;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class CallGraphRawTableModel extends AbstractTableModel {
	String columnNames[] = { "Segment begin", "Segment end", "From address", "To Address" };
	Vector<JmpData> data = new Vector<JmpData>();

	public boolean needToTellBochsToUpdateZone = false;

	public void addRow(JmpData data) {
		this.data.add(data);
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		try {
			return data.size();
		} catch (Exception ex) {
			return 0;
		}
	}

	public void setValueAt(Object aValue, int row, int column) {
	}

	public Object getValueAt(int row, int column) {
		if (column == 0) {
			return "0x" + Long.toHexString(data.get(row).segmentStart);
		} else if (column == 1) {
			return "0x" + Long.toHexString(data.get(row).segmentEnd);
		} else if (column == 2) {
			return "0x" + Long.toHexString(data.get(row).from);
		} else if (column == 3) {
			return "0x" + Long.toHexString(data.get(row).to);
		} else {
			return "";
		}
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public void add(JmpData data) {
		this.data.add(data);
		this.fireTableDataChanged();
	}

	public void removeAll() {
		data.removeAllElements();
		this.fireTableDataChanged();
	}
}
