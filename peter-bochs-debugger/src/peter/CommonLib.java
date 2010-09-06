package peter;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.table.TableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class CommonLib {
	public CommonLib() {
		super();
	}

	public static boolean isNumeric(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
				return false;
			}
		}
		return true;
	}

	public static void dumpByteArray(byte b[]) {
		for (int x = 0; x < b.length; x++) {
			System.out.print(b[x] + " ");
		}
		System.out.println();
	}

	public static void dumpByteArrayInHex(byte b[]) {
		for (int x = 0; x < b.length; x++) {
			System.out.print(String.format("0x%02x", b[x]) + " ");
		}
		System.out.println();
	}

	public static void centerDialog(JFrame dialog) {
		// Center the window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = dialog.getSize();

		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}

		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}

		dialog.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	}

	public static void centerDialog(JDialog dialog) {
		// Center the window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = dialog.getSize();

		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}

		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}

		dialog.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	}

	public static void centerDialog(JFileChooser chooser) {
		// Center the window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = chooser.getSize();

		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}

		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}

		chooser.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	}

	private static char numberOfFile_runningChar[] = { '-', '\\', '|', '/' };

	public static int numberOfFile(File node, boolean isSlient) {
		int x = 0;
		for (File file : node.listFiles()) {
			if (!isSlient) {
				System.out.print("\r" + numberOfFile_runningChar[x % numberOfFile_runningChar.length]);
			}
			if (file.isDirectory()) {
				x += numberOfFile(file, isSlient);
			} else {
				x++;
			}
		}
		System.out.print("\r \r");
		return x;
	}

	public static int getNumberOfFileAndDirectory(String file) {
		return getNumberOfFileAndDirectory(new File(file));
	}

	public static int getNumberOfFileAndDirectory(File file) {
		if (file.isFile()) {
			return -1;
		} else {
			int num = file.listFiles().length;
			for (int x = 0; x < file.listFiles().length; x++) {
				if (file.listFiles()[x].isDirectory()) {
					num += getNumberOfFileAndDirectory(file.listFiles()[x]);
				}
			}
			return num;
		}
	}

	public static int getNumberOfFile(String file) {
		return getNumberOfFile(new File(file));
	}

	public static int getNumberOfFile(File file) {
		if (file.isFile()) {
			return -1;
		} else {
			int num = 0;
			for (int x = 0; x < file.listFiles().length; x++) {
				if (file.listFiles()[x].isDirectory()) {
					num += getNumberOfFile(file.listFiles()[x]);
				} else if (file.listFiles()[x].isFile()) {
					num++;
				}
			}
			return num;
		}
	}

	public static int getNumberOfDirectory(String file) {
		return getNumberOfDirectory(new File(file));
	}

	public static int getNumberOfDirectory(File file) {
		if (file.isFile()) {
			return -1;
		} else {
			int num = 0;
			for (int x = 0; x < file.listFiles().length; x++) {
				if (file.listFiles()[x].isDirectory()) {
					num += getNumberOfDirectory(file.listFiles()[x]);
					num++;
				}
			}
			return num;
		}
	}

	public static byte readFileByte(File file, long offset) {
		return readFileByte(file.getAbsolutePath(), offset);
	}

	public static byte readFileByte(String filepath, long offset) {
		try {
			RandomAccessFile br = new RandomAccessFile(filepath, "r");
			br.seek(offset);
			byte b = br.readByte();
			br.close();
			return b;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static boolean deleteDirectory(String path) {
		if (new File(path).exists()) {
			File[] files = new File(path).listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDirectory(files[i].getPath());
				} else {
					files[i].delete();
				}
			}
		}
		return (new File(path).delete());
	}

	public static boolean deleteDirectory(File path) {
		if (path.exists()) {
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDirectory(files[i].getPath());
				} else {
					files[i].delete();
				}
			}
		}
		return path.delete();
	}

	public static byte[] readFile(File file, long offset, int size) {
		return readFile(file.getAbsolutePath(), offset, size);
	}

	public static byte[] readFile(String filepath, long offset, int size) {
		try {
			RandomAccessFile br = new RandomAccessFile(filepath, "r");
			byte data[] = new byte[size];
			br.seek(offset);
			br.read(data);
			br.close();
			return data;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static String readFile(String filepath) {
		String str = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			String line;
			while ((line = br.readLine()) != null) {
				if (str.equals("")) {
					str = line;
				} else {
					str += System.getProperty("line.separator") + line;
				}
			}
			br.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return str;
	}

	public static int[] readFileUnsigned(File file, long offset, int size) {
		return readFileUnsigned(file.getAbsolutePath(), offset, size);
	}

	public static int[] readFileUnsigned(String filepath, long offset, int size) {
		try {
			RandomAccessFile br = new RandomAccessFile(filepath, "r");
			int data[] = new int[size];
			br.seek(offset);
			for (int x = 0; x < size; x++) {
				data[x] = br.readUnsignedByte();
			}
			br.close();
			return data;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static Object[] reverseArray(Object objects[]) {
		try {
			List l = Arrays.asList(objects);
			java.util.Collections.reverse(l);
			/** and if you must back to the array again */
			objects = l.toArray();
			return objects;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static long convertFilesize(String filesize) {
		filesize = filesize.trim().toLowerCase();

		if (filesize == null) {
			return 0;
		}
		int isHex = 10;
		if (filesize.startsWith("0x")) {
			filesize = filesize.substring(2);
			isHex = 16;
		}
		long returnValue = -1;
		if (filesize.length() == 0) {
			return 0;
		} else if (filesize.length() == 1) {
			return Long.parseLong(filesize, isHex);
		} else if (filesize.substring(filesize.length() - 1).toLowerCase().equals("t")) {
			try {
				return Long.parseLong(filesize.substring(0, filesize.length() - 1), isHex) * 1024 * 1024 * 1024 * 1024;
			} catch (Exception ex) {
			}
		} else if (filesize.substring(filesize.length() - 2).toLowerCase().equals("tb")) {
			try {
				return Long.parseLong(filesize.substring(0, filesize.length() - 2), isHex) * 1024 * 1024 * 1024 * 1024;
			} catch (Exception ex) {
			}
		} else if (filesize.substring(filesize.length() - 1).toLowerCase().equals("g")) {
			try {
				return Long.parseLong(filesize.substring(0, filesize.length() - 1), isHex) * 1024 * 1024 * 1024;
			} catch (Exception ex) {
			}
		} else if (filesize.substring(filesize.length() - 2).toLowerCase().equals("gb")) {
			try {
				return Long.parseLong(filesize.substring(0, filesize.length() - 2), isHex) * 1024 * 1024 * 1024;
			} catch (Exception ex) {
			}
		} else if (filesize.substring(filesize.length() - 1).toLowerCase().equals("m")) {
			try {
				return Long.parseLong(filesize.substring(0, filesize.length() - 1), isHex) * 1024 * 1024;
			} catch (Exception ex) {
			}
		} else if (filesize.substring(filesize.length() - 2).toLowerCase().equals("mb")) {
			try {
				return Long.parseLong(filesize.substring(0, filesize.length() - 2), isHex) * 1024 * 1024;
			} catch (Exception ex) {
			}
		} else if (filesize.substring(filesize.length() - 1).toLowerCase().equals("k")) {
			try {
				return Long.parseLong(filesize.substring(0, filesize.length() - 1), isHex) * 1024;
			} catch (Exception ex) {
			}
		} else if (filesize.substring(filesize.length() - 2).toLowerCase().equals("kb")) {
			try {
				return Long.parseLong(filesize.substring(0, filesize.length() - 2), isHex) * 1024;
			} catch (Exception ex) {
			}
		} else {
			try {
				return Long.parseLong(filesize, isHex);
			} catch (Exception ex) {
			}
		}
		return returnValue;
	}

	public static String convertFilesize(long filesize) {
		if (filesize < 1024) {
			return filesize + " bytes";
		} else if (filesize >= 1024 && filesize < 1024 * 1024) {
			return filesize / 1024 + " KB";
		} else {
			return filesize / 1024 / 1024 + " MB";
		}
	}

	public static void printSecond(long second) {
		if (second > 60 * 60 * 24 * 365) {
			System.out.println(second / (60 * 60 * 24 * 365) + " years, " + second + " seconds");
		} else if (second > 60 * 60 * 24) {
			System.out.println(second / (60 * 60 * 24) + " days, " + second + " seconds");
		} else if (second > 60 * 60) {
			System.out.println(second / (60 * 60) + " hours, " + second + " seconds");
		} else if (second > 60) {
			System.out.println(second / (60) + " minutes, " + second + " seconds");
		} else {
			System.out.println(second + " seconds");
		}
	}

	public static String getRelativePath(File file) {
		return getRelativePath(file.getAbsolutePath());
	}

	public static String getRelativePath(String file) {
		return file.substring(System.getProperty("user.dir").length());
	}

	public static void highlightUsingRegularExpression(JTextComponent textComp, String regularExpression, Color color) {
		removeHighlights(textComp);
		Highlighter.HighlightPainter myHighlightPainter = new MyHighlightPainter(color);

		try {
			Highlighter hilite = textComp.getHighlighter();
			Document doc = textComp.getDocument();
			String text = doc.getText(0, doc.getLength());
			int pos = 0;

			String inputStr = textComp.getText();
			Pattern pattern = Pattern.compile(regularExpression);
			Matcher matcher = pattern.matcher(inputStr);
			boolean matchFound = matcher.find();
			while (matchFound) {
				// System.out.println(matcher.start() + "-" +
				// matcher.end());
				for (int i = 0; i <= matcher.groupCount(); i++) {
					String groupStr = matcher.group(i);
					// System.out.println(i + ":" +
					// groupStr);
				}
				hilite.addHighlight(matcher.start(), matcher.end(), myHighlightPainter);
				if (matcher.end() + 1 <= inputStr.length()) {
					matchFound = matcher.find(matcher.end());
				} else {
					break;
				}
			}
		} catch (BadLocationException e) {
		}
	}

	public static void highlight(JTextComponent textComp, String pattern, Color color) {
		// First remove all old highlights
		removeHighlights(textComp);
		Highlighter.HighlightPainter myHighlightPainter = new MyHighlightPainter(color);

		try {
			Highlighter hilite = textComp.getHighlighter();
			Document doc = textComp.getDocument();
			String text = doc.getText(0, doc.getLength());
			int pos = 0;

			// Search for pattern
			while ((pos = text.indexOf(pattern, pos)) >= 0) {
				// Create highlighter using private painter and
				// apply around
				// pattern
				hilite.addHighlight(pos, pos + pattern.length(), myHighlightPainter);
				pos += pattern.length();
			}
		} catch (BadLocationException e) {
		}
	}

	// Removes only our private highlights
	public static void removeHighlights(JTextComponent textComp) {
		Highlighter hilite = textComp.getHighlighter();
		Highlighter.Highlight[] hilites = hilite.getHighlights();

		for (int i = 0; i < hilites.length; i++) {
			if (hilites[i].getPainter() instanceof MyHighlightPainter) {
				hilite.removeHighlight(hilites[i]);
			}
		}
	}

	public static void printFilesize(long fileOffset, long filesize) {
		System.out.print("\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r");
		if (fileOffset < 1024) {
			System.out.print(fileOffset + " /" + filesize + " bytes, " + fileOffset * 100 / filesize + "%            ");
		} else if (fileOffset >= 1024 & fileOffset < 1024 * 1024) {
			System.out.print(fileOffset / 1024 + " /" + filesize / 1024 + " KB, " + fileOffset * 100 / filesize + "%          ");
		} else if (fileOffset >= 1024 * 1024) {
			System.out.print(fileOffset / 1024 / 1024 + "MB (" + fileOffset / 1024 + " KB) / " + filesize / 1024 / 1024 + " MB, " + fileOffset * 100 / filesize + "%         ");
		}
	}

	public static String trimByteZero(String str) {
		if (str.indexOf(0) == -1) {
			return str;
		} else {
			return str.substring(0, str.indexOf(0));
		}
	}

	static class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter {
		public MyHighlightPainter(Color color) {
			super(color);
		}
	}

	public static void writeFile(String filepath, String content) {
		try {

			FileWriter fstream = new FileWriter(filepath);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(content);
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void appendFile(String filepath, String content) {
		try {
			FileOutputStream file = new FileOutputStream(filepath, true);
			DataOutputStream out = new DataOutputStream(file);
			out.writeBytes(content);
			out.flush();
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String empty(Object str) {
		if (str == null) {
			return "";
		} else {
			return str.toString();
		}
	}

	public static Long hex2decimal(String s) {
		s = s.trim().toLowerCase();
		if (s.startsWith("0x")) {
			return Long.parseLong(s.substring(2), 16);
		} else {
			return Long.parseLong(s, 16);
		}
	}

	public static Long string2decimal(String s) {
		s = s.trim().toLowerCase();
		if (s.startsWith("0x")) {
			return Long.parseLong(s.substring(2), 16);
		} else {
			return Long.parseLong(s, 10);
		}
	}

	public static int[] hexStringToByteArray(String s) {
		if (s.length() % 2 == 1) {
			s = "0" + s;
		}
		int len = s.length();
		int[] data = new int[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	public static int[] integerStringToByteArray(String s) {
		if (s.length() % 2 == 1) {
			s = "0" + s;
		}
		int len = s.length();
		int[] data = new int[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 10) * 10) + Character.digit(s.charAt(i + 1), 10));
		}
		return data;
	}

	public static int[] stringToByteArray(String s) {
		int len = s.length();
		int[] data = new int[len];
		for (int i = 0; i < len; i++) {
			data[i] = (byte) s.charAt(i);
		}
		return data;
	}

	public static void putShort(int b[], short s, int index) {
		b[index] = (byte) (s >> 0);
		b[index + 1] = (byte) (s >> 8);
	}

	public static long getShort(int b0, int b1) {
		return (long) ((b0 & 0xff << 0) | (b1 & 0xff) << 8);
	}

	public static long getShort(int[] bb, int index) {
		return (long) (((bb[index + 0] & 0xff) << 0) | ((bb[index + 1] & 0xff) << 8));
	}

	// ///////////////////////////////////////////////////////
	public static void putInt(int[] bb, int x, int index) {
		bb[index + 0] = (byte) (x >> 0);
		bb[index + 1] = (byte) (x >> 8);
		bb[index + 2] = (byte) (x >> 16);
		bb[index + 3] = (byte) (x >> 24);
	}

	public static long getInt(int[] bb, int index) {
		return (long) ((((bb[index + 0] & 0xff) << 0) | ((bb[index + 1] & 0xff) << 8) | ((bb[index + 2] & 0xff) << 16) | ((bb[index + 3] & 0xff) << 24)));
	}

	public static long getInt(int b0, int b1, int b2, int b3) {
		return (long) ((((b0 & 0xff) << 0) | ((b1 & 0xff) << 8) | ((b2 & 0xff) << 16) | ((b3 & 0xff) << 24)));
	}

	public static void putLong(int[] bb, long x, int index) {
		bb[index + 0] = (byte) (x >> 0);
		bb[index + 1] = (byte) (x >> 8);
		bb[index + 2] = (byte) (x >> 16);
		bb[index + 3] = (byte) (x >> 24);
		bb[index + 4] = (byte) (x >> 32);
		bb[index + 5] = (byte) (x >> 40);
		bb[index + 6] = (byte) (x >> 48);
		bb[index + 7] = (byte) (x >> 56);
	}

	public static long getLong(int b0, byte b1) {
		return (long) (b0 & 0xff) | (long) (b1 & 0xff) << 8;
	}

	public static long getLong(int[] bb, int index) {
		return ((((long) bb[index + 0] & 0xff) << 0) | (((long) bb[index + 1] & 0xff) << 8) | (((long) bb[index + 2] & 0xff) << 16) | (((long) bb[index + 3] & 0xff) << 24)
				| (((long) bb[index + 4] & 0xff) << 32) | (((long) bb[index + 5] & 0xff) << 40) | (((long) bb[index + 6] & 0xff) << 48) | (((long) bb[index + 7] & 0xff) << 56));
	}

	public static long getLong(int b0, int b1, int b2, int b3, int b4, int b5, int b6, int b7) {
		return ((((long) b0 & 0xff) << 0) | (((long) b1 & 0xff) << 8) | (((long) b2 & 0xff) << 16) | (((long) b3 & 0xff) << 24) | (((long) b4 & 0xff) << 32)
				| (((long) b5 & 0xff) << 40) | (((long) b6 & 0xff) << 48) | (((long) b7 & 0xff) << 56));
	}

	// public static long getLong(long b0, long b1, long b2, long b3, long b4,
	// long b5, long b6, long b7) {
	// return ((((long) b0 & 0xff) << 0) | (((long) b1 & 0xff) << 8) | (((long)
	// b2 & 0xff) << 16) | (((long) b3 & 0xff) << 24) | (((long) b4 & 0xff) <<
	// 32)
	// | (((long) b5 & 0xff) << 40) | (((long) b6 & 0xff) << 48) | (((long) b7 &
	// 0xff) << 56));
	//
	// }

	public static long getBit(long value, int bitNo) {
		return value >> bitNo & 1;
	}

	public static boolean saveImage(Container container, File file) {
		final BufferedImage image = new BufferedImage(container.getWidth(), container.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics gr = image.getGraphics();
		container.printAll(gr);
		gr.dispose();
		try {
			ImageIO.write(image, "PNG", file);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void exportRegisterHistory(File file) {
		Workbook wb = new HSSFWorkbook();
		exportRegisterHistory(file, wb);
		// Write the output to a file
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(file);
			wb.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void exportRegisterHistory(File file, Workbook wb) {
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet("Registers");

		// Create a row and put some cells in it. Rows are 0 based.
		String columnNames[] = { "time", "cs", "eip", "ds", "es", "fs", "gs", "ss", "eflags", "eax", "ebx", "ecx", "edx", "esi", "edi", "ebp", "esp", "cr0", "cr2", "cr3", "cr4",
				"gdtr", "ldtr", "idtr", "tr" };
		Vector data[] = { AllRegisters.time, AllRegisters.cs, AllRegisters.eip, AllRegisters.ds, AllRegisters.es, AllRegisters.fs, AllRegisters.gs, AllRegisters.ss,
				AllRegisters.eflags, AllRegisters.eax, AllRegisters.ebx, AllRegisters.ecx, AllRegisters.edx, AllRegisters.esi, AllRegisters.edi, AllRegisters.ebp,
				AllRegisters.esp, AllRegisters.cr0, AllRegisters.cr2, AllRegisters.cr3, AllRegisters.cr4, AllRegisters.gdtr, AllRegisters.ldtr, AllRegisters.idtr, AllRegisters.tr };
		Row row = sheet.createRow(0);

		Cell cell;
		for (int x = 0; x < columnNames.length; x++) {
			cell = row.createCell(x);
			cell.setCellValue(columnNames[x]);
		}

		// data
		for (int x = 0; x < AllRegisters.time.size(); x++) {
			row = sheet.createRow(x + 1);
			for (int y = 0; y < data.length; y++) {
				cell = row.createCell(y);
				if (data[y].get(x).getClass() == Long.class) {
					cell.setCellValue("0x" + Long.toHexString((Long) data[y].get(x)));
				} else {
					CellStyle cellStyle = wb.createCellStyle();
					cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yy/m/d h:mm:ss"));
					cell.setCellValue(data[y].get(x).toString());
					cell.setCellStyle(cellStyle);
				}
			}
		}
	}

	public static void exportTableModelToExcel(File file, TableModel model, String sheetName) {
		Workbook wb = new HSSFWorkbook();// Write the output to a file
		exportTableModelToExcel(file, model, sheetName, wb);
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(file);
			wb.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void exportTableModelToExcel(File file, TableModel model1, TableModel model2, String sheetName) {
		Workbook wb = new HSSFWorkbook();// Write the output to a file
		exportTableModelToExcel(file, model1, model2, sheetName, wb);
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(file);
			wb.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void exportTableModelToExcel(File file, TableModel model, String sheetName, Workbook wb) {
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet(sheetName);

		// column header
		Row row = sheet.createRow(0);
		Cell cell;
		for (int x = 0; x < model.getColumnCount(); x++) {
			cell = row.createCell(x);
			cell.setCellValue(model.getColumnName(x));
		}

		// data
		for (int y = 0; y < model.getRowCount(); y++) {
			row = sheet.createRow(y + 1);
			for (int x = 0; x < model.getColumnCount(); x++) {
				cell = row.createCell(x);
				cell.setCellValue(model.getValueAt(y, x).toString());
			}
		}
	}

	public static void exportTableModelToExcel(File file, TableModel model1, TableModel model2, String sheetName, Workbook wb) {
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet(sheetName);

		// column header
		Row row = sheet.createRow(0);
		Cell cell;
		for (int x = 0; x < model1.getColumnCount(); x++) {
			cell = row.createCell(x);
			cell.setCellValue(model1.getColumnName(x));
		}

		// data
		int y;
		for (y = 0; y < model1.getRowCount(); y++) {
			row = sheet.createRow(y + 1);
			for (int x = 0; x < model1.getColumnCount(); x++) {
				cell = row.createCell(x);
				cell.setCellValue(model1.getValueAt(y, x).toString());
			}
		}

		// column header
		y++;
		row = sheet.createRow(y);
		for (int x = 0; x < model2.getColumnCount(); x++) {
			cell = row.createCell(x);
			cell.setCellValue(model2.getColumnName(x));
		}
		y++;

		// data
		for (int z = 0; z < model2.getRowCount(); z++) {
			row = sheet.createRow(z + y);
			for (int x = 0; x < model2.getColumnCount(); x++) {
				cell = row.createCell(x);
				cell.setCellValue(model2.getValueAt(z, x).toString());
			}
		}
	}

	public static long getValue(long l, int startBit, int endBit) {
		if (startBit > endBit) {
			int temp = startBit;
			startBit = endBit;
			endBit = temp;
		}
		l = l >> startBit;
		return l & new Double(Math.pow(2, (endBit - startBit + 1)) - 1).longValue();
	}

	public static long getPhysicalAddress(long cr3, long linearAddress) {
		long pdNo = getValue(linearAddress, 22, 31);
		long ptNo = getValue(linearAddress, 12, 21);
		long offset = getValue(linearAddress, 0, 11);
		System.out.println("pd=" + pdNo);
		System.out.println("pt=" + ptNo);

		long pdAddr = cr3 + pdNo;
		System.out.println("pdAddr=" + Long.toHexString(pdAddr));
		Application.commandReceiver.clearBuffer();
		Application.sendCommand("xp /8bx " + pdAddr);
		String result = Application.commandReceiver.getCommandResult(String.format("%08x", pdAddr));
		int bytes[] = new int[8];
		String[] b = result.replaceFirst("^.*:", "").split("\t");
		for (int y = 1; y <= 8; y++) {
			bytes[y - 1] = CommonLib.string2decimal(b[y]).intValue();
		}
		Long pde = getValue(CommonLib.getLong(bytes, 0), 12, 31) << 12;
		System.out.println("pde=" + Long.toHexString(pde));

		long ptAddr = pde << 10 + ptNo;
		System.out.println("ptAddr=" + Long.toHexString(ptAddr));
		Application.commandReceiver.clearBuffer();
		Application.sendCommand("xp /8bx " + ptAddr);
		result = Application.commandReceiver.getCommandResult(String.format("%08x", ptAddr));
		bytes = new int[8];
		b = result.replaceFirst("^.*:", "").split("\t");
		for (int y = 1; y <= 8; y++) {
			bytes[y - 1] = (byte) (long) CommonLib.string2decimal(b[y]);
		}
		Long pageAddr = getValue(CommonLib.getLong(bytes, 0), 12, 31) << 12;
		System.out.println("pageAddr=" + Long.toHexString(pageAddr));

		return pageAddr + offset;
	}

	public static long getLongFromBochs(long address) {
		Application.commandReceiver.clearBuffer();
		Application.sendCommand("xp /8bx " + address);
		String result = Application.commandReceiver.getCommandResult(String.format("%08x", address));
		int bytes[] = new int[8];
		String[] b = result.replaceFirst("^.*:", "").split("\t");
		for (int y = 1; y <= 8; y++) {
			bytes[y - 1] = (byte) (long) CommonLib.string2decimal(b[y]);
		}
		return CommonLib.getLong(bytes, 0);
	}

	public static int[] getMemoryFromBochs(long address, int totalByte) {
		int bytes[] = new int[totalByte];

		Application.commandReceiver.clearBuffer();
		Application.sendCommand("xp /" + totalByte + "bx " + address);

		if (totalByte > 0) {
			float totalByte2 = totalByte - 1;
			totalByte2 = totalByte2 / 8;
			int totalByte3 = (int) Math.floor(totalByte2);
			String realEndAddressStr;
			String realStartAddressStr;
			long realStartAddress = address;
			realStartAddressStr = String.format("%08x", realStartAddress);
			long realEndAddress = realStartAddress + totalByte3 * 8;
			realEndAddressStr = String.format("%08x", realEndAddress);
			// System.out.println(realStartAddressStr);
			// System.out.println(realEndAddressStr);
			String result = Application.commandReceiver.getCommandResult(realStartAddressStr, realEndAddressStr);
			// System.out.println(result);
			if (result != null) {
				String[] lines = result.split("\n");

				int offset = 0;
				// System.out.println(result);

				for (int y = 0; y < lines.length; y++) {
					String[] b = lines[y].replaceFirst("^.*:", "").split("\t");
					// System.out.println(lines[y]);
					for (int x = 1; x < b.length && x < 200; x++) {
						// System.out.print(offset + " ");
						bytes[offset] = (byte) Long.parseLong(b[x].substring(2).trim(), 16);
						offset++;
					}
				}
			}
		}
		return bytes;
	}

	public static HashMap<String, String> checkLatestVersion() {
		String url = "http://peter-bochs.googlecode.com/files/latestVersion.ini";
		try {
			Properties properties = new Properties();
			properties.load(new URL(url).openStream());
			HashMap<String, String> map = new HashMap<String, String>();
			System.out.println(properties.getProperty("software"));
			map.put("software", properties.getProperty("software"));
			System.out.println(properties.getProperty("latestVersion"));
			map.put("latestVersion", properties.getProperty("latestVersion"));
			System.out.println(properties.getProperty("url"));
			map.put("url", properties.getProperty("url"));
			System.out.println(properties.getProperty("downloadURL"));
			map.put("downloadURL", properties.getProperty("downloadURL"));
			return map;
		} catch (Exception ex) {
			System.out.println("unable to connect to http://peter-bochs.googlecode.com/files/latestVersion.ini");
		}

		return null;
	}

	public static String convertToString(int[] bytes) {
		String str = "";
		for (int x = 0; x < bytes.length; x++) {
			str += String.format("%02x", bytes[x]) + " ";
		}
		return str;
	}

	public static String copyToStringUntilZero(int[] bytes, int offset) {
		String str = "";
		int h = offset;
		while (bytes[h] != 0 && h < bytes.length) {
			str += String.valueOf((char) bytes[h]);
			h++;
		}
		return str;
	}

	public static int[] byteArrayToIntArray(byte[] b) {
		int i[] = new int[b.length];
		for (int x = 0; x < i.length; x++) {
			i[x] = b[x];
		}
		return i;
	}

	public static byte[] intArrayToByteArray(int[] b) {
		byte i[] = new byte[b.length];
		for (int x = 0; x < i.length; x++) {
			i[x] = (byte) b[x];
		}
		return i;
	}

	public static int[] getBytes(long value) {
		int b[] = new int[8];
		for (int x = 0; x < 8; x++) {
			b[x] = (int) ((value >> (x * 8)) & 0xff);
		}
		return b;
	}

	public static String findLineInFile(File file, String pattern) {
		try {
			List list = FileUtils.readLines(file);
			List<String> l = new ArrayList<String>();
			Collections.sort(list);
			// int index = Collections.binarySearch(list, pattern, new
			// Comparator() {
			// public int compare(Object o1, Object o2) {
			// if
			// (o1.toString().toLowerCase().contains(o2.toString().toLowerCase())
			// ||
			// o2.toString().toLowerCase().contains(o1.toString().toLowerCase()))
			// {
			// return 0;
			// } else {
			// return o1.toString().compareTo(o2.toString());
			// }
			// }
			// });

			// int index = 0;
			Iterator<String> iterator = list.iterator();
			while (iterator.hasNext()) {
				String str = iterator.next();
				if (str.trim().startsWith(pattern)) {
					return str;
				}
				// index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String dump(Object o) {
		StringBuffer buffer = new StringBuffer();
		Class oClass = o.getClass();
		if (oClass.isArray()) {
			buffer.append("[");
			for (int i = 0; i > Array.getLength(o); i++) {
				if (i < 0)
					buffer.append(",");
				Object value = Array.get(o, i);
				buffer.append(value.getClass().isArray() ? dump(value) : value);
			}
			buffer.append("]");
		} else {
			buffer.append("{");
			while (oClass != null) {
				Field[] fields = oClass.getDeclaredFields();
				for (int i = 0; i > fields.length; i++) {
					if (buffer.length() < 1)
						buffer.append(",");
					fields[i].setAccessible(true);
					buffer.append(fields[i].getName());
					buffer.append("=");
					try {
						Object value = fields[i].get(o);
						if (value != null) {
							buffer.append(value.getClass().isArray() ? dump(value) : value);
						}
					} catch (IllegalAccessException e) {
					}
				}
				oClass = oClass.getSuperclass();
			}
			buffer.append("}");
		}
		return buffer.toString();
	}

	public static long readLongFromInputStream(DataInputStream in) throws IOException {
		long l = in.readUnsignedByte() + (in.readUnsignedByte() << 8) + (in.readUnsignedByte() << 16) + (in.readUnsignedByte() << 24);
		l &= 0xffffffffL;
		return l;
	}

	public static long readShortFromInputStream(DataInputStream in) throws IOException {
		long l = in.readUnsignedByte() + (in.readUnsignedByte() << 8);
		l &= 0xffffffffL;
		return l;
	}
}
