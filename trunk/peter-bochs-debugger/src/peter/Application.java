package peter;

import info.clearthought.layout.TableLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
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
import java.awt.geom.Rectangle2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.ini4j.Wini;
import org.jgraph.JGraph;
import org.jgraph.graph.CellView;
import org.jgraph.graph.DefaultCellViewFactory;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.DefaultGraphModel;
import org.jgraph.graph.DefaultPort;
import org.jgraph.graph.EdgeView;
import org.jgraph.graph.GraphConstants;
import org.jgraph.graph.GraphLayoutCache;
import org.jgraph.graph.GraphModel;
import org.jgraph.graph.PortView;
import org.jgraph.graph.VertexView;

import peter.architecture.IA32PageDirectory;
import peter.architecture.IA32PageTable;
import peter.graph.JButtonView;
import peter.graph.PageDirectoryView;

import com.jgraph.layout.JGraphFacade;
import com.jgraph.layout.JGraphLayout;
import com.jgraph.layout.tree.JGraphTreeLayout;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licen sing terms. A COMMERCIAL LICENSE HAS NOT BEEN
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
	public JComboBox jMemoryAddressComboBox;
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
	private JScrollPane jScrollPane6;
	private JLabel jLabel3;
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
	private JTable jAddressTranslateTable2;
	private JPanel jPanel22;
	private JMenu jBochVersionMenu;
	private JMenuItem jPTEMenuItem;
	private JMenuItem jPDEMenuItem;
	private JMenuItem jIDTDescriptorMenuItem;
	private JMenuItem jIDTMenuItem;
	private JMenuItem jGDTDescriptorMenuItem;
	private JMenuItem jGDTMenuItem;
	private JPopupMenu jHexTablePopupMenu;
	private JTextField jAddressTextField;
	private JPanel jPanel21;
	private ButtonGroup buttonGroup3;
	private JButton jButton18;
	private JButton jButton17;
	private JToolBar jToolBar3;
	private JScrollPane jScrollPane13;
	private JButton jButton16;
	private JPanel jPanel20;
	private JRadioButton jSearchAddressRadioButton3;
	private JRadioButton jSearchAddressRadioButton2;
	private JRadioButton jSearchAddressRadioButton1;
	private JPanel jAddressTranslatePanel;
	private JButton jRefreshPageTableGraphButton;
	private JCheckBox jAutoRefreshPageTableGraphCheckBox;
	private JToolBar jToolBar2;
	private JPanel jPageTableGraphPanel;
	private JButton jPagingGraphButton;
	private JPanel jPanel19;
	private JButton jGDTGraphButton;
	private JLabel jRunningLabel;
	private JPanel jMainPanel;
	private JButton jButton15;
	private JButton jButton11;
	private JButton jButton10;
	private JButton jButton9;
	private JButton jButton8;
	private JPanel jPanel16;
	private JPanel jPanel15;
	private JButton jButton7;
	private JButton jButton6;
	private JPanel jPanel14;
	private ButtonGroup buttonGroup2;
	private JRadioButton jRadioButton2;
	private JPanel jPanel13;
	private JRadioButton jRadioButton1;
	private JTable jHistoryTable;
	private JMenuItem jDialogMenuItem;
	private JMenuItem jArialMenuItem;
	private JMenu jMenu2;
	private JMenu jMenu1;
	private JScrollPane jTableTranslateScrollPane;
	// Vector<HashMap> bochsCommandLength =
	// XMLHelper.xmltoVector(getClass().getClassLoader().getResourceAsStream("peter/bochsCommandLength.xml"),
	// "/bochsCommandLength");
	Wini ini;
	private static String[] arguments;
	private JMenuItem jFont14MenuItem;
	private JMenuItem jFont12MenuItem;
	private JMenuItem jFont10MenuItem;
	private JMenuItem jFont8MenuItem;
	private JMenu jFontMenu;
	private int fontsize;
	private String fontFamily;
	private JMenuItem jMenuItem3;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem1;
	private JMenu jMenu6;
	private JSplitPane jSplitPane3;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JButton jButton12;
	private JButton jButton13;
	private JPanel jPanel17;
	private JTable jSearchMemoryTable;
	private JScrollPane jScrollPane12;
	private JPanel jPanel18;
	private JButton jSearchMemoryButton;
	private JComboBox jSearchMemoryToComboBox;
	private JLabel jLabel6;
	private JComboBox jSearchMemoryFromComboBox;
	private JLabel jLabel5;
	private JTextField jSearchMemoryTextField;
	private JLabel jLabel4;
	private JButton jButton14;
	public static ResourceBundle language;
	private JButton jRefreshAddressTranslateTableButton;

	private long currentMemoryWindowsAddress;
	public static boolean isLinux;
	private Runtime runtime = Runtime.getRuntime();
	public static String version = "";

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

		String OS = System.getProperty("os.name").toLowerCase();
		if (OS.indexOf("windows") > -1) {
			isLinux = false;
		} else {
			isLinux = true;
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
			try {
				UIManager.setLookAndFeel("com.petersoft.white.PetersoftWhiteLookAndFeel");
			} catch (Exception e) {
				e.printStackTrace();
			}

			File iniFile = new File("setting.ini");
			if (!iniFile.exists()) {
				iniFile.createNewFile();
			}
			ini = new Wini(iniFile);

			if (ini.get("global", "fontsize") != null && !ini.get("global", "fontsize").trim().equals("")) {
				fontsize = Integer.parseInt(ini.get("global", "fontsize"));
			}
			if (ini.get("global", "font") != null && !ini.get("global", "font").trim().equals("")) {
				fontFamily = ini.get("global", "font");
			}
			if (ini.get("general", "language") != null && !ini.get("general", "language").trim().equals("")) {
				language = Utf8ResourceBundle.getBundle("language_" + ini.get("general", "language"));
			} else {
				language = Utf8ResourceBundle.getBundle("language_en_US");
			}
			if (!isLinux) {
				if (!new File("PauseBochs.exe").exists() || !new File("StopBochs.exe").exists()) {
					JOptionPane.showMessageDialog(null, language.getString("PauseBochsExe"), language.getString("Error"), JOptionPane.ERROR_MESSAGE);
					System.exit(-1);
				}
			}
			setFont();
		} catch (Exception e) {
			e.printStackTrace();
		}
		initGUI();
		startBochs();
		updateBochsStatus();
	}

	private void startBochs() {
		try {
			this.enableAllButtons(true);
			jRunBochsButton.setText(language.getString("Run_bochs"));
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

			pb.redirectErrorStream(true);
			p = pb.start();
			InputStream is = p.getInputStream();
			commandReceiver = new CommandReceiver(is, this);
			new Thread(commandReceiver).start();
			commandOutputStream = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));

			if (isLinux) {
				sendCommand("6");
			}

			while (commandReceiver.getLinesLength() < 9) {
			}

			String versionLines[] = commandReceiver.getCommandResultUntilEnd().split("\n");
			for (String line : versionLines) {
				if (line.contains("Bochs x86 Emulator")) {
					version = line.trim();
					jBochVersionMenu.setText(version);
					System.out.println(jBochVersionMenu.getText());
					break;
				}
			}

			jRefreshBreakpointButtonActionPerformed(null);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, language.getString("Unable_to_start_bochs"));
			ex.printStackTrace();
		}
	}

	private void stopBochs() {
		try {
			this.enableAllButtons(false);
			jRunBochsButton.setText(language.getString("Run_bochs"));
			jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/resultset_next.png")));

			if (isLinux) {
				ProcessBuilder pb = new ProcessBuilder("killall", "-9", "bochs");
				pb.start();
			} else {
				ProcessBuilder pb = new ProcessBuilder("StopBochs.exe");
				pb.start();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private synchronized void pauseBochs() {
		try {
			if (jRunBochsButton.getText().equals(language.getString("Pause_bochs"))) {
				if (isLinux) {
					ProcessBuilder pb = new ProcessBuilder("killall", "-2", "bochs");
					pb.start();
				} else {
					ProcessBuilder pb = new ProcessBuilder("PauseBochs.exe");
					pb.start();
				}

				updateBochsStatus();

				CardLayout cl = (CardLayout) (jMainPanel.getLayout());
				cl.show(jMainPanel, "jSplitPane2");

				jRunBochsButton.setText(language.getString("Run_bochs"));
				jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/resultset_next.png")));
				// jStepBochsButton.setEnabled(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void runBochs() {
		try {
			sendCommand("c");
			CardLayout cl = (CardLayout) (jMainPanel.getLayout());
			cl.show(jMainPanel, "Running Label");
			jRunBochsButton.setText(language.getString("Pause_bochs"));
			jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/pause.png")));

			new Thread() {
				public void run() {
					commandReceiver.clearBuffer();
					while (commandReceiver.getLinesLength() == 0) {
					}

					pauseBochs();
				}
			}.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void initGUI() {
		try {
			{
				this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				this.setTitle(language.getString("Title"));
				this.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent evt) {
						thisWindowClosing(evt);
					}
				});
			}
			{
				jToolBar1 = new JToolBar();
				getContentPane().add(jToolBar1, BorderLayout.NORTH);
				{
					jStartBochButton = new JButton();
					jToolBar1.add(jStartBochButton);
					jStartBochButton.setText(language.getString("Start_bochs"));
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
					jStopBochsButton.setText(language.getString("Stop_bochs"));
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
					jRunBochsButton.setText(language.getString("Run_bochs"));
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
					jStepBochsButton.setText(language.getString("Step"));
					jStepBochsButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jStepBochsButtonActionPerformed(evt);
						}
					});
				}
				{
					jUpdateBochsButton = new JButton();
					jToolBar1.add(jUpdateBochsButton);
					jToolBar1.add(getJButton13());
					jUpdateBochsButton.setEnabled(true);
					jUpdateBochsButton.setText(language.getString("Update"));
					jUpdateBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/arrow_refresh.png")));
					jUpdateBochsButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jUpdateBochsButtonActionPerformed(evt);
						}
					});
				}
			}
			{
				jStatusPanel = new JPanel();
				BorderLayout jStatusPanelLayout = new BorderLayout();
				jStatusPanel.setLayout(jStatusPanelLayout);
				getContentPane().add(jStatusPanel, BorderLayout.SOUTH);
				getContentPane().add(getJMainPanel(), BorderLayout.CENTER);
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
					jMenu3.setText(language.getString("File"));
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText(language.getString("Exit"));
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
					jMenuBar1.add(getJFontMenu());
					jMenuBar1.add(getJMenu6());
					jMenu4.setText(language.getString("Bochs"));
					{
						startBochsMenuItem = new JMenuItem();
						jMenu4.add(startBochsMenuItem);
						startBochsMenuItem.setText(language.getString("Start_bochs"));
						startBochsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								startBochsMenuItemActionPerformed(evt);
							}
						});
					}
					{
						stopBochsMenuItem = new JMenuItem();
						jMenu4.add(stopBochsMenuItem);
						stopBochsMenuItem.setText(language.getString("Stop_bochs"));
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
						runBochsMenuItem.setText(language.getString("Run_bochs"));
						runBochsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								runBochsMenuItemActionPerformed(evt);
							}
						});
					}
					{
						pauseBochsMenuItem = new JMenuItem();
						jMenu4.add(pauseBochsMenuItem);
						pauseBochsMenuItem.setText(language.getString("Pause_bochs"));
						pauseBochsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								pauseBochsMenuItemActionPerformed(evt);
							}
						});
					}
					{
						jUpdateBochsStatusMenuItem = new JMenuItem();
						jMenu4.add(jUpdateBochsStatusMenuItem);
						jUpdateBochsStatusMenuItem.setText(language.getString("Update_bochs_status"));
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
					jMenuBar1.add(getJBochVersionMenu());
					jMenu5.setText(language.getString("Help"));
					{
						aboutUsMenuItem = new JMenuItem();
						jMenu5.add(aboutUsMenuItem);
						aboutUsMenuItem.setText(language.getString("About_us"));
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

			initChineseFont();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(ERROR);
		}
	}

	private void initChineseFont() {
		Font[] allfonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
		int fontcount = 0;
		String chinesesample = "\u4e00";
		for (int j = 0; j < allfonts.length; j++) {
			if (allfonts[j].canDisplayUpTo(chinesesample) == -1) {
				// System.out.println(allfonts[j].getFontName());
				JMenuItem jMenuItem = new JMenuItem(allfonts[j].getFontName());
				jMenuItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						fontFamily = ((JMenuItem) evt.getSource()).getText();
						setFont();
					}
				});
				jMenu2.add(jMenuItem);
			}
			fontcount++;
		}
	}

	private void jBochsCommandButtonActionPerformed(ActionEvent evt) {
		try {
			if (jBochsCommandTextField.getText().trim().equals("clear")) {
				this.jBochsEditorPane.setText("");
			} else if (jBochsCommandTextField.getText().trim().equals("c")) {
				commandReceiver.shouldShow = false;
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
		commandReceiver.shouldShow = false;
		if (jRunBochsButton.getText().equals(language.getString("Run_bochs"))) {
			runBochsMenuItemActionPerformed(null);
		} else {
			pauseBochsMenuItemActionPerformed(null);
		}
	}

	public static void sendCommand(String command) {
		try {
			commandReceiver.clearBuffer();
			commandOutputStream.write(command + "\n");
			commandOutputStream.flush();
			if (!command.equals("6") && !command.equals("c") && !command.startsWith("pb") && !command.startsWith("lb") && !command.startsWith("bpd") && !command.startsWith("bpe")) {
				commandReceiver.waitUntilHaveInput();
			}

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

	private void addInstructionComboBox(String str) {
		System.out.println("str=" + str);
		for (int x = 0; x < jInstructionComboBox.getItemCount(); x++) {
			if (this.jInstructionComboBox.getItemAt(x).toString().trim().equals(str.trim())) {
				return;
			}
		}

		jInstructionComboBox.addItem(str.trim());
	}

	private void jUpdateBochsStatusMenuItemActionPerformed(ActionEvent evt) {
		updateBochsStatus();
	}

	public void updateBochsStatus() {
		Thread updateThread = new Thread() {
			public void run() {
				enableAllButtons(false);

				updateRegister();

				updateEFlag();

				updateMemory();

				updateInstruction(null);

				updateGDT();

				updateIDT();

				updatePageTable();

				updateStack();

				updateAddressTranslate();

				// ((DefaultComboBoxModel)
				// jPauseHistoryList.getModel()).addElement(jRegisterPanel1.jCSTextField.getText()
				// + ":" + jRegisterPanel1.jEIPTextField.getText());

				updateHistoryTable();

				updateBreakpointTableColor();

				jStatusLabel.setText("");

				enableAllButtons(true);
			}
		};
		updateThread.start();
	}

	private void updateBreakpointTableColor() {
		long eip = CommonLib.string2decimal(jRegisterPanel1.jEIPTextField.getText());
		String eipStr = Long.toHexString(eip);
		for (int x = 0; x < jBreakpointTable.getRowCount(); x++) {
			String value = jBreakpointTable.getValueAt(x, 0).toString();
			if (jBreakpointTable.getValueAt(x, 2).toString().contains(eipStr)) {
				int hit = Integer.parseInt(jBreakpointTable.getValueAt(x, 3).toString());
				jBreakpointTable.setValueAt("-" + value, x, 0);
				jBreakpointTable.setValueAt(hit + 1, x, 3);
			} else {
				if (value.startsWith("-")) {
					jBreakpointTable.setValueAt(value.substring(1), x, 0);
				}
			}
		}
	}

	private void updateHistoryTable() {
		try {
			AllRegisters.time.add(new Date());
			AllRegisters.eax.add(CommonLib.hex2decimal(jRegisterPanel1.jEAXTextField.getText()));
			AllRegisters.ebx.add(CommonLib.hex2decimal(jRegisterPanel1.jEBXTextField.getText()));
			AllRegisters.ecx.add(CommonLib.hex2decimal(jRegisterPanel1.jECXTextField.getText()));
			AllRegisters.edx.add(CommonLib.hex2decimal(jRegisterPanel1.jEDXTextField.getText()));
			AllRegisters.esi.add(CommonLib.hex2decimal(jRegisterPanel1.jESITextField.getText()));
			AllRegisters.edi.add(CommonLib.hex2decimal(jRegisterPanel1.jEDITextField.getText()));
			AllRegisters.ebp.add(CommonLib.hex2decimal(jRegisterPanel1.jEBPTextField.getText()));
			AllRegisters.esp.add(CommonLib.hex2decimal(jRegisterPanel1.jESPTextField.getText()));

			AllRegisters.cs.add(CommonLib.hex2decimal(jRegisterPanel1.jCSTextField.getText()));
			AllRegisters.eip.add(CommonLib.hex2decimal(jRegisterPanel1.jEIPTextField.getText()));
			AllRegisters.ds.add(CommonLib.hex2decimal(jRegisterPanel1.jDSTextField.getText()));
			AllRegisters.es.add(CommonLib.hex2decimal(jRegisterPanel1.jESTextField.getText()));
			AllRegisters.fs.add(CommonLib.hex2decimal(jRegisterPanel1.jFSTextField.getText()));
			AllRegisters.gs.add(CommonLib.hex2decimal(jRegisterPanel1.jGSTextField.getText()));
			AllRegisters.ss.add(CommonLib.hex2decimal(jRegisterPanel1.jSSTextField.getText()));
			AllRegisters.eflags.add(jRegisterPanel1.jEFlagLabel.getText().trim() + jRegisterPanel1.jEFlagLabel2.getText());

			AllRegisters.cr0.add(CommonLib.hex2decimal(jRegisterPanel1.jCR0TextField.getText()));
			AllRegisters.cr2.add(CommonLib.hex2decimal(jRegisterPanel1.jCR2TextField.getText()));
			AllRegisters.cr3.add(CommonLib.hex2decimal(jRegisterPanel1.jCR3TextField.getText()));
			AllRegisters.cr4.add(CommonLib.hex2decimal(jRegisterPanel1.jCR4TextField.getText()));

			AllRegisters.gdtr.add(CommonLib.hex2decimal(jRegisterPanel1.jGDTRTextField.getText()));
			AllRegisters.idtr.add(CommonLib.hex2decimal(jRegisterPanel1.jIDTRTextField.getText()));
			AllRegisters.ldtr.add(CommonLib.hex2decimal(jRegisterPanel1.jLDTRTextField.getText()));

			AllRegisters.tr.add(CommonLib.hex2decimal(jRegisterPanel1.jTRTextField.getText()));

			Vector<Long> stack = new Vector<Long>();
			for (int x = 0; x < jRegisterPanel1.jStackList.getModel().getSize(); x++) {
				stack.add(CommonLib.hex2decimal(jRegisterPanel1.jStackList.getModel().getElementAt(x).toString()));
			}
			AllRegisters.stack.add(stack);

			this.jHistoryTable.updateUI();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void updateEFlag() {
		try {
			jStatusLabel.setText("Updating EFlags");
			// commandReceiver.setCommandNoOfLine(-1);
			commandReceiver.clearBuffer();
			sendCommand("info eflags");
			String result = commandReceiver.getCommandResultUntilEnd();
			String arr[] = result.replaceAll("<.*> ", "").split(" ");

			jRegisterPanel1.jEFlagLabel.setText("");
			jRegisterPanel1.jEFlagLabel2.setText("");
			for (int x = 0; x < 7; x++) {
				jRegisterPanel1.jEFlagLabel.setText(jRegisterPanel1.jEFlagLabel.getText() + arr[x] + " ");
			}
			for (int x = 7; x < arr.length; x++) {
				jRegisterPanel1.jEFlagLabel2.setText(jRegisterPanel1.jEFlagLabel2.getText() + arr[x] + " ");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void updateAddressTranslate() {
		try {
			jStatusLabel.setText("Updating Address translate");
			// commandReceiver.setCommandNoOfLine(-1);
			commandReceiver.clearBuffer();
			sendCommand("info tab");
			String result = commandReceiver.getCommandResultUntilEnd();
			String[] lines = result.split("\n");
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
		Vector<IA32PageDirectory> ia32_pageDirectories = new Vector<IA32PageDirectory>();
		try {
			jStatusLabel.setText("Updating page table");
			// commandReceiver.setCommandNoOfLine(512);
			sendCommand("xp /4096bx " + this.jRegisterPanel1.jCR3TextField.getText());

			float totalByte2 = 4096 - 1;
			totalByte2 = totalByte2 / 8;
			int totalByte3 = (int) Math.floor(totalByte2);
			String realEndAddressStr;
			String realStartAddressStr;
			String baseAddress = this.jRegisterPanel1.jCR3TextField.getText();
			long realStartAddress;
			realStartAddress = CommonLib.hex2decimal(baseAddress.substring(2));
			realStartAddressStr = String.format("%08x", realStartAddress);
			long realEndAddress = realStartAddress + totalByte3 * 8;
			realEndAddressStr = String.format("%08x", realEndAddress);

			String result = commandReceiver.getCommandResult(realStartAddressStr, realEndAddressStr);
			String[] lines = result.split("\n");
			DefaultTableModel model = (DefaultTableModel) jPageDirectoryTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			jStatusProgressBar.setMaximum(lines.length - 1);

			for (int y = 0; y < lines.length; y++) {
				jStatusProgressBar.setValue(y);
				String[] b = lines[y].replaceFirst("^.*:", "").trim().split("\t");

				for (int z = 0; z < 2; z++) {
					try {
						byte bytes[] = new byte[4];
						for (int x = 0; x < 4; x++) {
							bytes[x] = (byte) (long) CommonLib.hex2decimal(b[x + z * 4].substring(2).trim());
						}
						int value = CommonLib.getInt(bytes, 0);
						// "No.", "PT base", "AVL", "G",
						// "D", "A", "PCD", "PWT",
						// "U/S", "W/R", "P"

						long baseL = value & 0xfffff000;
						if (baseL != 0) {
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
						}
					} catch (Exception ex) {
					}
				}

				jPageDirectoryTable.setModel(model);

				jStatusLabel.setText("Updating memory " + y + "/" + lines.length);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (jAutoRefreshPageTableGraphCheckBox.isSelected()) {
			GraphModel model = new DefaultGraphModel();
			GraphLayoutCache view = new GraphLayoutCache(model, new DefaultCellViewFactory() {
				public CellView createView(GraphModel model, Object cell) {
					CellView view = null;
					if (model.isPort(cell)) {
						view = new PortView(cell);
					} else if (model.isEdge(cell)) {
						view = new EdgeView(cell);
					} else {
						if (cell instanceof IA32PageDirectory) {
							view = new PageDirectoryView(cell);
						} else if (cell instanceof IA32PageTable) {
							view = new JButtonView(cell, 1);
						} else {
							view = new VertexView(cell);
						}
					}
					return view;
				}
			});
			JGraph graph = new JGraph(model, view);

			// add cells

			// DefaultGraphCell[] cells = new
			// DefaultGraphCell[ia32_pageDirectories.size() + 1];
			Vector<DefaultGraphCell> cells = new Vector<DefaultGraphCell>();
			DefaultGraphCell root = new DefaultGraphCell("cr3 " + jRegisterPanel1.jCR3TextField.getText());
			GraphConstants.setGradientColor(root.getAttributes(), Color.red);
			GraphConstants.setOpaque(root.getAttributes(), true);
			GraphConstants.setBounds(root.getAttributes(), new Rectangle2D.Double(0, 0, 140, 20));
			root.add(new DefaultPort());
			cells.add(root);

			Vector<IA32PageDirectory> pageDirectoryCells = new Vector<IA32PageDirectory>();
			for (int x = 0; x < ia32_pageDirectories.size(); x++) {
				IA32PageDirectory cell = ia32_pageDirectories.get(x);
				GraphConstants.setGradientColor(cell.getAttributes(), Color.orange);
				GraphConstants.setOpaque(cell.getAttributes(), true);
				GraphConstants.setBounds(cell.getAttributes(), new Rectangle2D.Double(0, x * 20, 140, 20));
				cell.add(new DefaultPort());
				pageDirectoryCells.add(cell);

				// page table
				String pageTableAddress = ia32_pageDirectories.get(x).base;
				sendCommand("xp /4096bx " + pageTableAddress);

				float totalByte2 = 4096 - 1;
				totalByte2 = totalByte2 / 8;
				int totalByte3 = (int) Math.floor(totalByte2);
				String realEndAddressStr;
				String realStartAddressStr;
				String baseAddress = pageTableAddress;
				long realStartAddress = CommonLib.hex2decimal(baseAddress);

				realStartAddressStr = String.format("%08x", realStartAddress);
				long realEndAddress = realStartAddress + totalByte3 * 8;
				realEndAddressStr = String.format("%08x", realEndAddress);

				String result = commandReceiver.getCommandResult(realStartAddressStr, realEndAddressStr);
				String[] lines = result.split("\n");

				Vector<DefaultGraphCell> pageTables = new Vector<DefaultGraphCell>();
				for (int y = 1; y < 4; y++) {
					String[] b = lines[y].replaceFirst("			cell.add(new DefaultPort());^.*:", "").trim().split("\t");

					for (int z = 0; z < 2; z++) {
						try {
							byte bytes[] = new byte[4];
							for (int x2 = 0; x2 < 4; x2++) {
								bytes[x2] = (byte) (long) CommonLib.hex2decimal(b[x2 + z * 4].substring(2).trim());
							}
							int value = CommonLib.getInt(bytes, 0);

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
							IA32PageTable pageTableCell = new IA32PageTable(base, avl, g, d, a, pcd, pwt, us, wr, p);
							GraphConstants.setGradientColor(pageTableCell.getAttributes(), Color.orange);
							GraphConstants.setOpaque(pageTableCell.getAttributes(), true);
							GraphConstants.setBounds(pageTableCell.getAttributes(), new Rectangle2D.Double(0, (z + y) * 20, 140, 20));
							pageTableCell.add(new DefaultPort());
							pageTables.add(pageTableCell);
						} catch (Exception ex) {
						}
					}
				}

				// group it and link it
				DefaultGraphCell pt[] = pageTables.toArray(new DefaultGraphCell[] {});
				DefaultGraphCell vertex1 = new DefaultGraphCell(new String("page table" + x), null, pt);
				vertex1.add(new DefaultPort());
				cells.add(vertex1);

				DefaultEdge edge = new DefaultEdge();
				edge.setSource(cell.getChildAt(0));
				edge.setTarget(vertex1.getLastChild());

				GraphConstants.setLineStyle(edge.getAttributes(), GraphConstants.STYLE_ORTHOGONAL);
				GraphConstants.setRouting(edge.getAttributes(), GraphConstants.ROUTING_DEFAULT);
				int arrow = GraphConstants.ARROW_CLASSIC;
				GraphConstants.setLineEnd(edge.getAttributes(), arrow);
				GraphConstants.setEndFill(edge.getAttributes(), true);

				cells.add(edge);
			}

			if (pageDirectoryCells.toArray().length > 0) {
				IA32PageDirectory pt[] = pageDirectoryCells.toArray(new IA32PageDirectory[] {});
				DefaultGraphCell vertex1 = new DefaultGraphCell(new String("Vertex1"), null, pt);
				vertex1.add(new DefaultPort());
				cells.add(vertex1);

				DefaultEdge edge = new DefaultEdge();
				edge.setSource(root.getChildAt(0));
				edge.setTarget(vertex1.getLastChild());
				int arrow = GraphConstants.ARROW_CLASSIC;
				GraphConstants.setLineEnd(edge.getAttributes(), arrow);
				GraphConstants.setEndFill(edge.getAttributes(), true);

				// lastObj = cells[index];
				cells.add(edge);
			}

			graph.getGraphLayoutCache().insert(cells.toArray());
			graph.setDisconnectable(false);

			JGraphFacade facade = new JGraphFacade(graph);
			JGraphLayout layout = new JGraphTreeLayout();
			((JGraphTreeLayout) layout).setOrientation(SwingConstants.WEST);
			// ((JGraphHierarchicalLayout) layout).setNodeDistance(100);
			layout.run(facade);
			Map nested = facade.createNestedMap(true, true);
			graph.getGraphLayoutCache().edit(nested);

			// JGraphFacade facade = new JGraphFacade(graph);
			// JGraphLayout layout = new JGraphFastOrganicLayout();
			// layout.run(facade);
			// Map nested = facade.createNestedMap(true, true);
			// graph.getGraphLayoutCache().edit(nested);

			jPageTableGraphPanel.removeAll();
			jPageTableGraphPanel.add(new JScrollPane(graph), BorderLayout.CENTER);
		}

	}

	private void updateStack() {
		try {
			jStatusLabel.setText("Updating stack");
			// commandReceiver.setCommandNoOfLine(512);

			commandReceiver.clearBuffer();
			sendCommand("print-stack 40");
			String result = commandReceiver.getCommandResultUntilEnd();
			String[] lines = result.split("\n");
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

	private void updateInstruction(Long address) {
		try {
			String command;
			jStatusLabel.setText("Updating instruction");
			if (address == null) {
				Long cs = CommonLib.hex2decimal(this.jRegisterPanel1.jCSTextField.getText());
				Long eip = CommonLib.hex2decimal(this.jRegisterPanel1.jEIPTextField.getText()) + 75;
				command = "disassemble cs:eip 0x" + Long.toHexString(cs) + ":0x" + Long.toHexString(eip + 100);
				// System.out.println(command);
			} else {
				command = "disassemble " + address;
			}
			commandReceiver.clearBuffer();
			sendCommand(command);
			Thread.currentThread().sleep(100);
			// commandReceiver.setCommandNoOfLine(15);
			String result = commandReceiver.getCommandResultUntilEnd();
			String lines[] = result.split("\n");
			if (lines.length > 0) {
				try {
					if (!lines[0].contains("not available")) {
						this.jInstructionComboBox.setSelectedItem("0x" + lines[0].split(" ")[1].trim().replaceAll(":", ""));
					} else {
						JOptionPane.showMessageDialog(this, lines[0]);
						return;
					}
				} catch (Exception ex) {
				}
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
						model.addRow(new String[] { strs[0].trim() + " " + strs[1].trim().replaceAll("\\( *\\)", ""), strs[2].trim() });
					} catch (Exception ex) {
						// System.out.println("error 1 : cannot parse"
						// + lines[x]);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateGDT() {
		try {
			jStatusLabel.setText("Updating GDT");
			// commandReceiver.setCommandNoOfLine(20);

			int limit = Integer.parseInt(this.jRegisterPanel1.jGDTRLimitTextField.getText().substring(2), 16);
			limit = (limit + 1) / 8 - 1;
			if (limit > 100) {
				limit = 100;
			}
			commandReceiver.clearBuffer();
			sendCommand("info gdt 0 " + limit);
			String limitStr = String.format("0x%02x", limit);

			String result = commandReceiver.getCommandResult("GDT[0x00]", "GDT[" + limitStr + "]");
			String lines[] = result.split("\n");
			JGDTTableModel model = (JGDTTableModel) jGDTTable.getModel();
			model.clear();
			// jStatusProgressBar.setMaximum(lines.length - 1);
			boolean start = false;
			for (int x = 1; x < lines.length; x++) {
				jStatusLabel.setText("Updating GDT " + x);
				// System.out.println(">++>>" + lines[x]);
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

			commandReceiver.clearBuffer();

			int limit = Integer.parseInt(this.jRegisterPanel1.jIDTRLimitTextField.getText().substring(2), 16);
			limit = (limit + 1) / 8 - 1;
			if (limit > 25) {
				limit = 25;
			}
			sendCommand("info idt 0 " + limit);

			String limitStr = String.format("0x%02x", limit);

			String result = commandReceiver.getCommandResult("IDT[0x00]", "IDT[" + limitStr + "]");
			String lines[] = result.split("\n");
			JIDTTableModel model = (JIDTTableModel) jIDTTable.getModel();
			model.clear();
			jStatusProgressBar.setMaximum(lines.length - 1);
			for (int x = 1; x < lines.length; x++) {
				jStatusLabel.setText("Updating IDT " + x);
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
			// commandReceiver.setCommandNoOfLine(20);
			sendCommand("info ldt 0 20");
			String result = commandReceiver.getCommandResult("XX", "XX");
			String lines[] = result.split("\n");
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

	private void changeText(JTextField jTextField, String value) {
		Long l = CommonLib.string2decimal(value);
		if (jTextField.getText().equals(value)) {
			jTextField.setForeground(Color.black);
		} else {
			jTextField.setForeground(Color.red);
		}
		jTextField.setText("0x" + Long.toHexString(l));
	}

	private void updateRegister() {
		try {
			jStatusLabel.setText("Updating general registers");
			// System.out.println("want r");
			sendCommand("r");
			String result = commandReceiver.getCommandResult("ax:", "eflags");
			// System.out.println(result);
			String lines[] = result.split("\n");
			jStatusProgressBar.setMaximum(lines.length - 1);
			int x = 0;
			for (String line : lines) {
				jStatusProgressBar.setValue(x++);
				if (line.matches(".*.ax:.*")) {
					changeText(this.jRegisterPanel1.jEAXTextField, line.replaceAll(":", "").replaceAll("^.*ax", "").split(" ")[1]);
				}
				if (line.matches(".*.bx:.*")) {
					changeText(this.jRegisterPanel1.jEBXTextField, line.replaceAll(":", "").replaceAll("^.*bx", "").split(" ")[1]);
				}
				if (line.matches(".*.cx:.*")) {
					changeText(this.jRegisterPanel1.jECXTextField, line.replaceAll(":", "").replaceAll("^.*cx", "").split(" ")[1]);
				}
				if (line.matches(".*.dx:.*")) {
					changeText(this.jRegisterPanel1.jEDXTextField, line.replaceAll(":", "").replaceAll("^.*dx", "").split(" ")[1]);
				}
				if (line.matches(".*.si:.*")) {
					changeText(this.jRegisterPanel1.jESITextField, line.replaceAll(":", "").replaceAll("^.*si", "").split(" ")[1]);
				}
				if (line.matches(".*.di:.*")) {
					changeText(this.jRegisterPanel1.jEDITextField, line.replaceAll(":", "").replaceAll("^.*di", "").split(" ")[1]);
				}
				if (line.matches(".*.bp:.*")) {
					changeText(this.jRegisterPanel1.jEBPTextField, line.replaceAll(":", "").replaceAll("^.*bp", "").split(" ")[1]);
				}
				if (line.matches(".*.sp:.*")) {
					changeText(this.jRegisterPanel1.jESPTextField, line.replaceAll(":", "").replaceAll("^.*sp", "").split(" ")[1]);
				}
				if (line.matches(".*.ip:.*")) {
					changeText(this.jRegisterPanel1.jEIPTextField, line.replaceAll(":", "").replaceAll("^.*ip", "").split(" ")[1]);
				}
				if (line.matches(".*eflags .*")) {
					changeText(this.jRegisterPanel1.jEFLAGSTextField, line.replaceAll(":", "").replaceAll("^.*eflags", "").split(" ")[1]);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (version.contains("2.4.1")) {
			try {
				// sregs
				jStatusLabel.setText("Updating segment registers");
				// System.out.println("want sreg");
				commandReceiver.clearBuffer();
				sendCommand("sreg");
				String result = commandReceiver.getCommandResult("s:", "idtr:");
				// System.out.println(result);
				String[] lines = result.split("\n");

				int x = 0;
				jStatusProgressBar.setMaximum(lines.length - 1);

				for (String line : lines) {
					line = line.replaceFirst("<.*>", "");
					jStatusProgressBar.setValue(x++);
					String str[] = line.split(" ");

					if (line.matches(".*cs:.*")) {
						System.out.println("===" + line.split("=")[1].split(",")[0]);
						changeText(this.jRegisterPanel1.jCSTextField, line.split("=")[1].split(",")[0]);
					}
					if (line.matches(".*ds:.*")) {
						changeText(this.jRegisterPanel1.jDSTextField, line.split("=")[1].split(",")[0]);
					}
					if (line.matches(".*es:.*")) {
						changeText(this.jRegisterPanel1.jESTextField, line.split("=")[1].split(",")[0]);
					}
					if (line.matches(".*fs:.*")) {
						changeText(this.jRegisterPanel1.jFSTextField, line.split("=")[1].split(",")[0]);
					}
					if (line.matches(".*gs:.*")) {
						changeText(this.jRegisterPanel1.jGSTextField, line.split("=")[1].split(",")[0]);
					}
					if (line.matches(".*ss:.*")) {
						changeText(this.jRegisterPanel1.jSSTextField, line.split("=")[1].split(",")[0]);
					}
					if (line.matches(".*gdtr:.*")) {
						changeText(this.jRegisterPanel1.jGDTRTextField, line.split("=")[1].split(",")[0]);
						changeText(this.jRegisterPanel1.jGDTRLimitTextField, str[1].split("=")[1]);
					}
					if (line.matches(".*ldtr.*")) {
						changeText(this.jRegisterPanel1.jLDTRTextField, line.split("=")[1].split(",")[0]);
					}
					if (line.matches(".*idtr:.*")) {
						changeText(this.jRegisterPanel1.jIDTRTextField, line.split("=")[1].split(",")[0]);
						changeText(this.jRegisterPanel1.jIDTRLimitTextField, str[1].split("=")[1]);
					}
					if (line.matches(".*tr:.*")) {
						changeText(this.jRegisterPanel1.jTRTextField, line.split("=")[1].split(",")[0]);
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			try {
				// sregs
				jStatusLabel.setText("Updating segment registers");
				// System.out.println("want sreg");
				commandReceiver.clearBuffer();
				sendCommand("sreg");
				String result = commandReceiver.getCommandResult("s:", "idtr:");
				// System.out.println(result);
				String[] lines = result.split("\n");

				int x = 0;
				jStatusProgressBar.setMaximum(lines.length - 1);

				for (String line : lines) {
					line = line.replaceFirst("<.*>", "");
					jStatusProgressBar.setValue(x++);
					String str[] = line.split(" ");

					if (line.matches(".*cs:.*")) {
						changeText(this.jRegisterPanel1.jCSTextField, line.split(":")[1].split(",")[0]);
					}
					if (line.matches(".*ds:.*")) {
						changeText(this.jRegisterPanel1.jDSTextField, line.split(":")[1].split(",")[0]);
					}
					if (line.matches(".*es:.*")) {
						changeText(this.jRegisterPanel1.jESTextField, line.split(":")[1].split(",")[0]);
					}
					if (line.matches(".*fs:.*")) {
						changeText(this.jRegisterPanel1.jFSTextField, line.split(":")[1].split(",")[0]);
					}
					if (line.matches(".*gs:.*")) {
						changeText(this.jRegisterPanel1.jGSTextField, line.split(":")[1].split(",")[0]);
					}
					if (line.matches(".*ss:.*")) {
						changeText(this.jRegisterPanel1.jSSTextField, line.split(":")[1].split(",")[0]);
					}
					if (line.matches(".*gdtr:.*")) {
						changeText(this.jRegisterPanel1.jGDTRTextField, line.split("=")[1].split(",")[0]);
						changeText(this.jRegisterPanel1.jGDTRLimitTextField, str[1].split("=")[1]);
					}
					if (line.matches(".*ldtr.*")) {
						changeText(this.jRegisterPanel1.jLDTRTextField, line.split("=")[1].split(",")[0]);
					}
					if (line.matches(".*idtr:.*")) {
						changeText(this.jRegisterPanel1.jIDTRTextField, line.split("=")[1].split(",")[0]);
						changeText(this.jRegisterPanel1.jIDTRLimitTextField, str[1].split("=")[1]);
					}
					if (line.matches(".*tr:.*")) {
						changeText(this.jRegisterPanel1.jTRTextField, line.split("=")[1].split(",")[0]);
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		try {
			// cregs
			jStatusLabel.setText("Updating control registers");
			// commandReceiver.setCommandNoOfLine(Integer.parseInt(bochsCommandLength.get(0).get("cregs").toString()));
			commandReceiver.clearBuffer();
			sendCommand("creg");
			String result = commandReceiver.getCommandResult("CR0", "CR4");
			String[] lines = result.split("\n");

			int x = 0;
			jStatusProgressBar.setMaximum(lines.length - 1);

			for (String line : lines) {
				jStatusProgressBar.setValue(x++);
				if (line.matches(".*CR0=.*")) {
					changeText(this.jRegisterPanel1.jCR0TextField, line.split(" ")[1].split("=")[1].replace(":", ""));
					String arr[] = line.split(":")[2].split(" ");

					jRegisterPanel1.jCR0DetailLabel.setText("");
					jRegisterPanel1.jCR0DetailLabel2.setText(" ");
					for (int z = 0; z < 7; z++) {
						jRegisterPanel1.jCR0DetailLabel.setText(jRegisterPanel1.jCR0DetailLabel.getText() + arr[z] + " ");
					}
					for (int z = 7; z < arr.length; z++) {
						jRegisterPanel1.jCR0DetailLabel2.setText(jRegisterPanel1.jCR0DetailLabel2.getText() + arr[z] + " ");
					}
				}
				if (line.matches(".*CR2=.*")) {
					changeText(this.jRegisterPanel1.jCR2TextField, line.split(" ")[2].split("=")[1]);
				}
				if (line.matches(".*CR3=.*")) {
					changeText(this.jRegisterPanel1.jCR3TextField, line.split(" ")[0].split("=")[1]);
				}
				if (line.matches(".*CR4=.*")) {
					changeText(this.jRegisterPanel1.jCR4TextField, line.split(" ")[0].split("=")[1].replace(":", ""));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			// dregs
			jStatusLabel.setText("Updating debug registers");
			// commandReceiver.setCommandNoOfLine(Integer.parseInt(bochsCommandLength.get(0).get("cregs").toString()));
			sendCommand("dreg");
			String result = commandReceiver.getCommandResult("DR0", "DR7");
			String[] lines = result.split("\n");

			int x = 0;
			jStatusProgressBar.setMaximum(lines.length - 1);

			for (String line : lines) {
				jStatusProgressBar.setValue(x++);
				if (line.matches(".*DR0=.*")) {
					changeText(this.jRegisterPanel1.jDR0TextField, line.split("=")[1].split(":")[0]);
				}
				if (line.matches(".*DR1=.*")) {
					changeText(this.jRegisterPanel1.jDR1TextField, line.split("=")[1].split(":")[0]);
				}
				if (line.matches(".*DR2=.*")) {
					changeText(this.jRegisterPanel1.jDR2TextField, line.split("=")[1].split(":")[0]);
				}
				if (line.matches(".*DR3=.*")) {
					changeText(this.jRegisterPanel1.jDR3TextField, line.split("=")[1].split(":")[0]);
				}
				if (line.matches(".*DR6=.*")) {
					changeText(this.jRegisterPanel1.jDR6TextField, line.split("=")[1].split(":")[0]);
				}
				if (line.matches(".*DR7=.*")) {
					changeText(this.jRegisterPanel1.jDR7TextField, line.split("=")[1].split(":")[0]);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void updateMemory() {
		try {
			jStatusLabel.setText("Updating memory");
			int totalByte = 200;
			sendCommand("xp /" + totalByte + "bx " + this.jMemoryAddressComboBox.getSelectedItem().toString());
			currentMemoryWindowsAddress = CommonLib.string2decimal(this.jMemoryAddressComboBox.getSelectedItem().toString());

			if (totalByte > 0) {
				float totalByte2 = totalByte - 1;
				totalByte2 = totalByte2 / 8;
				int totalByte3 = (int) Math.floor(totalByte2);
				String realEndAddressStr;
				String realStartAddressStr;
				String base = this.jMemoryAddressComboBox.getSelectedItem().toString();
				long realStartAddress = CommonLib.string2decimal(base);
				realStartAddressStr = String.format("%08x", realStartAddress);
				long realEndAddress = realStartAddress + totalByte3 * 8;
				realEndAddressStr = String.format("%08x", realEndAddress);
				// System.out.println(realStartAddressStr);
				// System.out.println(realEndAddressStr);
				String result = commandReceiver.getCommandResult(realStartAddressStr, realEndAddressStr);
				// System.out.println(result);
				String[] lines = result.split("\n");
				String bytes[] = new String[totalByte];
				int offset = 0;
				// System.out.println(result);
				jStatusProgressBar.setMaximum(lines.length - 1);
				for (int y = 0; y < lines.length; y++) {
					jStatusProgressBar.setValue(y);
					String[] b = lines[y].replaceFirst("^.*:", "").split("\t");
					// System.out.println(lines[y]);
					for (int x = 1; x < b.length && x < 200; x++) {
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
				jHexTable1.getModel().setCurrentAddress(CommonLib.string2decimal(this.jMemoryAddressComboBox.getSelectedItem().toString()));
				jHexTable1.updateUI();
			}
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
				if (jTabbedPane2.getTitleAt(x).equals(("GDT " + String.format("0x%02x", jGDTTable.getSelectedRow() + 1)))) {
					jTabbedPane2.setSelectedIndex(x);
					return;
				}
			}
			JScrollPane temp = new JScrollPane();
			temp.setViewportView(new GDTLDTPanel(this, 0, CommonLib.hex2decimal(this.jRegisterPanel1.jGDTRTextField.getText()), jGDTTable.getSelectedRow() + 1));
			jTabbedPane2.addTab("GDT " + String.format("0x%02x", jGDTTable.getSelectedRow() + 1), temp);
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
			temp.setViewportView(new GDTLDTPanel(this, 1, CommonLib.hex2decimal(this.jRegisterPanel1.jGDTRTextField.getText()), jLDTTable.getSelectedRow()));
			jTabbedPane2.addTab("LDT " + jLDTTable.getSelectedRow(), temp);
			jTabbedPane2.setSelectedIndex(jTabbedPane2.getTabCount() - 1);
		}
	}

	private void jButton2ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!CommonLib.saveImage(jHexTable1, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void jUpdateBochsButtonActionPerformed(ActionEvent evt) {
		updateBochsStatus();
	}

	private void jPageDirectoryTableMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			jStatusProgressBar.setValue(0);
			String pageTableAddress = jPageDirectoryTable.getValueAt(jPageDirectoryTable.getSelectedRow(), 1).toString();

			// commandReceiver.setCommandNoOfLine(512);
			sendCommand("xp /4096bx " + pageTableAddress);

			float totalByte2 = 4096 - 1;
			totalByte2 = totalByte2 / 8;
			int totalByte3 = (int) Math.floor(totalByte2);
			String realEndAddressStr;
			String realStartAddressStr;
			String baseAddress = pageTableAddress;
			long realStartAddress = CommonLib.hex2decimal(baseAddress);

			realStartAddressStr = String.format("%08x", realStartAddress);
			long realEndAddress = realStartAddress + totalByte3 * 8;
			realEndAddressStr = String.format("%08x", realEndAddress);

			String result = commandReceiver.getCommandResult(realStartAddressStr, realEndAddressStr);
			String[] lines = result.split("\n");
			DefaultTableModel model = (DefaultTableModel) jPageTableTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			for (int y = 0; y < lines.length; y++) {
				jStatusProgressBar.setValue(y * 100 / lines.length);
				String[] b = lines[y].replaceFirst("^.*:", "").trim().split("\t");

				for (int z = 0; z < 2; z++) {
					try {
						byte bytes[] = new byte[4];
						for (int x = 0; x < 4; x++) {
							bytes[x] = (byte) (long) CommonLib.hex2decimal(b[x + z * 4].substring(2).trim());
						}
						int value = CommonLib.getInt(bytes, 0);
						// "No.", "PT base", "AVL", "G",
						// "D", "A", "PCD", "PWT",
						// "U/S", "W/R", "P"

						String base = "0x" + Long.toHexString(CommonLib.getValue(value, 12, 31) << 12);
						String avl = String.valueOf((value >> 9) & 3);
						String g = String.valueOf((value >> 8) & 1);
						String d = String.valueOf((value >> 6) & 1);
						String a = String.valueOf((value >> 5) & 1);
						String pcd = String.valueOf((value >> 4) & 1);
						String pwt = String.valueOf((value >> 3) & 1);
						String us = String.valueOf((value >> 2) & 1);
						String wr = String.valueOf((value >> 1) & 1);
						String p = String.valueOf((value >> 0) & 1);
						model.addRow(new String[] { String.valueOf(y * 2 + z), base, avl, g, d, a, pcd, pwt, us, wr, p });
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
		jRefreshBreakpointButton.setEnabled(false);
		updateBreakpoint();
		jRefreshBreakpointButton.setEnabled(true);
	}

	private void updateBreakpoint() {
		try {
			// commandReceiver.setCommandNoOfLine(-1);
			commandReceiver.clearBuffer();
			sendCommand("info break");
			// Thread.currentThread().sleep(200);
			String result = commandReceiver.getCommandResultUntilEnd();
			String[] lines = result.split("\n");
			DefaultTableModel model = (DefaultTableModel) jBreakpointTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}

			for (int x = 1; x < lines.length; x++) {
				if (lines[x].contains("breakpoint")) {
					Vector<String> strs = new Vector<String>(Arrays.asList(lines[x].trim().split(" \\s")));
					strs.add("0"); // hit count
					if (strs.size() > 1) {
						strs.remove(1);
						model.addRow(strs);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void jDisassembleButtonActionPerformed(ActionEvent evt) {
		jDisassembleButton.setEnabled(false);
		this.updateInstruction(null);
		jDisassembleButton.setEnabled(true);
	}

	private void jAddBreakpointButtonActionPerformed(ActionEvent evt) {
		jAddBreakpointButton.setEnabled(false);
		String type = (String) JOptionPane.showInputDialog(this, null, "Add breakpoint", JOptionPane.QUESTION_MESSAGE, null, new Object[] { language.getString("Physical_address"),
				language.getString("Linear_address") }, "Breakpoint");
		if (type != null) {
			String address = JOptionPane.showInputDialog(this, "Please input breakpoint address", "Add breakpoint", JOptionPane.QUESTION_MESSAGE);
			if (address != null) {
				if (type.equals(language.getString("Physical_address"))) {
					sendCommand("pb " + address);
				} else {
					sendCommand("lb " + address);
				}
				updateBreakpoint();
			}
		}
		jAddBreakpointButton.setEnabled(true);
	}

	private void jSaveBreakpointButtonActionPerformed(ActionEvent evt) {
		jSaveBreakpointButton.setEnabled(false);
		Vector<HashMap> v = new Vector<HashMap>();

		for (int x = 0; x < this.jBreakpointTable.getRowCount(); x++) {
			HashMap<String, String> h = new HashMap<String, String>();
			h.put("no", String.valueOf(x));
			h.put("type", this.jBreakpointTable.getValueAt(x, 1).toString());
			h.put("address", this.jBreakpointTable.getValueAt(x, 2).toString());
			h.put("hit", this.jBreakpointTable.getValueAt(x, 3).toString());
			v.add(h);
		}
		XMLHelper.vectorToXML("breakpoint.xml", "breakpoints", "record", v);
		jSaveBreakpointButton.setEnabled(true);
	}

	private void jLoadBreakpointButtonActionPerformed(ActionEvent evt) {
		jLoadBreakpointButton.setEnabled(false);
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
		jLoadBreakpointButton.setEnabled(true);
	}

	private void jDeleteBreakpointButtonActionPerformed(ActionEvent evt) {
		jDeleteBreakpointButton.setEnabled(false);
		int rows[] = jBreakpointTable.getSelectedRows();
		for (int x = 0; x < rows.length; x++) {
			sendCommand("del " + jBreakpointTable.getValueAt(rows[x], 0).toString().trim().split(" ")[0]);
		}
		updateBreakpoint();
		jDeleteBreakpointButton.setEnabled(true);
	}

	private void jDisableBreakpointButtonActionPerformed(ActionEvent evt) {
		jDisableBreakpointButton.setEnabled(false);
		int rows[] = jBreakpointTable.getSelectedRows();
		for (int x = 0; x < rows.length; x++) {
			sendCommand("bpd " + jBreakpointTable.getValueAt(rows[x], 0).toString().trim().split(" ")[0]);
		}
		updateBreakpoint();
		jDisableBreakpointButton.setEnabled(true);
	}

	private void jEnableBreakpointButtonActionPerformed(ActionEvent evt) {
		jEnableBreakpointButton.setEnabled(false);
		int rows[] = jBreakpointTable.getSelectedRows();
		for (int x = 0; x < rows.length; x++) {
			sendCommand("bpe " + jBreakpointTable.getValueAt(rows[x], 0).toString().trim().split(" ")[0]);
		}
		updateBreakpoint();
		jEnableBreakpointButton.setEnabled(true);
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
			TableModel jAddressTranslateTableModel = new DefaultTableModel(new String[][] {}, new String[] { language.getString("From"), language.getString("To") });
			jAddressTranslateTable = new JTable();
			jAddressTranslateTable.setModel(jAddressTranslateTableModel);
		}
		return jAddressTranslateTable;
	}

	private JMenu getJFontMenu() {
		if (jFontMenu == null) {
			jFontMenu = new JMenu();
			jFontMenu.setText(language.getString("Font"));
			jFontMenu.add(getJMenu1());
			jFontMenu.add(getJMenu2());
		}
		return jFontMenu;
	}

	private JMenuItem getJFont8MenuItem() {
		if (jFont8MenuItem == null) {
			jFont8MenuItem = new JMenuItem();
			jFont8MenuItem.setText("8");
			jFont8MenuItem.setBounds(0, -110, 80, 22);
			jFont8MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jFont8MenuItemActionPerformed(evt);
				}
			});
		}
		return jFont8MenuItem;
	}

	private JMenuItem getJFont10MenuItem() {
		if (jFont10MenuItem == null) {
			jFont10MenuItem = new JMenuItem();
			jFont10MenuItem.setText("10");
			jFont10MenuItem.setBounds(0, -88, 80, 22);
			jFont10MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jFont10MenuItemActionPerformed(evt);
				}
			});
		}
		return jFont10MenuItem;
	}

	private JMenuItem getJFont12MenuItem() {
		if (jFont12MenuItem == null) {
			jFont12MenuItem = new JMenuItem();
			jFont12MenuItem.setText("12");
			jFont12MenuItem.setBounds(0, -66, 80, 22);
			jFont12MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jFont12MenuItemActionPerformed(evt);
				}
			});
		}
		return jFont12MenuItem;
	}

	private JMenuItem getJFont14MenuItem() {
		if (jFont14MenuItem == null) {
			jFont14MenuItem = new JMenuItem();
			jFont14MenuItem.setText("14");
			jFont14MenuItem.setBounds(0, -44, 80, 22);
			jFont14MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jFont14MenuItemActionPerformed(evt);
				}
			});
		}
		return jFont14MenuItem;
	}

	private void jFont14MenuItemActionPerformed(ActionEvent evt) {
		fontsize = 14;
		setFont();
	}

	private void jFont12MenuItemActionPerformed(ActionEvent evt) {
		fontsize = 12;
		setFont();
	}

	private void jFont10MenuItemActionPerformed(ActionEvent evt) {
		fontsize = 10;
		setFont();
	}

	private void jFont8MenuItemActionPerformed(ActionEvent evt) {
		fontsize = 8;
		setFont();
	}

	private void setFont() {
		if (fontFamily != null && !fontFamily.trim().equals("") && fontsize > 0) {
			initGlobalFontSetting(new Font(fontFamily, Font.PLAIN, fontsize));
		}
		ini.put("global", "fontsize", fontsize);
		ini.put("global", "font", fontFamily);
	}

	public void initGlobalFontSetting(Font fnt) {
		FontUIResource fontRes = new FontUIResource(fnt);
		for (Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, fontRes);
			}
		}

		SwingUtilities.updateComponentTreeUI(this);
	}

	private JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JMenu();
			jMenu1.setText(language.getString("Size"));
			jMenu1.add(getJFont8MenuItem());
			jMenu1.add(getJFont10MenuItem());
			jMenu1.add(getJFont12MenuItem());
			jMenu1.add(getJFont14MenuItem());
		}
		return jMenu1;
	}

	private JMenu getJMenu2() {
		if (jMenu2 == null) {
			jMenu2 = new JMenu();
			jMenu2.setText(language.getString("Font"));
			jMenu2.add(getJArialMenuItem());
			jMenu2.add(getJDialogMenuItem());
		}
		return jMenu2;
	}

	private JMenuItem getJArialMenuItem() {
		if (jArialMenuItem == null) {
			jArialMenuItem = new JMenuItem();
			jArialMenuItem.setText("Arial");
			jArialMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jArialMenuItemActionPerformed(evt);
				}
			});
		}
		return jArialMenuItem;
	}

	private JMenuItem getJDialogMenuItem() {
		if (jDialogMenuItem == null) {
			jDialogMenuItem = new JMenuItem();
			jDialogMenuItem.setText("Dialog");
			jDialogMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jDialogMenuItemActionPerformed(evt);
				}
			});
		}
		return jDialogMenuItem;
	}

	private void jArialMenuItemActionPerformed(ActionEvent evt) {
		fontFamily = "Arial";
		setFont();
	}

	private void jDialogMenuItemActionPerformed(ActionEvent evt) {
		fontFamily = "Dialog";
		setFont();
	}

	private JMenu getJMenu6() {
		if (jMenu6 == null) {
			jMenu6 = new JMenu();
			jMenu6.setText(language.getString("Language"));
			jMenu6.add(getJMenuItem1());
			jMenu6.add(getJMenuItem2());
			jMenu6.add(getJMenuItem3());
		}
		return jMenu6;
	}

	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText(language.getString("English"));
			jMenuItem1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem1ActionPerformed(evt);
				}
			});
		}
		return jMenuItem1;
	}

	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText(language.getString("Traditional_chinese"));
			jMenuItem2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem2ActionPerformed(evt);
				}
			});
		}
		return jMenuItem2;
	}

	private JMenuItem getJMenuItem3() {
		if (jMenuItem3 == null) {
			jMenuItem3 = new JMenuItem();
			jMenuItem3.setText(language.getString("Simplified_chinese"));
			jMenuItem3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem3ActionPerformed(evt);
				}
			});
		}
		return jMenuItem3;
	}

	private void jMenuItem2ActionPerformed(ActionEvent evt) {
		changeLanguage("zh_TW");
	}

	private void jMenuItem1ActionPerformed(ActionEvent evt) {
		changeLanguage("en_US");
	}

	private void jMenuItem3ActionPerformed(ActionEvent evt) {
		changeLanguage("zh_CN");
	}

	private void changeLanguage(String language) {
		JOptionPane.showMessageDialog(this, "Please restart");

		ini.put("general", "language", language);

		try {
			ini.store();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private JTable getJHistoryTable() {
		if (jHistoryTable == null) {
			jHistoryTable = new JTable();
			jHistoryTable.setModel(new HistoryTableModel());
		}
		return jHistoryTable;
	}

	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setText("reg");
			jRadioButton1.setSelected(true);
			getButtonGroup2().add(jRadioButton1);
			jRadioButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRadioButton1ActionPerformed(evt);
				}
			});
		}
		return jRadioButton1;
	}

	private JPanel getJPanel13() {
		if (jPanel13 == null) {
			jPanel13 = new JPanel();
			FlowLayout jPanel13Layout = new FlowLayout();
			jPanel13Layout.setAlignment(FlowLayout.LEFT);
			jPanel13.setLayout(jPanel13Layout);
			{
				jLabel3 = new JLabel();
				jPanel13.add(jLabel3);
				jLabel3.setText(language.getString("Pause_history"));
			}
			jPanel13.add(getJRadioButton1());
			jPanel13.add(getJRadioButton2());
			jPanel13.add(getJButton1());
			jPanel13.add(getJButton4());
		}
		return jPanel13;
	}

	private JRadioButton getJRadioButton2() {
		if (jRadioButton2 == null) {
			jRadioButton2 = new JRadioButton();
			jRadioButton2.setText("tbl. desc.");
			getButtonGroup2().add(jRadioButton2);
			jRadioButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRadioButton2ActionPerformed(evt);
				}
			});
		}
		return jRadioButton2;
	}

	private ButtonGroup getButtonGroup2() {
		if (buttonGroup2 == null) {
			buttonGroup2 = new ButtonGroup();
		}
		return buttonGroup2;
	}

	private void jRadioButton1ActionPerformed(ActionEvent evt) {
		((HistoryTableModel) this.jHistoryTable.getModel()).setView("reg");
	}

	private void jRadioButton2ActionPerformed(ActionEvent evt) {
		((HistoryTableModel) this.jHistoryTable.getModel()).setView("tbl");
	}

	private JSplitPane getJSplitPane3() {
		if (jSplitPane3 == null) {
			jSplitPane3 = new JSplitPane();
			jSplitPane3.setDividerLocation(400);
			{
				jScrollPane7 = new JScrollPane();
				jSplitPane3.add(jScrollPane7, JSplitPane.RIGHT);
				{
					TableModel jTable1Model = new DefaultTableModel(new String[][] {}, new String[] { "No.", language.getString("Physical_address"), "AVL", "G", "PAT", "D", "A", "PCD", "PWT", "U/S",
							"W/R", "P" }) {
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					jPageTableTable = new JTable();
					jScrollPane7.setViewportView(jPageTableTable);
					jPageTableTable.setModel(jTable1Model);
					jPageTableTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					jPageTableTable.getColumnModel().getColumn(0).setPreferredWidth(40);
					for (int x = 2; x <= 11; x++) {
						jPageTableTable.getColumnModel().getColumn(x).setPreferredWidth(40);
					}
					jPageTableTable.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jPageTableTableMouseClicked(evt);
						}
					});
				}
			}
			{
				jScrollPane8 = new JScrollPane();
				jSplitPane3.add(jScrollPane8, JSplitPane.LEFT);
				{
					TableModel jPageDirectoryTableModel = new DefaultTableModel(new String[][] {}, new String[] { "No.", "PT base", "AVL", "G", "D", "A", "PCD", "PWT", "U/S", "W/R", "P" }) {
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					jPageDirectoryTable = new JTable();
					jScrollPane8.setViewportView(jPageDirectoryTable);
					jPageDirectoryTable.setModel(jPageDirectoryTableModel);
					jPageDirectoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					jPageDirectoryTable.getColumnModel().getColumn(0).setPreferredWidth(40);
					for (int x = 2; x < 11; x++) {
						jPageDirectoryTable.getColumnModel().getColumn(x).setPreferredWidth(40);
					}
					jPageDirectoryTable.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jPageDirectoryTableMouseClicked(evt);
						}
					});
				}
			}
		}
		return jSplitPane3;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/disk.png")));
		}
		return jButton1;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/disk.png")));
			jButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton2ActionPerformed(evt);
				}
			});
		}
		return jButton2;
	}

	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/disk.png")));
			jButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton3ActionPerformed(evt);
				}
			});
		}
		return jButton3;
	}

	private void jButton3ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!CommonLib.saveImage(jInstructionTable, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/excel.gif")));
			jButton4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton4ActionPerformed(evt);
				}
			});
		}
		return jButton4;
	}

	private void jButton4ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			CommonLib.exportRegisterHistory(file);
		}
	}

	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/excel.gif")));
			jButton5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton5ActionPerformed(evt);
				}
			});
		}
		return jButton5;
	}

	private void jButton5ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			CommonLib.exportTableModelToExcel(file, this.jHexTable1.getModel(), jMemoryAddressComboBox.getSelectedItem().toString());
		}
	}

	private JPanel getJPanel14() {
		if (jPanel14 == null) {
			jPanel14 = new JPanel();
			jPanel14.add(getJButton6());
			jPanel14.add(getJButton7());
			jPanel14.add(getJGDTGraphButton());
		}
		return jPanel14;
	}

	private JButton getJButton6() {
		if (jButton6 == null) {
			jButton6 = new JButton();
			jButton6.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/disk.png")));
			jButton6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton6ActionPerformed(evt);
				}
			});
		}
		return jButton6;
	}

	private void jButton6ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!CommonLib.saveImage(this.jGDTTable, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private JButton getJButton7() {
		if (jButton7 == null) {
			jButton7 = new JButton();
			jButton7.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/excel.gif")));
			jButton7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton7ActionPerformed(evt);
				}
			});
		}
		return jButton7;
	}

	private void jButton7ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			CommonLib.exportTableModelToExcel(file, this.jGDTTable.getModel(), "GDT");
		}
	}

	private JPanel getJPanel15() {
		if (jPanel15 == null) {
			jPanel15 = new JPanel();
			jPanel15.add(getJButton9());
			jPanel15.add(getJButton8());
		}
		return jPanel15;
	}

	private JPanel getJPanel16() {
		if (jPanel16 == null) {
			jPanel16 = new JPanel();
			jPanel16.add(getJButton11());
			jPanel16.add(getJButton10());
		}
		return jPanel16;
	}

	private JButton getJButton8() {
		if (jButton8 == null) {
			jButton8 = new JButton();
			jButton8.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/excel.gif")));
			jButton8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton8ActionPerformed(evt);
				}
			});
		}
		return jButton8;
	}

	private void jButton8ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			CommonLib.exportTableModelToExcel(file, this.jIDTTable.getModel(), "IDT");
		}
	}

	private JButton getJButton9() {
		if (jButton9 == null) {
			jButton9 = new JButton();
			jButton9.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/disk.png")));
			jButton9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton9ActionPerformed(evt);
				}
			});
		}
		return jButton9;
	}

	private void jButton9ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!CommonLib.saveImage(this.jIDTTable, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private JButton getJButton10() {
		if (jButton10 == null) {
			jButton10 = new JButton();
			jButton10.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/excel.gif")));
			jButton10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton10ActionPerformed(evt);
				}
			});
		}
		return jButton10;
	}

	private void jButton10ActionPerformed(ActionEvent evt) {
		System.out.println("jButton10.actionPerformed, event=" + evt);
		// TODO add your code for jButton10.actionPerformed
	}

	private JButton getJButton11() {
		if (jButton11 == null) {
			jButton11 = new JButton();
			jButton11.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/disk.png")));
			jButton11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton11ActionPerformed(evt);
				}
			});
		}
		return jButton11;
	}

	private void jButton11ActionPerformed(ActionEvent evt) {
		System.out.println("jButton11.actionPerformed, event=" + evt);
		// TODO add your code for jButton11.actionPerformed
	}

	private JButton getJButton12() {
		if (jButton12 == null) {
			jButton12 = new JButton();
			jButton12.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/excel.gif")));
			jButton12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton12ActionPerformed(evt);
				}
			});
		}
		return jButton12;
	}

	private void jButton12ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			CommonLib.exportTableModelToExcel(file, this.jInstructionTable.getModel(), "instruction 0x" + this.jInstructionComboBox.getSelectedItem().toString());
		}
	}

	private JButton getJButton13() {
		if (jButton13 == null) {
			jButton13 = new JButton();
			jButton13.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/excel.gif")));
			jButton13.setText("Excel");
			jButton13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton13ActionPerformed(evt);
				}
			});
		}
		return jButton13;
	}

	private void jButton13ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			Workbook wb = new HSSFWorkbook();// Write the output to a file
			CommonLib.exportRegisterHistory(file, wb);
			CommonLib.exportTableModelToExcel(file, this.jGDTTable.getModel(), "GDT", wb);
			CommonLib.exportTableModelToExcel(file, this.jIDTTable.getModel(), "IDT", wb);
			CommonLib.exportTableModelToExcel(file, this.jInstructionTable.getModel(), "instruction 0x" + this.jInstructionComboBox.getSelectedItem().toString(), wb);
			CommonLib.exportTableModelToExcel(file, this.jHexTable1.getModel(), jMemoryAddressComboBox.getSelectedItem().toString(), wb);
			FileOutputStream fileOut;
			try {
				fileOut = new FileOutputStream(file);
				wb.write(fileOut);
				fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private JPanel getJPanel17() {
		if (jPanel17 == null) {
			jPanel17 = new JPanel();
			BorderLayout jPanel17Layout = new BorderLayout();
			jPanel17.setLayout(jPanel17Layout);
			jPanel17.add(getJPanel18(), BorderLayout.NORTH);
			jPanel17.add(getJScrollPane12(), BorderLayout.CENTER);
		}
		return jPanel17;
	}

	private JPanel getJPanel18() {
		if (jPanel18 == null) {
			jPanel18 = new JPanel();
			jPanel18.add(getJLabel4());
			jPanel18.add(getJTextField1());
			jPanel18.add(getJLabel5());
			jPanel18.add(getJSearchMemoryFromComboBox());
			jPanel18.add(getJLabel6());
			jPanel18.add(getJSearchMemoryToComboBox());
			jPanel18.add(getJSearchMemoryButton());
			jPanel18.add(getJButton15());
		}
		return jPanel18;
	}

	private JScrollPane getJScrollPane12() {
		if (jScrollPane12 == null) {
			jScrollPane12 = new JScrollPane();
			jScrollPane12.setViewportView(getJSearchMemoryTable());
		}
		return jScrollPane12;
	}

	private JTable getJSearchMemoryTable() {
		if (jSearchMemoryTable == null) {
			jSearchMemoryTable = new JTable();
			jSearchMemoryTable.setModel(new SearchTableModel());
		}
		return jSearchMemoryTable;
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("hex/dec/string");
		}
		return jLabel4;
	}

	private JTextField getJTextField1() {
		if (jSearchMemoryTextField == null) {
			jSearchMemoryTextField = new JTextField();
			jSearchMemoryTextField.setPreferredSize(new java.awt.Dimension(84, 18));
		}
		return jSearchMemoryTextField;
	}

	private JLabel getJLabel5() {
		if (jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("from");
		}
		return jLabel5;
	}

	private JComboBox getJSearchMemoryFromComboBox() {
		if (jSearchMemoryFromComboBox == null) {
			ComboBoxModel jSearchMemoryFromComboBoxModel = new DefaultComboBoxModel(new String[] {});
			jSearchMemoryFromComboBox = new JComboBox();
			jSearchMemoryFromComboBox.setModel(jSearchMemoryFromComboBoxModel);
			jSearchMemoryFromComboBox.setEditable(true);
			jSearchMemoryFromComboBox.setPreferredSize(new java.awt.Dimension(120, 22));
		}
		return jSearchMemoryFromComboBox;
	}

	private JLabel getJLabel6() {
		if (jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setText("to");
		}
		return jLabel6;
	}

	private JComboBox getJSearchMemoryToComboBox() {
		if (jSearchMemoryToComboBox == null) {
			ComboBoxModel jSearchMemoryToComboBoxModel = new DefaultComboBoxModel(new String[] {});
			jSearchMemoryToComboBox = new JComboBox();
			jSearchMemoryToComboBox.setModel(jSearchMemoryToComboBoxModel);
			jSearchMemoryToComboBox.setEditable(true);
			jSearchMemoryToComboBox.setPreferredSize(new java.awt.Dimension(120, 22));
		}
		return jSearchMemoryToComboBox;
	}

	private JButton getJSearchMemoryButton() {
		if (jSearchMemoryButton == null) {
			jSearchMemoryButton = new JButton();
			jSearchMemoryButton.setText("Search");
			jSearchMemoryButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSearchMemoryButtonActionPerformed(evt);
				}
			});
		}
		return jSearchMemoryButton;
	}

	private void jSearchMemoryButtonActionPerformed(ActionEvent evt) {
		try {
			new SearchMemoryDialog(this, this.jSearchMemoryTable, this.jSearchMemoryTextField.getText(), CommonLib.string2decimal(this.jSearchMemoryFromComboBox.getSelectedItem().toString()),
					CommonLib.string2decimal(this.jSearchMemoryToComboBox.getSelectedItem().toString())).setVisible(true);
		} catch (Exception ex) {

		}
	}

	private JButton getJButton14() {
		if (jButton14 == null) {
			jButton14 = new JButton();
			jButton14.setText(language.getString("Disassemble"));
			jButton14.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton14ActionPerformed(evt);
				}
			});
		}
		return jButton14;
	}

	private void jButton14ActionPerformed(ActionEvent evt) {
		this.addInstructionComboBox(this.jInstructionComboBox.getSelectedItem().toString());
		jDisassembleButton.setEnabled(false);
		updateInstruction(CommonLib.string2decimal(this.jInstructionComboBox.getSelectedItem().toString()));
		jDisassembleButton.setEnabled(true);
	}

	private JButton getJButton15() {
		if (jButton15 == null) {
			jButton15 = new JButton();
			jButton15.setText(language.getString("Clear"));
			jButton15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton15ActionPerformed(evt);
				}
			});
		}
		return jButton15;
	}

	private void jButton15ActionPerformed(ActionEvent evt) {
		((SearchTableModel) this.jSearchMemoryTable.getModel()).removeAll();
	}

	private JPanel getJMainPanel() {
		if (jMainPanel == null) {
			jMainPanel = new JPanel();
			CardLayout jMainPanelLayout = new CardLayout();
			jMainPanel.setLayout(jMainPanelLayout);
			{
				jSplitPane2 = new JSplitPane();
				jMainPanel.add(jSplitPane2, "jSplitPane2");
				jMainPanel.add(getJRunningLabel(), "Running Label");
				jSplitPane2.setPreferredSize(new java.awt.Dimension(1009, 781));
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
							jTabbedPane1.addTab(language.getString("Instruction"), null, jPanel10, null);
							jPanel10.setPreferredSize(new java.awt.Dimension(604, 452));
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
									jInstructionControlPanel.add(getJButton14());
									jInstructionControlPanel.add(getJButton3());
									jInstructionControlPanel.add(getJButton12());
									jDisassembleButton.setText(language.getString("Disassemble") + " cs:eip");
									jDisassembleButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent evt) {
											jDisassembleButtonActionPerformed(evt);
										}
									});
								}
							}
							{
								jScrollPane5 = new JScrollPane();
								jPanel10.add(jScrollPane5, BorderLayout.CENTER);
								{
									TableModel jInstructionTableModel = new DefaultTableModel(new String[][] {}, new String[] { "Address", "Instruction" }) {
										public boolean isCellEditable(int row, int col) {
											return false;
										}
									};
									jInstructionTable = new JTable();
									jScrollPane5.setViewportView(jInstructionTable);
									jInstructionTable.setModel(jInstructionTableModel);
									jInstructionTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
									jInstructionTable.getColumnModel().getColumn(0).setPreferredWidth(40);
								}
							}
						}
						{
							jPanel4 = new JPanel();
							jTabbedPane1.addTab(language.getString("Breakpoint"), null, jPanel4, null);
							BorderLayout jPanel4Layout = new BorderLayout();
							jPanel4.setLayout(jPanel4Layout);
							{
								jScrollPane9 = new JScrollPane();
								jPanel4.add(jScrollPane9, BorderLayout.CENTER);
								{
									TableModel jTable1Model = new DefaultTableModel(new String[][] {}, new String[] { language.getString("No"), language.getString("Address_type"), "Disp Enb Address",
											language.getString("Hit") }) {
										public boolean isCellEditable(int row, int col) {
											return false;
										}
									};
									jBreakpointTable = new JTable();
									jScrollPane9.setViewportView(jBreakpointTable);
									jBreakpointTable.setModel(jTable1Model);
									jBreakpointTable.getColumnModel().getColumn(0).setCellRenderer(new JBreakpointTableCellRenderer());
								}
							}
							{
								jPanel12 = new JPanel();
								jPanel4.add(jPanel12, BorderLayout.SOUTH);
								{
									jAddBreakpointButton = new JButton();
									jPanel12.add(jAddBreakpointButton);
									jAddBreakpointButton.setText(language.getString("Add"));
									jAddBreakpointButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent evt) {
											jAddBreakpointButtonActionPerformed(evt);
										}
									});
								}
								{
									jDeleteBreakpointButton = new JButton();
									jPanel12.add(jDeleteBreakpointButton);
									jDeleteBreakpointButton.setText(language.getString("Del"));
									jDeleteBreakpointButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent evt) {
											jDeleteBreakpointButtonActionPerformed(evt);
										}
									});
								}
								{
									jRefreshBreakpointButton = new JButton();
									jPanel12.add(jRefreshBreakpointButton);
									jRefreshBreakpointButton.setText(language.getString("Refresh"));
									jRefreshBreakpointButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent evt) {
											jRefreshBreakpointButtonActionPerformed(evt);
										}
									});
								}
								{
									jEnableBreakpointButton = new JButton();
									jPanel12.add(jEnableBreakpointButton);
									jEnableBreakpointButton.setText(language.getString("Enable"));
									jEnableBreakpointButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent evt) {
											jEnableBreakpointButtonActionPerformed(evt);
										}
									});
								}
								{
									jDisableBreakpointButton = new JButton();
									jPanel12.add(jDisableBreakpointButton);
									jDisableBreakpointButton.setText(language.getString("Disable"));
									jDisableBreakpointButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent evt) {
											jDisableBreakpointButtonActionPerformed(evt);
										}
									});
								}
								{
									jSaveBreakpointButton = new JButton();
									jPanel12.add(jSaveBreakpointButton);
									jSaveBreakpointButton.setText(language.getString("Save"));
									jSaveBreakpointButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent evt) {
											jSaveBreakpointButtonActionPerformed(evt);
										}
									});
								}
								{
									jLoadBreakpointButton = new JButton();
									jPanel12.add(jLoadBreakpointButton);
									jLoadBreakpointButton.setText(language.getString("Load"));
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
							jTabbedPane1.addTab(language.getString("Bochs"), null, jPanel1, null);
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
							jTabbedPane3.addTab(language.getString("Memory"), null, jPanel8, null);
							{
								jScrollPane2 = new JScrollPane();
								jPanel8.add(jScrollPane2, BorderLayout.CENTER);
								{
									jHexTable1 = new JHexTable();
									jHexTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
									for (int x = 1; x < 9; x++) {
										jHexTable1.getColumnModel().getColumn(x).setPreferredWidth(10);
									}
									jScrollPane2.setViewportView(jHexTable1);
									jHexTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
									jHexTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
									jHexTable1.setCellSelectionEnabled(true);
									jHexTable1.addMouseListener(new MouseAdapter() {
										public void mouseClicked(MouseEvent evt) {
											jHexTable1MouseClicked(evt);
										}
									});
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
									jMemoryAddressComboBox.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent evt) {
											jMemoryAddressComboBoxActionPerformed(evt);
										}
									});
									addMemoryAddressComboBox("0x00000000");
									Vector<HashMap> vector = XMLHelper.xmltoVector("memoryCombo.xml", "/address/record");
									for (int x = 0; x < vector.size(); x++) {
										addMemoryAddressComboBox(vector.get(x).get("address").toString());
									}
								}
								{
									jGOMemoryButton = new JButton();
									jPanel9.add(jGOMemoryButton);
									jPanel9.add(getJButton2());
									jPanel9.add(getJButton5());
									jGOMemoryButton.setText(language.getString("Go"));
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
							jTabbedPane3.addTab(language.getString("GDT"), null, jPanel5, null);
							BorderLayout jPanel5Layout = new BorderLayout();
							jPanel5.setLayout(jPanel5Layout);
							{
								jScrollPane3 = new JScrollPane();
								jPanel5.add(jScrollPane3, BorderLayout.CENTER);
								jPanel5.add(getJPanel14(), BorderLayout.NORTH);
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
							jTabbedPane3.addTab(language.getString("IDT"), null, jPanel6, null);
							{
								jScrollPane10 = new JScrollPane();
								jPanel6.add(jScrollPane10, BorderLayout.CENTER);
								jPanel6.add(getJPanel15(), BorderLayout.NORTH);
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
							jTabbedPane3.addTab(language.getString("LDT"), null, jPanel7, null);
							jTabbedPane3.addTab(language.getString("Search_memory"), null, getJPanel17(), null);
							{
								jScrollPane11 = new JScrollPane();
								jPanel7.add(jScrollPane11, BorderLayout.CENTER);
								jPanel7.add(getJPanel16(), BorderLayout.NORTH);
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
						jTabbedPane2.addTab(language.getString("Register"), null, jScrollPane1, null);
						{
							jRegisterPanel1 = new JRegisterPanel(this);
							jScrollPane1.setViewportView(jRegisterPanel1);
						}
					}
					{
						jPanel3 = new JPanel();
						jTabbedPane2.addTab(language.getString("History"), null, jPanel3, null);
						TableLayout jPanel3Layout = new TableLayout(new double[][] { { TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL }, { 36.0, TableLayout.FILL } });
						jPanel3Layout.setHGap(5);
						jPanel3Layout.setVGap(5);
						jPanel3.setLayout(jPanel3Layout);
						{
							jScrollPane6 = new JScrollPane();
							jPanel3.add(jScrollPane6, "0, 1, 3, 1");
							jPanel3.add(getJPanel13(), "0, 0, 1, 0");
							jScrollPane6.setViewportView(getJHistoryTable());
						}
					}
					{
						jPanel11 = new JPanel();
						jTabbedPane2.addTab(language.getString("Paging"), null, jPanel11, null);
						jTabbedPane2.addTab(language.getString("Address_translate") + " (experimential)", null, getJAddressTranslatePanel(), null);
						jTabbedPane2.addTab("Page table graph (experimental)", null, getJPageTableGraphPanel(), null);
						jTabbedPane2.addTab(language.getString("Table_translate"), null, getJTableTranslateScrollPane(), null);
						BorderLayout jPanel11Layout = new BorderLayout();
						jPanel11.setLayout(jPanel11Layout);
						jPanel11.add(getJSplitPane3(), BorderLayout.CENTER);
						jPanel11.add(getJPanel19(), BorderLayout.NORTH);
					}
				}
			}
		}
		return jMainPanel;
	}

	private JLabel getJRunningLabel() {
		if (jRunningLabel == null) {
			jRunningLabel = new JLabel();
			URL url = getClass().getClassLoader().getResource("images/ajax-loader.gif");
			jRunningLabel.setText("<html><center>Bochs is running, click the pause button to pause it !!!<br><br><img src=\"" + url + "\" /></center></html>");
			jRunningLabel.setHorizontalAlignment(SwingConstants.CENTER);
			jRunningLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			jRunningLabel.setFont(new java.awt.Font("Arial", 0, 20));
			jRunningLabel.setForeground(Color.white);
			jRunningLabel.setBackground(new Color(0, 0, 0, 180));
			jRunningLabel.setOpaque(true);
			// jRunningLabel.setIcon(new
			// ImageIcon(getClass().getClassLoader().getResource("pfsbuilder/images/ajax-loader.gif")));
		}
		return jRunningLabel;
	}

	private JButton getJGDTGraphButton() {
		if (jGDTGraphButton == null) {
			jGDTGraphButton = new JButton();
			jGDTGraphButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/map.png")));
			jGDTGraphButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jGDTGraphButtonActionPerformed(evt);
				}
			});
		}
		return jGDTGraphButton;
	}

	private void jGDTGraphButtonActionPerformed(ActionEvent evt) {

	}

	private JPanel getJPanel19() {
		if (jPanel19 == null) {
			jPanel19 = new JPanel();
			FlowLayout jPanel19Layout = new FlowLayout();
			jPanel19Layout.setAlignment(FlowLayout.LEFT);
			jPanel19.setLayout(jPanel19Layout);
			jPanel19.add(getJPagingGraphButton());
		}
		return jPanel19;
	}

	private JButton getJPagingGraphButton() {
		if (jPagingGraphButton == null) {
			jPagingGraphButton = new JButton();
			jPagingGraphButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/printer.png")));
			jPagingGraphButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jPagingGraphButtonActionPerformed(evt);
				}
			});
		}
		return jPagingGraphButton;
	}

	private void jPagingGraphButtonActionPerformed(ActionEvent evt) {
	}

	private JPanel getJPageTableGraphPanel() {
		if (jPageTableGraphPanel == null) {
			jPageTableGraphPanel = new JPanel();
			BorderLayout jPageTableGraphPanelLayout = new BorderLayout();
			jPageTableGraphPanel.setLayout(jPageTableGraphPanelLayout);
			jPageTableGraphPanel.add(getJToolBar2(), BorderLayout.NORTH);
		}
		return jPageTableGraphPanel;
	}

	private JToolBar getJToolBar2() {
		if (jToolBar2 == null) {
			jToolBar2 = new JToolBar();
			jToolBar2.add(getJAutoRefreshPageTableGraphCheckBox());
			jToolBar2.add(getJRefreshPageTableGraphButton());
		}
		return jToolBar2;
	}

	private JCheckBox getJAutoRefreshPageTableGraphCheckBox() {
		if (jAutoRefreshPageTableGraphCheckBox == null) {
			jAutoRefreshPageTableGraphCheckBox = new JCheckBox();
			jAutoRefreshPageTableGraphCheckBox.setText("Auto refresh");
		}
		return jAutoRefreshPageTableGraphCheckBox;
	}

	private JButton getJRefreshPageTableGraphButton() {
		if (jRefreshPageTableGraphButton == null) {
			jRefreshPageTableGraphButton = new JButton();
			jRefreshPageTableGraphButton.setText("Refresh");
		}
		return jRefreshPageTableGraphButton;
	}

	private JPanel getJAddressTranslatePanel() {
		if (jAddressTranslatePanel == null) {
			jAddressTranslatePanel = new JPanel();
			BorderLayout jAddressTranslatePanelLayout = new BorderLayout();
			jAddressTranslatePanel.setLayout(jAddressTranslatePanelLayout);
			jAddressTranslatePanel.add(getJPanel20(), BorderLayout.WEST);
			jAddressTranslatePanel.add(getJPanel22(), BorderLayout.CENTER);
			jAddressTranslatePanel.add(getJToolBar3(), BorderLayout.NORTH);
		}
		return jAddressTranslatePanel;
	}

	private JPanel getJPanel20() {
		if (jPanel20 == null) {
			jPanel20 = new JPanel();
			TableLayout jPanel20Layout = new TableLayout(new double[][] { { 8.0, 156.0, 13.0 }, { 25.0, 25.0, 25.0, 22.0, 37.0, TableLayout.FILL } });
			jPanel20Layout.setHGap(5);
			jPanel20Layout.setVGap(5);
			jPanel20.setLayout(jPanel20Layout);
			jPanel20.setPreferredSize(new java.awt.Dimension(189, 629));
			jPanel20.add(getJRadioButton3(), "1, 0, 2, 0");
			jPanel20.add(getJRadioButton4(), "1, 1, 2, 1");
			jPanel20.add(getJRadioButton5(), "1, 2, 2, 2");
			jPanel20.add(getJPanel21(), "1, 4");
			jPanel20.add(getJAddressTextField(), "1, 3");
		}
		return jPanel20;
	}

	private JRadioButton getJRadioButton3() {
		if (jSearchAddressRadioButton1 == null) {
			jSearchAddressRadioButton1 = new JRadioButton();
			jSearchAddressRadioButton1.setText(language.getString("Virtual_address"));
			jSearchAddressRadioButton1.setSelected(true);
			getButtonGroup3().add(jSearchAddressRadioButton1);
		}
		return jSearchAddressRadioButton1;
	}

	private JRadioButton getJRadioButton4() {
		if (jSearchAddressRadioButton2 == null) {
			jSearchAddressRadioButton2 = new JRadioButton();
			jSearchAddressRadioButton2.setText(language.getString("Linear_address"));
			getButtonGroup3().add(jSearchAddressRadioButton2);
		}
		return jSearchAddressRadioButton2;
	}

	private JRadioButton getJRadioButton5() {
		if (jSearchAddressRadioButton3 == null) {
			jSearchAddressRadioButton3 = new JRadioButton();
			jSearchAddressRadioButton3.setText(language.getString("Physical_address"));
			getButtonGroup3().add(jSearchAddressRadioButton3);
		}
		return jSearchAddressRadioButton3;
	}

	private JButton getJButton16() {
		if (jButton16 == null) {
			jButton16 = new JButton();
			jButton16.setText(language.getString("Convert"));
			jButton16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton16ActionPerformed(evt);
				}
			});
		}
		return jButton16;
	}

	private JPanel getJPanel22() {
		if (jPanel22 == null) {
			jPanel22 = new JPanel();
			BorderLayout jPanel22Layout = new BorderLayout();
			jPanel22.setLayout(jPanel22Layout);
			jPanel22.add(getJScrollPane13(), BorderLayout.CENTER);
		}
		return jPanel22;
	}

	private JTable getJTable1() {
		if (jAddressTranslateTable2 == null) {
			jAddressTranslateTable2 = new JTable();
			AddressTranslateTableModel addressTranslateTableModel = new AddressTranslateTableModel();
			jAddressTranslateTable2.setModel(addressTranslateTableModel);
		}
		return jAddressTranslateTable2;
	}

	private JScrollPane getJScrollPane13() {
		if (jScrollPane13 == null) {
			jScrollPane13 = new JScrollPane();
			jScrollPane13.setPreferredSize(new java.awt.Dimension(150, 32));
			jScrollPane13.setViewportView(getJTable1());
		}
		return jScrollPane13;
	}

	private JToolBar getJToolBar3() {
		if (jToolBar3 == null) {
			jToolBar3 = new JToolBar();
			jToolBar3.add(getJButton17());
			jToolBar3.add(getJButton18());
			jToolBar3.add(getJRefreshAddressTranslateTableButton());
		}
		return jToolBar3;
	}

	private JButton getJButton17() {
		if (jButton17 == null) {
			jButton17 = new JButton();
			jButton17.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/printer.png")));
		}
		return jButton17;
	}

	private JButton getJButton18() {
		if (jButton18 == null) {
			jButton18 = new JButton();
			jButton18.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/excel.gif")));
		}
		return jButton18;
	}

	private ButtonGroup getButtonGroup3() {
		if (buttonGroup3 == null) {
			buttonGroup3 = new ButtonGroup();
		}
		return buttonGroup3;
	}

	private JPanel getJPanel21() {
		if (jPanel21 == null) {
			jPanel21 = new JPanel();
			jPanel21.add(getJButton16());
		}
		return jPanel21;
	}

	private JTextField getJAddressTextField() {
		if (jAddressTextField == null) {
			jAddressTextField = new JTextField();
		}
		return jAddressTextField;
	}

	private void jButton16ActionPerformed(ActionEvent evt) {
		AddressTranslateTableModel model = (AddressTranslateTableModel) this.jAddressTranslateTable2.getModel();

		if (jSearchAddressRadioButton1.isSelected()) {
			if (!this.jAddressTextField.getText().contains(":") || this.jAddressTextField.getText().replaceAll("[^:]", "").length() != 1) {
				JOptionPane.showMessageDialog(this, "Error, please input <segment selector>:<offset>\n\ne.g. : 0x10:0x12345678", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Long segSelector = CommonLib.string2decimal(this.jAddressTextField.getText().split(":")[0]);
			Long address = CommonLib.string2decimal(this.jAddressTextField.getText().split(":")[1]);

			for (int x = 0; x < model.getRowCount(); x++) {
				if (model.searchType.get(x).equals(1) && model.searchSegSelector.get(x).equals(segSelector) && model.searchAddress.get(x).equals(address)) {
					return;
				}
			}

			model.searchType.add(1);
			model.searchSegSelector.add(segSelector);
			model.searchAddress.add(address);

			model.virtualAddress.add(0L);
			model.segNo.add(0L);
			model.linearAddress.add(0L);
			model.pdNo.add(0L);
			model.ptNo.add(0L);
			model.physicalAddress.add(0L);
			model.bytes.add("");

			model.fireTableDataChanged();
		} else if (jSearchAddressRadioButton2.isSelected()) {
			for (int x = 0; x < model.getRowCount(); x++) {
				if (model.searchType.get(x).equals(2) && model.searchAddress.get(x).equals(CommonLib.string2decimal(this.jAddressTextField.getText()))) {
					return;
				}
			}
			Long addr = CommonLib.string2decimal(this.jAddressTextField.getText());
			model.searchType.add(2);
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

	private JButton getJRefreshAddressTranslateTableButton() {
		if (jRefreshAddressTranslateTableButton == null) {
			jRefreshAddressTranslateTableButton = new JButton();
			jRefreshAddressTranslateTableButton.setText(language.getString("Refresh"));
			jRefreshAddressTranslateTableButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/arrow_refresh.png")));
			jRefreshAddressTranslateTableButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRefreshAddressTranslateTableButtonActionPerformed(evt);
				}
			});
		}
		return jRefreshAddressTranslateTableButton;
	}

	private void jRefreshAddressTranslateTableButtonActionPerformed(ActionEvent evt) {
		AddressTranslateTableModel model = (AddressTranslateTableModel) this.jAddressTranslateTable2.getModel();
		for (int x = 0; x < model.getRowCount(); x++) {
			if (model.searchType.get(x).equals(1)) {
				model.segNo.set(x, model.searchSegSelector.get(x) >> 3);
				model.virtualAddress.set(x, model.searchAddress.get(x));

				long gdtBase = CommonLib.getPhysicalAddress(CommonLib.string2decimal(this.jRegisterPanel1.jCR3TextField.getText()), CommonLib.string2decimal(this.jRegisterPanel1.jGDTRTextField
						.getText()));
				System.out.println("gdtBase=" + Long.toHexString(gdtBase));
				commandReceiver.clearBuffer();
				gdtBase += model.segNo.get(x) * 8;
				sendCommand("xp /8bx " + gdtBase);
				String result = commandReceiver.getCommandResult(String.format("%08x", gdtBase));

				byte bytes[] = new byte[8];
				String[] b = result.replaceFirst("^.*:", "").split("\t");
				for (int y = 1; y <= 8; y++) {
					bytes[y - 1] = (byte) (long) CommonLib.string2decimal(b[y]);
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

	private void jHexTable1MouseClicked(MouseEvent evt) {
		if (SwingUtilities.isRightMouseButton(evt)) {
			// select
			Point p = evt.getPoint();
			int rowNumber = jHexTable1.rowAtPoint(p);
			int columnNumber = jHexTable1.columnAtPoint(p);
			ListSelectionModel model = jHexTable1.getSelectionModel();
			model.setSelectionInterval(rowNumber, rowNumber);
			jHexTable1.getColumnModel().getSelectionModel().setSelectionInterval(columnNumber, columnNumber);
			// end select

			getJHexTablePopupMenu().show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}

	private JPopupMenu getJHexTablePopupMenu() {
		if (jHexTablePopupMenu == null) {
			jHexTablePopupMenu = new JPopupMenu();
			jHexTablePopupMenu.add(getJMenu7());
			jHexTablePopupMenu.add(getJMenu8());
			jHexTablePopupMenu.add(getJMenuItem4());
			jHexTablePopupMenu.add(getJMenuItem5());
			jHexTablePopupMenu.add(getJMenuItem6());
			jHexTablePopupMenu.add(getJMenuItem7());
		}
		return jHexTablePopupMenu;
	}

	private JMenuItem getJMenu7() {
		if (jGDTMenuItem == null) {
			jGDTMenuItem = new JMenuItem();
			jGDTMenuItem.setText("GDT table");
			jGDTMenuItem.setBounds(0, 21, 115, 21);
			jGDTMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jGDTMenuItemActionPerformed(evt);
				}
			});
		}
		return jGDTMenuItem;
	}

	private JMenuItem getJMenu8() {
		if (jGDTDescriptorMenuItem == null) {
			jGDTDescriptorMenuItem = new JMenuItem();
			jGDTDescriptorMenuItem.setText("GDT descriptor");
			jGDTDescriptorMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jGDTDescriptorMenuItemActionPerformed(evt);
				}
			});
		}
		return jGDTDescriptorMenuItem;
	}

	private JMenuItem getJMenuItem4() {
		if (jIDTMenuItem == null) {
			jIDTMenuItem = new JMenuItem();
			jIDTMenuItem.setText("IDT table");
			jIDTMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jIDTMenuItemActionPerformed(evt);
				}
			});
		}
		return jIDTMenuItem;
	}

	private JMenuItem getJMenuItem5() {
		if (jIDTDescriptorMenuItem == null) {
			jIDTDescriptorMenuItem = new JMenuItem();
			jIDTDescriptorMenuItem.setText("IDT descriptor");
			jIDTDescriptorMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jIDTDescriptorMenuItemActionPerformed(evt);
				}
			});
		}
		return jIDTDescriptorMenuItem;
	}

	private JMenuItem getJMenuItem6() {
		if (jPDEMenuItem == null) {
			jPDEMenuItem = new JMenuItem();
			jPDEMenuItem.setText("PDE");
			jPDEMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jPDEMenuItemActionPerformed(evt);
				}
			});
		}
		return jPDEMenuItem;
	}

	private JMenuItem getJMenuItem7() {
		if (jPTEMenuItem == null) {
			jPTEMenuItem = new JMenuItem();
			jPTEMenuItem.setText("PTE");
			jPTEMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jPTEMenuItemActionPerformed(evt);
				}
			});
		}
		return jPTEMenuItem;
	}

	private void jGDTMenuItemActionPerformed(ActionEvent evt) {
		new HelperDialog(this, currentMemoryWindowsAddress + jHexTable1.getSelectedRow() * 8 + jHexTable1.getSelectedColumn() - 1, "GDT").setVisible(true);
	}

	private void jGDTDescriptorMenuItemActionPerformed(ActionEvent evt) {
		new HelperDialog(this, currentMemoryWindowsAddress + jHexTable1.getSelectedRow() * 8 + jHexTable1.getSelectedColumn() - 1, "GDT Descriptor").setVisible(true);
	}

	private void jIDTMenuItemActionPerformed(ActionEvent evt) {
		new HelperDialog(this, currentMemoryWindowsAddress + jHexTable1.getSelectedRow() * 8 + jHexTable1.getSelectedColumn() - 1, "IDT").setVisible(true);
	}

	private void jIDTDescriptorMenuItemActionPerformed(ActionEvent evt) {
		new HelperDialog(this, currentMemoryWindowsAddress + jHexTable1.getSelectedRow() * 8 + jHexTable1.getSelectedColumn() - 1, "IDT Descriptor").setVisible(true);
	}

	private void jPDEMenuItemActionPerformed(ActionEvent evt) {
		new HelperDialog(this, currentMemoryWindowsAddress + jHexTable1.getSelectedRow() * 8 + jHexTable1.getSelectedColumn() - 1, "PDE").setVisible(true);
	}

	private void jPTEMenuItemActionPerformed(ActionEvent evt) {
		new HelperDialog(this, currentMemoryWindowsAddress + jHexTable1.getSelectedRow() * 8 + jHexTable1.getSelectedColumn() - 1, "PTE").setVisible(true);
	}

	private void jMemoryAddressComboBoxActionPerformed(ActionEvent evt) {
		if (this.isVisible()) {
			jGOMemoryButtonActionPerformed(evt);
		}
	}

	private JMenu getJBochVersionMenu() {
		if (jBochVersionMenu == null) {
			jBochVersionMenu = new JMenu();
		}
		return jBochVersionMenu;
	}
}
