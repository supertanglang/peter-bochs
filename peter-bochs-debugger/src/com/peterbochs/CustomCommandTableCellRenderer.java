package com.peterbochs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CustomCommandTableCellRenderer extends JPanel implements TableCellRenderer {
	JLabel jLabel = new JLabel();

	public CustomCommandTableCellRenderer() {
		this.setLayout(new BorderLayout());
		this.add(jLabel, BorderLayout.CENTER);
		jLabel.setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if (row == table.getRowCount() - 1) {
			return (JButton) value;
		} else {
			if (value == null) {
				jLabel.setText("");
			} else {
				jLabel.setText(value.toString());
			}
			if (isSelected) {
				jLabel.setBackground(table.getSelectionBackground());
			} else {
				if (row % 2 == 0) {
					jLabel.setBackground(Color.white);
				} else {
					jLabel.setBackground(new Color(0xf4f4f4));
				}
			}
			return this;
		}

	}

}