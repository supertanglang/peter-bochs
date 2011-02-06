package peter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
public class SystemMapDialog extends javax.swing.JDialog {
	private JScrollPane jScrollPane1;
	private JCheckBox jShowSelectedOnlyCheckBox;
	private JButton jCancelButton;
	private JButton jSetButton;
	private JPanel jPanel1;
	private JTable jTable1;
	File file;
	SystemMapTableModel model = new SystemMapTableModel();

	public SystemMapDialog(JFrame frame, File file) {
		super(frame, true);
		this.file = file;

		model.load(file);
		initGUI();
	}

	private void initGUI() {
		try {
			{
				this.setTitle("Load System.map");
				{
					jScrollPane1 = new JScrollPane();
					getContentPane().add(jScrollPane1, BorderLayout.CENTER);
					{
						jTable1 = new JTable();
						jScrollPane1.setViewportView(jTable1);
						jTable1.setModel(model);
						jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
						jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
						jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
						jTable1.getColumnModel().getColumn(3).setPreferredWidth(400);
					}
				}
				{
					jPanel1 = new JPanel();
					getContentPane().add(jPanel1, BorderLayout.SOUTH);
					{
						jShowSelectedOnlyCheckBox = new JCheckBox();
						jPanel1.add(jShowSelectedOnlyCheckBox);
						jShowSelectedOnlyCheckBox.setText("Show selected only");
					}
					{
						jSetButton = new JButton();
						jPanel1.add(jSetButton);
						jSetButton.setText("Set breakpoint");
						jSetButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jSetButtonActionPerformed(evt);
							}
						});
					}
					{
						jCancelButton = new JButton();
						jPanel1.add(jCancelButton);
						jCancelButton.setText("Cancel");
						jCancelButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jCancelButtonActionPerformed(evt);
							}
						});
					}
				}
			}
			this.setSize(700, 700);
			CommonLib.centerDialog(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jSetButtonActionPerformed(ActionEvent evt) {
		System.out.println("jSetButton.actionPerformed, event=" + evt);
		//TODO add your code for jSetButton.actionPerformed
	}

	private void jCancelButtonActionPerformed(ActionEvent evt) {
		setVisible(false);
	}

}
