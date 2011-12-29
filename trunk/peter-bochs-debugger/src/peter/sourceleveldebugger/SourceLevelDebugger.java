package peter.sourceleveldebugger;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.apache.commons.io.FileUtils;

import peter.Application;
import peter.Global;
import peter.JInstructionTableCellRenderer;
import peter.MyLanguage;
import peter.PeterBochsCommonLib;
import peter.Setting;

import com.petersoft.CommonLib;
import com.petersoft.advancedswing.enhancedtextarea.EnhancedTextArea;
import com.petersoft.advancedswing.jmaximizabletabbedpane.JMaximizableTabbedPane;
import com.petersoft.advancedswing.jprogressbardialog.JProgressBarDialog;
import com.petersoft.advancedswing.pager.PagerEvent;
import com.petersoft.advancedswing.pager.PagerEventListener;
import com.petersoft.advancedswing.searchtextfield.JSearchTextField;

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
public class SourceLevelDebugger extends JPanel {
	private JPanel jAssemblyPanel;
	private JPanel jStringPanel;
	private JButton jExpandAllButton;
	private JMenuItem jShowMeTheCodeMenuItem;
	private JPopupMenu jCppPopupMenu;
	private JButton jReloadCacheFileButton;
	private JToolBar jPanel7;
	private EnhancedTextArea cSourceTextArea;
	private JTree jFileTree;
	private JScrollPane jScrollPane4;
	private JPanel jPanel2;
	private JTabbedPane jTabbedPane2;
	private JTabbedPane jTabbedPane1;
	private JSplitPane jSplitPane1;
	private JButton jButton12;
	private JButton jButton3;
	private JButton jInstructionDownButton;
	private JButton jInstructionUpButton;
	private JButton jInstructionUpTenButton;
	private JButton jDisassembleButton;
	private JButton jButton14;
	private JComboBox jInstructionComboBox;
	private JPanel jInstructionControlPanel;
	private JSearchTextField jSearchMapTextField;
	private JPanel jPanel6;
	private JPanel jPanel5;
	private MemoryMap memoryMap;
	private JPanel jPanel4;
	public JTabbedPane jMapTabbedPane;
	private JTable jLibraryTable;
	private JButton jCollapseButton;
	private JScrollPane jScrollPane3;
	public EnhancedTextArea jMapTextArea;
	private JPanel jBreakpointPanel;
	private JButton jLoadMapButton;
	private JPanel jPanel1;
	private JPanel jMapPanel;
	public JTable jAssemblyTable;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JTable jMapDataTable;
	private MapDataTableModel mapDataTableModel = new MapDataTableModel();
	private JPanel jPanel3;
	private JPanel jLibraryPanel;
	private JPanel jCPanel;
	public JMaximizableTabbedPane jMainTabbedPane;
	Application application;

	public SourceLevelDebugger(Application application) {
		this.application = application;
		initGUI();
	}

