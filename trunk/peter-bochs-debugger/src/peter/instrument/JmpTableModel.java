package peter.instrument;

import java.io.File;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import peter.Global;
import peter.ReverseFileReader;

public class JmpTableModel extends DefaultTableModel implements Runnable {
	String columnNames[] = { "No.", "Date", "From", "To", "Segment start", "Segment End", "eax", "ecx", "edx", "ebx", "esp", "ebp", "esi", "edi", "es", "cs", "ss", "ds", "fs",
			"gs" };
	int rowCount = 20;
	boolean isGroup;
	File log = new File(Global.jmpLog);

	Vector<String> no = new Vector<String>();
	Vector<String> date = new Vector<String>();

	Vector<Long> from = new Vector<Long>();
	Vector<Long> to = new Vector<Long>();
	Vector<Long> segmentStart = new Vector<Long>();
	Vector<Long> segmentEnd = new Vector<Long>();

	Vector<Long> eax = new Vector<Long>();
	Vector<Long> ecx = new Vector<Long>();
	Vector<Long> edx = new Vector<Long>();
	Vector<Long> ebx = new Vector<Long>();
	Vector<Long> esp = new Vector<Long>();
	Vector<Long> ebp = new Vector<Long>();
	Vector<Long> esi = new Vector<Long>();
	Vector<Long> edi = new Vector<Long>();

	Vector<Long> es = new Vector<Long>();
	Vector<Long> cs = new Vector<Long>();
	Vector<Long> ss = new Vector<Long>();
	Vector<Long> ds = new Vector<Long>();
	Vector<Long> fs = new Vector<Long>();
	Vector<Long> gs = new Vector<Long>();

	Vector allData[] = { no, date, from, to, segmentStart, segmentEnd, eax, ecx, edx, ebx, esp, ebp, esi, edi, es, cs, ss, ds, fs, gs };

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
		try {
			if (allData[column].get(0) instanceof String) {
				return allData[column].get(row);
			} else if (allData[column].get(0) instanceof Long) {
				return "0x" + Long.toHexString((Long) allData[column].get(row));
			} else {
				return "";
			}
		} catch (Exception ex) {
			return "";
		}
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public boolean isGroup() {
		return isGroup;
	}

	public void setGroup(boolean isGroup) {
		this.isGroup = isGroup;
	}

	public void addData(String no, String date, Long from, Long to, Long segmentStart, Long segmentEnd, Long eax, Long ecx, Long edx, Long ebx, Long esp, Long ebp, Long esi,
			Long edi, Long es, Long cs, Long ss, Long ds, Long fs, Long gs) {
		this.no.add(no);
		this.date.add(date);
		this.from.add(from);
		this.to.add(to);
		this.segmentStart.add(segmentStart);
		this.segmentEnd.add(segmentEnd);

		this.eax.add(eax);
		this.ecx.add(ecx);
		this.edx.add(edx);
		this.ebx.add(ebx);
		this.esp.add(esp);
		this.ebp.add(ebp);
		this.esi.add(esi);
		this.edi.add(edi);

		this.es.add(es);
		this.cs.add(cs);
		this.ss.add(ss);
		this.ds.add(ds);
		this.fs.add(fs);
		this.gs.add(gs);

		if (this.no.size() > getRowCount()) {
			removeFirstRow();
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
							if (strs.length == 6) {
								no.add(strs[0]);
								date.add(strs[1]);
								from.add(Long.parseLong(strs[2]));
								to.add(Long.parseLong(strs[3]));
								segmentStart.add(Long.parseLong(strs[4]));
								segmentEnd.add(Long.parseLong(strs[5]));

								if (no.size() > getRowCount()) {
									removeFirstRow();
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

	private void removeFirstRow() {
		for (int x = 0; x < allData.length; x++) {
			if (allData[x].size() > 0) {
				allData[x].remove(0);
			} else {
				System.out.println("fuck =" + x);
			}
		}
	}
}
