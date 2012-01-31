package peter.sourceleveldebugger;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import peter.MyLanguage;
import peter.sourceleveldebugger.Line.CodeType;

public class RawSourceTableModel extends AbstractTableModel {
	private String[] columnNames = { MyLanguage.getString("Memory Offset"), MyLanguage.getString("Code") };
	String functionName;
	Vector<DisassembledCode> codes;

	Vector<Line> lines = new Vector<Line>();

	public Object getValueAt(int row, int column) {
		try {
			if (lines != null) {
				return lines.get(row);
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
		if (lines == null) {
			return 0;
		} else {
			return lines.size();
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

	private void updateCode() {
		lines.clear();
		if (codes == null) {
			return;
		}

		String cCode = "";
		for (DisassembledCode code : codes) {
			if (code.cCode != null && !cCode.equals(code.cCode)) {
				Line line = new Line();
				line.code = code.cCode;
				line.type = CodeType.C;
				line.offset = -1;
				lines.add(line);
				cCode = code.cCode;

				line = new Line();
				line.code = code.asmCode;
				line.type = CodeType.ASM;
				line.asmBytes = code.bytes;
				line.offset = code.offset;
				lines.add(line);
			} else {
				Line line = new Line();
				line.code = code.asmCode;
				line.type = CodeType.ASM;
				line.asmBytes = code.bytes;
				line.offset = code.offset;
				lines.add(line);
			}
		}
	}

	public void fireTableDataChanged() {
		updateCode();
		super.fireTableDataChanged();
	}
}
