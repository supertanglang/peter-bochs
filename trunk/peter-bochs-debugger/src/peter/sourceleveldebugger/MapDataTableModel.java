package peter.sourceleveldebugger;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import peter.MyLanguage;

public class MapDataTableModel extends AbstractTableModel {
	private String[] columnNames = { MyLanguage.getString("Object"), MyLanguage.getString("Segment"), MyLanguage.getString("Location"), MyLanguage.getString("Length"),
			MyLanguage.getString("Attributes") };
	public Vector<String> objects = new Vector<String>();
	public Vector<String> segments = new Vector<String>();
	public Vector<String> locations = new Vector<String>();
	public Vector<String> lengths = new Vector<String>();
	public Vector<String> attributes = new Vector<String>();

	public Vector<String> originalObjects;
	public Vector<String> originalSegments;
	public Vector<String> originalLocations;
	public Vector<String> originalLengths;
	public Vector<String> originalAttributes;

	public MapDataTableModel() {
	}

	public Object getValueAt(int row, int column) {
		try {
			switch (column) {
			case 0:
				return objects.get(row);
			case 1:
				return segments.get(row);
			case 2:
				return locations.get(row);
			case 3:
				return lengths.get(row);
			case 4:
				return attributes.get(row);
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
			return objects.size();
		} else {
			int rowCount = 0;
			for (int x = 0; x < objects.size(); x++) {
				if (objects.get(x).contains(searchPattern) || segments.get(x).contains(searchPattern) || locations.get(x).contains(searchPattern)
						|| lengths.get(x).contains(searchPattern) || attributes.get(x).contains(searchPattern)) {
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

	private String searchPattern;

	public Class getColumnClass(int columnIndex) {
		return String.class;
	}

	public String getSearchPattern() {
		return searchPattern;
	}

	public void setSearchPattern(String searchPattern) {
		if (originalObjects != null) {
			objects = (Vector<String>) originalObjects.clone();
		}
		if (originalSegments != null) {
			segments = (Vector<String>) originalSegments.clone();
		}
		if (originalLocations != null) {
			locations = (Vector<String>) originalLocations.clone();
		}
		if (originalLengths != null) {
			lengths = (Vector<String>) originalLengths.clone();
		}
		if (originalAttributes != null) {
			attributes = (Vector<String>) originalAttributes.clone();
		}

		if (searchPattern != null && !searchPattern.equals("")) {
			originalObjects = (Vector<String>) objects.clone();
			originalSegments = (Vector<String>) segments.clone();
			originalLocations = (Vector<String>) locations.clone();
			originalLengths = (Vector<String>) lengths.clone();
			originalAttributes = (Vector<String>) attributes.clone();

			objects.clear();
			segments.clear();
			locations.clear();
			lengths.clear();
			attributes.clear();

			for (int x = 0; x < originalObjects.size(); x++) {
				if (originalObjects.get(x).toLowerCase().contains(searchPattern.toLowerCase()) || originalSegments.get(x).toLowerCase().contains(searchPattern.toLowerCase())
						|| originalLocations.get(x).toLowerCase().contains(searchPattern.toLowerCase())
						|| originalLengths.get(x).toLowerCase().contains(searchPattern.toLowerCase())
						|| originalAttributes.get(x).toLowerCase().contains(searchPattern.toLowerCase())) {
					objects.add(originalObjects.get(x));
					segments.add(originalSegments.get(x));
					locations.add(originalLocations.get(x));
					lengths.add(originalLengths.get(x));
					attributes.add(originalAttributes.get(x));
				}
			}
		}
		this.fireTableDataChanged();
	}

}
