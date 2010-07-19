package peter.instrument;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import peter.Global;

public class JmpSocketServer implements Runnable {
	private int port;
	private JmpTableModel jmpTableModel;
	private boolean shouldStop;
	private ServerSocket serverSocket;
	private SimpleDateFormat dateformat1 = new SimpleDateFormat("HH:mm:ss.S");
	FileWriter fstream;

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
				// BufferedReader in = new BufferedReader(new
				// InputStreamReader(clientSocket.getInputStream()));
				DataInputStream in = new DataInputStream(clientSocket.getInputStream());

				// int x = 0;
				int lineNo = 1;
				while (!shouldStop) {
					long address = in.readUnsignedByte() + (in.readUnsignedByte() << 8) + (in.readUnsignedByte() << 16) + (in.readUnsignedByte() << 24);

					fstream.write(lineNo + "-" + dateformat1.format(new Date()) + "-" + String.valueOf(address) + "-fuck\n");

					jmpTableModel.addData(String.valueOf(lineNo), dateformat1.format(new Date()), address, address + 1);

					// fstream.flush();

					// if (!isGroup || lastAddress != address) {
					// new Thread(new BottomThread(x, address)).start();

					// jTextArea.append(lineNo + " - " +
					// dateformat1.format(new Date()) + " - 0x" +
					// Long.toHexString(address) +
					// System.getProperty("line.separator"));
					// jTextArea.setCaretPosition(jTextArea.getText().length());
					// lastAddress = address;
					// x++;
					lineNo++;
					// }
				}

				// out.close();
				// in.close();
				// clientSocket.close();
			}
			serverSocket.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
