package com.peterbochs.sourceleveldebugger;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.peterbochs.MyLanguage;


public class MapDataTableModel extends AbstractTableModel {
	private String[] columnNames = { MyLanguage.getString("Object"), MyLanguage.getString("Segment"), MyLanguage.getString("Memory Offset"), MyLanguage.getString("Length"),
			MyLanguage.getString("Function or Object") };

	public Vector<Symbol> symbols;

	private String searchPattern;

	public MapDataTableModel() {
		symbols = (Vector<Symbol>) MapStructure.symbols.clone();
	}

	public Object getValueAt(int row, int column) {
		try {
			switch (column) {
			case 0:
				return symbols.get(row).file.getName();
			case 1:
				return symbols.get(row).segment;
			case 2:
				return "0x" + Long.toHexString(symbols.get(row).memoryOffset);
			case 3:
				return (symbols.get(row).length != -1) ? symbols.get(row).length : MapStructure.findFunctionByFunctionName(symbols.get(row).functionNameOrObjectName).size;
			case 4:
				return symbols.get(row).functionNameOrObjectName;
			default:
				return "";
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
			return symbols.size();
		} else {
			int rowCount = 0;
			for (int x = 0; x < symbols.size(); x++) {
				if (symbols.get(x).file.getName().contains(searchPattern) || symbols.get(x).segment.contains(searchPattern)
						|| String.valueOf(symbols.get(x).memoryOffset).contains(searchPattern) || String.valueOf(symbols.get(x).length).contains(searchPattern)
						|| symbols.get(x).functionNameOrObjectName.contains(searchPattern)) {
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

	public String getSearchPattern() {
		return searchPattern;
	}

	public void setSearchPattern(String searchPattern) {
		if (searchPattern != null && !searchPattern.equals("")) {
			symbols.clear();

			for (int x = 0; x < MapStructure.symbols.size(); x++) {
				if (MapStructure.symbols.get(x).file.getName().toLowerCase().contains(searchPattern.toLowerCase())
						|| MapStructure.symbols.get(x).segment.toLowerCase().contains(searchPattern.toLowerCase())
						|| String.valueOf(MapStructure.symbols.get(x).memoryOffset).toLowerCase().contains(searchPattern.toLowerCase())
						|| String.valueOf(MapStructure.symbols.get(x).length).toLowerCase().contains(searchPattern.toLowerCase())
						|| MapStructure.symbols.get(x).functionNameOrObjectName.toLowerCase().contains(searchPattern.toLowerCase())) {

					Symbol symbol = new Symbol();
					symbol.file = MapStructure.symbols.get(x).file;
					symbol.segment = MapStructure.symbols.get(x).segment;
					symbol.memoryOffset = MapStructure.symbols.get(x).memoryOffset;
					symbol.length = MapStructure.symbols.get(x).length;
					symbol.functionNameOrObjectName = MapStructure.symbols.get(x).functionNameOrObjectName;

					symbols.add(symbol);
				}
			}
		} else {
			symbols = (Vector<Symbol>) MapStructure.symbols.clone();
		}
		this.fireTableDataChanged();
	}

}
