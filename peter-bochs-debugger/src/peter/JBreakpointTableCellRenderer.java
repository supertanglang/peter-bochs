package peter;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class JBreakpointTableCellRenderer extends JLabel implements TableCellRenderer {
	public JBreakpointTableCellRenderer() {
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if (value.toString().startsWith("-")) {
			this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/arrow_right_red.png")));
			this.setText(value.toString().substring(1));
		} else {
			this.setIcon(null);
			this.setText(value.toString());
		}
		return this;
	}
}
