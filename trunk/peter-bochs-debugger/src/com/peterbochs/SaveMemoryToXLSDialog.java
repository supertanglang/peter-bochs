package com.peterbochs;

import info.clearthought.layout.TableLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.peterswing.CommonLib;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used commercially (ie, by a
 * corporation, company or business for any purpose whatever) then you should purchase a license for each developer using Jigloo. Please visit www.cloudgarden.com for details. Use
 * of Jigloo implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR ANY
 * CORPORATE OR COMMERCIAL PURPOSE.
 */
public class SaveMemoryToXLSDialog extends javax.swing.JDialog {
	public JRadioButton jCurrentWindowRadioButton;
	public JRadioButton jRadioButton1;
	private JLabel jToLabel;
	private JProgressBar jProgressBar1;
	private JButton jExportButton;
	public JTextField jToTextField;
	public JTextField jFromTextField;
	private ButtonGroup buttonGroup1;
	private JLabel jLabel1;
	public boolean ok;

	/**
	 * Auto-generated main method to display this JDialog
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.petersoft.white.PetersoftWhiteLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				SaveMemoryToXLSDialog inst = new SaveMemoryToXLSDialog(frame);
				inst.setVisible(true);
			}
		});
	}

	public SaveMemoryToXLSDialog(JFrame frame) {
		super(frame, true);
		initGUI();
	}

	private void initGUI() {
		try {
			{
				TableLayout thisLayout = new TableLayout(new double[][] { { 7.0, 20.0, 49.0, TableLayout.FILL, 36.0, TableLayout.FILL, 7.0 },
						{ TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, 3.0 } });
				thisLayout.setHGap(5);
				thisLayout.setVGap(5);
				getContentPane().setLayout(thisLayout);
				this.setTitle("Save memory to excel");
				{
					jCurrentWindowRadioButton = new JRadioButton();
					getContentPane().add(jCurrentWindowRadioButton, "1, 1, 3, 1");
					jCurrentWindowRadioButton.setText("Same as memory window");
					getButtonGroup1().add(jCurrentWindowRadioButton);
					jCurrentWindowRadioButton.setSelected(true);
					jCurrentWindowRadioButton.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jCurrentWindowRadioButtonMouseClicked(evt);
						}
					});
				}
				{
					jLabel1 = new JLabel();
					getContentPane().add(jLabel1, "1, 0, 5, 0");
					jLabel1.setText("Which range of memory you want to save to xls?");
				}
				{
					jRadioButton1 = new JRadioButton();
					getContentPane().add(jRadioButton1, "1, 2, 2, 2");
					jRadioButton1.setText("From");
					jRadioButton1.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jRadioButton1MouseClicked(evt);
						}
					});
					getButtonGroup1().add(jRadioButton1);
					getContentPane().add(getJFromTextField(), "3, 2");
					getContentPane().add(getJToLabel(), "4, 2");
					getContentPane().add(getJToTextField(), "5, 2");
					getContentPane().add(getJExportButton(), "4, 4, 5, 4");
					getContentPane().add(getJProgressBar1(), "1, 3, 5, 3");
				}
			}
			this.setSize(391, 156);
			CommonLib.centerDialog(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ButtonGroup getButtonGroup1() {
		if (buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
		}
		return buttonGroup1;
	}

	private JTextField getJFromTextField() {
		if (jFromTextField == null) {
			jFromTextField = new JTextField();
			jFromTextField.setEnabled(false);
		}
		return jFromTextField;
	}

	private JLabel getJToLabel() {
		if (jToLabel == null) {
			jToLabel = new JLabel();
			jToLabel.setText("To");
			jToLabel.setHorizontalAlignment(SwingConstants.CENTER);
			jToLabel.setEnabled(false);
		}
		return jToLabel;
	}

	private JTextField getJToTextField() {
		if (jToTextField == null) {
			jToTextField = new JTextField();
			jToTextField.setEnabled(false);
		}
		return jToTextField;
	}

	private JButton getJExportButton() {
		if (jExportButton == null) {
			jExportButton = new JButton();
			jExportButton.setText("Export to excel");
			jExportButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/peterbochs/icons/famfam_icons/excel.gif")));
			jExportButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jExportButtonActionPerformed(evt);
				}
			});
		}
		return jExportButton;
	}

	private void jExportButtonActionPerformed(ActionEvent evt) {
		if (this.jCurrentWindowRadioButton.isSelected()) {
			ok = true;
		} else {
			try {
				int totalByte = (int) (CommonLib.convertFilesize(jToTextField.getText()) - CommonLib.convertFilesize(jFromTextField.getText()) + 1);
				if (totalByte > 64 * 1024) {
					JOptionPane.showMessageDialog(this, "Cannot dump more than 64KB, because it is too slow");
				} else {
					JFileChooser fc = new JFileChooser();
					int returnVal = fc.showSaveDialog(this);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						if (!file.getName().toLowerCase().endsWith(".xls")) {
							file = new File(file.getAbsolutePath() + ".xls");
						}
						PeterBochsDebugger.commandReceiver.shouldShow = false;
						int bytes[] = PeterBochsDebugger.getMemory(CommonLib.convertFilesize(jFromTextField.getText()), totalByte, true);
						PeterBochsCommonLib.exportTableModelToExcel(file, bytes, jFromTextField.getText(), CommonLib.convertFilesize(jFromTextField.getText()));
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "Error, unable to export");
			}
		}
		setVisible(false);
	}

	private JProgressBar getJProgressBar1() {
		if (jProgressBar1 == null) {
			jProgressBar1 = new JProgressBar();
			jProgressBar1.setVisible(false);
		}
		return jProgressBar1;
	}

	private void jRadioButton1MouseClicked(MouseEvent evt) {
		this.jFromTextField.setEnabled(true);
		this.jToLabel.setEnabled(true);
		this.jToTextField.setEnabled(true);
	}

	private void jCurrentWindowRadioButtonMouseClicked(MouseEvent evt) {
		this.jFromTextField.setEnabled(false);
		this.jToLabel.setEnabled(false);
		this.jToTextField.setEnabled(false);
	}

}
