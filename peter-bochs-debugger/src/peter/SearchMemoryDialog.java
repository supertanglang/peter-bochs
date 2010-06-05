package peter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class SearchMemoryDialog extends javax.swing.JDialog {
	private JProgressBar jProgressBar1;
	private JPanel jPanel1;
	private JButton jButton1;
	JTable jTable;
	String pattern;
	long from;
	long to;
	private JTextField jTextField1;
	private JLabel jLabel1;
	private JPanel jPanel2;
	private JLabel jAddressLabel;
	byte patternByte[];
	boolean shouldStop;
	Thread t;
	SearchThread s = new SearchThread();

	public SearchMemoryDialog(JFrame frame, JTable jTable, String pattern, long from, long to) {
		super(frame, true);
		this.jTable = jTable;
		this.pattern = pattern.trim().toLowerCase();
		this.from = from;
		this.to = to;

		initGUI();
		setTitle(Application.language.getString("Search") + " " + pattern + " " + Application.language.getString("From") + " 0x" + Long.toHexString(from) + " " + Application.language.getString("To")
				+ " 0x" + Long.toHexString(to));
		t = new Thread(s);
		t.start();
	}

	private void initGUI() {
		try {
			{
				jProgressBar1 = new JProgressBar();
				getContentPane().add(jProgressBar1, BorderLayout.CENTER);
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.SOUTH);
				{
					jAddressLabel = new JLabel();
					jPanel1.add(jAddressLabel);
				}
				{
					jButton1 = new JButton();
					jPanel1.add(jButton1);
					jButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButton1ActionPerformed(evt);
						}
					});
					jButton1.setText(Application.language.getString("Cancel"));
				}
			}
			{
				jPanel2 = new JPanel();
				BorderLayout jPanel2Layout = new BorderLayout();
				jPanel2.setLayout(jPanel2Layout);
				getContentPane().add(jPanel2, BorderLayout.NORTH);
				jPanel2.setPreferredSize(new java.awt.Dimension(290, 35));
				{
					jTextField1 = new JTextField();
					jPanel2.add(jTextField1, BorderLayout.CENTER);
				}
				{
					jLabel1 = new JLabel();
					jPanel2.add(jLabel1, BorderLayout.NORTH);
					jLabel1.setText(Application.language.getString("Searching_these_bytes"));
				}
			}
			setSize(350, 130);
			CommonLib.centerDialog(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class SearchThread implements Runnable {
		public void run() {
			if (pattern.startsWith("0x")) {
				patternByte = CommonLib.intArrayToByteArray(CommonLib.hexStringToByteArray(pattern.substring(2)));
			} else if (CommonLib.isNumeric(pattern)) {
				patternByte = CommonLib.intArrayToByteArray(CommonLib.integerStringToByteArray(pattern));
			} else {
				patternByte = CommonLib.intArrayToByteArray(CommonLib.stringToByteArray(pattern));
			}

			for (int x = 0; x < patternByte.length; x++) {
				jTextField1.setText(jTextField1.getText() + String.format("0x%02x", patternByte[x]) + " ");
			}

			jProgressBar1.setMaximum(100);
			int totalByte = 200;
			for (long addr = from; addr <= to; addr += (totalByte - patternByte.length + 1)) {
				jAddressLabel.setText("0x" + Long.toHexString(addr));
				Application.commandReceiver.clearBuffer();
				Application.sendCommand("xp /" + totalByte + "bx " + addr);
				float totalByte2 = totalByte - 1;
				totalByte2 = totalByte2 / 8;
				int totalByte3 = (int) Math.floor(totalByte2);
				String realEndAddressStr;
				String realStartAddressStr;
				long realStartAddress = addr;
				realStartAddressStr = String.format("%08x", realStartAddress);
				long realEndAddress = realStartAddress + totalByte3 * 8;
				realEndAddressStr = String.format("%08x", realEndAddress);

				String result = Application.commandReceiver.getCommandResult(realStartAddressStr, realEndAddressStr);
				String[] lines = result.split("\n");
				byte bytes[] = new byte[totalByte];
				int offset = 0;

				for (int y = 0; y < lines.length; y++) {
					String[] b = lines[y].replaceFirst("^.*:", "").split("\t");
					for (int x = 1; x < b.length && x < 200; x++) {
						bytes[offset] = CommonLib.hex2decimal(b[x].substring(2).trim()).byteValue();
						offset++;
					}
				}

				// search
				for (int x = 0; x < bytes.length - patternByte.length; x++) {
					byte temp[] = new byte[patternByte.length];
					for (int z = 0; z < temp.length; z++) {
						temp[z] = bytes[x + z];
					}
					if (Arrays.equals(patternByte, temp)) {
						// System.out.println("match " + (addr + x));
						((SearchTableModel) jTable.getModel()).addRow(addr + x, patternByte);
					}
				}
				// end search

				if (shouldStop) {
					return;
				}

				jProgressBar1.setValue((int) ((addr - from) * 100 / (to - from)));
			}
			jProgressBar1.setValue(100);
			jButton1.setText(Application.language.getString("Finished"));
		}
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		shouldStop = true;
		while (t.isAlive()) {
		}
		Application.commandReceiver.clearBuffer();
		setVisible(false);
	}
}
