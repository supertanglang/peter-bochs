package peter;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import syntaxhighlight.Keywords;

public class JInstructionTableCellRenderer extends JLabel implements TableCellRenderer {
	// private HashMap<Long, Boolean> breakpoint = new HashMap<Long, Boolean>();
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
			this.setBackground(Color.white);
		}
		if (table.getValueAt(row, 1).equals("cCode")) {
			if (column == 1) {
				this.setText("");
			} else {

				String code = ((String) value);
				if (code != null) {
					code = code.replaceAll("\\t", "    ");
//					for (String keyword : Keywords.cKeywords) {
//						code = code.replaceAll(keyword, "<font color=red>$0</font>");
//					}
//					for (String keyword : Keywords.cppKeywords) {
//						code = code.replaceAll(keyword, "<font color=red>$0</font>");
//					}
					
//					code = code.replaceAll(Keywords.asmKeywords, "<font color=red>$0</font>");
//					this.setText("<html>" + code + "</html>");
					this.setText(code);
				}
			}
			this.setForeground(Color.blue);
			this.setIcon(null);
		} else {
			this.setForeground(Color.black);
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
			} else if (column == 2) {
				String asmCode = (String) value;
				asmCode = asmCode.replaceAll(Keywords.asmKeywords.toLowerCase(), "<font color=red>$0&nbsp;</font>");
				this.setText("<html>&nbsp;&nbsp;&nbsp;&nbsp;" + asmCode + "</html>");
				this.setIcon(null);
			} else {
				String s = (String) value;
				if (s.contains(":")) {
					String ss[] = s.split(":");
					if (ss.length > 1) {
						this.setText("<html>" + ss[0] + ":<font color=green>" + ss[1] + "</font></html>");
					} else {
						this.setText(s);
					}
				} else {
					this.setText(s);
				}
				this.setIcon(null);
			}
		}
		if (column == 1) {
			this.setHorizontalAlignment(SwingConstants.CENTER);
		} else {
			this.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return this;
	}
}
