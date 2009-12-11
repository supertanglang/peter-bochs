package peter;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class JSourceCodeTableModel extends AbstractTableModel {
	private String[] columnNames = { Application.language.getString("Line"), Application.language.getString("Source") };
	private HashMap<String, List<String>> sourceCodes = new HashMap<String, List<String>>();

	public HashMap<String, List<String>> getSourceCodes() {
		return sourceCodes;
	}

	private String currentFile;

	public Object getValueAt(int row, int column) {
		try {
			if (column == 0) {
				return row + 1;
			} else {
				return sourceCodes.get(currentFile).get(row);
			}
		} catch (Exception ex) {
			return "";
		}
	}

	public String getCurrentFile() {
		return currentFile;
	}

	public void setCurrentFile(String currentFile) {
		this.currentFile = currentFile;
		this.fireTableDataChanged();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		try {
			return sourceCodes.get(currentFile).size();
		} catch (Exception ex) {
			return 0;
		}
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
