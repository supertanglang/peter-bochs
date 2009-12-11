package peter;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class JSourceCodeCellRenderer extends JLabel implements TableCellRenderer {
	public JSourceCodeCellRenderer() {
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		this.setText(value.toString().replaceAll("\t", "    "));
		return this;
	}
}
