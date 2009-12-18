package peter;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Vector;

import javax.swing.JEditorPane;
import javax.swing.SwingUtilities;

public class CommandReceiver implements Runnable {
	Application application;
	private final InputStream is;
	private String commandResult;
	// private int threadID = 0;
	public boolean shouldShow;

	int timeoutSecond = 8;

	boolean readCommandFinish;
	Vector<String> lines = new Vector<String>();

	public void clearBuffer() {
		synchronized (lines) {
			lines.removeAllElements();
		}
	}

	public int getLinesLength() {
		return lines.size();
	}

	public void waitUntilNoInput() {
		while (true) {
			synchronized (lines) {
				if (lines.size() == 0) {
					return;
				}
			}
		}
	}

	public void waitUntilHaveInput() {
		while (true) {
			synchronized (lines) {
				if (lines.size() > 0) {
					return;
				}
			}
		}
	}

	public String getCommandResultUntilEnd() {
		commandResult = "";

		String str = "";

		while (true) {
			synchronized (lines) {
				if (lines.size() > 0) {
					str += lines.get(0) + "\n";
					lines.remove(0);
				} else {
					return str;
				}
			}
		}
	}

	public String getCommandResultUntilHaveLines(int noOfLine) {
		commandResult = "";

		String str = "";

		while (true) {
			synchronized (lines) {
				if (lines.size() > 0) {
					str += lines.get(0) + "\n";
					lines.remove(0);
				} else {
					if (str.split("\n").length >= noOfLine) {
						return str;
					}
				}
			}
		}
	}

	public String getCommandResult(String pattern) {
		long startTime = new Date().getTime();
		commandResult = "";

		String str = "";

		while (true) {
			synchronized (lines) {
				if (lines.size() > 0) {
					// System.out.println(lines.get(0));
					if (lines.get(0).contains(pattern)) {
						str += lines.get(0) + "\n";
						lines.remove(0);
						return str;
					} else {
						lines.remove(0);
					}
				}
			}
			long diff = new Date().getTime() - startTime;
			if (diff / 1000 >= timeoutSecond) {
				return null;
			}
		}
	}

	public String getCommandResult(String startPattern, String endPattern) {
		long startTime = new Date().getTime();
		commandResult = "";

		String str = "";
		boolean startCapture = false;

		while (true) {
			synchronized (lines) {
				if (lines.size() > 0) {
					// System.out.println("line size=" + lines.size() + ">" +
					// lines.get(0));
					if (startCapture) {
						if (lines.get(0).contains((endPattern))) {
							str += lines.get(0) + "\n";
							lines.remove(0);
							// System.out.println("end");
							startCapture = false;
							return str;
						} else {
							str += lines.get(0) + "\n";
							lines.remove(0);
							// System.out.println(str);
						}
					} else {
						if (lines.get(0).contains(startPattern)) {
							// System.out.println("start");
							str += lines.get(0) + "\n";
							lines.remove(0);
							if (startPattern.equals(endPattern)) {
								return str;
							}
							startCapture = true;
						} else {
							lines.remove(0);
						}
					}
				}
				long diff = new Date().getTime() - startTime;
				// System.out.println(diff);
				if (diff / 1000 >= timeoutSecond) {
					return null;
				}
			}
		}
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
				synchronized (lines) {
					lines.add(line);
					// System.out.println(">>" + line);
				}
			}
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}
}