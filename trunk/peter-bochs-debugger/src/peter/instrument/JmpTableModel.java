package peter.instrument;

import java.io.File;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import peter.Global;
import peter.ReverseFileReader;

public class JmpTableModel extends DefaultTableModel implements Runnable {
	String columnNames[] = { "No.", "Date", "From", "To" };
	int rowCount = 20;
	boolean isGroup;
	File log = new File(Global.jmpLog);

	Vector<String> no = new Vector<String>();
	Vector<String> date = new Vector<String>();
	Vector<Long> from = new Vector<Long>();
	Vector<Long> to = new Vector<Long>();

	// LogFileTailer tailer = new LogFileTailer(new File("jmp.log"), 1000,
	// false);

	public JmpTableModel() {
		// tailer.addLogFileTailerListener(this);
		// tailer.start();
		// new Thread(this).start();
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setValueAt(Object aValue, int row, int column) {

		this.fireTableDataChanged();
	}

	public Object getValueAt(int row, int column) {
		if (column == 0) {
			return no.get(row);
		} else if (column == 1) {
			return date.get(row);
		} else if (column == 2) {
			return "0x" + Long.toHexString(from.get(row));
		} else if (column == 3) {
			return to.get(row);
		} else {
			return "";
		}
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

	/*
	 * @Override public void newLogFileLine(String line) { String strs[] =
	 * line.split("-"); No.add(strs[0]); Date.add(strs[1]); From.add(strs[2]);
	 * To.add(strs[3]); if (No.size() > getRowCount()) { No.remove(0);
	 * Date.remove(0); From.remove(0); To.remove(0); }
	 * this.fireTableDataChanged(); }
	 */

	public boolean isGroup() {
		return isGroup;
	}

	public void setGroup(boolean isGroup) {
		this.isGroup = isGroup;
	}

	public void addData(String no, String date, Long from, Long to) {
		this.no.add(no);
		this.date.add(date);
		this.from.add(from);
		this.to.add(to);
		if (this.no.size() > getRowCount()) {
			this.no.remove(0);
			this.date.remove(0);
			this.from.remove(0);
			this.to.remove(0);
		}
		this.fireTableDataChanged();
	}

	@Override
	public void run() {
		long lastFileLength = -1;

		while (true) {
			try {
				long fileLength = log.length();

				if (fileLength > lastFileLength) {
					ReverseFileReader reader = new ReverseFileReader(Global.jmpLog);
					for (int x = 0; x < getRowCount(); x++) {
						String s = reader.readLine();
						if (s != null) {
							String strs[] = s.split("-");
							if (strs.length == 4) {
								// System.out.println("s=" + s);
								no.add(strs[0]);
								date.add(strs[1]);
								from.add(Long.parseLong(strs[2]));
								to.add(Long.parseLong(strs[2]));
								if (no.size() > getRowCount()) {
									no.remove(0);
									date.remove(0);
									from.remove(0);
									to.remove(0);
								}
							}
						}
					}
					this.fireTableDataChanged();
					reader.close();
					lastFileLength = fileLength;
				}
				Thread.currentThread().sleep(500);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}
}
