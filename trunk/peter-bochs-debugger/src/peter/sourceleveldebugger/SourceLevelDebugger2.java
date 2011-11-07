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
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.apache.commons.io.FileUtils;

import peter.Application;
import peter.CommonLib;
import peter.JInstructionTableCellRenderer;
import peter.MyLanguage;
import peter.Setting;

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
	private JSplitPane jSplitPane1;
	private JPanel jPanel1;
	private JPanel jPanel8;
	private JMaximizableTabbedPane jTabbedPane2;
	private JPanel jPanel7;
	private JPanel jPanel6;
	private JSplitPane jSplitPane3;
	private JPanel jPanel5;
	private JPanel jPanel4;
	private JSplitPane jSplitPane2;
	private JScrollPane jScrollPane1;
	private JButton jDisassembleButton;
	private JButton jButton14;
	private JComboBox jInstructionComboBox;
	private EnhancedTextArea jMapTextArea;
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
	private JMaximizableTabbedPane jTabbedPane4;
	public JTable jAssemblyTable;
	private JScrollPane jScrollPane3;
	private JButton jButton12;
	private JButton jButton3;
	private JButton jInstructionDownButton;
	private JButton jInstructionUpButton;
	private JButton jInstructionUpTenButton;
	private JTable jLibraryTable;
	private JScrollPane jScrollPane6;
	private JPanel jLibraryPanel;
	private JPanel jInstructionControlPanel;
	private JPanel jASMPanel;
	private EnhancedTextArea cSourceTextArea;
	private JPanel jSourcePanel;
	private JMaximizableTabbedPane jTabbedPane3;
	private JTree jFileTree;
	private JPanel jPanel3;
	private JMaximizableTabbedPane jTabbedPane1;
	private JPanel jPanel2;
	private JPopupMenu jCppPopupMenu;
	private JMenuItem jShowMeTheCodeMenuItem;

	private MapDataTableModel mapDataTableModel = new MapDataTableModel();
	Application application;
	private File mapFile;

	public SourceLevelDebugger2(Application application) {
		this.application = application;
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(975, 563));
			{
				jSplitPane1 = new JSplitPane();
				this.add(jSplitPane1, "MAIN");
				jSplitPane1.setDividerLocation(300);
				{
					jPanel1 = new JPanel();
					BorderLayout jPanel1Layout = new BorderLayout();
					jPanel1.setLayout(jPanel1Layout);
					jSplitPane1.add(jPanel1, JSplitPane.LEFT);
					{
						jTabbedPane1 = new JMaximizableTabbedPane();
						jPanel1.add(jTabbedPane1, BorderLayout.CENTER);
						{
							jPanel3 = new JPanel();
							BorderLayout jPanel3Layout = new BorderLayout();
							jPanel3.setLayout(jPanel3Layout);
							jTabbedPane1.addTab("Project", null, jPanel3, null);
							{
								jScrollPane1 = new JScrollPane();
								jPanel3.add(jScrollPane1, BorderLayout.CENTER);
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
				{
					jPanel2 = new JPanel();
					BorderLayout jPanel2Layout = new BorderLayout();
					jPanel2.setLayout(jPanel2Layout);
					jSplitPane1.add(jPanel2, JSplitPane.RIGHT);
					{
						jSplitPane2 = new JSplitPane();
						jPanel2.add(jSplitPane2, BorderLayout.CENTER);
						jSplitPane2.setDividerLocation(550);
						{
							jPanel4 = new JPanel();
							BorderLayout jPanel4Layout = new BorderLayout();
							jPanel4.setLayout(jPanel4Layout);
							jSplitPane2.add(jPanel4, JSplitPane.LEFT);
							{
								jSplitPane3 = new JSplitPane();
								jPanel4.add(jSplitPane3, BorderLayout.CENTER);
								jSplitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);
								jSplitPane3.setDividerLocation(400);
								{
									jPanel6 = new JPanel();
									BorderLayout jPanel6Layout = new BorderLayout();
									jPanel6.setLayout(jPanel6Layout);
									jSplitPane3.add(jPanel6, JSplitPane.LEFT);
									{
										jTabbedPane3 = new JMaximizableTabbedPane();
										jPanel6.add(jTabbedPane3, BorderLayout.CENTER);
										{
											jSourcePanel = new JPanel();
											BorderLayout jPanel9Layout = new BorderLayout();
											jSourcePanel.setLayout(jPanel9Layout);
											jTabbedPane3.addTab("Source", new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/memory.png")), jSourcePanel,
													null);
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
											jASMPanel = new JPanel();
											BorderLayout jASMPanelLayout = new BorderLayout();
											jASMPanel.setLayout(jASMPanelLayout);
											jTabbedPane3.addTab("ASM", null, jASMPanel, null);
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
													jAssemblyTable.setDefaultRenderer(String.class, new JInstructionTableCellRenderer());
													jAssemblyTable.addMouseListener(new MouseAdapter() {
														public void mouseClicked(MouseEvent evt) {
															jAssemblyTableMouseClicked(evt);
														}
													});
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
											jPanel8 = new JPanel();
											jTabbedPane2.addTab("Breakpoint", null, jPanel8, null);
										}
									}
								}
							}
						}
						{
							jPanel5 = new JPanel();
							BorderLayout jPanel5Layout = new BorderLayout();
							jSplitPane2.add(jPanel5, JSplitPane.RIGHT);
							jPanel5.setLayout(jPanel5Layout);
							{
								jTabbedPane4 = new JMaximizableTabbedPane();
								jPanel5.add(jTabbedPane4, BorderLayout.CENTER);
								{
									jPanel10 = new JPanel();
									jTabbedPane4.addTab("Map", null, jPanel10, null);
									jTabbedPane4.addTab("Raw", null, getJPanel14(), null);
									jTabbedPane4.addTab("Library / Object", null, getJLibraryPanel(), null);
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
		System.out.println(file.getAbsolutePath());
		if (file.exists()) {
			TreePath p = com.petersoft.CommonLib.findTreeNode((TreeNode) jFileTree.getModel().getRoot(), file.getName(), new TreePath(jFileTree.getModel().getRoot()));
			jFileTree.setSelectionPath(p);
			handleProjectTreeClick(p);
		} else {
			System.out.println("file not exist : " + file.getAbsolutePath());
		}
	}

	private void jFileTreeMouseClicked(MouseEvent evt) {
		handleProjectTreeClick(jFileTree.getSelectionPath());
	}

	void handleProjectTreeClick(TreePath treePath) {
		jFileTree.setEnabled(false);
		try {
			if (treePath != null) {
				final ObjectFileTreeNode selectedTreeNode = (ObjectFileTreeNode) jFileTree.getSelectionPath().getLastPathComponent();
				if (selectedTreeNode != null) {
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
								cSourceTextArea.loadLargeFile(str);
								cSourceTextArea.refreshPage();

								jFileTree.setEnabled(true);
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
			if (!CommonLib.saveImage(jAssemblyTable, file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void jButton12ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			CommonLib.exportTableModelToExcel(file, this.jAssemblyTable.getModel(), "instruction 0x" + this.jInstructionComboBox.getSelectedItem().toString());
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

	public void loadSystemMap(File mapFile) {
		try {
			if (!mapFile.isFile()) {
				JOptionPane.showMessageDialog(this, mapFile.getAbsolutePath() + " is not a file !!!");
			} else if (!mapFile.exists()) {
				JOptionPane.showMessageDialog(this, mapFile.getAbsolutePath() + " not exist !!!");
			}
			this.mapFile = mapFile;
			String mapFileContent = FileUtils.readFileToString(mapFile);
			jMapTextArea.setText(mapFileContent);
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
			ObjectFileTreeNode root = new ObjectFileTreeNode(mapFile.getName());
			ObjectFileTreeNode archiveNode = new ObjectFileTreeNode("Archive member");
			root.children.add(archiveNode);

			HashSet<File> hs = new HashSet<File>();
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
			// end "Archive member included because of file"

			// load all (*)
			Pattern pattern = Pattern.compile(".*\\(\\*\\).*");
			Matcher lm = pattern.matcher(mapFileContent);
			ObjectFileTreeNode objectsNode = new ObjectFileTreeNode("Objects");
			root.children.add(objectsNode);
			while (lm.find()) {
				String filepath = lm.group().replaceAll("\\(.*", "").trim();
				File file;
				if (filepath.startsWith(File.separator)) {
					file = new File(filepath);
				} else {
					file = new File(mapFile.getParent() + File.separator + filepath);
				}
				if (!hs.contains(file)) {
					ObjectFileTreeNode tempNode = new ObjectFileTreeNode(file);
					objectsNode.children.add(tempNode);
				}
			}
			// end load all (*)

			((ObjectFileTreeModel) jFileTree.getModel()).setRoot(root);
			jFileTree.updateUI();
			initMemoryMap();

			application.jShowInSourceCodeMenuItem.setEnabled(true);
			application.jWhereIsHereMenuItem.setEnabled(true);
			application.jSourceLevelDebuggerButtonActionPerformed(null);
			// jMainTabbedPane.setSelectedIndex(1);
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
			jScrollPane5.setViewportView(getJMapTextArea());
		}
		return jScrollPane5;
	}

	private EnhancedTextArea getJMapTextArea() {
		if (jMapTextArea == null) {
			jMapTextArea = new EnhancedTextArea();
		}
		return jMapTextArea;
	}

	private JPanel getJLibraryPanel() {
		if (jLibraryPanel == null) {
			jLibraryPanel = new JPanel();
			BorderLayout jLibraryPanelLayout = new BorderLayout();
			jLibraryPanel.setLayout(jLibraryPanelLayout);
			jLibraryPanel.add(getJScrollPane6(), BorderLayout.CENTER);
		}
		return jLibraryPanel;
	}

	private JScrollPane getJScrollPane6() {
		if (jScrollPane6 == null) {
			jScrollPane6 = new JScrollPane();
			jScrollPane6.setViewportView(getJLibraryTable());
		}
		return jScrollPane6;
	}

	private JTable getJLibraryTable() {
		if (jLibraryTable == null) {
			jLibraryTable = new JTable();
			jLibraryTable.setModel(new LibraryTableModel());
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
		return jLibraryTable;
	}

	private void jLibraryTableMouseClicked(MouseEvent evt) {
		jLibraryTable.setEnabled(false);
		final JProgressBarDialog dialog = new JProgressBarDialog(application, "Dumping object/library", true);
		dialog.jProgressBar.setIndeterminate(true);
		dialog.jProgressBar.setStringPainted(true);
		dialog.setSize(new Dimension(750, 150));
		dialog.addCancelEventListener(this);
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
					jLibraryTable.setEnabled(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		dialog.thread = thread;
		dialog.setVisible(true);
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
		jLibraryTable.setEnabled(false);
	}
}
