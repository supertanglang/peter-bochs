package peter.instrument;

import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import peter.CommonLib;
import peter.Global;

public class InterruptSocketServer implements Runnable {
	private int port;
	private boolean shouldStop;
	private ServerSocket serverSocket;
	private SimpleDateFormat dateformat1 = new SimpleDateFormat("HH:mm:ss.S");
	FileWriter fstream;

	public static Hashtable<Long, Integer> interruptRecords = new Hashtable<Long, Integer>();

	public void startServer(int port) {
		this.port = port;
		try {
			fstream = new FileWriter(Global.interruptLog, true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

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
			System.out.println("Interrupt server start at port " + port);
		}

		try {
			serverSocket = new ServerSocket(port);
			while (!shouldStop) {
				Socket clientSocket = serverSocket.accept();
				DataInputStream in = new DataInputStream(clientSocket.getInputStream());

				int lineNo = 1;

				while (!shouldStop) {
					long intNo = CommonLib.readLongFromInputStream(in);
					//					System.out.println("int==" + intNo);

					lineNo++;
					if (interruptRecords.get(intNo) != null) {
						//						System.out.println(interruptRecords.get(intNo));
						interruptRecords.put(intNo, interruptRecords.get(intNo) + 1);
					} else {
						interruptRecords.put(intNo, 1);
					}
					//					fstream.write(lineNo + "-" + dateformat1.format(new Date()) + "-" + intNo + "\n");
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
