package peter.sourceleveldebugger;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

import peter.sourceleveldebugger.Line.CodeType;

import com.petersoft.CommonLib;

public class RawSourceTableCellRenderer extends JLabel implements TableCellRenderer {
	Color darkGreen = new Color(0, 88, 0);

	public RawSourceTableCellRenderer() {
		this.setOpaque(true);
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		Line line = (Line) value;
		if (column == 0) {
			this.setForeground(Color.black);
			if (line.offset != -1) {
				this.setText("0x" + Integer.toHexString(line.offset));
			} else {
				this.setText("");
			}
		} else if (column == 1) {
			if (line.type == CodeType.ASM) {
				this.setForeground(darkGreen);
				String bytes = "";
				for (int b : line.asmBytes) {
					bytes += Integer.toHexString(b) + ",";
				}
				this.setText("          " + line.code + "    " + bytes);
			} else if (line.type == CodeType.C) {
				this.setForeground(Color.blue);
				this.setText(line.code);
			} else {
				this.setForeground(table.getForeground());
				this.setText("");
			}
		}

		if (isSelected) {
			this.setBackground(table.getSelectionBackground());
		} else {
			this.setBackground(table.getBackground());
		}
		return this;
	}

}
