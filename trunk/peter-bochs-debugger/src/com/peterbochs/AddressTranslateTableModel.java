package com.peterbochs;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class AddressTranslateTableModel extends DefaultTableModel {
	String columnNames[] = new String[] { MyLanguage.getString("Address_type"), MyLanguage.getString("Search_address"), MyLanguage.getString("Virtual_address"),
			MyLanguage.getString("Segment_no"), MyLanguage.getString("Base_address"), MyLanguage.getString("Linear_address"), MyLanguage.getString("PD_No"),
			MyLanguage.getString("PDE"), MyLanguage.getString("PT_No"), MyLanguage.getString("PTE"), MyLanguage.getString("Physical_address"),
			MyLanguage.getString("Bytes") };

	public Vector<Integer> searchType = new Vector<Integer>();
	public Vector<Long> searchSegSelector = new Vector<Long>();
	public Vector<Long> searchAddress = new Vector<Long>();

	public Vector<Long> virtualAddress = new Vector<Long>();
	public Vector<Long> segNo = new Vector<Long>();
	public Vector<Long> baseAddress = new Vector<Long>();
	public Vector<Long> linearAddress = new Vector<Long>();
	public Vector<Long> pdNo = new Vector<Long>();
	public Vector<Long> pde = new Vector<Long>();
	public Vector<Long> ptNo = new Vector<Long>();
	public Vector<Long> pte = new Vector<Long>();
	public Vector<Long> physicalAddress = new Vector<Long>();
	public Vector<String> bytes = new Vector<String>();

	public Vector data[] = new Vector[] { virtualAddress, segNo, baseAddress, linearAddress, pdNo, pde, ptNo, pte, physicalAddress, bytes };

	public String getColumnName(int column) {
		return columnNames[column];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		if (searchType != null) {
			return searchType.size();
		} else {
			return 0;
		}
	}

	public Object getValueAt(int row, int column) {
		try {
			if (column == 0) {
				if (searchType.get(row) == 1) {
					return MyLanguage.getString("Virtual_address");
				} else if (searchType.get(row) == 2) {
					return MyLanguage.getString("Linear_address");
				} else if (searchType.get(row) == 3) {
					return MyLanguage.getString("Physical_address");
				} else {
					return "";
				}
			} else if (column == 1) {
				if (searchType.get(row) == 1) {
					return "0x" + Long.toHexString(searchSegSelector.get(row)) + ":0x" + Long.toHexString(searchAddress.get(row));
				} else {
					return "0x" + Long.toHexString(searchAddress.get(row));
				}
			} else if (data[column - 2].get(row).getClass() == Long.class) {
				return "0x" + Long.toHexString((Long) data[column - 2].get(row));
			} else if (data[column - 2].get(row).getClass() == Integer.class) {
				return "0x" + Long.toHexString((Integer) data[column - 2].get(row));
			} else {
				return data[column - 2].get(row);
			}
		} catch (Exception ex) {
			return "";
		}
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public void removeRow(int[] rows) {
		Arrays.sort(rows);
		for (int x = rows.length - 1; x >= 0; x--) {
			for (int y = 0; y < data.length; y++) {
				data[y].remove(rows[x]);
			}

			searchType.remove(rows[x]);
			searchSegSelector.remove(rows[x]);
			searchAddress.remove(rows[x]);
		}
		this.fireTableDataChanged();
	}
}
