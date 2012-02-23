package com.peterbochs.instrument;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.TreeSet;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;


import com.peterbochs.Global;
import com.petersoft.CommonLib;

public class MemorySocketServer implements Runnable {
	int port;
	JTextArea jTextArea;
	boolean shouldStop;
	ServerSocket serverSocket;
	final int MAX_MEMORY_PROFILING_BUFFER = 500 * 4;

	public void startServer(int port, JTextArea jTextArea) {
		this.port = port;
		this.jTextArea = jTextArea;
		// jTextArea.setText("");

		shouldStop = false;
		new Thread(this).start();

		while (serverSocket != null && !serverSocket.isBound()) {
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stopServer() {
		shouldStop = true;
		try {
			serverSocket.close();
		} catch (Exception e) {
		}
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
				// clientSocket.setTcpNoDelay(true);
				DataInputStream in = new DataInputStream(clientSocket.getInputStream());
				DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

				while (!shouldStop) {
					// hit count
					byte bytes[] = new byte[MAX_MEMORY_PROFILING_BUFFER];
					in.readFully(bytes, 0, bytes.length);

					for (int z = 0; z <= MAX_MEMORY_PROFILING_BUFFER - 4; z += 4) {
						try {
							long address = CommonLib.getInt(bytes, z);
							Data.increaseMemoryReadCount(address);
						} catch (Exception ex) {
							if (Global.debug) {
								ex.printStackTrace();
							}
						}
					}
					// end hit count

					// zones
					try {
						// hit count
						int noOfZone = in.readUnsignedByte() + (in.readUnsignedByte() << 8) + (in.readUnsignedByte() << 16) + (in.readUnsignedByte() << 24);
						for (int offset = 0; offset < noOfZone; offset++) {
							long zoneFrom = in.readUnsignedByte() + (in.readUnsignedByte() << 8) + (in.readUnsignedByte() << 16) + (in.readUnsignedByte() << 24);
							long zoneTo = in.readUnsignedByte() + (in.readUnsignedByte() << 8) + (in.readUnsignedByte() << 16) + (in.readUnsignedByte() << 24);
							long zoneHitCount = in.readUnsignedByte() + (in.readUnsignedByte() << 8) + (in.readUnsignedByte() << 16) + (in.readUnsignedByte() << 24);
							long noOfZoneHitAddress = in.readUnsignedByte() + (in.readUnsignedByte() << 8) + (in.readUnsignedByte() << 16) + (in.readUnsignedByte() << 24);
							if (Global.bits.equals("32bits")) {
								zoneFrom &= 0xffffffffL;
								zoneTo &= 0xffffffffL;
								zoneHitCount &= 0xffffffffL;
								noOfZoneHitAddress &= 0xffffffffL;
							}

							TreeSet<Long> treeset = new TreeSet<Long>();
							for (int index = 0; index < noOfZoneHitAddress; index++) {
								long zoneHitAddress = in.readUnsignedByte() + (in.readUnsignedByte() << 8) + (in.readUnsignedByte() << 16) + (in.readUnsignedByte() << 24);
								treeset.add(zoneHitAddress);
							}

							// System.out.println(Long.toHexString(zoneFrom) +
							// "-" + Long.toHexString(zoneTo));
							for (int y = 0; y < Data.memoryProfilingZone.getRowCount(); y++) {
								long from = CommonLib.convertFilesize(Data.memoryProfilingZone.getValueAt(y, 0).toString());
								long to = CommonLib.convertFilesize(Data.memoryProfilingZone.getValueAt(y, 1).toString());
								if (zoneFrom == from && zoneTo == to) {
									Data.memoryProfilingZone.setValueAt(zoneHitCount, y, 2);
									Data.memoryProfilingZone.setValueAt(treeset, y, 4);
									break;
								}
							}
						}
					} catch (Exception ex) {
						if (Global.debug) {
							ex.printStackTrace();
						}
					}
					// end zones

					if (Data.memoryProfilingZone.needToTellBochsToUpdateZone) {
						out.writeByte(2);
						out.writeInt(Data.memoryProfilingZone.getRowCount());

						for (int y = 0; y < Data.memoryProfilingZone.getRowCount(); y++) {
							// System.out.println((int)
							// CommonLib.convertFilesize(Data.memoryProfilingZone.getValueAt(y,
							// 0).toString()) + "---"
							// + (int)
							// CommonLib.convertFilesize(Data.memoryProfilingZone.getValueAt(y,
							// 1).toString()));
							out.writeInt((int) CommonLib.convertFilesize(Data.memoryProfilingZone.getValueAt(y, 0).toString()));
							out.writeInt((int) CommonLib.convertFilesize(Data.memoryProfilingZone.getValueAt(y, 1).toString()));
						}

						Data.memoryProfilingZone.needToTellBochsToUpdateZone = false;
					} else {
						out.writeByte(1);
					}
					out.flush();

				}
				out.close();
				in.close();
				clientSocket.close();
			}
			serverSocket.close();
		} catch (BindException ex) {
			JOptionPane.showMessageDialog(null, "You have turn on the profiling feature but the port " + port + " is not available. Program exit", "Error",
					JOptionPane.ERROR_MESSAGE);
			if (Global.debug) {
				ex.printStackTrace();
			}
			System.exit(-1);
		} catch (IOException ex2) {

		}
	}
}
