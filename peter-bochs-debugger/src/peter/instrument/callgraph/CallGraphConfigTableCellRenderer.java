package peter.instrument.callgraph;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class CallGraphConfigTableCellRenderer implements TableCellRenderer {

	JCheckBox checkbox = new JCheckBox();

	public CallGraphConfigTableCellRenderer() {
		checkbox.setHorizontalAlignment(SwingConstants.CENTER);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if (value instanceof Boolean) {
			checkbox.setSelected((Boolean) value);
		}
		return checkbox;
	}

}
