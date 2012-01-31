package peter;

import info.clearthought.layout.TableLayout;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import peter.architecture.IA32PageDirectory;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.petersoft.CommonLib;

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
public class TSSPanel extends JPanel {
	private JTable jTable1;
	private int gdtNo;
	private JPanel jPanel1;
	private JTabbedPane jTabbedPane1;
	private JTable jPageTableTable;
	private JTable jPageDirectoryTable;
	private JLabel jLabel1;
	private JTable jTSSTable;
	private JCheckBox jHideIfAddressIsZeroCheckBox;
	private ButtonGroup buttonGroup1;
	private JButton jButton19;
	private JButton jRefreshAddressTranslateTableButton;
	private JButton jButton18;
	private JButton jButton17;
	private JToolBar jToolBar3;
	private JTable jAddressTranslateTable2;
	private JScrollPane jScrollPane13;
	private JPanel jPanel22;
	private JTextField jAddressTextField;
	private JButton jRefreshAddressTranslateButton;
	private JPanel jPanel21;
	private JRadioButton jSearchAddressRadioButton3;
	private JRadioButton jSearchAddressRadioButton2;
	private JRadioButton jSearchAddressRadioButton1;
	private JPanel jPanel20;
	private JPanel jAddressTranslatePanel;
	private JScrollPane jScrollPane5;
	private JScrollPane jScrollPane4;
	private JScrollPane jScrollPane3;
	private JScrollPane jScrollPane2;
	private JTextField jLinearAddressTextField;
	private JPanel jPanel3;
	private JSplitPane jSplitPane2;
	private JPanel jPanel2;
	private JSplitPane jSplitPane1;
	private JLabel jTypeLabel;
	private JTable jTable2;
	private JScrollPane jScrollPane1;
	private int b[] = new int[8];
	private long value;
	private long bit[] = new long[64];
	private Application application;
	private int type;
	private long gdtAddress;
	private long ldtr;
	private long cr3;

