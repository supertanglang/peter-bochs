package com.peterbochs.instrument.callgraph;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;

public class CallGraphConfigTableCellEditor extends JCheckBox implements TableCellEditor, ActionListener {
	Vector listeners = new Vector();

	public CallGraphConfigTableCellEditor() {
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.addActionListener(this);
	}

	@Override
	public Object getCellEditorValue() {
		return new Boolean(this.isSelected());
	}

	@Override
	public boolean isCellEditable(EventObject anEvent) {
		return true;
	}

	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		return true;
	}

	@Override
	public boolean stopCellEditing() {
		fireEditingStopped();
		return true;
	}

	@Override
	public void cancelCellEditing() {

	}

	@Override
	public void addCellEditorListener(CellEditorListener l) {
		listeners.addElement(l);
	}

	@Override
	public void removeCellEditorListener(CellEditorListener l) {
		listeners.removeElement(l);
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		this.setSelected((Boolean) value);
		return this;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fireEditingStopped();
	}

	protected void fireEditingStopped() {
		ChangeEvent ce = new ChangeEvent(this);
		for (int i = listeners.size() - 1; i >= 0; i--) {
			((CellEditorListener) listeners.elementAt(i)).editingStopped(ce);
		}
	}
}
