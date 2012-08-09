package com.peterbochs.sourceleveldebugger;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.math.BigInteger;
import java.util.TreeSet;

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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.TreePath;

import com.peterbochs.Global;
import com.peterbochs.InstructionTableCellRenderer;
import com.peterbochs.InstructionTableModel;
import com.peterbochs.MyLanguage;
import com.peterbochs.PeterBochsCommonLib;
import com.peterbochs.PeterBochsDebugger;
import com.peterbochs.Setting;
import com.peterdwarf.dwarf.Dwarf;
import com.peterdwarf.dwarf.DwarfDebugLineHeader;
import com.peterdwarf.dwarf.DwarfHeaderFilename;
import com.peterdwarf.elf.Elf32_Sym;
import com.peterdwarf.gui.PeterDwarfPanel;
import com.peterswing.CommonLib;
import com.peterswing.advancedswing.jmaximizabletabbedpane.JMaximizableTabbedPane;
import com.peterswing.advancedswing.jmaximizabletabbedpane.JMaximizableTabbedPane_BasePanel;
import com.peterswing.advancedswing.jprogressbardialog.JProgressBarDialogEventListener;
import com.peterswing.advancedswing.onoffbutton.OnOffButton;
import com.peterswing.advancedswing.searchtextfield.JSearchTextField;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN ANY
 * CORPORATE OR COMMERCIAL PURPOSE.
 */
public class SourceLevelDebugger3 extends JMaximizableTabbedPane_BasePanel implements JProgressBarDialogEventListener {
	private JSplitPane jMainSplitPane;
	private JPanel jPanel1;
	private JPanel jPanel6;
	private JSplitPane jSplitPane3;
	private JPanel jPanel4;
	private JScrollPane jScrollPane1;
	private JButton disassembleCSEIPButton;
	private JButton disassembleButton;
	private JComboBox jInstructionComboBox;
	public JScrollPane registerPanelScrollPane;
	private JTabbedPane jInfoTabbedPane;
	public JTable instructionTable;
	private JScrollPane instructionTableScrollPane;
	private JButton jExcelButton;
	private JButton jDiskButton;
	private JButton jInstructionDownButton;
	private JButton jInstructionUpButton;
	private JButton jInstructionUpTenButton;
	private JPanel jDwarfPanel;
	public PeterDwarfPanel peterDwarfPanel;
	private JPanel jInstructionControlPanel;
	private JPanel jASMPanel;
	private JPanel symbolTablePanel;
	private JSearchTextField jSearchProjectTextField;
	private JToolBar jProjectToolBar;
	private JMaximizableTabbedPane jMainTabbedPane;
	private JTree projectTree;
	private JPanel jPanel3;
	private JMaximizableTabbedPane jTabbedPane1;
	private JPopupMenu jCppPopupMenu;
	private JMenuItem jShowMeTheCodeMenuItem;

	private PeterBochsDebugger peterBochsDebugger;
	private File elfFile;
	private ProjectTreeNode root;
	private JLabel jErrorLabel;
	private JCheckBox symbolExactCheckBox;
	private JSearchTextField jSearchTextField;
	private JSearchTextField jSearchSymbolTextField;
	private JToolBar jToolBar1;
	private JTable symbolTable;
	private JScrollPane jScrollPane11;
	private JCheckBox jExactMatchCheckBox;

	ProjectFilterTreeModel projectFilterTreeModel = new ProjectFilterTreeModel(new ProjectTreeModel(null));
	SymbolTableModel symbolTableModel = new SymbolTableModel();
	private JButton btnSearch;
	private OnOffButton onOffButton;