	private void initGUI() {
		try {
			{
				BorderLayout thisLayout = new BorderLayout();
				this.setLayout(thisLayout);
				this.setPreferredSize(new java.awt.Dimension(812, 470));
				{
					jMainTabbedPane = new JMaximizableTabbedPane();
					this.add(jMainTabbedPane);
					jMainTabbedPane.setTabPlacement(JTabbedPane.LEFT);
					{
						jAssemblyPanel = new JPanel();
						BorderLayout jAssemblyPanelLayout = new BorderLayout();
						jAssemblyPanel.setLayout(jAssemblyPanelLayout);
						jMainTabbedPane.addTab("Asm", null, jAssemblyPanel, null);
						{
							jScrollPane1 = new JScrollPane();
							jAssemblyPanel.add(jScrollPane1, BorderLayout.CENTER);
							{
								jAssemblyTable = new JTable();
								jScrollPane1.setViewportView(jAssemblyTable);
								jAssemblyTable.setModel(Application.jInstructionTable.getModel());
								jAssemblyTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
								jAssemblyTable.getTableHeader().setReorderingAllowed(false);
								jAssemblyTable.getColumnModel().getColumn(0).setMaxWidth(20);
								jAssemblyTable.getColumnModel().getColumn(1).setPreferredWidth(40);
								jAssemblyTable.getColumnModel().getColumn(2).setPreferredWidth(200);
								jAssemblyTable.getColumnModel().getColumn(3).setPreferredWidth(40);
								jAssemblyTable.setDefaultRenderer(String.class, new JInstructionTableCellRenderer());
								jAssemblyTable.addMouseListener(new MouseAdapter() {
									public void mouseClicked(MouseEvent evt) {
										jAssemblyTableMouseClicked(evt);
									}
								});
							}
						}
						{
							jInstructionControlPanel = new JPanel();
							jAssemblyPanel.add(jInstructionControlPanel, BorderLayout.NORTH);
							{
								jInstructionComboBox = new JComboBox();
								jInstructionControlPanel.add(jInstructionComboBox);
								jInstructionComboBox.setEditable(true);
								jInstructionComboBox.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jInstructionComboBoxActionPerformed(evt);
									}
								});
							}
							{
								jButton14 = new JButton();
								jInstructionControlPanel.add(jButton14);
								jButton14.setText(MyLanguage.getString("Disassemble"));
								jButton14.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jButton14ActionPerformed(evt);
									}
								});
							}
							{
								jDisassembleButton = new JButton();
								jInstructionControlPanel.add(jDisassembleButton);
								jDisassembleButton.setText(MyLanguage.getString("Disassemble") + " cs:eip");
								jDisassembleButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jDisassembleButtonActionPerformed(evt);
									}
								});
								jDisassembleButton.setEnabled(true);
							}
							{
								jInstructionUpTenButton = new JButton();
								jInstructionControlPanel.add(jInstructionUpTenButton);
								jInstructionUpTenButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/arrow_up10.png")));
								jInstructionUpTenButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jInstructionUpTenButtonActionPerformed(evt);
									}
								});
							}
							{
								jInstructionUpButton = new JButton();
								jInstructionControlPanel.add(jInstructionUpButton);
								jInstructionUpButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/arrow_up1.png")));
								jInstructionUpButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jInstructionUpButtonActionPerformed(evt);
									}
								});
							}
							{
								jInstructionDownButton = new JButton();
								jInstructionControlPanel.add(jInstructionDownButton);
								jInstructionDownButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/arrow_down.png")));
								jInstructionDownButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jInstructionDownButtonActionPerformed(evt);
									}
								});
							}
							{
								jButton3 = new JButton();
								jInstructionControlPanel.add(jButton3);
								jButton3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/disk.png")));
								jButton3.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jButton3ActionPerformed(evt);
									}
								});
							}
							{
								jButton12 = new JButton();
								jInstructionControlPanel.add(jButton12);
								jButton12.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/excel.gif")));
								jButton12.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jButton12ActionPerformed(evt);
									}
								});
							}
						}
					}
					{
						jMapPanel = new JPanel();
						jMainTabbedPane.addTab("Map", null, jMapPanel, null);
						BorderLayout jMapPanelLayout = new BorderLayout();
						jMapPanel.setLayout(jMapPanelLayout);
						{
							jPanel1 = new JPanel();
							FlowLayout jPanel1Layout = new FlowLayout();
							jPanel1Layout.setAlignment(FlowLayout.LEFT);
							jPanel1.setLayout(jPanel1Layout);
							jMapPanel.add(jPanel1, BorderLayout.NORTH);
							{
								jLoadMapButton = new JButton();
								jPanel1.add(jLoadMapButton);
								jLoadMapButton.setText("Load map");
								jLoadMapButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jLoadMapButtonActionPerformed(evt);
									}
								});
							}
						}
						{
							jMapTabbedPane = new JTabbedPane();
							jMapPanel.add(jMapTabbedPane, BorderLayout.CENTER);
							jMapTabbedPane.setPreferredSize(new java.awt.Dimension(594, 408));
							jMapTabbedPane.setTabPlacement(JTabbedPane.LEFT);
							{
								jMapTextArea = new EnhancedTextArea();
								jMapTabbedPane.addTab("Raw", null, jMapTextArea, null);
								jMapTextArea.getTextArea().setFont(new java.awt.Font("DialogInput", 0, 12));
							}
							{
								jPanel3 = new JPanel();
								jMapTabbedPane.addTab("Map", null, jPanel3, null);
								BorderLayout jPanel3Layout = new BorderLayout();
								jPanel3.setLayout(jPanel3Layout);
								{
									jPanel5 = new JPanel();
									BorderLayout jPanel5Layout = new BorderLayout();
									jPanel5.setLayout(jPanel5Layout);
									jPanel3.add(jPanel5, BorderLayout.CENTER);
									jPanel5.setPreferredSize(new java.awt.Dimension(549, 372));
									{
										jScrollPane2 = new JScrollPane();
										jPanel5.add(jScrollPane2, BorderLayout.CENTER);
										{
											jMapDataTable = new JTable();
											jScrollPane2.setViewportView(jMapDataTable);
											jMapDataTable.setModel(mapDataTableModel);
											jMapDataTable.setDefaultRenderer(String.class, new MapDataTableCellRenderer());
											jMapDataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
											jMapDataTable.getTableHeader().setReorderingAllowed(false);
											jMapDataTable.getColumnModel().getColumn(0).setPreferredWidth(260);
											jMapDataTable.getColumnModel().getColumn(1).setPreferredWidth(160);
											jMapDataTable.getColumnModel().getColumn(2).setPreferredWidth(180);
											jMapDataTable.getColumnModel().getColumn(3).setPreferredWidth(80);
											jMapDataTable.getColumnModel().getColumn(4).setPreferredWidth(460);
											jMapDataTable.addMouseListener(new MouseAdapter() {
												public void mouseClicked(MouseEvent evt) {
													jMapDataTableMouseClicked(evt);
												}
											});
										}
									}
									{
										jPanel6 = new JPanel();
										FlowLayout jPanel6Layout = new FlowLayout();
										jPanel6Layout.setAlignment(FlowLayout.LEFT);
										jPanel6.setLayout(jPanel6Layout);
										jPanel5.add(jPanel6, BorderLayout.NORTH);
										{
											jSearchMapTextField = new JSearchTextField();
											jPanel6.add(jSearchMapTextField);
											jSearchMapTextField.setPreferredSize(new java.awt.Dimension(152, 25));
											jSearchMapTextField.addKeyListener(new KeyAdapter() {
												public void keyReleased(KeyEvent evt) {
													jSearchMapTextFieldKeyReleased(evt);
												}
											});
										}
									}
								}
								{
									jPanel4 = new JPanel();
									BorderLayout jPanel4Layout = new BorderLayout();
									jPanel4.setLayout(jPanel4Layout);
									jPanel3.add(jPanel4, BorderLayout.NORTH);
									{
										memoryMap = new MemoryMap();
										jPanel4.add(memoryMap, BorderLayout.CENTER);
										memoryMap.setPreferredSize(new java.awt.Dimension(549, 31));
									}
								}
							}
						}
					}
					{
						jCPanel = new JPanel();
						jMainTabbedPane.addTab("C/C++", null, jCPanel, null);
						BorderLayout jCPanelLayout = new BorderLayout();
						jCPanel.setLayout(jCPanelLayout);
						{
							jSplitPane1 = new JSplitPane();
							jCPanel.add(jSplitPane1, BorderLayout.CENTER);
							jSplitPane1.setDividerLocation(250);
							{
								jTabbedPane1 = new JTabbedPane();
								jSplitPane1.add(jTabbedPane1, JSplitPane.LEFT);
								{
									jPanel2 = new JPanel();
									BorderLayout jPanel2Layout = new BorderLayout();
									jPanel2.setLayout(jPanel2Layout);
									jTabbedPane1.addTab("File", null, jPanel2, null);
									{
										jScrollPane4 = new JScrollPane();
										jPanel2.add(jScrollPane4, BorderLayout.CENTER);
										{
											jFileTree = new JTree();
											jScrollPane4.setViewportView(jFileTree);
											jFileTree.setModel(new ObjectFileTreeModel(null));
											jFileTree.setShowsRootHandles(true);
											jFileTree.setCellRenderer(new ObjectFileTreeRenderer());
											jFileTree.addMouseListener(new MouseAdapter() {
												public void mouseClicked(MouseEvent evt) {
													jFileTreeMouseClicked(evt);
												}
											});
										}
									}
									{
										jPanel7 = new JToolBar();
										FlowLayout jPanel7Layout = new FlowLayout();
										jPanel7Layout.setAlignment(FlowLayout.LEFT);
										jPanel2.add(jPanel7, BorderLayout.NORTH);
										{
											jReloadCacheFileButton = new JButton();
											jPanel7.add(jReloadCacheFileButton);
											jPanel7.add(getJExpandAllButton());
											jPanel7.add(getJCollapseButton());
											jReloadCacheFileButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/arrow_refresh.png")));
											jReloadCacheFileButton.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent evt) {
													jReloadCacheFileButtonActionPerformed(evt);
												}
											});
										}
									}
								}
							}
							{
								jTabbedPane2 = new JTabbedPane();
								BorderLayout jTabbedPane2Layout = new BorderLayout();
								jTabbedPane2.setLayout(jTabbedPane2Layout);
								jSplitPane1.add(jTabbedPane2, JSplitPane.RIGHT);
								{
									cSourceTextArea = new EnhancedTextArea();
									cSourceTextArea.pager.addPagerEventListener(new PagerEventListener() {
										public void clicked(PagerEvent evt) {
											pagerClicked(evt);
										}
									});
									jTabbedPane2.addTab("Center", null, cSourceTextArea, null);
								}
							}
						}
					}
					{
						jBreakpointPanel = new JPanel();
						jMainTabbedPane.addTab("Breakpoint", null, jBreakpointPanel, null);
					}
					{
						jLibraryPanel = new JPanel();
						BorderLayout jLibraryPanelLayout = new BorderLayout();
						jLibraryPanel.setLayout(jLibraryPanelLayout);
						jMainTabbedPane.addTab("Library / Object", null, jLibraryPanel, null);
						{
							jScrollPane3 = new JScrollPane();
							jLibraryPanel.add(jScrollPane3, BorderLayout.CENTER);
							{
								jLibraryTable = new JTable();
								jLibraryTable.setModel(new LibraryTableModel());
								jScrollPane3.setViewportView(jLibraryTable);
								jLibraryTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
								jLibraryTable.getColumnModel().getColumn(0).setPreferredWidth(120);
								jLibraryTable.getColumnModel().getColumn(1).setPreferredWidth(100);
								jLibraryTable.getColumnModel().getColumn(2).setPreferredWidth(400);
								jLibraryTable.setDefaultRenderer(String.class, new LibraryTableCellRenderer());
								jLibraryTable.addMouseListener(new MouseAdapter() {
									public void mouseClicked(MouseEvent evt) {
										jLibraryTableMouseClicked(evt);
									}
								});
							}
						}
					}
					{
						jStringPanel = new JPanel();
						BorderLayout jStringPanelLayout = new BorderLayout();
						jStringPanel.setLayout(jStringPanelLayout);
						jMainTabbedPane.addTab("String", null, jStringPanel, null);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadSystemMap(File file) {
		try {
			jMapTextArea.setText(FileUtils.readFileToString(file));
			jMapTextArea.jTextArea.setCaretPosition(0);

			Pattern p = Pattern.compile("[0-9a-zA-Z/\\.-]+\\.[oa]");
			Matcher myMatcher = p.matcher(jMapTextArea.getText());
			LibraryTableModel model = (LibraryTableModel) jLibraryTable.getModel();
			model.data.clear();
			while (myMatcher.find()) {
				File f = new File(myMatcher.group());
				if (f.exists()) {
					model.data.add(f);
				}
			}
			model.fireTableDataChanged();

			// load "Archive member included because of file"
			ObjectFileTreeNode root = new ObjectFileTreeNode(file.getName());
			ObjectFileTreeNode archiveNode = new ObjectFileTreeNode("Archive member");
			root.children.add(archiveNode);

			try {
				String line;
				BufferedReader br = new BufferedReader(new FileReader(file));
				boolean start = false;
				HashSet<File> hs = new HashSet<File>();
				while ((line = br.readLine()) != null) {
					if (line.toLowerCase().contains("Allocating common symbols".toLowerCase())) {
						break;
					}
					if (start) {
						Matcher matcher = Pattern.compile("^[^ \t].*").matcher(line);
						if (matcher.matches()) {
							hs.add(new File(line.replaceAll("\\(.*", "")));
						}
					} else if (line.toLowerCase().contains("Archive member included because of file".toLowerCase())) {
						start = true;
					}
				}
				Iterator<File> it = hs.iterator();
				while (it.hasNext()) {
					File f = it.next();
					archiveNode.children.add(new ObjectFileTreeNode(f));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			((ObjectFileTreeModel) jFileTree.getModel()).setRoot(root);
			jFileTree.updateUI();
			// end "Archive member included because of file"

			initMemoryMap();

			application.jShowInSourceCodeMenuItem.setEnabled(true);
			application.jWhereIsHereMenuItem.setEnabled(true);
			application.jSourceLevelDebuggerButtonActionPerformed(null);
			jMainTabbedPane.setSelectedIndex(1);
			com.petersoft.CommonLib.expandAll(jFileTree, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jLoadMapButtonActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser(new File("."));
		fc.setFileFilter(new FileFilter() {
			public boolean accept(File f) {
				String fileName = f.getName().toLowerCase();
				return fileName.endsWith(".map") || f.isDirectory();
			}

			public String getDescription() {
				return "Map";
			}
		});

		fc.setCurrentDirectory(new File(Setting.getInstance().getLastMapOpenDir()));
		int returnVal = fc.showOpenDialog(this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();

			// save history
			Setting.getInstance().setLastMapOpenDir(file.getParentFile().getAbsolutePath());
			Setting.getInstance().save();
			// end save history

			loadSystemMap(file);
		}
	}

	private void initMemoryMap() {
		String str = jMapTextArea.getText();
		str = str.replaceFirst("(?s).*Linker script and memory map", "Linker script and memory map");

		String lines[] = str.split("\n");
		boolean captureStart = false;
		String objectName = null;

		mapDataTableModel.objects.clear();
		mapDataTableModel.segments.clear();
		mapDataTableModel.locations.clear();
		mapDataTableModel.lengths.clear();
		mapDataTableModel.attributes.clear();
		String lastSegment = "";

		for (int x = 0; x < lines.length; x++) {
			String line = lines[x];

			String t[] = line.split("  +");

			if (t.length == 1) {
				if (t[0].contains("(*)")) {
					if (!captureStart) {
						captureStart = true;
						objectName = t[0];
					} else {
						objectName = t[0];
					}
					continue;
				}
			}
			try {
				if (captureStart) {
					if (t.length >= 3) {
						mapDataTableModel.objects.add(objectName);
						if (t[0].equals("")) {
							mapDataTableModel.segments.add(lastSegment);
						} else {
							mapDataTableModel.segments.add(t[0]);
							lastSegment = t[0];
						}
						mapDataTableModel.locations.add(t[1]);
						if (t[2].contains(" ")) {
							mapDataTableModel.lengths.add(t[2].split(" ")[0]);
							mapDataTableModel.attributes.add(t[2].split(" ")[1]);
						} else {
							mapDataTableModel.lengths.add("");
							mapDataTableModel.attributes.add(t[2]);
						}
					} else {
						if (line.equals("")) {
							continue;
						} else {
							lastSegment = t[0];
						}
						// System.out.println(">>>>>>>>>" + line);
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		mapDataTableModel.fireTableDataChanged();

		memoryMap.model = mapDataTableModel;
		memoryMap.repaint();

		Pattern p = Pattern.compile("0x[0-9abcdef]+");
		Matcher myMatcher = p.matcher(str);
		while (myMatcher.find()) {
			// System.out.println(myMatcher.group());
		}
	}

	private void jLibraryTableMouseClicked(MouseEvent evt) {
		final JProgressBarDialog dialog = new JProgressBarDialog(application, "Dumping object/library", true);
		dialog.jProgressBar.setIndeterminate(true);
		dialog.jProgressBar.setStringPainted(true);
		dialog.setSize(new Dimension(750, 150));
		CommonLib.centerDialog(dialog);

		Thread thread = new Thread() {
			public void run() {
				try {
					String objectFile = jLibraryTable.getValueAt(jLibraryTable.getSelectedRow(), 2).toString();
					Process process = Runtime.getRuntime().exec("objdump -dlS " + objectFile);
					InputStream input = process.getInputStream();

					String str = "";
					byte b[] = new byte[1024000];
					int len;
					int x = 0;
					while ((len = input.read(b)) > 0) {
						str += new String(b, 0, len);
						x += len;
						dialog.jProgressBar.setString("objdump -dlS " + objectFile + ", " + String.valueOf(x));
					}
					input.close();
					dialog.jProgressBar.setString("Setting the result to textarea, please be patient");
					final String str2 = str;
					// jObjdumpTextArea.setText(str);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		dialog.thread = thread;
		dialog.setVisible(true);
	}

	private void jAssemblyTableMouseClicked(MouseEvent evt) {
		application.jInstructionTableMouseClicked(evt);
	}

	private void jSearchMapTextFieldKeyReleased(KeyEvent evt) {
		mapDataTableModel.setSearchPattern(jSearchMapTextField.getText());
		mapDataTableModel.fireTableDataChanged();
	}

	public void showWhere(long address) {
		for (int x = 0; x < this.jMapDataTable.getRowCount(); x++) {
			long addr = CommonLib.string2decimal((String) jMapDataTable.getValueAt(x, 2));

			if (address < addr) {
				if (x == 0) {
					x = 1;
				}
				jMapDataTable.setRowSelectionInterval(x - 1, x - 1);
				jMapDataTable.scrollRectToVisible(new Rectangle(jMapDataTable.getCellRect(x - 1, 0, true)));
				return;
			}
		}
	}

	private void jButton14ActionPerformed(ActionEvent evt) {
		this.addInstructionComboBox(this.jInstructionComboBox.getSelectedItem().toString());
		jDisassembleButton.setEnabled(false);
		application.updateInstruction(CommonLib.convertFilesize(this.jInstructionComboBox.getSelectedItem().toString()));
		application.updateBreakpointTableColor();
		jDisassembleButton.setEnabled(true);
	}

	private void addInstructionComboBox(String str) {
		for (int x = 0; x < jInstructionComboBox.getItemCount(); x++) {
			if (this.jInstructionComboBox.getItemAt(x).toString().trim().equals(str.trim())) {
				return;
			}
		}

		jInstructionComboBox.addItem(str.trim());
	}

	private void jInstructionComboBoxActionPerformed(ActionEvent evt) {
		jButton14ActionPerformed(evt);
	}

	private void jDisassembleButtonActionPerformed(ActionEvent evt) {
		jDisassembleButton.setEnabled(false);
		application.updateInstruction(null);
		application.updateBreakpointTableColor();
		jDisassembleButton.setEnabled(true);
	}

	private void jInstructionUpTenButtonActionPerformed(ActionEvent evt) {
		String firstAddress = this.jAssemblyTable.getValueAt(0, 1).toString().replaceAll("^-*", "");
		firstAddress = Long.toHexString(CommonLib.convertFilesize("0x" + firstAddress) - 16);

		this.jInstructionComboBox.setSelectedItem("0x" + firstAddress);
		application.updateInstruction(CommonLib.convertFilesize("0x" + firstAddress));
		application.updateBreakpointTableColor();
	}

	private void jInstructionUpButtonActionPerformed(ActionEvent evt) {
		if (this.jAssemblyTable.getRowCount() > 0) {
			String firstAddress = this.jAssemblyTable.getValueAt(0, 1).toString().replaceAll("^-*", "");
			firstAddress = Long.toHexString(CommonLib.convertFilesize("0x" + firstAddress) - 1);

			this.jInstructionComboBox.setSelectedItem("0x" + firstAddress);
			application.updateInstruction(CommonLib.convertFilesize("0x" + firstAddress));
			application.updateBreakpointTableColor();
		}
	}

	private void jInstructionDownButtonActionPerformed(ActionEvent evt) {
		if (this.jAssemblyTable.getRowCount() > 10) {
			String firstAddress = this.jAssemblyTable.getValueAt(10, 1).toString().replaceAll("^-*", "");

			this.jInstructionComboBox.setSelectedItem("0x" + firstAddress);
			application.updateInstruction(CommonLib.convertFilesize("0x" + firstAddress));
			application.updateBreakpointTableColor();
		}
	}

	private void jButton3ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!PeterBochsCommonLib.saveImage(jAssemblyTable, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void jButton12ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			PeterBochsCommonLib.exportTableModelToExcel(file, this.jAssemblyTable.getModel(), "instruction 0x" + this.jInstructionComboBox.getSelectedItem().toString());
		}
	}

	private void jFileTreeMouseClicked(MouseEvent evt) {
		handleClick(jFileTree.getSelectionPath());
	}

	void handleClick(TreePath treePath) {
		try {
			if (treePath != null) {
				final ObjectFileTreeNode file = (ObjectFileTreeNode) jFileTree.getSelectionPath().getLastPathComponent();
				if (file != null) {
					// final File cacheFile = new File(Global.peterBochsCacheDir + File.separator + file.file.getName() + ".cache");
					if (file.file.length() >= 1024 * 1024 * 10) {
						int n = JOptionPane.showConfirmDialog(application, "File too large, continue?", "Warning", JOptionPane.YES_NO_OPTION);
						if (n == JOptionPane.NO_OPTION) {
							return;
						}
					}
					// if (cacheFile.exists() && file.file.length() >= 1024 * 1024) {
					// cSourceTextArea.setText(FileUtils.readFileToString(cacheFile));
					// } else {
					final JProgressBarDialog dialog = new JProgressBarDialog(application, "Dumping object/library", true);
					dialog.jProgressBar.setIndeterminate(true);
					dialog.jProgressBar.setStringPainted(true);
					dialog.setSize(new Dimension(750, 150));
					CommonLib.centerDialog(dialog);

					Thread thread = new Thread() {
						public void run() {
							try {
								String objectFile = file.file.getAbsolutePath();
								Process process = Runtime.getRuntime().exec("objdump -dlS " + objectFile);
								InputStream input = process.getInputStream();

								String str = "";
								byte b[] = new byte[10240000];
								int len;
								int x = 0;
								cSourceTextArea.setText("");
								while ((len = input.read(b)) > 0) {
									str += new String(b, 0, len);
									x += len;
									// cSourceTextArea.jTextArea.append(str);
									dialog.jProgressBar.setString("objdump -dlS " + objectFile + ", " + String.valueOf(x));
								}
								input.close();
								dialog.jProgressBar.setString("Setting the result to textarea, please be patient");
								cSourceTextArea.pager.setVisible(true);
								cSourceTextArea.loadLargeFile(str);
								cSourceTextArea.refreshPage();

								// if (!new File(Global.peterBochsCacheDir).exists()) {
								// new File(Global.peterBochsCacheDir).mkdir();
								// }
								// FileUtils.write(cacheFile, str);
								// cSourceTextArea.setText(str);
								// Document doc = cSourceTextArea.jTextArea.getDocument();
								// doc.insertString(0, str, null);

							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					};
					dialog.thread = thread;
					dialog.setVisible(true);
					// }
				}
			}
			cSourceTextArea.setPage(1);
		} catch (Exception e) {
		}
	}

	private void jReloadCacheFileButtonActionPerformed(ActionEvent evt) {
		if (jFileTree.getSelectionPath() == null) {
			JOptionPane.showMessageDialog(this, "Please select a node", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			final ObjectFileTreeNode file = (ObjectFileTreeNode) jFileTree.getSelectionPath().getLastPathComponent();
			if (file.file != null) {
				new File(Global.peterBochsCacheDir + File.separator + file.file.getName() + ".cache").delete();
			}
		}
	}

	private JPopupMenu getJCppPopupMenu() {
		if (jCppPopupMenu == null) {
			jCppPopupMenu = new JPopupMenu();
			{
				jShowMeTheCodeMenuItem = new JMenuItem();
				jCppPopupMenu.add(jShowMeTheCodeMenuItem);
				jShowMeTheCodeMenuItem.setText("Show me the code");
				jShowMeTheCodeMenuItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jShowMeTheCodeMenuItemActionPerformed(evt);
					}
				});
			}
		}
		return jCppPopupMenu;
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

	private void jShowMeTheCodeMenuItemActionPerformed(ActionEvent evt) {
		jMainTabbedPane.setSelectedComponent(jCPanel);
		File file = new File(jMapDataTable.getValueAt(jMapDataTable.getSelectedRow(), 0).toString().replaceAll("\\(.*", "").trim());
		if (file.exists()) {
			TreePath p = com.petersoft.CommonLib.findTreeNode((TreeNode) jFileTree.getModel().getRoot(), file.getName(), new TreePath(jFileTree.getModel().getRoot()));
			jFileTree.setSelectionPath(p);
			handleClick(p);
		}
	}

	private void jMapDataTableMouseClicked(MouseEvent evt) {
		if (SwingUtilities.isRightMouseButton(evt)) {
			// select
			Point p = evt.getPoint();
			int rowNumber = jMapDataTable.rowAtPoint(p);
			int columnNumber = jMapDataTable.columnAtPoint(p);
			ListSelectionModel model = jMapDataTable.getSelectionModel();
			model.setSelectionInterval(rowNumber, rowNumber);
			jMapDataTable.getColumnModel().getSelectionModel().setSelectionInterval(columnNumber, columnNumber);
			// end select

			getJCppPopupMenu().show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}

	private JButton getJExpandAllButton() {
		if (jExpandAllButton == null) {
			jExpandAllButton = new JButton();
			jExpandAllButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/expand.png")));
			jExpandAllButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jExpandAllButtonActionPerformed(evt);
				}
			});
		}
		return jExpandAllButton;
	}

	private JButton getJCollapseButton() {
		if (jCollapseButton == null) {
			jCollapseButton = new JButton();
			jCollapseButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/collapse.png")));
			jCollapseButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jCollapseButtonActionPerformed(evt);
				}
			});
		}
		return jCollapseButton;
	}

	private void jExpandAllButtonActionPerformed(ActionEvent evt) {
		com.petersoft.CommonLib.expandAll(jFileTree, true);
	}

	private void jCollapseButtonActionPerformed(ActionEvent evt) {
		com.petersoft.CommonLib.expandAll(jFileTree, false);
	}

	private void pagerClicked(PagerEvent evt) {
		cSourceTextArea.refreshPage();
	}

}
