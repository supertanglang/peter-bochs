package peter;

import java.awt.BorderLayout;
import java.util.LinkedHashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import peter.architecture.DescriptorParser;

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
public class IDTDescriptorPanel extends JPanel {
	private JTable jByteTable;
	private int idtNo;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JTabbedPane jTabbedPane1;
	private JLabel jTypeLabel;
	private JTable jFieldTable;
	private JScrollPane jScrollPane1;
	private int b[] = new int[8];
	private long value;
	private long bit[] = new long[64];
	private Application application;
	private long idtAddress;
	private JScrollPane jScrollPane2;

	public IDTDescriptorPanel(Application application, long idtAddress, int idtNo) {
		this.application = application;
		this.idtAddress = idtAddress;
		this.idtNo = idtNo;

		initGUI();
	}

	private void initGUI() {
		try {
			{
				BorderLayout thisLayout = new BorderLayout();
				this.setLayout(thisLayout);
			}
			{
				jTabbedPane1 = new JTabbedPane();
				this.add(jTabbedPane1, BorderLayout.CENTER);
				jTabbedPane1.setTabPlacement(JTabbedPane.LEFT);
				jTabbedPane1.setPreferredSize(new java.awt.Dimension(515, 437));
				{
					jPanel2 = new JPanel();
					jTabbedPane1.addTab(Application.language.getString("Info"), null, jPanel2, null);
					BorderLayout jPanel2Layout = new BorderLayout();
					jPanel2.setLayout(jPanel2Layout);
					{
						jScrollPane1 = new JScrollPane();
						jPanel2.add(jScrollPane1, BorderLayout.CENTER);
						jScrollPane1.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));
						{
							DefaultTableModel jTable1Model = new DefaultTableModel(new String[][] { { "" }, { "" } }, new String[] { "31" });
							for (int x = 30; x >= 0; x--) {
								jTable1Model.addColumn(x);
							}

							jByteTable = new JTable();
							jScrollPane1.setViewportView(jByteTable);
							jByteTable.setModel(jTable1Model);
							jByteTable.setBounds(12, 12, 562, 50);
						}
					}
					{
						jTypeLabel = new JLabel();
						jPanel2.add(jTypeLabel, BorderLayout.NORTH);
						jTypeLabel.setText("Type : ");
					}
				}
				{
					jPanel3 = new JPanel();
					jTabbedPane1.addTab(Application.language.getString("Field"), null, jPanel3, null);
					BorderLayout jPanel3Layout = new BorderLayout();
					jPanel3.setLayout(jPanel3Layout);
					{
						jScrollPane2 = new JScrollPane();
						jPanel3.add(jScrollPane2, BorderLayout.CENTER);
						{
							TableModel jTable2Model = new DefaultTableModel(new String[][] {}, new String[] { Application.language.getString("Field"), Application.language.getString("Value") });
							jFieldTable = new JTable();
							jScrollPane2.setViewportView(jFieldTable);
							jFieldTable.setModel(jTable2Model);
						}
					}
				}
			}
			// Application.commandReceiver.setCommandNoOfLine(2);
			String result;
			Application.sendCommand("info idt " + idtNo);
			String idtNoHex = String.format("0x%02x", idtNo);
			result = Application.commandReceiver.getCommandResult("IDT[" + idtNoHex + "]");

