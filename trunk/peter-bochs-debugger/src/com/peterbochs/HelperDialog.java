package com.peterbochs;

import info.clearthought.layout.TableLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.petersoft.CommonLib;

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
public class HelperDialog extends javax.swing.JDialog {
	long address;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JLabel jBytesLabel;
	String type;

	public HelperDialog(JFrame frame, long address, String type) {
		super(frame);
		this.address = address;
		this.type = type;
		initGUI();
		initData();
	}

	private void initData() {
		long bytes = PeterBochsCommonLib.getLongFromBochs(address);
		jBytesLabel.setText("0x" + Long.toHexString(address) + " : 0x" + Long.toHexString(bytes));

		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		if (type.equals("GDT")) {
			int totalGDT = 40;
			int b[] = PeterBochsCommonLib.getMemoryFromBochs(address, totalGDT * 8);
			for (int x = 0; x < totalGDT * 8; x += 8) {
				long value = CommonLib.getLong(b, x);
				long bit[] = new long[64];

				for (int x2 = 0; x2 < 64; x2++) {
					bit[x2] = CommonLib.getBit(value, x2);
				}

				// parse descriptor
				if (bit[44] == 1 && bit[43] == 1) {
					model.addRow(new String[] { String.valueOf(x / 8), "Code descriptor, value=0x" + Long.toHexString(value) });
					// parseCodeDescriptor();
				} else if (bit[44] == 1 && bit[43] == 0) {
					model.addRow(new String[] { String.valueOf(x / 8), "Data descriptor, value=0x" + Long.toHexString(value) });
					// parseDataDescriptor();
				} else if (bit[44] == 0 && bit[43] == 0 && bit[42] == 0 && bit[41] == 1 && bit[40] == 0) {
					model.addRow(new String[] {
							String.valueOf(x / 8),
							"LDT descriptor, value=0x" + Long.toHexString(value) + ", base=0x" + Long.toHexString(CommonLib.getInt(b[2], b[3], b[4], b[7])) + ", limit=0x"
									+ Long.toHexString(CommonLib.getShort(b[0], b[1])) });
					// parseLDT();
				} else if (bit[44] == 0 && bit[42] == 0 && bit[40] == 1) {
					model.addRow(new String[] { String.valueOf(x / 8), "TSS descriptor, value=0x" + Long.toHexString(value) });
					// parseTSSDescriptor();
				} else {
					model.addRow(new String[] { String.valueOf(x / 8), "wrong descriptor, value=0x" + Long.toHexString(value) });
				}
				// end parse descriptor
			}
		} else if (type.equals("GDT Descriptor")) {
			int b[] = PeterBochsCommonLib.getMemoryFromBochs(address, 8);
			long value = CommonLib.getLong(b, 0);
			long bit[] = new long[64];

			for (int x2 = 0; x2 < 64; x2++) {
				bit[x2] = CommonLib.getBit(value, x2);
			}

			// parse descriptor
			if (bit[44] == 1 && bit[43] == 1) {
				model.addRow(new String[] { "type", "code descriptor, value=0x" + Long.toHexString(value) });
				long base = CommonLib.getLong(b[2], b[3], b[4], b[7], 0, 0, 0, 0);
				model.addRow(new String[] { "base", "0x" + Long.toHexString(base) });

				long limit = CommonLib.getLong(b[0], b[1], b[6] & 0xf, 0, 0, 0, 0, 0);
				if (bit[55] == 1) {
					limit *= 4096;
				}
				model.addRow(new String[] { "limit", "0x" + Long.toHexString(limit) });

				model.addRow(new String[] { "G", String.valueOf(bit[55]) });
				model.addRow(new String[] { "D", String.valueOf(bit[54]) });
				model.addRow(new String[] { "AVL", String.valueOf(bit[52]) });
				model.addRow(new String[] { "P", String.valueOf(bit[47]) });
				model.addRow(new String[] { "DPL", String.valueOf(bit[45] + bit[46] << 1) });
				model.addRow(new String[] { "S", String.valueOf(bit[44]) });
				model.addRow(new String[] { "X", String.valueOf(bit[43]) });
				model.addRow(new String[] { "C", String.valueOf(bit[42]) });
				model.addRow(new String[] { "R", String.valueOf(bit[41]) });
				model.addRow(new String[] { "A", String.valueOf(bit[40]) });
			} else if (bit[44] == 1 && bit[43] == 0) {
				model.addRow(new String[] { "type", "data descriptor, value=0x" + Long.toHexString(value) });
				long base = CommonLib.getLong(b[2], b[3], b[4], b[7], 0, 0, 0, 0);
				model.addRow(new String[] { "base", "0x" + Long.toHexString(base) });

				long limit = CommonLib.getLong(b[0], b[1], b[6] & 0xf, 0, 0, 0, 0, 0);
				if (bit[55] == 1) {
					limit *= 4096;
				}
				model.addRow(new String[] { "limit", "0x" + Long.toHexString(limit) });

				model.addRow(new String[] { "G", String.valueOf(bit[55]) });
				model.addRow(new String[] { "B", String.valueOf(bit[54]) });
				model.addRow(new String[] { "AVL", String.valueOf(bit[52]) });
				model.addRow(new String[] { "P", String.valueOf(bit[47]) });
				model.addRow(new String[] { "DPL", String.valueOf(bit[45] + bit[46] << 1) });
				model.addRow(new String[] { "S", String.valueOf(bit[44]) });
				model.addRow(new String[] { "X", String.valueOf(bit[43]) });
				model.addRow(new String[] { "E", String.valueOf(bit[42]) });
				model.addRow(new String[] { "W", String.valueOf(bit[41]) });
				model.addRow(new String[] { "A", String.valueOf(bit[40]) });
			} else if (bit[44] == 0 && bit[43] == 0 && bit[42] == 0 && bit[41] == 1 && bit[40] == 0) {
				model.addRow(new String[] { "type", "LDT, value=0x" + Long.toHexString(value) });
			} else if (bit[44] == 0 && bit[42] == 0 && bit[40] == 1) {
				model.addRow(new String[] { "type", "tss descriptor, value=0x" + Long.toHexString(value) });
				long base = CommonLib.getLong(b[2], b[3], b[4], b[7], 0, 0, 0, 0);
				model.addRow(new String[] { "base", "0x" + Long.toHexString(base) });

				long limit = CommonLib.getLong(b[0], b[1], b[6] & 0xf, 0, 0, 0, 0, 0);
				if (bit[55] == 1) {
					limit *= 4096;
				}
				model.addRow(new String[] { "limit", "0x" + Long.toHexString(limit) });

				model.addRow(new String[] { "G", String.valueOf(bit[55]) });
				model.addRow(new String[] { "AVL", String.valueOf(bit[52]) });
				model.addRow(new String[] { "P", String.valueOf(bit[47]) });
				model.addRow(new String[] { "DPL", String.valueOf(bit[45] + bit[46] << 1) });
				model.addRow(new String[] { "S", String.valueOf(bit[44]) });
				model.addRow(new String[] { "D", String.valueOf(bit[43]) });
				model.addRow(new String[] { "G", String.valueOf(bit[42]) });
				model.addRow(new String[] { "B", String.valueOf(bit[41]) });
				model.addRow(new String[] { "V", String.valueOf(bit[40]) });

				// TSS
				// Application.commandReceiver.setCommandNoOfLine(2);
				Application.sendCommand("x /" + limit + "bx " + base);

				float totalByte2 = limit - 1;
				totalByte2 = totalByte2 / 8;
				int totalByte3 = (int) Math.floor(totalByte2);
				String realEndAddressStr;
				String realStartAddressStr;
				Integer realStartAddress;
				if (String.valueOf(base).startsWith("0x")) {
					realStartAddress = Integer.parseInt(String.valueOf(base).substring(2), 16);
				} else {
					realStartAddress = Integer.parseInt(String.valueOf(base));
				}
				realStartAddressStr = String.format("%08x", realStartAddress);
				int realEndAddress = realStartAddress + totalByte3 * 8;
				realEndAddressStr = String.format("%08x", realEndAddress);

				String result2 = Application.commandReceiver.getCommandResult(realStartAddressStr, realEndAddressStr);
				String[] lines2 = result2.split("\n");

				byte tssByte[] = new byte[(int) limit];
				for (int y = 1; y < lines2.length; y++) {
					String byteStr[] = lines2[y].replaceFirst("^.*>:\t", "").split("\t");
					for (int x = 0; x < 8; x++) {
						tssByte[x + ((y - 1) * 8)] = (byte) Long.parseLong(byteStr[x].substring(2), 16);
					}
				}

				long tssValue = CommonLib.getLong(b, 0);

				model.addRow(new String[] { "link", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0], tssByte[1], 0, 0, 0, 0, 0, 0)) });
				model.addRow(new String[] { "esp0", "0x" + Long.toHexString(CommonLib.getLong(tssByte[4], tssByte[5], tssByte[6], tssByte[7], 0, 0, 0, 0)) });
				model.addRow(new String[] { "ss0", "0x" + Long.toHexString(CommonLib.getLong(tssByte[8], tssByte[9], 0, 0, 0, 0, 0, 0)) });
				model.addRow(new String[] { "esp1", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0xc], tssByte[0xd], tssByte[0xe], tssByte[0xf], 0, 0, 0, 0)) });
				model.addRow(new String[] { "ss1", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x10], tssByte[0x11], 0, 0, 0, 0, 0, 0)) });
				model.addRow(new String[] { "esp2", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x14], tssByte[0x15], tssByte[0x16], tssByte[0x17], 0, 0, 0, 0)) });
				model.addRow(new String[] { "ss2", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x18], tssByte[0x19], 0, 0, 0, 0, 0, 0)) });
				model.addRow(new String[] { "cr3", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x1c], tssByte[0x1d], tssByte[0x1e], tssByte[0x1f], 0, 0, 0, 0)) });
				model.addRow(new String[] { "eip", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x20], tssByte[0x21], tssByte[0x22], tssByte[0x23], 0, 0, 0, 0)) });
				model.addRow(new String[] { "eflags", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x24], tssByte[0x25], tssByte[0x26], tssByte[0x27], 0, 0, 0, 0)) });
				model.addRow(new String[] { "eax", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x28], tssByte[0x29], tssByte[0x2a], tssByte[0x2b], 0, 0, 0, 0)) });
				model.addRow(new String[] { "ecx", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x2c], tssByte[0x2d], tssByte[0x2e], tssByte[0x2f], 0, 0, 0, 0)) });
				model.addRow(new String[] { "edx", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x30], tssByte[0x31], tssByte[0x32], tssByte[0x33], 0, 0, 0, 0)) });
				model.addRow(new String[] { "ebx", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x34], tssByte[0x35], tssByte[0x36], tssByte[0x37], 0, 0, 0, 0)) });
				model.addRow(new String[] { "esp", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x38], tssByte[0x39], tssByte[0x3a], tssByte[0x3b], 0, 0, 0, 0)) });
				model.addRow(new String[] { "ebp", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x3c], tssByte[0x3d], tssByte[0x3e], tssByte[0x3f], 0, 0, 0, 0)) });
				model.addRow(new String[] { "esi", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x40], tssByte[0x41], tssByte[0x42], tssByte[0x43], 0, 0, 0, 0)) });
				model.addRow(new String[] { "edi", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x44], tssByte[0x45], tssByte[0x45], tssByte[0x47], 0, 0, 0, 0)) });

				model.addRow(new String[] { "es", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x48], tssByte[0x49], 0, 0, 0, 0, 0, 0)) });
				model.addRow(new String[] { "cs", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x4c], tssByte[0x4d], 0, 0, 0, 0, 0, 0)) });
				model.addRow(new String[] { "ss", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x50], tssByte[0x51], 0, 0, 0, 0, 0, 0)) });
				model.addRow(new String[] { "ds", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x54], tssByte[0x55], 0, 0, 0, 0, 0, 0)) });
				model.addRow(new String[] { "fs", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x58], tssByte[0x59], 0, 0, 0, 0, 0, 0)) });
				model.addRow(new String[] { "gs", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x5c], tssByte[0x5d], 0, 0, 0, 0, 0, 0)) });
				model.addRow(new String[] { "ldtr", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x60], tssByte[0x61], 0, 0, 0, 0, 0, 0)) });

				model.addRow(new String[] { "iobp", "0x" + Long.toHexString(CommonLib.getLong(tssByte[0x66], tssByte[0x67], 0, 0, 0, 0, 0, 0)) });
			} else {
				model.addRow(new String[] { "error", "wrong gdt descriptor, value=0x" + Long.toHexString(value) });
			}
		} else if (type.equals("IDT")) {
			int totalGDT = 40;
			int b[] = PeterBochsCommonLib.getMemoryFromBochs(address, totalGDT * 8);
			for (int x = 0; x < totalGDT * 8; x += 8) {
				long value = CommonLib.getLong(b, x);
				long bit[] = new long[64];

				for (int x2 = 0; x2 < 64; x2++) {
					bit[x2] = CommonLib.getBit(value, x2);
				}

				// parse descriptor
				if (bit[44] == 0 && bit[42] == 1 && bit[41] == 1 && bit[40] == 0) {
					// interrupt date
					model.addRow(new String[] { String.valueOf(x / 8), "interrupt gate, value=0x" + Long.toHexString(value) });
				} else if (bit[44] == 0 && bit[42] == 1 && bit[41] == 0 && bit[40] == 1) {
					// task gate
					model.addRow(new String[] { String.valueOf(x / 8), "task gate, value=0x" + Long.toHexString(value) });
				} else if (bit[44] == 0 && bit[42] == 1 && bit[41] == 1 && bit[40] == 1) {
					// trap gate
					model.addRow(new String[] { String.valueOf(x / 8), "trap gate, value=0x" + Long.toHexString(value) });
				} else {
					model.addRow(new String[] { String.valueOf(x / 8), "wrong descriptor, value=0x" + Long.toHexString(value) });
				}
				// end parse descriptor
			}
		} else if (type.equals("IDT Descriptor")) {
			int b[] = PeterBochsCommonLib.getMemoryFromBochs(address, 8);
			long value = CommonLib.getLong(b, 0);
			long bit[] = new long[64];

			for (int x2 = 0; x2 < 64; x2++) {
				bit[x2] = CommonLib.getBit(value, x2);
			}

			if (bit[44] == 0 && bit[42] == 1 && bit[41] == 1 && bit[40] == 0) {
				// interrupt date
				model.addRow(new String[] { "type", "interrupt gate, value=0x" + Long.toHexString(value) });
				model.addRow(new String[] { "cs", "0x" + Long.toHexString(CommonLib.getLong(b[2], b[3], 0, 0, 0, 0, 0, 0)) });
				model.addRow(new String[] { "offset", "0x" + Long.toHexString(CommonLib.getLong(b[0], b[1], b[6], b[7], 0, 0, 0, 0)) });
				model.addRow(new String[] { "g", String.valueOf(bit[42]) });
				model.addRow(new String[] { "d", String.valueOf(bit[43]) });
				model.addRow(new String[] { "s", String.valueOf(bit[44]) });
				model.addRow(new String[] { "dpl", String.valueOf(bit[45] + bit[46] << 1) });
				model.addRow(new String[] { "p", String.valueOf(bit[47]) });
			} else if (bit[44] == 0 && bit[42] == 1 && bit[41] == 0 && bit[40] == 1) {
				// task gate
				model.addRow(new String[] { "type", "task gate, value=0x" + Long.toHexString(value) });
			} else if (bit[44] == 0 && bit[42] == 1 && bit[41] == 1 && bit[40] == 1) {
				// trap gate
				model.addRow(new String[] { "type", "trap gate, value=0x" + Long.toHexString(value) });
			} else {
				model.addRow(new String[] { "type", "wrong descriptor, value=0x" + Long.toHexString(value) });
			}
		} else if (type.equals("PDE")) {
			int b[] = PeterBochsCommonLib.getMemoryFromBochs(address, 8);
			long value = CommonLib.getLong(b, 0);
			long bit[] = new long[64];

			for (int x2 = 0; x2 < 64; x2++) {
				bit[x2] = CommonLib.getBit(value, x2);
			}

			long pageTableAddress = CommonLib.getValue(value, 12, 31) << 12;
			long avl = CommonLib.getValue(value, 9, 11);
			model.addRow(new String[] { "type", "PDE, value=0x" + Long.toHexString(value) });
			model.addRow(new String[] { "p", String.valueOf(bit[0]) });
			model.addRow(new String[] { "w/r", String.valueOf(bit[1]) });
			model.addRow(new String[] { "u/s", String.valueOf(bit[2]) });
			model.addRow(new String[] { "pwt", String.valueOf(bit[3]) });
			model.addRow(new String[] { "pcd", String.valueOf(bit[4]) });
			model.addRow(new String[] { "a", String.valueOf(bit[5]) });
			model.addRow(new String[] { "d", String.valueOf(bit[6]) });
			model.addRow(new String[] { "g", String.valueOf(bit[8]) });
			model.addRow(new String[] { "avl", String.valueOf(avl) });
			model.addRow(new String[] { "page table address", "0x" + Long.toHexString(pageTableAddress) });
		} else if (type.equals("PTE")) {
			int b[] = PeterBochsCommonLib.getMemoryFromBochs(address, 8);
			long value = CommonLib.getLong(b, 0);
			long bit[] = new long[64];

			for (int x2 = 0; x2 < 64; x2++) {
				bit[x2] = CommonLib.getBit(value, x2);
			}

			long pageTableAddress = CommonLib.getValue(value, 12, 31) << 12;
			long avl = CommonLib.getValue(value, 9, 11);
			model.addRow(new String[] { "type", "PTE, value=0x" + Long.toHexString(value) });
			model.addRow(new String[] { "p", String.valueOf(bit[0]) });
			model.addRow(new String[] { "w/r", String.valueOf(bit[1]) });
			model.addRow(new String[] { "u/s", String.valueOf(bit[2]) });
			model.addRow(new String[] { "pwt", String.valueOf(bit[3]) });
			model.addRow(new String[] { "pcd", String.valueOf(bit[4]) });
			model.addRow(new String[] { "a", String.valueOf(bit[5]) });
			model.addRow(new String[] { "d", String.valueOf(bit[6]) });
			model.addRow(new String[] { "pat", String.valueOf(bit[7]) });
			model.addRow(new String[] { "g", String.valueOf(bit[8]) });
			model.addRow(new String[] { "avl", String.valueOf(avl) });
			model.addRow(new String[] { "page table address", "0x" + Long.toHexString(pageTableAddress) });
		}

		jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
		jTable1.getColumnModel().getColumn(1).setPreferredWidth(500);
	}

	private void initGUI() {
		try {
			TableLayout thisLayout = new TableLayout(new double[][] { { TableLayout.FILL, TableLayout.FILL }, { 26.0, TableLayout.FILL, TableLayout.FILL } });
			thisLayout.setHGap(5);
			thisLayout.setVGap(5);
			getContentPane().setLayout(thisLayout);
			this.setTitle("Helper, address : 0x" + Long.toHexString(address));
			{
				jBytesLabel = new JLabel();
				getContentPane().add(jBytesLabel, "0, 0, 1, 0");
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1, "0, 1, 1, 2");
				{
					TableModel jTable1Model = new DefaultTableModel(new String[][] {}, new String[] { "Field", "Value" });
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(jTable1Model);
				}
			}
			setSize(600, 300);
			CommonLib.centerDialog(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
