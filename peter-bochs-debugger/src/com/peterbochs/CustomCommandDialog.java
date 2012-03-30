package com.peterbochs;

import info.clearthought.layout.TableLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

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
public class CustomCommandDialog extends javax.swing.JDialog {
	private JPanel jPanel1;
	private JButton jRunButton;
	public JSpinner jSpinner6;
	public JSpinner jSpinner5;
	public JSpinner jSpinner4;
	public JSpinner jSpinner3;
	public JSpinner jSpinner2;
	public JSpinner jSpinner1;
	public JComboBox jComboBox6;
	public JComboBox jComboBox5;
	public JComboBox jComboBox4;
	public JComboBox jComboBox3;
	public JComboBox jComboBox2;
	public JComboBox jComboBox1;
	private JLabel jLabel2;
	private JLabel jLabel1;
	SpinnerNumberModel model1 = new SpinnerNumberModel(1, 1, 100, 1);
	SpinnerNumberModel model2 = new SpinnerNumberModel(1, 1, 100, 1);
	SpinnerNumberModel model3 = new SpinnerNumberModel(1, 1, 100, 1);
	SpinnerNumberModel model4 = new SpinnerNumberModel(1, 1, 100, 1);
	SpinnerNumberModel model5 = new SpinnerNumberModel(1, 1, 100, 1);
	SpinnerNumberModel model6 = new SpinnerNumberModel(1, 1, 100, 1);
	SpinnerNumberModel repeatModel = new SpinnerNumberModel(1, 1, 10000, 1);
	DefaultComboBoxModel comboBoxModel1 = new DefaultComboBoxModel(new String[] { "", "c", "s" });
	public JSpinner jRepeatSpinner;
	private JLabel jLabel3;
	DefaultComboBoxModel comboBoxModel2 = new DefaultComboBoxModel(new String[] { "", "c", "s" });
	DefaultComboBoxModel comboBoxModel3 = new DefaultComboBoxModel(new String[] { "", "c", "s" });
	DefaultComboBoxModel comboBoxModel4 = new DefaultComboBoxModel(new String[] { "", "c", "s" });
	DefaultComboBoxModel comboBoxModel5 = new DefaultComboBoxModel(new String[] { "", "c", "s" });
	DefaultComboBoxModel comboBoxModel6 = new DefaultComboBoxModel(new String[] { "", "c", "s" });
	public boolean ok;

	public static void main(String s[]) {
		try {
			UIManager.setLookAndFeel("com.petersoft.white.PetersoftWhiteLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		new CustomCommandDialog(null).setVisible(true);
	}

	public CustomCommandDialog(JFrame frame) {
		super(frame, true);
		GroupLayout thisLayout = new GroupLayout((JComponent) getContentPane());
		getContentPane().setLayout(thisLayout);
		this.setTitle("Run custom commands");
		{
			jPanel1 = new JPanel();
			TableLayout jPanel1Layout = new TableLayout(new double[][] { { TableLayout.FILL, TableLayout.FILL },
					{ TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL } });
			jPanel1Layout.setHGap(5);
			jPanel1Layout.setVGap(5);
			jPanel1.setLayout(jPanel1Layout);
			{
				jLabel1 = new JLabel();
				jPanel1.add(jLabel1, "0, 0");
				jLabel1.setText("Command");
				jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabel2 = new JLabel();
				jPanel1.add(jLabel2, "1, 0");
				jLabel2.setText("Count");
				jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jComboBox1 = new JComboBox();
				jPanel1.add(jComboBox1, "0, 1");
				jComboBox1.setModel(comboBoxModel1);
			}
			{
				jComboBox2 = new JComboBox();
				jPanel1.add(jComboBox2, "0, 2");
				jComboBox2.setModel(comboBoxModel2);
			}
			{
				jComboBox3 = new JComboBox();
				jPanel1.add(jComboBox3, "0, 3");
				jComboBox3.setModel(comboBoxModel3);
			}
			{
				jComboBox4 = new JComboBox();
				jPanel1.add(jComboBox4, "0, 4");
				jComboBox4.setModel(comboBoxModel4);
			}
			{
				jComboBox5 = new JComboBox();
				jPanel1.add(jComboBox5, "0, 5");
				jComboBox5.setModel(comboBoxModel5);
			}
			{
				jComboBox6 = new JComboBox();
				jPanel1.add(jComboBox6, "0, 6");
				jComboBox6.setModel(comboBoxModel6);
			}
			{
				jSpinner1 = new JSpinner();
				jPanel1.add(jSpinner1, "1, 1");
				jSpinner1.setModel(model1);
			}
			{
				jSpinner2 = new JSpinner();
				jPanel1.add(jSpinner2, "1, 2");
				jSpinner2.setModel(model2);
			}
			{
				jSpinner3 = new JSpinner();
				jPanel1.add(jSpinner3, "1, 3");
				jSpinner3.setModel(model3);
			}
			{
				jSpinner4 = new JSpinner();
				jPanel1.add(jSpinner4, "1, 4");
				jSpinner4.setModel(model4);
			}
			{
				jSpinner5 = new JSpinner();
				jPanel1.add(jSpinner5, "1, 5");
				jSpinner5.setModel(model5);
			}
			{
				jSpinner6 = new JSpinner();
				jPanel1.add(jSpinner6, "1, 6");
				jSpinner6.setModel(model6);
			}
		}
		{
			jRunButton = new JButton();
			jRunButton.setText("Run");
			jRunButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRunButtonActionPerformed(evt);
				}
			});
		}
		{
			jRepeatSpinner = new JSpinner();
			jRepeatSpinner.setModel(repeatModel);
			jRepeatSpinner.setVerifyInputWhenFocusTarget(false);
		}
		{
			jLabel3 = new JLabel();
			jLabel3.setText("Repeat all above commands");
			jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		thisLayout.setVerticalGroup(thisLayout
				.createSequentialGroup()
				.addContainerGap()
				.addComponent(jPanel1, 0, 174, Short.MAX_VALUE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(
						thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jRepeatSpinner, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jRunButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE).addContainerGap());
		thisLayout.setHorizontalGroup(thisLayout
				.createSequentialGroup()
				.addContainerGap()
				.addGroup(
						thisLayout
								.createParallelGroup()
								.addComponent(jPanel1, GroupLayout.Alignment.LEADING, 0, 279, Short.MAX_VALUE)
								.addGroup(
										GroupLayout.Alignment.LEADING,
										thisLayout
												.createSequentialGroup()
												.addGap(0, 15, Short.MAX_VALUE)
												.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(
														thisLayout
																.createParallelGroup()
																.addComponent(jRepeatSpinner, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
																.addGroup(
																		GroupLayout.Alignment.LEADING,
																		thisLayout.createSequentialGroup()
																				.addPreferredGap(jRepeatSpinner, jRunButton, LayoutStyle.ComponentPlacement.INDENT)
																				.addComponent(jRunButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))))
				.addContainerGap());
		{
			this.setSize(301, 281);
			com.peterswing.CommonLib.centerDialog(this);
		}
	}

	private void jRunButtonActionPerformed(ActionEvent evt) {
		ok = true;

		new Thread() {
			public void run() {
				try {
					// prevent jRepeatSpinner.getValue() get the old value
					Thread.currentThread().sleep(10);
					setVisible(false);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}.start();
	}

}
