package peter.sourceleveldebugger;

import java.io.File;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import peter.MyLanguage;

public class DwarfTableModel extends AbstractTableModel {
	private String[] columnNames = { MyLanguage.getString("File"), MyLanguage.getString("Line no."), MyLanguage.getString("pc"), MyLanguage.getString("Archive member") };

	public Vector<DwarfLine> dwarfLines;

	private String searchPattern;
	public File archiveFile;

	public DwarfTableModel() {
		dwarfLines = new Vector<DwarfLine>();
	}

	public Object getValueAt(int row, int column) {
		try {
			if (dwarfLines != null) {
				switch (column) {
				case 0:
					return dwarfLines.get(row).file.getCanonicalPath();
				case 1:
					return dwarfLines.get(row).lineNo;
				case 2:
					return "0x" + Long.toHexString(dwarfLines.get(row).pc);
				case 3:
					return dwarfLines.get(row).archiveMember;
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
			return dwarfLines.size();
		} else {
			int rowCount = 0;
			for (int x = 0; x < dwarfLines.size(); x++) {
				if (dwarfLines.get(x).file.getName().contains(searchPattern) || String.valueOf(dwarfLines.get(x).lineNo).contains(searchPattern)
						|| String.valueOf(dwarfLines.get(x).pc).contains(searchPattern) || dwarfLines.get(x).archiveMember.contains(searchPattern)) {
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
		if (searchPattern != null && !searchPattern.equals("") && archiveFile != null) {
			dwarfLines.clear();

			for (int x = 0; x < MapStructure.dwarfLines.get(archiveFile).size(); x++) {
				if (MapStructure.dwarfLines.get(archiveFile).get(x).file.getName().toLowerCase().contains(searchPattern.toLowerCase())
						|| String.valueOf(MapStructure.dwarfLines.get(archiveFile).get(x).lineNo).toLowerCase().contains(searchPattern.toLowerCase())
						|| String.valueOf(MapStructure.dwarfLines.get(archiveFile).get(x).pc).toLowerCase().contains(searchPattern.toLowerCase())
						|| MapStructure.dwarfLines.get(archiveFile).get(x).archiveMember.toLowerCase().contains(searchPattern.toLowerCase())) {

					DwarfLine dwarfLine = new DwarfLine();
					dwarfLine.file = MapStructure.dwarfLines.get(archiveFile).get(x).file;
					dwarfLine.lineNo = MapStructure.dwarfLines.get(archiveFile).get(x).lineNo;
					dwarfLine.pc = MapStructure.dwarfLines.get(archiveFile).get(x).pc;
					dwarfLine.archiveMember = MapStructure.dwarfLines.get(archiveFile).get(x).archiveMember;
					dwarfLines.add(dwarfLine);
				}
			}
		} else if (archiveFile != null) {
			dwarfLines = (Vector<DwarfLine>) MapStructure.dwarfLines.get(archiveFile).clone();
		}
		fireTableDataChanged();
	}

	public void reload() {
		setSearchPattern(searchPattern);
	}

}
