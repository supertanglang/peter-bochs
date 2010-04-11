package peter;

import info.clearthought.layout.TableLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used commercially (ie, by a
 * corporation, company or business for any purpose whatever) then you should purchase a license for each developer using Jigloo. Please visit www.cloudgarden.com for details. Use
 * of Jigloo implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR ANY
 * CORPORATE OR COMMERCIAL PURPOSE.
 */
public class JSettingDialog extends javax.swing.JDialog {
	private JCheckBox jCheckBox1;
	private JCheckBox jCheckBox2;
	private JCheckBox jFastStepIDTCheckBox;
	private JCheckBox jFastStepLDTCheckBox;
	private JCheckBox jFastStepGDTCheckBox;
	private JCheckBox jFastStepBreakpointCheckBox;
	private JCheckBox jFastStepInstructionCheckBox;
	private JCheckBox jFastStepMemoryCheckBox;
	private JCheckBox jFastStepRegisterCheckBox;
	private JPanel jPanel2;
	private JLabel jLabel9;
	private JCheckBox jBochsIDTCheckBox;
	private JCheckBox jBochsLDTCheckBox;
	private JCheckBox jBochsGDTCheckBox;
	private JCheckBox jBochsHistoryCheckBox;
	private JCheckBox jBochsAddressTranslateCheckBox;
	private JCheckBox jBochsStackCheckBox;
	private JCheckBox jBochsPageTableCheckBox;
	private JCheckBox jBochsBreakpointCheckBox;
	private JCheckBox jBochsInstructionCheckBox;
	private JCheckBox jBochsMemoryCheckBox;
	private JCheckBox jBochsRegisterCheckBox;
	private JPanel jPanel1;

