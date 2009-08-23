package peter;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;

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
public class JRegisterPanel extends javax.swing.JPanel {
	private JLabel jLabel1;
	public JTextField jEAXTextField;
	private JPanel jPanel1;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel12;
	private JLabel jLabel11;
	private JLabel jLabel10;
	public JLabel jESLabel;
	public JLabel jDSLabel;
	public JTextField jCSTextField;
	public JTextField jGSTextField;
	public JTextField jSSTextField;
	public JTextField jEIPTextField;
	public JTextField jCR0TextField;
	public JTextField jDR7TextField;
	public JTextField jDR6TextField;
	public JTextField jDR5TextField;
	public JTextField jDR4TextField;
	public JTextField jDR3TextField;
	public JTextField jDR2TextField;
	private JSeparator jSeparator1;
	private JTextField jDR1TextField;
	private JLabel jLabel32;
	private JLabel jLabel31;
	private JLabel jLabel30;
	private JLabel jLabel29;
	private JLabel jLabel28;
	private JLabel jLabel27;
	private JLabel jLabel26;
	private JTextField jDR0TextField;
	private JLabel jDR0Label;
	private JPanel jDRPanel;
	private JScrollPane jStackScrollPane;
	public JList jStackList;
	private JLabel jLabel25;
	private JPanel jStackPanel;
	public JTextField jTRTextField;
	public JTextField jIDTRTextField;
	public JTextField jLDTRTextField;
	public JTextField jGDTRTextField;
	private JLabel jLabel22;
	private JLabel jLabel21;
	private JLabel jLabel20;
	private JLabel jLabel19;
	public JTextField jCR4TextField;
	public JTextField jCR3TextField;
	public JTextField jCR2TextField;
	public JTable jCR0Table;
	private JLabel jLabel18;
	private JLabel jLabel17;
	private JLabel jLabel16;
	private JLabel jCR0Label;
	private JPanel jPanel3;
	public JTextField jEFLAGSTextField;
	private JLabel jLabel14;
	private JLabel jLabel13;
	public JTextField jFSTextField;
	public JTextField jESTextField;
	public JTextField jDSTextField;
	private JLabel jLabel9;
	private JPanel jPanel2;
	public JTextField jESPTextField;
	public JTextField jEBPTextField;
	public JTextField jEDITextField;
	public JTextField jESITextField;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel6;
	public JTextField jEDXTextField;
	public JTextField jECXTextField;
	public JTextField jEBXTextField;
	private JLabel jLabel2;

	/**
	 * Auto-generated main method to display this JPanel inside a new
	 * JFrame.
	 */

