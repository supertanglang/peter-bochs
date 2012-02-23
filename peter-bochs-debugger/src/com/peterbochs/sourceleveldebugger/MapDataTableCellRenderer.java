package com.peterbochs.sourceleveldebugger;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class MapDataTableCellRenderer extends JLabel implements TableCellRenderer {
	public MapDataTableCellRenderer() {
		this.setOpaque(true);
		this.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if (value == null) {
			this.setText(null);
		} else {
			this.setText(value.toString());
			this.setToolTipText(value.toString());
		}
		if (isSelected) {
			this.setBackground(table.getSelectionBackground());
		} else {
			if (row % 2 == 0) {
				this.setBackground(Color.white);
			} else {
				this.setBackground(new Color(0xf4f4f4));
			}
		}
		if (column == 1 || column == 2) {
			this.setHorizontalAlignment(SwingConstants.RIGHT);
		} else {
			this.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return this;
	}

}
