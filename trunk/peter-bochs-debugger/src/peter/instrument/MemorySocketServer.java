package peter.instrument;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

import peter.CommonLib;
import peter.Global;

public class MemorySocketServer implements Runnable {
	int port;
	JTextArea jTextArea;
	boolean shouldStop;
	ServerSocket serverSocket;

	public void startServer(int port, JTextArea jTextArea) {
		this.port = port;
		this.jTextArea = jTextArea;
		jTextArea.setText("");

		shouldStop = false;
		new Thread(this).start();

		while (serverSocket == null) {
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		while (!serverSocket.isBound()) {
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stopServer() {
		shouldStop = true;
	}

	@Override
	public void run() {
		if (Global.debug) {
			System.out.println("Memory server start at port " + port);
		}

		try {

			serverSocket = new ServerSocket(port);
			while (!shouldStop) {
				Socket clientSocket = serverSocket.accept();
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String inputLine;

				int x = 0;
				while ((inputLine = in.readLine()) != null && !shouldStop) {
					// jTextArea.append(inputLine +
					// System.getProperty("line.separator"));

					for (int z = 0; z < 80000; z += 8) {
						try {
							long address = Long.parseLong(inputLine.substring(z, z + 8).trim(), 16);
							Data.increaseMemoryReadCount(address);
						} catch (Exception ex) {

						}
						// System.out.println(address);
					}
					x++;
				}
				out.close();
				in.close();
				clientSocket.close();
			}
			serverSocket.close();
		} catch (IOException e) {
			jTextArea.append("Could not listen on port: " + port);
		}
	}
}
