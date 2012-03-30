package com.peterbochs.instrument;

import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.peterbochs.instrument.callgraph.JmpData;

import com.peterbochs.Global;
import com.peterswing.CommonLib;

public class JmpSocketServer implements Runnable {
	private int port;
	private JmpTableModel jmpTableModel;
	private boolean shouldStop;
	private ServerSocket serverSocket;
	private SimpleDateFormat dateformat1 = new SimpleDateFormat("HH:mm:ss.S");
	FileWriter fstream;

	//	public static LinkedHashSet<String> segments = new LinkedHashSet<String>();
	public static Vector<JmpData> jmpDataVector = new Vector<JmpData>();

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
			System.out.println("Jmp server start at port " + port);
		}

		try {
			serverSocket = new ServerSocket(port);
			while (!shouldStop) {
				Socket clientSocket = serverSocket.accept();
				DataInputStream in = new DataInputStream(clientSocket.getInputStream());

				int lineNo = 1;

				while (!shouldStop) {
					long fromAddress = CommonLib.readLongFromInputStream(in);
					long toAddress = CommonLib.readLongFromInputStream(in);
					long segmentStart = CommonLib.readLongFromInputStream(in);
					long segmentEnd = CommonLib.readLongFromInputStream(in);

					long eax = CommonLib.readLongFromInputStream(in);
					long ecx = CommonLib.readLongFromInputStream(in);
					long edx = CommonLib.readLongFromInputStream(in);
					long ebx = CommonLib.readLongFromInputStream(in);
					long esp = CommonLib.readLongFromInputStream(in);
					long ebp = CommonLib.readLongFromInputStream(in);
					long esi = CommonLib.readLongFromInputStream(in);
					long edi = CommonLib.readLongFromInputStream(in);

					long es = CommonLib.readShortFromInputStream(in);
					long cs = CommonLib.readShortFromInputStream(in);
					long ss = CommonLib.readShortFromInputStream(in);
					long ds = CommonLib.readShortFromInputStream(in);
					long fs = CommonLib.readShortFromInputStream(in);
					long gs = CommonLib.readShortFromInputStream(in);

					jmpTableModel.addData(String.valueOf(lineNo), dateformat1.format(new Date()), fromAddress, toAddress, segmentStart, segmentEnd, eax, ecx, edx, ebx, esp, ebp,
							esi, edi, es, cs, ss, ds, fs, gs);
					lineNo++;
					jmpDataVector.add(new JmpData(segmentStart, segmentEnd, fromAddress, toAddress));

					fstream.write(lineNo + "-" + dateformat1.format(new Date()) + "-" + fromAddress + "-" + toAddress + "-" + segmentStart + "-" + segmentEnd + "\n");
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
