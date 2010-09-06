package peter.instrument;


public class JmpSocketServerController {
	static JmpSocketServer server = new JmpSocketServer();

	public static void start(int port, JmpTableModel jmpTableModel) {
		server.startServer(port, jmpTableModel);
	}

	public static void stop() {
		server.stopServer();
	}

}