	public TSSPanel(Application application, int type, long gdtAddress, int gdtNo) {
		this.application = application;
		this.type = type;
		this.gdtAddress = gdtAddress;
		this.gdtNo = gdtNo;

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
				{
					jSplitPane1 = new JSplitPane();
					jTabbedPane1.addTab("TSS", null, jSplitPane1, null);
					jSplitPane1.setDividerLocation(450);
					{
						jScrollPane2 = new JScrollPane();
						jSplitPane1.add(jScrollPane2, JSplitPane.LEFT);
						jScrollPane2.setPreferredSize(new java.awt.Dimension(449, 600));
						{
							TableModel jTable2Model = new DefaultTableModel(new String[][] {}, new String[] { MyLanguage.getString("Field"), MyLanguage.getString("Value") });
							jTable2 = new JTable();
							jScrollPane2.setViewportView(jTable2);
							jTable2.setModel(jTable2Model);
						}
					}
					{
						jScrollPane3 = new JScrollPane();
						jSplitPane1.add(jScrollPane3, JSplitPane.RIGHT);
						jScrollPane3.setPreferredSize(new java.awt.Dimension(457, 600));
						{
							TableModel jTSSTableModel = new DefaultTableModel(new String[][] {}, new String[] { MyLanguage.getString("Offset"), MyLanguage.getString("Field"),
									MyLanguage.getString("Value"), "" });
							jTSSTable = new JTable();
							jScrollPane3.setViewportView(jTSSTable);
							jTSSTable.setModel(jTSSTableModel);
							jTSSTable.getColumn("").setCellRenderer(new ButtonRenderer());
							jTSSTable.getColumn("").setCellEditor(new ButtonEditor(new JCheckBox()));
						}
					}
				}
				{
					jPanel1 = new JPanel();
					jTabbedPane1.addTab("Info", null, jPanel1, null);
					BorderLayout jPanel1Layout = new BorderLayout();
					jPanel1.setLayout(jPanel1Layout);
					{
						jScrollPane1 = new JScrollPane();
						jPanel1.add(jScrollPane1, BorderLayout.CENTER);
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
						jTypeLabel = new JLabel();
						jPanel1.add(jTypeLabel, BorderLayout.NORTH);
						jTypeLabel.setText("Type : ");
						jTypeLabel.setBounds(12, 12, 576, 14);
					}
				}
				{
					jPanel2 = new JPanel();
					jTabbedPane1.addTab("Page table", null, jPanel2, null);
					BorderLayout jPanel2Layout = new BorderLayout();
					jPanel2.setLayout(jPanel2Layout);
					{
						jPanel3 = new JPanel();
						FormLayout jPanel3Layout = new FormLayout("max(p;5dlu), max(p;5dlu), 80dlu, max(p;5dlu)", "max(p;5dlu), max(p;5dlu), max(p;5dlu), max(p;5dlu)");
						jPanel3.setLayout(jPanel3Layout);
						jPanel2.add(jPanel3, BorderLayout.NORTH);
						jPanel3.setPreferredSize(new java.awt.Dimension(915, 27));
						{
							jLabel1 = new JLabel();
							jPanel3.add(jLabel1, new CellConstraints("2, 1, 1, 1, default, default"));
							jLabel1.setText(MyLanguage.getString("Linear_address"));
							jLabel1.setBounds(691, 12, 143, 14);
						}
						{
							jLinearAddressTextField = new JTextField();
							jPanel3.add(jLinearAddressTextField, new CellConstraints("3, 1, 1, 1, default, default"));
							jPanel3.add(getJHideIfAddressIsZeroCheckBox(), new CellConstraints("4, 1, 1, 1, default, default"));
						}
					}
					{
						jSplitPane2 = new JSplitPane();
						jPanel2.add(jSplitPane2, BorderLayout.CENTER);
						jSplitPane2.setDividerLocation(400);
						{
							jScrollPane4 = new JScrollPane();
							jSplitPane2.add(jScrollPane4, JSplitPane.LEFT);
							jScrollPane4.setPreferredSize(new java.awt.Dimension(399, 573));
							{
								PageDirectoryTableModel jPageDirectoryTableModel = new PageDirectoryTableModel();
								jPageDirectoryTable = new JTable();
								jScrollPane4.setViewportView(jPageDirectoryTable);
								jPageDirectoryTable.setModel(jPageDirectoryTableModel);
								jPageDirectoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
								jPageDirectoryTable.addMouseListener(new MouseAdapter() {
									public void mouseClicked(MouseEvent evt) {
										jPageDirectoryTableMouseClicked(evt);
									}
								});
							}
						}
						{
							jScrollPane5 = new JScrollPane();
							jSplitPane2.add(jScrollPane5, JSplitPane.RIGHT);
							jScrollPane5.setPreferredSize(new java.awt.Dimension(507, 573));
							{
								PageTableTableModel jPageTableTableModel = new PageTableTableModel();
								jPageTableTable = new JTable();
								jScrollPane5.setViewportView(jPageTableTable);
								jPageTableTable.setModel(jPageTableTableModel);
								jPageTableTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
							}
						}
					}
				}
				{
					jAddressTranslatePanel = new JPanel();
					jTabbedPane1.addTab("Address  translate", null, jAddressTranslatePanel, null);
					BorderLayout jAddressTranslatePanelLayout = new BorderLayout();
					jAddressTranslatePanel.setLayout(jAddressTranslatePanelLayout);
					{
						jPanel20 = new JPanel();
						TableLayout jPanel20Layout = new TableLayout(new double[][] { { 8.0, 156.0, 13.0 }, { 25.0, 25.0, 25.0, 22.0, 37.0, TableLayout.FILL } });
						jPanel20Layout.setHGap(5);
						jPanel20Layout.setVGap(5);
						jAddressTranslatePanel.add(jPanel20, BorderLayout.WEST);
						jPanel20.setPreferredSize(new java.awt.Dimension(189, 629));
						jPanel20.setLayout(jPanel20Layout);
						{
							jSearchAddressRadioButton1 = new JRadioButton();
							jSearchAddressRadioButton1.setText(MyLanguage.getString("Virtual_address"));
							jPanel20.add(jSearchAddressRadioButton1, "1, 0, 2, 0");
							jSearchAddressRadioButton1.setSelected(true);
							getButtonGroup1().add(jSearchAddressRadioButton1);
						}
						{
							jSearchAddressRadioButton2 = new JRadioButton();
							jSearchAddressRadioButton2.setText(MyLanguage.getString("Linear_address"));
							jPanel20.add(jSearchAddressRadioButton2, "1, 1, 2, 1");
							getButtonGroup1().add(jSearchAddressRadioButton2);
						}
						{
							jSearchAddressRadioButton3 = new JRadioButton();
							jPanel20.add(jSearchAddressRadioButton3, "1, 2, 2, 2");
							jSearchAddressRadioButton3.setVisible(false);
						}
						{
							jPanel21 = new JPanel();
							jPanel20.add(jPanel21, "1, 4");
							{
								jRefreshAddressTranslateButton = new JButton();
								jRefreshAddressTranslateButton.setText(MyLanguage.getString("Convert"));
								jPanel21.add(jRefreshAddressTranslateButton);
								jRefreshAddressTranslateButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jRefreshAddressTranslateButtonActionPerformed(evt);
									}
								});
							}
						}
						{
							jAddressTextField = new JTextField();
							jPanel20.add(jAddressTextField, "1, 3");
							jAddressTextField.addKeyListener(new KeyAdapter() {
								public void keyTyped(KeyEvent evt) {
									jAddressTextFieldKeyTyped(evt);
								}
							});
						}
					}
					{
						jPanel22 = new JPanel();
						BorderLayout jPanel22Layout = new BorderLayout();
						jAddressTranslatePanel.add(jPanel22, BorderLayout.CENTER);
						jPanel22.setLayout(jPanel22Layout);
						{
							jScrollPane13 = new JScrollPane();
							jPanel22.add(jScrollPane13, BorderLayout.CENTER);
							jScrollPane13.setPreferredSize(new java.awt.Dimension(150, 32));
							{
								AddressTranslateTableModel addressTranslateTableModel = new AddressTranslateTableModel();
								jAddressTranslateTable2 = new JTable();
								jScrollPane13.setViewportView(jAddressTranslateTable2);
								jAddressTranslateTable2.setModel(addressTranslateTableModel);
								jAddressTranslateTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
							}
						}
					}
					{
						jToolBar3 = new JToolBar();
						jAddressTranslatePanel.add(jToolBar3, BorderLayout.NORTH);
						{
							jButton17 = new JButton();
							jToolBar3.add(jButton17);
							jButton17.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/disk.png")));
							jButton17.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButton17ActionPerformed(evt);
								}
							});
						}
						{
							jButton18 = new JButton();
							jToolBar3.add(jButton18);
							jButton18.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/excel.gif")));
							jButton18.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButton18ActionPerformed(evt);
								}
							});
						}
						{
							jRefreshAddressTranslateTableButton = new JButton();
							jToolBar3.add(jRefreshAddressTranslateTableButton);
							jRefreshAddressTranslateTableButton.setText("Refresh");
							jRefreshAddressTranslateTableButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/arrow_refresh.png")));
							jRefreshAddressTranslateTableButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jRefreshAddressTranslateTableButtonActionPerformed(evt);
								}
							});
						}
						{
							jButton19 = new JButton();
							jToolBar3.add(jButton19);
							jButton19.setText("Delete");
							jButton19.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/cross.png")));
							jButton19.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButton19ActionPerformed(evt);
								}
							});
						}
					}
				}
			}

			String result;
			if (Application.commandReceiver != null) {
				if (type == 0) {
					Application.sendCommand("info gdt " + gdtNo);
					String gdtNoHex = String.format("0x%02x", gdtNo);
					result = Application.commandReceiver.getCommandResult("GDT[" + gdtNoHex + "]");
				} else if (type == 1) {
					Application.sendCommand("info ldt " + gdtNo);
					String gdtNoHex = String.format("0x%02x", gdtNo);
					result = Application.commandReceiver.getCommandResult("LDT[" + gdtNoHex + "]");
				} else if (type == 2) {
					Application.sendCommand("info idt " + gdtNo);
					String gdtNoHex = String.format("0x%02x", gdtNo);
					result = Application.commandReceiver.getCommandResult("IDT[" + gdtNoHex + "]");
					System.out.println(result);
				}

				Application.commandReceiver.clearBuffer();
				Application.sendCommand("x /8bx " + String.format("0x%08x", gdtAddress + (gdtNo * 8)));
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
					jTypeLabel.setText("Type : LDT descriptor, value=0x" + Long.toHexString(value) + ", base=0x" + Long.toHexString(CommonLib.getInt(b[2], b[3], b[4], b[7]))
							+ ", limit=0x" + Long.toHexString(CommonLib.getShort(b[0], b[1])));
					parseLDT();
				} else if (bit[44] == 0 && bit[42] == 0 && bit[40] == 1) {
					jTypeLabel.setText("Type : TSS descriptor, value=0x" + Long.toHexString(value));
					parseTSSDescriptor();
				}
				// end parse descriptor
			}
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
			limit += 1; //Real TSS limit = TSS limit in descriptor + 1
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
			long realStartAddress = base;
			realStartAddressStr = String.format("%08x", realStartAddress);
			long realEndAddress = realStartAddress + totalByte3 * 8;
			realEndAddressStr = String.format("%08x", realEndAddress);

			String result2 = Application.commandReceiver.getCommandResult(realStartAddressStr, realEndAddressStr);
			String[] lines2 = result2.split("\n");

			int tssByte[] = new int[(int) limit];
			for (int y = 0; y < lines2.length; y++) {
				String byteStr[] = lines2[y].replaceFirst("^.*>:\t", "").split("\t");
				for (int x = 0; x < 8 && x < byteStr.length; x++) {
					tssByte[x + (y * 8)] = (byte) Long.parseLong(byteStr[x].substring(2), 16);
				}
			}

			//long tssValue = CommonLib.getLong(b, 0);

			DefaultTableModel tssModel = (DefaultTableModel) jTSSTable.getModel();
			tssModel.addRow(new String[] { "0", "link", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0], tssByte[1], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "4", "esp0", "0x" + Long.toHexString(CommonLib.getLong(tssByte[4], tssByte[5], tssByte[6], tssByte[7], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "8", "ss0", "0x" + Long.toHexString(CommonLib.getLong(tssByte[8], tssByte[9], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0xc", "esp1", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0xc], tssByte[0xd], tssByte[0xe], tssByte[0xf], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x10", "ss1", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x10], tssByte[0x11], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x14", "esp2", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x14], tssByte[0x15], tssByte[0x16], tssByte[0x17], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x18", "ss2", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x18], tssByte[0x19], 0, 0, 0, 0, 0, 0)) });
			cr3 = CommonLib.getLong(tssByte[0x1c], tssByte[0x1d], tssByte[0x1e], tssByte[0x1f], 0, 0, 0, 0);
			tssModel.addRow(new String[] { "0x1c", "cr3", "0x" + Long.toHexString(cr3), "dump" });
			tssModel.addRow(new String[] { "0x20", "eip", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x20], tssByte[0x21], tssByte[0x22], tssByte[0x23], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x24", "eflags", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x24], tssByte[0x25], tssByte[0x26], tssByte[0x27], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x28", "eax", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x28], tssByte[0x29], tssByte[0x2a], tssByte[0x2b], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x2c", "ecx", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x2c], tssByte[0x2d], tssByte[0x2e], tssByte[0x2f], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x30", "edx", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x30], tssByte[0x31], tssByte[0x32], tssByte[0x33], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x34", "ebx", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x34], tssByte[0x35], tssByte[0x36], tssByte[0x37], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x38", "esp", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x38], tssByte[0x39], tssByte[0x3a], tssByte[0x3b], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x3c", "ebp", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x3c], tssByte[0x3d], tssByte[0x3e], tssByte[0x3f], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x40", "esi", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x40], tssByte[0x41], tssByte[0x42], tssByte[0x43], 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x44", "edi", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x44], tssByte[0x45], tssByte[0x45], tssByte[0x47], 0, 0, 0, 0)) });

			tssModel.addRow(new String[] { "0x48", "es", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x48], tssByte[0x49], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x4c", "cs", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x4c], tssByte[0x4d], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x50", "ss", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x50], tssByte[0x51], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x54", "ds", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x54], tssByte[0x55], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x58", "fs", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x58], tssByte[0x59], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x5c", "gs", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x5c], tssByte[0x5d], 0, 0, 0, 0, 0, 0)) });
			tssModel.addRow(new String[] { "0x60", "ldtr", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x60], tssByte[0x61], 0, 0, 0, 0, 0, 0)) });
			ldtr = CommonLib.getLong(tssByte[0x60], tssByte[0x61], 0, 0, 0, 0, 0, 0);
			tssModel.addRow(new String[] { "0x64", "T", "0x" + Long.toHexString(CommonLib.getBit(tssByte[0x64], 0)) });
			tssModel.addRow(new String[] { "0x66", "iobp offset", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x66], tssByte[0x67], 0, 0, 0, 0, 0, 0)) });

			updatePageTable(cr3);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void updatePageTable(long pageDirectoryBaseAddress) {
		this.jLinearAddressTextField.setText("0x" + Long.toHexString(pageDirectoryBaseAddress));
		Vector<IA32PageDirectory> ia32_pageDirectories = new Vector<IA32PageDirectory>();
		try {
			// commandReceiver.setCommandNoOfLine(512);
			Application.sendCommand("xp /4096bx " + pageDirectoryBaseAddress);
			float totalByte2 = 4096 - 1;
			totalByte2 = totalByte2 / 8;
			int totalByte3 = (int) Math.floor(totalByte2);
			String realEndAddressStr;
			String realStartAddressStr;
			long realStartAddress = pageDirectoryBaseAddress;
			realStartAddressStr = String.format("%08x", realStartAddress);
			long realEndAddress = realStartAddress + totalByte3 * 8;
			realEndAddressStr = String.format("%08x", realEndAddress);
			String result = Application.commandReceiver.getCommandResult(realStartAddressStr, realEndAddressStr);
			if (result != null) {
				String[] lines = result.split("\n");
				DefaultTableModel model = (DefaultTableModel) jPageDirectoryTable.getModel();
				while (model.getRowCount() > 0) {
					model.removeRow(0);
				}
				// jStatusProgressBar.setMaximum(lines.length - 1);

				for (int y = 0; y < lines.length; y++) {
					// jStatusProgressBar.setValue(y);
					String[] b = lines[y].replaceFirst("^.*:", "").trim().split("\t");

					for (int z = 0; z < 2; z++) {
						try {
							int bytes[] = new int[4];
							for (int x = 0; x < 4; x++) {
								bytes[x] = CommonLib.string2decimal(b[x + z * 4].substring(2).trim()).intValue();
							}
							long value = CommonLib.getInt(bytes, 0);
							// "No.", "PT base", "AVL", "G",
							// "D", "A", "PCD", "PWT",
							// "U/S", "W/R", "P"

							long baseL = value & 0xfffff000;
							// if (baseL != 0) {
							String base = "0x" + Long.toHexString(baseL);
							String avl = String.valueOf((value >> 9) & 3);
							String g = String.valueOf((value >> 8) & 1);
							String d = String.valueOf((value >> 6) & 1);
							String a = String.valueOf((value >> 5) & 1);
							String pcd = String.valueOf((value >> 4) & 1);
							String pwt = String.valueOf((value >> 3) & 1);
							String us = String.valueOf((value >> 2) & 1);
							String wr = String.valueOf((value >> 1) & 1);
							String p = String.valueOf((value >> 0) & 1);

							ia32_pageDirectories.add(new IA32PageDirectory(base, avl, g, d, a, pcd, pwt, us, wr, p));

							model.addRow(new String[] { String.valueOf(y * 2 + z), base, avl, g, d, a, pcd, pwt, us, wr, p });
							// }
						} catch (Exception ex) {
						}
					}
					// jStatusLabel.setText("Updating page table " + (y + 1) +
					// "/" + lines.length);
				}
				jPageDirectoryTable.setModel(model);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void jDumpPageDirectoryButtonActionPerformed(ActionEvent evt) {
		System.out.println("jDumpPageDirectoryButton.actionPerformed, event=" + evt);
	}

	private void jPageDirectoryTableMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			// jStatusProgressBar.setValue(0);
			String pageTableAddress = jPageDirectoryTable.getValueAt(jPageDirectoryTable.getSelectedRow(), 1).toString();

			// commandReceiver.setCommandNoOfLine(512);
			Application.sendCommand("xp /4096bx " + pageTableAddress);

			float totalByte2 = 4096 - 1;
			totalByte2 = totalByte2 / 8;
			int totalByte3 = (int) Math.floor(totalByte2);
			String realEndAddressStr;
			String realStartAddressStr;
			String baseAddress = pageTableAddress;
			long realStartAddress = CommonLib.string2decimal(baseAddress);

			realStartAddressStr = String.format("%08x", realStartAddress);
			long realEndAddress = realStartAddress + totalByte3 * 8;
			realEndAddressStr = String.format("%08x", realEndAddress);

			String result = Application.commandReceiver.getCommandResult(realStartAddressStr, realEndAddressStr);
			String[] lines = result.split("\n");
			DefaultTableModel model = (DefaultTableModel) jPageTableTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			for (int y = 0; y < lines.length; y++) {
				// jStatusProgressBar.setValue(y * 100 / lines.length);
				String[] b = lines[y].replaceFirst("^.*:", "").trim().split("\t");

				for (int z = 0; z < 2; z++) {
					try {
						int bytes[] = new int[4];
						for (int x = 0; x < 4; x++) {
							bytes[x] = CommonLib.string2decimal(b[x + z * 4].substring(2).trim()).intValue();
						}
						long value = CommonLib.getInt(bytes, 0);
						// "No.", "PT base", "AVL", "G",
						// "D", "A", "PCD", "PWT",
						// "U/S", "W/R", "P"

						String base = "0x" + Long.toHexString(CommonLib.getValue(value, 12, 31) << 12);
						String avl = String.valueOf((value >> 9) & 3);
						String g = String.valueOf((value >> 8) & 1);
						String pat = String.valueOf((value >> 7) & 1);
						String d = String.valueOf((value >> 6) & 1);
						String a = String.valueOf((value >> 5) & 1);
						String pcd = String.valueOf((value >> 4) & 1);
						String pwt = String.valueOf((value >> 3) & 1);
						String us = String.valueOf((value >> 2) & 1);
						String wr = String.valueOf((value >> 1) & 1);
						String p = String.valueOf((value >> 0) & 1);

						model.addRow(new String[] { String.valueOf(y * 2 + z), base, avl, g, pat, d, a, pcd, pwt, us, wr, p });
					} catch (Exception ex) {
					}
				}

				jPageTableTable.setModel(model);
			}
		}
	}

	class ButtonRenderer extends JButton implements TableCellRenderer {
		public ButtonRenderer() {
			setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			if (table.getValueAt(row, 3) == null || table.getValueAt(row, 3).equals("")) {
				return null;
			}
			if (isSelected) {
				setForeground(table.getSelectionForeground());
				setBackground(UIManager.getColor("Button.background"));
			} else {
				setForeground(table.getForeground());
				setBackground(UIManager.getColor("Button.background"));
			}

			setText((value == null) ? "" : value.toString());
			return this;
		}
	}

	class ButtonEditor extends DefaultCellEditor {
		protected JButton button;
		private boolean isPushed;
		long cr3;

		public ButtonEditor(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
				}
			});
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			if (table.getValueAt(row, 3) == null || table.getValueAt(row, 3).equals("")) {
				return null;
			}
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());
			} else {
				button.setForeground(table.getForeground());
				button.setBackground(table.getBackground());
			}

			cr3 = CommonLib.string2decimal(table.getValueAt(row, 2).toString());

			button.setText((value == null) ? "" : value.toString());
			isPushed = true;
			return button;
		}

		public Object getCellEditorValue() {
			if (isPushed) {
				application.jDumpPageDirectoryAddressTextField.setText("0x" + Long.toHexString(cr3));
				application.updatePageTable(cr3);
				application.jTabbedPane2.setSelectedIndex(2);
			}
			isPushed = false;
			return button.getText();
		}

		public boolean stopCellEditing() {
			isPushed = false;
			return super.stopCellEditing();
		}

		protected void fireEditingStopped() {
			super.fireEditingStopped();
		}
	}

	private void jRefreshAddressTranslateButtonActionPerformed(ActionEvent evt) {
		AddressTranslateTableModel model = (AddressTranslateTableModel) this.jAddressTranslateTable2.getModel();

		if (jSearchAddressRadioButton1.isSelected()) {
			if (!this.jAddressTextField.getText().contains(":") || this.jAddressTextField.getText().replaceAll("[^:]", "").length() != 1) {
				JOptionPane.showMessageDialog(this, "Error, please input <segment selector>:<offset>\n\ne.g. : 0x10:0x12345678", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Long segSelector = CommonLib.string2decimal(this.jAddressTextField.getText().split(":")[0]);
			Long address = CommonLib.string2decimal(this.jAddressTextField.getText().split(":")[1]);

			// for (int x = 0; x < model.getRowCount(); x++) {
			// if (model.searchType.get(x).equals(1) &&
			// model.searchSegSelector.get(x).equals(segSelector) &&
			// model.searchAddress.get(x).equals(address)) {
			// return;
			// }
			// }

			model.searchType.add(1);
			model.searchSegSelector.add(segSelector);
			model.searchAddress.add(address);

			model.virtualAddress.add(address);
			long segNo = segSelector >> 3;
			model.segNo.add(segNo);

			// read GDT descriptor
			int descriptor[] = PeterBochsCommonLib.getMemoryFromBochs(ldtr + (segNo * 8), 8);
			long baseAddress = CommonLib.getLong(descriptor[2], descriptor[3], descriptor[4], descriptor[7], 0, 0, 0, 0);
			long linearAddress = baseAddress + address;
			model.baseAddress.add(baseAddress);
			model.linearAddress.add(linearAddress);

			long pdNo = CommonLib.getValue(linearAddress, 31, 22);
			model.pdNo.add(pdNo);
			int pdeBytes[] = PeterBochsCommonLib.getMemoryFromBochs(cr3 + (pdNo * 4), 4);
			long pde = CommonLib.getInt(pdeBytes, 0);
			model.pde.add(pde);

			long ptNo = CommonLib.getValue(linearAddress, 21, 12);
			model.ptNo.add(ptNo);
			long pageTableBaseAddress = pde & 0xfffff000;
			int pteBytes[] = PeterBochsCommonLib.getMemoryFromBochs(pageTableBaseAddress + (ptNo * 4), 4);
			long pte = CommonLib.getInt(pteBytes, 0);
			long pagePhysicalAddress = pte & 0xfffff000;
			model.pte.add(pte);

			long physicalAddress = pagePhysicalAddress + CommonLib.getValue(linearAddress, 11, 0);
			model.physicalAddress.add(physicalAddress);
			int bytesAtPhysicalAddress[] = PeterBochsCommonLib.getMemoryFromBochs(physicalAddress, 8);
			model.bytes.add(PeterBochsCommonLib.convertToString(bytesAtPhysicalAddress));

			model.fireTableDataChanged();
		} else if (jSearchAddressRadioButton2.isSelected()) {
			// for (int x = 0; x < model.getRowCount(); x++) {
			// if (model.searchType.get(x).equals(2) &&
			// model.searchAddress.get(x).equals(CommonLib.string2decimal(this.jAddressTextField.getText())))
			// {
			// return;
			// }
			// }
			Long address = CommonLib.string2decimal(this.jAddressTextField.getText());

			model.searchType.add(2);
			model.searchAddress.add(address);

			long baseAddress = 0;
			long linearAddress = baseAddress + address;
			model.baseAddress.add(baseAddress);
			model.linearAddress.add(linearAddress);

			long pdNo = CommonLib.getValue(linearAddress, 31, 22);
			System.out.println(linearAddress + "==" + pdNo);
			model.pdNo.add(pdNo);
			int pdeBytes[] = PeterBochsCommonLib.getMemoryFromBochs(cr3 + (pdNo * 4), 4);
			long pde = CommonLib.getInt(pdeBytes, 0);
			model.pde.add(pde);

			long ptNo = CommonLib.getValue(linearAddress, 21, 12);
			model.ptNo.add(ptNo);
			long pageTableBaseAddress = pde & 0xfffff000;
			int pteBytes[] = PeterBochsCommonLib.getMemoryFromBochs(pageTableBaseAddress + (ptNo * 4), 4);
			long pte = CommonLib.getInt(pteBytes, 0);
			long pagePhysicalAddress = pte & 0xfffff000;
			model.pte.add(pte);

			long physicalAddress = pagePhysicalAddress + CommonLib.getValue(linearAddress, 11, 0);
			model.physicalAddress.add(physicalAddress);
			int bytesAtPhysicalAddress[] = PeterBochsCommonLib.getMemoryFromBochs(physicalAddress, 8);
			model.bytes.add(PeterBochsCommonLib.convertToString(bytesAtPhysicalAddress));

			model.fireTableDataChanged();
		} else if (jSearchAddressRadioButton3.isSelected()) {
			for (int x = 0; x < model.getRowCount(); x++) {
				if (model.searchType.get(x).equals(3) && model.searchAddress.get(x).equals(CommonLib.string2decimal(this.jAddressTextField.getText()))) {
					return;
				}
			}
			Long addr = CommonLib.string2decimal(this.jAddressTextField.getText());
			model.searchType.add(3);
			model.searchSegSelector.add(0L);
			model.searchAddress.add(addr);

			model.virtualAddress.add(0L);
			model.segNo.add(0L);
			model.linearAddress.add(0L);
			model.pdNo.add(0L);
			model.ptNo.add(0L);
			model.physicalAddress.add(0L);
			model.bytes.add("");

			model.fireTableDataChanged();
		}
	}

	private void jAddressTextFieldKeyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == '\n') {
			jRefreshAddressTranslateButtonActionPerformed(null);
		}
	}

	private void jButton17ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!PeterBochsCommonLib.saveImage(jAddressTranslateTable2, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void jButton18ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			PeterBochsCommonLib.exportTableModelToExcel(file, this.jAddressTranslateTable2.getModel(), String.valueOf(cr3));
		}
	}

	private void jRefreshAddressTranslateTableButtonActionPerformed(ActionEvent evt) {
		AddressTranslateTableModel model = (AddressTranslateTableModel) this.jAddressTranslateTable2.getModel();
		for (int x = 0; x < model.getRowCount(); x++) {
			if (model.searchType.get(x).equals(1)) {
				model.segNo.set(x, model.searchSegSelector.get(x) >> 3);
				model.virtualAddress.set(x, model.searchAddress.get(x));

				long gdtBase = PeterBochsCommonLib.getPhysicalAddress(cr3, ldtr);
				System.out.println("gdtBase=" + Long.toHexString(gdtBase));
				Application.commandReceiver.clearBuffer();
				gdtBase += model.segNo.get(x) * 8;
				Application.sendCommand("xp /8bx " + gdtBase);
				String result = Application.commandReceiver.getCommandResult(String.format("%08x", gdtBase));

				int bytes[] = new int[8];
				String[] b = result.replaceFirst("^.*:", "").split("\t");
				for (int y = 1; y <= 8; y++) {
					bytes[y - 1] = CommonLib.string2decimal(b[y]).intValue();
				}

				Long gdtDescriptor = CommonLib.getLong(bytes, 0);
				System.out.println(Long.toHexString(gdtDescriptor));
				long base = CommonLib.getLong(bytes[2], bytes[3], bytes[4], bytes[7], 0, 0, 0, 0);
				System.out.println(Long.toHexString(base));

				model.linearAddress.set(x, base + model.searchAddress.get(x));
			}
		}
		model.fireTableDataChanged();
	}

	private void jButton19ActionPerformed(ActionEvent evt) {
		int rows[] = jAddressTranslateTable2.getSelectedRows();
		AddressTranslateTableModel model = (AddressTranslateTableModel) this.jAddressTranslateTable2.getModel();
		model.removeRow(rows);
	}

	private ButtonGroup getButtonGroup1() {
		if (buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
		}
		return buttonGroup1;
	}

	private JCheckBox getJHideIfAddressIsZeroCheckBox() {
		if (jHideIfAddressIsZeroCheckBox == null) {
			jHideIfAddressIsZeroCheckBox = new JCheckBox();
			jHideIfAddressIsZeroCheckBox.setText("Hide if address = 0");
			jHideIfAddressIsZeroCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jHideIfAddressIsZeroCheckBoxActionPerformed(evt);
				}
			});
		}
		return jHideIfAddressIsZeroCheckBox;
	}

	private void jHideIfAddressIsZeroCheckBoxActionPerformed(ActionEvent evt) {
		((PageDirectoryTableModel) jPageDirectoryTable.getModel()).setShowZeroAddress(!jHideIfAddressIsZeroCheckBox.isSelected());
		((PageTableTableModel) jPageTableTable.getModel()).setShowZeroAddress(!jHideIfAddressIsZeroCheckBox.isSelected());
	}
}