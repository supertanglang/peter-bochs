package com.peterbochs.sourceleveldebugger;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.peterbochs.MyLanguage;


public class SymbolTableModel extends AbstractTableModel {
	private String[] columnNames = { MyLanguage.getString("File"), MyLanguage.getString("Archive member"), MyLanguage.getString("Segment"), MyLanguage.getString("Memory offset"),
			MyLanguage.getString("Length"), MyLanguage.getString("Function name or object name") };

	public Vector<Symbol> symbols;

	private String searchPattern;

	public SymbolTableModel() {
		symbols = (Vector<Symbol>) MapStructure.symbols.clone();
	}

	public Object getValueAt(int row, int column) {
		try {
			if (symbols != null) {
				switch (column) {
				case 0:
					return symbols.get(row).file.getAbsolutePath();
				case 1:
					return symbols.get(row).archiveMember;
				case 2:
					return symbols.get(row).segment;
				case 3:
					return "0x" + Long.toHexString(symbols.get(row).memoryOffset);
				case 4:
					return symbols.get(row).length;
				case 5:
					return symbols.get(row).functionNameOrObjectName;
				default:
					return "";
				}
			} else {
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
				if (symbols.get(x).file.getName().toLowerCase().contains(searchPattern.toLowerCase())
						|| symbols.get(x).archiveMember.toLowerCase().contains(searchPattern.toLowerCase())
						|| symbols.get(x).segment.toLowerCase().contains(searchPattern.toLowerCase())
						|| String.valueOf(symbols.get(x).memoryOffset).toLowerCase().contains(searchPattern.toLowerCase())
						|| String.valueOf(symbols.get(x).length).toLowerCase().contains(searchPattern.toLowerCase())
						|| symbols.get(x).functionNameOrObjectName.toLowerCase().contains(searchPattern.toLowerCase())) {
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

	public void setSearchPattern(String searchPattern) {
		if (searchPattern != null && !searchPattern.equals("")) {
			symbols.clear();

			for (int x = 0; x < MapStructure.symbols.size(); x++) {
				if (MapStructure.symbols.get(x).file.getName().toLowerCase().contains(searchPattern.toLowerCase())
						|| MapStructure.symbols.get(x).archiveMember.toLowerCase().contains(searchPattern.toLowerCase())
						|| MapStructure.symbols.get(x).segment.toLowerCase().contains(searchPattern.toLowerCase())
						|| String.valueOf(MapStructure.symbols.get(x).memoryOffset).toLowerCase().contains(searchPattern.toLowerCase())
						|| String.valueOf(MapStructure.symbols.get(x).length).toLowerCase().contains(searchPattern.toLowerCase())
						|| MapStructure.symbols.get(x).functionNameOrObjectName.toLowerCase().contains(searchPattern.toLowerCase())) {

					Symbol symbol = new Symbol();
					symbol.file = MapStructure.symbols.get(x).file;
					symbol.archiveMember = MapStructure.symbols.get(x).archiveMember;
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
		fireTableDataChanged();
	}

	public void reload() {
		setSearchPattern(searchPattern);
	}

}
