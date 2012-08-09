package com.peterbochs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

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
		pb = new ProcessBuilder("/Users/peter/install/bin/bochs", "-q");

		pb.redirectErrorStream(true);
		try {
			p = pb.start();
			InputStream is = p.getInputStream();
			commandReceiver = new CommandReceiver(is, null);
			new Thread(commandReceiver, "commandReceiver thread").start();
			commandReceiver.shouldShow = false;

			commandOutputStream = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
			sendCommand("ptime");
			String result = commandReceiver.getCommandResultUntilEnd();
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
