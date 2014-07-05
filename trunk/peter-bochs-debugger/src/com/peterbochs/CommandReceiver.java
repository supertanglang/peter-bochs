package com.peterbochs;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JEditorPane;
import javax.swing.SwingUtilities;

public class CommandReceiver implements Runnable {
	PeterBochsDebugger peterBochsDebugger;
	private final InputStream is;
	// private int threadID = 0;
	public boolean shouldShow;

	int timeoutSecond = 5;

	boolean readCommandFinish;
	Vector<String> lines = new Vector<String>();

	public CommandReceiver(InputStream is, PeterBochsDebugger peterBochsDebugger) {
		this.is = is;
		this.peterBochsDebugger = peterBochsDebugger;
	}

	public void clearBuffer() {
		synchronized (lines) {
			lines.clear();
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
		long startTime = new Date().getTime();

		String str = "";

		int normalTimeout = 500;

		while (true) {
			synchronized (lines) {
				if (lines.size() > 0) {
					str += lines.get(0) + "\n";
					lines.remove(0);
					startTime = new Date().getTime();
				} else {
					long diff = new Date().getTime() - startTime;
					if (diff >= normalTimeout) {
						return str;
					}
				}
				long diff = new Date().getTime() - startTime;
				if (diff / 1000 >= timeoutSecond) {
					return str;
				}
			}
		}
	}

	public String getCommandResultUntilHaveLines(int noOfLine) {
		long startTime = new Date().getTime();

		String str = "";

		while (true) {
			synchronized (lines) {
				if (lines.size() > 0) {
					str += lines.get(0) + "\n";
					lines.remove(0);
					startTime = new Date().getTime();
				} else {
					if (str.split("\n").length >= noOfLine) {
						return str;
					}
				}
				long diff = new Date().getTime() - startTime;
				if (diff / 1000 >= timeoutSecond) {
					return null;
				}
			}
		}
	}

	public String getCommandResult(String pattern) {
		long startTime = new Date().getTime();

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
					startTime = new Date().getTime();
				}
			}
			long diff = new Date().getTime() - startTime;
			if (diff / 1000 >= timeoutSecond) {
				return null;
			}
		}
	}

	public String getCommandResult(String startPattern, String endPattern, String exitPattern) {
		long startTime = new Date().getTime();

		String str = "";
		boolean startCapture = false;

		while (true) {
			synchronized (lines) {
				if (lines.size() > 0) {
					if (exitPattern != null && lines.get(0).contains(exitPattern)) {
						return str;
					}
					if (startCapture) {
						if (lines.get(0).contains(endPattern)) {
							str += lines.get(0) + "\n";
							lines.remove(0);
							startCapture = false;
							return str;
						} else {
							str += lines.get(0) + "\n";
							lines.remove(0);
						}
					} else {
						if (lines.get(0).contains(startPattern)) {
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
					startTime = new Date().getTime();
				}
				long diff = new Date().getTime() - startTime;
				if (diff / 1000 >= timeoutSecond) {
					return null;
				}
			}
		}
	}

	public void run() {
		try {
			final BufferedReader br = new BufferedReader(new InputStreamReader(is), 1024);
			String line;
			final JEditorPane bochsEditorPane = peterBochsDebugger.getBochsEditorPane();
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
					Matcher matcher = Pattern.compile("^.*<bochs[^>]*.*" + Global.lastCommand).matcher(line);
					if (matcher.matches()) {
						continue;
					}
					line = line.replaceAll("^<bochs[^>]* ", "");
					if (!line.equals("")) {
						lines.add(line);
					}
				}
			}
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}

	public void waitUntilHaveLine(int i) {
		long startTime = new Date().getTime();

		while (lines.size() < i) {
			//			try {
			//				Thread.currentThread().sleep(20);
			//			} catch (InterruptedException e) {
			//			}
			long diff = new Date().getTime() - startTime;
			if (diff / 1000 >= timeoutSecond) {
				return;
			}
		}
	}
}