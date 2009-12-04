package peter;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class AddressTranslateTableModel extends DefaultTableModel {
	String columnNames[] = new String[] { Application.language.getString("Address_type"), Application.language.getString("Search_address"),
			Application.language.getString("Virtual_address"), Application.language.getString("Segment_no"), Application.language.getString("Linear_address"),
			Application.language.getString("PD_No"), Application.language.getString("PT_No"), Application.language.getString("Physical_address"),
			Application.language.getString("Bytes") };

	public Vector<Integer> searchType = new Vector<Integer>();
	public Vector<Long> searchSegSelector = new Vector<Long>();
	public Vector<Long> searchAddress = new Vector<Long>();

	public Vector<Long> virtualAddress = new Vector<Long>();
	public Vector<Long> segNo = new Vector<Long>();
	public Vector<Long> linearAddress = new Vector<Long>();
	public Vector<Long> pdNo = new Vector<Long>();
	public Vector<Long> ptNo = new Vector<Long>();
	public Vector<Long> physicalAddress = new Vector<Long>();
	public Vector<String> bytes = new Vector<String>();

	public Vector data[] = new Vector[] { virtualAddress, segNo, linearAddress, linearAddress, pdNo, ptNo, physicalAddress, bytes };

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
					return Application.language.getString("Virtual_address");
				} else if (searchType.get(row) == 2) {
					return Application.language.getString("Linear_address");
				} else if (searchType.get(row) == 3) {
					return Application.language.getString("Physical_address");
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
}
