package com.peterbochs.instrument;

import javax.swing.JTextArea;

public class SMServerController {
	static SMServer server = new SMServer();

	public static void start(JTextArea jTextArea) {
		server.startServer(jTextArea);
	}

	public static void stop() {
		server.stopServer();
	}

}
