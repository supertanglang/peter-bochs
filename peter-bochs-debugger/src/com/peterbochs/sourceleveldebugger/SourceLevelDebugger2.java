package com.peterbochs.sourceleveldebugger;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.apache.commons.io.FileUtils;


import com.peterbochs.Application;
import com.peterbochs.Global;
import com.peterbochs.JInstructionTableCellRenderer;
import com.peterbochs.MyLanguage;
import com.peterbochs.PeterBochsCommonLib;
import com.petersoft.CommonLib;
import com.peterbochs.Setting;
import com.petersoft.CommonLib;
import com.petersoft.advancedswing.enhancedtextarea.EnhancedTextArea;
import com.petersoft.advancedswing.jmaximizabletabbedpane.JMaximizableTabbedPane;
import com.petersoft.advancedswing.jmaximizabletabbedpane.JMaximizableTabbedPane_BasePanel;
import com.petersoft.advancedswing.jprogressbardialog.JProgressBarDialog;
import com.petersoft.advancedswing.jprogressbardialog.JProgressBarDialogEventListener;
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
public class SourceLevelDebugger2 extends JMaximizableTabbedPane_BasePanel implements JProgressBarDialogEventListener {
	private JSplitPane jMainSplitPane;
	private JPanel jPanel1;
	private JPanel jBreakpointPanel;
	private JMaximizableTabbedPane jTabbedPane2;
	private JPanel jPanel7;
	private JPanel jPanel6;
	private JSplitPane jSplitPane3;
	private JPanel jPanel4;
	private JScrollPane jScrollPane1;
	private JButton jDisassembleButton;
	private JButton jButton14;
	private JComboBox jInstructionComboBox;
	private EnhancedTextArea jRawTextArea;
	private JScrollPane jScrollPane5;
	private JPanel jPanel14;
	private MemoryMap memoryMap;
	private JPanel jPanel13;
	private JSearchTextField jSearchMapTextField;
	private JPanel jPanel12;
	private JTable jMapDataTable;
	private JScrollPane jScrollPane4;
	private JPanel jPanel11;
	private JPanel jPanel10;
	public JTable jAssemblyTable;
	private JScrollPane jScrollPane3;
	private JButton jButton12;
	private JButton jButton3;
	private JButton jInstructionDownButton;
	private JButton jInstructionUpButton;
	private JButton jInstructionUpTenButton;
	private JPanel jInstructionControlPanel;
	private JPanel jASMPanel;
	private EnhancedTextArea cSourceTextArea;
	private JPanel jSourcePanel;
	private JPanel jFunctionListPanel;
	private JSearchTextField jSearchProjectTextField;
	private JToolBar jProjectToolBar;
	private JMaximizableTabbedPane jMainTabbedPane;
	private JTree jFileTree;
	private JPanel jPanel3;
	private JMaximizableTabbedPane jTabbedPane1;
	private JPopupMenu jCppPopupMenu;
	private JMenuItem jShowMeTheCodeMenuItem;

	private MapDataTableModel mapDataTableModel = new MapDataTableModel();
	Application application;
	private File mapFile;
	private TextTreeNode root;
	private JTable jCodeTable;
	private JLabel jErrorLabel;
	private JCheckBox jAllFunctionsExactCheckBox;
	private JSearchTextField jSearchAllFunctionsTextField;
	private JToolBar jToolBar1;
	private JTable jAllFunctionsTable;
	private JScrollPane jScrollPane11;
	private JSearchTextField jSearchFunctionTextField;
	private JSearchTextField jSearchDwarfTextField;
	private JCheckBox jExactMatchCheckBox;
	private JComboBox jDwarfComboBox;
	private JButton jRefreshDwarfTableButton;
	private JPanel jPanel22;
	private JTable jDwarfTable;
	private JScrollPane jScrollPane10;
	private JPanel jPanel21;
	private JSearchTextField jSearchSymbolTextField;
	private JButton jRefreshParsedFunctionButton;
	private JPanel jPanel20;
	private JPanel jPanel19;
	private JTable jParsedFunctionTable;
	private JButton jRefreshArchiveFileButton;
	private JPanel jPanel18;
	private JPanel jPanel17;
	private JButton jRefreshFunctionButton;
	private JPanel jPanel16;
	private JPanel jPanel15;
	private JButton jRefreshSymbolButton;
	private JPanel jPanel9;
	private JPanel jPanel8;
	private JButton jRefreshCodeButton;
	private JPanel jPanel5;
	private JPanel jPanel2;
	private JTable jArchiveFileTable;
	private JTable jFunctionTable;
	private JTable jSymbolTable;
	private JScrollPane jScrollPane9;
	private JScrollPane jScrollPane8;
	private JScrollPane jScrollPane7;
	private JScrollPane Symbol;
	private JScrollPane jScrollPane6;
	private JTabbedPane jTabbedPane3;
	private JPanel jStructurePanel;
	private JPanel jThreadPanel;
	private JPanel jVariablePanel;
	private JTable jRawSourceTable;
	private JScrollPane jScrollPane2;
	private JPanel jRawSourcePanel;

