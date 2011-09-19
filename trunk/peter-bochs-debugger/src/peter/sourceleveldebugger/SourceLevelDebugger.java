package peter.sourceleveldebugger;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;

import org.apache.commons.io.FileUtils;

import peter.Application;
import peter.Global;
import peter.JInstructionTableCellRenderer;
import peter.Setting;

import com.petersoft.CommonLib;
import com.petersoft.advancedswing.enhancedtextarea.EnhancedTextArea;
import com.petersoft.advancedswing.jmaximizabletabbedpane.JMaximizableTabbedPane;
import com.petersoft.advancedswing.jmaximizabletabbedpane.JMaximizableTabbedPane_BasePanel;
import com.petersoft.advancedswing.jprogressbardialog.JProgressBarDialog;
import com.petersoft.advancedswing.searchtextfield.JSearchTextField;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used commercially (ie, by a
 * corporation, company or business for any purpose whatever) then you should purchase a license for each developer using Jigloo. Please visit www.cloudgarden.com for details. Use
 * of Jigloo implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR ANY
 * CORPORATE OR COMMERCIAL PURPOSE.
 */
public class SourceLevelDebugger extends JPanel {
	private JPanel jAssemblyPanel;
	private JPanel jStringPanel;
	private JSearchTextField jSearchMapTextField;
	private JPanel jPanel6;
	private JPanel jPanel5;
	private MemoryMap memoryMap;
	private JPanel jPanel4;
	public JTabbedPane jMapTabbedPane;
	private EnhancedTextArea jObjdumpTextArea;
	private JTable jLibraryTable;
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
											jMapDataTable.getColumnModel().getColumn(0).setPreferredWidth(120);
											jMapDataTable.getColumnModel().getColumn(1).setPreferredWidth(120);
											jMapDataTable.getColumnModel().getColumn(2).setPreferredWidth(150);
											jMapDataTable.getColumnModel().getColumn(3).setPreferredWidth(60);
											jMapDataTable.getColumnModel().getColumn(4).setPreferredWidth(460);
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
							jObjdumpTextArea = new EnhancedTextArea();
							jCPanel.add(jObjdumpTextArea, BorderLayout.CENTER);
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

			initMemoryMap();

			application.jShowInSourceCodeMenuItem.setEnabled(true);
			application.jWhereIsHereMenuItem.setEnabled(true);
			application.jSourceLevelDebuggerButtonActionPerformed(null);
			jMainTabbedPane.setSelectedIndex(1);
		} catch (IOException e) {
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
					Process process = Runtime.getRuntime().exec("objdump -dS " + objectFile);
					InputStream input = process.getInputStream();

					String str = "";
					byte b[] = new byte[1024000];
					int len;
					int x = 0;
					// int totalLen = (int) new File(jLibraryTable.getValueAt(jLibraryTable.getSelectedRow(), 1).toString()).length();
					// dialog.jProgressBar.setMaximum(totalLen);
					while ((len = input.read(b)) > 0) {
						str += new String(b, 0, len);
						x += len;
						dialog.jProgressBar.setString("objdump -dS " + objectFile + ", " + String.valueOf(x));
					}
					input.close();
					dialog.jProgressBar.setString("Setting the result to textarea, please be patient");
					final String str2 = str;
					jObjdumpTextArea.setText(str);

					// try {
					// EventQueue.invokeAndWait(new Runnable() {
					// public void run() {
					// jObjdumpTextArea.setText(str2);
					// }
					// });
					// } catch (InterruptedException e) {
					// e.printStackTrace();
					// } catch (InvocationTargetException e) {
					// e.printStackTrace();
					// }

					// Thread thread = new Thread() {
					// public void run() {
					// Document document = jObjdumpTextArea.jTextArea.getDocument();
					// try {
					// document.insertString(0, str2, null);
					// } catch (BadLocationException e) {
					// e.printStackTrace();
					// }
					// }
					// };
					// thread.start();
					// try {
					// thread.join();
					// } catch (InterruptedException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }

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
				return;
			}
		}
	}
}
