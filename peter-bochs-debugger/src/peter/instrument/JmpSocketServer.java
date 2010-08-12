package peter.instrument;

import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;

import javax.swing.JOptionPane;

import peter.Global;

public class JmpSocketServer implements Runnable {
	private int port;
	private JmpTableModel jmpTableModel;
	private boolean shouldStop;
	private ServerSocket serverSocket;
	private SimpleDateFormat dateformat1 = new SimpleDateFormat("HH:mm:ss.S");
	FileWriter fstream;

	public static LinkedHashSet<String> segments = new LinkedHashSet<String>();

	public void startServer(int port, JmpTableModel jmpTableModel) {
		this.port = port;
		this.jmpTableModel = jmpTableModel;
		try {
			fstream = new FileWriter(Global.jmpLog, true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		shouldStop = false;
		new Thread(this).start();

		// while (serverSocket == null) {
		// try {
		// Thread.currentThread().sleep(500);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }

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
		} catch (IOException e) {
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
				DataInputStream in = new DataInputStream(clientSocket.getInputStream());

				int lineNo = 1;

				while (!shouldStop) {
					int head = in.readUnsignedByte();
					if (head == 1) {
						long fromAddress = in.readUnsignedByte() + (in.readUnsignedByte() << 8) + (in.readUnsignedByte() << 16) + (in.readUnsignedByte() << 24);
						long toAddress = in.readUnsignedByte() + (in.readUnsignedByte() << 8) + (in.readUnsignedByte() << 16) + (in.readUnsignedByte() << 24);
						fromAddress &= 0xffffffffL;
						toAddress &= 0xffffffffL;
						fstream.write(lineNo + "-" + dateformat1.format(new Date()) + "-" + fromAddress + "-" + toAddress + "\n");
						jmpTableModel.addData(String.valueOf(lineNo), dateformat1.format(new Date()), fromAddress, toAddress);
						lineNo++;
					} else if (head == 2) {
						long segmentBegin = in.readUnsignedByte() + (in.readUnsignedByte() << 8) + (in.readUnsignedByte() << 16) + (in.readUnsignedByte() << 24);
						long segmentEnd = in.readUnsignedByte() + (in.readUnsignedByte() << 8) + (in.readUnsignedByte() << 16) + (in.readUnsignedByte() << 24);
						segmentBegin &= 0xffffffffL;
						segmentEnd &= 0xffffffffL;
						segments.add(segmentBegin + "-" + segmentEnd);
					}
				}

				in.close();
				clientSocket.close();
			}
			serverSocket.close();
		} catch (BindException ex) {
			JOptionPane.showMessageDialog(null, "You have turn on the profiling feature but the port " + port + " is not available. Program exit", "Error",
					JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		} catch (IOException ex2) {

		}
	}
}