	public SourceLevelDebugger2(Application application) {
		this.application = application;
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(975, 563));
			{
				jMainSplitPane = new JSplitPane();
				this.add(getJErrorLabel(), "errorLabel");
				this.add(jMainSplitPane, "MAIN");
				jMainSplitPane.setDividerLocation(300);
				{
					jPanel4 = new JPanel();
					jMainSplitPane.add(jPanel4, JSplitPane.RIGHT);
					BorderLayout jPanel4Layout = new BorderLayout();
					jPanel4.setLayout(jPanel4Layout);
					{
						jSplitPane3 = new JSplitPane();
						jPanel4.add(jSplitPane3, BorderLayout.CENTER);
						jSplitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);
						jSplitPane3.setDividerLocation(500);
						{
							jPanel6 = new JPanel();
							BorderLayout jPanel6Layout = new BorderLayout();
							jPanel6.setLayout(jPanel6Layout);
							jSplitPane3.add(jPanel6, JSplitPane.LEFT);
							{
								jMainTabbedPane = new JMaximizableTabbedPane();
								jPanel6.add(jMainTabbedPane, BorderLayout.CENTER);
								{
									jASMPanel = new JPanel();
									jMainTabbedPane.addTab(MyLanguage.getString("ASM/C"), null, jASMPanel, null);
									BorderLayout jASMPanelLayout = new BorderLayout();
									jASMPanel.setLayout(jASMPanelLayout);
									{
										jInstructionControlPanel = new JPanel();
										jASMPanel.add(jInstructionControlPanel, BorderLayout.NORTH);
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
											jDisassembleButton.setEnabled(true);
											jDisassembleButton.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent evt) {
													jDisassembleButtonActionPerformed(evt);
												}
											});
										}
										{
											jInstructionUpTenButton = new JButton();
											jInstructionControlPanel.add(jInstructionUpTenButton);
											jInstructionUpTenButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/arrow_up10.png")));
											jInstructionUpTenButton.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent evt) {
													jInstructionUpTenButtonActionPerformed(evt);
												}
											});
										}
										{
											jInstructionUpButton = new JButton();
											jInstructionControlPanel.add(jInstructionUpButton);
											jInstructionUpButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/arrow_up1.png")));
											jInstructionUpButton.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent evt) {
													jInstructionUpButtonActionPerformed(evt);
												}
											});
										}
										{
											jInstructionDownButton = new JButton();
											jInstructionControlPanel.add(jInstructionDownButton);
											jInstructionDownButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/arrow_down.png")));
											jInstructionDownButton.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent evt) {
													jInstructionDownButtonActionPerformed(evt);
												}
											});
										}
										{
											jButton3 = new JButton();
											jInstructionControlPanel.add(jButton3);
											jButton3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/disk.png")));
											jButton3.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent evt) {
													jButton3ActionPerformed(evt);
												}
											});
										}
										{
											jButton12 = new JButton();
											jInstructionControlPanel.add(jButton12);
											jButton12.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/excel.gif")));
											jButton12.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent evt) {
													jButton12ActionPerformed(evt);
												}
											});
										}
									}
									{
										jScrollPane3 = new JScrollPane();
										jASMPanel.add(jScrollPane3, BorderLayout.CENTER);
										{
											jAssemblyTable = new JTable();
											jScrollPane3.setViewportView(jAssemblyTable);
											jAssemblyTable.setModel(Application.jInstructionTable.getModel());
											jAssemblyTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
											jAssemblyTable.getTableHeader().setReorderingAllowed(false);
											jAssemblyTable.getColumnModel().getColumn(0).setMaxWidth(20);
											jAssemblyTable.getColumnModel().getColumn(1).setPreferredWidth(40);
											jAssemblyTable.getColumnModel().getColumn(2).setPreferredWidth(200);
											jAssemblyTable.getColumnModel().getColumn(3).setPreferredWidth(40);
											jAssemblyTable.setShowGrid(false);
											jAssemblyTable.setDefaultRenderer(String.class, new JInstructionTableCellRenderer());
											jAssemblyTable.addMouseListener(new MouseAdapter() {
												public void mouseClicked(MouseEvent evt) {
													jAssemblyTableMouseClicked(evt);
												}
											});
										}
									}
								}
								{
									jSourcePanel = new JPanel();
									jMainTabbedPane.addTab(MyLanguage.getString("Source"), null, jSourcePanel, null);
									BorderLayout jPanel9Layout = new BorderLayout();
									jSourcePanel.setLayout(jPanel9Layout);
									{
										cSourceTextArea = new EnhancedTextArea();
										jSourcePanel.add(cSourceTextArea, BorderLayout.CENTER);
										cSourceTextArea.pager.addPagerEventListener(new PagerEventListener() {
											public void clicked(PagerEvent evt) {
												pagerClicked(evt);
											}
										});
									}
								}
								{
									jPanel10 = new JPanel();
									jMainTabbedPane.addTab(MyLanguage.getString("Raw"), null, getJPanel14(), null);
									jMainTabbedPane.addTab(MyLanguage.getString("Map"), null, jPanel10, null);
									jMainTabbedPane.addTab(MyLanguage.getString("Raw_source"), null, getJRawSourcePanel(), null);
									jMainTabbedPane.addTab(MyLanguage.getString("Structure"), null, getJStructurePanel(), null);
									BorderLayout jPanel10Layout = new BorderLayout();
									jPanel10.setLayout(jPanel10Layout);
									{
										jPanel11 = new JPanel();
										BorderLayout jPanel11Layout = new BorderLayout();
										jPanel10.add(jPanel11, BorderLayout.CENTER);
										jPanel11.setPreferredSize(new java.awt.Dimension(549, 372));
										jPanel11.setLayout(jPanel11Layout);
										{
											jScrollPane4 = new JScrollPane();
											jPanel11.add(jScrollPane4, BorderLayout.CENTER);
											{
												jMapDataTable = new JTable();
												jScrollPane4.setViewportView(jMapDataTable);
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
											jPanel12 = new JPanel();
											FlowLayout jPanel12Layout = new FlowLayout();
											jPanel12Layout.setAlignment(FlowLayout.LEFT);
											jPanel11.add(jPanel12, BorderLayout.NORTH);
											jPanel12.setLayout(jPanel12Layout);
											{
												jSearchMapTextField = new JSearchTextField();
												jPanel12.add(jSearchMapTextField);
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
										jPanel13 = new JPanel();
										BorderLayout jPanel13Layout = new BorderLayout();
										jPanel10.add(jPanel13, BorderLayout.NORTH);
										jPanel13.setLayout(jPanel13Layout);
										{
											memoryMap = new MemoryMap();
											jPanel13.add(memoryMap, BorderLayout.CENTER);
											memoryMap.setPreferredSize(new java.awt.Dimension(549, 31));
										}
									}
								}
							}
						}
						{
							jPanel7 = new JPanel();
							BorderLayout jPanel7Layout = new BorderLayout();
							jPanel7.setLayout(jPanel7Layout);
							jSplitPane3.add(jPanel7, JSplitPane.BOTTOM);
							{
								jTabbedPane2 = new JMaximizableTabbedPane();
								jPanel7.add(jTabbedPane2, BorderLayout.CENTER);
								{
									jBreakpointPanel = new JPanel();
									jTabbedPane2.addTab("Breakpoint", null, jBreakpointPanel, null);
									jTabbedPane2.addTab("Variable", null, getJVariablePanel(), null);
									jTabbedPane2.addTab("Thread", null, getJThreadPanel(), null);
								}
							}
						}
					}
				}
				{
					jPanel1 = new JPanel();
					jMainSplitPane.add(jPanel1, JSplitPane.LEFT);
					BorderLayout jPanel1Layout = new BorderLayout();
					jPanel1.setLayout(jPanel1Layout);
					{
						jTabbedPane1 = new JMaximizableTabbedPane();
						jPanel1.add(jTabbedPane1, BorderLayout.CENTER);
						jTabbedPane1.addChangeListener(new ChangeListener() {
							public void stateChanged(ChangeEvent evt) {
								jTabbedPane1StateChanged(evt);
							}
						});
						{
							jPanel3 = new JPanel();
							BorderLayout jPanel3Layout = new BorderLayout();
							jPanel3.setLayout(jPanel3Layout);
							jTabbedPane1.addTab(MyLanguage.getString("Project"), null, jPanel3, null);
							jTabbedPane1.addTab(MyLanguage.getString("Functions"), null, getJFunctionListPanel(), null);
							{
								jScrollPane1 = new JScrollPane();
								jPanel3.add(jScrollPane1, BorderLayout.CENTER);
								jPanel3.add(getJProjectToolBar(), BorderLayout.NORTH);
								{
									jFileTree = new JTree();
									jScrollPane1.setViewportView(jFileTree);
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
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	private void jShowMeTheCodeMenuItemActionPerformed(ActionEvent evt) {
		// jMainTabbedPane.setSelectedComponent(jCPanel);
		String path = jMapDataTable.getValueAt(jMapDataTable.getSelectedRow(), 0).toString().replaceAll("\\(.*", "").trim();
		File file;
		if (path.startsWith(File.separator)) {
			file = new File(path);
		} else {
			file = new File(mapFile.getParent() + File.separator + path);
		}
		if (file.exists()) {
			TreePath p = com.petersoft.CommonLib.findTreeNode((TreeNode) jFileTree.getModel().getRoot(), file.getName(), new TreePath(jFileTree.getModel().getRoot()));
			jFileTree.setSelectionPath(p);
			handleProjectTreeClick(p);
		} else {
			System.out.println("file not exist : " + file.getAbsolutePath());
		}
	}

	private void jFileTreeMouseClicked(MouseEvent evt) {
		if (jFileTree.getSelectionPath() != null) {
			Object node = jFileTree.getSelectionPath().getLastPathComponent();
			if (node instanceof FunctionTreeNode) {
				FunctionTreeNode funcNode = (FunctionTreeNode) node;
				Symbol symbol = MapStructure.findSymbolByFilenameOrObjectName(funcNode.function.name);
				if (symbol != null) {
					jInstructionComboBox.setSelectedItem("0x" + Long.toHexString(symbol.memoryOffset));
				} else {
					JOptionPane.showMessageDialog(this, "Symbol not found");
				}
				jMainTabbedPane.setSelectedIndex(0);
			} /*
			 * else if (evt.getClickCount() == 2) { boolean isExpand =
			 * jFileTree.isExpanded(jFileTree.getSelectionPath());
			 * jFileTree.setEnabled(false);
			 * handleProjectTreeClick(jFileTree.getSelectionPath());
			 * jFileTree.setEnabled(true); if (!isExpand) {
			 * jFileTree.expandPath(jFileTree.getSelectionPath()); } else {
			 * jFileTree.collapsePath(jFileTree.getSelectionPath()); } }
			 */
		}
	}

	private void updateRawSourceTable(String functionName) {
		RawSourceTableModel model = (RawSourceTableModel) jRawSourceTable.getModel();
		model.functionName = functionName;
		model.codes = MapStructure.disassembledCodes.get(functionName);
		model.fireTableDataChanged();

		jMainTabbedPane.setSelectedComponent(this.getJRawSourcePanel());
	}

	private void parseCodeIntoDisassembledCodes(Function function) {
		try {
			if (MapStructure.parsedFunctions.contains(function.file.getAbsolutePath() + "+" + function.name)) {
				return;
			}
			if (Global.debug) {
				System.out.println("parseCode : " + function.file.getAbsolutePath() + ", function name : " + function.name);
			}
			MapStructure.disassembledCodes.remove(function.name);
			Vector<DisassembledCode> codeLines = new Vector<DisassembledCode>();

			String lines[] = function.code.split("\n");
			System.out.println(function.code);
			boolean start = false;
			String cCode = null;
			for (String line : lines) {
				Matcher matcher = Pattern.compile("^ +.*[0123456789abcdef]+:.*").matcher(line);
				if (start) {
					if (matcher.matches()) {
						DisassembledCode dc = parseLine(function, line, cCode);
						if (dc != null) {
							codeLines.add(dc);
						}
					} else {
						cCode = line.trim();
					}
				} else {
					if (matcher.matches()) {
						start = true;

						DisassembledCode dc = parseLine(function, line, cCode);
						if (dc != null) {
							codeLines.add(dc);
						}
						continue;
					}
					cCode = line.trim();
				}
			}
			MapStructure.disassembledCodes.put(function.name, codeLines);
			MapStructure.parsedFunctions.add(function.file.getAbsolutePath() + "+" + function.name);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	DisassembledCode parseLine(Function function, String line, String cCode) {
		DisassembledCode dc = new DisassembledCode();
		String s[] = line.split("\t");
		if (s.length >= 3) {
			try {
				dc.cCode = cCode;
				dc.offset = Integer.parseInt(s[0].trim().replaceAll(":", ""), 16);
				String bytes[] = s[1].trim().split(" ");
				dc.bytes = new int[bytes.length];
				for (int x = 0; x < bytes.length; x++) {
					dc.bytes[x] = Integer.parseInt(bytes[x], 16);
				}
				dc.asmCode = s[2];
				dc.file = function.file;
				return dc;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	void handleProjectTreeClick(TreePath treePath) {
		try {
			if (treePath != null) {
				final ObjectFileTreeNode selectedTreeNode = (ObjectFileTreeNode) jFileTree.getSelectionPath().getLastPathComponent();
				if (selectedTreeNode != null) {
					if (selectedTreeNode.file == null) {
						return;
					}
					if (selectedTreeNode.file.length() >= 1024 * 1024 * 10) {
						int n = JOptionPane.showConfirmDialog(application, "File too large, continue?", "Warning", JOptionPane.YES_NO_OPTION);
						if (n == JOptionPane.NO_OPTION) {
							return;
						}
					}
					final JProgressBarDialog dialog = new JProgressBarDialog(application, "Dumping object/library", true);
					dialog.jProgressBar.setIndeterminate(true);
					dialog.jProgressBar.setStringPainted(true);
					// dialog.setSize(new Dimension(750, 150));
					dialog.addCancelEventListener(this);
					CommonLib.centerDialog(dialog);

					Thread thread = new Thread() {
						public void run() {
							try {
								String objectFile = selectedTreeNode.file.getAbsolutePath();
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
									dialog.jProgressBar.setString("objdump -dlS " + objectFile + ", " + String.valueOf(x));
								}
								input.close();
								dialog.jProgressBar.setString("Setting the result to textarea, please be patient");
								cSourceTextArea.pager.setVisible(true);
								cSourceTextArea.pageSize = 10000;
								cSourceTextArea.loadLargeFile(str);
								cSourceTextArea.refreshPage();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					};
					dialog.thread = thread;
					dialog.setVisible(true);
				}
			}
		} catch (Exception e) {
		}
	}

	private void jInstructionComboBoxActionPerformed(ActionEvent evt) {
		jButton14ActionPerformed(evt);
	}

	private void jButton14ActionPerformed(ActionEvent evt) {
		this.addInstructionComboBox(this.jInstructionComboBox.getSelectedItem().toString());
		jDisassembleButton.setEnabled(false);
		try {
			application.updateInstruction(CommonLib.string2decimal(this.jInstructionComboBox.getSelectedItem().toString()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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

	private void jDisassembleButtonActionPerformed(ActionEvent evt) {
		jDisassembleButton.setEnabled(false);
		application.updateInstruction(null);
		application.updateBreakpointTableColor();
		jDisassembleButton.setEnabled(true);
	}

	private void jInstructionUpTenButtonActionPerformed(ActionEvent evt) {
		application.jInstructionUpTenButtonActionPerformed(evt);
	}

	private void jInstructionUpButtonActionPerformed(ActionEvent evt) {
		application.jInstructionUpButtonActionPerformed(evt);
	}

	private void jInstructionDownButtonActionPerformed(ActionEvent evt) {
		application.jInstructionDownButtonActionPerformed(evt);
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

	private void jAssemblyTableMouseClicked(MouseEvent evt) {
		application.jInstructionTableMouseClicked(evt);
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

	private void jSearchMapTextFieldKeyReleased(KeyEvent evt) {
		mapDataTableModel.setSearchPattern(jSearchMapTextField.getText());
		mapDataTableModel.fireTableDataChanged();
	}

	public void loadSystemMap(final File mapFile) {
		if (Global.debug) {
			System.out.println("loadSystemMap");
		}
		try {
			if (!mapFile.isFile()) {
				JOptionPane.showMessageDialog(this, mapFile.getAbsolutePath() + " is not a file !!!");
				return;
			} else if (!mapFile.exists()) {
				JOptionPane.showMessageDialog(this, mapFile.getAbsolutePath() + " not exist !!!");
				return;
			}
			this.mapFile = mapFile;
			final JProgressBarDialog d = new JProgressBarDialog(application, "Load map file", true);
			d.jProgressBar.setIndeterminate(true);
			d.jProgressBar.setStringPainted(true);
			d.setSize(new Dimension(600, 160));
			d.addCancelEventListener(this);
			Thread longRunningThread = new Thread() {
				public void run() {
					application.enableAllButtons(false, false);

					try {
						MapStructure.mapFileContent = FileUtils.readFileToString(mapFile);

						jRawTextArea.setText(MapStructure.mapFileContent);
						jRawTextArea.jTextArea.setCaretPosition(0);

						d.jProgressBar.setString("init project tree");
						initProjectTree();
						d.jProgressBar.setString("init memory map");
//						initMemoryMap();
						d.jProgressBar.setString("load dwarf line");
						loadDwarfLine(d);

						application.jShowInSourceCodeMenuItem.setEnabled(true);
						application.jWhereIsHereMenuItem.setEnabled(true);
						application.jSourceLevelDebuggerButtonActionPerformed(null);
						// jMainTabbedPane.setSelectedIndex(1);
						com.petersoft.CommonLib.expandAll(jFileTree, true);
						collapseAllFunction(jFileTree);

						jErrorLabel.setVisible(false);
						show("MAIN");
					} catch (IOException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(application, e.getMessage());
					}
					application.enableAllButtons(true, false);
				}
			};
			d.thread = longRunningThread;
			d.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (Global.debug) {
			System.out.println("loadSystemMap end");
		}
	}

	private void loadDwarfLine(JProgressBarDialog d) {
		// load line information from dwarfdump
		MapStructure.dwarfLines.clear();
		for (File file : MapStructure.archiveAndObjectFiles) {
			Symbol fileSymbol = MapStructure.findSymbolByFileAndSegmentName(file, ".text");
			String dwarfdump = Setting.getInstance().getPath_dwarfdump();
			if (dwarfdump == null || dwarfdump.trim().equals("")) {
				dwarfdump = "dwarfdump";
			}
			String command = dwarfdump + " -l " + file.getAbsolutePath();
			d.jProgressBar.setString("dwarfdump -l " + file.getAbsolutePath());
			String results = CommonLib.runCommand(command);
			if (Global.debug) {
				System.out.println(command);
			}
			String lines[] = results.split("\n");
			Vector<DwarfLine> linesVector = new Vector<DwarfLine>();
			String archiveMember = file.getName();
			for (int x = 0; x < lines.length; x++) {
				d.jProgressBar.setString("dwarfdump -l " + file.getAbsolutePath() + " " + x + "/" + (lines.length - 1));
				lines[x] = lines[x].replaceAll("\\[", "").replaceAll("\\]", "");
				String words[] = lines[x].split("[ \\t]+");
				if (lines[x].contains("archive member")) {
					archiveMember = lines[x].replace("archive member", "").trim();
				} else if (words.length >= 4) {
					File sourceFile = new File(words[0].replaceAll(":", ""));
					if (sourceFile.exists()) {
						try {
							Symbol symbol = MapStructure.findSymbolByArchiveMember(archiveMember, ".text");
							if (symbol == null) {
								symbol = fileSymbol;
							}
							if (symbol != null) {
								DwarfLine dLine = new DwarfLine();
								dLine.file = sourceFile;
								dLine.lineNo = Integer.parseInt(words[1].split(",")[0]);
								dLine.pc = symbol.memoryOffset + CommonLib.string2decimal(words[2]);
								dLine.archiveMember = archiveMember;
								linesVector.add(dLine);
							}
						} catch (Exception ex) {
							if (Global.debug) {
								ex.printStackTrace();
							}
						}
					}
				}
			}
			MapStructure.dwarfLines.put(file, linesVector);
		}
		MapStructure.updateAllDwarfLines();
		// end load line information from dwarfdump
	}

	private void initProjectTree() {
		if (Global.debug) {
			System.out.println("--initProjectTree");
		}
		MapStructure.archiveAndObjectFiles.clear();

		// load "Archive member included because of file" into JTree
		TextTreeNode archiveNode = new TextTreeNode("Archive member");
		root = new TextTreeNode(mapFile.getName());
		archiveNode.parent = root;
		root.children.add(archiveNode);

		try {
			String line;
			BufferedReader br = new BufferedReader(new FileReader(mapFile));
			boolean start = false;
			while ((line = br.readLine()) != null) {
				if (line.toLowerCase().contains("Allocating common symbols".toLowerCase())) {
					break;
				}
				if (start) {
					Matcher matcher = Pattern.compile("^[^ \t].*").matcher(line);
					if (matcher.matches()) {
						File file = new File(line.replaceAll("\\(.*", ""));
						if (file.exists() && !MapStructure.archiveAndObjectFiles.contains(file)) {
							MapStructure.archiveAndObjectFiles.add(file);
							ArchiveFileTreeNode node = new ArchiveFileTreeNode(file);
							node.parent = archiveNode;
							archiveNode.children.add(node);
							loadFunctionList(node, file);
						}
					}
				} else if (line.toLowerCase().contains("Archive member included because of file".toLowerCase())) {
					start = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// end "Archive member included because of file" into JTree

		// load all (*) into JTree
		Pattern pattern = Pattern.compile(".*\\(\\*\\).*");
		Matcher lm = pattern.matcher(MapStructure.mapFileContent);
		TextTreeNode objectsNode = new TextTreeNode("Objects");
		objectsNode.parent = root;
		root.children.add(objectsNode);
		while (lm.find()) {
			String filepath = lm.group().replaceAll("\\(.*", "").trim();
			File file;
			if (filepath.startsWith(File.separator)) {
				file = new File(filepath);
			} else {
				file = new File(mapFile.getParent() + File.separator + filepath);
			}
			if (file.exists() && !MapStructure.archiveAndObjectFiles.contains(file)) {
				MapStructure.archiveAndObjectFiles.add(file);
				ObjectFileTreeNode node = new ObjectFileTreeNode(file);
				node.parent = objectsNode;
				objectsNode.children.add(node);
				loadFunctionList(node, file);
			}
		}
		// end load all (*) into JTree

		((ObjectFileTreeModel) jFileTree.getModel()).setRoot(root);
		jFileTree.updateUI();

		if (Global.debug) {
			System.out.println("--initProjectTree end");
		}
	}

	private void loadFunctionList(MyMutableTreeNode node, File f) {
		try {
			String objdump = Setting.getInstance().getPath_objdump();
			if (objdump == null || objdump.trim().equals("")) {
				objdump = "objdump";
			}
			String command = objdump + " -t " + f.getAbsolutePath();
			String str = CommonLib.runCommand(command);
			if (Global.debug) {
				System.out.println(command);
			}
			String lines[] = str.split("\n");
			TreeSet<Function> hs = new TreeSet<Function>();
			for (String line : lines) {
				if (line.contains(".text") && !line.endsWith(".text")) {
					try {
						Function function = new Function();
						String words[] = line.split("\\s");
						List<String> list = new ArrayList<String>(Arrays.asList(words));
						list.removeAll(Arrays.asList(""));
						words = list.toArray(words);
						function.file = f;
						function.name = words[words.length - 1].trim();
						function.fileOffset = Integer.parseInt(words[0], 16);
						if (words[words.length - 2].contains(".hidden")) {
							function.size = Integer.parseInt(words[words.length - 3], 16);
						} else {
							function.size = Integer.parseInt(words[words.length - 2], 16);
						}

						hs.add(function);
						MapStructure.functions.add(function);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			for (Function s : hs) {
				FunctionTreeNode childNode = new FunctionTreeNode(s);
				childNode.parent = node;
				node.getChildren().add(childNode);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void loadCode(Function function) {
		if (function.file == null) {
			JOptionPane.showMessageDialog(this, "Internal error, \"function.file\" is null", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Symbol symbol = MapStructure.findSymbolByFile(function.file);
		if (symbol == null) {
			JOptionPane.showMessageDialog(this, "Internal error, \"symbol(" + function.file.getAbsolutePath() + ")\" is null", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		long vmaAddress = symbol.memoryOffset;
		String code = CommonLib.runCommand("objdump -S " + function.file.getAbsolutePath() + " --adjust-vma=" + vmaAddress + " --start-address="
				+ (function.fileOffset + vmaAddress) + " --stop-address=" + (function.fileOffset + function.size + vmaAddress), 12);
		System.out.println("objdump -S " + function.file.getAbsolutePath() + " --adjust-vma=" + vmaAddress + " --start-address=" + (function.fileOffset + vmaAddress)
				+ " --stop-address=" + (function.fileOffset + function.size + vmaAddress));
		function.code = code;
		parseCodeIntoDisassembledCodes(function);
	}

	public void collapseAllFunction(JTree tree) {
		// from bottom up
		int row = tree.getRowCount() - 1;
		while (row >= 0) {
			Object obj = tree.getPathForRow(row).getLastPathComponent();
			if (obj instanceof ObjectFileTreeNode) {
				ObjectFileTreeNode node = (ObjectFileTreeNode) obj;
				if (node.file != null) {
					tree.collapseRow(row);
				}
			}
			if (obj instanceof ArchiveFileTreeNode) {
				ArchiveFileTreeNode node = (ArchiveFileTreeNode) obj;
				if (node.file != null) {
					tree.collapseRow(row);
				}
			}
			row--;
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
		if (Global.debug) {
			System.out.println("--initMemoryMap");
		}
		String str = jRawTextArea.getText();
		str = str.replaceFirst("(?s).*Linker script and memory map", "Linker script and memory map");

		String lines[] = str.split("\n");
		boolean captureStart = false;
		String objectName = null;

		MapStructure.symbols.clear();
		String lastSegment = "";
		String archiveMember = "";
		for (int x = 0; x < lines.length; x++) {
			String line = lines[x];

			String t[] = line.split("  +");

			if (t.length == 1) {
				if (t[0].contains("(*)")) {
					if (!captureStart) {
						captureStart = true;
						objectName = t[0].trim();
					} else {
						objectName = t[0].trim();
					}
					archiveMember = objectName.replaceAll("\\(.*", "");
					continue;
				}
			}
			try {
				if (captureStart) {
					if (t.length >= 3) {
						Symbol symbol = new Symbol();
						if (new File(objectName.replaceAll("\\(.*", "")).exists()) {
							symbol.file = new File(objectName.replaceAll("\\(.*", ""));
						} else {
							symbol.file = new File(mapFile.getParent() + File.separator + objectName.replaceAll("\\(.*", ""));
						}
						if (!symbol.file.exists()) {
							System.out.println("Warning : symbol.file " + symbol.file.getAbsolutePath() + " not exist");
							continue;
						}
						if (t[0].equals("")) {
							symbol.segment = lastSegment.trim();
						} else {
							symbol.segment = t[0].trim();
							lastSegment = t[0];
						}
						symbol.memoryOffset = CommonLib.string2decimal(t[1]);
						if (t[2].contains(" ")) {
							try {
								symbol.length = CommonLib.string2decimal(t[2].split(" ")[0]);
							} catch (Exception ex) {
								symbol.length = -1;
							}
							symbol.functionNameOrObjectName = t[2].split(" ")[1].trim();
						} else {
							symbol.length = -1;
							symbol.functionNameOrObjectName = t[2].trim();
						}
						if (symbol.functionNameOrObjectName.contains("(")) {
							archiveMember = symbol.functionNameOrObjectName.replaceAll("^.*\\(", "").replaceAll("\\)", "");
						}
						symbol.archiveMember = archiveMember;
						MapStructure.symbols.add(symbol);
					} else {
						if (line.equals("")) {
							continue;
						} else {
							lastSegment = t[0].trim();
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

		mapDataTableModel.setSearchPattern(null);
		mapDataTableModel.fireTableDataChanged();

		memoryMap.model = mapDataTableModel;
		memoryMap.repaint();
		if (Global.debug) {
			System.out.println("--initMemoryMap end");
		}
	}

	private JPanel getJPanel14() {
		if (jPanel14 == null) {
			jPanel14 = new JPanel();
			BorderLayout jPanel14Layout = new BorderLayout();
			jPanel14.setLayout(jPanel14Layout);
			jPanel14.add(getJScrollPane5(), BorderLayout.CENTER);
		}
		return jPanel14;
	}

	private JScrollPane getJScrollPane5() {
		if (jScrollPane5 == null) {
			jScrollPane5 = new JScrollPane();
			jScrollPane5.setViewportView(getJRawTextArea());
		}
		return jScrollPane5;
	}

	private EnhancedTextArea getJRawTextArea() {
		if (jRawTextArea == null) {
			jRawTextArea = new EnhancedTextArea();
		}
		return jRawTextArea;
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

	private void pagerClicked(PagerEvent evt) {
		cSourceTextArea.refreshPage();
	}

	@Override
	public void cancelled() {
		jFileTree.setEnabled(true);
	}

	private JToolBar getJProjectToolBar() {
		if (jProjectToolBar == null) {
			jProjectToolBar = new JToolBar();
			jProjectToolBar.add(getJSearchProjectTextField());
			jProjectToolBar.add(getJExactMatchCheckBox());
		}
		return jProjectToolBar;
	}

	private JSearchTextField getJSearchProjectTextField() {
		if (jSearchProjectTextField == null) {
			jSearchProjectTextField = new JSearchTextField();
			jSearchProjectTextField.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					jSearchProjectTextFieldKeyReleased(evt);
				}
			});
		}
		return jSearchProjectTextField;
	}

	private JPanel getJFunctionListPanel() {
		if (jFunctionListPanel == null) {
			jFunctionListPanel = new JPanel();
			BorderLayout jFunctionListPanelLayout = new BorderLayout();
			jFunctionListPanel.setLayout(jFunctionListPanelLayout);
			jFunctionListPanel.add(getJScrollPane11(), BorderLayout.CENTER);
			jFunctionListPanel.add(getJToolBar1(), BorderLayout.NORTH);
		}
		return jFunctionListPanel;
	}

	private void jSearchProjectTextFieldKeyReleased(KeyEvent evt) {
		if (jSearchProjectTextField.getText() != null) {
			setNodeVisible(root, jSearchProjectTextField.getText().toLowerCase());
			jFileTree.updateUI();
			CommonLib.expandAll(jFileTree, true);
		}
	}

	private void setNodeVisible(MyMutableTreeNode node, String str) {
		if (!this.jExactMatchCheckBox.isSelected() && node.toString().toLowerCase().contains(str)) {
			visibleNode(node);
		} else if (node.toString().toLowerCase().equals(str)) {
			visibleNode(node);
		} else {
			node.setVisible(false);
		}
		for (int x = 0; x < node.getChildren().size(); x++) {
			setNodeVisible(node.getChildren().get(x), str);
		}
	}

	private void visibleNode(MyMutableTreeNode node) {
		node.setVisible(true);
		if (node.getParent() != null) {
			visibleNode((MyMutableTreeNode) node.getParent());
		}
	}

	private JPanel getJRawSourcePanel() {
		if (jRawSourcePanel == null) {
			jRawSourcePanel = new JPanel();
			BorderLayout jRawSourcePanelLayout = new BorderLayout();
			jRawSourcePanel.setLayout(jRawSourcePanelLayout);
			jRawSourcePanel.add(getJScrollPane2(), BorderLayout.CENTER);
		}
		return jRawSourcePanel;
	}

	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getJRawSourceTable());
		}
		return jScrollPane2;
	}

	private JTable getJRawSourceTable() {
		if (jRawSourceTable == null) {
			jRawSourceTable = new JTable();
			jRawSourceTable.setModel(new RawSourceTableModel());
			jRawSourceTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jRawSourceTable.getColumnModel().getColumn(0).setPreferredWidth(100);
			jRawSourceTable.getColumnModel().getColumn(1).setPreferredWidth(800);
			jRawSourceTable.setDefaultRenderer(String.class, new RawSourceTableCellRenderer());
			jRawSourceTable.setShowHorizontalLines(false);
		}
		return jRawSourceTable;
	}

	private JPanel getJVariablePanel() {
		if (jVariablePanel == null) {
			jVariablePanel = new JPanel();
		}
		jVariablePanel.setVisible(false);
		return jVariablePanel;
	}

	private JPanel getJThreadPanel() {
		if (jThreadPanel == null) {
			jThreadPanel = new JPanel();
		}
		jThreadPanel.setVisible(false);
		return jThreadPanel;
	}

	private JPanel getJStructurePanel() {
		if (jStructurePanel == null) {
			jStructurePanel = new JPanel();
			BorderLayout jStructurePanelLayout = new BorderLayout();
			jStructurePanel.setLayout(jStructurePanelLayout);
			jStructurePanel.add(getJTabbedPane3(), BorderLayout.CENTER);
		}
		return jStructurePanel;
	}

	private JTabbedPane getJTabbedPane3() {
		if (jTabbedPane3 == null) {
			jTabbedPane3 = new JTabbedPane();
			jTabbedPane3.setTabPlacement(JTabbedPane.LEFT);
			jTabbedPane3.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent evt) {
					jTabbedPane3StateChanged(evt);
				}
			});
			jTabbedPane3.addTab("Symbol", null, getJPanel8(), null);
			jTabbedPane3.addTab("Function", null, getJPanel15(), null);
			jTabbedPane3.addTab("Archive file", null, getJPanel17(), null);
			jTabbedPane3.addTab("Code", null, getJPanel2(), null);
			jTabbedPane3.addTab("Parsed func", null, getJPanel19(), null);
			jTabbedPane3.addTab("Dwarf", null, getJPanel21(), null);
		}
		return jTabbedPane3;
	}

	private JScrollPane getJScrollPane6() {
		if (jScrollPane6 == null) {
			jScrollPane6 = new JScrollPane();
			jScrollPane6.setViewportView(getJFunctionTable());
		}
		return jScrollPane6;
	}

	private JScrollPane getSymbol() {
		if (Symbol == null) {
			Symbol = new JScrollPane();
			Symbol.setViewportView(getJSymbolTable());
		}
		return Symbol;
	}

	private JScrollPane getJScrollPane7() {
		if (jScrollPane7 == null) {
			jScrollPane7 = new JScrollPane();
			jScrollPane7.setViewportView(getJArchiveFileTable());
		}
		return jScrollPane7;
	}

	private JScrollPane getJScrollPane8() {
		if (jScrollPane8 == null) {
			jScrollPane8 = new JScrollPane();
			jScrollPane8.setViewportView(getJCodeTable());
		}
		return jScrollPane8;
	}

	private JScrollPane getJScrollPane9() {
		if (jScrollPane9 == null) {
			jScrollPane9 = new JScrollPane();
			jScrollPane9.setViewportView(getJParsedFunctionTable());
		}
		return jScrollPane9;
	}

	private JTable getJSymbolTable() {
		if (jSymbolTable == null) {
			jSymbolTable = new JTable();
			jSymbolTable.setModel(new SymbolTableModel());
			jSymbolTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jSymbolTable.getColumnModel().getColumn(0).setPreferredWidth(400);
			jSymbolTable.getColumnModel().getColumn(1).setPreferredWidth(160);
			jSymbolTable.getColumnModel().getColumn(3).setPreferredWidth(120);
			jSymbolTable.getColumnModel().getColumn(5).setPreferredWidth(400);
		}
		return jSymbolTable;
	}

	private JTable getJFunctionTable() {
		if (jFunctionTable == null) {
			jFunctionTable = new JTable();
			jFunctionTable.setModel(new FunctionTableModel());
			jFunctionTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jFunctionTable.getColumnModel().getColumn(0).setPreferredWidth(400);
			jFunctionTable.getColumnModel().getColumn(3).setPreferredWidth(250);
			jFunctionTable.getColumnModel().getColumn(4).setPreferredWidth(250);
		}
		return jFunctionTable;
	}

	private JTable getJArchiveFileTable() {
		if (jArchiveFileTable == null) {
			jArchiveFileTable = new JTable();
			jArchiveFileTable.setModel(new ArchiveFileTableModel());
			jArchiveFileTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jArchiveFileTable.getColumnModel().getColumn(0).setPreferredWidth(600);
		}
		return jArchiveFileTable;
	}

	private JTable getJCodeTable() {
		if (jCodeTable == null) {
			jCodeTable = new JTable();
			jCodeTable.setModel(new CodeTableModel());
			jCodeTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jCodeTable.getColumnModel().getColumn(0).setPreferredWidth(100);
			jCodeTable.getColumnModel().getColumn(1).setPreferredWidth(400);
			jCodeTable.getColumnModel().getColumn(2).setPreferredWidth(300);
			jCodeTable.getColumnModel().getColumn(3).setPreferredWidth(300);
			jCodeTable.getColumnModel().getColumn(4).setPreferredWidth(100);
			jCodeTable.getColumnModel().getColumn(5).setPreferredWidth(150);
		}
		return jCodeTable;
	}

	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			BorderLayout jPanel2Layout = new BorderLayout();
			jPanel2.setLayout(jPanel2Layout);
			jPanel2.setPreferredSize(new java.awt.Dimension(542, 467));
			jPanel2.add(getJScrollPane8(), BorderLayout.CENTER);
			jPanel2.add(getJPanel5(), BorderLayout.NORTH);
		}
		return jPanel2;
	}

	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jPanel5 = new JPanel();
			FlowLayout jPanel5Layout = new FlowLayout();
			jPanel5Layout.setAlignment(FlowLayout.LEFT);
			jPanel5.setLayout(jPanel5Layout);
			jPanel5.add(getJRefreshCodeButton());
		}
		return jPanel5;
	}

	private JButton getJRefreshCodeButton() {
		if (jRefreshCodeButton == null) {
			jRefreshCodeButton = new JButton();
			jRefreshCodeButton.setText("Refresh");
			jRefreshCodeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRefreshCodeButtonActionPerformed(evt);
				}
			});
		}
		return jRefreshCodeButton;
	}

	private void jRefreshCodeButtonActionPerformed(ActionEvent evt) {
		if (jCodeTable != null) {
			((CodeTableModel) jCodeTable.getModel()).fireTableDataChanged();
		}
	}

	private void jTabbedPane3StateChanged(ChangeEvent evt) {
		jRefreshCodeButtonActionPerformed(null);
	}

	private JPanel getJPanel8() {
		if (jPanel8 == null) {
			jPanel8 = new JPanel();
			BorderLayout jPanel8Layout = new BorderLayout();
			jPanel8.setLayout(jPanel8Layout);
			jPanel8.setPreferredSize(new java.awt.Dimension(542, 467));
			jPanel8.add(getSymbol(), BorderLayout.CENTER);
			jPanel8.add(getJPanel9(), BorderLayout.NORTH);
		}
		return jPanel8;
	}

	private JPanel getJPanel9() {
		if (jPanel9 == null) {
			jPanel9 = new JPanel();
			FlowLayout jPanel9Layout1 = new FlowLayout();
			jPanel9Layout1.setAlignment(FlowLayout.LEFT);
			jPanel9.setLayout(jPanel9Layout1);
			jPanel9.add(getJRefreshSymbolButton());
			jPanel9.add(getJSearchSymbolTextField());
		}
		return jPanel9;
	}

	private JButton getJRefreshSymbolButton() {
		if (jRefreshSymbolButton == null) {
			jRefreshSymbolButton = new JButton();
			jRefreshSymbolButton.setText("Refresh");
			jRefreshSymbolButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRefreshSymbolButtonActionPerformed(evt);
				}
			});
		}
		return jRefreshSymbolButton;
	}

	private JPanel getJPanel15() {
		if (jPanel15 == null) {
			jPanel15 = new JPanel();
			BorderLayout jPanel15Layout = new BorderLayout();
			jPanel15.setLayout(jPanel15Layout);
			jPanel15.setPreferredSize(new java.awt.Dimension(542, 467));
			jPanel15.add(getJScrollPane6(), BorderLayout.CENTER);
			jPanel15.add(getJPanel16(), BorderLayout.NORTH);
		}
		return jPanel15;
	}

	private JPanel getJPanel16() {
		if (jPanel16 == null) {
			jPanel16 = new JPanel();
			FlowLayout jPanel16Layout = new FlowLayout();
			jPanel16Layout.setAlignment(FlowLayout.LEFT);
			jPanel16.setLayout(jPanel16Layout);
			jPanel16.add(getJRefreshFunctionButton());
			jPanel16.add(getJSearchFunctionTextField());
		}
		return jPanel16;
	}

	private JButton getJRefreshFunctionButton() {
		if (jRefreshFunctionButton == null) {
			jRefreshFunctionButton = new JButton();
			jRefreshFunctionButton.setText("Refresh");
			jRefreshFunctionButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRefreshFunctionButtonActionPerformed(evt);
				}
			});
		}
		return jRefreshFunctionButton;
	}

	private JPanel getJPanel17() {
		if (jPanel17 == null) {
			jPanel17 = new JPanel();
			BorderLayout jPanel17Layout = new BorderLayout();
			jPanel17.setLayout(jPanel17Layout);
			jPanel17.setPreferredSize(new java.awt.Dimension(542, 467));
			jPanel17.add(getJScrollPane7(), BorderLayout.CENTER);
			jPanel17.add(getJPanel18(), BorderLayout.NORTH);
		}
		return jPanel17;
	}

	private JPanel getJPanel18() {
		if (jPanel18 == null) {
			jPanel18 = new JPanel();
			FlowLayout jPanel18Layout = new FlowLayout();
			jPanel18Layout.setAlignment(FlowLayout.LEFT);
			jPanel18.setLayout(jPanel18Layout);
			jPanel18.add(getJRefreshArchiveFileButton());
		}
		return jPanel18;
	}

	private JButton getJRefreshArchiveFileButton() {
		if (jRefreshArchiveFileButton == null) {
			jRefreshArchiveFileButton = new JButton();
			jRefreshArchiveFileButton.setText("Refresh");
			jRefreshArchiveFileButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRefreshArchiveFileButtonActionPerformed(evt);
				}
			});
		}
		return jRefreshArchiveFileButton;
	}

	private void jRefreshSymbolButtonActionPerformed(ActionEvent evt) {
		((SymbolTableModel) this.jSymbolTable.getModel()).reload();
	}

	private void jRefreshFunctionButtonActionPerformed(ActionEvent evt) {
		((FunctionTableModel) this.jFunctionTable.getModel()).reload();
	}

	private void jRefreshArchiveFileButtonActionPerformed(ActionEvent evt) {
		((ArchiveFileTableModel) this.jArchiveFileTable.getModel()).fireTableDataChanged();
	}

	private void jRefreshParsedFunctionButtonActionPerformed(ActionEvent evt) {
		((ParsedFunctionTableModel) this.jParsedFunctionTable.getModel()).fireTableDataChanged();
	}

	private JTable getJParsedFunctionTable() {
		if (jParsedFunctionTable == null) {
			jParsedFunctionTable = new JTable();
			jParsedFunctionTable.setModel(new ParsedFunctionTableModel());
		}
		return jParsedFunctionTable;
	}

	private JPanel getJPanel19() {
		if (jPanel19 == null) {
			jPanel19 = new JPanel();
			BorderLayout jPanel19Layout = new BorderLayout();
			jPanel19.setLayout(jPanel19Layout);
			jPanel19.setPreferredSize(new java.awt.Dimension(542, 467));
			jPanel19.add(getJScrollPane9(), BorderLayout.CENTER);
			jPanel19.add(getJPanel20(), BorderLayout.NORTH);
		}
		return jPanel19;
	}

	private JPanel getJPanel20() {
		if (jPanel20 == null) {
			jPanel20 = new JPanel();
			FlowLayout jPanel20Layout = new FlowLayout();
			jPanel20Layout.setAlignment(FlowLayout.LEFT);
			jPanel20.setLayout(jPanel20Layout);
			jPanel20.add(getJRefreshParsedFunctionButton());
		}
		return jPanel20;
	}

	private JButton getJRefreshParsedFunctionButton() {
		if (jRefreshParsedFunctionButton == null) {
			jRefreshParsedFunctionButton = new JButton();
			jRefreshParsedFunctionButton.setText("Refresh");
			jRefreshParsedFunctionButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRefreshParsedFunctionButtonActionPerformed(evt);
				}
			});
		}
		return jRefreshParsedFunctionButton;
	}

	private JSearchTextField getJSearchSymbolTextField() {
		if (jSearchSymbolTextField == null) {
			jSearchSymbolTextField = new JSearchTextField();
			jSearchSymbolTextField.setPreferredSize(new java.awt.Dimension(152, 25));
			jSearchSymbolTextField.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					jSearchSymbolTextFieldKeyReleased(evt);
				}
			});
		}
		return jSearchSymbolTextField;
	}

	private void jSearchSymbolTextFieldKeyReleased(KeyEvent evt) {
		SymbolTableModel model = (SymbolTableModel) jSymbolTable.getModel();
		model.setSearchPattern(jSearchSymbolTextField.getText());
		model.fireTableDataChanged();
	}

	private JPanel getJPanel21() {
		if (jPanel21 == null) {
			jPanel21 = new JPanel();
			BorderLayout jPanel21Layout = new BorderLayout();
			jPanel21.setLayout(jPanel21Layout);
			jPanel21.add(getJScrollPane10(), BorderLayout.CENTER);
			jPanel21.add(getJPanel22(), BorderLayout.NORTH);
		}
		return jPanel21;
	}

	private JScrollPane getJScrollPane10() {
		if (jScrollPane10 == null) {
			jScrollPane10 = new JScrollPane();
			jScrollPane10.setViewportView(getJDwarfTable());
		}
		return jScrollPane10;
	}

	private JTable getJDwarfTable() {
		if (jDwarfTable == null) {
			jDwarfTable = new JTable();
			jDwarfTable.setModel(new DwarfTableModel());
			jDwarfTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jDwarfTable.getColumnModel().getColumn(0).setPreferredWidth(400);
			jDwarfTable.getColumnModel().getColumn(2).setPreferredWidth(100);
			jDwarfTable.getColumnModel().getColumn(3).setPreferredWidth(200);
		}
		return jDwarfTable;
	}

	private JPanel getJPanel22() {
		if (jPanel22 == null) {
			jPanel22 = new JPanel();
			FlowLayout jPanel22Layout = new FlowLayout();
			jPanel22Layout.setAlignment(FlowLayout.LEFT);
			jPanel22.setLayout(jPanel22Layout);
			jPanel22.add(getJRefreshDwarfTableButton());
			jPanel22.add(getJSearchDwarfTextField());
			jPanel22.add(getJDwarfComboBox());
		}
		return jPanel22;
	}

	private JButton getJRefreshDwarfTableButton() {
		if (jRefreshDwarfTableButton == null) {
			jRefreshDwarfTableButton = new JButton();
			jRefreshDwarfTableButton.setText("Refresh");
			jRefreshDwarfTableButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRefreshDwarfTableButtonActionPerformed(evt);
				}
			});
		}
		return jRefreshDwarfTableButton;
	}

	private void jRefreshDwarfTableButtonActionPerformed(ActionEvent evt) {
		((DwarfTableModel) jDwarfTable.getModel()).fireTableDataChanged();
		for (File file : MapStructure.dwarfLines.keySet()) {
			jDwarfComboBox.addItem(file);
		}
	}

	private JComboBox getJDwarfComboBox() {
		if (jDwarfComboBox == null) {
			jDwarfComboBox = new JComboBox();
			jDwarfComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jDwarfComboBoxActionPerformed(evt);
				}
			});
		}
		return jDwarfComboBox;
	}

	private void jDwarfComboBoxActionPerformed(ActionEvent evt) {
		DwarfTableModel model = (DwarfTableModel) jDwarfTable.getModel();
		model.archiveFile = (File) jDwarfComboBox.getSelectedItem();
		model.setSearchPattern(null);
	}

	private JCheckBox getJExactMatchCheckBox() {
		if (jExactMatchCheckBox == null) {
			jExactMatchCheckBox = new JCheckBox();
			jExactMatchCheckBox.setText("exact");
			jExactMatchCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jExactMatchCheckBoxActionPerformed(evt);
				}
			});
		}
		return jExactMatchCheckBox;
	}

	private void jExactMatchCheckBoxActionPerformed(ActionEvent evt) {
		jSearchProjectTextFieldKeyReleased(null);
	}

	private JTextField getJSearchDwarfTextField() {
		if (jSearchDwarfTextField == null) {
			jSearchDwarfTextField = new JSearchTextField();
			jSearchDwarfTextField.setPreferredSize(new java.awt.Dimension(149, 22));
			jSearchDwarfTextField.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					jSearchDwarfTextFieldKeyReleased(evt);
				}
			});
		}
		return jSearchDwarfTextField;
	}

	private void jSearchDwarfTextFieldKeyReleased(KeyEvent evt) {
		DwarfTableModel model = (DwarfTableModel) jDwarfTable.getModel();
		model.setSearchPattern(jSearchDwarfTextField.getText());
	}

	private JSearchTextField getJSearchFunctionTextField() {
		if (jSearchFunctionTextField == null) {
			jSearchFunctionTextField = new JSearchTextField();
			jSearchFunctionTextField.setPreferredSize(new java.awt.Dimension(152, 25));
			jSearchFunctionTextField.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					jSearchFunctionTextFieldKeyReleased(evt);
				}
			});
		}
		return jSearchFunctionTextField;
	}

	private void jSearchFunctionTextFieldKeyReleased(KeyEvent evt) {
		FunctionTableModel model = (FunctionTableModel) jFunctionTable.getModel();
		model.setSearchPattern(jSearchFunctionTextField.getText());
	}

	private JScrollPane getJScrollPane11() {
		if (jScrollPane11 == null) {
			jScrollPane11 = new JScrollPane();
			jScrollPane11.setViewportView(getJAllFunctionsTable());
		}
		return jScrollPane11;
	}

	private JTable getJAllFunctionsTable() {
		if (jAllFunctionsTable == null) {
			jAllFunctionsTable = new JTable();
			jAllFunctionsTable.setModel(new AllFunctionsTableModel());
			jAllFunctionsTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					jAllFunctionsTableMouseClicked(evt);
				}
			});
		}
		return jAllFunctionsTable;
	}

	private JToolBar getJToolBar1() {
		if (jToolBar1 == null) {
			jToolBar1 = new JToolBar();
			jToolBar1.add(getJSearchAllFunctionsTextField());
			jToolBar1.add(getJAllFunctionsExactCheckBox());
		}
		return jToolBar1;
	}

	private JSearchTextField getJSearchAllFunctionsTextField() {
		if (jSearchAllFunctionsTextField == null) {
			jSearchAllFunctionsTextField = new JSearchTextField();
			jSearchAllFunctionsTextField.setText("");
			jSearchAllFunctionsTextField.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					jSearchAllFunctionsTextFieldKeyReleased(evt);
				}
			});
		}
		return jSearchAllFunctionsTextField;
	}

	private JCheckBox getJAllFunctionsExactCheckBox() {
		if (jAllFunctionsExactCheckBox == null) {
			jAllFunctionsExactCheckBox = new JCheckBox();
			jAllFunctionsExactCheckBox.setText("exact");
			jAllFunctionsExactCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jAllFunctionsExactCheckBoxActionPerformed(evt);
				}
			});
		}
		return jAllFunctionsExactCheckBox;
	}

	private void jSearchAllFunctionsTextFieldKeyReleased(KeyEvent evt) {
		if (jSearchAllFunctionsTextField.getText() != null) {
			AllFunctionsTableModel model = (AllFunctionsTableModel) jAllFunctionsTable.getModel();
			model.setSearchPattern(jSearchAllFunctionsTextField.getText(), jAllFunctionsExactCheckBox.isSelected());
		}
	}

	private void jAllFunctionsExactCheckBoxActionPerformed(ActionEvent evt) {
		jSearchAllFunctionsTextFieldKeyReleased(null);
	}

	private void jTabbedPane1StateChanged(ChangeEvent evt) {
		JTabbedPane pane = (JTabbedPane) evt.getSource();

		// Get current tab
		int sel = pane.getSelectedIndex();

		if (sel == 1) {
			AllFunctionsTableModel model = (AllFunctionsTableModel) jAllFunctionsTable.getModel();
			model.reload();
		}
	}

	private void jAllFunctionsTableMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			String str = (String) jAllFunctionsTable.getValueAt(jAllFunctionsTable.getSelectedRow(), 0);
			if (str != null && str.contains("0x")) {
				long address = CommonLib.string2decimal("0x" + str.split("0x")[1]);

				jInstructionComboBox.setSelectedItem("0x" + Long.toHexString(address));
				jMainTabbedPane.setSelectedIndex(0);
			}
		}
	}

	private JLabel getJErrorLabel() {
		if (jErrorLabel == null) {
			jErrorLabel = new JLabel();
			jErrorLabel.setText("<html>Source level debug is disabled before you load the map file,<br>by clicking menu \"system\" -> \"load map file\"</html>");
			jErrorLabel.setBackground(new java.awt.Color(0, 0, 0, 200));
			jErrorLabel.setForeground(new java.awt.Color(255, 255, 255));
			jErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
			jErrorLabel.setFont(new java.awt.Font("Dialog", 0, 26));
			jErrorLabel.setOpaque(true);
		}
		return jErrorLabel;
	}
}
