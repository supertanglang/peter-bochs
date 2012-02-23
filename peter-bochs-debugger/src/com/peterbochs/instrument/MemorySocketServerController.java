package com.peterbochs.instrument;

import javax.swing.JTextArea;

public class MemorySocketServerController {
	static MemorySocketServer server = new MemorySocketServer();

	public static void start(int port, JTextArea jTextArea) {
		server.startServer(port, jTextArea);
	}

	public static void stop() {
		server.stopServer();
	}

}
