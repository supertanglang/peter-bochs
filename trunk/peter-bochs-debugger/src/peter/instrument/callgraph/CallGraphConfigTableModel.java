package peter.instrument.callgraph;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import peter.Setting;

public class CallGraphConfigTableModel extends AbstractTableModel {
	private String columnNames[] = { "Physical address", "TSS", "Memory start", "Memory end", "Register", "GDT", "IDT", "LDT" };

	Object data[] = { Setting.getInstance().getPhysicalAddress(), Setting.getInstance().getTss(), Setting.getInstance().getMemoryStart(), Setting.getInstance().getMemoryEnd(),
			Setting.getInstance().getRegister(), Setting.getInstance().getGdt(), Setting.getInstance().getIdt(), Setting.getInstance().getLdt() };

	public boolean needToTellBochsToUpdateZone = false;

	public String getColumnName(int column) {
		return columnNames[column];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	public int getRowCount() {
		return Setting.getInstance().getPhysicalAddress().size() + 1;
	}

	public void setValueAt(Object aValue, int row, int column) {
		if (row == Setting.getInstance().getPhysicalAddress().size()) {
			long physicalAddress = 0;
			boolean tss = false;
			boolean memoryStart = false;
			boolean memoryEnd = false;
			boolean register = false;
			boolean gdt = false;
			boolean idt = false;
			boolean ldt = false;
			switch (column) {
			case 0:
				physicalAddress = (Long) aValue;
				break;
			case 1:
				tss = (Boolean) aValue;
				break;
			case 2:
				memoryStart = (Boolean) aValue;
				break;
			case 3:
				memoryEnd = (Boolean) aValue;
				break;
			case 4:
				register = (Boolean) aValue;
				break;
			case 5:
				gdt = (Boolean) aValue;
				break;
			case 6:
				idt = (Boolean) aValue;
				break;
			case 7:
				ldt = (Boolean) aValue;
				break;
			}
			this.add(physicalAddress, tss, memoryStart, memoryEnd, register, gdt, idt, ldt);
		} else {
			Vector vector = (Vector) data[column];
			vector.setElementAt(aValue, row);
			Setting.getInstance().save();
		}
	}

	public Object getValueAt(int row, int column) {
		if (row == Setting.getInstance().getPhysicalAddress().size()) {
			if (column == 0) {
				return 0;
			} else {
				return false;
			}
		} else {
			Vector vector = (Vector) data[column];
			return vector.get(row);
		}
	}

	public boolean isCellEditable(int row, int column) {
		return true;
	}

	public void add(long physicalAddress, boolean tss, boolean memoryStart, boolean memoryEnd, boolean register, boolean gdt, boolean idt, boolean ldt) {
		Setting.getInstance().getPhysicalAddress().add(physicalAddress);
		Setting.getInstance().getTss().add(tss);
		Setting.getInstance().getMemoryStart().add(memoryStart);
		Setting.getInstance().getMemoryEnd().add(memoryEnd);
		Setting.getInstance().getRegister().add(register);
		Setting.getInstance().getGdt().add(gdt);
		Setting.getInstance().getIdt().add(idt);
		Setting.getInstance().getLdt().add(ldt);
		this.fireTableDataChanged();
		Setting.getInstance().save();
	}

}
