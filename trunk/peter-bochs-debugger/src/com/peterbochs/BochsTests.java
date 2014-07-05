package com.peterbochs;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JEditorPane;
import javax.swing.SwingUtilities;

public class BochsTests {
	CommandReceiver commandReceiver;
	BufferedWriter commandOutputStream;

	public static void main(String args[]) {
		new BochsTests().test();
	}

	public void test() {
		Process p = null;

		if (p != null) {
			p.destroy();
		}

		ProcessBuilder pb;
		pb = new ProcessBuilder("/Users/peter/Downloads/bochs-2.6.6-install/bin/bochs", "-q", "-f", "bochsrc.txt");

		pb.redirectErrorStream(true);
		try {
			p = pb.start();
			InputStream is = p.getInputStream();
			commandReceiver = new CommandReceiver(is, null);
			new Thread() {
				public void run() {
					try {
						final BufferedReader br = new BufferedReader(new InputStreamReader(is), 1024);
						String line;
						while ((line = br.readLine()) != null) {
							System.out.println(">" + line);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}.start();

			commandOutputStream = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
//			sendCommand("\n");
			String result = commandReceiver.getCommandResult();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendCommand(String command) {
		try {
			command = command.toLowerCase().trim();

			commandReceiver.clearBuffer();
			Global.lastCommand = command;
			commandOutputStream.write(command + "\n");
			commandOutputStream.flush();
			if (!command.equals("6") && !command.equals("c") && !command.startsWith("pb") && !command.startsWith("vb") && !command.startsWith("lb") && !command.startsWith("bpd")
					&& !command.startsWith("bpe") && !command.startsWith("del") && !command.startsWith("set")) {
				commandReceiver.waitUntilHaveInput();
				return;
			}
		} catch (IOException e) {
		}
	}
}
