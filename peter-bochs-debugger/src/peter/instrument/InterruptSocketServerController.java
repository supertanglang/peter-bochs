package peter.instrument;


public class InterruptSocketServerController {
	static InterruptSocketServer server = new InterruptSocketServer();

	public static void start(int port) {
		server.startServer(port);
	}

	public static void stop() {
		server.stopServer();
	}

}
