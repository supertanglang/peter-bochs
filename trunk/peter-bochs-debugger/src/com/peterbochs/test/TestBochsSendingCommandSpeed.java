package com.peterbochs.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import com.peterbochs.Global;

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
public class TestBochsSendingCommandSpeed extends JFrame {
	String line;
	private JButton jButton1;
	private JLabel jLabel1;
	Vector<String> lines = new Vector<String>();
	BufferedWriter commandOutputStream;
	InputStream is;
	private JButton jSButton;

	public static void main(String[] args) {
		TestBochsSendingCommandSpeed frame = new TestBochsSendingCommandSpeed();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public TestBochsSendingCommandSpeed() {

		try {
			{
				getContentPane().setLayout(null);
				this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				{
					jSButton = new JButton();
					getContentPane().add(jSButton);
					jSButton.setText("s");
					jSButton.setBounds(22, 21, 108, 29);
					jSButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jSButtonActionPerformed(evt);
						}
					});
				}
				{
					jButton1 = new JButton();
					getContentPane().add(jButton1);
					jButton1.setText("start");
					jButton1.setBounds(159, 24, 74, 26);
					jButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButton1ActionPerformed(evt);
						}
					});
				}
				{
					jLabel1 = new JLabel();
					getContentPane().add(jLabel1);
					jLabel1.setText("jLabel1");
					jLabel1.setBounds(27, 78, 435, 30);
				}
			}
			{
				this.setSize(490, 338);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendCommand(String command) {
		try {
			command = command.toLowerCase().trim();

			Global.lastCommand = command;
			commandOutputStream.write(command + "\n");
			commandOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void jSButtonActionPerformed(ActionEvent evt) {
		new Thread() {
			public void run() {
				try {
					int len;
					long lastTime = new Date().getTime();
					int lastCount = 1;
					int speed = 0;
					for (int x = 0; x < 1000000; x++) {
						sendCommand("s");
						byte[] buffer = new byte[1024];
						len = is.read(buffer);

						sendCommand("r");
						len = is.read(buffer);
						
						sendCommand("ptime");
						len = is.read(buffer);
						
						sendCommand("sreg");
						len = is.read(buffer);
						
						sendCommand("info eflags");
						len = is.read(buffer);
						
						

						jLabel1.setText("Step " + x + " / " + 1000000 + ", speed : " + speed + " steps/second");
						if (new Date().getTime() - lastTime >= 1000) {
							speed = x - lastCount;
							lastCount = x;
							lastTime = new Date().getTime();
						}
					}
					System.out.println("End");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}.start();
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		try {
			Process p;
			String[] arguments = { "..\\bochsdbg.exe", "-q", "-f", "bochsrc.bxrc" };
			ProcessBuilder pb = new ProcessBuilder(arguments);

			pb.redirectErrorStream(true);
			p = pb.start();
			is = p.getInputStream();
			commandOutputStream = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
