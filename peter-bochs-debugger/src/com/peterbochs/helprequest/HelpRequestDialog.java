package com.peterbochs.helprequest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.LineBorder;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;


import com.peterbochs.Application;
import com.peterbochs.CommandReceiver;
import com.peterswing.advancedswing.enhancedtextarea.EnhancedTextArea;

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
public class HelpRequestDialog extends javax.swing.JDialog {
	private JButton jSendButton;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JScrollPane jScrollPane1;
	private JTextField jNameTextField;
	private EnhancedTextArea jInfoTextArea;
	private JTextArea jMessageTextField;
	private JTextField jEmailTextField;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private CommandReceiver commandReceiver;

	public HelpRequestDialog(JFrame frame, CommandReceiver commandReceiver) {
		super(frame);
		this.commandReceiver = commandReceiver;
		initGUI();
	}

	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent) getContentPane());
			getContentPane().setLayout(thisLayout);
			this.setTitle("I need help");
			{
				jSendButton = new JButton();
				jSendButton.setText("Send help request");
				jSendButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jSendButtonActionPerformed(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				jLabel1.setText("<- Press this button, it will send the information to the author, so that he can help you");
			}
			{
				jLabel4 = new JLabel();
				jLabel4.setText("Below are the auto-collected information, will be send to the author");
			}
			{
				jInfoTextArea = new EnhancedTextArea();
			}
			{
				jLabel5 = new JLabel();
				jLabel5.setText("Name");
			}
			{
				jNameTextField = new JTextField();
			}
			{
				jLabel2 = new JLabel();
				jLabel2.setText("Email");
			}
			{
				jEmailTextField = new JTextField();
			}
			{
				jLabel3 = new JLabel();
				jLabel3.setText("Massage");
			}
			{
				jScrollPane1 = new JScrollPane();
				jScrollPane1.setBorder(new LineBorder(new java.awt.Color(88, 88, 88), 1, false));
				{
					jMessageTextField = new JTextArea();
					jScrollPane1.setViewportView(jMessageTextField);
				}
			}
			thisLayout.setVerticalGroup(thisLayout
					.createSequentialGroup()
					.addContainerGap()
					.addGroup(
							thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(jSendButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addComponent(jLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(
							thisLayout
									.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(jEmailTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(jLabel2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(jLabel5, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(jNameTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(
							thisLayout
									.createParallelGroup()
									.addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addGroup(
											GroupLayout.Alignment.LEADING,
											thisLayout.createSequentialGroup().addGap(8)
													.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE).addGap(42)))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jInfoTextArea, 0, 207, Short.MAX_VALUE).addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout
					.createSequentialGroup()
					.addContainerGap()
					.addGroup(
							thisLayout
									.createParallelGroup()
									.addGroup(
											thisLayout
													.createSequentialGroup()
													.addGroup(
															thisLayout
																	.createParallelGroup()
																	.addComponent(jLabel3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 54,
																			GroupLayout.PREFERRED_SIZE)
																	.addGroup(
																			GroupLayout.Alignment.LEADING,
																			thisLayout.createSequentialGroup()
																					.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE).addGap(18)))
													.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
													.addGroup(
															thisLayout
																	.createParallelGroup()
																	.addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, 0, 560, Short.MAX_VALUE)
																	.addGroup(
																			GroupLayout.Alignment.LEADING,
																			thisLayout.createSequentialGroup()
																					.addComponent(jEmailTextField, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
																					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																					.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
																					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																					.addComponent(jNameTextField, 0, 239, Short.MAX_VALUE))))
									.addGroup(
											GroupLayout.Alignment.LEADING,
											thisLayout.createSequentialGroup().addComponent(jSendButton, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel1, 0, 474, Short.MAX_VALUE))
									.addGroup(
											GroupLayout.Alignment.LEADING,
											thisLayout.createSequentialGroup().addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
													.addGap(0, 177, Short.MAX_VALUE)).addComponent(jInfoTextArea, GroupLayout.Alignment.LEADING, 0, 626, Short.MAX_VALUE))
					.addContainerGap());

			this.setSize(666, 425);
			jInfoTextArea.setEnabled(false);
			jInfoTextArea.setBorder(new LineBorder(new java.awt.Color(88, 88, 88), 1, false));
			jInfoTextArea.getTextArea().setEnabled(false);

			String commands[] = { "r", "info eflags", "xp /10bx 0x1000", "disasm cs:eip", "disasm 0x7c00 0x7cff", "info gdt 0 10", "info idt 0 10", "xp /4096bx 0x1000",
					"print-stack 40", "info tab", "info break" };
			String result = "";
			for (String c : commands) {
				Application.sendCommand(c);
				result += "\n\n" + c + "\n\n" + commandReceiver.getCommandResultUntilEnd();
			}
			jInfoTextArea.setText(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jSendButtonActionPerformed(ActionEvent evt) {
		String url = "http://webservice1.petersoft.com/NuSoapServer.php";
		Service service = new Service();
		try {
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(url));
			call.setOperationName("peterBochsHelpRequest");
			call.addParameter("Name", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("Email", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("Message", XMLType.XSD_STRING, ParameterMode.IN);
			call.setReturnType(XMLType.XSD_STRING);
			String res = (String) call.invoke(new Object[] { jNameTextField.getText(), jEmailTextField.getText(),
					jMessageTextField.getText() + "\n-------------------\n" + jInfoTextArea.getTextArea().getText() });
			if (res.equals("ok")) {
				JOptionPane.showMessageDialog(this, "Message is sent to Peter, thanks");
			} else {
				JOptionPane.showMessageDialog(this, "Send fail, please check network connection");
			}
			return;
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(this, "Send fail");
	}
}