			Application.commandReceiver.clearBuffer();
			Application.sendCommand("x /8bx " + String.format("0x%08x", idtAddress + (idtNo * 8)));
			result = Application.commandReceiver.getCommandResult(String.format("%08x", idtAddress + (idtNo * 8)));
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
				jByteTable.setValueAt(value >> x & 1, 1, 31 - x);
			}

			for (int x = 32; x < 64; x++) {
				jByteTable.setValueAt(value >> x & 1, 0, 63 - x);
			}

			// parse descriptor
			if (bit[40] == 0 && bit[41] == 1 && bit[42] == 1 && bit[44] == 0) {
				jTypeLabel.setText("Type : Interrupt gate descriptor, value=0x" + Long.toHexString(value));
				parseInterruptGateDescriptor();
			} else if (bit[40] == 1 && bit[41] == 0 && bit[42] == 1 && bit[43] == 0 && bit[44] == 0) {
				jTypeLabel.setText("Type : Task gate descriptor, value=0x" + Long.toHexString(value));
				parseTaskGateDescriptor();
			} else if (bit[44] == 0 && bit[43] == 0 && bit[42] == 0 && bit[41] == 1 && bit[40] == 0) {
				jTypeLabel.setText("Type : LDT descriptor, value=0x" + Long.toHexString(value) + ", base=0x" + Long.toHexString(CommonLib.getInt(b[2], b[3], b[4], b[7])) + ", limit=0x"
						+ Long.toHexString(CommonLib.getShort(b[0], b[1])));
				parseLDT();
			} else if (bit[44] == 0 && bit[42] == 0 && bit[40] == 1) {
				jTypeLabel.setText("Type : TSS descriptor, value=0x" + Long.toHexString(value));
				this.removeAll();
				this.setLayout(new BorderLayout());
				this.add(new TSSPanel(application, 2, idtAddress, idtNo), BorderLayout.CENTER);
			}
			// end parse descriptor
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void parseInterruptGateDescriptor() {
		try {
			DefaultTableModel model = (DefaultTableModel) jFieldTable.getModel();
			long cs_selector = CommonLib.getLong(b[2], b[3], 0, 0, 0, 0, 0, 0);
			model.addRow(new String[] { "cs selector", "0x" + Long.toHexString(cs_selector) + " (0x" + Long.toHexString(cs_selector >> 3) + ")" });

			long offset = CommonLib.getLong(b[0], b[1], b[6], b[7], 0, 0, 0, 0);
			model.addRow(new String[] { "offset", "0x" + Long.toHexString(offset) });

			model.addRow(new String[] { "P", String.valueOf(bit[47]) });
			model.addRow(new String[] { "DPL", String.valueOf(bit[46] << 8 + bit[45]) });
			model.addRow(new String[] { "S", String.valueOf(bit[44]) });
			model.addRow(new String[] { "D", String.valueOf(bit[43]) });
			model.addRow(new String[] { "G", String.valueOf(bit[42]) });
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void parseTaskGateDescriptor() {
		try {
			DefaultTableModel model = (DefaultTableModel) jFieldTable.getModel();
			long tss_selector = CommonLib.getLong(b[2], b[3], 0, 0, 0, 0, 0, 0);
			model.addRow(new String[] { "tss selector", "0x" + Long.toHexString(tss_selector) + " (0x" + Long.toHexString(tss_selector >> 3) + ")" });

			model.addRow(new String[] { "P", String.valueOf(bit[47]) });
			model.addRow(new String[] { "DPL", String.valueOf(bit[46] << 8 + bit[45]) });
			model.addRow(new String[] { "S", String.valueOf(bit[44]) });
			model.addRow(new String[] { "G", String.valueOf(bit[42]) });
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void parseLDT() {
		try {
			DefaultTableModel model = (DefaultTableModel) jFieldTable.getModel();

			long base = CommonLib.getInt(b[2], b[3], b[4], b[7]);
			long limit = CommonLib.getShort(b[0], b[1]);
			model.addRow(new String[] { "base", "0x" + Long.toHexString(base) });
			model.addRow(new String[] { "limit", "0x" + Long.toHexString(limit) });
			model.addRow(new String[] { "dpl", "0x" + Long.toHexString(bit[46] << 1 + bit[45]) });
			model.addRow(new String[] { "p", "0x" + Long.toHexString(bit[47]) });
			model.addRow(new String[] { "avl", "0x" + Long.toHexString(bit[52]) });
			model.addRow(new String[] { "g", "0x" + Long.toHexString(bit[55]) });

			// parse each descriptor

			JScrollPane pane = new JScrollPane();
			jTabbedPane1.addTab(Application.language.getString("Descriptor"), null, pane, null);
			JTable table = new JTable();
			DefaultTableModel model2 = new DefaultTableModel(new String[][] {}, new String[] { "No.", "Type", "Value", "Base", "Limit", "A", "R/W", "C/E", "X", "S", "DPL", "P", "AVL", "D/B", "G" });

			if (limit > 1000) {
				limit = 1000;
			}
			int bytes[] = Application.getLinearMemory(base, (int) (limit + 1));

			for (int x = 0; x < limit; x += 8) {
				long value = CommonLib.getLong(bytes, x);
				LinkedHashMap<String, String> hm = DescriptorParser.parseDescriptor(value);
				model2.addRow(new String[] { String.valueOf(x), hm.get("Type"), hm.get("Value"), hm.get("Base"), hm.get("Limit"), hm.get("A"), hm.get("R/W"), hm.get("C/E"), hm.get("X"), hm.get("S"),
						hm.get("DPL"), hm.get("P"), hm.get("AVL"), hm.get("D/B"), hm.get("G") });
			}
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setModel(model2);
			table.getColumnModel().getColumn(2).setPreferredWidth(150);
			for (int x = 5; x <= 14; x++) {
				table.getColumnModel().getColumn(x).setPreferredWidth(50);
			}
			pane.setViewportView(table);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}