	public JRegisterPanel() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			BoxLayout thisLayout = new BoxLayout(this, javax.swing.BoxLayout.X_AXIS);
			this.setLayout(thisLayout);
			this.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
			{
				jPanel2 = new JPanel();
				this.add(jPanel2);
				FormLayout jPanel2Layout = new FormLayout("24dlu, 46dlu",
						"max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu)");
				jPanel2.setLayout(jPanel2Layout);
				{
					jLabel9 = new JLabel();
					jPanel2.add(jLabel9, new CellConstraints("1, 1, 1, 1, default, default"));
					jLabel9.setText("cs");
				}
				{
					jCSTextField = new JTextField();
					jPanel2.add(jCSTextField, new CellConstraints("2, 1, 1, 1, default, default"));
				}
				{
					jDSLabel = new JLabel();
					jPanel2.add(jDSLabel, new CellConstraints("1, 3, 1, 1, default, default"));
					jDSLabel.setText("ds");
				}
				{
					jESLabel = new JLabel();
					jPanel2.add(jESLabel, new CellConstraints("1, 4, 1, 1, default, default"));
					jESLabel.setText("es");
				}
				{
					jLabel10 = new JLabel();
					jPanel2.add(jLabel10, new CellConstraints("1, 5, 1, 1, default, default"));
					jLabel10.setText("fs");
				}
				{
					jLabel11 = new JLabel();
					jPanel2.add(jLabel11, new CellConstraints("1, 6, 1, 1, default, default"));
					jLabel11.setText("gs");
				}
				{
					jLabel12 = new JLabel();
					jPanel2.add(jLabel12, new CellConstraints("1, 7, 1, 1, default, default"));
					jLabel12.setText("ss");
				}
				{
					jDSTextField = new JTextField();
					jPanel2.add(jDSTextField, new CellConstraints("2, 3, 1, 1, default, default"));
				}
				{
					jESTextField = new JTextField();
					jPanel2.add(jESTextField, new CellConstraints("2, 4, 1, 1, default, default"));
				}
				{
					jFSTextField = new JTextField();
					jPanel2.add(jFSTextField, new CellConstraints("2, 5, 1, 1, default, default"));
				}
				{
					jGSTextField = new JTextField();
					jPanel2.add(jGSTextField, new CellConstraints("2, 6, 1, 1, default, default"));
				}
				{
					jSSTextField = new JTextField();
					jPanel2.add(jSSTextField, new CellConstraints("2, 7, 1, 1, default, default"));
				}
				{
					jLabel13 = new JLabel();
					jPanel2.add(jLabel13, new CellConstraints("1, 2, 1, 1, default, default"));
					jLabel13.setText("eip");
				}
				{
					jEIPTextField = new JTextField();
					jPanel2.add(jEIPTextField, new CellConstraints("2, 2, 1, 1, default, default"));
				}
				{
					jLabel14 = new JLabel();
					jPanel2.add(jLabel14, new CellConstraints("1, 8, 1, 1, default, default"));
					jLabel14.setText("eflags");
				}
				{
					jEFLAGSTextField = new JTextField();
					jPanel2.add(jEFLAGSTextField, new CellConstraints("2, 8, 1, 1, default, default"));
				}
			}
			{
				jPanel1 = new JPanel();
				FormLayout jPanel1Layout = new FormLayout("16dlu, 50dlu",
						"max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu)");
				jPanel1.setLayout(jPanel1Layout);
				this.add(jPanel1);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1, new CellConstraints("1, 1, 1, 1, default, default"));
					jLabel1.setText("eax");
				}
				{
					jEAXTextField = new JTextField();
					jPanel1.add(jEAXTextField, new CellConstraints("2, 1, 1, 1, default, default"));
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2, new CellConstraints("1, 2, 1, 1, default, default"));
					jLabel2.setText("ebx");
				}
				{
					jEBXTextField = new JTextField();
					jPanel1.add(jEBXTextField, new CellConstraints("2, 2, 1, 1, default, default"));
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3, new CellConstraints("1, 3, 1, 1, default, default"));
					jLabel3.setText("ecx");
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4, new CellConstraints("1, 4, 1, 1, default, default"));
					jLabel4.setText("edx");
				}
				{
					jECXTextField = new JTextField();
					jPanel1.add(jECXTextField, new CellConstraints("2, 3, 1, 1, default, default"));
				}
				{
					jEDXTextField = new JTextField();
					jPanel1.add(jEDXTextField, new CellConstraints("2, 4, 1, 1, default, default"));
				}
				{
					jLabel5 = new JLabel();
					jPanel1.add(jLabel5, new CellConstraints("1, 5, 1, 1, default, default"));
					jLabel5.setText("esi");
				}
				{
					jLabel6 = new JLabel();
					jPanel1.add(jLabel6, new CellConstraints("1, 6, 1, 1, default, default"));
					jLabel6.setText("edi");
				}
				{
					jLabel7 = new JLabel();
					jPanel1.add(jLabel7, new CellConstraints("1, 7, 1, 1, default, default"));
					jLabel7.setText("ebp");
				}
				{
					jLabel8 = new JLabel();
					jPanel1.add(jLabel8, new CellConstraints("1, 8, 1, 1, default, default"));
					jLabel8.setText("esp");
				}
				{
					jESITextField = new JTextField();
					jPanel1.add(jESITextField, new CellConstraints("2, 5, 1, 1, default, default"));
				}
				{
					jEDITextField = new JTextField();
					jPanel1.add(jEDITextField, new CellConstraints("2, 6, 1, 1, default, default"));
				}
				{
					jEBPTextField = new JTextField();
					jPanel1.add(jEBPTextField, new CellConstraints("2, 7, 1, 1, default, default"));
				}
				{
					jESPTextField = new JTextField();
					jPanel1.add(jESPTextField, new CellConstraints("2, 8, 1, 1, default, default"));
				}
			}
			{
				jPanel3 = new JPanel();
				this.add(jPanel3);
				FormLayout jPanel3Layout = new FormLayout("16dlu, 54dlu",
						"max(p;15dlu), 25dlu, max(p;15dlu), max(p;15dlu), max(p;15dlu), 5dlu, max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu)");
				jPanel3.setLayout(jPanel3Layout);
				{
					jCR0Label = new JLabel();
					jPanel3.add(jCR0Label, new CellConstraints("1, 1, 1, 1, default, default"));
					jCR0Label.setText("cr0");
				}
				{
					jCR0TextField = new JTextField();
					jPanel3.add(jCR0TextField, new CellConstraints("2, 1, 1, 1, default, default"));
				}
				{
					jLabel16 = new JLabel();
					jPanel3.add(jLabel16, new CellConstraints("1, 3, 1, 1, default, default"));
					jLabel16.setText("cr2");
				}
				{
					jLabel17 = new JLabel();
					jPanel3.add(jLabel17, new CellConstraints("1, 4, 1, 1, default, default"));
					jLabel17.setText("cr3");
				}
				{
					jLabel18 = new JLabel();
					jPanel3.add(jLabel18, new CellConstraints("1, 5, 1, 1, default, default"));
					jLabel18.setText("cr4");
				}
				{
					jCR2TextField = new JTextField();
					jPanel3.add(jCR2TextField, new CellConstraints("2, 3, 1, 1, default, default"));
				}
				{
					jCR3TextField = new JTextField();
					jPanel3.add(jCR3TextField, new CellConstraints("2, 4, 1, 1, default, default"));
				}
				{
					jCR4TextField = new JTextField();
					jPanel3.add(jCR4TextField, new CellConstraints("2, 5, 1, 1, default, default"));
				}
				{
					jLabel19 = new JLabel();
					jPanel3.add(jLabel19, new CellConstraints("1, 7, 1, 1, default, default"));
					jLabel19.setText("gdtr");
				}
				{
					jLabel20 = new JLabel();
					jPanel3.add(jLabel20, new CellConstraints("1, 8, 1, 1, default, default"));
					jLabel20.setText("ldtr");
				}
				{
					jLabel21 = new JLabel();
					jPanel3.add(jLabel21, new CellConstraints("1, 9, 1, 1, default, default"));
					jLabel21.setText("idtr");
				}
				{
					jLabel22 = new JLabel();
					jPanel3.add(jLabel22, new CellConstraints("1, 10, 1, 1, default, default"));
					jLabel22.setText("tr");
				}
				{
					jGDTRTextField = new JTextField();
					jPanel3.add(jGDTRTextField, new CellConstraints("2, 7, 1, 1, default, default"));
				}
				{
					jLDTRTextField = new JTextField();
					jPanel3.add(jLDTRTextField, new CellConstraints("2, 8, 1, 1, default, default"));
				}
				{
					jIDTRTextField = new JTextField();
					jPanel3.add(jIDTRTextField, new CellConstraints("2, 9, 1, 1, default, default"));
				}
				{
					jTRTextField = new JTextField();
					jPanel3.add(jTRTextField, new CellConstraints("2, 10, 1, 1, default, default"));
				}
				{
					jSeparator1 = new JSeparator();
					jPanel3.add(jSeparator1, new CellConstraints("1, 6, 2, 1, default, default"));
				}
				{
					TableModel jTable1Model = new DefaultTableModel(new String[][] { { "pg", "cd", "nw", "am", "wp" }, { "ne", "et", "ts", "em", "mp", "pe" } }, new String[] { "",
							"", "", "", "", "" });
					jCR0Table = new JTable();
					jPanel3.add(jCR0Table, new CellConstraints("1, 2, 2, 1, default, default"));
					jCR0Table.setModel(jTable1Model);
					jCR0Table.setBorder(new LineBorder(new java.awt.Color(140, 140, 140), 1, false));
				}
			}
			{
				jDRPanel = new JPanel();
				FormLayout jDRPanelLayout = new FormLayout("18dlu, 49dlu",
						"max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu)");
				jDRPanel.setLayout(jDRPanelLayout);
				this.add(jDRPanel);
				{
					jDR0Label = new JLabel();
					jDRPanel.add(jDR0Label, new CellConstraints("1, 1, 1, 1, default, default"));
					jDR0Label.setText("DR0");
				}
				{
					jDR0TextField = new JTextField();
					jDRPanel.add(jDR0TextField, new CellConstraints("2, 1, 1, 1, default, default"));
				}
				{
					jLabel26 = new JLabel();
					jDRPanel.add(jLabel26, new CellConstraints("1, 2, 1, 1, default, default"));
					jLabel26.setText("DR1");
				}
				{
					jLabel27 = new JLabel();
					jDRPanel.add(jLabel27, new CellConstraints("1, 3, 1, 1, default, default"));
					jLabel27.setText("DR2");
				}
				{
					jLabel28 = new JLabel();
					jDRPanel.add(jLabel28, new CellConstraints("1, 4, 1, 1, default, default"));
					jLabel28.setText("DR3");
				}
				{
					jLabel29 = new JLabel();
					jDRPanel.add(jLabel29, new CellConstraints("1, 5, 1, 1, default, default"));
					jLabel29.setText("DR4");
				}
				{
					jLabel30 = new JLabel();
					jDRPanel.add(jLabel30, new CellConstraints("1, 6, 1, 1, default, default"));
					jLabel30.setText("DR5");
				}
				{
					jLabel31 = new JLabel();
					jDRPanel.add(jLabel31, new CellConstraints("1, 7, 1, 1, default, default"));
					jLabel31.setText("DR6");
				}
				{
					jLabel32 = new JLabel();
					jDRPanel.add(jLabel32, new CellConstraints("1, 8, 1, 1, default, default"));
					jLabel32.setText("DR7");
				}
				{
					jDR1TextField = new JTextField();
					jDRPanel.add(jDR1TextField, new CellConstraints("2, 2, 1, 1, default, default"));
				}
				{
					jDR2TextField = new JTextField();
					jDRPanel.add(jDR2TextField, new CellConstraints("2, 3, 1, 1, default, default"));
				}
				{
					jDR3TextField = new JTextField();
					jDRPanel.add(jDR3TextField, new CellConstraints("2, 4, 1, 1, default, default"));
				}
				{
					jDR4TextField = new JTextField();
					jDRPanel.add(jDR4TextField, new CellConstraints("2, 5, 1, 1, default, default"));
				}
				{
					jDR5TextField = new JTextField();
					jDRPanel.add(jDR5TextField, new CellConstraints("2, 6, 1, 1, default, default"));
				}
				{
					jDR6TextField = new JTextField();
					jDRPanel.add(jDR6TextField, new CellConstraints("2, 7, 1, 1, default, default"));
				}
				{
					jDR7TextField = new JTextField();
					jDRPanel.add(jDR7TextField, new CellConstraints("2, 8, 1, 1, default, default"));
				}
			}
			{
				jStackPanel = new JPanel();
				this.add(jStackPanel);
				BorderLayout jStackPanelLayout = new BorderLayout();
				jStackPanel.setLayout(jStackPanelLayout);
				{
					jStackScrollPane = new JScrollPane();
					jStackPanel.add(jStackScrollPane, BorderLayout.CENTER);
					jStackScrollPane.setPreferredSize(new java.awt.Dimension(120, 3));
					{
						jStackList = new JList();
						jStackScrollPane.setViewportView(jStackList);
					}
				}
				{
					jLabel25 = new JLabel();
					jStackPanel.add(jLabel25, BorderLayout.NORTH);
					jLabel25.setText("Stack");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
