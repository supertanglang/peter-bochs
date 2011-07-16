package peter.instrument;

import javax.swing.JTextArea;

import peter.Global;

public class SMServer implements Runnable {
	JTextArea jTextArea;
	boolean shouldStop;
	MySHStub mySHStub = new MySHStub();

	public void startServer(JTextArea jTextArea) {
		this.jTextArea = jTextArea;
		jTextArea.setText("");

		shouldStop = false;

		System.loadLibrary("peter");
		new Thread(this).start();
	}

	public void stopServer() {
		shouldStop = true;
	}

	@Override
	public void run() {
		if (Global.debug) {
			System.out.println("SH server started");
		}

		while (!shouldStop) {
			mySHStub.getSharedMemory();
		}

	}

}
