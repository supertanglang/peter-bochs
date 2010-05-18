package peter.osdebuginformation;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import peter.SortableTableModel;

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
public class JOSDebugInformationPanel extends JPanel {
	private JToolBar jToolBar1;
	private JScrollPane jScrollPane1;
	public JEditorPane jXMLEditorPane;
	private JScrollPane jScrollPane2;
	private JTable jKernelInterruptTable;
	private JTable jKernelModuleTable;
	private JScrollPane jScrollPane5;
	private JScrollPane jScrollPane4;
	private JTabbedPane jTabbedPane1;
	private JTable jKernelTable;
	private JScrollPane jScrollPane3;
	private JPanel jKernelPanel;
	private JTable jTable1;
	private JPanel jOSInfoPanel;
	private JPanel jXMLPanel;
	private JPanel jMainPanel;
	private JTree jFunctionTree;
	private JScrollPane jLeftScrollPane;
	private JButton jExcelButton;
	private JSplitPane jMainSplitPane;
	OSInfoTableModel osInfoTableModel = new OSInfoTableModel();
	OSInfoTableModel kernelInfoTableModel = new OSInfoTableModel();
	OSInfoKernelModuleTableModel kernelModuleInfoTableModel = new OSInfoKernelModuleTableModel();
	OSInfoTableModel kernelInterruptInfoTableModel = new OSInfoTableModel();

