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
//		jTextArea.setText("");

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

				while (!shouldStop) {
					// hit count
					inputLine = in.readLine();
					for (int z = 0; z < 80000; z += 8) {
						try {
							long address = Long.parseLong(inputLine.substring(z, z + 8).trim(), 16);
							Data.increaseMemoryReadCount(address);
						} catch (Exception ex) {

						}
					}
					// end hit count

					// zones
					inputLine = in.readLine();
					try {
						int noOfZone = Integer.parseInt(inputLine.substring(0, 8).trim());
						inputLine = inputLine.substring(8);
						if (noOfZone > 0) {
							
							for (int offset = 0; offset < inputLine.length();) {
								long zoneFrom = CommonLib.convertFilesize("0x" + inputLine.substring(offset, offset + 8).trim());
								offset += 8;
								long zoneTo = CommonLib.convertFilesize("0x" + inputLine.substring(offset, offset + 8).trim());
								offset += 8;
								long zoneHitCount = CommonLib.convertFilesize("0x" + inputLine.substring(offset, offset + 8).trim());
								offset += 8;
								long noOfZoneHitAddress = CommonLib.convertFilesize("0x" + inputLine.substring(offset, offset + 8).trim());
								offset += 8;

								for (int y = 0; y < Data.memoryProfilingZone.getRowCount(); y++) {
									long from = CommonLib.convertFilesize(Data.memoryProfilingZone.getValueAt(y, 0).toString());
									long to = CommonLib.convertFilesize(Data.memoryProfilingZone.getValueAt(y, 1).toString());

									if (zoneFrom == from && zoneTo == to) {
										Data.memoryProfilingZone.setValueAt(zoneHitCount, y, 2);
										for (int index = 0; index < noOfZoneHitAddress; index++) {
											long zoneHitAddress = CommonLib.convertFilesize("0x" + inputLine.substring(offset, offset + 8).trim());
											offset += 8;
											Data.memoryProfilingZone.addHitAddress(y, zoneHitAddress);
										}
									}
								}
							}
						}
					} catch (Exception ex) {

					}
					// end zones

					if (Data.memoryProfilingZone.needToTellBochsToUpdateZone) {
						String header = String.format("Z%04d", Data.memoryProfilingZone.getRowCount());
						out.print(header);

						for (int y = 0; y < Data.memoryProfilingZone.getRowCount(); y++) {
							String from = String.format("%08x", CommonLib.convertFilesize(Data.memoryProfilingZone.getValueAt(y, 0).toString()));
							String to = String.format("%08x", CommonLib.convertFilesize(Data.memoryProfilingZone.getValueAt(y, 1).toString()));
							out.print(from);
							out.print(to);
						}

						Data.memoryProfilingZone.needToTellBochsToUpdateZone = false;
					} else {
						out.print("-");
					}
					out.flush();
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
