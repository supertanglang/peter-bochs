package com.peterbochs.sourceleveldebugger;

import java.util.TreeSet;

import javax.swing.table.AbstractTableModel;

import com.peterbochs.MyLanguage;
import com.peterdwarf.elf.Elf32_Sym;

public class SymbolTableModel extends AbstractTableModel {
	private String[] columnNames = { MyLanguage.getString("Name") };
	private TreeSet<Elf32_Sym> displaySymbols;
	TreeSet<Elf32_Sym> symbols;
	private String searchPattern;
	public boolean exactMatch;

	public SymbolTableModel() {
	}

	public Object getValueAt(int row, int column) {
		try {
			if (displaySymbols == null) {
				setSearchPattern(searchPattern);
			}
			Elf32_Sym symbol = (Elf32_Sym) displaySymbols.toArray()[row];
			return symbol;
		} catch (Exception ex) {
			return "";
		}
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		if (displaySymbols == null) {
			setSearchPattern(searchPattern);
		}
		if (displaySymbols == null) {
			return 0;
		} else if (searchPattern == null) {
			return displaySymbols.size();
		} else {
			int rowCount = 0;
			for (int x = 0; x < displaySymbols.size(); x++) {
				Elf32_Sym symbol = (Elf32_Sym) displaySymbols.toArray()[x];
				if ((!exactMatch && symbol.name.toLowerCase().contains(searchPattern.toLowerCase()))
						|| (exactMatch && symbol.name.toLowerCase().equals(searchPattern.toLowerCase()))) {
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
		this.searchPattern = searchPattern;
		if (symbols == null) {
			return;
		}
		if (searchPattern != null && !searchPattern.equals("")) {
			displaySymbols.clear();

			for (int x = 0; x < symbols.size(); x++) {
				Elf32_Sym symbol = (Elf32_Sym) symbols.toArray()[x];
				if ((!exactMatch && symbol.name.toLowerCase().contains(searchPattern.toLowerCase()))
						|| (exactMatch && symbol.name.toLowerCase().equals(searchPattern.toLowerCase()))) {
					displaySymbols.add(symbol);
				}
			}
		} else {
			displaySymbols = (TreeSet<Elf32_Sym>) symbols.clone();
		}
		fireTableDataChanged();
	}

	public void reload() {
		setSearchPattern(searchPattern);
	}
}
