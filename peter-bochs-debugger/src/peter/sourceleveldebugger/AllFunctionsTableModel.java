package peter.sourceleveldebugger;

import java.util.TreeSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import peter.MyLanguage;

public class AllFunctionsTableModel extends AbstractTableModel {
	private String[] columnNames = { MyLanguage.getString("Name") };

	public TreeSet<Function> functions;

	private String searchPattern;

	boolean exact;

	public AllFunctionsTableModel() {
		functions = (TreeSet<Function>) MapStructure.functions.clone();
	}

	public Object getValueAt(int row, int column) {
		try {
			Function function = (Function) functions.toArray()[row];
			Symbol symbol = MapStructure.findSymbolByFilenameOrObjectName(function.name);
			if (symbol == null) {
				return function.name;
			} else {
				return function.name + " 0x" + Long.toHexString(symbol.memoryOffset);
			}
		} catch (Exception ex) {
			return "";
		}
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		if (searchPattern == null) {
			return functions.size();
		} else {
			int rowCount = 0;
			for (int x = 0; x < functions.size(); x++) {
				Function f = (Function) functions.toArray()[x];
				if ((exact == false && f.name.toLowerCase().contains(searchPattern.toLowerCase())) || (exact == true && f.name.toLowerCase().equals(searchPattern.toLowerCase()))) {
					rowCount++;
				}
			}
			return rowCount;
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

	public void setSearchPattern(String searchPattern, boolean exact) {
		this.exact = exact;
		if (searchPattern != null && !searchPattern.equals("")) {
			functions.clear();

			for (int x = 0; x < MapStructure.functions.size(); x++) {
				Function f = (Function) MapStructure.functions.toArray()[x];
				if ((exact == false && f.name.toLowerCase().contains(searchPattern.toLowerCase())) || (exact == true && f.name.toLowerCase().equals(searchPattern.toLowerCase()))) {
					Function function = new Function();
					function.file = f.file;
					function.fileOffset = f.fileOffset;
					function.size = f.size;
					function.name = f.name;
					function.code = f.code;
					functions.add(function);
				}
			}
		} else {
			functions = (TreeSet<Function>) MapStructure.functions.clone();
		}
		fireTableDataChanged();
	}

	public void reload() {
		setSearchPattern(searchPattern, exact);
	}
}
