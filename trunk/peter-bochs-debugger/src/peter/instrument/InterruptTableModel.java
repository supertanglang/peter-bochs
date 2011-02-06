package peter.instrument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

import javax.swing.table.DefaultTableModel;

public class InterruptTableModel extends DefaultTableModel {
	String columnNames[] = { "Interrupt No.", "Count", "Interrupt No.", "Count" };
	public static Hashtable<Long, Integer> interruptRecords;

	public InterruptTableModel() {
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		if (interruptRecords == null) {
			return 0;
		} else {
			int size = interruptRecords.size();
			if (size % 2 == 0) {
				return size / 2;
			} else {
				return size / 2 + 1;
			}
		}
	}

	public void setValueAt(Object aValue, int row, int column) {
		this.fireTableDataChanged();
	}

	public Object getValueAt(int row, int column) {
		ArrayList<Long> list = Collections.list(interruptRecords.keys());
		Collections.sort(list);
		if (column == 0) {
			return "0x" + Integer.toHexString((int) (long) list.get(row));
		} else if (column == 1) {
			return interruptRecords.get(list.get(row));
		} else if (column == 2) {
			return "0x" + Integer.toHexString((int) (long) list.get(row + getRowCount()));
		} else if (column == 3) {
			return interruptRecords.get(list.get(row + getRowCount()));
		} else {
			return "";
		}
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
