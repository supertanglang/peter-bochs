package peter;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JEditorPane;
import javax.swing.JScrollBar;
import javax.swing.SwingUtilities;

public class CommandReceiver implements Runnable {
	Application application;
	private final InputStream is;
	private String commandResult;
	private int commandNoOfLine;
	private int threadID = 0;
	public boolean shouldShow;

	public int getCommandNoOfLine() {
		return commandNoOfLine;
	}

	public void setCommandNoOfLine(int commandNoOfLine) {
		this.commandNoOfLine = commandNoOfLine;
	}

	public String getCommandResult(final int timeoutMilliSecond) {
		// prevent wait forever
		if (timeoutMilliSecond != -1) {
			// if (timeoutThread!=null){
			// timeoutThread.interrupt();
			// }
			threadID++;
			new Thread() {
				public void run() {
					int currentThreadID = threadID;
					try {
						Thread.currentThread().sleep(timeoutMilliSecond);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (threadID == currentThreadID) {
						commandNoOfLine = 0;
						shouldShow = false;
					}
				}
			}.start();

			while (commandNoOfLine > 0) {
				try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		// end prevent wait forever
		shouldShow = false;
		return commandResult;
	}

	public String getCommandResult() {
		return getCommandResult(2000);
	}

	public void setCommandResult(String commandResult) {
		this.commandResult = commandResult;
	}

	public CommandReceiver(InputStream is, Application application) {
		this.is = is;
		this.application = application;
	}

	public void run() {
		try {
			final BufferedReader br = new BufferedReader(new InputStreamReader(is), 1024);
			String line;
			final JEditorPane bochsEditorPane = application.getjBochsEditorPane();
			while ((line = br.readLine()) != null) {

				if (shouldShow) {
					bochsEditorPane.setText(bochsEditorPane.getText() + "\n" + line);
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							bochsEditorPane.scrollRectToVisible(new Rectangle(0, bochsEditorPane.getHeight() - 1, 1, bochsEditorPane.getHeight() - 1));
						}
					});
				}

				commandResult += line + "\n";
				commandNoOfLine--;
				// System.out.println(line);
			}
		} catch (IOException e) {
			throw new IllegalArgumentException("IOException receiving data from child process.");
		}
	}
}