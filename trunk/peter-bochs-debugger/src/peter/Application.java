package peter;

import info.clearthought.layout.TableLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
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
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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
import javax.swing.JToggleButton;
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
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang.ArrayUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import peter.architecture.IA32PageDirectory;
import peter.elf.ElfUtil;
import peter.instrument.Data;
import peter.instrument.InstrumentPanel;
import peter.instrument.JmpSocketServerController;
import peter.instrument.MemorySocketServerController;
import peter.logpanel.LogPanel;
import peter.osdebuginformation.JOSDebugInformationPanel;
import peter.osdebuginformation.OSDebugInfoHelper;

import com.petersoft.advancedswing.diskpanel.DiskPanel;
import com.petersoft.advancedswing.jmaximizabletabbedpane.JMaximizableTabbedPane;
import com.petersoft.advancedswing.jmaximizabletabbedpane.JMaximizableTabbedPane_BasePanel;

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
	private JMaximizableTabbedPane jTabbedPane1;
	private JHexTable jHexTable1;
	private JEditorPane jBochsEditorPane;

	public static CommandReceiver commandReceiver;

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
	private JMaximizableTabbedPane jTabbedPane3;
	private JMenuItem pauseBochsMenuItem;
	private JPanel jPanel3;
	public JMaximizableTabbedPane jTabbedPane2;
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
	private JPanel jPanel24;
	private JToolBar jPanel26;
	private JToggleButton jRegisterToggleButton;
	private LogPanel logPanel1;
	private JToggleButton jLogToggleButton;
	private JToggleButton jProfilerToggleButton;
	private InstrumentPanel jInstrumentPanel;
	private JOSDebugInformationPanel jOSDebugInformationPanel1;
	private JLabel jOSDebugInfoErrorLabel;
	private JTabbedPane jTabbedPane5;
	private JPanel jOSDebugStandardPanel;
	private JButton jSettingButton;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem1;
	private JPopupMenu jELFTablePopupMenu;
	public JButton jFastStepBochsButton;
	private JMenuItem jJPMenuItem;
	private JMenuItem jKRMenuItem;
	private JButton jInstructionUpTenButton;
	private JButton jInstructionDownButton;
	private JButton jInstructionUpButton;
	private JMenuItem jMenuItem9;
	private JMenuItem jMenuItem8;
	private JPopupMenu jSearchMemoryTablePopupMenu;
	private JMenuItem jMenuItem7;
	private JMenuItem jMenuItem6;
	private JPopupMenu jBreakpointPopupMenu;
	private JMenuItem jMenuItem5;
	private JMenuItem jMenuItem4;
	private JPopupMenu jInstructionPanelPopupMenu;
	private JCheckBox jHideIfAddressIsZeroCheckBox;
	private JMaximizableTabbedPane_BasePanel jMaximizableTabbedPane_BasePanel1;
	private DiskPanel diskPanel;
	private JButton jGoLinearButton;
	private JButton jClearBochsButton;
	public JTextField jDumpPageDirectoryAddressTextField;
	private JButton jDumpPageTableAtAddressButton;
	private JButton jButton20;
	private JButton jButton19;
	private JTable jProgramHeaderTable;
	private JScrollPane jScrollPane16;
	private JTable jELFSectionTable;
	private JScrollPane jScrollPane15;
	private JTable jELFHeaderTable;
	private JScrollPane jELFHeaderScrollPane;
	private JMaximizableTabbedPane jTabbedPane4;
	private JButton jOpenELFDumpButton;
	private JComboBox jELFComboBox;
	private JPanel jELFDumpPanel;
	private JLabel jLatestVersionLabel;
	private JLabel jBochsVersionLabel;
	private JCheckBox jShowELFByteCheckBox;
	private JLabel jCPUModeLabel;
	private JPanel jPanel25;
	private JButton jLoadELFBreakpointButton;
	private JButton jSaveELFBreakpointButton;
	private JButton jDisableELFBreakpointButton;
	private JButton jEnableELFBreakpointButton;
	private JButton jRefreshELFBreakpointButton;
	private JTable jELFTable;
	private JScrollPane jScrollPane14;
	private JComboBox jELFFileComboBox;
	private JButton jOpenELFButton;
	private JPanel jPanel23;
	private JPanel jELFBreakpointPanel;
	private JMenuItem jDisassemble32MenuItem;
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
	private JButton jRefreshAddressTranslateButton;
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
	private JToolBar jPanel19;
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
	private JRadioButton jRadioButton2;
	private JToolBar jPanel13;
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
	private static String[] arguments;
	private JMenuItem jFont14MenuItem;
	private JMenuItem jFont12MenuItem;
	private JMenuItem jFont10MenuItem;
	private JMenuItem jFont8MenuItem;
	private JMenu jFontMenu;
	private JMenuItem jSCMenuItem;
	private JMenuItem jHKMenuItem;
	private JMenuItem jEnglishMenuItem;
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
	public static String version = "";
	private JButton jButton21;
	public static String bochsrc;
	static boolean preventSetVisibleHang = true;

	boolean breakpointLoadedOnce = false;
	private JScrollPane jScrollPane17;
	private JEditorPane jEditorPane1;
	private JButton jSearchObjdumpButton;
	private JTextField jTextField1;
	private JToolBar jPanel27;
	private JPanel objdumpPanel;
	private JButton jSearchRelPltButton;
	private JTextField jSearchRelPltTextField;
	private JToolBar jToolBar4;
	private JEditorPane jSearchRelPltEditorPane;
	private JScrollPane jScrollPane18;
	private JPanel jPanel28;

	private JEditorPane jSearchDynamicEditorPane;
	private JScrollPane jScrollPane19;
	private JButton jSearchDynamicButton;
	private JTextField jSearchDynamicTextField;
	private JToolBar jToolBar5;
	private JPanel jPanel29;

	private String currentPanel = "jMaximizableTabbedPane_BasePanel1";

	private ButtonGroup buttonGroup2 = new ButtonGroup();

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		try {
			if (Application.class.getProtectionDomain().getCodeSource().getLocation().getFile().endsWith(".jar")) {
				JarFile jarFile = new JarFile(Application.class.getProtectionDomain().getCodeSource().getLocation().getFile());
				InputStream is = jarFile.getInputStream(new JarEntry("exe/PauseBochs.exe"));
				InputStream is2 = jarFile.getInputStream(new JarEntry("exe/StopBochs.exe"));
				InputStream is3 = jarFile.getInputStream(new JarEntry("exe/ndisasm.exe"));

				BufferedOutputStream fOut = null;
				try {
					fOut = new BufferedOutputStream(new FileOutputStream(new File("PauseBochs.exe")));
					byte[] buffer = new byte[32 * 1024];
					int bytesRead = 0;
					while ((bytesRead = is.read(buffer)) != -1) {
						fOut.write(buffer, 0, bytesRead);
					}
					fOut.close();

					fOut = new BufferedOutputStream(new FileOutputStream(new File("StopBochs.exe")));
					buffer = new byte[32 * 1024];
					bytesRead = 0;
					while ((bytesRead = is2.read(buffer)) != -1) {
						fOut.write(buffer, 0, bytesRead);
					}
					fOut.close();

					fOut = new BufferedOutputStream(new FileOutputStream(new File("ndisasm.exe")));
					buffer = new byte[32 * 1024];
					bytesRead = 0;
					while ((bytesRead = is3.read(buffer)) != -1) {
						fOut.write(buffer, 0, bytesRead);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					is.close();
					is2.close();
					is3.close();
					fOut.close();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (args.length == 0) {
			System.out.println("Wrong number of argument");
			System.out.println("In Linux : java -jar peter-bochs-debugger.jar bochs -f bochxrc.bxrc");
			System.out.println("In windows : java -jar peter-bochs-debugger.jar c:\\program files\\bochs2.4.3\\bochsdbg.exe -q -f bochxrc.bxrc");
			System.out
					.println("!!! if using peter-bochs in windows, you need to pass the full path of bochs exe and -q to the parameter. (!!! relative path of bochs exe will not work)");
			System.out.println("!!! to use \"experimental feature\", please add \"-debug\" to the parameter list");
			return;
		} else {
			if (args[0].equals("-version") || args[0].equals("-v")) {
				System.out.println(Global.version);
				return;
			}
		}

		for (String str : args) {
			if (str.contains("bochsrc")) {
				bochsrc = str;
			}
		}

		String OS = System.getProperty("os.name").toLowerCase();
		if (OS.indexOf("windows") > -1) {
			isLinux = false;
		} else {
			isLinux = true;
		}

		if (ArrayUtils.contains(args, "-debug")) {
			Global.debug = true;
			args = (String[]) ArrayUtils.removeElement(args, "-debug");
		} else {
			Global.debug = false;
		}

		if (ArrayUtils.contains(args, "-loadBreakpoint") || ArrayUtils.contains(args, "-loadbreakpoint")) {
			Setting.getInstance().setLoadBreakpointAtStartup(true);
			args = (String[]) ArrayUtils.removeElement(args, "-loadBreakpoint");
		}

		for (int x = 0; x < args.length; x++) {
			if (args[x].toLowerCase().startsWith("-osdebug")) {
				Global.osDebug = CommonLib.convertFilesize(args[x].replaceAll("-.*=", ""));
				args = (String[]) ArrayUtils.removeElement(args, args[x]);
				x = -1;
			} else if (args[x].toLowerCase().startsWith("-profilingmemoryport")) {
				Global.profilingMemoryPort = (int) CommonLib.convertFilesize(args[x].replaceAll("-.*=", ""));
				args = (String[]) ArrayUtils.removeElement(args, args[x]);
				x = -1;
			} else if (args[x].toLowerCase().startsWith("-profilingjmpport")) {
				Global.profilingJmpPort = (int) CommonLib.convertFilesize(args[x].replaceAll("-.*=", ""));
				args = (String[]) ArrayUtils.removeElement(args, args[x]);
				x = -1;
			}
		}

		arguments = args;

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Application inst = new Application();
				new Thread() {
					public void run() {
						try {
							Thread.currentThread().sleep(5000);
							if (preventSetVisibleHang) {
								System.out.println("setVisible(true) cause system hang, this probably a swing bug, so force exit, please restart");
								System.exit(-1);
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}.start();

				if (Global.debug) {
					System.out.println("setVisible(true)");
				}
				inst.setVisible(true);
				preventSetVisibleHang = false;
				if (Global.debug) {
					System.out.println("end setVisible(true)");
				}
			}
		});
	}

	public Application() {
		super();
		if (Global.debug) {
			System.out.println(new Date());
		}

		try {
			try {
				UIManager.setLookAndFeel("com.petersoft.white.PetersoftWhiteLookAndFeel");
			} catch (Exception e) {
				e.printStackTrace();
			}

			language = Utf8ResourceBundle.getBundle("language_" + Setting.getInstance().getCurrentLanguage());

			if (!isLinux) {
				if (!new File("PauseBochs.exe").exists() || !new File("StopBochs.exe").exists()) {
					JOptionPane.showMessageDialog(null, MyLanguage.getString("PauseBochsExe"), MyLanguage.getString("Error"), JOptionPane.ERROR_MESSAGE);
					System.exit(-1);
				}
				if (!new File("ndisasm.exe").exists()) {
					JOptionPane.showMessageDialog(null, MyLanguage.getString("NdisasmExe"), MyLanguage.getString("Error"), JOptionPane.ERROR_MESSAGE);
					System.exit(-1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (Global.debug) {
			System.out.println("initGUI()");
		}
		initGUI();
		if (Global.debug) {
			System.out.println("end initGUI()");
		}

		if (Global.debug) {
			System.out.println("startBochs()");
		}
		startBochs();
		if (Global.debug) {
			System.out.println("end startBochs()");
		}
		new Thread() {
			public void run() {
				HashMap<String, String> map = CommonLib.checkLatestVersion();
				if (Global.debug) {
					System.out.println("finished checkLatestVersion()");
				}
				if (map != null) {
					if (map.get("latestVersion").compareTo(Global.version) > 0) {
						jLatestVersionLabel.setText(MyLanguage.getString("Latest_version_available") + " : " + map.get("latestVersion") + "     "
								+ MyLanguage.getString("Download_url") + " : " + map.get("downloadURL"));
					} else {
						jLatestVersionLabel.setText("");
					}
				} else {
					jLatestVersionLabel.setText("");
				}
			}
		}.start();

		new Thread() {
			public void run() {
				try {
					InputStream in = new URL("http://peter-bochs.googlecode.com/files/start.txt").openStream();
					IOUtils.toString(in);
					IOUtils.closeQuietly(in);
				} catch (Exception ex) {
					if (Global.debug) {
						ex.printStackTrace();
					}
				}
			}
		}.start();

		if (Global.debug) {
			System.out.println(new Date());
		}
	}

	private void startBochs() {
		try {
			this.enableAllButtons(true);
			jRunBochsButton.setText(MyLanguage.getString("Run_bochs"));
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

			Date date1 = new Date();
			while (commandReceiver.getLinesLength() < 9) {
				Thread.currentThread().sleep(100);
				if (new Date().getTime() - date1.getTime() > 4000) {
					break;
				}
			}
			String versionLines[] = commandReceiver.getCommandResultUntilEnd().split("\n");
			for (String line : versionLines) {
				if (line.contains("Bochs x86 Emulator")) {
					version = line.trim();
					System.out.println("v=" + version);
					jBochsVersionLabel.setText(version + "     ");
				}
				if (line.contains("Peter-bochs instrument")) {
					if (Setting.getInstance().isMemoryProfiling()) {
						MemorySocketServerController.start(Global.profilingMemoryPort, null);
					}
					if (Setting.getInstance().isJmpProfiling()) {
						JmpSocketServerController.start(Global.profilingJmpPort, jInstrumentPanel.getJmpTableModel());
					}
				}
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, MyLanguage.getString("Unable_to_start_bochs") + "\n" + MyLanguage.getString("Tips_you_specified_a_wrong_path_of_bochs"));
			ex.printStackTrace();
		}
	}

	private void stopBochs() {
		try {
			this.enableAllButtons(false);
			jRunBochsButton.setText(MyLanguage.getString("Run_bochs"));
			jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/resultset_next.png")));

			if (currentPanel.equals("jMaximizableTabbedPane_BasePanel1")) {
				CardLayout cl = (CardLayout) (jMainPanel.getLayout());
				cl.show(jMainPanel, "jMaximizableTabbedPane_BasePanel1");
				currentPanel = "jMaximizableTabbedPane_BasePanel1";
			}

			if (isLinux) {
				ProcessBuilder pb = new ProcessBuilder("killall", "-9", "bochs");
				pb.start();
			} else {
				ProcessBuilder pb = new ProcessBuilder("StopBochs.exe");
				pb.start();
			}

			MemorySocketServerController.stop();
			JmpSocketServerController.stop();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private synchronized void pauseBochs() {
		try {
			if (jRunBochsButton.getText().equals(MyLanguage.getString("Pause_bochs"))) {
				commandReceiver.clearBuffer();
				commandReceiver.waitUntilNoInput();
				if (isLinux) {
					ProcessBuilder pb = new ProcessBuilder("killall", "-2", "bochs");
					pb.start();
				} else {
					ProcessBuilder pb = new ProcessBuilder("PauseBochs.exe");
					pb.start();
				}

				updateBochsStatus();

				CardLayout cl = (CardLayout) (jMainPanel.getLayout());
				cl.show(jMainPanel, currentPanel);

				jRunBochsButton.setText(MyLanguage.getString("Run_bochs"));
				jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/resultset_next.png")));
				// jStepBochsButton.setEnabled(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void runBochs() {
		try {
			Data.memoryProfilingZone.needToTellBochsToUpdateZone = true;
			commandReceiver.clearBuffer();
			sendCommand("c");
			if (currentPanel.equals("jMaximizableTabbedPane_BasePanel1")) {
				CardLayout cl = (CardLayout) (jMainPanel.getLayout());
				cl.show(jMainPanel, "Running Label");
			}
			jRunBochsButton.setText(MyLanguage.getString("Pause_bochs"));
			jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/pause.png")));

			new Thread() {
				public void run() {
					while (commandReceiver.getLinesLength() == 0) {
						try {
							Thread.currentThread().sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					pauseBochs();
				}
			}.start();

			new Thread() {
				public void run() {
					try {
						InputStream in = new URL("http://peter-bochs.googlecode.com/files/run.txt").openStream();
						String str = IOUtils.toString(in);
						IOUtils.closeQuietly(in);
					} catch (Exception ex) {
					}
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
				this.setTitle(MyLanguage.getString("Title") + " " + Global.version);

				this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("icons/peter.png")).getImage());
				this.addWindowListener(new WindowAdapter() {
					public void windowOpened(WindowEvent evt) {
						thisWindowOpened(evt);
					}

					public void windowActivated(WindowEvent evt) {
						thisWindowActivated(evt);
					}

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
					jStartBochButton.setText(MyLanguage.getString("Start_bochs"));
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
					jStopBochsButton.setText(MyLanguage.getString("Stop_bochs"));
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
					jRunBochsButton.setText(MyLanguage.getString("Run_bochs"));
					jRunBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/resultset_next.png")));
					jRunBochsButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jRunBochsButtonActionPerformed(evt);
						}
					});
				}
				{
					jStepBochsButton = new JButton();
					jToolBar1.add(jStepBochsButton);
					jToolBar1.add(getJFastStepBochsButton());
					jStepBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/step.png")));
					jStepBochsButton.setText(MyLanguage.getString("Step"));
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
					jToolBar1.add(getJSettingButton());
					jToolBar1.add(getJRegisterToggleButton());
					jToolBar1.add(getJProfilerToggleButton());
					jToolBar1.add(getJLogToggleButton());
					jUpdateBochsButton.setEnabled(true);
					jUpdateBochsButton.setText(MyLanguage.getString("Update"));
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
				getContentPane().add(getJMainPanel());
				{
					jStatusProgressBar = new JProgressBar();
					jStatusPanel.add(jStatusProgressBar, BorderLayout.WEST);
				}
				{
					jStatusLabel = new JLabel();
					jStatusPanel.add(jStatusLabel, BorderLayout.EAST);
					jStatusPanel.add(getJPanel25(), BorderLayout.CENTER);
				}
			}
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText(MyLanguage.getString("File"));
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText(MyLanguage.getString("Exit"));
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
					jMenu4.setText(MyLanguage.getString("Bochs"));
					{
						startBochsMenuItem = new JMenuItem();
						jMenu4.add(startBochsMenuItem);
						startBochsMenuItem.setText(MyLanguage.getString("Start_bochs"));
						startBochsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								startBochsMenuItemActionPerformed(evt);
							}
						});
					}
					{
						stopBochsMenuItem = new JMenuItem();
						jMenu4.add(stopBochsMenuItem);
						stopBochsMenuItem.setText(MyLanguage.getString("Stop_bochs"));
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
						runBochsMenuItem.setText(MyLanguage.getString("Run_bochs"));
						runBochsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								runBochsMenuItemActionPerformed(evt);
							}
						});
					}
					{
						pauseBochsMenuItem = new JMenuItem();
						jMenu4.add(pauseBochsMenuItem);
						pauseBochsMenuItem.setText(MyLanguage.getString("Pause_bochs"));
						pauseBochsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								pauseBochsMenuItemActionPerformed(evt);
							}
						});
					}
					{
						jUpdateBochsStatusMenuItem = new JMenuItem();
						jMenu4.add(jUpdateBochsStatusMenuItem);
						jUpdateBochsStatusMenuItem.setText(MyLanguage.getString("Update_bochs_status"));
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
					jMenu5.setText(MyLanguage.getString("Help"));
					{
						aboutUsMenuItem = new JMenuItem();
						jMenu5.add(aboutUsMenuItem);
						aboutUsMenuItem.setText(MyLanguage.getString("About_us"));
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

			setSize(Setting.getInstance().getWidth(), Setting.getInstance().getHeight());

			int x = Setting.getInstance().getX();
			int y = Setting.getInstance().getY();
			setLocation(x, y);

			jSplitPane1.setDividerLocation(Setting.getInstance().getDivX());
			jSplitPane2.setDividerLocation(Setting.getInstance().getDivY());

			jOSDebugInformationPanel1.getjMainSplitPane().setDividerLocation(Setting.getInstance().getOsDebugSplitPane_DividerLocation());
			// pack();

			initChineseFont();
			initGlobalFontSetting(new Font(Setting.getInstance().getFontFamily(), Font.PLAIN, Setting.getInstance().getFontsize()));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(ERROR);
		}
	}

	private void initChineseFont() {
		new Thread() {
			public void run() {
				Font[] allfonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
				int fontcount = 0;
				String chinesesample = "\u4e00";
				for (int j = 0; j < allfonts.length; j++) {
					if (allfonts[j].canDisplayUpTo(chinesesample) == -1) {
						// System.out.println(allfonts[j].getFontName());
						JMenuItem jMenuItem = new JMenuItem(allfonts[j].getFontName());
						jMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								Setting.getInstance().setFontFamily(((JMenuItem) evt.getSource()).getText());
							}
						});
						jMenu2.add(jMenuItem);
					}
					fontcount++;
				}
			}
		}.start();
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
					Setting.getInstance().getBochsCommandHistory().add(jBochsCommandTextField.getText());
					Setting.getInstance().save();
				} catch (Exception ex2) {
				}

				commandReceiver.shouldShow = true;

				sendCommand(this.jBochsCommandTextField.getText());
				if (Setting.getInstance().isUpdateAfterBochsCommand()) {
					updateBochsStatusForBochsCommand(true);
				}
				commandHistoryIndex = 0;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void jBochsCommandTextFieldKeyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == '\n') {
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

	private void jRunBochsButtonActionPerformed(ActionEvent evt) {
		commandReceiver.shouldShow = false;
		if (jRunBochsButton.getText().equals(MyLanguage.getString("Run_bochs"))) {
			runBochsMenuItemActionPerformed(null);
		} else {
			pauseBochsMenuItemActionPerformed(null);
		}
	}

	public static void sendCommand(String command) {
		try {
			command = command.toLowerCase().trim();
			// do {
			commandReceiver.clearBuffer();
			commandOutputStream.write(command + "\n");
			commandOutputStream.flush();
			if (!command.equals("6") && !command.equals("c") && !command.startsWith("pb") && !command.startsWith("lb") && !command.startsWith("bpd") && !command.startsWith("bpe")
					&& !command.startsWith("del") && !command.startsWith("set")) {
				commandReceiver.waitUntilHaveInput();
				return;
			}
			// }while();
		} catch (IOException e) {
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
		updateMemory(true);

		addMemoryAddressComboBox(jMemoryAddressComboBox.getSelectedItem().toString());

		Setting.getInstance().getMemoryCombo().add(jMemoryAddressComboBox.getSelectedItem().toString());
		Setting.getInstance().save();
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
		updateBochsStatus(false);
	}

	public void updateBochsStatus(boolean shouldWait) {
		Thread updateThread = new Thread() {
			public void run() {
				enableAllButtons(false);

				if (Global.debug) {
					System.out.println("updateRegister");
				}
				updateRegister();

				if (Global.debug) {
					System.out.println("updateEFlag");
				}
				updateEFlag();

				if (Global.debug) {
					System.out.println("updateMemory");
				}
				updateMemory(true);

				if (Global.debug) {
					System.out.println("updateInstruction");
				}
				updateInstruction(null);

				if (Global.debug) {
					System.out.println("updateGDT");
				}
				updateGDT();

				if (Global.debug) {
					System.out.println("updateIDT");
				}
				updateIDT();

				if (Global.debug) {
					System.out.println("updatePageTable");
				}
				updatePageTable(CommonLib.convertFilesize(jRegisterPanel1.jCR3TextField.getText()));

				if (Global.debug) {
					System.out.println("updateStack");
				}
				updateStack();

				if (Global.debug) {
					System.out.println("updateAddressTranslate");
				}
				updateAddressTranslate();

				// ((DefaultComboBoxModel)
				// jPauseHistoryList.getModel()).addElement(jRegisterPanel1.jCSTextField.getText()
				// + ":" + jRegisterPanel1.jEIPTextField.getText());

				if (Global.debug) {
					System.out.println("updateHistoryTable");
				}
				updateHistoryTable();

				if (Global.debug) {
					System.out.println("updateBreakpointTableColor");
				}
				updateBreakpoint();
				updateBreakpointTableColor();

				if (Global.debug) {
					System.out.println("update OS debug informations");
				}
				updateOSDebugInfo();
				
				if (Global.debug){
					System.out.println("update call graph");
				}
				jInstrumentPanel.generateGraph();

				jStatusLabel.setText("");

				enableAllButtons(true);

				if (breakpointLoadedOnce == false && Setting.getInstance().loadBreakpointAtStartup) {
					jLoadBreakpointButtonActionPerformed(null);
					breakpointLoadedOnce = true; // since we only have to load
					// once
				}

				jInstrumentPanel.updateChart();
			}
		};

		updateThread.start();
		if (shouldWait) {
			try {
				updateThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected void updateOSDebugInfo() {
		long size = 0;
		try {
			String magicByte = getMemoryStr(Global.osDebug, 8, true);
			CardLayout cl = (CardLayout) (jOSDebugStandardPanel.getLayout());
			if (magicByte.equals("PETER---")) {
				size = CommonLib.getInt(getMemory(Global.osDebug + 8, 4, true), 0);
				String xml = getMemoryStr(Global.osDebug + 12, (int) size, true).trim();
				// xml = CommonLib.readFile("test.xml");
				OSDebugInfoHelper.jOSDebugInformationPanel = jOSDebugInformationPanel1;

				OSDebugInfoHelper.addData(magicByte, size, xml);
				this.jOSDebugInformationPanel1.jXMLEditorPane.setText(xml);
				cl.show(jOSDebugStandardPanel, "jOSDebugInformationPanel1");
			} else {
				cl.show(jOSDebugStandardPanel, "OS debug error label");
			}
		} catch (OutOfMemoryError ex) {
			System.gc();
			System.out.println("Size probably too large? size=" + size);
			ex.printStackTrace();
		}
	}

	public void updateBochsStatusForBochsCommand(boolean shouldWait) {
		Thread updateThread = new Thread() {
			public void run() {
				enableAllButtons(false);

				if (Setting.getInstance().isUpdateAfterBochsCommand_register()) {
					if (Global.debug) {
						System.out.println("updateRegister");
					}
					updateRegister();
					if (Global.debug) {
						System.out.println("updateEFlag");
					}
					updateEFlag();
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_memory()) {
					if (Global.debug) {
						System.out.println("updateMemory");
					}
					updateMemory(true);
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_instruction()) {
					if (Global.debug) {
						System.out.println("updateInstruction");
					}
					updateInstruction(null);
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_gdt()) {
					if (Global.debug) {
						System.out.println("updateGDT");
					}
					updateGDT();
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_idt()) {
					if (Global.debug) {
						System.out.println("updateIDT");
					}
					updateIDT();
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_ldt()) {
					if (Global.debug) {
						System.out.println("updateLDT");
					}
					updateLDT();
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_pageTable()) {
					if (Global.debug) {
						System.out.println("updatePageTable");
					}
					updatePageTable(CommonLib.convertFilesize(jRegisterPanel1.jCR3TextField.getText()));
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_stack()) {
					if (Global.debug) {
						System.out.println("updateStack");
					}
					updateStack();
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_addressTranslate()) {
					if (Global.debug) {
						System.out.println("updateAddressTranslate");
					}
					updateAddressTranslate();
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_history()) {
					if (Global.debug) {
						System.out.println("updateHistoryTable");
					}
					updateHistoryTable();
				}

				if (Setting.getInstance().isUpdateAfterBochsCommand_breakpoint()) {
					if (Global.debug) {
						System.out.println("updateBreakpointTableColor");
					}
					updateBreakpointTableColor();
				}

				jStatusLabel.setText("");

				enableAllButtons(true);

				if (breakpointLoadedOnce == false && Setting.getInstance().loadBreakpointAtStartup) {
					jLoadBreakpointButtonActionPerformed(null);
					breakpointLoadedOnce = true; // since we only have to load
					// once
				}
			}
		};
		updateThread.start();
		if (shouldWait) {
			try {
				updateThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateBreakpointTableColor() {
		long eip = CommonLib.convertFilesize(jRegisterPanel1.jEIPTextField.getText());
		String eipStr = Long.toHexString(eip);

		for (int x = 0; x < jInstructionTable.getRowCount(); x++) {
			String value = jInstructionTable.getValueAt(x, 0).toString();
			if (CommonLib.convertFilesize("0x" + eipStr) == CommonLib.convertFilesize("0x" + jInstructionTable.getValueAt(x, 1))) {
				jInstructionTable.setValueAt("-" + value, x, 1);
			} else {
				if (value.startsWith("-")) {
					jInstructionTable.setValueAt(value.substring(1), x, 1);
				}
			}
		}

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
			commandReceiver.shouldShow = false;
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
			commandReceiver.shouldShow = false;
			sendCommand("info tab");
			Thread.currentThread().sleep(100);
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
		jFastStepBochsButton.setEnabled(b);
		jUpdateBochsButton.setEnabled(b);
		jPageDirectoryTable.setEnabled(b);
		jPageTableTable.setEnabled(b);

		pauseBochsMenuItem.setEnabled(b);
		runBochsMenuItem.setEnabled(b);
		jUpdateBochsStatusMenuItem.setEnabled(b);
	}

	public void updatePageTable(long pageDirectoryBaseAddress) {
		Vector<IA32PageDirectory> ia32_pageDirectories = new Vector<IA32PageDirectory>();
		try {
			commandReceiver.clearBuffer();
			commandReceiver.shouldShow = false;
			jStatusLabel.setText("Updating page table");
			// commandReceiver.setCommandNoOfLine(512);
			sendCommand("xp /4096bx " + pageDirectoryBaseAddress);
			float totalByte2 = 4096 - 1;
			totalByte2 = totalByte2 / 8;
			int totalByte3 = (int) Math.floor(totalByte2);
			String realEndAddressStr;
			String realStartAddressStr;
			long realStartAddress = pageDirectoryBaseAddress;
			realStartAddressStr = String.format("%08x", realStartAddress);
			long realEndAddress = realStartAddress + totalByte3 * 8;
			realEndAddressStr = String.format("%08x", realEndAddress);
			String result = commandReceiver.getCommandResult(realStartAddressStr, realEndAddressStr);
			if (result != null) {
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
							int bytes[] = new int[4];
							for (int x = 0; x < 4; x++) {
								bytes[x] = CommonLib.hex2decimal(b[x + z * 4].substring(2).trim()).intValue();
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
					jStatusLabel.setText("Updating page table " + (y + 1) + "/" + lines.length);
				}
				jPageDirectoryTable.setModel(model);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		/*
		 * if (false && Global.debug &&
		 * jAutoRefreshPageTableGraphCheckBox.isSelected()) {
		 * System.out.println("aa"); GraphModel model = new DefaultGraphModel();
		 * GraphLayoutCache view = new GraphLayoutCache(model, new
		 * DefaultCellViewFactory() { public CellView createView(GraphModel
		 * model, Object cell) { CellView view = null; if (model.isPort(cell)) {
		 * view = new PortView(cell); } else if (model.isEdge(cell)) { view =
		 * new EdgeView(cell); } else { if (cell instanceof IA32PageDirectory) {
		 * view = new PageDirectoryView(cell); } else if (cell instanceof
		 * IA32PageTable) { view = new JButtonView(cell, 1); } else { view = new
		 * VertexView(cell); } } return view; } }); JGraph graph = new
		 * JGraph(model, view);
		 * 
		 * // add cells
		 * 
		 * // DefaultGraphCell[] cells = new //
		 * DefaultGraphCell[ia32_pageDirectories.size() + 1];
		 * Vector<DefaultGraphCell> cells = new Vector<DefaultGraphCell>();
		 * DefaultGraphCell root = new DefaultGraphCell("cr3 " +
		 * jRegisterPanel1.jCR3TextField.getText());
		 * GraphConstants.setGradientColor(root.getAttributes(), Color.red);
		 * GraphConstants.setOpaque(root.getAttributes(), true);
		 * GraphConstants.setBounds(root.getAttributes(), new
		 * Rectangle2D.Double(0, 0, 140, 20)); root.add(new DefaultPort());
		 * cells.add(root);
		 * 
		 * Vector<IA32PageDirectory> pageDirectoryCells = new
		 * Vector<IA32PageDirectory>(); for (int x = 0; x <
		 * ia32_pageDirectories.size(); x++) { IA32PageDirectory cell =
		 * ia32_pageDirectories.get(x);
		 * GraphConstants.setGradientColor(cell.getAttributes(), Color.orange);
		 * GraphConstants.setOpaque(cell.getAttributes(), true);
		 * GraphConstants.setBounds(cell.getAttributes(), new
		 * Rectangle2D.Double(0, x * 20, 140, 20)); cell.add(new DefaultPort());
		 * pageDirectoryCells.add(cell);
		 * 
		 * // page table String pageTableAddress =
		 * ia32_pageDirectories.get(x).base; sendCommand("xp /4096bx " +
		 * pageTableAddress);
		 * 
		 * float totalByte2 = 4096 - 1; totalByte2 = totalByte2 / 8; int
		 * totalByte3 = (int) Math.floor(totalByte2); String realEndAddressStr;
		 * String realStartAddressStr; String baseAddress = pageTableAddress;
		 * long realStartAddress = CommonLib.hex2decimal(baseAddress);
		 * 
		 * realStartAddressStr = String.format("%08x", realStartAddress); long
		 * realEndAddress = realStartAddress + totalByte3 * 8; realEndAddressStr
		 * = String.format("%08x", realEndAddress);
		 * 
		 * String result = commandReceiver.getCommandResult(realStartAddressStr,
		 * realEndAddressStr); String[] lines = result.split("\n");
		 * 
		 * Vector<DefaultGraphCell> pageTables = new Vector<DefaultGraphCell>();
		 * for (int y = 1; y < 4; y++) { String[] b =
		 * lines[y].replaceFirst("			cell.add(new DefaultPort());^.*:",
		 * "").trim().split("\t");
		 * 
		 * for (int z = 0; z < 2; z++) { try { int bytes[] = new int[4]; for
		 * (int x2 = 0; x2 < 4; x2++) { bytes[x2] = CommonLib.hex2decimal(b[x2 +
		 * z * 4].substring(2).trim()).intValue(); } long value =
		 * CommonLib.getInt(bytes, 0);
		 * 
		 * String base = Long.toHexString(value & 0xfffff000); String avl =
		 * String.valueOf((value >> 9) & 3); String g = String.valueOf((value >>
		 * 8) & 1); String d = String.valueOf((value >> 6) & 1); String a =
		 * String.valueOf((value >> 5) & 1); String pcd = String.valueOf((value
		 * >> 4) & 1); String pwt = String.valueOf((value >> 3) & 1); String us
		 * = String.valueOf((value >> 2) & 1); String wr = String.valueOf((value
		 * >> 1) & 1); String p = String.valueOf((value >> 0) & 1);
		 * IA32PageTable pageTableCell = new IA32PageTable(base, avl, g, d, a,
		 * pcd, pwt, us, wr, p);
		 * GraphConstants.setGradientColor(pageTableCell.getAttributes(),
		 * Color.orange);
		 * GraphConstants.setOpaque(pageTableCell.getAttributes(), true);
		 * GraphConstants.setBounds(pageTableCell.getAttributes(), new
		 * Rectangle2D.Double(0, (z + y) * 20, 140, 20)); pageTableCell.add(new
		 * DefaultPort()); pageTables.add(pageTableCell); } catch (Exception ex)
		 * { } } }
		 * 
		 * // group it and link it DefaultGraphCell pt[] =
		 * pageTables.toArray(new DefaultGraphCell[] {}); DefaultGraphCell
		 * vertex1 = new DefaultGraphCell(new String("page table" + x), null,
		 * pt); vertex1.add(new DefaultPort()); cells.add(vertex1);
		 * 
		 * DefaultEdge edge = new DefaultEdge();
		 * edge.setSource(cell.getChildAt(0));
		 * edge.setTarget(vertex1.getLastChild());
		 * 
		 * GraphConstants.setLineStyle(edge.getAttributes(),
		 * GraphConstants.STYLE_ORTHOGONAL);
		 * GraphConstants.setRouting(edge.getAttributes(),
		 * GraphConstants.ROUTING_DEFAULT); int arrow =
		 * GraphConstants.ARROW_CLASSIC;
		 * GraphConstants.setLineEnd(edge.getAttributes(), arrow);
		 * GraphConstants.setEndFill(edge.getAttributes(), true);
		 * 
		 * cells.add(edge); }
		 * 
		 * if (pageDirectoryCells.toArray().length > 0) { IA32PageDirectory pt[]
		 * = pageDirectoryCells.toArray(new IA32PageDirectory[] {});
		 * DefaultGraphCell vertex1 = new DefaultGraphCell(new
		 * String("Vertex1"), null, pt); vertex1.add(new DefaultPort());
		 * cells.add(vertex1);
		 * 
		 * DefaultEdge edge = new DefaultEdge();
		 * edge.setSource(root.getChildAt(0));
		 * edge.setTarget(vertex1.getLastChild()); int arrow =
		 * GraphConstants.ARROW_CLASSIC;
		 * GraphConstants.setLineEnd(edge.getAttributes(), arrow);
		 * GraphConstants.setEndFill(edge.getAttributes(), true);
		 * 
		 * // lastObj = cells[index]; cells.add(edge); }
		 * 
		 * graph.getGraphLayoutCache().insert(cells.toArray());
		 * graph.setDisconnectable(false);
		 * 
		 * JGraphFacade facade = new JGraphFacade(graph); JGraphLayout layout =
		 * new JGraphTreeLayout(); ((JGraphTreeLayout)
		 * layout).setOrientation(SwingConstants.WEST); //
		 * ((JGraphHierarchicalLayout) layout).setNodeDistance(100);
		 * layout.run(facade); Map nested = facade.createNestedMap(true, true);
		 * graph.getGraphLayoutCache().edit(nested);
		 * 
		 * // JGraphFacade facade = new JGraphFacade(graph); // JGraphLayout
		 * layout = new JGraphFastOrganicLayout(); // layout.run(facade); // Map
		 * nested = facade.createNestedMap(true, true); //
		 * graph.getGraphLayoutCache().edit(nested);
		 * 
		 * jPageTableGraphPanel.removeAll(); jPageTableGraphPanel.add(new
		 * JScrollPane(graph), BorderLayout.CENTER); }
		 */

	}

	private void updateStack() {
		try {
			jStatusLabel.setText("Updating stack");
			// commandReceiver.setCommandNoOfLine(512);

			commandReceiver.clearBuffer();
			commandReceiver.shouldShow = false;
			sendCommand("print-stack 40");
			String result = commandReceiver.getCommandResultUntilHaveLines(40);
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
		updateInstructionUsingBochs(address);
	}

	private void updateInstructionUsingNasm(Long address) {
		try {
			if (address == null) {
				address = new Long(0);
			}
			jStatusLabel.setText("Updating instruction");
			String result = Disassemble.disassemble(address, 32);
			String lines[] = result.split("\n");
			if (lines.length > 0) {
				DefaultTableModel model = (DefaultTableModel) jInstructionTable.getModel();
				while (model.getRowCount() > 0) {
					model.removeRow(0);
				}
				jStatusProgressBar.setMaximum(lines.length - 1);
				for (int x = 0; x < lines.length; x++) {
					jStatusProgressBar.setValue(x);
					try {
						model.addRow(new String[] { lines[x].substring(0, 10).trim(), lines[x].substring(20).trim(), lines[x].substring(10, 20).trim() });
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

	private void updateInstructionUsingBochs(Long address) {
		try {
			final int maximumLine = 40;
			String command;
			jStatusLabel.setText("Updating instruction");
			if (address == null) {
				Long cs = CommonLib.hex2decimal(this.jRegisterPanel1.jCSTextField.getText());
				Long eip = CommonLib.hex2decimal(this.jRegisterPanel1.jEIPTextField.getText()) + 75;
				command = "disasm cs:eip 0x" + Long.toHexString(cs) + ":0x" + Long.toHexString(eip + 200);
			} else {
				command = "disasm " + address + " " + (address + 200);
			}
			commandReceiver.clearBuffer();
			commandReceiver.shouldShow = false;
			sendCommand(command);
			Thread.currentThread().sleep(200);
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
				JInstructionTableModel model = (JInstructionTableModel) jInstructionTable.getModel();
				model.clearData();
				jStatusProgressBar.setMaximum(lines.length - 1);
				for (int x = 0; x < lines.length && x < maximumLine; x++) {
					jStatusProgressBar.setValue(x);
					try {
						lines[x] = lines[x].replaceFirst("\\<.*\\>", "");
						// System.out.println(lines[x]);
						String strs[] = lines[x].split(":");
						int secondColon = lines[x].indexOf(":", lines[x].indexOf(":") + 1);
						model.addRow(new String[] { "", strs[0].trim() + " " + strs[1].trim().replaceAll("\\( *\\)", ""),
								lines[x].substring(secondColon + 1).trim().split(";")[0].trim(), lines[x].split(";")[1] });
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
			commandReceiver.shouldShow = false;
			sendCommand("info gdt 0 " + limit);
			String limitStr = String.format("0x%02x", limit);

			String result = commandReceiver.getCommandResult("GDT[0x00]", "GDT[" + limitStr + "]");
			if (result != null) {
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
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void updateIDT() {
		try {
			jStatusLabel.setText("Updating IDT");

			commandReceiver.clearBuffer();
			commandReceiver.shouldShow = false;
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
			for (int x = 0; x < lines.length; x++) {
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
		Long l = CommonLib.convertFilesize(value);
		String newValue = "0x" + Long.toHexString(l);
		if (jTextField.getText().equals(newValue)) {
			jTextField.setForeground(Color.black);
		} else {
			jTextField.setForeground(Color.red);
		}
		jTextField.setText(newValue);
	}

	private void updateRegister() {
		try {
			jStatusLabel.setText("Updating general registers");
			commandReceiver.shouldShow = false;
			sendCommand("r");
			String result = commandReceiver.getCommandResult("ax:", "eflags");
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
					} else if (line.matches(".*ldtr.*")) {
						changeText(this.jRegisterPanel1.jLDTRTextField, line.split("=")[1].split(",")[0]);
					} else if (line.matches(".*idtr:.*")) {
						changeText(this.jRegisterPanel1.jIDTRTextField, line.split("=")[1].split(",")[0]);
						changeText(this.jRegisterPanel1.jIDTRLimitTextField, str[1].split("=")[1]);
					} else if (line.matches(".*tr:.*")) {
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
					} else if (line.matches(".*ldtr.*")) {
						changeText(this.jRegisterPanel1.jLDTRTextField, line.split("=")[1].split(",")[0]);
					} else if (line.matches(".*idtr:.*")) {
						changeText(this.jRegisterPanel1.jIDTRTextField, line.split("=")[1].split(",")[0]);
						changeText(this.jRegisterPanel1.jIDTRLimitTextField, str[1].split("=")[1]);
					} else if (line.matches(".*tr:.*")) {
						changeText(this.jRegisterPanel1.jTRTextField, line.split(":")[1].split(",")[0]);
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

					if (CommonLib.getBit(CommonLib.convertFilesize(jRegisterPanel1.jCR0TextField.getText()), 0) == 1) {
						jCPUModeLabel.setText(MyLanguage.getString("Protected_mode") + "     ");
					} else {
						jCPUModeLabel.setText(MyLanguage.getString("Real_mode") + "     ");
					}
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
			if (version.contains("2.4.1")) {
			} else {
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
					if (line.matches(".*DR0=0x.*")) {
						changeText(this.jRegisterPanel1.jDR0TextField, line.split("=")[1].split(":")[0]);
					} else if (line.matches(".*DR1=0x.*")) {
						changeText(this.jRegisterPanel1.jDR1TextField, line.split("=")[1].split(":")[0]);
					} else if (line.matches(".*DR2=0x.*")) {
						changeText(this.jRegisterPanel1.jDR2TextField, line.split("=")[1].split(":")[0]);
					} else if (line.matches(".*DR3=0x.*")) {
						changeText(this.jRegisterPanel1.jDR3TextField, line.split("=")[1].split(":")[0]);
					} else if (line.matches(".*DR6=0x.*")) {
						changeText(this.jRegisterPanel1.jDR6TextField, line.split("=")[1].split(":")[0]);
					} else if (line.matches(".*DR7=0x.*")) {
						changeText(this.jRegisterPanel1.jDR7TextField, line.split("=")[1].split(":")[0]);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void updateMemory(boolean isPhysicalAddress) {
		try {
			if (this.jMemoryAddressComboBox.getSelectedItem() != null) {
				commandReceiver.shouldShow = false;
				currentMemoryWindowsAddress = CommonLib.convertFilesize(this.jMemoryAddressComboBox.getSelectedItem().toString());
				jStatusLabel.setText("Updating memory");
				int totalByte = 200;
				int bytes[] = this.getMemory(CommonLib.convertFilesize(this.jMemoryAddressComboBox.getSelectedItem().toString()), totalByte, isPhysicalAddress);
				jStatusLabel.setText("");
				jHexTable1.getModel().setCurrentAddress(CommonLib.convertFilesize(this.jMemoryAddressComboBox.getSelectedItem().toString()));
				jHexTable1.updateUI();
				jHexTable1.getModel().set(bytes);

				// commandReceiver.clearBuffer();
				// commandReceiver.shouldShow = false;
				// sendCommand("xp /" + totalByte + "bx " +
				// this.jMemoryAddressComboBox.getSelectedItem().toString());

				//
				// if (totalByte > 0) {
				// float totalByte2 = totalByte - 1;
				// totalByte2 = totalByte2 / 8;
				// int totalByte3 = (int) Math.floor(totalByte2);
				// String realEndAddressStr;
				// String realStartAddressStr;
				// String base =
				// this.jMemoryAddressComboBox.getSelectedItem().toString();
				// long realStartAddress = CommonLib.convertFilesize(base);
				// realStartAddressStr = String.format("%08x",
				// realStartAddress);
				// long realEndAddress = realStartAddress + totalByte3 * 8;
				// realEndAddressStr = String.format("%08x", realEndAddress);
				// // System.out.println(realStartAddressStr);
				// // System.out.println(realEndAddressStr);
				// String result =
				// commandReceiver.getCommandResult(realStartAddressStr,
				// realEndAddressStr);
				// // System.out.println(result);
				// if (result != null) {
				// String[] lines = result.split("\n");
				// String bytes[] = new String[totalByte];
				// int offset = 0;
				// // System.out.println(result);
				// jStatusProgressBar.setMaximum(lines.length - 1);
				// for (int y = 0; y < lines.length; y++) {
				// jStatusProgressBar.setValue(y);
				// String[] b = lines[y].replaceFirst("^.*:", "").split("\t");
				// // System.out.println(lines[y]);
				//
				// for (int x = 1; x < b.length && offset < totalByte; x++) {
				// // System.out.println(offset + "==" + x);
				// bytes[offset] = b[x].substring(2).trim();
				// offset++;
				// }
				// // System.out.println();
				// jStatusLabel.setText("Updating memory " + (y + 1) + "/" +
				// (lines.length - 1));
				// }
				// jHexTable1.getModel().set(bytes);
				// }
				// jStatusLabel.setText("");
				// // System.out.println(lines.length);
				//
				// jHexTable1.getModel().setCurrentAddress(CommonLib.convertFilesize(this.jMemoryAddressComboBox.getSelectedItem().toString()));
				// jHexTable1.updateUI();
			}
			// }
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

		Setting.getInstance().setWidth(this.getWidth());
		Setting.getInstance().setHeight(this.getHeight());
		Setting.getInstance().setX(this.getLocation().x);
		Setting.getInstance().setY(this.getLocation().y);
		Setting.getInstance().setDivX(jSplitPane1.getDividerLocation());
		Setting.getInstance().setDivY(jSplitPane2.getDividerLocation());
		Setting.getInstance().setOsDebugSplitPane_DividerLocation(this.jOSDebugInformationPanel1.getjMainSplitPane().getDividerLocation());
		Setting.getInstance().save();
	}

	private void jGDTTableMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			for (int x = 0; x < jTabbedPane2.getTabCount(); x++) {
				if (jTabbedPane2.getTitleAt(x).equals(("GDT " + String.format("0x%02x", jGDTTable.getSelectedRow() + 1)))) {
					jTabbedPane2.setSelectedIndex(x);
					return;
				}
			}
			jTabbedPane2.addTabWithCloseButton("GDT " + String.format("0x%02x", jGDTTable.getSelectedRow() + 1), null,
					new GDTLDTPanel(this, 0, CommonLib.hex2decimal(this.jRegisterPanel1.jGDTRTextField.getText()), jGDTTable.getSelectedRow() + 1), null);
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
			PageTableTableModel model = (PageTableTableModel) jPageTableTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			for (int y = 0; y < lines.length; y++) {
				jStatusProgressBar.setValue(y * 100 / lines.length);
				String[] b = lines[y].replaceFirst("^.*:", "").trim().split("\t");

				for (int z = 0; z < 2; z++) {
					try {
						int bytes[] = new int[4];
						for (int x = 0; x < 4; x++) {
							bytes[x] = CommonLib.hex2decimal(b[x + z * 4].substring(2).trim()).intValue();
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
						boolean tempB = model.isShowZeroAddress();
						model.setShowZeroAddress(true);
						model.addRow(new String[] { String.valueOf(y * 2 + z), base, avl, g, pat, d, a, pcd, pwt, us, wr, p });
						model.setShowZeroAddress(tempB);
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
			this.jMemoryAddressComboBox.setSelectedItem(pageAddress);
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
			Thread.currentThread().sleep(100);
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

			this.jRefreshELFBreakpointButtonActionPerformed(null);

			if (!jRegisterPanel1.jEIPTextField.getText().equals("")) {
				((JSourceCodeTableModel) jELFTable.getModel()).updateBreakpoint(getRealEIP());
				((JInstructionTableModel) jInstructionTable.getModel()).updateBreakpoint(getRealEIP());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void jDisassembleButtonActionPerformed(ActionEvent evt) {
		jDisassembleButton.setEnabled(false);
		this.updateInstruction(null);
		updateBreakpointTableColor();
		jDisassembleButton.setEnabled(true);
	}

	private void jAddBreakpointButtonActionPerformed(ActionEvent evt) {
		jAddBreakpointButton.setEnabled(false);
		String type = (String) JOptionPane.showInputDialog(this, null, "Add breakpoint", JOptionPane.QUESTION_MESSAGE, null,
				new Object[] { MyLanguage.getString("Physical_address"), MyLanguage.getString("Linear_address") }, "Breakpoint");
		if (type != null) {
			String address = JOptionPane.showInputDialog(this, "Please input breakpoint address", "Add breakpoint", JOptionPane.QUESTION_MESSAGE);
			if (address != null) {
				if (type.equals(MyLanguage.getString("Physical_address"))) {
					sendCommand("pb " + address);
				} else {
					sendCommand("lb " + address);
				}
				updateBreakpoint();
				updateBreakpointTableColor();
			}
		}
		jAddBreakpointButton.setEnabled(true);
	}

	private void jSaveBreakpointButtonActionPerformed(ActionEvent evt) {
		jSaveBreakpointButton.setEnabled(false);
		LinkedList<Breakpoint> v = Setting.getInstance().getBreakpoint();
		v.clear();

		for (int x = 0; x < this.jBreakpointTable.getRowCount(); x++) {
			Breakpoint h = new Breakpoint();
			h.setNo(x);
			h.setType(this.jBreakpointTable.getValueAt(x, 0).toString());
			h.setEnable(this.jBreakpointTable.getValueAt(x, 1).toString());
			h.setAddress(this.jBreakpointTable.getValueAt(x, 2).toString());
			h.setHit(Integer.parseInt(this.jBreakpointTable.getValueAt(x, 3).toString()));
			v.add(h);
		}
		Setting.getInstance().save();
		jSaveBreakpointButton.setEnabled(true);
	}

	private void jLoadBreakpointButtonActionPerformed(ActionEvent evt) {
		jLoadBreakpointButton.setEnabled(false);
		LinkedList<Breakpoint> vector = Setting.getInstance().getBreakpoint();
		try {
			for (int x = 0; x < vector.size(); x++) {
				boolean match = false;
				for (int y = 0; y < this.jBreakpointTable.getRowCount(); y++) {
					if (vector.get(x).getAddress().trim().equals(jBreakpointTable.getValueAt(y, 2).toString().trim())) {
						match = true;
						break;
					}
				}
				if (!match) {
					if (vector.get(x).getType().contains("pbreakpoint")) {
						sendCommand("pb " + vector.get(x).getAddress());
					} else {
						sendCommand("lb " + vector.get(x).getAddress());
					}
					if (vector.get(x).getEnable().trim().equals("keep n")) {
						sendCommand("bpd " + (x + 1));
					}
				}
			}
		} catch (Exception e) {
			if (Global.debug) {
				e.printStackTrace();
			}
		}
		updateBreakpoint();
		updateBreakpointTableColor();
		jLoadBreakpointButton.setEnabled(true);
	}

	private void jDeleteBreakpointButtonActionPerformed(ActionEvent evt) {
		jDeleteBreakpointButton.setEnabled(false);
		int rows[] = jBreakpointTable.getSelectedRows();
		for (int x = 0; x < rows.length; x++) {
			sendCommand("del " + jBreakpointTable.getValueAt(rows[x], 0).toString().replaceAll("^-*", "").trim().split(" ")[0]);
		}
		updateBreakpoint();
		updateBreakpointTableColor();
		jDeleteBreakpointButton.setEnabled(true);
	}

	private void jDisableBreakpointButtonActionPerformed(ActionEvent evt) {
		jDisableBreakpointButton.setEnabled(false);
		int rows[] = jBreakpointTable.getSelectedRows();
		for (int x = 0; x < rows.length; x++) {
			sendCommand("bpd " + jBreakpointTable.getValueAt(rows[x], 0).toString().replaceAll("^-*", "").trim().split(" ")[0]);
		}
		updateBreakpoint();
		updateBreakpointTableColor();
		jDisableBreakpointButton.setEnabled(true);
	}

	private void jEnableBreakpointButtonActionPerformed(ActionEvent evt) {
		jEnableBreakpointButton.setEnabled(false);
		int rows[] = jBreakpointTable.getSelectedRows();
		for (int x = 0; x < rows.length; x++) {
			sendCommand("bpe " + jBreakpointTable.getValueAt(rows[x], 0).toString().replaceAll("^-*", "").trim().split(" ")[0]);
		}
		updateBreakpoint();
		updateBreakpointTableColor();
		jEnableBreakpointButton.setEnabled(true);
	}

	private void jBochsCommandTextFieldKeyPressed(KeyEvent evt) {
		if (jBochsCommandTextField.getText().equals("")) {
			commandHistoryIndex = 0;
		}
		HashSet<String> vector = Setting.getInstance().getBochsCommandHistory();
		if (evt.getKeyCode() == 38) {
			if (commandHistoryIndex < vector.size()) {
				commandHistoryIndex++;
				this.jBochsCommandTextField.setText(vector.toArray()[vector.size() - commandHistoryIndex].toString());
			}
		} else if (evt.getKeyCode() == 40) {
			if (commandHistoryIndex > 1) {
				commandHistoryIndex--;
				this.jBochsCommandTextField.setText(vector.toArray()[vector.size() - commandHistoryIndex].toString());
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
			jTableTranslateScrollPane.setViewportView(getJTabbedPane5());
			jTableTranslateScrollPane.setViewportView(getJAddressTranslateTable());
		}
		return jTableTranslateScrollPane;
	}

	private JTable getJAddressTranslateTable() {
		if (jAddressTranslateTable == null) {
			TableModel jAddressTranslateTableModel = new DefaultTableModel(new String[][] {}, new String[] { MyLanguage.getString("From"), MyLanguage.getString("To") });
			jAddressTranslateTable = new JTable();
			jAddressTranslateTable.setModel(jAddressTranslateTableModel);
		}
		return jAddressTranslateTable;
	}

	private JMenu getJFontMenu() {
		if (jFontMenu == null) {
			jFontMenu = new JMenu();
			jFontMenu.setText(MyLanguage.getString("Font"));
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
		Setting.getInstance().setFontsize(14);
		initGlobalFontSetting(new Font(Setting.getInstance().getFontFamily(), Font.PLAIN, Setting.getInstance().getFontsize()));
	}

	private void jFont12MenuItemActionPerformed(ActionEvent evt) {
		Setting.getInstance().setFontsize(12);
		initGlobalFontSetting(new Font(Setting.getInstance().getFontFamily(), Font.PLAIN, Setting.getInstance().getFontsize()));
	}

	private void jFont10MenuItemActionPerformed(ActionEvent evt) {
		Setting.getInstance().setFontsize(10);
		initGlobalFontSetting(new Font(Setting.getInstance().getFontFamily(), Font.PLAIN, Setting.getInstance().getFontsize()));
	}

	private void jFont8MenuItemActionPerformed(ActionEvent evt) {
		Setting.getInstance().setFontsize(8);
		initGlobalFontSetting(new Font(Setting.getInstance().getFontFamily(), Font.PLAIN, Setting.getInstance().getFontsize()));
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
			jMenu1.setText(MyLanguage.getString("Size"));
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
			jMenu2.setText(MyLanguage.getString("Font"));
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
		Setting.getInstance().setFontFamily("Arial");
	}

	private void jDialogMenuItemActionPerformed(ActionEvent evt) {
		Setting.getInstance().setFontFamily("Dialog");
	}

	private JMenu getJMenu6() {
		if (jMenu6 == null) {
			jMenu6 = new JMenu();
			jMenu6.setText(MyLanguage.getString("Language"));
			jMenu6.add(getJMenuItem1());
			jMenu6.add(getJMenuItem2());
			jMenu6.add(getJMenuItem3());
			jMenu6.add(getJKRMenuItem());
			jMenu6.add(getJJPMenuItem());
		}
		return jMenu6;
	}

	private JMenuItem getJMenuItem1() {
		if (jEnglishMenuItem == null) {
			jEnglishMenuItem = new JMenuItem();
			jEnglishMenuItem.setText(MyLanguage.getString("English"));
			jEnglishMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem1ActionPerformed(evt);
				}
			});
		}
		return jEnglishMenuItem;
	}

	private JMenuItem getJMenuItem2() {
		if (jHKMenuItem == null) {
			jHKMenuItem = new JMenuItem();
			jHKMenuItem.setText(MyLanguage.getString("Traditional_chinese"));
			jHKMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem2ActionPerformed(evt);
				}
			});
		}
		return jHKMenuItem;
	}

	private JMenuItem getJMenuItem3() {
		if (jSCMenuItem == null) {
			jSCMenuItem = new JMenuItem();
			jSCMenuItem.setText(MyLanguage.getString("Simplified_chinese"));
			jSCMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem3ActionPerformed(evt);
				}
			});
		}
		return jSCMenuItem;
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

		Setting.getInstance().setCurrentLanguage(language);
		Setting.getInstance().save();
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

	private JToolBar getJPanel13() {
		if (jPanel13 == null) {
			jPanel13 = new JToolBar();
			FlowLayout jPanel13Layout = new FlowLayout();
			jPanel13Layout.setAlignment(FlowLayout.LEFT);
			{
				jLabel3 = new JLabel();
				jPanel13.add(jLabel3);
				jLabel3.setText(MyLanguage.getString("Pause_history"));
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
					// TableModel jTable1Model = new DefaultTableModel(new
					// String[][] {}, new String[] { "No.",
					// MyLanguage.getString("Physical_address"), "AVL", "G",
					// "PAT", "D", "A",
					// "PCD", "PWT", "U/S", "W/R", "P" }) {
					// public boolean isCellEditable(int row, int column) {
					// return false;
					// }
					// };
					jPageTableTable = new JTable();
					jScrollPane7.setViewportView(jPageTableTable);
					jPageTableTable.setModel(new PageTableTableModel());
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
					// TableModel jPageDirectoryTableModel = new
					// DefaultTableModel(new String[][] {}, new String[] {
					// "No.", "PT base", "AVL", "G", "D", "A", "PCD", "PWT",
					// "U/S",
					// "W/R", "P" }) {
					// public boolean isCellEditable(int row, int column) {
					// return false;
					// }
					// };
					jPageDirectoryTable = new JTable();
					jScrollPane8.setViewportView(jPageDirectoryTable);
					jPageDirectoryTable.setModel(new PageDirectoryTableModel());
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
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton1ActionPerformed(evt);
				}
			});
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
			jSearchMemoryTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					jSearchMemoryTableMouseClicked(evt);
				}
			});
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
			if (this.jSearchMemoryToComboBox.getSelectedItem().toString().trim().startsWith("+")) {
				this.jSearchMemoryToComboBox.setSelectedItem("0x"
						+ Long.toHexString(CommonLib.convertFilesize(this.jSearchMemoryFromComboBox.getSelectedItem().toString())
								+ CommonLib.convertFilesize(this.jSearchMemoryToComboBox.getSelectedItem().toString().substring(1))));
			}
			new SearchMemoryDialog(this, this.jSearchMemoryTable, this.jSearchMemoryTextField.getText(), CommonLib.convertFilesize(this.jSearchMemoryFromComboBox.getSelectedItem()
					.toString()), CommonLib.convertFilesize(this.jSearchMemoryToComboBox.getSelectedItem().toString())).setVisible(true);
		} catch (Exception ex) {

		}
	}

	private JButton getJButton14() {
		if (jButton14 == null) {
			jButton14 = new JButton();
			jButton14.setText(MyLanguage.getString("Disassemble"));
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
		updateInstruction(CommonLib.convertFilesize(this.jInstructionComboBox.getSelectedItem().toString()));
		updateBreakpointTableColor();
		jDisassembleButton.setEnabled(true);
	}

	private JButton getJButton15() {
		if (jButton15 == null) {
			jButton15 = new JButton();
			jButton15.setText(MyLanguage.getString("Clear"));
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
				jMainPanel.add(getJMaximizableTabbedPane_BasePanel1(), "jMaximizableTabbedPane_BasePanel1");
				jMainPanel.add(getJInstrumentPanel(), "jInstrumentPanel");
				jMainPanel.add(getJRunningLabel(), "Running Label");
				jMainPanel.add(getLogPanel1(), "logPanel1");
			}
		}
		return jMainPanel;
	}

	private JSplitPane getJSplitPane2() {
		jSplitPane2 = new JSplitPane();

		jSplitPane2.setPreferredSize(new java.awt.Dimension(1009, 781));
		jSplitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		{
			jSplitPane1 = new JSplitPane();
			jSplitPane2.add(jSplitPane1, JSplitPane.TOP);
			jSplitPane1.setDividerLocation(400);
			{
				jTabbedPane1 = new JMaximizableTabbedPane();
				jSplitPane1.add(jTabbedPane1, JSplitPane.RIGHT);
				{
					jPanel10 = new JPanel();
					BorderLayout jPanel10Layout = new BorderLayout();
					jPanel10.setLayout(jPanel10Layout);
					jTabbedPane1.addTab(MyLanguage.getString("Instruction"), new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/text_padding_top.png")),
							jPanel10, null);
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
							jInstructionControlPanel.add(getJInstructionUpTenButton());
							jInstructionControlPanel.add(getJInstructionUpButton());
							jInstructionControlPanel.add(getJButton22());
							jInstructionControlPanel.add(getJButton3());
							jInstructionControlPanel.add(getJButton12());
							jDisassembleButton.setText(MyLanguage.getString("Disassemble") + " cs:eip");
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
							jInstructionTable = new JTable();
							jScrollPane5.setViewportView(jInstructionTable);
							jInstructionTable.setModel(new JInstructionTableModel());
							jInstructionTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
							jInstructionTable.getColumnModel().getColumn(0).setMaxWidth(20);
							jInstructionTable.getColumnModel().getColumn(1).setPreferredWidth(40);
							jInstructionTable.getColumnModel().getColumn(2).setPreferredWidth(200);
							jInstructionTable.getColumnModel().getColumn(3).setPreferredWidth(40);
							jInstructionTable.getColumnModel().getColumn(0).setCellRenderer(new JInstructionTableCellRenderer());
							jInstructionTable.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									jInstructionTableMouseClicked(evt);
								}
							});
						}
					}
				}
				{
					jPanel4 = new JPanel();
					jTabbedPane1.addTab(MyLanguage.getString("Breakpoint"), new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/cancel.png")), jPanel4, null);
					BorderLayout jPanel4Layout = new BorderLayout();
					jPanel4.setLayout(jPanel4Layout);
					{
						jScrollPane9 = new JScrollPane();
						jPanel4.add(jScrollPane9, BorderLayout.CENTER);
						{
							TableModel jTable1Model = new DefaultTableModel(new String[][] {}, new String[] { MyLanguage.getString("No"), MyLanguage.getString("Address_type"),
									"Disp Enb Address", MyLanguage.getString("Hit") }) {
								public boolean isCellEditable(int row, int col) {
									return false;
								}
							};
							jBreakpointTable = new JTable();
							jScrollPane9.setViewportView(jBreakpointTable);
							jBreakpointTable.setModel(jTable1Model);
							jBreakpointTable.getColumnModel().getColumn(0).setCellRenderer(new JBreakpointTableCellRenderer());
							jBreakpointTable.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									jBreakpointTableMouseClicked(evt);
								}
							});
						}
					}
					{
						jPanel12 = new JPanel();
						jPanel4.add(jPanel12, BorderLayout.SOUTH);
						{
							jAddBreakpointButton = new JButton();
							jPanel12.add(jAddBreakpointButton);
							jAddBreakpointButton.setText(MyLanguage.getString("Add"));
							jAddBreakpointButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jAddBreakpointButtonActionPerformed(evt);
								}
							});
						}
						{
							jDeleteBreakpointButton = new JButton();
							jPanel12.add(jDeleteBreakpointButton);
							jDeleteBreakpointButton.setText(MyLanguage.getString("Del"));
							jDeleteBreakpointButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jDeleteBreakpointButtonActionPerformed(evt);
								}
							});
						}
						{
							jRefreshBreakpointButton = new JButton();
							jPanel12.add(jRefreshBreakpointButton);
							jRefreshBreakpointButton.setText(MyLanguage.getString("Refresh"));
							jRefreshBreakpointButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jRefreshBreakpointButtonActionPerformed(evt);
								}
							});
						}
						{
							jEnableBreakpointButton = new JButton();
							jPanel12.add(jEnableBreakpointButton);
							jEnableBreakpointButton.setText(MyLanguage.getString("Enable"));
							jEnableBreakpointButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jEnableBreakpointButtonActionPerformed(evt);
								}
							});
						}
						{
							jDisableBreakpointButton = new JButton();
							jPanel12.add(jDisableBreakpointButton);
							jDisableBreakpointButton.setText(MyLanguage.getString("Disable"));
							jDisableBreakpointButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jDisableBreakpointButtonActionPerformed(evt);
								}
							});
						}
						{
							jSaveBreakpointButton = new JButton();
							jPanel12.add(jSaveBreakpointButton);
							jSaveBreakpointButton.setText(MyLanguage.getString("Save"));
							jSaveBreakpointButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jSaveBreakpointButtonActionPerformed(evt);
								}
							});
						}
						{
							jLoadBreakpointButton = new JButton();
							jPanel12.add(jLoadBreakpointButton);
							jLoadBreakpointButton.setText(MyLanguage.getString("Load"));
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
					jTabbedPane1.addTab(MyLanguage.getString("Bochs"), new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/application_xp_terminal.png")),
							jPanel1, null);
					jTabbedPane1.addTab("ELF", new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/linux.png")), getJELFBreakpointPanel(), null);
					DiskPanel diskPanel = getDiskPanel();
					if (diskPanel.getFile() != null) {
						jTabbedPane1.addTab(diskPanel.getFile().getName(), new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/package.png")), diskPanel,
								null);
					}
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
						TableLayout jPanel2Layout = new TableLayout(new double[][] { { TableLayout.FILL, 411.0, TableLayout.MINIMUM, TableLayout.MINIMUM }, { TableLayout.FILL } });
						jPanel2Layout.setHGap(5);
						jPanel2Layout.setVGap(5);
						jPanel2.setLayout(jPanel2Layout);
						jPanel1.add(jPanel2, BorderLayout.SOUTH);
						{
							jBochsCommandTextField = new JTextField();
							jPanel2.add(jBochsCommandTextField, "0, 0, 1, 0");
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
							jPanel2.add(jBochsCommandButton, "2, 0");
							jPanel2.add(getJClearBochsButton(), "3, 0");
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
				jTabbedPane3 = new JMaximizableTabbedPane();
				jSplitPane1.add(jTabbedPane3, JSplitPane.LEFT);
				{
					jPanel8 = new JPanel();
					BorderLayout jPanel8Layout = new BorderLayout();
					jPanel8.setLayout(jPanel8Layout);
					jTabbedPane3.addTab(MyLanguage.getString("Memory"), new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/memory.png")), jPanel8, null);
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
							// ComboBoxModel jMemoryAddressComboBoxModel
							// = new DefaultComboBoxModel(new String[] {
							// "0x00000000" });
							jMemoryAddressComboBox = new JComboBox();
							jPanel9.add(jMemoryAddressComboBox);
							jMemoryAddressComboBox.setSelectedItem("0x00000000");
							// jMemoryAddressComboBox.setModel(jMemoryAddressComboBoxModel);
							jMemoryAddressComboBox.setEditable(true);
							jMemoryAddressComboBox.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jMemoryAddressComboBoxActionPerformed(evt);
								}
							});
							new Thread() {
								public void run() {
									TreeSet<String> vector = Setting.getInstance().getMemoryCombo();
									// for (int x = 0; x < vector.size(); x++) {
									// addMemoryAddressComboBox(vector.get(x).toString());
									// }

									Iterator<String> iterator = vector.iterator();
									while (iterator.hasNext()) {
										addMemoryAddressComboBox(iterator.next());
									}
								}
							}.start();
						}
						{
							jGOMemoryButton = new JButton();
							jPanel9.add(jGOMemoryButton);
							jPanel9.add(getJGoLinearButton());
							jPanel9.add(getJButton2());
							jPanel9.add(getJButton5());
							jGOMemoryButton.setText(MyLanguage.getString("Go"));
							jGOMemoryButton.setToolTipText(MyLanguage.getString("Physical_address"));
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
					jTabbedPane3.addTab(MyLanguage.getString("GDT"), new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/gdt.png")), jPanel5, null);
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
					jTabbedPane3.addTab(MyLanguage.getString("IDT"), new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/idt.png")), jPanel6, null);
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
							jIDTTable.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									jIDTTableMouseClicked(evt);
								}
							});
						}
					}
				}
				{
					jPanel7 = new JPanel();
					BorderLayout jPanel7Layout = new BorderLayout();
					jPanel7.setLayout(jPanel7Layout);
					jTabbedPane3.addTab(MyLanguage.getString("LDT"), new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/ldt.png")), jPanel7, null);
					jTabbedPane3.addTab(MyLanguage.getString("Search_memory"), new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/memory.png")),
							getJPanel17(), null);
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
			jTabbedPane2 = new JMaximizableTabbedPane();
			// jTabbedPane2.setCloseIcon(true);
			// jTabbedPane2.setMaxIcon(true);
			//
			// jTabbedPane2.addCloseListener(new CloseListener() {
			// public void closeOperation(MouseEvent e) {
			// jTabbedPane2.remove(jTabbedPane2.getOverTabIndex());
			// }
			// });
			//
			// jTabbedPane2.addMaxListener(new MaxListener() {
			// public void maxOperation(MouseEvent e) {
			// jTabbedPane2.detachTab(jTabbedPane2.getOverTabIndex());
			// }
			// });

			jSplitPane2.add(jTabbedPane2, JSplitPane.BOTTOM);
			{
				jScrollPane1 = new JScrollPane();
				jTabbedPane2.addTab(MyLanguage.getString("Register"), new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/text_kerning.png")), jScrollPane1,
						null);
				{
					jRegisterPanel1 = new JRegisterPanel(this);
					jScrollPane1.setViewportView(jRegisterPanel1);
				}
			}
			{
				jPanel3 = new JPanel();
				jTabbedPane2
						.addTab(MyLanguage.getString("History"), new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/book_addresses.png")), jPanel3, null);
				BorderLayout jPanel3Layout = new BorderLayout();
				jPanel3.setLayout(jPanel3Layout);
				{
					jScrollPane6 = new JScrollPane();
					jPanel3.add(jScrollPane6, BorderLayout.CENTER);
					jPanel3.add(getJPanel13(), BorderLayout.NORTH);
					jScrollPane6.setViewportView(getJHistoryTable());
				}
			}
			{
				jPanel11 = new JPanel();
				jTabbedPane2.addTab(MyLanguage.getString("Paging"), new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/page_copy.png")), jPanel11, null);
				jTabbedPane2.addTab(MyLanguage.getString("Address_translate"), new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/page_go.png")),
						getJAddressTranslatePanel(), null);
				jTabbedPane2.addTab("Page table graph (experimental)", new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/page_lightning.png")),
						getJPageTableGraphPanel(), null);
				if (!Global.debug) {
					jTabbedPane2.removeTabAt(jTabbedPane2.getTabCount() - 1);
				}
				jTabbedPane2.addTab(MyLanguage.getString("Table_translate"), new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/page_refresh.png")),
						getJTableTranslateScrollPane(), null);
				jTabbedPane2.addTab(MyLanguage.getString("ELF_dump"), new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/linux.png")),
						getJELFDumpScrollPane(), null);
				jTabbedPane2
						.addTab("OS debug informations", new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/bug.png")), getJOSDebugStandardPanel(), null);
				BorderLayout jPanel11Layout = new BorderLayout();
				jPanel11.setLayout(jPanel11Layout);
				jPanel11.add(getJSplitPane3(), BorderLayout.CENTER);
				jPanel11.add(getJPanel19(), BorderLayout.NORTH);
			}
		}
		return jSplitPane2;
	}

	private JLabel getJRunningLabel() {
		if (jRunningLabel == null) {
			jRunningLabel = new JLabel();

			new Thread() {
				public void run() {
					URL url = getClass().getClassLoader().getResource("images/ajax-loader.gif");
					if (Setting.getInstance().getCurrentLanguage().equals("zh_TW")) {
						jRunningLabel
								.setText("<html><center>Bochs is running, click the pause button to pause it !!!<br><br><img src=\""
										+ url
										+ "\" /><br><br><a style=\"color: #ffffff;  text-decoration:none\" href=\"http://www.kingofcoders.com\">編程王網站  www.kingofcoders.com</a></center></html>");
					} else if (Setting.getInstance().getCurrentLanguage().equals("zh_CN")) {
						jRunningLabel
								.setText("<html><center>Bochs is running, click the pause button to pause it !!!<br><br><img src=\""
										+ url
										+ "\" /><br><br><img src=\"http://www.kingofcoders.com/images/KOC_logo2.jpg\" /><br><a style=\"color: #ffffff;  text-decoration:none\" href=\"http://www.kingofcoders.com\">编程王网站  www.kingofcoders.com</a></center></html>");
					} else {
						jRunningLabel.setText("<html><center>Bochs is running, click the pause button to pause it !!!<br><br><img src=\"" + url + "\" /></center></html>");
					}
				}
			}.start();
			jRunningLabel.setHorizontalAlignment(SwingConstants.CENTER);
			jRunningLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			jRunningLabel.setFont(new java.awt.Font("Arial", 0, 20));
			jRunningLabel.setForeground(Color.white);
			jRunningLabel.setBackground(new Color(0, 0, 0, 180));
			jRunningLabel.setOpaque(true);
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

	private JToolBar getJPanel19() {
		if (jPanel19 == null) {
			jPanel19 = new JToolBar();
			FlowLayout jPanel19Layout = new FlowLayout();
			jPanel19Layout.setAlignment(FlowLayout.LEFT);
			jPanel19.add(getJPagingGraphButton());
			jPanel19.add(getJButton21x());
			jPanel19.add(getJButton20());
			jPanel19.add(getJDumpPageDirectoryAddressTextField());
			jPanel19.add(getJButton21());
			jPanel19.add(getJHideIfAddressIsZeroCheckBox());
		}
		return jPanel19;
	}

	private JButton getJPagingGraphButton() {
		if (jPagingGraphButton == null) {
			jPagingGraphButton = new JButton();
			jPagingGraphButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/disk.png")));
			jPagingGraphButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jPagingGraphButtonActionPerformed(evt);
				}
			});
		}
		return jPagingGraphButton;
	}

	private void jPagingGraphButtonActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!CommonLib.saveImage(jSplitPane3, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
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
			jSearchAddressRadioButton1.setText(MyLanguage.getString("Virtual_address"));
			jSearchAddressRadioButton1.setSelected(true);
			getButtonGroup3().add(jSearchAddressRadioButton1);
		}
		return jSearchAddressRadioButton1;
	}

	private JRadioButton getJRadioButton4() {
		if (jSearchAddressRadioButton2 == null) {
			jSearchAddressRadioButton2 = new JRadioButton();
			jSearchAddressRadioButton2.setText(MyLanguage.getString("Linear_address"));
			getButtonGroup3().add(jSearchAddressRadioButton2);
		}

		return jSearchAddressRadioButton2;
	}

	private JRadioButton getJRadioButton5() {
		if (jSearchAddressRadioButton3 == null) {
			jSearchAddressRadioButton3 = new JRadioButton();
			jSearchAddressRadioButton3.setVisible(false);
			jSearchAddressRadioButton3.setText(MyLanguage.getString("Physical_address"));
			getButtonGroup3().add(jSearchAddressRadioButton3);
		}

		return jSearchAddressRadioButton3;
	}

	private JButton getJButton16() {
		if (jRefreshAddressTranslateButton == null) {
			jRefreshAddressTranslateButton = new JButton();
			jRefreshAddressTranslateButton.setText(MyLanguage.getString("Convert"));
			jRefreshAddressTranslateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRefreshAddressTranslateButtonActionPerformed(evt);
				}
			});
		}
		return jRefreshAddressTranslateButton;
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
			jAddressTranslateTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			for (int x = 0; x < jAddressTranslateTable2.getColumnCount(); x++) {
				jAddressTranslateTable2.getColumnModel().getColumn(x).setPreferredWidth(100);
			}
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
			jToolBar3.add(getJButton19());
		}
		return jToolBar3;
	}

	private JButton getJButton17() {
		if (jButton17 == null) {
			jButton17 = new JButton();
			jButton17.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/disk.png")));
			jButton17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton17ActionPerformed(evt);
				}
			});
		}
		return jButton17;
	}

	private JButton getJButton18() {
		if (jButton18 == null) {
			jButton18 = new JButton();
			jButton18.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/excel.gif")));
			jButton18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton18ActionPerformed(evt);
				}
			});
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
			jAddressTextField.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jAddressTextFieldKeyTyped(evt);
				}
			});
		}
		return jAddressTextField;
	}

	private void jRefreshAddressTranslateButtonActionPerformed(ActionEvent evt) {
		AddressTranslateTableModel model = (AddressTranslateTableModel) this.jAddressTranslateTable2.getModel();

		if (jSearchAddressRadioButton1.isSelected()) {
			if (!this.jAddressTextField.getText().contains(":") || this.jAddressTextField.getText().replaceAll("[^:]", "").length() != 1) {
				JOptionPane.showMessageDialog(this, "Error, please input <segment selector>:<offset>\n\ne.g. : 0x10:0x12345678", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Long segSelector = CommonLib.convertFilesize(this.jAddressTextField.getText().split(":")[0]);
			Long address = CommonLib.convertFilesize(this.jAddressTextField.getText().split(":")[1]);

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
			int descriptor[] = CommonLib.getMemoryFromBochs(CommonLib.convertFilesize(this.jRegisterPanel1.jGDTRTextField.getText()) + (segNo * 8), 8);
			long baseAddress = CommonLib.getLong(descriptor[2], descriptor[3], descriptor[4], descriptor[7], 0, 0, 0, 0);
			long linearAddress = baseAddress + address;
			model.baseAddress.add(baseAddress);
			model.linearAddress.add(linearAddress);

			long pdNo = CommonLib.getValue(linearAddress, 31, 22);
			model.pdNo.add(pdNo);
			int pdeBytes[] = CommonLib.getMemoryFromBochs(CommonLib.convertFilesize(this.jRegisterPanel1.jCR3TextField.getText()) + (pdNo * 4), 4);
			long pde = CommonLib.getInt(pdeBytes, 0);
			model.pde.add(pde);

			long ptNo = CommonLib.getValue(linearAddress, 21, 12);
			model.ptNo.add(ptNo);
			long pageTableBaseAddress = pde & 0xfffff000;
			int pteBytes[] = CommonLib.getMemoryFromBochs(pageTableBaseAddress + (ptNo * 4), 4);
			long pte = CommonLib.getInt(pteBytes, 0);
			long pagePhysicalAddress = pte & 0xfffff000;
			model.pte.add(pte);

			long physicalAddress = pagePhysicalAddress + CommonLib.getValue(linearAddress, 11, 0);
			model.physicalAddress.add(physicalAddress);
			int bytesAtPhysicalAddress[] = CommonLib.getMemoryFromBochs(physicalAddress, 8);
			model.bytes.add(CommonLib.convertToString(bytesAtPhysicalAddress));

			model.fireTableDataChanged();
		} else if (jSearchAddressRadioButton2.isSelected()) {
			// for (int x = 0; x < model.getRowCount(); x++) {
			// if (model.searchType.get(x).equals(2) &&
			// model.searchAddress.get(x).equals(CommonLib.convertFilesize(this.jAddressTextField.getText())))
			// {
			// return;
			// }
			// }
			Long address = CommonLib.convertFilesize(this.jAddressTextField.getText());

			model.searchType.add(2);
			model.searchAddress.add(address);

			long baseAddress = 0;
			long linearAddress = baseAddress + address;
			model.baseAddress.add(baseAddress);
			model.linearAddress.add(linearAddress);

			long pdNo = CommonLib.getValue(linearAddress, 31, 22);
			model.pdNo.add(pdNo);
			int pdeBytes[] = CommonLib.getMemoryFromBochs(CommonLib.convertFilesize(this.jRegisterPanel1.jCR3TextField.getText()) + (pdNo * 4), 4);
			long pde = CommonLib.getInt(pdeBytes, 0);
			model.pde.add(pde);

			long ptNo = CommonLib.getValue(linearAddress, 21, 12);
			model.ptNo.add(ptNo);
			long pageTableBaseAddress = pde & 0xfffff000;
			int pteBytes[] = CommonLib.getMemoryFromBochs(pageTableBaseAddress + (ptNo * 4), 4);
			long pte = CommonLib.getInt(pteBytes, 0);
			long pagePhysicalAddress = pte & 0xfffff000;
			model.pte.add(pte);

			long physicalAddress = pagePhysicalAddress + CommonLib.getValue(linearAddress, 11, 0);
			model.physicalAddress.add(physicalAddress);
			int bytesAtPhysicalAddress[] = CommonLib.getMemoryFromBochs(physicalAddress, 8);
			model.bytes.add(CommonLib.convertToString(bytesAtPhysicalAddress));

			model.fireTableDataChanged();
		} else if (jSearchAddressRadioButton3.isSelected()) {
			for (int x = 0; x < model.getRowCount(); x++) {
				if (model.searchType.get(x).equals(3) && model.searchAddress.get(x).equals(CommonLib.convertFilesize(this.jAddressTextField.getText()))) {
					return;
				}
			}
			Long addr = CommonLib.convertFilesize(this.jAddressTextField.getText());
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
			jRefreshAddressTranslateTableButton.setText(MyLanguage.getString("Refresh"));
			jRefreshAddressTranslateTableButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/arrow_refresh.png")));
			jRefreshAddressTranslateTableButton.setText("Refresh");
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

				long gdtBase = CommonLib.getPhysicalAddress(CommonLib.convertFilesize(this.jRegisterPanel1.jCR3TextField.getText()),
						CommonLib.convertFilesize(this.jRegisterPanel1.jGDTRTextField.getText()));
				System.out.println("gdtBase=" + Long.toHexString(gdtBase));
				commandReceiver.clearBuffer();
				gdtBase += model.segNo.get(x) * 8;
				sendCommand("xp /8bx " + gdtBase);
				String result = commandReceiver.getCommandResult(String.format("%08x", gdtBase));

				int bytes[] = new int[8];
				String[] b = result.replaceFirst("^.*:", "").split("\t");
				for (int y = 1; y <= 8; y++) {
					bytes[y - 1] = (int) CommonLib.convertFilesize(b[y]);
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
			jHexTablePopupMenu.add(getJDisassemble32MenuItem());
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
			jPDEMenuItem.setText(MyLanguage.getString("PDE"));
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
			jPTEMenuItem.setText(MyLanguage.getString("PTE"));
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

	private JMenuItem getJDisassemble32MenuItem() {
		if (jDisassemble32MenuItem == null) {
			jDisassemble32MenuItem = new JMenuItem();
			jDisassemble32MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jDisassemble32MenuItemActionPerformed(evt);
				}
			});
			jDisassemble32MenuItem.setText(MyLanguage.getString("Disassemble"));
		}
		return jDisassemble32MenuItem;
	}

	private void jDisassemble32MenuItemActionPerformed(ActionEvent evt) {
		this.jInstructionComboBox.setSelectedItem(currentMemoryWindowsAddress + jHexTable1.getSelectedRow() * 8 + jHexTable1.getSelectedColumn() - 1);
		jButton14ActionPerformed(null);
		jTabbedPane1.setSelectedIndex(0);
	}

	private JPanel getJELFBreakpointPanel() {
		if (jELFBreakpointPanel == null) {
			jELFBreakpointPanel = new JPanel();
			BorderLayout jELFBreakpointPanelLayout = new BorderLayout();
			jELFBreakpointPanel.setLayout(jELFBreakpointPanelLayout);
			jELFBreakpointPanel.add(getJPanel23(), BorderLayout.NORTH);
			jELFBreakpointPanel.add(getJScrollPane14(), BorderLayout.CENTER);
			jELFBreakpointPanel.add(getJPanel24(), BorderLayout.SOUTH);
		}
		return jELFBreakpointPanel;
	}

	private JPanel getJPanel23() {
		if (jPanel23 == null) {
			jPanel23 = new JPanel();
			FlowLayout jPanel23Layout = new FlowLayout();
			jPanel23.setLayout(jPanel23Layout);
			jPanel23.add(getJELFFileComboBox());
			jPanel23.add(getJOpenELFButton());
			jPanel23.add(getJShowELFByteCheckBox());
		}
		return jPanel23;
	}

	private JButton getJOpenELFButton() {
		if (jOpenELFButton == null) {
			jOpenELFButton = new JButton();
			jOpenELFButton.setText("Open ELF");
			jOpenELFButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jOpenELFButtonActionPerformed(evt);
				}
			});
		}
		return jOpenELFButton;
	}

	private JComboBox getJELFFileComboBox() {
		if (jELFFileComboBox == null) {
			ComboBoxModel jELFFileComboBoxModel = new DefaultComboBoxModel();
			jELFFileComboBox = new JComboBox();
			jELFFileComboBox.setModel(jELFFileComboBoxModel);
			jELFFileComboBox.setPreferredSize(new java.awt.Dimension(163, 26));
			jELFFileComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jELFFileComboBoxActionPerformed(evt);
				}
			});
		}
		return jELFFileComboBox;
	}

	private JScrollPane getJScrollPane14() {
		if (jScrollPane14 == null) {
			jScrollPane14 = new JScrollPane();
			jScrollPane14.setViewportView(getJELFTable());
		}
		return jScrollPane14;
	}

	private JTable getJELFTable() {
		if (jELFTable == null) {
			jELFTable = new JTable();
			jELFTable.setModel(new JSourceCodeTableModel());
			jELFTable.getColumnModel().getColumn(0).setCellRenderer(new JSourceCodeCellRenderer());
			jELFTable.getColumnModel().getColumn(3).setCellRenderer(new JSourceCodeCellRenderer());
			jELFTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jELFTable.getColumnModel().getColumn(0).setPreferredWidth(20);
			jELFTable.getColumnModel().getColumn(1).setPreferredWidth(30);
			jELFTable.getColumnModel().getColumn(2).setPreferredWidth(80);
			jELFTable.getColumnModel().getColumn(3).setPreferredWidth(300);
			getJELFTable().getTableHeader().setReorderingAllowed(false);
			jELFTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					jELFTableMouseClicked(evt);
				}
			});
		}
		return jELFTable;
	}

	private void jOpenELFButtonActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File(Setting.getInstance().getLastElfHistoryOpenDir()));

		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			openELF(fc.getSelectedFile());
			parseELF(fc.getSelectedFile());
		}
	}

	private void openELF(File file) {
		String lines = ElfUtil.getDebugLine(file);
		String filenames[] = lines.split("\n")[0].split(",");
		JSourceCodeTableModel model = (JSourceCodeTableModel) jELFTable.getModel();
		model.setDebugLine(lines);

		for (int x = 0; x < filenames.length; x++) {
			// find source file
			Collection<File> found = FileUtils.listFiles(file.getParentFile(), FileFilterUtils.nameFileFilter(filenames[x]), TrueFileFilter.INSTANCE);
			if (found.size() == 0) {
				this.jELFFileComboBox.addItem(file.getName() + " - " + filenames[x] + " (missing)");
			} else {
				File foundFile = (File) found.toArray()[0];

				// read source code
				try {
					List<String> list = FileUtils.readLines(foundFile);
					model.getSourceCodes().put(foundFile.getName(), list);
				} catch (IOException e) {
					e.printStackTrace();
				}

				this.jELFFileComboBox.addItem(file.getName() + " - " + foundFile.getAbsolutePath().substring(file.getParent().length()));
				// end read source code
			}
			// end find source file
		}
		jELFFileComboBoxActionPerformed(null);

		model.updateBreakpoint(getRealEIP());

		// save history
		Setting.getInstance().setLastElfHistoryOpenDir(file.getParentFile().getAbsolutePath());
		Setting.getInstance().save();
		// end save history
	}

	private void jELFFileComboBoxActionPerformed(ActionEvent evt) {
		JSourceCodeTableModel model = (JSourceCodeTableModel) jELFTable.getModel();
		model.setCurrentFile(new File(jELFFileComboBox.getSelectedItem().toString().split("-")[1]).getName());
	}

	private JPanel getJPanel24() {
		if (jPanel24 == null) {
			jPanel24 = new JPanel();
			jPanel24.add(getJRefreshButton());
			jPanel24.add(getJEnableELFBreakpointButton());
			jPanel24.add(getJDisableELFBreakpointButton());
			jPanel24.add(getJSaveELFBreakpointButton());
			jPanel24.add(getJLoadELFBreakpointButton());
		}
		return jPanel24;
	}

	private JButton getJRefreshButton() {
		if (jRefreshELFBreakpointButton == null) {
			jRefreshELFBreakpointButton = new JButton();
			jRefreshELFBreakpointButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRefreshELFBreakpointButtonActionPerformed(evt);
				}
			});
			jRefreshELFBreakpointButton.setText(MyLanguage.getString("Refresh"));
		}
		return jRefreshELFBreakpointButton;
	}

	private JButton getJEnableELFBreakpointButton() {
		if (jEnableELFBreakpointButton == null) {
			jEnableELFBreakpointButton = new JButton();
			jEnableELFBreakpointButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jEnableELFBreakpointButtonActionPerformed(evt);
				}
			});
			jEnableELFBreakpointButton.setText(MyLanguage.getString("Enable"));
		}
		return jEnableELFBreakpointButton;
	}

	private JButton getJDisableELFBreakpointButton() {
		if (jDisableELFBreakpointButton == null) {
			jDisableELFBreakpointButton = new JButton();
			jDisableELFBreakpointButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jDisableELFBreakpointButtonActionPerformed(evt);
				}
			});
			jDisableELFBreakpointButton.setText(MyLanguage.getString("Disable"));
		}
		return jDisableELFBreakpointButton;
	}

	private JButton getJSaveELFBreakpointButton() {
		if (jSaveELFBreakpointButton == null) {
			jSaveELFBreakpointButton = new JButton();
			jSaveELFBreakpointButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSaveELFBreakpointButtonActionPerformed(evt);
				}
			});
			jSaveELFBreakpointButton.setText(MyLanguage.getString("Save"));
		}
		return jSaveELFBreakpointButton;
	}

	private JButton getJLoadELFBreakpointButton() {
		if (jLoadELFBreakpointButton == null) {
			jLoadELFBreakpointButton = new JButton();
			jLoadELFBreakpointButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jLoadELFBreakpointButtonActionPerformed(evt);
				}
			});
			jLoadELFBreakpointButton.setText(MyLanguage.getString("Load"));
		}
		return jLoadELFBreakpointButton;
	}

	private void jRefreshELFBreakpointButtonActionPerformed(ActionEvent evt) {
		if (Global.debug) {
			JSourceCodeTableModel model = (JSourceCodeTableModel) jELFTable.getModel();

			model.updateBreakpoint(getRealEIP());
		}
	}

	private long getRealEIP() {
		try {
			long eip;
			if (CommonLib.getBit(CommonLib.convertFilesize(jRegisterPanel1.jCR0TextField.getText()), 0) == 1) {
				eip = CommonLib.convertFilesize(jRegisterPanel1.jEIPTextField.getText());
			} else {
				eip = CommonLib.convertFilesize(jRegisterPanel1.jCSTextField.getText()) * 16 + CommonLib.convertFilesize(jRegisterPanel1.jEIPTextField.getText());
			}
			return eip;
		} catch (Exception ex) {
			return 0;
		}
	}

	private void jEnableELFBreakpointButtonActionPerformed(ActionEvent evt) {
		JSourceCodeTableModel model = (JSourceCodeTableModel) jELFTable.getModel();
		long address = model.getDebugLineInfo().get(model.getCurrentFile()).get(this.jELFTable.getSelectedRow());

		for (int x = 0; x < jBreakpointTable.getRowCount(); x++) {
			long addr = CommonLib.convertFilesize(jBreakpointTable.getValueAt(x, 2).toString());
			if (addr == address) {
				String breakpointNo = jBreakpointTable.getValueAt(x, 0).toString().trim().split(" ")[0];
				sendCommand("bpe " + breakpointNo);

				model.updateBreakpoint(getRealEIP());
				this.updateBreakpoint();
				return;
			}
		}
	}

	private void jDisableELFBreakpointButtonActionPerformed(ActionEvent evt) {
		JSourceCodeTableModel model = (JSourceCodeTableModel) jELFTable.getModel();
		long address = model.getDebugLineInfo().get(model.getCurrentFile()).get(this.jELFTable.getSelectedRow());

		for (int x = 0; x < jBreakpointTable.getRowCount(); x++) {
			long addr = CommonLib.convertFilesize(jBreakpointTable.getValueAt(x, 2).toString());
			if (addr == address) {
				String breakpointNo = jBreakpointTable.getValueAt(x, 0).toString().trim().split(" ")[0];
				sendCommand("bpd " + breakpointNo);

				model.updateBreakpoint(getRealEIP());
				this.updateBreakpoint();
				return;
			}
		}
	}

	private void jSaveELFBreakpointButtonActionPerformed(ActionEvent evt) {
		this.jSaveBreakpointButtonActionPerformed(null);
	}

	private void jLoadELFBreakpointButtonActionPerformed(ActionEvent evt) {
		this.jLoadBreakpointButtonActionPerformed(null);
	}

	private void jELFTableMouseClicked(MouseEvent evt) {
		if (SwingUtilities.isRightMouseButton(evt)) {
			// select
			Point p = evt.getPoint();
			int rowNumber = jELFTable.rowAtPoint(p);
			int columnNumber = jELFTable.columnAtPoint(p);
			ListSelectionModel model = jELFTable.getSelectionModel();
			model.setSelectionInterval(rowNumber, rowNumber);
			jELFTable.getColumnModel().getSelectionModel().setSelectionInterval(columnNumber, columnNumber);
			// end select

			getJELFTablePopupMenu().show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}

	private JPanel getJPanel25() {
		if (jPanel25 == null) {
			jPanel25 = new JPanel();
			FlowLayout jPanel25Layout = new FlowLayout();
			jPanel25Layout.setHgap(0);
			jPanel25Layout.setVgap(0);
			jPanel25Layout.setAlignment(FlowLayout.LEFT);
			jPanel25.setLayout(jPanel25Layout);
			jPanel25.add(getJCPUModeLabel());
			jPanel25.add(getJBochsVersionLabel());
			jPanel25.add(getJLatestVersionLabel());
		}
		return jPanel25;
	}

	private JLabel getJCPUModeLabel() {
		if (jCPUModeLabel == null) {
			jCPUModeLabel = new JLabel();
		}
		return jCPUModeLabel;
	}

	private JCheckBox getJShowELFByteCheckBox() {
		if (jShowELFByteCheckBox == null) {
			jShowELFByteCheckBox = new JCheckBox();
			jShowELFByteCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jShowELFByteCheckBoxActionPerformed(evt);
				}
			});
			jShowELFByteCheckBox.setText(MyLanguage.getString("Bytes"));
		}
		return jShowELFByteCheckBox;
	}

	private void jShowELFByteCheckBoxActionPerformed(ActionEvent evt) {
		JSourceCodeTableModel model = (JSourceCodeTableModel) jELFTable.getModel();
		model.showBytes(jShowELFByteCheckBox.isSelected());
	}

	private JLabel getJBochsVersionLabel() {
		if (jBochsVersionLabel == null) {
			jBochsVersionLabel = new JLabel();
		}
		return jBochsVersionLabel;
	}

	private JLabel getJLatestVersionLabel() {
		if (jLatestVersionLabel == null) {
			jLatestVersionLabel = new JLabel();
			jLatestVersionLabel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					jLatestVersionLabelMouseClicked(evt);
				}
			});
		}
		return jLatestVersionLabel;
	}

	private void jLatestVersionLabelMouseClicked(MouseEvent evt) {
		if (!jLatestVersionLabel.getText().equals("")) {
			try {
				java.awt.Desktop.getDesktop().browse(new URI(jLatestVersionLabel.getText().split(MyLanguage.getString("Download_url") + " : ")[1]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void thisWindowActivated(WindowEvent evt) {

	}

	private JPanel getJELFDumpScrollPane() {
		if (jELFDumpPanel == null) {
			jELFDumpPanel = new JPanel();
			BorderLayout jELFDumpPanelLayout = new BorderLayout();
			jELFDumpPanel.setLayout(jELFDumpPanelLayout);
			jELFDumpPanel.add(getJPanel26(), BorderLayout.NORTH);
			jELFDumpPanel.add(getJTabbedPane4(), BorderLayout.CENTER);
		}
		return jELFDumpPanel;
	}

	private JToolBar getJPanel26() {
		if (jPanel26 == null) {
			jPanel26 = new JToolBar();
			FlowLayout jPanel26Layout = new FlowLayout();
			jPanel26Layout.setAlignment(FlowLayout.LEFT);
			jPanel26.add(getJELFComboBox());
			jPanel26.add(getJButton16x());
		}
		return jPanel26;
	}

	private JComboBox getJELFComboBox() {
		if (jELFComboBox == null) {
			ComboBoxModel jELFComboBoxModel = new DefaultComboBoxModel(new String[] {});
			jELFComboBox = new JComboBox();
			jELFComboBox.setModel(jELFComboBoxModel);
			jELFComboBox.setMaximumSize(new java.awt.Dimension(400, 30));
			jELFComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jELFComboBoxActionPerformed(evt);
				}
			});
		}
		return jELFComboBox;
	}

	private JButton getJButton16x() {
		if (jOpenELFDumpButton == null) {
			jOpenELFDumpButton = new JButton();
			jOpenELFDumpButton.setText("Open ELF");
			jOpenELFDumpButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jOpenELFDumpButtonActionPerformed(evt);
				}
			});
		}
		return jOpenELFDumpButton;
	}

	private JTabbedPane getJTabbedPane4() {
		if (jTabbedPane4 == null) {
			jTabbedPane4 = new JMaximizableTabbedPane();
			jTabbedPane4.addTab("Header", null, getJELFHeaderScrollPane(), null);
			jTabbedPane4.addTab("Section", null, getJScrollPane15(), null);
			jTabbedPane4.addTab("Program header", null, getJScrollPane16(), null);
			jTabbedPane4.addTab("objdump", null, getObjdump(), null);
			jTabbedPane4.addTab(".rel.plt", null, getJPanel28(), null);
			jTabbedPane4.addTab(".dynamic", null, getJPanel29(), null);
		}
		return jTabbedPane4;
	}

	private JScrollPane getJELFHeaderScrollPane() {
		if (jELFHeaderScrollPane == null) {
			jELFHeaderScrollPane = new JScrollPane();
			jELFHeaderScrollPane.setViewportView(getJELFHeaderTable());
		}
		return jELFHeaderScrollPane;
	}

	private JTable getJELFHeaderTable() {
		if (jELFHeaderTable == null) {
			TableModel jELFHeaderTableModel = new DefaultTableModel(null, new String[] { MyLanguage.getString("Field"), MyLanguage.getString("Value") });
			jELFHeaderTable = new JTable();
			jELFHeaderTable.setModel(jELFHeaderTableModel);
		}
		return jELFHeaderTable;
	}

	private void jOpenELFDumpButtonActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		// load history
		fc.setCurrentDirectory(new File(Setting.getInstance().getLastElfHistoryOpenDir2()));

		// end load history
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			this.jELFComboBox.addItem(file);

			parseELF(file);
			openELF(file);
			// save history
			Setting.getInstance().setLastElfHistoryOpenDir2(file.getParentFile().getAbsolutePath());
			Setting.getInstance().save();
			// end save history
		}
	}

	private void parseELF(File elfFile) {
		jELFDumpPanel.remove(jTabbedPane4);
		jTabbedPane4 = null;
		jELFDumpPanel.add(getJTabbedPane4(), BorderLayout.CENTER);

		HashMap map = ElfUtil.getELFDetail(elfFile);
		if (map != null) {
			// header
			DefaultTableModel model = (DefaultTableModel) jELFHeaderTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			Set entries = ((HashMap) map.get("header")).entrySet();
			Iterator it = entries.iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();

				Vector<String> v = new Vector<String>();
				v.add(entry.getKey().toString());

				String bytesStr = "";

				if (entry.getValue().getClass() == Short.class) {
					jStatusLabel.setText("header " + Long.toHexString((Short) entry.getValue()));
					bytesStr += "0x" + Long.toHexString((Short) entry.getValue());
				} else if (entry.getValue().getClass() == Integer.class) {
					bytesStr += "0x" + Long.toHexString((Integer) entry.getValue());
				} else if (entry.getValue().getClass() == Long.class) {
					bytesStr += "0x" + Long.toHexString((Long) entry.getValue());
				} else {
					int b[] = (int[]) entry.getValue();
					for (int x = 0; x < b.length; x++) {
						bytesStr += "0x" + Long.toHexString(b[x]) + " ";
					}
				}

				v.add(bytesStr);
				model.addRow(v);
			}
			// end header

			// section
			model = (DefaultTableModel) jELFSectionTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			int sectionNo = 0;
			while (map.get("section" + sectionNo) != null) {
				entries = ((HashMap) map.get("section" + sectionNo)).entrySet();
				it = entries.iterator();
				Vector<String> v = new Vector<String>();
				while (it.hasNext()) {
					Map.Entry entry = (Map.Entry) it.next();

					String bytesStr = "";
					if (entry.getValue().getClass() == Short.class) {
						jStatusLabel.setText("section " + Long.toHexString((Short) entry.getValue()));
						bytesStr += "0x" + Long.toHexString((Short) entry.getValue());
					} else if (entry.getValue().getClass() == Integer.class) {
						bytesStr += "0x" + Long.toHexString((Integer) entry.getValue());
					} else if (entry.getValue().getClass() == String.class) {
						bytesStr = (String) entry.getValue();
					} else if (entry.getValue().getClass() == Long.class) {
						bytesStr += "0x" + Long.toHexString((Long) entry.getValue());
					} else {
						int b[] = (int[]) entry.getValue();
						for (int x = 0; x < b.length; x++) {
							bytesStr += "0x" + Long.toHexString(b[x]) + " ";
						}
					}

					v.add(bytesStr);
				}
				model.addRow(v);
				sectionNo++;
			}
			// end section

			// program header
			model = (DefaultTableModel) jProgramHeaderTable.getModel();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			int programHeaderNo = 0;
			while (map.get("programHeader" + programHeaderNo) != null) {
				entries = ((HashMap) map.get("programHeader" + programHeaderNo)).entrySet();
				it = entries.iterator();
				Vector<String> v = new Vector<String>();
				while (it.hasNext()) {
					Map.Entry entry = (Map.Entry) it.next();

					String bytesStr = "";
					if (entry.getValue().getClass() == Short.class) {
						jStatusLabel.setText("Program header " + Long.toHexString((Short) entry.getValue()));
						bytesStr += "0x" + Long.toHexString((Short) entry.getValue());
					} else if (entry.getValue().getClass() == Integer.class) {
						bytesStr += "0x" + Long.toHexString((Integer) entry.getValue());
					} else if (entry.getValue().getClass() == Long.class) {
						bytesStr += "0x" + Long.toHexString((Long) entry.getValue());
					} else if (entry.getValue().getClass() == String.class) {
						bytesStr += "0x" + entry.getValue();
					} else {
						int b[] = (int[]) entry.getValue();
						for (int x = 0; x < b.length; x++) {
							bytesStr += "0x" + Long.toHexString(b[x]) + " ";
						}
					}

					v.add(bytesStr);
				}
				model.addRow(v);
				programHeaderNo++;
			}
			// program header

			// symbol table
			int symbolTableNo = 0;
			while (map.get("symbolTable" + symbolTableNo) != null) {
				DefaultTableModel tempTableModel = new DefaultTableModel(null, new String[] { "No.", "st_name", "st_value", "st_size", "st_info", "st_other", "p_st_shndx" });
				JTable tempTable = new JTable();
				HashMap tempMap = (HashMap) map.get("symbolTable" + symbolTableNo);
				Vector<LinkedHashMap> v = (Vector<LinkedHashMap>) tempMap.get("vector");
				for (int x = 0; x < v.size(); x++) {
					Vector tempV = new Vector();
					jStatusLabel.setText("Symbol table " + x);
					tempV.add("0x" + Long.toHexString((Integer) v.get(x).get("No.")));
					tempV.add(v.get(x).get("st_name"));
					tempV.add("0x" + Long.toHexString((Long) v.get(x).get("st_value")));
					tempV.add("0x" + Long.toHexString((Long) v.get(x).get("st_size")));
					tempV.add("0x" + Long.toHexString((Integer) v.get(x).get("st_info")));
					tempV.add("0x" + Long.toHexString((Integer) v.get(x).get("st_other")));
					tempV.add("0x" + Long.toHexString((Integer) v.get(x).get("p_st_shndx")));

					tempTableModel.addRow(tempV);
				}

				tempTable.setModel(tempTableModel);
				JScrollPane tempScrollPane = new JScrollPane();
				tempScrollPane.setViewportView(tempTable);
				jTabbedPane4.addTab(tempMap.get("name").toString(), null, tempScrollPane, null);

				symbolTableNo++;
			}
			// end symbol table

			// note
			int noteSectionNo = 0;
			while (map.get("note" + noteSectionNo) != null) {
				DefaultTableModel tempTableModel = new DefaultTableModel(null, new String[] { "No.", "namesz", "descsz", "type", "name", "desc" });
				JTable tempTable = new JTable();
				HashMap tempMap = (HashMap) map.get("note" + noteSectionNo);
				Vector<LinkedHashMap> v = (Vector<LinkedHashMap>) tempMap.get("vector");
				for (int x = 0; x < v.size(); x++) {
					Vector tempV = new Vector();
					jStatusLabel.setText("Note " + x);
					tempV.add("0x" + Long.toHexString((Integer) v.get(x).get("No.")));
					tempV.add("0x" + Long.toHexString((Long) v.get(x).get("namesz")));
					tempV.add("0x" + Long.toHexString((Long) v.get(x).get("descsz")));
					tempV.add("0x" + Long.toHexString((Long) v.get(x).get("type")));
					tempV.add(v.get(x).get("name"));
					tempV.add(v.get(x).get("desc"));

					tempTableModel.addRow(tempV);
				}

				tempTable.setModel(tempTableModel);
				JScrollPane tempScrollPane = new JScrollPane();
				tempScrollPane.setViewportView(tempTable);
				jTabbedPane4.addTab(tempMap.get("name").toString(), null, tempScrollPane, null);

				noteSectionNo++;
			}
			// end note
		}

		try {
			jStatusLabel.setText("running objdump -DS");
			Process process = Runtime.getRuntime().exec("objdump -DS " + elfFile.getAbsolutePath());
			InputStream input = process.getInputStream();
			String str = "";
			byte b[] = new byte[102400];
			int len;
			while ((len = input.read(b)) > 0) {
				str += new String(b, 0, len);
			}
			jEditorPane1.setText(str);

			jStatusLabel.setText("readelf -r");
			process = Runtime.getRuntime().exec("readelf -r " + elfFile.getAbsolutePath());
			input = process.getInputStream();
			str = "";
			b = new byte[102400];
			while ((len = input.read(b)) > 0) {
				str += new String(b, 0, len);
			}
			jSearchRelPltEditorPane.setText(str);

			jStatusLabel.setText("readelf -d");
			process = Runtime.getRuntime().exec("readelf -d " + elfFile.getAbsolutePath());
			input = process.getInputStream();
			str = "";
			b = new byte[102400];
			while ((len = input.read(b)) > 0) {
				str += new String(b, 0, len);
			}
			jSearchDynamicEditorPane.setText(str);

			jStatusLabel.setText("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// end symbol table
	}

	private void jELFComboBoxActionPerformed(ActionEvent evt) {
		parseELF((File) jELFComboBox.getSelectedItem());
	}

	private void thisWindowOpened(WindowEvent evt) {
		if (Global.debug) {
			System.out.println("updateBochsStatus");
		}
		updateBochsStatus();
		if (Global.debug) {
			System.out.println("updateBochsStatus end");
		}
	}

	private JScrollPane getJScrollPane15() {
		if (jScrollPane15 == null) {
			jScrollPane15 = new JScrollPane();
			jScrollPane15.setViewportView(getJSectionTable());
		}
		return jScrollPane15;
	}

	private JTable getJSectionTable() {
		if (jELFSectionTable == null) {
			TableModel jSectionTableModel = new DefaultTableModel(null, new String[] { "No.", "sh_name", "sh_type", "sh_flags", "sh_addr", "sh_offset", "sh_size", "sh_link",
					"sh_info", "sh_addralign", "sh_entsize" });
			jELFSectionTable = new JTable();
			jELFSectionTable.setModel(jSectionTableModel);
			jELFSectionTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
		return jELFSectionTable;
	}

	private JScrollPane getJScrollPane16() {
		if (jScrollPane16 == null) {
			jScrollPane16 = new JScrollPane();
			jScrollPane16.setViewportView(getJProgramHeaderTable());
		}
		return jScrollPane16;
	}

	private JTable getJProgramHeaderTable() {
		if (jProgramHeaderTable == null) {
			TableModel jProgramHeaderTableModel = new DefaultTableModel(null, new String[] { "No.", "p_type", "p_offset", "p_vaddr", "p_filesz", "p_memsz", "p_flags", "p_align" });
			jProgramHeaderTable = new JTable();
			jProgramHeaderTable.setModel(jProgramHeaderTableModel);
			jProgramHeaderTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
		return jProgramHeaderTable;
	}

	private JButton getJButton19() {
		if (jButton19 == null) {
			jButton19 = new JButton();
			jButton19.setText("Delete");
			jButton19.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/cross.png")));
			jButton19.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton19ActionPerformed(evt);
				}
			});
		}
		return jButton19;
	}

	private void jButton19ActionPerformed(ActionEvent evt) {
		int rows[] = jAddressTranslateTable2.getSelectedRows();
		AddressTranslateTableModel model = (AddressTranslateTableModel) this.jAddressTranslateTable2.getModel();
		model.removeRow(rows);
	}

	private JButton getJButton20() {
		if (jButton20 == null) {
			jButton20 = new JButton();
			jButton20.setText("Dump CR3");
			jButton20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jDumpCR3ButtonActionPerformed(evt);
				}
			});
		}
		return jButton20;
	}

	private JButton getJButton21() {
		if (jDumpPageTableAtAddressButton == null) {
			jDumpPageTableAtAddressButton = new JButton();
			jDumpPageTableAtAddressButton.setText("Dump at here");
			jDumpPageTableAtAddressButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jDumpPageTableAtAddressButtonActionPerformed(evt);
				}
			});
		}
		return jDumpPageTableAtAddressButton;
	}

	private JTextField getJDumpPageDirectoryAddressTextField() {
		if (jDumpPageDirectoryAddressTextField == null) {
			jDumpPageDirectoryAddressTextField = new JTextField();
			jDumpPageDirectoryAddressTextField.setMaximumSize(new java.awt.Dimension(150, 28));
			jDumpPageDirectoryAddressTextField.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jDumpPageDirectoryAddressTextFieldKeyTyped(evt);
				}
			});
		}
		return jDumpPageDirectoryAddressTextField;
	}

	private void jDumpCR3ButtonActionPerformed(ActionEvent evt) {
		updatePageTable(CommonLib.convertFilesize(jRegisterPanel1.jCR3TextField.getText()));
	}

	private void jDumpPageTableAtAddressButtonActionPerformed(ActionEvent evt) {
		updatePageTable(CommonLib.convertFilesize(jDumpPageDirectoryAddressTextField.getText()));
	}

	private JButton getJButton21x() {
		if (jButton21 == null) {
			jButton21 = new JButton();
			jButton21.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/excel.gif")));
			jButton21.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton21ActionPerformed(evt);
				}
			});
		}
		return jButton21;
	}

	private void jButton21ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			CommonLib.exportTableModelToExcel(file, this.jPageDirectoryTable.getModel(), this.jPageTableTable.getModel(), jMemoryAddressComboBox.getSelectedItem().toString());
		}
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!CommonLib.saveImage(jHistoryTable, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void jButton17ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!CommonLib.saveImage(jAddressTranslateTable2, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void jButton18ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			CommonLib.exportTableModelToExcel(file, this.jAddressTranslateTable2.getModel(), jMemoryAddressComboBox.getSelectedItem().toString());
		}
	}

	private void jDumpPageDirectoryAddressTextFieldKeyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == '\n') {
			jDumpPageTableAtAddressButtonActionPerformed(null);
		}
	}

	private void jAddressTextFieldKeyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == '\n') {
			jRefreshAddressTranslateButtonActionPerformed(null);
		}
	}

	private JButton getJClearBochsButton() {
		if (jClearBochsButton == null) {
			jClearBochsButton = new JButton();
			jClearBochsButton.setText(MyLanguage.getString("Clear"));
			jClearBochsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jClearBochsButtonActionPerformed(evt);
				}
			});
		}
		return jClearBochsButton;
	}

	private void jClearBochsButtonActionPerformed(ActionEvent evt) {
		this.jBochsEditorPane.setText("");
	}

	public static int[] getPhysicalMemory(long address, int totalByte) {
		return getMemory(address, totalByte, true);
	}

	public static int[] getLinearMemory(long address, int totalByte) {
		return getMemory(address, totalByte, false);
	}

	private static int[] getMemory(long address, int totalByte, boolean isPhysicalAddress) {
		try {
			commandReceiver.clearBuffer();
			commandReceiver.shouldShow = false;
			if (isPhysicalAddress) {
				sendCommand("xp /" + totalByte + "bx " + address);
			} else {
				sendCommand("x /" + totalByte + "bx " + address);
			}
			int bytes[] = new int[totalByte];

			if (totalByte > 0) {
				float totalByte2 = totalByte - 1;
				totalByte2 = totalByte2 / 8;
				int totalByte3 = (int) Math.floor(totalByte2);
				String realEndAddressStr;
				String realStartAddressStr;
				long realStartAddress = address;
				realStartAddressStr = String.format("%08x", realStartAddress);
				long realEndAddress = realStartAddress + totalByte3 * 8;
				realEndAddressStr = String.format("%08x", realEndAddress);
				String result = commandReceiver.getCommandResult(realStartAddressStr, realEndAddressStr);
				if (result != null) {
					String[] lines = result.split("\n");
					int offset = 0;
					// System.out.println(result);
					for (int y = 0; y < lines.length; y++) {
						String[] b = lines[y].replaceFirst("^.*:", "").split("\t");
						// System.out.println(lines[y]);

						for (int x = 1; x < b.length && offset < totalByte; x++) {
							// System.out.println(offset + "==" + x);
							bytes[offset] = (int) CommonLib.convertFilesize(b[x]);
							offset++;
						}
					}
				}
			}
			return bytes;
		} catch (OutOfMemoryError ex) {
			System.gc();
			ex.printStackTrace();
			return null;
		}

	}

	private static String getMemoryStr(long address, int totalByte, boolean isPhysicalAddress) {
		int bytes[] = getMemory(address, totalByte, isPhysicalAddress);
		String str = "";
		for (int x = 0; x < bytes.length; x++) {
			str += (char) bytes[x];
		}
		return str;
	}

	private JButton getJGoLinearButton() {
		if (jGoLinearButton == null) {
			jGoLinearButton = new JButton();
			jGoLinearButton.setText("Lin");
			jGoLinearButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jGoLinearButtonActionPerformed(evt);
				}
			});
			jGoLinearButton.setToolTipText(MyLanguage.getString("Linear_address"));
		}
		return jGoLinearButton;
	}

	private void jGoLinearButtonActionPerformed(ActionEvent evt) {
		updateMemory(false);

		addMemoryAddressComboBox(jMemoryAddressComboBox.getSelectedItem().toString());
		Setting.getInstance().memoryCombo.add(jMemoryAddressComboBox.getSelectedItem().toString());
		Setting.getInstance().save();
	}

	private DiskPanel getDiskPanel() {
		if (diskPanel == null) {
			diskPanel = new DiskPanel();
			try {
				String line = CommonLib.findLineInFile(new File(bochsrc), "ata0-master");
				if (line != null) {
					String strs[] = line.split(",");
					for (String str : strs) {
						if (str.toLowerCase().contains("path=")) {
							String filename = str.split("=")[1];
							filename = filename.replaceAll("\"", "");
							diskPanel.setFile(new File(filename));
							break;
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return diskPanel;
	}

	private JMaximizableTabbedPane_BasePanel getJMaximizableTabbedPane_BasePanel1() {
		if (jMaximizableTabbedPane_BasePanel1 == null) {
			jMaximizableTabbedPane_BasePanel1 = new JMaximizableTabbedPane_BasePanel();
			jMaximizableTabbedPane_BasePanel1.add(getJSplitPane2(), "MAIN");
		}
		return jMaximizableTabbedPane_BasePanel1;
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

	private JPopupMenu getJInstructionPanelPopupMenu() {
		if (jInstructionPanelPopupMenu == null) {
			jInstructionPanelPopupMenu = new JPopupMenu();
			jInstructionPanelPopupMenu.add(getJMenuItem4x());
			jInstructionPanelPopupMenu.add(getJMenuItem5x());
		}
		return jInstructionPanelPopupMenu;
	}

	/**
	 * Auto-generated method for setting the popup menu for a component
	 */
	private void setComponentPopupMenu(final java.awt.Component parent, final javax.swing.JPopupMenu menu) {
		parent.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent e) {
				if (e.isPopupTrigger())
					menu.show(parent, e.getX(), e.getY());
			}

			public void mouseReleased(java.awt.event.MouseEvent e) {
				if (e.isPopupTrigger())
					menu.show(parent, e.getX(), e.getY());
			}
		});
	}

	private JMenuItem getJMenuItem4x() {
		if (jMenuItem4 == null) {
			jMenuItem4 = new JMenuItem();
			jMenuItem4.setText("Set physical breakpoint here");
			jMenuItem4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem4ActionPerformed(evt);
				}
			});
		}
		return jMenuItem4;
	}

	private JMenuItem getJMenuItem5x() {
		if (jMenuItem5 == null) {
			jMenuItem5 = new JMenuItem();
			jMenuItem5.setText("Set linear breakpoint here");
			jMenuItem5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem5ActionPerformed(evt);
				}
			});
		}
		return jMenuItem5;
	}

	private void jInstructionTableMouseClicked(MouseEvent evt) {
		if (SwingUtilities.isRightMouseButton(evt)) {
			// select
			Point p = evt.getPoint();
			int rowNumber = jInstructionTable.rowAtPoint(p);
			int columnNumber = jInstructionTable.columnAtPoint(p);
			ListSelectionModel model = jInstructionTable.getSelectionModel();
			model.setSelectionInterval(rowNumber, rowNumber);
			jInstructionTable.getColumnModel().getSelectionModel().setSelectionInterval(columnNumber, columnNumber);
			// end select

			getJInstructionPanelPopupMenu().show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}

	private void jMenuItem4ActionPerformed(ActionEvent evt) {
		Application.sendCommand("pb 0x" + this.jInstructionTable.getValueAt(this.jInstructionTable.getSelectedRow(), 1));
		this.updateBreakpoint();
	}

	private void jMenuItem5ActionPerformed(ActionEvent evt) {
		Application.sendCommand("lb 0x" + this.jInstructionTable.getValueAt(this.jInstructionTable.getSelectedRow(), 1));
		this.updateBreakpoint();
	}

	private void jBreakpointTableMouseClicked(MouseEvent evt) {
		if (SwingUtilities.isRightMouseButton(evt)) {
			// select
			Point p = evt.getPoint();
			int rowNumber = jBreakpointTable.rowAtPoint(p);
			int columnNumber = jBreakpointTable.columnAtPoint(p);
			ListSelectionModel model = jBreakpointTable.getSelectionModel();
			model.setSelectionInterval(rowNumber, rowNumber);
			jBreakpointTable.getColumnModel().getSelectionModel().setSelectionInterval(columnNumber, columnNumber);
			// end select

			getJBreakpointPopupMenu().show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}

	private JPopupMenu getJBreakpointPopupMenu() {
		if (jBreakpointPopupMenu == null) {
			jBreakpointPopupMenu = new JPopupMenu();
			jBreakpointPopupMenu.add(getJMenuItem6x());
			jBreakpointPopupMenu.add(getJMenuItem7x());
		}
		return jBreakpointPopupMenu;
	}

	private JMenuItem getJMenuItem6x() {
		if (jMenuItem6 == null) {
			jMenuItem6 = new JMenuItem();
			jMenuItem6.setText("Dump here");
			jMenuItem6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem6ActionPerformed(evt);
				}
			});
		}
		return jMenuItem6;
	}

	private JMenuItem getJMenuItem7x() {
		if (jMenuItem7 == null) {
			jMenuItem7 = new JMenuItem();
			jMenuItem7.setText(MyLanguage.getString("Disassemble"));
			jMenuItem7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem7ActionPerformed(evt);
				}
			});
		}
		return jMenuItem7;
	}

	private void jMenuItem6ActionPerformed(ActionEvent evt) {
		this.jMemoryAddressComboBox.setSelectedItem(this.jBreakpointTable.getValueAt(this.jBreakpointTable.getSelectedRow(), 2));
		if (this.jBreakpointTable.getValueAt(this.jBreakpointTable.getSelectedRow(), 0).toString().contains("lb")) {
			jGoLinearButtonActionPerformed(null);
		} else {
			jGOMemoryButtonActionPerformed(null);
		}
		jTabbedPane3.setSelectedIndex(0);
	}

	private void jMenuItem7ActionPerformed(ActionEvent evt) {
		this.jInstructionComboBox.setSelectedItem(this.jBreakpointTable.getValueAt(this.jBreakpointTable.getSelectedRow(), 2));
		jButton14ActionPerformed(null);
		jTabbedPane1.setSelectedIndex(0);
	}

	private void jSearchMemoryTableMouseClicked(MouseEvent evt) {
		if (SwingUtilities.isRightMouseButton(evt)) {
			// select
			Point p = evt.getPoint();
			int rowNumber = jSearchMemoryTable.rowAtPoint(p);
			int columnNumber = jSearchMemoryTable.columnAtPoint(p);
			ListSelectionModel model = jSearchMemoryTable.getSelectionModel();
			model.setSelectionInterval(rowNumber, rowNumber);
			jSearchMemoryTable.getColumnModel().getSelectionModel().setSelectionInterval(columnNumber, columnNumber);
			// end select

			getJSearchMemoryTablePopupMenu().show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}

	private JPopupMenu getJSearchMemoryTablePopupMenu() {
		if (jSearchMemoryTablePopupMenu == null) {
			jSearchMemoryTablePopupMenu = new JPopupMenu();
			jSearchMemoryTablePopupMenu.add(getJMenuItem8());
			jSearchMemoryTablePopupMenu.add(getJMenuItem9());
		}
		return jSearchMemoryTablePopupMenu;
	}

	private JMenuItem getJMenuItem8() {
		if (jMenuItem8 == null) {
			jMenuItem8 = new JMenuItem();
			jMenuItem8.setText("Set physical breakpoint here");
			jMenuItem8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem8ActionPerformed(evt);
				}
			});
		}
		return jMenuItem8;
	}

	private JMenuItem getJMenuItem9() {
		if (jMenuItem9 == null) {
			jMenuItem9 = new JMenuItem();
			jMenuItem9.setText("Set linear breakpoint here");
			jMenuItem9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItem9ActionPerformed(evt);
				}
			});
		}
		return jMenuItem9;
	}

	private void jMenuItem8ActionPerformed(ActionEvent evt) {
		System.out.println(this.jSearchMemoryTable.getValueAt(this.jSearchMemoryTable.getSelectedRow(), 0));
		Application.sendCommand("pb " + this.jSearchMemoryTable.getValueAt(this.jSearchMemoryTable.getSelectedRow(), 0));
		this.updateBreakpoint();
	}

	private void jMenuItem9ActionPerformed(ActionEvent evt) {
		Application.sendCommand("lb " + this.jSearchMemoryTable.getValueAt(this.jSearchMemoryTable.getSelectedRow(), 0));
		this.updateBreakpoint();
	}

	private JButton getJInstructionUpButton() {
		if (jInstructionUpButton == null) {
			jInstructionUpButton = new JButton();
			jInstructionUpButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/arrow_up1.png")));
			jInstructionUpButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jInstructionUpButtonActionPerformed(evt);
				}
			});
		}
		return jInstructionUpButton;
	}

	private JButton getJButton22() {
		if (jInstructionDownButton == null) {
			jInstructionDownButton = new JButton();
			jInstructionDownButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/arrow_down.png")));
			jInstructionDownButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jInstructionDownButtonActionPerformed(evt);
				}
			});
		}
		return jInstructionDownButton;
	}

	public JEditorPane getjBochsEditorPane() {
		return jBochsEditorPane;
	}

	private void jInstructionUpButtonActionPerformed(ActionEvent evt) {
		if (this.jInstructionTable.getRowCount() > 0) {
			String firstAddress = this.jInstructionTable.getValueAt(0, 1).toString().replaceAll("^-*", "");
			firstAddress = Long.toHexString(CommonLib.convertFilesize("0x" + firstAddress) - 1);

			this.jInstructionComboBox.setSelectedItem("0x" + firstAddress);
			this.updateInstruction(CommonLib.convertFilesize("0x" + firstAddress));
			this.updateBreakpointTableColor();
		}
	}

	private void jInstructionDownButtonActionPerformed(ActionEvent evt) {
		if (this.jInstructionTable.getRowCount() > 10) {
			String firstAddress = this.jInstructionTable.getValueAt(10, 1).toString().replaceAll("^-*", "");

			this.jInstructionComboBox.setSelectedItem("0x" + firstAddress);
			this.updateInstruction(CommonLib.convertFilesize("0x" + firstAddress));
			this.updateBreakpointTableColor();
		}
	}

	private JButton getJInstructionUpTenButton() {
		if (jInstructionUpTenButton == null) {
			jInstructionUpTenButton = new JButton();
			jInstructionUpTenButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/arrow_up10.png")));
			jInstructionUpTenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jInstructionUpTenButtonActionPerformed(evt);
				}
			});
		}
		return jInstructionUpTenButton;
	}

	private void jInstructionUpTenButtonActionPerformed(ActionEvent evt) {
		String firstAddress = this.jInstructionTable.getValueAt(0, 1).toString().replaceAll("^-*", "");
		firstAddress = Long.toHexString(CommonLib.convertFilesize("0x" + firstAddress) - 16);

		this.jInstructionComboBox.setSelectedItem("0x" + firstAddress);
		this.updateInstruction(CommonLib.convertFilesize("0x" + firstAddress));
		this.updateBreakpointTableColor();
	}

	private JMenuItem getJKRMenuItem() {
		if (jKRMenuItem == null) {
			jKRMenuItem = new JMenuItem();
			jKRMenuItem.setText("Korean");
			jKRMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jKRMenuItemActionPerformed(evt);
				}
			});
		}
		return jKRMenuItem;
	}

	private void jKRMenuItemActionPerformed(ActionEvent evt) {
		changeLanguage("KR");
	}

	private JMenuItem getJJPMenuItem() {
		if (jJPMenuItem == null) {
			jJPMenuItem = new JMenuItem();
			jJPMenuItem.setText("Japanese");
			jJPMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jJPMenuItemActionPerformed(evt);
				}
			});
		}
		return jJPMenuItem;
	}

	private void jJPMenuItemActionPerformed(ActionEvent evt) {
		changeLanguage("JP");
	}

	private void jIDTTableMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			for (int x = 0; x < jTabbedPane2.getTabCount(); x++) {
				if (jTabbedPane2.getTitleAt(x).equals(("IDT " + String.format("0x%02x", jGDTTable.getSelectedRow() + 1)))) {
					jTabbedPane2.setSelectedIndex(x);
					return;
				}
			}
			jTabbedPane2.addTabWithCloseButton("IDT " + String.format("0x%02x", jIDTTable.getSelectedRow() + 1), null,
					new IDTDescriptorPanel(this, CommonLib.hex2decimal(this.jRegisterPanel1.jIDTRTextField.getText()), jIDTTable.getSelectedRow() + 1), null);
			jTabbedPane2.setSelectedIndex(jTabbedPane2.getTabCount() - 1);
		}
	}

	private JButton getJFastStepBochsButton() {
		if (jFastStepBochsButton == null) {
			jFastStepBochsButton = new JButton();
			jFastStepBochsButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/step.png")));
			jFastStepBochsButton.setText(MyLanguage.getString("Fast_Step"));
			jFastStepBochsButton
					.setToolTipText("<html><body>A faster step<br><br>It will only update:<br>1) Memory panel<br>2) Insturction panel<br>3) Register panel</body></html>");
			jFastStepBochsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jFastStepButtonActionPerformed(evt);
				}
			});
		}
		return jFastStepBochsButton;
	}

	private void jFastStepButtonActionPerformed(ActionEvent evt) {
		try {
			sendCommand("s");
			Thread updateThread = new Thread() {
				public void run() {
					enableAllButtons(false);

					if (Setting.getInstance().updateFastStepCommand_register) {
						if (Global.debug) {
							System.out.println("updateRegister");
						}
						updateRegister();
					}

					if (Global.debug) {
						System.out.println("updateEFlag");
					}
					updateEFlag();

					if (Setting.getInstance().updateFastStepCommand_memory) {
						if (Global.debug) {
							System.out.println("updateMemory");
						}
						updateMemory(true);
					}

					if (Setting.getInstance().updateFastStepCommand_instruction) {
						if (Global.debug) {
							System.out.println("updateInstruction");
						}
						updateInstruction(null);
					}

					if (Setting.getInstance().updateFastStepCommand_breakpoint) {
						if (Global.debug) {
							System.out.println("updateBreakpointTableColor");
						}
						updateBreakpoint();
						updateBreakpointTableColor();
					}

					jStatusLabel.setText("");

					enableAllButtons(true);
				}
			};
			updateThread.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private JPopupMenu getJELFTablePopupMenu() {
		if (jELFTablePopupMenu == null) {
			jELFTablePopupMenu = new JPopupMenu();
			jELFTablePopupMenu.add(getJMenuItem1x());
			jELFTablePopupMenu.add(getJMenuItem2x());
		}
		return jELFTablePopupMenu;
	}

	private JMenuItem getJMenuItem1x() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("Set linear breakpoint here");
			jMenuItem1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jELFLinearBreakpointMenuItemActionPerformed(evt);
				}
			});
		}
		return jMenuItem1;
	}

	private JMenuItem getJMenuItem2x() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText("Set physical breakpoint here");
			jMenuItem2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jELFPhysicalBreakpointMenuItemActionPerformed(evt);
				}
			});
		}
		return jMenuItem2;
	}

	private void jELFLinearBreakpointMenuItemActionPerformed(ActionEvent evt) {
		JSourceCodeTableModel model = (JSourceCodeTableModel) jELFTable.getModel();
		Long address = model.getDebugLineInfo().get(model.getCurrentFile()).get(this.jELFTable.getSelectedRow());
		if (address != null) {
			sendCommand("lb 0x" + Long.toHexString(address));

			model.updateBreakpoint(getRealEIP());
			this.updateBreakpoint();
		}
	}

	private void jELFPhysicalBreakpointMenuItemActionPerformed(ActionEvent evt) {
		JSourceCodeTableModel model = (JSourceCodeTableModel) jELFTable.getModel();
		Long address = model.getDebugLineInfo().get(model.getCurrentFile()).get(this.jELFTable.getSelectedRow());
		if (address != null) {
			sendCommand("pb 0x" + Long.toHexString(address));

			model.updateBreakpoint(getRealEIP());
			this.updateBreakpoint();
		}
	}

	private JButton getJSettingButton() {
		if (jSettingButton == null) {
			jSettingButton = new JButton();
			jSettingButton.setText(MyLanguage.getString("Setting"));
			jSettingButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/wrench.png")));
			jSettingButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSettingButtonActionPerformed(evt);
				}
			});
		}
		return jSettingButton;
	}

	private void jSettingButtonActionPerformed(ActionEvent evt) {
		JSettingDialog jSettingDialog = new JSettingDialog(this);
		CommonLib.centerDialog(jSettingDialog);
		jSettingDialog.setVisible(true);
	}

	private JPanel getObjdump() {
		if (objdumpPanel == null) {
			objdumpPanel = new JPanel();
			BorderLayout ObjdumpLayout = new BorderLayout();
			objdumpPanel.setLayout(ObjdumpLayout);
			objdumpPanel.add(getJPanel27(), BorderLayout.NORTH);
			objdumpPanel.add(getJScrollPane17(), BorderLayout.CENTER);
		}
		return objdumpPanel;
	}

	private JToolBar getJPanel27() {
		if (jPanel27 == null) {
			jPanel27 = new JToolBar();
			FlowLayout jPanel27Layout = new FlowLayout();
			jPanel27Layout.setAlignment(FlowLayout.LEFT);
			jPanel27.add(getJTextField1x());
			jPanel27.add(getJSearchObjdumpButton());
		}
		return jPanel27;
	}

	private JTextField getJTextField1x() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setMaximumSize(new java.awt.Dimension(100, 25));
			jTextField1.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextField1KeyTyped(evt);
				}
			});
		}
		return jTextField1;
	}

	private void jTextField1KeyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == '\n') {
			jSearchObjdumpButtonActionPerformed(null);
		}
	}

	private JButton getJSearchObjdumpButton() {
		if (jSearchObjdumpButton == null) {
			jSearchObjdumpButton = new JButton();
			jSearchObjdumpButton.setText("Search");
			jSearchObjdumpButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSearchObjdumpButtonActionPerformed(evt);
				}
			});
		}
		return jSearchObjdumpButton;
	}

	final Highlighter hilit = new DefaultHighlighter();
	final Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.BLUE);

	private void jSearchObjdumpButtonActionPerformed(ActionEvent evt) {
		if (jTextField1.getText().length() > 0) {
			Highlighter h = jEditorPane1.getHighlighter();
			h.removeAllHighlights();
			String text = jEditorPane1.getText().toLowerCase();

			int nextPosition = -1;

			for (int j = 0; j < text.length() - jTextField1.getText().length() + 1; j += 1) {
				if (text.substring(j, j + jTextField1.getText().length()).equals(jTextField1.getText().toLowerCase())) {
					try {
						if (j >= jEditorPane1.getCaretPosition() && nextPosition == -1) {
							h.addHighlight(j, j + jTextField1.getText().length(), new DefaultHighlighter.DefaultHighlightPainter(Color.red));
							nextPosition = j + jTextField1.getText().length();
						} else {
							h.addHighlight(j, j + jTextField1.getText().length(), new DefaultHighlighter.DefaultHighlightPainter(Color.yellow));
						}
					} catch (BadLocationException ble) {
					}
				}
			}
			if (nextPosition != -1) {
				jEditorPane1.setCaretPosition(nextPosition);
			} else {
				jEditorPane1.setCaretPosition(0);
			}
		}
	}

	private JEditorPane getJEditorPane1() {
		if (jEditorPane1 == null) {
			jEditorPane1 = new JEditorPane();
		}
		return jEditorPane1;
	}

	private JScrollPane getJScrollPane17() {
		if (jScrollPane17 == null) {
			jScrollPane17 = new JScrollPane();
			jScrollPane17.setPreferredSize(new java.awt.Dimension(997, 512));
			jScrollPane17.setViewportView(getJEditorPane1());
		}
		return jScrollPane17;
	}

	private JPanel getJPanel28() {
		if (jPanel28 == null) {
			jPanel28 = new JPanel();
			BorderLayout jPanel28Layout = new BorderLayout();
			jPanel28.setLayout(jPanel28Layout);
			jPanel28.add(getJScrollPane18(), BorderLayout.CENTER);
			jPanel28.add(getJToolBar4(), BorderLayout.NORTH);
		}
		return jPanel28;
	}

	private JScrollPane getJScrollPane18() {
		if (jScrollPane18 == null) {
			jScrollPane18 = new JScrollPane();
			jScrollPane18.setPreferredSize(new java.awt.Dimension(993, 533));
			jScrollPane18.setViewportView(getJEditorPane2());
		}
		return jScrollPane18;
	}

	private JEditorPane getJEditorPane2() {
		if (jSearchRelPltEditorPane == null) {
			jSearchRelPltEditorPane = new JEditorPane();
		}
		return jSearchRelPltEditorPane;
	}

	private JToolBar getJToolBar4() {
		if (jToolBar4 == null) {
			jToolBar4 = new JToolBar();
			jToolBar4.add(getJTextField2());
			jToolBar4.add(getJButton16xx());
		}
		return jToolBar4;
	}

	private JTextField getJTextField2() {
		if (jSearchRelPltTextField == null) {
			jSearchRelPltTextField = new JTextField();
			jSearchRelPltTextField.setMaximumSize(new java.awt.Dimension(100, 25));
			jSearchRelPltTextField.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextField2KeyTyped(evt);
				}
			});
		}
		return jSearchRelPltTextField;
	}

	private JButton getJButton16xx() {
		if (jSearchRelPltButton == null) {
			jSearchRelPltButton = new JButton();
			jSearchRelPltButton.setText("Search");
			jSearchRelPltButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSearchRelPltButtonActionPerformed(evt);
				}
			});
		}
		return jSearchRelPltButton;
	}

	private void jSearchRelPltButtonActionPerformed(ActionEvent evt) {
		if (jSearchRelPltTextField.getText().length() > 0) {
			Highlighter h = jSearchRelPltEditorPane.getHighlighter();
			h.removeAllHighlights();
			String text = jSearchRelPltEditorPane.getText().toLowerCase();

			int nextPosition = -1;

			for (int j = 0; j < text.length() - jSearchRelPltTextField.getText().length() + 1; j += 1) {
				if (text.substring(j, j + jSearchRelPltTextField.getText().length()).equals(jSearchRelPltTextField.getText().toLowerCase())) {
					try {
						if (j >= jSearchRelPltEditorPane.getCaretPosition() && nextPosition == -1) {
							h.addHighlight(j, j + jSearchRelPltTextField.getText().length(), new DefaultHighlighter.DefaultHighlightPainter(Color.red));
							nextPosition = j + jSearchRelPltTextField.getText().length();
						} else {
							h.addHighlight(j, j + jSearchRelPltTextField.getText().length(), new DefaultHighlighter.DefaultHighlightPainter(Color.yellow));
						}
					} catch (BadLocationException ble) {
					}
				}
			}
			if (nextPosition != -1) {
				jSearchRelPltEditorPane.setCaretPosition(nextPosition);
			} else {
				jSearchRelPltEditorPane.setCaretPosition(0);
			}
		}
	}

	private JPanel getJPanel29() {
		if (jPanel29 == null) {
			jPanel29 = new JPanel();
			BorderLayout jPanel29Layout = new BorderLayout();
			jPanel29.setLayout(jPanel29Layout);
			jPanel29.add(getJToolBar5(), BorderLayout.NORTH);
			jPanel29.add(getJScrollPane19(), BorderLayout.CENTER);
			jPanel29.add(getJEditorPane3());
		}
		return jPanel29;
	}

	private JToolBar getJToolBar5() {
		if (jToolBar5 == null) {
			jToolBar5 = new JToolBar();
			jToolBar5.add(getJTextField3());
			jToolBar5.add(getJButton22x());
		}
		return jToolBar5;
	}

	private JTextField getJTextField3() {
		if (jSearchDynamicTextField == null) {
			jSearchDynamicTextField = new JTextField();
			jSearchDynamicTextField.setMaximumSize(new java.awt.Dimension(100, 25));
			jSearchDynamicTextField.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextField3KeyTyped(evt);
				}
			});
		}
		return jSearchDynamicTextField;
	}

	private JButton getJButton22x() {
		if (jSearchDynamicButton == null) {
			jSearchDynamicButton = new JButton();
			jSearchDynamicButton.setText("Search");
			jSearchDynamicButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jSearchDynamicButtonActionPerformed(evt);
				}
			});
		}
		return jSearchDynamicButton;
	}

	private void jSearchDynamicButtonActionPerformed(ActionEvent evt) {
		if (jSearchDynamicTextField.getText().length() > 0) {
			Highlighter h = jSearchDynamicEditorPane.getHighlighter();
			h.removeAllHighlights();
			String text = jSearchDynamicEditorPane.getText().toLowerCase();

			int nextPosition = -1;

			for (int j = 0; j < text.length() - jSearchDynamicTextField.getText().length() + 1; j += 1) {
				if (text.substring(j, j + jSearchDynamicTextField.getText().length()).equals(jSearchDynamicTextField.getText().toLowerCase())) {
					try {
						if (j >= jSearchDynamicEditorPane.getCaretPosition() && nextPosition == -1) {
							h.addHighlight(j, j + jSearchDynamicTextField.getText().length(), new DefaultHighlighter.DefaultHighlightPainter(Color.red));
							nextPosition = j + jSearchDynamicTextField.getText().length();
						} else {
							h.addHighlight(j, j + jSearchDynamicTextField.getText().length(), new DefaultHighlighter.DefaultHighlightPainter(Color.yellow));
						}
					} catch (BadLocationException ble) {
					}
				}
			}
			if (nextPosition != -1) {
				jSearchDynamicEditorPane.setCaretPosition(nextPosition);
			} else {
				jSearchDynamicEditorPane.setCaretPosition(0);
			}
		}
	}

	private JScrollPane getJScrollPane19() {
		if (jScrollPane19 == null) {
			jScrollPane19 = new JScrollPane();
			jScrollPane19.setPreferredSize(new java.awt.Dimension(993, 533));
		}
		return jScrollPane19;
	}

	private JEditorPane getJEditorPane3() {
		if (jSearchDynamicEditorPane == null) {
			jSearchDynamicEditorPane = new JEditorPane();
		}
		return jSearchDynamicEditorPane;
	}

	private void jTextField2KeyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == '\n') {
			jSearchRelPltButtonActionPerformed(null);
		}
	}

	private void jTextField3KeyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == '\n') {
			jSearchDynamicButtonActionPerformed(null);
		}
	}

	private JPanel getJOSDebugStandardPanel() {
		if (jOSDebugStandardPanel == null) {
			jOSDebugStandardPanel = new JPanel();
			CardLayout jOSDebugStandardPanelLayout = new CardLayout();
			jOSDebugStandardPanel.setLayout(jOSDebugStandardPanelLayout);
			jOSDebugStandardPanel.add(getJOSDebugInfoErrorLabel(), "OS debug error label");
			jOSDebugStandardPanel.add(getJOSDebugInformationPanel1(), "jOSDebugInformationPanel1");
		}
		return jOSDebugStandardPanel;
	}

	private JTabbedPane getJTabbedPane5() {
		if (jTabbedPane5 == null) {
			jTabbedPane5 = new JTabbedPane();
		}
		return jTabbedPane5;
	}

	private JLabel getJOSDebugInfoErrorLabel() {
		if (jOSDebugInfoErrorLabel == null) {
			jOSDebugInfoErrorLabel = new JLabel();
			if (Global.osDebug == -1) {
				jOSDebugInfoErrorLabel.setText("Parameter -osdebug is not specified.");
			} else {
				jOSDebugInfoErrorLabel.setText("OS debug information not found - wrong magic bytes.");
			}
			jOSDebugInfoErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
			jOSDebugInfoErrorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			jOSDebugInfoErrorLabel.setFont(new java.awt.Font("Arial", 0, 20));
			jOSDebugInfoErrorLabel.setForeground(Color.white);
			jOSDebugInfoErrorLabel.setBackground(new Color(0, 0, 0, 180));
			jOSDebugInfoErrorLabel.setOpaque(true);
		}
		return jOSDebugInfoErrorLabel;
	}

	private JOSDebugInformationPanel getJOSDebugInformationPanel1() {
		if (jOSDebugInformationPanel1 == null) {
			jOSDebugInformationPanel1 = new JOSDebugInformationPanel();
		}
		return jOSDebugInformationPanel1;
	}

	private InstrumentPanel getJInstrumentPanel() {
		if (jInstrumentPanel == null) {
			jInstrumentPanel = new InstrumentPanel();
		}
		return jInstrumentPanel;
	}

	private JToggleButton getJProfilerToggleButton() {
		if (jProfilerToggleButton == null) {
			jProfilerToggleButton = new JToggleButton();
			jProfilerToggleButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/chart_organisation.png")));
			jProfilerToggleButton.setText("Profile & Sampling");
			buttonGroup2.add(jProfilerToggleButton);
			jProfilerToggleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jProfilerToggleButtonActionPerformed(evt);
				}
			});
		}
		return jProfilerToggleButton;
	}

	private void jProfilerToggleButtonActionPerformed(ActionEvent evt) {
		CardLayout cl = (CardLayout) (jMainPanel.getLayout());
		if (jProfilerToggleButton.isSelected()) {
			cl.show(jMainPanel, "jInstrumentPanel");
			currentPanel = "jInstrumentPanel";
		} else {
			cl.show(jMainPanel, "jMaximizableTabbedPane_BasePanel1");
			currentPanel = "jMaximizableTabbedPane_BasePanel1";
		}
	}

	private JToggleButton getJLogToggleButton() {
		if (jLogToggleButton == null) {
			jLogToggleButton = new JToggleButton();
			jLogToggleButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/script.png")));
			jLogToggleButton.setText("Log");
			buttonGroup2.add(jLogToggleButton);
			jLogToggleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jLogToggleButtonActionPerformed(evt);
				}
			});
		}
		return jLogToggleButton;
	}

	private void jLogToggleButtonActionPerformed(ActionEvent evt) {
		CardLayout cl = (CardLayout) (jMainPanel.getLayout());
		if (jLogToggleButton.isSelected()) {
			cl.show(jMainPanel, "logPanel1");
			currentPanel = "logPanel1";
		} else {
			cl.show(jMainPanel, "jMaximizableTabbedPane_BasePanel1");
			currentPanel = "jMaximizableTabbedPane_BasePanel1";
		}
	}

	private LogPanel getLogPanel1() {
		if (logPanel1 == null) {
			logPanel1 = new LogPanel();
		}
		return logPanel1;
	}

	private JToggleButton getJRegisterToggleButton() {
		if (jRegisterToggleButton == null) {
			jRegisterToggleButton = new JToggleButton();
			jRegisterToggleButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/chart_bar.png")));
			buttonGroup2.add(jRegisterToggleButton);
			jRegisterToggleButton.setSelected(true);
			jRegisterToggleButton.setText("Reg");
			jRegisterToggleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRegisterToggleButtonActionPerformed(evt);
				}
			});
		}
		return jRegisterToggleButton;
	}

	private void jRegisterToggleButtonActionPerformed(ActionEvent evt) {
		final CardLayout cl = (CardLayout) (jMainPanel.getLayout());
		if (jProfilerToggleButton.isSelected()) {
			cl.show(jMainPanel, "jInstrumentPanel");
			currentPanel = "jInstrumentPanel";
		} else {
			cl.show(jMainPanel, "jMaximizableTabbedPane_BasePanel1");
			currentPanel = "jMaximizableTabbedPane_BasePanel1";
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					if (jRunBochsButton.getText().equals(MyLanguage.getString("Pause_bochs"))) {
						cl.show(jMainPanel, "Running Label");
					}
				}
			});
		}
	}

}
