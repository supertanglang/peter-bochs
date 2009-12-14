package peter;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class JSourceCodeCellRenderer extends JLabel implements TableCellRenderer {
	ImageIcon breakpointIcon = new ImageIcon(getClass().getClassLoader().getResource("images/breakpoint/breakpoint.png"));
	ImageIcon breakpointDisableIcon = new ImageIcon(getClass().getClassLoader().getResource("images/breakpoint/breakpointDisable.png"));

	public JSourceCodeCellRenderer() {
		this.setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			this.setBackground(table.getSelectionBackground());
		} else {
			this.setBackground(Color.white);
		}
		if (column == 0) {
			this.setHorizontalAlignment(JLabel.CENTER);
			if (value.toString().equals("O")) {
				setIcon(breakpointIcon);
			} else if (value.toString().equals("X")) {
				setIcon(breakpointDisableIcon);
			} else {
				setIcon(null);
			}
		} else {
			this.setText(value.toString().replaceAll("\t", "    "));
		}
		return this;
	}
}