	/**
	 * Auto-generated main method to display this JDialog
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				JSettingDialog inst = new JSettingDialog(frame);
				inst.setVisible(true);
			}
		});
	}

	public JSettingDialog(JFrame frame) {
		super(frame, true);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			TableLayout thisLayout = new TableLayout(new double[][] { { TableLayout.FILL, TableLayout.FILL },
					{ TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.FILL } });
			thisLayout.setHGap(5);
			thisLayout.setVGap(5);
			getContentPane().setLayout(thisLayout);
			this.setTitle("Setting");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				jCheckBox1 = new JCheckBox();
				getContentPane().add(jCheckBox1, "0, 0");
				jCheckBox1.setText("Load breakpoint at startup");
				jCheckBox1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jCheckBox1ActionPerformed(evt);
					}
				});
			}
			{
				jCheckBox2 = new JCheckBox();
				getContentPane().add(jCheckBox2, "0, 1, 1, 1");
				jCheckBox2.setText("Update status after bochs command");
				jCheckBox2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jCheckBox2ActionPerformed(evt);
					}
				});
			}
			{
				jPanel1 = new JPanel();
				TableLayout jPanel1Layout = new TableLayout(new double[][] { { 34.0, TableLayout.FILL, TableLayout.FILL, TableLayout.PREFERRED },
						{ 15.0, 15.0, 15.0, TableLayout.PREFERRED } });
				jPanel1Layout.setHGap(10);
				jPanel1Layout.setVGap(5);
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, "0, 2, 1, 2");
				{
					jBochsRegisterCheckBox = new JCheckBox();
					jPanel1.add(jBochsRegisterCheckBox, "1, 0");
					jBochsRegisterCheckBox.setText("Registers");
					jBochsRegisterCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jCheckBox3ActionPerformed(evt);
						}
					});
				}
				{
					jBochsMemoryCheckBox = new JCheckBox();
					jPanel1.add(jBochsMemoryCheckBox, "2, 0");
					jBochsMemoryCheckBox.setText("Memory");
					jBochsMemoryCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jCheckBox4ActionPerformed(evt);
						}
					});
				}
				{
					jBochsInstructionCheckBox = new JCheckBox();
					jPanel1.add(jBochsInstructionCheckBox, "3, 0");
					jBochsInstructionCheckBox.setText("Insturction table");
					jBochsInstructionCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jCheckBox5ActionPerformed(evt);
						}
					});
				}
				{
					jBochsBreakpointCheckBox = new JCheckBox();
					jPanel1.add(jBochsBreakpointCheckBox, "1, 1");
					jBochsBreakpointCheckBox.setText("Breakpoint");
					jBochsBreakpointCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jCheckBox6ActionPerformed(evt);
						}
					});
				}
				{
					jBochsGDTCheckBox = new JCheckBox();
					jPanel1.add(jBochsGDTCheckBox, "2, 1");
					jBochsGDTCheckBox.setText("GDT");
					jBochsGDTCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jCheckBox7ActionPerformed(evt);
						}
					});
				}
				{
					jBochsLDTCheckBox = new JCheckBox();
					jPanel1.add(jBochsLDTCheckBox, "3, 1");
					jBochsLDTCheckBox.setText("LDT");
					jBochsLDTCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jCheckBox8ActionPerformed(evt);
						}
					});
				}
				{
					jBochsIDTCheckBox = new JCheckBox();
					jPanel1.add(jBochsIDTCheckBox, "1, 2");
					jBochsIDTCheckBox.setText("IDT");
					jBochsIDTCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jCheckBox9ActionPerformed(evt);
						}
					});
				}
				{
					jBochsPageTableCheckBox = new JCheckBox();
					jPanel1.add(jBochsPageTableCheckBox, "2, 2");
					jBochsPageTableCheckBox.setText("Page Table");
					jBochsPageTableCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jBochsPageTableCheckBoxActionPerformed(evt);
						}
					});
				}
				{
					jBochsStackCheckBox = new JCheckBox();
					jPanel1.add(jBochsStackCheckBox, "3, 2");
					jBochsStackCheckBox.setText("Stack");
					jBochsStackCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jBochsStackCheckBoxActionPerformed(evt);
						}
					});
				}
				{
					jBochsAddressTranslateCheckBox = new JCheckBox();
					jPanel1.add(jBochsAddressTranslateCheckBox, "1, 3, 2, 3");
					jBochsAddressTranslateCheckBox.setText("Address Translate");
					jBochsAddressTranslateCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jBochsAddressTranslateCheckBoxActionPerformed(evt);
						}
					});
				}
				{
					jBochsHistoryCheckBox = new JCheckBox();
					jPanel1.add(jBochsHistoryCheckBox, "3, 3");
					jBochsHistoryCheckBox.setText("History");
					jBochsHistoryCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jBochsHistoryCheckBoxActionPerformed(evt);
						}
					});
				}
			}
			{
				jLabel9 = new JLabel();
				getContentPane().add(jLabel9, "0, 3, 1, 3");
				jLabel9.setText("What panel will update after \"fast step\" button");
			}
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2, "0, 4, 1, 4");
				TableLayout jPanel2Layout = new TableLayout(new double[][] { { 34.0, TableLayout.FILL, TableLayout.FILL, TableLayout.PREFERRED },
						{ 15.0, 15.0, 15.0, TableLayout.FILL } });
				jPanel2Layout.setHGap(10);
				jPanel2Layout.setVGap(5);
				jPanel2.setLayout(jPanel2Layout);
				{
					jFastStepRegisterCheckBox = new JCheckBox();
					jPanel2.add(jFastStepRegisterCheckBox, "1, 0");
					jFastStepRegisterCheckBox.setText("Registers");
					jFastStepRegisterCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jFastStepRegisterCheckBoxActionPerformed(evt);
						}
					});
				}
				{
					jFastStepMemoryCheckBox = new JCheckBox();
					jPanel2.add(jFastStepMemoryCheckBox, "2, 0");
					jFastStepMemoryCheckBox.setText("Memory");
					jFastStepMemoryCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jFastStepMemoryCheckBoxActionPerformed(evt);
						}
					});
				}
				{
					jFastStepInstructionCheckBox = new JCheckBox();
					jPanel2.add(jFastStepInstructionCheckBox, "3, 0");
					jFastStepInstructionCheckBox.setText("Insturction table");
					jFastStepInstructionCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jFastStepInstructionCheckBoxActionPerformed(evt);
						}
					});
				}
				{
					jFastStepBreakpointCheckBox = new JCheckBox();
					jPanel2.add(jFastStepBreakpointCheckBox, "1, 1");
					jFastStepBreakpointCheckBox.setText("Breakpoint");
					jFastStepBreakpointCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jFastStepBreakpointCheckBoxActionPerformed(evt);
						}
					});
				}
				{
					jFastStepGDTCheckBox = new JCheckBox();
					jPanel2.add(jFastStepGDTCheckBox, "2, 1");
					jFastStepGDTCheckBox.setText("GDT");
					jFastStepGDTCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jFastStepGDTCheckBoxActionPerformed(evt);
						}
					});
				}
				{
					jFastStepLDTCheckBox = new JCheckBox();
					jPanel2.add(jFastStepLDTCheckBox, "3, 1");
					jFastStepLDTCheckBox.setText("LDT");
					jFastStepLDTCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jFastStepLDTCheckBoxActionPerformed(evt);
						}
					});
				}
				{
					jFastStepIDTCheckBox = new JCheckBox();
					jPanel2.add(jFastStepIDTCheckBox, "1, 2");
					jFastStepIDTCheckBox.setText("IDT");
					jFastStepIDTCheckBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jFastStepIDTCheckBoxActionPerformed(evt);
						}
					});
				}
			}
			setSize(400, 300);
			pack();
			initValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initValue() {
		jCheckBox1.setSelected(Setting.getInstance().isLoadBreakpointAtStartup());
		jCheckBox2.setSelected(Setting.getInstance().isUpdateAfterBochsCommand());

		jBochsRegisterCheckBox.setSelected(Setting.getInstance().isUpdateAfterBochsCommand_register());
		jBochsMemoryCheckBox.setSelected(Setting.getInstance().isUpdateAfterBochsCommand_memory());
		jBochsInstructionCheckBox.setSelected(Setting.getInstance().isUpdateAfterBochsCommand_instruction());
		jBochsBreakpointCheckBox.setSelected(Setting.getInstance().isUpdateAfterBochsCommand_breakpoint());
		jBochsGDTCheckBox.setSelected(Setting.getInstance().isUpdateAfterBochsCommand_gdt());
		jBochsLDTCheckBox.setSelected(Setting.getInstance().isUpdateAfterBochsCommand_ldt());
		jBochsIDTCheckBox.setSelected(Setting.getInstance().isUpdateAfterBochsCommand_idt());
		jBochsPageTableCheckBox.setSelected(Setting.getInstance().isUpdateAfterBochsCommand_pageTable());
		jBochsAddressTranslateCheckBox.setSelected(Setting.getInstance().isUpdateAfterBochsCommand_addressTranslate());
		jBochsStackCheckBox.setSelected(Setting.getInstance().isUpdateAfterBochsCommand_stack());
		jBochsHistoryCheckBox.setSelected(Setting.getInstance().isUpdateAfterBochsCommand_history());

		jFastStepIDTCheckBox.setSelected(Setting.getInstance().isUpdateFastStepCommand_idt());
		jFastStepLDTCheckBox.setSelected(Setting.getInstance().isUpdateFastStepCommand_ldt());
		jFastStepGDTCheckBox.setSelected(Setting.getInstance().isUpdateFastStepCommand_gdt());
		jFastStepBreakpointCheckBox.setSelected(Setting.getInstance().isUpdateFastStepCommand_breakpoint());
		jFastStepInstructionCheckBox.setSelected(Setting.getInstance().isUpdateFastStepCommand_instruction());
		jFastStepMemoryCheckBox.setSelected(Setting.getInstance().isUpdateFastStepCommand_memory());
		jFastStepRegisterCheckBox.setSelected(Setting.getInstance().isUpdateFastStepCommand_register());

	}

	private void jCheckBox1ActionPerformed(ActionEvent evt) {
		Setting.getInstance().setLoadBreakpointAtStartup(jCheckBox1.isSelected());
	}

	private void jCheckBox2ActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateAfterBochsCommand(jCheckBox2.isSelected());
	}

	private void thisWindowClosing(WindowEvent evt) {
		Setting.getInstance().save();
	}

	private void jCheckBox3ActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateAfterBochsCommand_register(jBochsRegisterCheckBox.isSelected());
	}

	private void jCheckBox4ActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateAfterBochsCommand_memory(jBochsMemoryCheckBox.isSelected());
	}

	private void jCheckBox5ActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateAfterBochsCommand_instruction(jBochsInstructionCheckBox.isSelected());
	}

	private void jCheckBox6ActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateAfterBochsCommand_breakpoint(jBochsBreakpointCheckBox.isSelected());
	}

	private void jCheckBox7ActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateAfterBochsCommand_gdt(jBochsGDTCheckBox.isSelected());
	}

	private void jCheckBox8ActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateAfterBochsCommand_ldt(jBochsLDTCheckBox.isSelected());
	}

	private void jCheckBox9ActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateAfterBochsCommand_idt(jBochsIDTCheckBox.isSelected());
	}

	private void jBochsPageTableCheckBoxActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateAfterBochsCommand_pageTable(jBochsPageTableCheckBox.isSelected());
	}

	private void jBochsStackCheckBoxActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateAfterBochsCommand_stack(jBochsStackCheckBox.isSelected());
	}

	private void jBochsAddressTranslateCheckBoxActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateAfterBochsCommand_addressTranslate(jBochsAddressTranslateCheckBox.isSelected());
	}

	private void jBochsHistoryCheckBoxActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateAfterBochsCommand_history(jBochsHistoryCheckBox.isSelected());
	}

	private void jFastStepRegisterCheckBoxActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateFastStepCommand_register(jFastStepRegisterCheckBox.isSelected());
	}

	private void jFastStepMemoryCheckBoxActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateFastStepCommand_memory(jFastStepMemoryCheckBox.isSelected());
	}

	private void jFastStepInstructionCheckBoxActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateFastStepCommand_instruction(jFastStepInstructionCheckBox.isSelected());
	}

	private void jFastStepBreakpointCheckBoxActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateFastStepCommand_breakpoint(jFastStepBreakpointCheckBox.isSelected());
	}

	private void jFastStepGDTCheckBoxActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateFastStepCommand_gdt(jFastStepGDTCheckBox.isSelected());
	}

	private void jFastStepLDTCheckBoxActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateFastStepCommand_ldt(jFastStepLDTCheckBox.isSelected());
	}

	private void jFastStepIDTCheckBoxActionPerformed(ActionEvent evt) {
		Setting.getInstance().setUpdateFastStepCommand_idt(jFastStepIDTCheckBox.isSelected());
	}

}
