package peter;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class JInstructionTableCellRenderer extends JLabel implements TableCellRenderer {
	private HashMap<Long, Boolean> breakpoint = new HashMap<Long, Boolean>();
	ImageIcon breakpointHereIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/arrow_right_red.png"));
	ImageIcon breakpointIcon = new ImageIcon(getClass().getClassLoader().getResource("images/breakpoint/breakpoint.png"));
	ImageIcon breakpointDisableIcon = new ImageIcon(getClass().getClassLoader().getResource("images/breakpoint/breakpointDisable.png"));

	public JInstructionTableCellRenderer() {
		this.setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			this.setBackground(table.getSelectionBackground());
		} else {
			if (row % 2 == 0) {
				this.setBackground(Color.white);
			} else {
				this.setBackground(new Color(0xf4f4f4));
			}
		}
		if (column == 0) {
			if (value.toString().equals("here")) {
				this.setIcon(breakpointHereIcon);
			} else if (value.toString().equals("O")) {
				this.setIcon(breakpointIcon);
			} else if (value.toString().equals("X")) {
				this.setIcon(breakpointDisableIcon);
			} else {
				this.setIcon(null);
			}
			this.setText(null);
		} else {
			this.setText((String) value);
			this.setIcon(null);
		}
		return this;
	}
}