	public JOSDebugInformationPanel() {
		initGUI();
	}

	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			this.setLayout(thisLayout);
			{
				jToolBar1 = new JToolBar();
				this.add(jToolBar1, BorderLayout.NORTH);
				{
					jExcelButton = new JButton();
					jToolBar1.add(jExcelButton);
					jExcelButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/excel.gif")));
				}
			}
			{
				jMainSplitPane = new JSplitPane();
				this.add(jMainSplitPane, BorderLayout.CENTER);
				{
					jLeftScrollPane = new JScrollPane();
					jMainSplitPane.add(jLeftScrollPane, JSplitPane.LEFT);
					{
						FunctionTreeNode root = new FunctionTreeNode("os", "os");
						root.add(new FunctionTreeNode("kernel", "kernel"));
						root.add(new FunctionTreeNode("ram", "ram"));
						root.add(new FunctionTreeNode("process", "process"));
						root.add(new FunctionTreeNode("device", "device"));
						root.add(new FunctionTreeNode("fs", "fs"));
						root.add(new FunctionTreeNode("network", "network"));
						root.add(new FunctionTreeNode("table", "table"));
						root.add(new FunctionTreeNode("xml", "xml"));

						jFunctionTree = new JTree(root);
						jFunctionTree.setCellRenderer(new FunctionTreeRenderer());
						jFunctionTree.setShowsRootHandles(true);
						jLeftScrollPane.setViewportView(jFunctionTree);
						jFunctionTree.addTreeSelectionListener(new TreeSelectionListener() {
							public void valueChanged(TreeSelectionEvent evt) {
								jFunctionTreeValueChanged(evt);
							}
						});
					}
				}
				{
					jMainPanel = new JPanel();
					CardLayout jMainPanelLayout = new CardLayout();
					jMainPanel.setLayout(jMainPanelLayout);
					jMainSplitPane.add(jMainPanel, JSplitPane.RIGHT);
					{
						jXMLPanel = new JPanel();
						BorderLayout jXMLPanelLayout = new BorderLayout();
						jXMLPanel.setLayout(jXMLPanelLayout);
						jMainPanel.add(jXMLPanel, "jXMLPanel");
						{
							jScrollPane1 = new JScrollPane();
							jXMLPanel.add(jScrollPane1, BorderLayout.CENTER);
							{
								jXMLEditorPane = new JEditorPane();
								jScrollPane1.setViewportView(jXMLEditorPane);
								jXMLEditorPane.setText("");
							}
						}
					}
					{
						jOSInfoPanel = new JPanel();
						BorderLayout jOSInfoPanelLayout = new BorderLayout();
						jOSInfoPanel.setLayout(jOSInfoPanelLayout);
						jMainPanel.add(jOSInfoPanel, "jOSInfoPanel");
						{
							jScrollPane2 = new JScrollPane();
							jOSInfoPanel.add(jScrollPane2, BorderLayout.CENTER);
							{
								jTable1 = new JTable();
								jScrollPane2.setViewportView(jTable1);
								jTable1.setModel(new SortableTableModel(osInfoTableModel));
							}
						}
					}
					{
						jKernelPanel = new JPanel();
						BorderLayout jKernelPanelLayout = new BorderLayout();
						jKernelPanel.setLayout(jKernelPanelLayout);
						jMainPanel.add(jKernelPanel, "jKernelPanel");
						{
							jTabbedPane1 = new JTabbedPane();
							jKernelPanel.add(jTabbedPane1, BorderLayout.CENTER);
							jTabbedPane1.setPreferredSize(new java.awt.Dimension(453, 422));
							jTabbedPane1.setTabPlacement(JTabbedPane.LEFT);
							{
								jScrollPane3 = new JScrollPane();
								jTabbedPane1.addTab("basic info", null, jScrollPane3, null);
								{
									jKernelTable = new JTable();
									jScrollPane3.setViewportView(jKernelTable);
									jKernelTable.setModel(kernelInfoTableModel);
								}
							}
							{
								jScrollPane4 = new JScrollPane();
								jTabbedPane1.addTab("module", null, jScrollPane4, null);
								{
									jKernelModuleTable = new JTable();
									jScrollPane4.setViewportView(jKernelModuleTable);
									jKernelModuleTable.setModel(kernelModuleInfoTableModel);
								}
							}
							{
								jScrollPane5 = new JScrollPane();
								jTabbedPane1.addTab("interrupt", null, jScrollPane5, null);
								{
									jKernelInterruptTable = new JTable();
									jScrollPane5.setViewportView(jKernelInterruptTable);
									jKernelInterruptTable.setModel(kernelInterruptInfoTableModel);
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

	public OSInfoKernelModuleTableModel getKernelModuleInfoTableModel() {
		return kernelModuleInfoTableModel;
	}

	public void setKernelModuleInfoTableModel(OSInfoKernelModuleTableModel kernelModuleInfoTableModel) {
		this.kernelModuleInfoTableModel = kernelModuleInfoTableModel;
	}

	public OSInfoTableModel getKernelInterruptInfoTableModel() {
		return kernelInterruptInfoTableModel;
	}

	public void setKernelInterruptInfoTableModel(OSInfoTableModel kernelInterruptInfoTableModel) {
		this.kernelInterruptInfoTableModel = kernelInterruptInfoTableModel;
	}

	public OSInfoTableModel getKernelInfoTableModel() {
		return kernelInfoTableModel;
	}

	public void setKernelInfoTableModel(OSInfoTableModel kernelInfoTableModel) {
		this.kernelInfoTableModel = kernelInfoTableModel;
	}

	public OSInfoTableModel getOsInfoTableModel() {
		return osInfoTableModel;
	}

	public void setOsInfoTableModel(OSInfoTableModel osInfoTableModel) {
		this.osInfoTableModel = osInfoTableModel;
	}

	public JSplitPane getjMainSplitPane() {
		return jMainSplitPane;
	}

	public void setjMainSplitPane(JSplitPane jMainSplitPane) {
		this.jMainSplitPane = jMainSplitPane;
	}

	private void jFunctionTreeValueChanged(TreeSelectionEvent evt) {
		FunctionTreeNode node = (FunctionTreeNode) jFunctionTree.getLastSelectedPathComponent();
		CardLayout cl = (CardLayout) (jMainPanel.getLayout());
		System.out.println(node.toString());
		if (node.toString().equals("os")) {
			cl.show(jMainPanel, "jOSInfoPanel");
		} else if (node.toString().equals("xml")) {
			cl.show(jMainPanel, "jXMLPanel");
		} else if (node.toString().equals("kernel")) {
			cl.show(jMainPanel, "jKernelPanel");
		}
	}

}
