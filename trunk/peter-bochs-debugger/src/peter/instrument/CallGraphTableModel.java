package peter.instrument;

import java.text.DecimalFormat;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class CallGraphTableModel extends DefaultTableModel {
	String columnNames[] = { "Segment begin", "Segment end" };
	Vector<Long> segmentBegin = new Vector<Long>();
	Vector<Long> segmentEnd = new Vector<Long>();

	public boolean needToTellBochsToUpdateZone = false;

	public void addRow(long segmentBegin, long segmentEnd) {
		this.segmentBegin.add(segmentBegin);
		this.segmentEnd.add(segmentEnd);
		this.fireTableDataChanged();
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		try {
			return segmentBegin.size();
		} catch (Exception ex) {
			return 0;
		}
	}

	public void setValueAt(Object aValue, int row, int column) {
		if (column == 0) {
			segmentBegin.set(row, (Long) aValue);
		} else if (column == 1) {
			segmentEnd.set(row, (Long) aValue);
		}
		this.fireTableDataChanged();
	}

	public Object getValueAt(int row, int column) {
		if (column == 0) {
			return "0x" + Long.toHexString(segmentBegin.get(row));
		} else if (column == 1) {
			return "0x" + Long.toHexString(segmentEnd.get(row));
		} else {
			return "";
		}
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public void removeAll() {
		segmentBegin.removeAllElements();
		segmentEnd.removeAllElements();
		this.fireTableDataChanged();
	}
}
