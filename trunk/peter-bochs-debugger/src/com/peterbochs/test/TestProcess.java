package com.peterbochs.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestProcess implements Runnable {
	String line;
	Vector<String> lines = new Vector<String>();
	BufferedReader br;

	public static void main(String[] args) {
		new TestProcess();
	}

	public TestProcess() {
		Process p;
		String[] arguments = { "/Users/peter/install/bin/bochs", "-q", "-f", "bochsrc.bxrc" };
		//		String[] arguments = { "bochs", "-q", "-f", "bochsrc.bxrc" };
		ProcessBuilder pb = new ProcessBuilder(arguments);

		pb.redirectErrorStream(true);
		try {
			p = pb.start();
			InputStream is = p.getInputStream();
			br = new BufferedReader(new InputStreamReader(is), 1024);
			BufferedWriter commandOutputStream = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));

			new Thread(this).start();

			Thread.currentThread().sleep(500);
			// commandOutputStream.write("info eflags" + "\n");
			commandOutputStream.write("disasm cs:65520 0xf000:0x100b8" + "\n");
			//			commandOutputStream.write("c\n");
			//			commandOutputStream.write("r\n");
			//			commandOutputStream.write("ptime" + "\n");
			commandOutputStream.flush();

			Thread.currentThread().sleep(200000);
			System.out.println("End");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			while ((line = br.readLine()) != null) {
				synchronized (lines) {
					System.out.println("line=" + line);

					Matcher matcher = Pattern.compile("^.*<bochs[^>]*.*" + "disasm cs:65520 0xf000:0x100b8").matcher(line);
					if (matcher.matches()) {
						System.out.println("matched");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
