package peter;

import java.io.File;
import java.util.Vector;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class SystemMapTableModel extends AbstractTableModel {
	private String[] columnNames = { MyLanguage.getString("No."), MyLanguage.getString("Address"), MyLanguage.getString("Symbol type"), MyLanguage.getString("Symbol") };
	private Vector<Boolean> value = new Vector<Boolean>();
	private Vector<String> address = new Vector<String>();
	private Vector<String> symbolType = new Vector<String>();
	private Vector<String> symbol = new Vector<String>();

	public void load(File file) {
		String fileContent = new String(CommonLib.readFile(file));

		String lines[] = fileContent.split("\n");
		int x = 0;
		for (String line : lines) {
			String data[] = line.split(" ");
			if (data.length == 3) {
				value.add(false);
				address.add(data[0]);
				symbolType.add(data[1]);
				symbol.add(data[2]);
			}
		}
		this.fireTableDataChanged();
	}

	public Object getValueAt(int row, int column) {
		try {
			if (column == 0) {
				return value.get(row);
			} else if (column == 1) {
				return row;
			} else if (column == 2) {
				return address.get(row);
			} else if (column == 3) {
				return symbolType.get(row);
			} else {
				return symbol.get(row);
			}
		} catch (Exception ex) {
			return "";
		}
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return address.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public boolean isCellEditable(int row, int col) {
		if (col == 0) {
			return true;
		} else {
			return false;
		}
	}

	public Class getColumnClass(int columnIndex) {
		if (columnIndex == 0) {
			return Boolean.class;
		} else {
			return String.class;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			value.set(rowIndex, (Boolean) aValue);
		}
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}
