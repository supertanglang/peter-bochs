package com.peterbochs.sourceleveldebugger;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class LibraryTableCellRenderer extends JLabel implements TableCellRenderer {
	public LibraryTableCellRenderer() {
		this.setOpaque(true);
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.lightGray));
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		this.setText(value.toString());
		if (isSelected) {
			this.setBackground(table.getSelectionBackground());
		} else {
			if (row % 2 == 0) {
				this.setBackground(Color.white);
			} else {
				this.setBackground(new Color(0xf4f4f4));
			}
		}
		if (column == 1) {
			this.setHorizontalAlignment(SwingConstants.RIGHT);
		} else {
			this.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return this;
	}

}