	public SourceLevelDebugger3(PeterBochsDebugger peterBochsDebugger) {
		this.peterBochsDebugger = peterBochsDebugger;
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(975, 563));
			{
				jMainSplitPane = new JSplitPane();
				this.add(getJErrorLabel(), "errorLabel");
				this.add(jMainSplitPane, "MAIN");
				jMainSplitPane.setDividerLocation(200);
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
							jSplitPane3.add(jPanel6, JSplitPane.TOP);
							jSplitPane3.add(getJInfoTabbedPane(), JSplitPane.BOTTOM);
							BorderLayout jPanel6Layout = new BorderLayout();
							jPanel6.setLayout(jPanel6Layout);
							{
								jMainTabbedPane = new JMaximizableTabbedPane();
								jPanel6.add(jMainTabbedPane, BorderLayout.CENTER);
								{
									jASMPanel = new JPanel();
									jMainTabbedPane.addTab(MyLanguage.getString("ASM/C"), null, jASMPanel, null);
									jMainTabbedPane.addTab("Dwarf", null, getJDwarfPanel(), null);
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
											disassembleButton = new JButton();
											jInstructionControlPanel.add(disassembleButton);
											disassembleButton.setText(MyLanguage.getString("Disassemble"));
											disassembleButton.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent evt) {
													disassembleButtonActionPerformed(evt);
												}
											});
										}
										{
											disassembleCSEIPButton = new JButton();
											jInstructionControlPanel.add(disassembleCSEIPButton);
											disassembleCSEIPButton.setText(MyLanguage.getString("Disassemble") + " cs:eip");
											disassembleCSEIPButton.setEnabled(true);
											disassembleCSEIPButton.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent evt) {
													disassembleCSEIPButtonActionPerformed(evt);
												}
											});
										}
										{
											jInstructionUpTenButton = new JButton();
											jInstructionControlPanel.add(jInstructionUpTenButton);
											jInstructionUpTenButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
													"com/peterbochs/icons/famfam_icons/arrow_up10.png")));
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
											jInstructionDownButton.setIcon(new ImageIcon(getClass().getClassLoader()
													.getResource("com/peterbochs/icons/famfam_icons/arrow_down.png")));
											jInstructionDownButton.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent evt) {
													jInstructionDownButtonActionPerformed(evt);
												}
											});
										}
										{
											jDiskButton = new JButton();
											jInstructionControlPanel.add(jDiskButton);
											jDiskButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/disk.png")));
											jDiskButton.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent evt) {
													jButton3ActionPerformed(evt);
												}
											});
										}
										{
											jExcelButton = new JButton();
											jInstructionControlPanel.add(jExcelButton);
											jInstructionControlPanel.add(getJSearchTextField());
											jExcelButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/excel.gif")));
											{
												btnSearch = new JButton("Search");
												jInstructionControlPanel.add(btnSearch);
											}
											{
												onOffButton = new OnOffButton();
												onOffButton.setSelected(true);
												onOffButton.addItemListener(new ItemListener() {
													public void itemStateChanged(ItemEvent e) {
														InstructionTableModel model = (InstructionTableModel) PeterBochsDebugger.instructionTable.getModel();
														if (e.getStateChange() == ItemEvent.SELECTED) {
															model.showSourceLevel = true;
														} else {
															model.showSourceLevel = false;
														}
														model.fireTableDataChanged();
													}
												});
												onOffButton.setPreferredSize(new Dimension(53, 18));
												jInstructionControlPanel.add(onOffButton);
											}
											jExcelButton.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent evt) {
													jButton12ActionPerformed(evt);
												}
											});
										}
									}
									{
										instructionTableScrollPane = new JScrollPane();
										instructionTableScrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
											boolean isRunning;

											public void adjustmentValueChanged(AdjustmentEvent evt) {
												/*	JScrollBar vbar = (JScrollBar) evt.getSource();

													if (evt.getValueIsAdjusting()) {
														return;
													}
													if ((vbar.getValue() + vbar.getVisibleAmount()) == vbar.getMaximum()) {
														if (!isRunning) {
															try {
																isRunning = true;
																final CardLayout cl = (CardLayout) (peterBochsDebugger.jMainPanel.getLayout());
																cl.show(peterBochsDebugger.jMainPanel, "Running Label");
																//															new Thread("update instruction thread") {
																//																public void run() {
																//																	long address = Long.parseLong(instructionTable.getValueAt(instructionTable.getRowCount() - 1, 1).toString()
																//																			.substring(2), 16);
																//																	peterBochsDebugger.updateInstruction(address, true);
																//																	peterBochsDebugger.updateBreakpointTableColor();
																////																	cl.show(peterBochsDebugger.jMainPanel, peterBochsDebugger.currentPanel);
																//
																//																	isRunning = false;
																//																}
																//															}.start();

															} catch (Exception ex) {
															}
														}

													}*/
											}

										});
										jASMPanel.add(instructionTableScrollPane, BorderLayout.CENTER);
										{
											instructionTable = new JTable();
											instructionTableScrollPane.setViewportView(instructionTable);
											instructionTable.setModel(PeterBochsDebugger.instructionTable.getModel());
											instructionTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
											instructionTable.getTableHeader().setReorderingAllowed(false);
											instructionTable.getColumnModel().getColumn(0).setMaxWidth(20);
											instructionTable.getColumnModel().getColumn(1).setPreferredWidth(40);
											instructionTable.getColumnModel().getColumn(2).setPreferredWidth(200);
											instructionTable.getColumnModel().getColumn(3).setPreferredWidth(40);
											instructionTable.setShowGrid(false);
											instructionTable.setDefaultRenderer(String.class, new InstructionTableCellRenderer());
											instructionTable.addMouseListener(new MouseAdapter() {
												public void mouseClicked(MouseEvent evt) {
													jAssemblyTableMouseClicked(evt);
												}
											});
										}
									}
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
							jTabbedPane1.addTab("Symbol", null, getSymbolTablePanel(), null);
							{
								jScrollPane1 = new JScrollPane();
								jPanel3.add(jScrollPane1, BorderLayout.CENTER);
								jPanel3.add(getJProjectToolBar(), BorderLayout.NORTH);
								{
									projectTree = new JTree();
									jScrollPane1.setViewportView(projectTree);
									projectTree.setModel(projectFilterTreeModel);
									projectTree.setShowsRootHandles(true);
									projectTree.setCellRenderer(new ProjectTreeRenderer());
									projectTree.addMouseListener(new MouseAdapter() {
										public void mouseClicked(MouseEvent evt) {
											projectTreeMouseClicked(evt);
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

	private void projectTreeMouseClicked(MouseEvent evt) {

		//				* handleProjectTreeClick(jFileTree.getSelectionPath());
	}

	void handleProjectTreeClick(TreePath treePath) {
		/*
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
		*/
	}

	private void jInstructionComboBoxActionPerformed(ActionEvent evt) {
		disassembleButtonActionPerformed(evt);
	}

	private void disassembleButtonActionPerformed(ActionEvent evt) {
		this.addInstructionComboBox(this.jInstructionComboBox.getSelectedItem().toString());
		disassembleCSEIPButton.setEnabled(false);
		try {
			peterBochsDebugger.updateInstruction(CommonLib.string2decimal(this.jInstructionComboBox.getSelectedItem().toString()), false);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		peterBochsDebugger.updateBreakpointTableColor();
		disassembleCSEIPButton.setEnabled(true);
	}

	private void addInstructionComboBox(String str) {
		for (int x = 0; x < jInstructionComboBox.getItemCount(); x++) {
			if (this.jInstructionComboBox.getItemAt(x).toString().trim().equals(str.trim())) {
				return;
			}
		}

		jInstructionComboBox.addItem(str.trim());
	}

	private void disassembleCSEIPButtonActionPerformed(ActionEvent evt) {
		disassembleCSEIPButton.setEnabled(false);
		peterBochsDebugger.updateInstruction(null, false);
		peterBochsDebugger.updateBreakpointTableColor();
		disassembleCSEIPButton.setEnabled(true);
	}

	private void jInstructionUpTenButtonActionPerformed(ActionEvent evt) {
		peterBochsDebugger.jInstructionUpTenButtonActionPerformed(evt);
	}

	private void jInstructionUpButtonActionPerformed(ActionEvent evt) {
		peterBochsDebugger.jInstructionUpButtonActionPerformed(evt);
	}

	private void jInstructionDownButtonActionPerformed(ActionEvent evt) {
		peterBochsDebugger.jInstructionDownButtonActionPerformed(evt);
	}

	private void jButton3ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!PeterBochsCommonLib.saveImage(instructionTable, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void jButton12ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			PeterBochsCommonLib.exportTableModelToExcel(file, this.instructionTable.getModel(), "instruction 0x" + this.jInstructionComboBox.getSelectedItem().toString());
		}
	}

	private void jAssemblyTableMouseClicked(MouseEvent evt) {
		peterBochsDebugger.jInstructionTableMouseClicked(evt);
	}

	public void loadELF(final File file) {
		//$hide>>$
		if (Global.debug) {
			System.out.println("load elf");
		}

		if (!file.isFile()) {
			JOptionPane.showMessageDialog(this, elfFile.getAbsolutePath() + " is not a file !!!");
			return;
		} else if (!file.exists()) {
			JOptionPane.showMessageDialog(this, elfFile.getAbsolutePath() + " not exist !!!");
			return;
		}

		this.elfFile = file;
		peterBochsDebugger.enableAllButtons(false, false);
		peterDwarfPanel.init(file);
		peterBochsDebugger.jShowInSourceCodeMenuItem.setEnabled(true);
		peterBochsDebugger.jWhereIsHereMenuItem.setEnabled(true);
		peterBochsDebugger.jSourceLevelDebuggerToggleButtonActionPerformed(null);
		com.peterswing.CommonLib.expandAll(projectTree, true);

		initProjectTree();
		initSymbolTable();

		jErrorLabel.setVisible(false);
		show("MAIN");
		peterBochsDebugger.enableAllButtons(true, false);

		if (Global.debug) {
			System.out.println("load elf end");
		}
		//$hide<<$
	}

	private void initProjectTree() {
		//$hide>>$
		if (Global.debug) {
			System.out.println("--initProjectTree");
		}

		root = new ProjectTreeNode(elfFile);
		((ProjectFilterTreeModel) projectTree.getModel()).setRoot(root);

		TreeSet<File> allSourceFiles = new TreeSet<File>();
		for (Dwarf dwarf : peterDwarfPanel.dwarfs) {
			for (DwarfDebugLineHeader header : dwarf.headers) {
				for (DwarfHeaderFilename filename : header.filenames) {
					allSourceFiles.add(filename.file);
				}
			}
		}
		for (File file : allSourceFiles) {
			ProjectTreeNode subnode = new ProjectTreeNode(file);
			root.children.add(subnode);
		}
		((ProjectFilterTreeModel) projectTree.getModel()).reload();

		if (Global.debug) {
			System.out.println("--initProjectTree end");
		}
		//$hide<<$
	}

	private void initSymbolTable() {
		//$hide>>$
		if (Global.debug) {
			System.out.println("--initSymbolTable");
		}

		TreeSet<Elf32_Sym> allSymbols = new TreeSet<Elf32_Sym>();
		for (Dwarf dwarf : peterDwarfPanel.dwarfs) {
			for (Elf32_Sym symbol : dwarf.symbols) {
				allSymbols.add(symbol);
			}
		}
		symbolTableModel.symbols = allSymbols;
		symbolTableModel.fireTableDataChanged();

		if (Global.debug) {
			System.out.println("--initSymbolTable end");
		}
		//$hide<<$
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

			loadELF(file);
		}
	}

	private void initMemoryMap() {
		if (Global.debug) {
			System.out.println("--initMemoryMap");
		}
		if (Global.debug) {
			System.out.println("--initMemoryMap end");
		}
	}

	@Override
	public void cancelled() {
		projectTree.setEnabled(true);
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

	private JPanel getSymbolTablePanel() {
		if (symbolTablePanel == null) {
			symbolTablePanel = new JPanel();
			BorderLayout jFunctionListPanelLayout = new BorderLayout();
			symbolTablePanel.setLayout(jFunctionListPanelLayout);
			symbolTablePanel.add(getJScrollPane11(), BorderLayout.CENTER);
			symbolTablePanel.add(getJToolBar1(), BorderLayout.NORTH);
		}
		return symbolTablePanel;
	}

	private void jSearchProjectTextFieldKeyReleased(KeyEvent evt) {
		if (jSearchProjectTextField.getText() != null) {
			projectFilterTreeModel.filter = jSearchProjectTextField.getText();
			projectFilterTreeModel.reload();
			CommonLib.expandAll(projectTree, true);
		}
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
		projectFilterTreeModel.exactMatch = jExactMatchCheckBox.isSelected();
		jSearchProjectTextFieldKeyReleased(null);
	}

	private JScrollPane getJScrollPane11() {
		if (jScrollPane11 == null) {
			jScrollPane11 = new JScrollPane();
			jScrollPane11.setViewportView(getSymbolTable());
		}
		return jScrollPane11;
	}

	private JTable getSymbolTable() {
		if (symbolTable == null) {
			symbolTable = new JTable() {
				public String getToolTipText(MouseEvent event) {
					Point p = event.getPoint();
					int row = rowAtPoint(p);
					int col = columnAtPoint(p);
					if (row == -1 || col == -1) {
						return null;
					}
					Elf32_Sym symbol = (Elf32_Sym) getValueAt(row, col);
					String str = "<html><table>";
					str += "<tr><td>name</td><td>:</td><td>" + symbol.name + "</td></tr>";
					str += "<tr><td>st_name</td><td>:</td><td>" + symbol.st_name + "</td></tr>";
					str += "<tr><td>st_value</td><td>:</td><td>" + symbol.st_value + "</td></tr>";
					str += "<tr><td>st_size</td><td>:</td><td>" + symbol.st_size + "</td></tr>";
					str += "<tr><td>st_info</td><td>:</td><td>" + symbol.st_info + "</td></tr>";
					str += "<tr><td>st_other</td><td>:</td><td>" + symbol.st_other + "</td></tr>";
					str += "<tr><td>st_shndx</td><td>:</td><td>" + symbol.st_shndx + "</td></tr>";
					str += "</table></html>";
					return str;
				}
			};
			symbolTable.setModel(symbolTableModel);
			symbolTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					symbolTableMouseClicked(evt);
				}
			});
		}
		return symbolTable;
	}

	private JToolBar getJToolBar1() {
		if (jToolBar1 == null) {
			jToolBar1 = new JToolBar();
			jToolBar1.add(getSearchSymbolTextField());
			jToolBar1.add(getSymbolExactCheckBox());
		}
		return jToolBar1;
	}

	private JSearchTextField getSearchSymbolTextField() {
		if (jSearchSymbolTextField == null) {
			jSearchSymbolTextField = new JSearchTextField();
			jSearchSymbolTextField.setText("");
			jSearchSymbolTextField.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					searchSymbolTextFieldKeyReleased(evt);
				}
			});
		}
		return jSearchSymbolTextField;
	}

	private JCheckBox getSymbolExactCheckBox() {
		if (symbolExactCheckBox == null) {
			symbolExactCheckBox = new JCheckBox();
			symbolExactCheckBox.setText("exact");
			symbolExactCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					symbolExactCheckBoxActionPerformed(evt);
				}
			});
		}
		return symbolExactCheckBox;
	}

	private void searchSymbolTextFieldKeyReleased(KeyEvent evt) {
		if (jSearchSymbolTextField.getText() != null) {
			symbolTableModel.setSearchPattern(jSearchSymbolTextField.getText());
		}
	}

	private void symbolExactCheckBoxActionPerformed(ActionEvent evt) {
		symbolTableModel.exactMatch = symbolExactCheckBox.isSelected();
		searchSymbolTextFieldKeyReleased(null);
	}

	private void jTabbedPane1StateChanged(ChangeEvent evt) {
		JTabbedPane pane = (JTabbedPane) evt.getSource();

		// Get current tab
		int sel = pane.getSelectedIndex();

		if (sel == 1) {
			symbolTableModel.reload();
		}
	}

	private void symbolTableMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			Elf32_Sym symbol = (Elf32_Sym) symbolTable.getValueAt(symbolTable.getSelectedRow(), 0);
			if (symbol != null && symbol.name.contains("0x")) {
				BigInteger address = CommonLib.string2decimal("0x" + symbol.name.split("0x")[1]);

				jInstructionComboBox.setSelectedItem("0x" + address.toString(16));
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

	private JPanel getJDwarfPanel() {
		if (jDwarfPanel == null) {
			jDwarfPanel = new JPanel();
			BorderLayout jDwarfPanelLayout = new BorderLayout();
			jDwarfPanel.setLayout(jDwarfPanelLayout);
			jDwarfPanel.add(getPeterDwarfPanel(), BorderLayout.CENTER);
		}
		return jDwarfPanel;
	}

	private PeterDwarfPanel getPeterDwarfPanel() {
		if (peterDwarfPanel == null) {
			peterDwarfPanel = new PeterDwarfPanel();
		}
		return peterDwarfPanel;
	}

	private JTabbedPane getJInfoTabbedPane() {
		if (jInfoTabbedPane == null) {
			jInfoTabbedPane = new JTabbedPane();
			jInfoTabbedPane.addTab(MyLanguage.getString("Register"), null, getRegisterPanelScrollPane(), null);
		}
		return jInfoTabbedPane;
	}

	private JScrollPane getRegisterPanelScrollPane() {
		if (registerPanelScrollPane == null) {
			registerPanelScrollPane = new JScrollPane();
		}
		return registerPanelScrollPane;
	}

	private JSearchTextField getJSearchTextField() {
		if (jSearchTextField == null) {
			jSearchTextField = new JSearchTextField();
			jSearchTextField.setPreferredSize(new java.awt.Dimension(163, 25));
		}
		return jSearchTextField;
	}
}
