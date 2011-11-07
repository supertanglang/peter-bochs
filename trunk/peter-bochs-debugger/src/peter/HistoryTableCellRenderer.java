package peter;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;

public class HistoryTableCellRenderer extends JLabel implements TableCellRenderer {
	public HistoryTableCellRenderer() {
		this.setOpaque(true);
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.lightGray));
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if (value == null) {
			this.setText("");
		} else {
			this.setText(value.toString());
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
		return this;
	}

}
