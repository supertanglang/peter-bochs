package peter;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class GDTLDTPanel extends JPanel {
	private JTable jTable1;
	private int gdtNo;
	private JScrollPane jScrollPane2;
	private JTable jTSSTable;
	private JScrollPane jScrollPane3;
	private JLabel jTypeLabel;
	private JTable jTable2;
	private JScrollPane jScrollPane1;
	private byte b[] = new byte[8];
	private long value;
	private long bit[] = new long[64];
	private Application application;
	private int type;
	private long gdtAddress;

	public GDTLDTPanel(Application application, int type, long gdtAddress, int gdtNo) {
		this.application = application;
		this.type = type;
		this.gdtAddress = gdtAddress;
		this.gdtNo = gdtNo;

		initGUI();
	}

	private void initGUI() {
		try {
			{
				this.setLayout(null);
				{
					jScrollPane1 = new JScrollPane();
					this.add(jScrollPane1);
					jScrollPane1.setBounds(12, 38, 667, 60);
					jScrollPane1.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));
					{
						DefaultTableModel jTable1Model = new DefaultTableModel(new String[][] { { "" }, { "" } }, new String[] { "31" });
						for (int x = 30; x >= 0; x--) {
							jTable1Model.addColumn(x);
						}

						jTable1 = new JTable();
						jScrollPane1.setViewportView(jTable1);
						jTable1.setModel(jTable1Model);
						jTable1.setBounds(12, 12, 562, 50);
					}
				}
				{
					jScrollPane2 = new JScrollPane();
					this.add(jScrollPane2);
					jScrollPane2.setBounds(12, 110, 287, 227);
					jScrollPane2.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));
					{
						TableModel jTable2Model = new DefaultTableModel(new String[][] {}, new String[] { "Field", "Value" });
						jTable2 = new JTable();
						jScrollPane2.setViewportView(jTable2);
						jTable2.setModel(jTable2Model);
					}
				}
				{
					jTypeLabel = new JLabel();
					this.add(jTypeLabel);
					jTypeLabel.setText("Type : ");
					jTypeLabel.setBounds(12, 12, 576, 14);
				}
			}
			{
				jScrollPane3 = new JScrollPane();
				this.add(jScrollPane3);
				jScrollPane3.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));
				jScrollPane3.setBounds(305, 110, 374, 471);
				jScrollPane3.setVisible(false);
				{
					TableModel jTable3Model = new DefaultTableModel(new String[][] {}, new String[] { "Field", "Value" });
					jTSSTable = new JTable();
					jScrollPane3.setViewportView(jTSSTable);
					jTSSTable.setModel(jTable3Model);
				}
			}
			// Application.commandReceiver.setCommandNoOfLine(2);
			String result;
			if (type == 0) {
				Application.sendCommand("info gdt " + gdtNo);
				String gdtNoHex = String.format("0x%02x", gdtNo);
				result = Application.commandReceiver.getCommandResult("GDT[" + gdtNoHex + "]");
			} else {
				Application.sendCommand("info ldt " + gdtNo);
				String gdtNoHex = String.format("0x%02x", gdtNo);
				result = Application.commandReceiver.getCommandResult("LDT[" + gdtNoHex + "]");
			}

			// String lines[] =
			// result.split("\n");
			// System.out.println(lines[0]);
			// long address = Long.parseLong(lines[0].replaceFirst("^.*base=0x",
			// "").replaceFirst(",.*$", ""), 16);

			// get bytes
			// Application.commandReceiver.setCommandNoOfLine(2);
			// String dumpAddress = String.format("0x%08x", gdtAddress + (gdtNo
			// * 8));
			// String dumpEndAddress = String.format("0x%08x", gdtAddress +
			// ((gdtNo + 1) * 8));
			Application.commandReceiver.clearBuffer();
			Application.sendCommand("xp /8bx " + String.format("0x%08x", gdtAddress + (gdtNo * 8)));
			// System.out.println("xp /8bx " + dumpAddress);
			result = Application.commandReceiver.getCommandResult(String.format("%08x", gdtAddress + (gdtNo * 8)));
			String lines[] = result.split("\n");

			String byteStr[] = lines[0].replaceFirst("^.*>:\t", "").split("\t");
			for (int x = 0; x < 8; x++) {
				b[x] = (byte) Long.parseLong(byteStr[x].substring(2), 16);
			}

			value = CommonLib.getLong(b, 0);

			for (int x = 0; x < 64; x++) {
				bit[x] = CommonLib.getBit(value, x);
			}

			for (int x = 0; x < 32; x++) {
				jTable1.setValueAt(value >> x & 1, 1, 31 - x);
			}

			for (int x = 32; x < 64; x++) {
				jTable1.setValueAt(value >> x & 1, 0, 63 - x);
				jTable1.setPreferredSize(new java.awt.Dimension(669, 32));
			}

			// parse descriptor
			if (bit[44] == 1 && bit[43] == 1) {
				jTypeLabel.setText("Type : Code descriptor, value=0x" + Long.toHexString(value));
				parseCodeDescriptor();
			} else if (bit[44] == 1 && bit[43] == 0) {
				jTypeLabel.setText("Type : Data descriptor, value=0x" + Long.toHexString(value));
				parseDataDescriptor();
			} else if (bit[44] == 0 && bit[43] == 0 && bit[42] == 0 && bit[41] == 1 && bit[40] == 0) {
				jTypeLabel.setText("Type : LDT descriptor, value=0x" + Long.toHexString(value) + ", base=0x" + Long.toHexString(CommonLib.getInt(b[2], b[3], b[4], b[7])) + ", limit=0x"
						+ Long.toHexString(CommonLib.getShort(b[0], b[1])));
				parseLDT();
			} else if (bit[44] == 0 && bit[42] == 0 && bit[40] == 1) {
				jTypeLabel.setText("Type : TSS descriptor, value=0x" + Long.toHexString(value));
				parseTSSDescriptor();
			}
			// end parse descriptor
			this.setPreferredSize(new Dimension(600, 600));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void parseCodeDescriptor() {
		try {
			DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
			long base = CommonLib.getLong(b[2], b[3], b[4], b[7], 0, 0, 0, 0);
			model.addRow(new String[] { "base", "0x" + Long.toHexString(base) });

			long limit = CommonLib.getLong(b[0], b[1], b[6] & 0xf, 0, 0, 0, 0, 0);
			if (bit[55] == 1) {
				limit *= 4096;
			}
			model.addRow(new String[] { "limit", "0x" + Long.toHexString(limit) });

			model.addRow(new String[] { "G", String.valueOf(bit[55]) });
			model.addRow(new String[] { "D", String.valueOf(bit[54]) });
			model.addRow(new String[] { "AVL", String.valueOf(bit[52]) });
			model.addRow(new String[] { "P", String.valueOf(bit[47]) });
			model.addRow(new String[] { "DPL", String.valueOf(bit[45] + bit[46] << 1) });
			model.addRow(new String[] { "S", String.valueOf(bit[44]) });
			model.addRow(new String[] { "X", String.valueOf(bit[43]) });
			model.addRow(new String[] { "C", String.valueOf(bit[42]) });
			model.addRow(new String[] { "R", String.valueOf(bit[41]) });
			model.addRow(new String[] { "A", String.valueOf(bit[40]) });
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void parseDataDescriptor() {
		try {
			DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
			long base = CommonLib.getLong(b[2], b[3], b[4], b[7], 0, 0, 0, 0);
			model.addRow(new String[] { "base", "0x" + Long.toHexString(base) });

			long limit = CommonLib.getLong(b[0], b[1], b[6] & 0xf, 0, 0, 0, 0, 0);
			if (bit[55] == 1) {
				limit *= 4096;
			}
			model.addRow(new String[] { "limit", "0x" + Long.toHexString(limit) });

			model.addRow(new String[] { "G", String.valueOf(bit[55]) });
			model.addRow(new String[] { "B", String.valueOf(bit[54]) });
			model.addRow(new String[] { "AVL", String.valueOf(bit[52]) });
			model.addRow(new String[] { "P", String.valueOf(bit[47]) });
			model.addRow(new String[] { "DPL", String.valueOf(bit[45] + bit[46] << 1) });
			model.addRow(new String[] { "S", String.valueOf(bit[44]) });
			model.addRow(new String[] { "X", String.valueOf(bit[43]) });
			model.addRow(new String[] { "E", String.valueOf(bit[42]) });
			model.addRow(new String[] { "W", String.valueOf(bit[41]) });
			model.addRow(new String[] { "A", String.valueOf(bit[40]) });
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void parseLDT() {
		try {
			jTable2.getColumnModel().getColumn(0).setHeaderValue("No");
			jTable2.getColumnModel().getColumn(1).setHeaderValue("Type");
			DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
			jTable2.getColumnModel().getColumn(0).setMaxWidth(40);
			jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			jTable2.setPreferredSize(new Dimension(600, 600));
			// application.commandReceiver.setCommandNoOfLine(20);
			application.sendCommand("info ldt 0 20");
			String result = application.commandReceiver.getCommandResult("XX", "XX");
			String lines[] = result.split("\n");
			for (int x = 1; x < lines.length; x++) {
				try {
					model.addRow(new String[] { lines[x].replaceFirst("^.*\\[", "").replaceFirst("].*$", ""), lines[x].replaceFirst("^.*]=", "") });
				} catch (Exception ex) {
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void parseTSSDescriptor() {
		try {
			DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
			long base = CommonLib.getLong(b[2], b[3], b[4], b[7], 0, 0, 0, 0);
			model.addRow(new String[] { "base", "0x" + Long.toHexString(base) });

			long limit = CommonLib.getLong(b[0], b[1], b[6] & 0xf, 0, 0, 0, 0, 0);
			if (bit[55] == 1) {
				limit *= 4096;
			}
			model.addRow(new String[] { "limit", "0x" + Long.toHexString(limit) });

			model.addRow(new String[] { "G", String.valueOf(bit[55]) });
			model.addRow(new String[] { "AVL", String.valueOf(bit[52]) });
			model.addRow(new String[] { "P", String.valueOf(bit[47]) });
			model.addRow(new String[] { "DPL", String.valueOf(bit[45] + bit[46] << 1) });
			model.addRow(new String[] { "S", String.valueOf(bit[44]) });
			model.addRow(new String[] { "D", String.valueOf(bit[43]) });
			model.addRow(new String[] { "G", String.valueOf(bit[42]) });
			model.addRow(new String[] { "B", String.valueOf(bit[41]) });
			model.addRow(new String[] { "V", String.valueOf(bit[40]) });

			// TSS
			// Application.commandReceiver.setCommandNoOfLine(2);
			Application.commandReceiver.clearBuffer();
			Application.sendCommand("x /" + limit + "bx " + base);

			float totalByte2 = limit - 1;
			totalByte2 = totalByte2 / 8;
			int totalByte3 = (int) Math.floor(totalByte2);
			String realEndAddressStr;
			String realStartAddressStr;
			Integer realStartAddress;
			if (String.valueOf(base).startsWith("0x")) {
				realStartAddress = Integer.parseInt(String.valueOf(base).substring(2), 16);
			} else {
				realStartAddress = Integer.parseInt(String.valueOf(base));
			}
			realStartAddressStr = String.format("%08x", realStartAddress);
			int realEndAddress = realStartAddress + totalByte3 * 8;
			realEndAddressStr = String.format("%08x", realEndAddress);

			String result2 = Application.commandReceiver.getCommandResult(realStartAddressStr, realEndAddressStr);
			String[] lines2 = result2.split("\n");

			byte tssByte[] = new byte[(int) limit];
			for (int y = 1; y < lines2.length; y++) {
				String byteStr[] = lines2[y].replaceFirst("^.*>:\t", "").split("\t");
				for (int x = 0; x < 8; x++) {
					tssByte[x + ((y - 1) * 8)] = (byte) Long.parseLong(byteStr[x].substring(2), 16);
				}
			}

			long tssValue = CommonLib.getLong(b, 0);

			DefaultTableModel tssModel = (DefaultTableModel) jTSSTable.getModel();
			tssModel.addRow(new String[] { "link", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0], tssByte[1], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "esp0", "0x" + Long.toHexString(CommonLib.getLong(tssByte[4], tssByte[5], tssByte[6], tssByte[7], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "ss0", "0x" + Long.toHexString(CommonLib.getLong(tssByte[8], tssByte[9], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "esp1", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0xc], tssByte[0xd], tssByte[0xe], tssByte[0xf], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "ss1", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x10], tssByte[0x11], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "esp2", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x14], tssByte[0x15], tssByte[0x16], tssByte[0x17], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "ss2", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x18], tssByte[0x19], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "cr3", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x1c], tssByte[0x1d], tssByte[0x1e], tssByte[0x1f], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "eip", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x20], tssByte[0x21], tssByte[0x22], tssByte[0x23], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "eflags", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x24], tssByte[0x25], tssByte[0x26], tssByte[0x27], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "eax", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x28], tssByte[0x29], tssByte[0x2a], tssByte[0x2b], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "ecx", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x2c], tssByte[0x2d], tssByte[0x2e], tssByte[0x2f], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "edx", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x30], tssByte[0x31], tssByte[0x32], tssByte[0x33], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "ebx", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x34], tssByte[0x35], tssByte[0x36], tssByte[0x37], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "esp", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x38], tssByte[0x39], tssByte[0x3a], tssByte[0x3b], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "ebp", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x3c], tssByte[0x3d], tssByte[0x3e], tssByte[0x3f], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "esi", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x40], tssByte[0x41], tssByte[0x42], tssByte[0x43], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "edi", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x44], tssByte[0x45], tssByte[0x45], tssByte[0x47], 0, 0, 0, 0)) });

			tssModel.addRow(new String[] { "es", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x48], tssByte[0x49], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "cs", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x4c], tssByte[0x4d], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "ss", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x50], tssByte[0x51], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "ds", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x54], tssByte[0x55], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "fs", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x58], tssByte[0x59], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "gs", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x5c], tssByte[0x5d], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "ldtr", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x60], tssByte[0x61], 0, 0, 0, 0, 0, 0)) });

			tssModel.addRow(new String[] { "iobp", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x66], tssByte[0x67], 0, 0, 0, 0, 0, 0)) });
			jScrollPane3.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}