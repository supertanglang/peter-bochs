package com.peterbochs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CustomCommandTableModel extends DefaultTableModel {
	String columnNames[] = { "Command", "Count" };
	Vector<String> command = new Vector<String>();
	Vector<Integer> count = new Vector<Integer>();
	JButton button = new JButton("Add");

	public CustomCommandTableModel() {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button), "Button clicked for row");
			}
		});
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseClicked");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("mousePressed");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("mouseReleased");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("mouseEntered");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("mouseExited");
			}

		});
		button.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println("mouseMoved");
			}
		});
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

	public int getColumnCount() {
		if (columnNames == null) {
			return 0;
		}
		return columnNames.length;
	}

	public int getRowCount() {
		if (command == null) {
			return 1;
		}
		return command.size() + 1;
	}

	public void setValueAt(Object aValue, int row, int column) {
		this.fireTableDataChanged();
	}

	public Object getValueAt(final int row, int column) {
		if (row < getRowCount() - 1) {
			if (column == 0) {
				return command.get(row);
			} else if (column == 1) {
				return count.get(row);
			} else {
				return "";
			}
		} else {
			return button;
		}
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public Class getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}
}
