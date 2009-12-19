package peter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

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
	private JLabel jEAXLabel;
	public JTextField jEAXTextField;
	private JLabel jECXLabel;
	private JLabel jEDXLabel;
	private JLabel jESILabel;
	private JLabel jSSLabel;
	private JLabel jGSLabel;
	private JLabel jFSLabel;
	public JLabel jESLabel;
	public JLabel jDSLabel;
	public JTextField jCSTextField;
	public JTextField jGSTextField;
	public JTextField jSSTextField;
	public JTextField jEIPTextField;
	public JTextField jCR0TextField;
	public JTextField jDR7TextField;
	public JTextField jDR6TextField;
	public JTextField jDR3TextField;
	public JTextField jDR2TextField;
	private JSeparator jSeparator1;
	public JTextField jDR1TextField;
	private JLabel jDR7Label;
	private JLabel jDR6Label;
	private JLabel jDR3Label;
	private JLabel jDR2Label;
	private JLabel jDR1Label;
	public JTextField jDR0TextField;
	private JLabel jDR0Label;
	private JLabel jLabel25;
	public JTextField jTRTextField;
	public JTextField jIDTRTextField;
	public JTextField jLDTRTextField;
	public JTextField jGDTRTextField;
	private JLabel jTRLabel;
	private JLabel jIDTRLabel;
	private JLabel jLDTRLabel;
	private JLabel jGDTRLabel;
	public JTextField jCR4TextField;
	public JTextField jCR3TextField;
	private JPanel jPanel1;
	private JButton jExportExcelButton;
	private JButton jButton1;
	public JList jStackList;
	private JScrollPane jStackScrollPane;
	public JTextField jGDTRLimitTextField;
	public JTextField jCR2TextField;
	public JLabel jCR0DetailLabel2;
	public JLabel jCR0DetailLabel;
	public JLabel jEFlagLabel2;
	public JLabel jEFlagLabel;
	public JTextField jIDTRLimitTextField;
	private JLabel jCR4Label;
	private JLabel jCR3Label;
	private JLabel jCR2Label;
	public JLabel jCR0Label;
	public JTextField jEFLAGSTextField;
	private JLabel jEFlagsLabel;
	private JLabel jEIPLabel;
	public JTextField jFSTextField;
	public JTextField jESTextField;
	public JTextField jDSTextField;
	private JLabel jCSLabel;
	private JPanel jPanel99;
	public JTextField jESPTextField;
	public JTextField jEBPTextField;
	public JTextField jEDITextField;
	public JTextField jESITextField;
	private JLabel jESPLabel;
	private JLabel jEBPLabel;
	private JLabel jEDILabel;
	public JTextField jEDXTextField;
	public JTextField jECXTextField;
	public JTextField jEBXTextField;
	private JLabel jEBXLabel;
	Application application;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */

	public JRegisterPanel() {
		super();
		initGUI();
	}

	public JRegisterPanel(Application application) {
		super();
		this.application = application;
		initGUI();
	}

	private void initGUI() {
		try {
			BoxLayout thisLayout = new BoxLayout(this, javax.swing.BoxLayout.X_AXIS);
			this.setLayout(thisLayout);
			this.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
			{
				jPanel99 = new JPanel();
				this.add(jPanel99);
				FormLayout jPanel2Layout = new FormLayout(
						"max(p;15dlu), 24dlu, 72dlu, 5dlu, max(p;15dlu), 67dlu, 5dlu, max(p;15dlu), 68dlu, 5dlu, 28dlu, 5dlu, max(p;15dlu), 72dlu, 5dlu, 83dlu",
						"max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu), max(p;15dlu)");
				jPanel99.setLayout(jPanel2Layout);
				jPanel99.setPreferredSize(new java.awt.Dimension(1037, 250));
				{
					jCSLabel = new JLabel();
					jPanel99.add(jCSLabel, new CellConstraints("2, 1, 1, 1, default, default"));
					jCSLabel.setText("cs");
					jCSLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jCSLabelMouseClicked(evt);
						}
					});
				}
				{
					jCSTextField = new JTextField();
					jPanel99.add(jCSTextField, new CellConstraints("3, 1, 1, 1, default, default"));
				}
				{
					jDSLabel = new JLabel();
					jPanel99.add(jDSLabel, new CellConstraints("2, 3, 1, 1, default, default"));
					jDSLabel.setText("ds");
					jDSLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jDSLabelMouseClicked(evt);
						}
					});
				}
				{
					jESLabel = new JLabel();
					jPanel99.add(jESLabel, new CellConstraints("2, 4, 1, 1, default, default"));
					jESLabel.setText("es");
					jESLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jESLabelMouseClicked(evt);
						}
					});
				}
				{
					jFSLabel = new JLabel();
					jPanel99.add(jFSLabel, new CellConstraints("2, 5, 1, 1, default, default"));
					jFSLabel.setText("fs");
					jFSLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jFSLabelMouseClicked(evt);
						}
					});
				}
				{
					jGSLabel = new JLabel();
					jPanel99.add(jGSLabel, new CellConstraints("2, 6, 1, 1, default, default"));
					jGSLabel.setText("gs");
					jGSLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jGSLabelMouseClicked(evt);
						}
					});
				}
				{
					jSSLabel = new JLabel();
					jPanel99.add(jSSLabel, new CellConstraints("2, 7, 1, 1, default, default"));
					jSSLabel.setText("ss");
					jSSLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jSSLabelMouseClicked(evt);
						}
					});
				}
				{
					jDSTextField = new JTextField();
					jPanel99.add(jDSTextField, new CellConstraints("3, 3, 1, 1, default, default"));
				}
				{
					jESTextField = new JTextField();
					jPanel99.add(jESTextField, new CellConstraints("3, 4, 1, 1, default, default"));
				}
				{
					jFSTextField = new JTextField();
					jPanel99.add(jFSTextField, new CellConstraints("3, 5, 1, 1, default, default"));
				}
				{
					jGSTextField = new JTextField();
					jPanel99.add(jGSTextField, new CellConstraints("3, 6, 1, 1, default, default"));
				}
				{
					jSSTextField = new JTextField();
					jPanel99.add(jSSTextField, new CellConstraints("3, 7, 1, 1, default, default"));
				}
				{
					jEIPLabel = new JLabel();
					jPanel99.add(jEIPLabel, new CellConstraints("2, 2, 1, 1, default, default"));
					jEIPLabel.setText("eip");
					jEIPLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jEIPLabelMouseClicked(evt);
						}
					});
				}
				{
					jEIPTextField = new JTextField();
					jPanel99.add(jEIPTextField, new CellConstraints("3, 2, 1, 1, default, default"));
				}
				{
					jEFlagsLabel = new JLabel();
					jPanel99.add(jEFlagsLabel, new CellConstraints("2, 8, 1, 1, default, default"));
					jEFlagsLabel.setText("eflags");
					jEFlagsLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jEFlagsLabelMouseClicked(evt);
						}
					});
				}
				{
					jEFLAGSTextField = new JTextField();
					jPanel99.add(jEFLAGSTextField, new CellConstraints("3, 8, 1, 1, default, default"));
				}
				{
					jEFlagLabel = new JLabel();
					jPanel99.add(jEFlagLabel, new CellConstraints("2, 9, 5, 1, default, default"));
				}
				{
					jEFlagLabel2 = new JLabel();
					jPanel99.add(jEFlagLabel2, new CellConstraints("2, 10, 5, 1, default, default"));
				}
				{
					jEAXLabel = new JLabel();
					jPanel99.add(jEAXLabel, new CellConstraints("5, 1, 1, 1, default, default"));
					jEAXLabel.setText("eax");
					jEAXLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jEAXLabelMouseClicked(evt);
						}
					});
				}
				{
					jEBXLabel = new JLabel();
					jPanel99.add(jEBXLabel, new CellConstraints("5, 2, 1, 1, default, default"));
					jEBXLabel.setText("ebx");
					jEBXLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jEBXLabelMouseClicked(evt);
						}
					});
				}
				{
					jECXLabel = new JLabel();
					jPanel99.add(jECXLabel, new CellConstraints("5, 3, 1, 1, default, default"));
					jECXLabel.setText("ecx");
					jECXLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jECXLabelMouseClicked(evt);
						}
					});
				}
				{
					jEDXLabel = new JLabel();
					jPanel99.add(jEDXLabel, new CellConstraints("5, 4, 1, 1, default, default"));
					jEDXLabel.setText("edx");
					jEDXLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jEDXLabelMouseClicked(evt);
						}
					});
				}
				{
					jESILabel = new JLabel();
					jPanel99.add(jESILabel, new CellConstraints("5, 5, 1, 1, default, default"));
					jESILabel.setText("esi");
					jESILabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jESILabelMouseClicked(evt);
						}
					});
				}
				{
					jEDILabel = new JLabel();
					jPanel99.add(jEDILabel, new CellConstraints("5, 6, 1, 1, default, default"));
					jEDILabel.setText("edi");
					jEDILabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jEDILabel6MouseClicked(evt);
						}
					});
				}
				{
					jEBPLabel = new JLabel();
					jPanel99.add(jEBPLabel, new CellConstraints("5, 7, 1, 1, default, default"));
					jEBPLabel.setText("ebp");
					jEBPLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jEBPLabelMouseClicked(evt);
						}
					});
				}
				{
					jESPLabel = new JLabel();
					jPanel99.add(jESPLabel, new CellConstraints("5, 8, 1, 1, default, default"));
					jESPLabel.setText("esp");
					jESPLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jESPLabelMouseClicked(evt);
						}
					});
				}
				{
					jEAXTextField = new JTextField();
					jPanel99.add(jEAXTextField, new CellConstraints("6, 1, 1, 1, default, default"));
				}
				{
					jEBXTextField = new JTextField();
					jPanel99.add(jEBXTextField, new CellConstraints("6, 2, 1, 1, default, default"));
				}
				{
					jECXTextField = new JTextField();
					jPanel99.add(jECXTextField, new CellConstraints("6, 3, 1, 1, default, default"));
				}
				{
					jEDXTextField = new JTextField();
					jPanel99.add(jEDXTextField, new CellConstraints("6, 4, 1, 1, default, default"));
				}
				{
					jESITextField = new JTextField();
					jPanel99.add(jESITextField, new CellConstraints("6, 5, 1, 1, default, default"));
				}
				{
					jEDITextField = new JTextField();
					jPanel99.add(jEDITextField, new CellConstraints("6, 6, 1, 1, default, default"));
				}
				{
					jEBPTextField = new JTextField();
					jPanel99.add(jEBPTextField, new CellConstraints("6, 7, 1, 1, default, default"));
				}
				{
					jESPTextField = new JTextField();
					jPanel99.add(jESPTextField, new CellConstraints("6, 8, 1, 1, default, default"));
				}
				{
					jCR0Label = new JLabel();
					jPanel99.add(jCR0Label, new CellConstraints("8, 1, 1, 1, default, default"));
					jCR0Label.setText("cr0");
					jCR0Label.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jCR0LabelMouseClicked(evt);
						}
					});
				}
				{
					jCR0TextField = new JTextField();
					jPanel99.add(jCR0TextField, new CellConstraints("9, 1, 3, 1, default, default"));
				}
				{
					jCR2Label = new JLabel();
					jPanel99.add(jCR2Label, new CellConstraints("8, 4, 1, 1, default, default"));
					jCR2Label.setText("cr2");
					jCR2Label.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jCR2LabelMouseClicked(evt);
						}
					});
				}
				{
					jCR2TextField = new JTextField();
					jPanel99.add(jCR2TextField, new CellConstraints("9, 4, 3, 1, default, default"));
				}
				{
					jCR3Label = new JLabel();
					jPanel99.add(jCR3Label, new CellConstraints("8, 5, 1, 1, default, default"));
					jCR3Label.setText("cr3");
					jCR3Label.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jCR3LabelMouseClicked(evt);
						}
					});
				}
				{
					jCR3TextField = new JTextField();
					jPanel99.add(jCR3TextField, new CellConstraints("9, 5, 3, 1, default, default"));
				}
				{
					jCR4Label = new JLabel();
					jPanel99.add(jCR4Label, new CellConstraints("8, 6, 1, 1, default, default"));
					jCR4Label.setText("cr4");
					jCR4Label.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jCR4LabelMouseClicked(evt);
						}
					});
				}
				{
					jCR4TextField = new JTextField();
					jPanel99.add(jCR4TextField, new CellConstraints("9, 6, 3, 1, default, default"));
				}
				{
					jSeparator1 = new JSeparator();
					jPanel99.add(jSeparator1, new CellConstraints("8, 7, 4, 1, default, default"));
				}
				{
					jGDTRTextField = new JTextField();
					jPanel99.add(jGDTRTextField, new CellConstraints("9, 8, 1, 1, default, default"));
				}
				{
					jGDTRLabel = new JLabel();
					jPanel99.add(jGDTRLabel, new CellConstraints("8, 8, 1, 1, default, default"));
					jGDTRLabel.setText("gdtr");
					jGDTRLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jGDTRLabelMouseClicked(evt);
						}
					});
				}
				{
					jGDTRLimitTextField = new JTextField();
					jPanel99.add(jGDTRLimitTextField, new CellConstraints("11, 8, 1, 1, default, default"));
				}
				{
					jLDTRLabel = new JLabel();
					jPanel99.add(jLDTRLabel, new CellConstraints("8, 9, 1, 1, default, default"));
					jLDTRLabel.setText("ldtr");
					jLDTRLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jLDTRLabelMouseClicked(evt);
						}
					});
				}
				{
					jLDTRTextField = new JTextField();
					jPanel99.add(jLDTRTextField, new CellConstraints("9, 9, 3, 1, default, default"));
				}
				{
					jIDTRLabel = new JLabel();
					jPanel99.add(jIDTRLabel, new CellConstraints("8, 10, 1, 1, default, default"));
					jIDTRLabel.setText("idtr");
					jIDTRLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jIDTRLabelMouseClicked(evt);
						}
					});
				}
				{
					jIDTRTextField = new JTextField();
					jPanel99.add(jIDTRTextField, new CellConstraints("9, 10, 1, 1, default, default"));
				}
				{
					jIDTRLimitTextField = new JTextField();
					jPanel99.add(jIDTRLimitTextField, new CellConstraints("11, 10, 1, 1, default, default"));
				}
				{
					jTRLabel = new JLabel();
					jPanel99.add(jTRLabel, new CellConstraints("8, 11, 1, 1, default, default"));
					jTRLabel.setText("tr");
					jTRLabel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jTRLabelMouseClicked(evt);
						}
					});
				}
				{
					jTRTextField = new JTextField();
					jPanel99.add(jTRTextField, new CellConstraints("9, 11, 3, 1, default, default"));
				}
				{
					jCR0DetailLabel = new JLabel();
					jPanel99.add(jCR0DetailLabel, new CellConstraints("8, 2, 4, 1, default, default"));
				}
				{
					jCR0DetailLabel2 = new JLabel();
					jPanel99.add(jCR0DetailLabel2, new CellConstraints("8, 3, 4, 1, default, default"));
				}
				{
					jDR0Label = new JLabel();
					jPanel99.add(jDR0Label, new CellConstraints("13, 1, 1, 1, default, default"));
					jDR0Label.setText("DR0");
					jDR0Label.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jDR0LabelMouseClicked(evt);
						}
					});
				}
				{
					jDR1Label = new JLabel();
					jPanel99.add(jDR1Label, new CellConstraints("13, 2, 1, 1, default, default"));
					jDR1Label.setText("DR1");
					jDR1Label.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jDR1LabelMouseClicked(evt);
						}
					});
				}
				{
					jDR2Label = new JLabel();
					jPanel99.add(jDR2Label, new CellConstraints("13, 3, 1, 1, default, default"));
					jDR2Label.setText("DR2");
					jDR2Label.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jDR2LabelMouseClicked(evt);
						}
					});
				}
				{
					jDR3Label = new JLabel();
					jPanel99.add(jDR3Label, new CellConstraints("13, 4, 1, 1, default, default"));
					jDR3Label.setText("DR3");
					jDR3Label.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jDR3LabelMouseClicked(evt);
						}
					});
				}
				{
					jDR6Label = new JLabel();
					jPanel99.add(jDR6Label, new CellConstraints("13, 5, 1, 1, default, default"));
					jDR6Label.setText("DR6");
					jDR6Label.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jDR6LabelMouseClicked(evt);
						}
					});
				}
				{
					jDR7Label = new JLabel();
					jPanel99.add(jDR7Label, new CellConstraints("13, 6, 1, 1, default, default"));
					jDR7Label.setText("DR7");
					jDR7Label.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jDR7LabelMouseClicked(evt);
						}
					});
				}
				{
					jDR0TextField = new JTextField();
					jPanel99.add(jDR0TextField, new CellConstraints("14, 1, 1, 1, default, default"));
				}
				{
					jDR1TextField = new JTextField();
					jPanel99.add(jDR1TextField, new CellConstraints("14, 2, 1, 1, default, default"));
				}
				{
					jDR2TextField = new JTextField();
					jPanel99.add(jDR2TextField, new CellConstraints("14, 3, 1, 1, default, default"));
				}
				{
					jDR3TextField = new JTextField();
					jPanel99.add(jDR3TextField, new CellConstraints("14, 4, 1, 1, default, default"));
				}
				{
					jDR6TextField = new JTextField();
					jPanel99.add(jDR6TextField, new CellConstraints("14, 5, 1, 1, default, default"));
				}
				{
					jDR7TextField = new JTextField();
					jPanel99.add(jDR7TextField, new CellConstraints("14, 6, 1, 1, default, default"));
				}
				{
					jLabel25 = new JLabel();
					jPanel99.add(jLabel25, new CellConstraints("16, 1, 1, 1, default, default"));
					jLabel25.setText(Application.language.getString("Stack"));
				}
				{
					jStackScrollPane = new JScrollPane();
					jPanel99.add(jStackScrollPane, new CellConstraints("16, 2, 1, 10, default, default"));
					jStackScrollPane.setPreferredSize(new java.awt.Dimension(120, 3));
					{

						jStackList = new JList();
						jStackScrollPane.setViewportView(jStackList);

					}
				}
				{
					jPanel1 = new JPanel();
					BoxLayout jPanel1Layout = new BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS);
					jPanel99.add(jPanel1, new CellConstraints("1, 1, 1, 4, default, default"));
					jPanel1.setLayout(jPanel1Layout);
					{
						jButton1 = new JButton();
						jPanel1.add(jButton1);
						jButton1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/disk.png")));
						jButton1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButton1ActionPerformed(evt);
							}
						});
					}
					{
						jExportExcelButton = new JButton();
						jPanel1.add(jExportExcelButton);
						jExportExcelButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/famfam_icons/excel.gif")));
						jExportExcelButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jExportExcelButtonActionPerformed(evt);
							}
						});
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!CommonLib.saveImage(this.getParent(), file)) {
				JOptionPane.showMessageDialog(this, "Cannot save image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void jExportExcelButtonActionPerformed(ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			CommonLib.exportRegisterHistory(file);
		}
	}

	private void jCSLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jCSTextField.getText());
	}

	private void jEIPLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jEIPTextField.getText());
	}

	private void jDSLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jDSTextField.getText());
	}

	private void jESLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jESTextField.getText());
	}

	private void jFSLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jFSTextField.getText());
	}

	private void jGSLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jGSTextField.getText());
	}

	private void jSSLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jSSTextField.getText());
	}

	private void jEFlagsLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jEFLAGSTextField.getText());
	}

	private void jEAXLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jEAXTextField.getText());
	}

	private void jEBXLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jEBXTextField.getText());
	}

	private void jECXLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jECXTextField.getText());
	}

	private void jEDXLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jEDXTextField.getText());
	}

	private void jESILabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jESITextField.getText());
	}

	private void jEDILabel6MouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jEDITextField.getText());
	}

	private void jEBPLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jEBPTextField.getText());
	}

	private void jESPLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jESPTextField.getText());
	}

	private void jGDTRLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jGDTRTextField.getText());
	}

	private void jLDTRLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jLDTRTextField.getText());
	}

	private void jIDTRLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jIDTRTextField.getText());
	}

	private void jTRLabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jTRTextField.getText());
	}

	private void jCR0LabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jCR0TextField.getText());
	}

	private void jCR2LabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jCR2TextField.getText());
	}

	private void jCR3LabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jCR3TextField.getText());
	}

	private void jCR4LabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jCR4TextField.getText());
	}

	private void jDR0LabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jDR0TextField.getText());
	}

	private void jDR1LabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jDR1TextField.getText());
	}

	private void jDR2LabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jDR2TextField.getText());
	}

	private void jDR3LabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jDR3TextField.getText());
	}

	private void jDR6LabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jDR6TextField.getText());
	}

	private void jDR7LabelMouseClicked(MouseEvent evt) {
		application.jMemoryAddressComboBox.setSelectedItem(this.jDR7TextField.getText());
	}
}
