package peter;

import info.clearthought.layout.TableLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ButtonGroup;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.ini4j.Wini;

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
public class Application extends javax.swing.JFrame {
	private JMenuItem aboutUsMenuItem;
	private JPanel jPanel8;
	private JButton jStepBochsButton;
	private JMenu jMenu5;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JTabbedPane jTabbedPane1;
	private JHexTable jHexTable1;
	private JEditorPane jBochsEditorPane;
	public static CommandReceiver commandReceiver;

	public JEditorPane getjBochsEditorPane() {
		return jBochsEditorPane;
	}

	private JSplitPane jSplitPane1;
	private JRegisterPanel jRegisterPanel1;
	private JMenuItem runBochsMenuItem;
	private JSeparator jSeparator1;
	private JMenuItem stopBochsMenuItem;
	private JMenuItem startBochsMenuItem;
	private JMenu jMenu4;
	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	public JButton jRunBochsButton;
	private JButton jStopBochsButton;
	private JButton jStartBochButton;
	private JToolBar jToolBar1;
	private JPanel jPanel7;
	private JPanel jPanel6;
	private JPanel jPanel5;
	private JTabbedPane jTabbedPane3;
	private JMenuItem pauseBochsMenuItem;
	private JPanel jPanel3;
	private JTabbedPaneWithCloseIcons jTabbedPane2;
	private JButton jBochsCommandButton;
	private JTextField jBochsCommandTextField;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JTable jInstructionTable;
	private JScrollPane jScrollPane5;
	private JScrollPane jScrollPane4;
	private JComboBox jMemoryAddressComboBox;
	private JButton jDeleteBreakpointButton;
	private JPanel jPanel12;
	private JTable jBreakpointTable;
	private JButton jDisableBreakpointButton;
	private JButton jEnableBreakpointButton;
	private JButton jSaveBreakpointButton;
	private JButton jAddBreakpointButton;
	private JButton jRefreshBreakpointButton;
	private JScrollPane jScrollPane9;
	private JPanel jPanel4;
	private JList jPauseHistoryList;
	private JScrollPane jScrollPane6;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JScrollPane jScrollPane8;
	private JScrollPane jScrollPane7;
	private JTable jPageTableTable;
	private JTable jPageDirectoryTable;
	private JPanel jPanel11;
	private JTable jGDTTable;
	private JScrollPane jScrollPane3;
	private JMenuItem jUpdateBochsStatusMenuItem;
	private JButton jGOMemoryButton;
	private JPanel jPanel9;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;
	private static BufferedWriter commandOutputStream;
	private Process p;
	private JSplitPane jSplitPane2;
	private JProgressBar jStatusProgressBar;
	private JPanel jStatusPanel;
	private JButton jUpdateBochsButton;
	private JLabel jStatusLabel;
	private JButton jDisassembleButton;
	private JComboBox jInstructionComboBox;
	private JPanel jInstructionControlPanel;
	private JPanel jPanel10;
	private JButton jLoadBreakpointButton;
	private int commandHistoryIndex;
	private JScrollPane jScrollPane10;
	private ButtonGroup buttonGroup1;
	private JRadioButton jHexRadioButton;
	private JRadioButton jDecRadioButton;
	private JRadioButton jOctRadioButton1;
	private JRadioButton jBinaryRadioButton;
	private JTable jLDTTable;
	private JScrollPane jScrollPane11;
	private JTable jIDTTable;
	private JTable jAddressTranslateTable;
	private JScrollPane jTableTranslateScrollPane;
	Vector<HashMap> bochsCommandLength = XMLHelper.xmltoVector(getClass().getClassLoader().getResourceAsStream("peter/bochsCommandLength.xml"), "/bochsCommandLength");
	Wini ini;
	// private static String bochsPath = "bochs";
	private static String[] arguments;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			if (args[0].equals("-version") || args[0].equals("-v")) {
				System.out.println(Global.version);
				return;
			}
		}
		arguments = args;
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Application inst = new Application();
				inst.setVisible(true);
			}
		});
	}

	public Application() {
		super();
		try {
			File iniFile = new File("setting.ini");
			if (!iniFile.exists()) {
				iniFile.createNewFile();
			}
			ini = new Wini(iniFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		initGUI();
	}

	private void startBochs() {
		try {
			this.enableAllButtons(true);
			jRunBochsButton.setText("Run Bochs");
			jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/resultset_next.png")));

			if (p != null) {
				p.destroy();
			}
			ProcessBuilder pb;
			if (arguments.length == 0) {
				pb = new ProcessBuilder("bochs", "-q");
			} else {
				pb = new ProcessBuilder(arguments);
			}
			// pb.directory(new File("test"));
			pb.redirectErrorStream(true);

			p = pb.start();
			InputStream is = p.getInputStream();
			commandReceiver = new CommandReceiver(is, this);
			new Thread(commandReceiver).start();
			commandOutputStream = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
			sendCommand("6");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Unable to start bochs");
			ex.printStackTrace();
		}
	}

	private void stopBochs() {
		try {
			this.enableAllButtons(false);
			jRunBochsButton.setText("Run Bochs");
			jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/resultset_next.png")));

			ProcessBuilder pb = new ProcessBuilder("killall", "-9", "bochs");
			pb.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void pauseBochs() {
		try {
			jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/resultset_next.png")));
			ProcessBuilder pb = new ProcessBuilder("killall", "-2", "bochs");
			pb.start();

			// sendCommand2(String.valueOf((byte) 0x3));
			// p.getOutputStream().write(new byte[]{3});
			// p.getOutputStream().flush();

			// new Thread() {
			// public void run() {
			updateBochsStatus();
			// }
			// }.start();

			jRunBochsButton.setText("Run Bochs");
			// jStepBochsButton.setEnabled(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void runBochs() {
		try {
			jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/tag.png")));
			sendCommand("c");
			commandReceiver.setRunning(true);
			jRunBochsButton.setText("Pause Bochs");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void initGUI() {
		try {
			{
				this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				this.setTitle("Peter-Bochs Debugger");
				this.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent evt) {
						thisWindowClosing(evt);
					}
				});
				{
					jSplitPane2 = new JSplitPane();
					getContentPane().add(jSplitPane2, BorderLayout.CENTER);
					jSplitPane2.setPreferredSize(new java.awt.Dimension(1013, 787));
					jSplitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);
					{
						jSplitPane1 = new JSplitPane();
						jSplitPane2.add(jSplitPane1, JSplitPane.TOP);
						jSplitPane1.setDividerLocation(400);
						{
							jTabbedPane1 = new JTabbedPane();
							jSplitPane1.add(jTabbedPane1, JSplitPane.RIGHT);
							{
								jPanel10 = new JPanel();
								BorderLayout jPanel10Layout = new BorderLayout();
								jPanel10.setLayout(jPanel10Layout);
								jTabbedPane1.addTab("Instruction", null, jPanel10, null);
								jPanel10.setPreferredSize(new java.awt.Dimension(604, 452));
								{
									jScrollPane5 = new JScrollPane();
									jPanel10.add(jScrollPane5, BorderLayout.CENTER);
									{
										TableModel jInstructionTableModel = new DefaultTableModel(new String[][] {}, new String[] { "Address", "Instruction" });
										jInstructionTable = new JTable();
										jScrollPane5.setViewportView(jInstructionTable);
										jInstructionTable.setModel(jInstructionTableModel);
									}
								}
								{
									jInstructionControlPanel = new JPanel();
									jPanel10.add(jInstructionControlPanel, BorderLayout.NORTH);
									{
										ComboBoxModel jInstructionComboBoxModel = new DefaultComboBoxModel(new String[] {});
										jInstructionComboBox = new JComboBox();
										jInstructionControlPanel.add(jInstructionComboBox);
										jInstructionComboBox.setModel(jInstructionComboBoxModel);
										jInstructionComboBox.setEditable(true);
									}
									{
										jDisassembleButton = new JButton();
										jInstructionControlPanel.add(jDisassembleButton);
										jDisassembleButton.setText("Disassemble");
										jDisassembleButton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent evt) {
												jDisassembleButtonActionPerformed(evt);
											}
										});
									}
								}
							}
							{
								jPanel4 = new JPanel();
								jTabbedPane1.addTab("Breakpoint", null, jPanel4, null);
								BorderLayout jPanel4Layout = new BorderLayout();
								jPanel4.setLayout(jPanel4Layout);
								{
									jScrollPane9 = new JScrollPane();
									jPanel4.add(jScrollPane9, BorderLayout.CENTER);
									{
										TableModel jTable1Model = new DefaultTableModel(new String[][] {}, new String[] { "Num", "Type", "Disp Enb Address" });
										jBreakpointTable = new JTable();
										jScrollPane9.setViewportView(jBreakpointTable);
										jBreakpointTable.setModel(jTable1Model);
									}
								}
								{
									jPanel12 = new JPanel();
									jPanel4.add(jPanel12, BorderLayout.SOUTH);
									{
										jAddBreakpointButton = new JButton();
										jPanel12.add(jAddBreakpointButton);
										jAddBreakpointButton.setText("Add");
										jAddBreakpointButton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent evt) {
												jAddBreakpointButtonActionPerformed(evt);
											}
										});
									}
									{
										jDeleteBreakpointButton = new JButton();
										jPanel12.add(jDeleteBreakpointButton);
										jDeleteBreakpointButton.setText("Del");
										jDeleteBreakpointButton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent evt) {
												jDeleteBreakpointButtonActionPerformed(evt);
											}
										});
									}
									{
										jRefreshBreakpointButton = new JButton();
										jPanel12.add(jRefreshBreakpointButton);
										jRefreshBreakpointButton.setText("Refresh");
										jRefreshBreakpointButton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent evt) {
												jRefreshBreakpointButtonActionPerformed(evt);
											}
										});
									}
									{
										jEnableBreakpointButton = new JButton();
										jPanel12.add(jEnableBreakpointButton);
										jEnableBreakpointButton.setText("Enable");
										jEnableBreakpointButton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent evt) {
												jEnableBreakpointButtonActionPerformed(evt);
											}
										});
									}
									{
										jDisableBreakpointButton = new JButton();
										jPanel12.add(jDisableBreakpointButton);
										jDisableBreakpointButton.setText("Disable");
										jDisableBreakpointButton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent evt) {
												jDisableBreakpointButtonActionPerformed(evt);
											}
										});
									}
									{
										jSaveBreakpointButton = new JButton();
										jPanel12.add(jSaveBreakpointButton);
										jSaveBreakpointButton.setText("Save");
										jSaveBreakpointButton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent evt) {
												jSaveBreakpointButtonActionPerformed(evt);
											}
										});
									}
									{
										jLoadBreakpointButton = new JButton();
										jPanel12.add(jLoadBreakpointButton);
										jLoadBreakpointButton.setText("Load");
										jLoadBreakpointButton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent evt) {
												jLoadBreakpointButtonActionPerformed(evt);
											}
										});
									}
								}
							}
							{
								jPanel1 = new JPanel();
								jTabbedPane1.addTab("Bochs", null, jPanel1, null);
								BorderLayout jPanel1Layout = new BorderLayout();
								jPanel1.setLayout(jPanel1Layout);
								{
									jScrollPane4 = new JScrollPane();
									jPanel1.add(jScrollPane4, BorderLayout.CENTER);
									{
										jBochsEditorPane = new JEditorPane();
										jScrollPane4.setViewportView(jBochsEditorPane);
									}
								}
								{
									jPanel2 = new JPanel();
									BorderLayout jPanel2Layout = new BorderLayout();
									jPanel2.setLayout(jPanel2Layout);
									jPanel1.add(jPanel2, BorderLayout.SOUTH);
									{
										jBochsCommandTextField = new JTextField();
										jPanel2.add(jBochsCommandTextField, BorderLayout.CENTER);
										jBochsCommandTextField.addKeyListener(new KeyAdapter() {
											public void keyPressed(KeyEvent evt) {
												jBochsCommandTextFieldKeyPressed(evt);
											}

											public void keyTyped(KeyEvent evt) {
												jBochsCommandTextFieldKeyTyped(evt);
											}
										});
									}
									{
										jBochsCommandButton = new JButton();
										jPanel2.add(jBochsCommandButton, BorderLayout.EAST);
										jBochsCommandButton.setText("Run");
										jBochsCommandButton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent evt) {
												jBochsCommandButtonActionPerformed(evt);
											}
										});
									}
								}
							}
						}
						{
							jTabbedPane3 = new JTabbedPane();
							jSplitPane1.add(jTabbedPane3, JSplitPane.LEFT);
							{
								jPanel8 = new JPanel();
								BorderLayout jPanel8Layout = new BorderLayout();
								jPanel8.setLayout(jPanel8Layout);
								jTabbedPane3.addTab("Memory", null, jPanel8, null);
								{
									jScrollPane2 = new JScrollPane();
									jPanel8.add(jScrollPane2, BorderLayout.CENTER);
									{
										jHexTable1 = new JHexTable();
										jHexTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
										for (int x = 1; x < 9; x++) {
											jHexTable1.getColumnModel().getColumn(x).setPreferredWidth(15);
										}
										jScrollPane2.setViewportView(jHexTable1);
										jHexTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
									}
								}
								{
									jPanel9 = new JPanel();
									FlowLayout jPanel9Layout = new FlowLayout();
									jPanel9.setLayout(jPanel9Layout);
									jPanel8.add(jPanel9, BorderLayout.NORTH);
									{
										ComboBoxModel jMemoryAddressComboBoxModel = new DefaultComboBoxModel(new String[] {});
										jMemoryAddressComboBox = new JComboBox();
										jPanel9.add(jMemoryAddressComboBox);
										jMemoryAddressComboBox.setModel(jMemoryAddressComboBoxModel);
										jMemoryAddressComboBox.setEditable(true);
										addMemoryAddressComboBox("0x00000000");
										Vector<HashMap> vector = XMLHelper.xmltoVector("memoryCombo.xml", "/address/record");
										for (int x = 0; x < vector.size(); x++) {
											addMemoryAddressComboBox(vector.get(x).get("address").toString());
										}
									}
									{
										jGOMemoryButton = new JButton();
										jPanel9.add(jGOMemoryButton);
										jGOMemoryButton.setText("Go");
										jGOMemoryButton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent evt) {
												jGOMemoryButtonActionPerformed(evt);
											}
										});
									}
									{
										jBinaryRadioButton = new JRadioButton();
										jPanel9.add(jBinaryRadioButton);
										jBinaryRadioButton.setText("2");
										jBinaryRadioButton.addItemListener(new ItemListener() {
											public void itemStateChanged(ItemEvent evt) {
												jBinaryRadioButtonItemStateChanged(evt);
											}
										});
										jBinaryRadioButton.addChangeListener(new ChangeListener() {
											public void stateChanged(ChangeEvent evt) {
												jBinaryRadioButtonStateChanged(evt);
											}
										});
										getButtonGroup1().add(jBinaryRadioButton);
									}
									{
										jOctRadioButton1 = new JRadioButton();
										jPanel9.add(jOctRadioButton1);
										jOctRadioButton1.setText("8");
										jOctRadioButton1.addItemListener(new ItemListener() {
											public void itemStateChanged(ItemEvent evt) {
												jOctRadioButton1ItemStateChanged(evt);
											}
										});
										jOctRadioButton1.addChangeListener(new ChangeListener() {
											public void stateChanged(ChangeEvent evt) {
												jOctRadioButton1StateChanged(evt);
											}
										});
										getButtonGroup1().add(jOctRadioButton1);
									}
									{
										jDecRadioButton = new JRadioButton();
										jPanel9.add(jDecRadioButton);
										jDecRadioButton.setText("10");
										jDecRadioButton.addItemListener(new ItemListener() {
											public void itemStateChanged(ItemEvent evt) {
												jDecRadioButtonItemStateChanged(evt);
											}
										});
										jDecRadioButton.addChangeListener(new ChangeListener() {
											public void stateChanged(ChangeEvent evt) {
												jDecRadioButtonStateChanged(evt);
											}
										});
										getButtonGroup1().add(jDecRadioButton);
									}
									{
										jHexRadioButton = new JRadioButton();
										jPanel9.add(jHexRadioButton);
										jHexRadioButton.setText("16");
										jHexRadioButton.setSelected(true);
										jHexRadioButton.addItemListener(new ItemListener() {
											public void itemStateChanged(ItemEvent evt) {
												jHexRadioButtonItemStateChanged(evt);
											}
										});
										jHexRadioButton.addChangeListener(new ChangeListener() {
											public void stateChanged(ChangeEvent evt) {
												jHexRadioButtonStateChanged(evt);
											}
										});
										getButtonGroup1().add(jHexRadioButton);
									}
								}
							}
							{
								jPanel5 = new JPanel();
								jTabbedPane3.addTab("GDT", null, jPanel5, null);
								BorderLayout jPanel5Layout = new BorderLayout();
								jPanel5.setLayout(jPanel5Layout);
								{
									jScrollPane3 = new JScrollPane();
									jPanel5.add(jScrollPane3, BorderLayout.CENTER);
									{
										JGDTTableModel jGDTTableModel = new JGDTTableModel();
										jGDTTable = new JTable();
										jGDTTable.setModel(jGDTTableModel);
										jScrollPane3.setViewportView(jGDTTable);
										jGDTTable.getColumnModel().getColumn(0).setMaxWidth(40);
										jGDTTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
										jGDTTable.addMouseListener(new MouseAdapter() {
											public void mouseClicked(MouseEvent evt) {
												jGDTTableMouseClicked(evt);
											}
										});

									}
								}
							}
							{
								jPanel6 = new JPanel();
								BorderLayout jPanel6Layout = new BorderLayout();
								jPanel6.setLayout(jPanel6Layout);
								jTabbedPane3.addTab("IDT", null, jPanel6, null);
								{
									jScrollPane10 = new JScrollPane();
									jPanel6.add(jScrollPane10, BorderLayout.CENTER);
									{
										JIDTTableModel jIDTTableModel = new JIDTTableModel();
										jIDTTable = new JTable();
										jIDTTable.setModel(jIDTTableModel);
										jScrollPane10.setViewportView(jIDTTable);
										jIDTTable.getColumnModel().getColumn(0).setMaxWidth(40);
										jIDTTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
									}
								}
							}
							{
								jPanel7 = new JPanel();
								BorderLayout jPanel7Layout = new BorderLayout();
								jPanel7.setLayout(jPanel7Layout);
								jTabbedPane3.addTab("LDT", null, jPanel7, null);
								{
									jScrollPane11 = new JScrollPane();
									jPanel7.add(jScrollPane11, BorderLayout.CENTER);
									{
										JLDTTableModel jLDTTableModel = new JLDTTableModel();
										jLDTTable = new JTable();
										jLDTTable.setModel(jLDTTableModel);
										jScrollPane11.setViewportView(jLDTTable);
										jLDTTable.getColumnModel().getColumn(0).setMaxWidth(40);
										jLDTTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
										jLDTTable.addMouseListener(new MouseAdapter() {
											public void mouseClicked(MouseEvent evt) {
												jLDTTableMouseClicked(evt);
											}
										});
									}
								}
							}
						}
					}
					{
						jTabbedPane2 = new JTabbedPaneWithCloseIcons();
						jSplitPane2.add(jTabbedPane2, JSplitPane.BOTTOM);
						{
							jScrollPane1 = new JScrollPane();
							jTabbedPane2.addTab("Register", null, jScrollPane1, null);
							{
								jRegisterPanel1 = new JRegisterPanel();
								jScrollPane1.setViewportView(jRegisterPanel1);
							}
						}
						{
							jPanel3 = new JPanel();
							jTabbedPane2.addTab("Bochs Control", null, jPanel3, null);
							TableLayout jPanel3Layout = new TableLayout(new double[][] { { TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL },
									{ 24.0, TableLayout.FILL } });
							jPanel3Layout.setHGap(5);
							jPanel3Layout.setVGap(5);
							jPanel3.setLayout(jPanel3Layout);
							{
								jLabel3 = new JLabel();
								jPanel3.add(jLabel3, "0, 0");
								jLabel3.setText("Pause History");
							}
							{
								jScrollPane6 = new JScrollPane();
								jPanel3.add(jScrollPane6, "0, 1");
								{
									ListModel jPauseHistoryListModel = new DefaultComboBoxModel(new String[] {});
									jPauseHistoryList = new JList();
									jScrollPane6.setViewportView(jPauseHistoryList);
									jPauseHistoryList.setModel(jPauseHistoryListModel);
								}
							}
						}
						{
							jPanel11 = new JPanel();
							jTabbedPane2.addTab("Paging", null, jPanel11, null);
							jTabbedPane2.addTab("Table translate", null, getJTableTranslateScrollPane(), null);
							TableLayout jPanel11Layout = new TableLayout(new double[][] { { 475.0, TableLayout.FILL }, { 22.0, TableLayout.FILL } });
							jPanel11Layout.setHGap(5);
							jPanel11Layout.setVGap(5);
							jPanel11.setLayout(jPanel11Layout);
							{
								jScrollPane8 = new JScrollPane();
								jPanel11.add(jScrollPane8, "0, 1");
								{
									TableModel jPageDirectoryTableModel = new DefaultTableModel(new String[][] {}, new String[] { "No.", "PT base", "AVL", "G",
											"D", "A", "PCD", "PWT", "U/S", "W/R", "P" }) {
										public boolean isCellEditable(int row, int column) {
											return false;
										}
									};
									jPageDirectoryTable = new JTable();
									jScrollPane8.setViewportView(jPageDirectoryTable);
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
								jScrollPane7 = new JScrollPane();
								jPanel11.add(jScrollPane7, "1, 1");
								{
									TableModel jTable1Model = new DefaultTableModel(new String[][] {}, new String[] { "No.", "PT base", "AVL", "G", "PAT", "D",
											"A", "PCD", "PWT", "U/S", "W/R", "P" }) {
										public boolean isCellEditable(int row, int column) {
											return false;
										}
									};
									jPageTableTable = new JTable();
									jScrollPane7.setViewportView(jPageTableTable);
									jPageTableTable.setModel(jTable1Model);
									jPageTableTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
									jPageTableTable.addMouseListener(new MouseAdapter() {
										public void mouseClicked(MouseEvent evt) {
											jPageTableTableMouseClicked(evt);
										}
									});
								}
							}
							{
								jLabel1 = new JLabel();
								jPanel11.add(jLabel1, "0, 0");
								jLabel1.setText("Page Directory");
							}
							{
								jLabel2 = new JLabel();
								jPanel11.add(jLabel2, "1, 0");
								jLabel2.setText("Page Table");
							}
						}
					}
				}
			}
			{
				jToolBar1 = new JToolBar();
				getContentPane().add(jToolBar1, BorderLayout.NORTH);
				{
					jStartBochButton = new JButton();
					jToolBar1.add(jStartBochButton);
					jStartBochButton.setText("Start Bochs");
					jStartBochButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/accept.png")));
					jStartBochButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jStartBochButtonActionPerformed(evt);
						}
					});
				}
				{
					jStopBochsButton = new JButton();
					jToolBar1.add(jStopBochsButton);
					jStopBochsButton.setText("Stop Bochs");
					jStopBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/stop.png")));
					jStopBochsButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jStopBochsButtonActionPerformed(evt);
						}
					});
				}
				{
					jRunBochsButton = new JButton();
					jToolBar1.add(jRunBochsButton);
					jRunBochsButton.setText("Run Bochs");
					jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/resultset_next.png")));
					jRunBochsButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButton1ActionPerformed(evt);
						}
					});
				}
				{
					jStepBochsButton = new JButton();
					jToolBar1.add(jStepBochsButton);
					jStepBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/group.png")));
					jStepBochsButton.setText("Step");
					jStepBochsButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jStepBochsButtonActionPerformed(evt);
						}
					});
				}
				{
					jUpdateBochsButton = new JButton();
					jToolBar1.add(jUpdateBochsButton);
					jUpdateBochsButton.setEnabled(true);
					jUpdateBochsButton.setText("Update");
					jUpdateBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/arrow_refresh.png")));
					jUpdateBochsButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButton2ActionPerformed(evt);
						}
					});
				}
			}
			{
				jStatusPanel = new JPanel();
				BorderLayout jStatusPanelLayout = new BorderLayout();
				jStatusPanel.setLayout(jStatusPanelLayout);
				getContentPane().add(jStatusPanel, BorderLayout.SOUTH);
				{
					jStatusProgressBar = new JProgressBar();
					jStatusPanel.add(jStatusProgressBar, BorderLayout.CENTER);
				}
				{
					jStatusLabel = new JLabel();
					jStatusPanel.add(jStatusLabel, BorderLayout.EAST);
				}
			}
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("File");
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText("Exit");
						exitMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								exitMenuItemActionPerformed(evt);
							}
						});
					}
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("Bochs");
					{
						startBochsMenuItem = new JMenuItem();
						jMenu4.add(startBochsMenuItem);
						startBochsMenuItem.setText("Start Bochs");
						startBochsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								startBochsMenuItemActionPerformed(evt);
							}
						});
					}
					{
						stopBochsMenuItem = new JMenuItem();
						jMenu4.add(stopBochsMenuItem);
						stopBochsMenuItem.setText("Stop Bochs");
						stopBochsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								stopBochsMenuItemActionPerformed(evt);
							}
						});
					}
					{
						jSeparator1 = new JSeparator();
						jMenu4.add(jSeparator1);
					}
					{
						runBochsMenuItem = new JMenuItem();
						jMenu4.add(runBochsMenuItem);
						runBochsMenuItem.setText("Run Bochs");
						runBochsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								runBochsMenuItemActionPerformed(evt);
							}
						});
					}
					{
						pauseBochsMenuItem = new JMenuItem();
						jMenu4.add(pauseBochsMenuItem);
						pauseBochsMenuItem.setText("Pause Bochs");
						pauseBochsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								pauseBochsMenuItemActionPerformed(evt);
							}
						});
					}
					{
						jUpdateBochsStatusMenuItem = new JMenuItem();
						jMenu4.add(jUpdateBochsStatusMenuItem);
						jUpdateBochsStatusMenuItem.setText("Update Bochs Status");
						jUpdateBochsStatusMenuItem.setBounds(83, 86, 79, 20);
						jUpdateBochsStatusMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jUpdateBochsStatusMenuItemActionPerformed(evt);
							}
						});
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Help");
					{
						aboutUsMenuItem = new JMenuItem();
						jMenu5.add(aboutUsMenuItem);
						aboutUsMenuItem.setText("About Us");
						aboutUsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								aboutUsMenuItemActionPerformed(evt);
							}
						});
					}
				}
			}
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			setSize(screenSize.width * 2 / 3, screenSize.height * 4 / 5);

			int width = ini.get("window", "width", int.class);
			int height = ini.get("window", "height", int.class);
			if (width > 0 && height > 0) {
				setSize(width, height);
			}
			int x = ini.get("window", "x", int.class);
			int y = ini.get("window", "y", int.class);
			setLocation(x, y);

			int divX = ini.get("window", "divX", int.class);
			if (divX > 0) {
				jSplitPane1.setDividerLocation(divX);
			}

			int divY = ini.get("window", "divY", int.class);
			if (divY > 0) {
				jSplitPane2.setDividerLocation(divY);
			}
			// pack();

			startBochs();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(ERROR);
		}
	}

	private void jBochsCommandButtonActionPerformed(ActionEvent evt) {
		try {
			if (jBochsCommandTextField.getText().equals("clear")) {
				this.jBochsEditorPane.setText("");
			} else if (jBochsCommandTextField.getText().trim().equals("c")) {
				runBochs();
			} else if (jBochsCommandTextField.getText().trim().equals("q")) {
				stopBochs();
			} else {
				try {
					Vector<HashMap> vector = XMLHelper.xmltoVector("history.xml", "/history/record");
					HashMap<String, String> h = new HashMap<String, String>();
					h.put("command", jBochsCommandTextField.getText());
					vector.add(h);
					XMLHelper.vectorToXML("history.xml", "history", "record", vector);
				} catch (Exception ex2) {
				}
				commandReceiver.shouldShow = true;
				sendCommand(this.jBochsCommandTextField.getText());
				commandHistoryIndex = 0;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void jBochsCommandTextFieldKeyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == '\n') {
			this.jBochsEditorPane.setText("");
			jBochsCommandButtonActionPerformed(null);
			jBochsCommandTextField.setText("");
		}
	}

	private void startBochsMenuItemActionPerformed(ActionEvent evt) {
		startBochs();
	}

	private void stopBochsMenuItemActionPerformed(ActionEvent evt) {
		stopBochs();
	}

	private void runBochsMenuItemActionPerformed(ActionEvent evt) {
		runBochs();
	}

	private void pauseBochsMenuItemActionPerformed(ActionEvent evt) {
		pauseBochs();
	}

	private void jStartBochButtonActionPerformed(ActionEvent evt) {
		startBochs();
	}

	private void jStopBochsButtonActionPerformed(ActionEvent evt) {
		stopBochsMenuItemActionPerformed(null);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		if (jRunBochsButton.getText().equals("Run Bochs")) {
			jRunBochsButton.setText("Pause Bochs");
			runBochsMenuItemActionPerformed(null);
		} else {
			jRunBochsButton.setText("Run Bochs");
			pauseBochsMenuItemActionPerformed(null);
		}
	}

	public static void sendCommand(String command) {
		try {
			commandOutputStream.write(command + System.getProperty("line.separator"));
			commandOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendCommand2(String command) {
		try {
			p.getOutputStream().write(3);
			// commandOutputStream.write(3);
			// commandOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void aboutUsMenuItemActionPerformed(ActionEvent evt) {
		new JAboutUsDialog(this).setVisible(true);
	}

	private void jStepBochsButtonActionPerformed(ActionEvent evt) {
		try {
			sendCommand("s");
			updateBochsStatus();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void jGOMemoryButtonActionPerformed(ActionEvent evt) {
		updateMemory();

		addMemoryAddressComboBox(jMemoryAddressComboBox.getSelectedItem().toString());

		Vector<HashMap> v = new Vector<HashMap>();

		for (int x = 0; x < jMemoryAddressComboBox.getItemCount(); x++) {
			HashMap<String, String> h = new HashMap<String, String>();
			h.put("address", jMemoryAddressComboBox.getItemAt(x).toString());
			v.add(h);
		}
		XMLHelper.vectorToXML("memoryCombo.xml", "address", "record", v);
	}

	private void addMemoryAddressComboBox(String str) {
		for (int x = 0; x < jMemoryAddressComboBox.getItemCount(); x++) {
			if (jMemoryAddressComboBox.getItemAt(x).toString().trim().equals(str.trim())) {
				return;
			}
		}

		jMemoryAddressComboBox.addItem(str.trim());
	}

	private void jUpdateBochsStatusMenuItemActionPerformed(ActionEvent evt) {
		updateBochsStatus();
	}

	public void updateBochsStatus() {
		Thread updateThread = new Thread() {
			public void run() {
				enableAllButtons(false);

				updateRegister();

				updateMemory();

				// long instructionAddress =
				// CommonLib.decodeNumber(this.jInstructionComboBox.getName());
				// try {
				// // if (this.jRegisterPanel1.jCSTextField)
				// } catch (Exception ex) {
				//
				// }
				updateInstruction();

				updateGDT();

				updateIDT();

				updateLDT();

				updatePageTable();

				updateStack();

				updateAddressTranslate();

				((DefaultComboBoxModel) jPauseHistoryList.getModel()).addElement(jRegisterPanel1.jCSTextField.getText() + ":" + jRegisterPanel1.jEIPTextField.getText());

				jStatusLabel.setText("");
				enableAllButtons(true);
			}
		};
		updateThread.start();
		// try {
		// updateThread.join();
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
	}

	protected void updateAddressTranslate() {
		try {
			jStatusLabel.setText("Updating Address translate");
			commandReceiver.setCommandResult("");
			commandReceiver.setCommandNoOfLine(-1);
			sendCommand("info tab");
			String result = commandReceiver.getCommandResult();
			String[] lines = result.split(System.getProperty("line.separator"));
			DefaultTableModel model = (DefaultTableModel) jAddressTranslateTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			for (int x = 1; x < lines.length; x++) {
				Vector<String> strs = new Vector<String>(Arrays.asList(lines[x].trim().split("->")));
				model.addRow(strs);
			}
			jAddressTranslateTable.updateUI();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void enableAllButtons(boolean b) {
		jRunBochsButton.setEnabled(b);
		jStepBochsButton.setEnabled(b);
		jUpdateBochsButton.setEnabled(b);
		jPageDirectoryTable.setEnabled(b);
		jPageTableTable.setEnabled(b);

		pauseBochsMenuItem.setEnabled(b);
		runBochsMenuItem.setEnabled(b);
		jUpdateBochsStatusMenuItem.setEnabled(b);
	}

	private void updatePageTable() {
		try {
			jStatusLabel.setText("Updating page table");
			commandReceiver.setCommandResult("");
			commandReceiver.setCommandNoOfLine(512);
			sendCommand("xp /4096bx 0x" + this.jRegisterPanel1.jCR3TextField.getText());
			String result = commandReceiver.getCommandResult(1500);
			String[] lines = result.split(System.getProperty("line.separator"));
			DefaultTableModel model = (DefaultTableModel) jPageDirectoryTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			jStatusProgressBar.setMaximum(lines.length - 1);
			for (int y = 1; y < lines.length; y++) {
				jStatusProgressBar.setValue(y);
				String[] b = lines[y].replaceFirst("^.*:", "").trim().split("\t");

				for (int z = 0; z < 2; z++) {
					try {
						byte bytes[] = new byte[4];
						for (int x = 0; x < 4; x++) {
							bytes[x] = (byte) Long.parseLong(b[x + z * 4].substring(2).trim(), 16);
						}
						int value = CommonLib.getInt(bytes, 0);
						// "No.", "PT base", "AVL", "G",
						// "D", "A", "PCD", "PWT",
						// "U/S", "W/R", "P"

						String base = Integer.toHexString(value & 0xfffff000);
						String avl = String.valueOf((value >> 9) & 3);
						String g = String.valueOf((value >> 8) & 1);
						String d = String.valueOf((value >> 6) & 1);
						String a = String.valueOf((value >> 5) & 1);
						String pcd = String.valueOf((value >> 4) & 1);
						String pwt = String.valueOf((value >> 3) & 1);
						String us = String.valueOf((value >> 2) & 1);
						String wr = String.valueOf((value >> 1) & 1);
						String p = String.valueOf((value >> 0) & 1);
						model.addRow(new String[] { String.valueOf((y - 1) * 2 + z), base, avl, g, d, a, pcd, pwt, us, wr, p });
					} catch (Exception ex) {
					}
				}

				jPageDirectoryTable.setModel(model);

				jStatusLabel.setText("Updating memory " + y + "/" + lines.length);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void updateStack() {
		try {
			jStatusLabel.setText("Updating stack");
			commandReceiver.setCommandResult("");
			commandReceiver.setCommandNoOfLine(512);
			sendCommand("print-stack 10");
			String result = commandReceiver.getCommandResult(11);
			String[] lines = result.split(System.getProperty("line.separator"));
			jRegisterPanel1.jStackList.removeAll();

			jStatusProgressBar.setMaximum(lines.length - 1);
			DefaultListModel model = new DefaultListModel();
			for (int y = 1; y < lines.length; y++) {
				try {
					jStatusProgressBar.setValue(y);
					String[] b = lines[y].split("[\\[\\]]");
					model.addElement(b[1]);
					jStatusLabel.setText("Updating stack " + y + "/" + (lines.length - 1));
				} catch (Exception ex2) {
				}
			}
			jRegisterPanel1.jStackList.setModel(model);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void updateInstruction() {
		try {
			jStatusLabel.setText("Updating instruction");
			commandReceiver.setCommandResult("");
			Long cs = Long.parseLong(this.jRegisterPanel1.jCSTextField.getText(), 16);
			Long eip = Long.parseLong(this.jRegisterPanel1.jEIPTextField.getText(), 16) + 75;
			String command = "disassemble cs:eip 0x" + Long.toHexString(cs) + ":0x" + Long.toHexString(eip);
			// System.out.println(command);
			sendCommand(command);
			commandReceiver.setCommandNoOfLine(15);
			String result = commandReceiver.getCommandResult(1000);
			String lines[] = result.split(System.getProperty("line.separator"));
			this.jInstructionComboBox.setSelectedItem(lines[1].split(" ")[0].trim());
			DefaultTableModel model = (DefaultTableModel) jInstructionTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			jStatusProgressBar.setMaximum(lines.length - 1);
			for (int x = 0; x < lines.length; x++) {
				jStatusProgressBar.setValue(x);
				try {
					lines[x] = lines[x].replaceFirst("\\<.*\\>", "");
					String strs[] = lines[x].split(":");
					model.addRow(new String[] { strs[0].trim() + " " + strs[1].trim(), strs[2].trim() });
				} catch (Exception ex) {
					// System.out.println("error 1 : cannor parse"
					// + lines[x]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateGDT() {
		try {
			jStatusLabel.setText("Updating GDT");
			commandReceiver.setCommandResult("");
			commandReceiver.setCommandNoOfLine(20);
			sendCommand("info gdt 0 20");
			String result = commandReceiver.getCommandResult(500);
			String lines[] = result.split(System.getProperty("line.separator"));
			JGDTTableModel model = (JGDTTableModel) jGDTTable.getModel();
			model.clear();
			jStatusProgressBar.setMaximum(lines.length - 1);
			for (int x = 1; x < lines.length; x++) {
				jStatusProgressBar.setValue(x);
				try {
					Vector<String> v = new Vector<String>();
					v.add(lines[x].replaceFirst("^.*\\[", "").replaceFirst("].*$", ""));
					v.add(lines[x].replaceFirst("^.*]=", ""));
					model.addValue(v);
				} catch (Exception ex) {
				}
			}
			jGDTTable.updateUI();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void updateIDT() {
		try {
			jStatusLabel.setText("Updating IDT");
			commandReceiver.setCommandResult("");
			commandReceiver.setCommandNoOfLine(20);
			sendCommand("info idt 0 20");
			String result = commandReceiver.getCommandResult(500);
			String lines[] = result.split(System.getProperty("line.separator"));
			JIDTTableModel model = (JIDTTableModel) jIDTTable.getModel();
			model.clear();
			jStatusProgressBar.setMaximum(lines.length - 1);
			for (int x = 1; x < lines.length; x++) {
				jStatusProgressBar.setValue(x);
				try {
					Vector<String> v = new Vector<String>();
					v.add(lines[x].replaceFirst("^.*\\[", "").replaceFirst("].*$", ""));
					v.add(lines[x].replaceFirst("^.*]=", ""));
					model.addValue(v);
				} catch (Exception ex) {
				}
			}
			jIDTTable.updateUI();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void updateLDT() {
		try {
			jStatusLabel.setText("Updating LDT");
			commandReceiver.setCommandResult("");
			commandReceiver.setCommandNoOfLine(20);
			sendCommand("info ldt 0 20");
			String result = commandReceiver.getCommandResult(500);
			String lines[] = result.split(System.getProperty("line.separator"));
			JLDTTableModel model = (JLDTTableModel) jLDTTable.getModel();
			model.clear();
			jStatusProgressBar.setMaximum(lines.length - 1);
			for (int x = 1; x < lines.length; x++) {
				jStatusProgressBar.setValue(x);
				try {
					Vector<String> v = new Vector<String>();
					v.add(lines[x].replaceFirst("^.*\\[", "").replaceFirst("].*$", ""));
					v.add(lines[x].replaceFirst("^.*]=", ""));
					model.addValue(v);
				} catch (Exception ex) {
				}
			}
			jLDTTable.updateUI();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void updateRegister() {
		try {
			jStatusLabel.setText("Updating general registers");
			commandReceiver.setCommandResult("");
			commandReceiver.setCommandNoOfLine(Integer.parseInt(bochsCommandLength.get(0).get("r").toString()));
			sendCommand("r");
			String result = commandReceiver.getCommandResult();
			String lines[] = result.split(System.getProperty("line.separator"));
			jStatusProgressBar.setMaximum(lines.length - 1);
			int x = 0;
			for (String line : lines) {
				jStatusProgressBar.setValue(x++);
				if (line.matches(".*eax:.*")) {
					this.jRegisterPanel1.jEAXTextField.setText(line.split(" ")[2].substring(2));
				} else if (line.matches(".*ebx:.*")) {
					this.jRegisterPanel1.jEBXTextField.setText(line.split(" ")[1].substring(2));
				} else if (line.matches(".*ecx:.*")) {
					this.jRegisterPanel1.jECXTextField.setText(line.split(" ")[1].substring(2));
				} else if (line.matches(".*edx:.*")) {
					this.jRegisterPanel1.jEDXTextField.setText(line.split(" ")[1].substring(2));
				} else if (line.matches(".*esi:.*")) {
					this.jRegisterPanel1.jESITextField.setText(line.split(" ")[1].substring(2));
				} else if (line.matches(".*edi:.*")) {
					this.jRegisterPanel1.jEDITextField.setText(line.split(" ")[1].substring(2));
				} else if (line.matches(".*ebp:.*")) {
					this.jRegisterPanel1.jEBPTextField.setText(line.split(" ")[1].substring(2));
				} else if (line.matches(".*esp:.*")) {
					this.jRegisterPanel1.jESPTextField.setText(line.split(" ")[1].substring(2));
				} else if (line.matches(".*eip:.*")) {
					this.jRegisterPanel1.jEIPTextField.setText(line.split(" ")[1].substring(2));
				} else if (line.matches(".*eflags .*")) {
					this.jRegisterPanel1.jEFLAGSTextField.setText(line.split(" ")[1].substring(2));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			// sregs
			jStatusLabel.setText("Updating segment registers");
			commandReceiver.setCommandResult("");
			commandReceiver.setCommandNoOfLine(Integer.parseInt(bochsCommandLength.get(0).get("sregs").toString()));
			sendCommand("sreg");
			String result = commandReceiver.getCommandResult();
			String[] lines = result.split(System.getProperty("line.separator"));

			int x = 0;
			jStatusProgressBar.setMaximum(lines.length - 1);

			for (String line : lines) {
				jStatusProgressBar.setValue(x++);
				String str[] = line.split(" ");
				if (line.matches(".*cs:.*")) {
					this.jRegisterPanel1.jCSTextField.setText(str[1].substring(7).replace(",", ""));
				} else if (line.matches(".*ds:.*")) {
					this.jRegisterPanel1.jDSTextField.setText(str[0].substring(7).replace(",", ""));
				} else if (line.matches(".*es:.*")) {
					this.jRegisterPanel1.jESTextField.setText(str[0].substring(7).replace(",", ""));
				} else if (line.matches(".*fs:.*")) {
					this.jRegisterPanel1.jFSTextField.setText(str[0].substring(7).replace(",", ""));
				} else if (line.matches(".*gs:.*")) {
					this.jRegisterPanel1.jGSTextField.setText(str[0].substring(7).replace(",", ""));
				} else if (line.matches(".*ss:.*")) {
					this.jRegisterPanel1.jSSTextField.setText(str[0].substring(7).replace(",", ""));
				} else if (line.matches(".*gdtr:.*")) {
					this.jRegisterPanel1.jGDTRTextField.setText(str[0].substring(12).replace(",", ""));
				} else if (line.matches(".*ldtr:.*")) {
					this.jRegisterPanel1.jLDTRTextField.setText(str[1].substring(5).replace(",", ""));
				} else if (line.matches(".*idtr:.*")) {
					this.jRegisterPanel1.jIDTRTextField.setText(str[0].substring(12).replace(",", ""));
				} else if (line.matches(".*tr:.*")) {
					this.jRegisterPanel1.jTRTextField.setText(str[0].substring(7).replace(",", ""));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			// cregs
			jStatusLabel.setText("Updating control registers");
			commandReceiver.setCommandResult("");
			commandReceiver.setCommandNoOfLine(Integer.parseInt(bochsCommandLength.get(0).get("cregs").toString()));
			sendCommand("creg");
			String result = commandReceiver.getCommandResult();
			String[] lines = result.split(System.getProperty("line.separator"));

			int x = 0;
			jStatusProgressBar.setMaximum(lines.length - 1);

			for (String line : lines) {
				jStatusProgressBar.setValue(x++);
				if (line.matches(".*CR0=.*")) {
					this.jRegisterPanel1.jCR0TextField.setText(line.split(" ")[1].substring(6).replace(":", ""));
				} else if (line.matches(".*CR2=.*")) {
					this.jRegisterPanel1.jCR2TextField.setText(line.split(" ")[2].substring(8));
				} else if (line.matches(".*CR3=.*")) {
					this.jRegisterPanel1.jCR3TextField.setText(line.split(" ")[0].substring(6));
				} else if (line.matches(".*CR4=.*")) {
					this.jRegisterPanel1.jCR4TextField.setText(line.split(" ")[0].substring(6).replace(":", ""));
				}
			}

			// cr0
			long cr0 = Long.parseLong(this.jRegisterPanel1.jCR0TextField.getText(), 16);

			long pg = (cr0 & (1 << 31)) >> 31;
			if (pg == 1) {
				this.jRegisterPanel1.jCR0Table.setValueAt("PG", 0, 0);
			} else {
				this.jRegisterPanel1.jCR0Table.setValueAt("pg", 0, 0);
			}

			long cd = (cr0 & (1 << 30)) >> 30;
			if (cd == 1) {
				this.jRegisterPanel1.jCR0Table.setValueAt("CD", 0, 1);
			} else {
				this.jRegisterPanel1.jCR0Table.setValueAt("cd", 0, 1);
			}

			long nw = (cr0 & (1 << 29)) >> 29;
			if (nw == 1) {
				this.jRegisterPanel1.jCR0Table.setValueAt("NW", 0, 2);
			} else {
				this.jRegisterPanel1.jCR0Table.setValueAt("nw", 0, 2);
			}

			long am = (cr0 & (1 << 18)) >> 18;
			if (am == 1) {
				this.jRegisterPanel1.jCR0Table.setValueAt("AM", 0, 3);
			} else {
				this.jRegisterPanel1.jCR0Table.setValueAt("am", 0, 3);
			}

			long wp = (cr0 & (1 << 16)) >> 16;
			if (wp == 1) {
				this.jRegisterPanel1.jCR0Table.setValueAt("WP", 0, 4);
			} else {
				this.jRegisterPanel1.jCR0Table.setValueAt("wp", 0, 4);
			}

			long ne = (cr0 & (1 << 5)) >> 5;
			if (ne == 1) {
				this.jRegisterPanel1.jCR0Table.setValueAt("NE", 1, 0);
			} else {
				this.jRegisterPanel1.jCR0Table.setValueAt("ne", 1, 0);
			}

			long et = (cr0 & (1 << 4)) >> 4;
			if (et == 1) {
				this.jRegisterPanel1.jCR0Table.setValueAt("ET", 1, 1);
			} else {
				this.jRegisterPanel1.jCR0Table.setValueAt("et", 1, 1);
			}

			long ts = (cr0 & (1 << 3)) >> 3;
			if (ts == 1) {
				this.jRegisterPanel1.jCR0Table.setValueAt("TS", 1, 2);
			} else {
				this.jRegisterPanel1.jCR0Table.setValueAt("ts", 1, 2);
			}

			long em = (cr0 & (1 << 2)) >> 2;
			if (em == 1) {
				this.jRegisterPanel1.jCR0Table.setValueAt("EM", 1, 3);
			} else {
				this.jRegisterPanel1.jCR0Table.setValueAt("em", 1, 3);
			}

			long mp = (cr0 & (1 << 1)) >> 1;
			if (mp == 1) {
				this.jRegisterPanel1.jCR0Table.setValueAt("MP", 1, 4);
			} else {
				this.jRegisterPanel1.jCR0Table.setValueAt("mp", 1, 4);
			}

			long pe = cr0 & 1;
			if (pe == 1) {
				this.jRegisterPanel1.jCR0Table.setValueAt("PE", 1, 5);
			} else {
				this.jRegisterPanel1.jCR0Table.setValueAt("pe", 1, 5);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void updateMemory() {
		try {
			jStatusLabel.setText("Updating memory");
			commandReceiver.setCommandResult("");
			int totalByte = 200;
			commandReceiver.setCommandNoOfLine(totalByte / 8 + 1);
			sendCommand("xp /" + totalByte + "bx " + this.jMemoryAddressComboBox.getSelectedItem().toString());
			String result = commandReceiver.getCommandResult();
			String[] lines = result.split(System.getProperty("line.separator"));
			String bytes[] = new String[totalByte];
			int offset = 0;
			jStatusProgressBar.setMaximum(lines.length - 1);
			for (int y = 1; y < lines.length; y++) {
				jStatusProgressBar.setValue(y);
				String[] b = lines[y].replaceFirst("^.*:", "").split("\t");
				// System.out.println(lines[y]);
				for (int x = 1; x < b.length; x++) {
					// System.out.print(offset + " ");
					bytes[offset] = b[x].substring(2).trim();
					offset++;
				}
				// System.out.println();
				jStatusLabel.setText("Updating memory " + y + "/" + (lines.length - 1));
			}
			jStatusLabel.setText("");
			// System.out.println(lines.length);
			jHexTable1.getModel().set(bytes);
			jHexTable1.updateUI();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void exitMenuItemActionPerformed(ActionEvent evt) {
		thisWindowClosing(null);
		System.exit(0);
	}

	private void thisWindowClosing(WindowEvent evt) {
		if (p != null) {
			p.destroy();
		}
		ini.put("window", "width", this.getWidth());
		ini.put("window", "height", this.getHeight());
		ini.put("window", "x", this.getLocation().x);
		ini.put("window", "y", this.getLocation().y);
		ini.put("window", "divX", jSplitPane1.getDividerLocation());
		ini.put("window", "divY", jSplitPane2.getDividerLocation());

		try {
			ini.store();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void jGDTTableMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			for (int x = 0; x < jTabbedPane2.getTabCount(); x++) {
				if (jTabbedPane2.getTitleAt(x).equals(("GDT " + jGDTTable.getSelectedRow()))) {
					jTabbedPane2.setSelectedIndex(x);
					return;
				}
			}
			JScrollPane temp = new JScrollPane();
			temp.setViewportView(new GDTLDTPanel(this, 0, jGDTTable.getSelectedRow()));
			jTabbedPane2.addTab("GDT " + jGDTTable.getSelectedRow(), temp);
			jTabbedPane2.setSelectedIndex(jTabbedPane2.getTabCount() - 1);
		}
	}

	private void jLDTTableMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			for (int x = 0; x < jTabbedPane2.getTabCount(); x++) {
				if (jTabbedPane2.getTitleAt(x).equals(("LDT " + jLDTTable.getSelectedRow()))) {
					jTabbedPane2.setSelectedIndex(x);
					return;
				}
			}
			JScrollPane temp = new JScrollPane();
			temp.setViewportView(new GDTLDTPanel(this, 1, jLDTTable.getSelectedRow()));
			jTabbedPane2.addTab("LDT " + jLDTTable.getSelectedRow(), temp);
			jTabbedPane2.setSelectedIndex(jTabbedPane2.getTabCount() - 1);
		}
	}

	private void jButton2ActionPerformed(ActionEvent evt) {
		this.updateBochsStatus();
	}

	private void jPageDirectoryTableMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			String pageTableAddress = jPageDirectoryTable.getValueAt(jPageDirectoryTable.getSelectedRow(), 1).toString();

			commandReceiver.setCommandResult("");
			commandReceiver.setCommandNoOfLine(512);
			sendCommand("xp /4096bx 0x" + pageTableAddress);
			String result = commandReceiver.getCommandResult();
			String[] lines = result.split(System.getProperty("line.separator"));
			DefaultTableModel model = (DefaultTableModel) jPageTableTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			for (int y = 1; y < lines.length; y++) {
				String[] b = lines[y].replaceFirst("^.*:", "").trim().split("\t");

				for (int z = 0; z < 2; z++) {
					try {
						byte bytes[] = new byte[4];
						for (int x = 0; x < 4; x++) {
							bytes[x] = (byte) Long.parseLong(b[x + z * 4].substring(2).trim(), 16);
						}
						int value = CommonLib.getInt(bytes, 0);
						// "No.", "PT base", "AVL", "G",
						// "D", "A", "PCD", "PWT",
						// "U/S", "W/R", "P"

						String base = Integer.toHexString(value & 0xfffff000);
						String avl = String.valueOf((value >> 9) & 3);
						String g = String.valueOf((value >> 8) & 1);
						String d = String.valueOf((value >> 6) & 1);
						String a = String.valueOf((value >> 5) & 1);
						String pcd = String.valueOf((value >> 4) & 1);
						String pwt = String.valueOf((value >> 3) & 1);
						String us = String.valueOf((value >> 2) & 1);
						String wr = String.valueOf((value >> 1) & 1);
						String p = String.valueOf((value >> 0) & 1);
						model.addRow(new String[] { String.valueOf((y - 1) * 2 + z), base, avl, g, d, a, pcd, pwt, us, wr, p });
					} catch (Exception ex) {
					}
				}

				jPageTableTable.setModel(model);
			}
		}
	}

	private void jPageTableTableMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			String pageAddress = jPageTableTable.getValueAt(jPageTableTable.getSelectedRow(), 1).toString();
			this.jMemoryAddressComboBox.setSelectedItem("0x" + pageAddress);
			this.jGOMemoryButtonActionPerformed(null);
		}
	}

	private void jRefreshBreakpointButtonActionPerformed(ActionEvent evt) {
		updateBreakpoint();
	}

	private void updateBreakpoint() {
		try {
			commandReceiver.setCommandResult("");
			commandReceiver.setCommandNoOfLine(-1);
			sendCommand("info break");
			String result = commandReceiver.getCommandResult();
			String[] lines = result.split(System.getProperty("line.separator"));
			DefaultTableModel model = (DefaultTableModel) jBreakpointTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			for (int x = 1; x < lines.length; x++) {
				Vector<String> strs = new Vector<String>(Arrays.asList(lines[x].trim().split(" \\s")));
				strs.remove(1);
				model.addRow(strs);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void jDisassembleButtonActionPerformed(ActionEvent evt) {
		this.updateInstruction();
	}

	private void jAddBreakpointButtonActionPerformed(ActionEvent evt) {
		String type = (String) JOptionPane.showInputDialog(this, null, "Add breakpoint", JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Physical breakpoint", "Linear breakpoint" },
				"Physical breakpoint");
		if (type == null) {
			return;
		}
		String address = JOptionPane.showInputDialog(this, "Please input breakpoint address", "Add breakpoint", JOptionPane.QUESTION_MESSAGE);
		// boolean match = false;
		// for (int y = 0; y < this.jBreakpointTable.getRowCount(); y++)
		// {
		// if (jBreakpointTable.getValueAt(y,
		// 2).toString().trim().equals(address.trim())) {
		// match = true;
		// break;
		// }
		// }
		// if (!match) {
		if (address != null) {
			if (type.equals("Physical breakpoint")) {
				sendCommand("pb " + address);
			} else {
				sendCommand("lb " + address);
			}
			updateBreakpoint();
		}
		// }
	}

	private void jSaveBreakpointButtonActionPerformed(ActionEvent evt) {
		Vector<HashMap> v = new Vector<HashMap>();

		for (int x = 0; x < this.jBreakpointTable.getRowCount(); x++) {
			HashMap<String, String> h = new HashMap<String, String>();
			h.put("no", String.valueOf(x));
			h.put("type", this.jBreakpointTable.getValueAt(x, 1).toString());
			h.put("address", this.jBreakpointTable.getValueAt(x, 2).toString());
			v.add(h);
		}
		XMLHelper.vectorToXML("breakpoint.xml", "breakpoints", "record", v);
	}

	private void jLoadBreakpointButtonActionPerformed(ActionEvent evt) {
		Vector<HashMap> vector = XMLHelper.xmltoVector("breakpoint.xml", "/breakpoints/record");
		for (int x = 0; x < vector.size(); x++) {
			boolean match = false;
			for (int y = 0; y < this.jBreakpointTable.getRowCount(); y++) {
				if (vector.get(x).get("address").toString().trim().equals(jBreakpointTable.getValueAt(y, 2).toString().trim())) {
					match = true;
					break;
				}
			}
			if (!match) {
				sendCommand("pb " + vector.get(x).get("address").toString());
				updateBreakpoint();
				if (vector.get(x).get("type").toString().trim().equals("keep n")) {
					sendCommand("bpd " + jBreakpointTable.getValueAt(jBreakpointTable.getRowCount() - 1, 0).toString().split(" ")[0]);
					updateBreakpoint();
				}
			}
		}

	}

	private void jDeleteBreakpointButtonActionPerformed(ActionEvent evt) {
		int rows[] = jBreakpointTable.getSelectedRows();
		for (int x = 0; x < rows.length; x++) {
			sendCommand("del " + jBreakpointTable.getValueAt(rows[x], 0).toString().trim().split(" ")[0]);
		}
		updateBreakpoint();
	}

	private void jDisableBreakpointButtonActionPerformed(ActionEvent evt) {
		int rows[] = jBreakpointTable.getSelectedRows();
		for (int x = 0; x < rows.length; x++) {
			sendCommand("bpd " + jBreakpointTable.getValueAt(rows[x], 0).toString().trim().split(" ")[0]);
		}
		updateBreakpoint();
	}

	private void jEnableBreakpointButtonActionPerformed(ActionEvent evt) {
		int rows[] = jBreakpointTable.getSelectedRows();
		for (int x = 0; x < rows.length; x++) {
			sendCommand("bpe " + jBreakpointTable.getValueAt(rows[x], 0).toString().trim().split(" ")[0]);
		}
		updateBreakpoint();
	}

	private void jBochsCommandTextFieldKeyPressed(KeyEvent evt) {
		if (jBochsCommandTextField.getText().equals("")) {
			commandHistoryIndex = 0;
		}
		if (evt.getKeyCode() == 38) {
			Vector<HashMap> vector = XMLHelper.xmltoVector("history.xml", "/history/record");
			if (commandHistoryIndex < vector.size() - 1) {
				commandHistoryIndex++;
				this.jBochsCommandTextField.setText(vector.get(vector.size() - commandHistoryIndex).get("command").toString());
			}
		} else if (evt.getKeyCode() == 40) {
			Vector<HashMap> vector = XMLHelper.xmltoVector("history.xml", "/history/record");
			if (commandHistoryIndex > 1) {
				commandHistoryIndex--;
				this.jBochsCommandTextField.setText(vector.get(vector.size() - commandHistoryIndex).get("command").toString());
			}
		}
	}

	private ButtonGroup getButtonGroup1() {
		if (buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
		}
		return buttonGroup1;
	}

	private void jBinaryRadioButtonStateChanged(ChangeEvent evt) {

	}

	private void jOctRadioButton1StateChanged(ChangeEvent evt) {

	}

	private void jDecRadioButtonStateChanged(ChangeEvent evt) {

	}

	private void jHexRadioButtonStateChanged(ChangeEvent evt) {

	}

	private void jBinaryRadioButtonItemStateChanged(ItemEvent evt) {
		jHexTable1.getModel().setRadix(2);
		jHexTable1.updateUI();
	}

	private void jOctRadioButton1ItemStateChanged(ItemEvent evt) {
		jHexTable1.getModel().setRadix(8);
		jHexTable1.updateUI();
	}

	private void jDecRadioButtonItemStateChanged(ItemEvent evt) {
		jHexTable1.getModel().setRadix(10);
		jHexTable1.updateUI();
	}

	private void jHexRadioButtonItemStateChanged(ItemEvent evt) {
		jHexTable1.getModel().setRadix(16);
		jHexTable1.updateUI();
	}

	private JScrollPane getJTableTranslateScrollPane() {
		if (jTableTranslateScrollPane == null) {
			jTableTranslateScrollPane = new JScrollPane();
			jTableTranslateScrollPane.setViewportView(getJAddressTranslateTable());
		}
		return jTableTranslateScrollPane;
	}

	private JTable getJAddressTranslateTable() {
		if (jAddressTranslateTable == null) {
			TableModel jAddressTranslateTableModel = new DefaultTableModel(new String[][] {}, new String[] { "From", "To" });
			jAddressTranslateTable = new JTable();
			jAddressTranslateTable.setModel(jAddressTranslateTableModel);
		}
		return jAddressTranslateTable;
	}

}
