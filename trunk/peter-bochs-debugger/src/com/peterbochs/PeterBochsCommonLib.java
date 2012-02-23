package com.peterbochs;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.petersoft.CommonLib;
import com.petersoft.advancedswing.jprogressbardialog.JProgressBarDialog;

public class PeterBochsCommonLib {
	private final static int max_row_limit_in_xls = 65535;
	private final static short rowHeight = 250;

	public PeterBochsCommonLib() {
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

	public static String empty(Object str) {
		if (str == null) {
			return "";
		} else {
			return str.toString();
		}
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

	public static void exportRegisterHistory(File file, JProgressBarDialog d) {
		Workbook wb = new HSSFWorkbook();
		exportRegisterHistory(wb, d);
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

	public static void exportRegisterHistory(Workbook wb, JProgressBarDialog d) {
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet("Registers");
		sheet.setColumnWidth(5, 30000);
		sheet.setColumnWidth(6, 30000);

		// Create a row and put some cells in it. Rows are 0 based.
		String columnNames[] = { "row no.", "time", "ptime", "cs", "eip", "instruction", "c code", "ds", "es", "fs", "gs", "ss", "eflags", "eax", "ebx", "ecx", "edx", "esi",
				"edi", "ebp", "esp", "cr0", "cr2", "cr3", "cr4", "gdtr", "ldtr", "idtr", "tr" };
		Vector data[] = { AllRegisters.time, AllRegisters.ptime, AllRegisters.cs, AllRegisters.eip, AllRegisters.instructions, AllRegisters.cCode, AllRegisters.ds,
				AllRegisters.es, AllRegisters.fs, AllRegisters.gs, AllRegisters.ss, AllRegisters.eflags, AllRegisters.eax, AllRegisters.ebx, AllRegisters.ecx, AllRegisters.edx,
				AllRegisters.esi, AllRegisters.edi, AllRegisters.ebp, AllRegisters.esp, AllRegisters.cr0, AllRegisters.cr2, AllRegisters.cr3, AllRegisters.cr4, AllRegisters.gdtr,
				AllRegisters.ldtr, AllRegisters.idtr, AllRegisters.tr };
		Row row = sheet.createRow(0);

		Cell cell;
		for (int x = 0; x < columnNames.length; x++) {
			cell = row.createCell(x);
			cell.setCellValue(columnNames[x]);
			d.jProgressBar.setString("General register worksheet, creating column : " + columnNames[x]);
		}

		CellStyle style = wb.createCellStyle();
		style.setFillBackgroundColor(HSSFColor.LIME.index);

		if (AllRegisters.time.size() > max_row_limit_in_xls) {
			JOptionPane.showMessageDialog(null, "Will export " + max_row_limit_in_xls + " row only, this is the xls limit");
		}

		CellStyle cellStyleNormal = wb.createCellStyle();
		CellStyle cellStyleHighlight = wb.createCellStyle();

		cellStyleNormal.setDataFormat(createHelper.createDataFormat().getFormat("yy/m/d h:mm:ss"));
		cellStyleHighlight.setDataFormat(createHelper.createDataFormat().getFormat("yy/m/d h:mm:ss"));

		//		cellStyleHighlight.setFillBackgroundColor(HSSFColor.LIME.index);
		//		cellStyleHighlight.setFillPattern(CellStyle.ALIGN_FILL);

		//		cellStyleHighlight.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyleHighlight.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		cellStyleHighlight.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		//		cellStyleHighlight.setBorderBottom(CellStyle.BORDER_THIN);
		//		cellStyleHighlight.setBorderLeft(CellStyle.BORDER_THIN);
		//		cellStyleHighlight.setBorderRight(CellStyle.BORDER_THIN);
		//		cellStyleHighlight.setBorderTop(CellStyle.BORDER_THIN);

		// data
		for (int rowY = 0; rowY < AllRegisters.time.size() && rowY < max_row_limit_in_xls; rowY++) {
			d.jProgressBar.setString("General register worksheet, exporting row: " + rowY);
			row = sheet.createRow(rowY + 1);
			cell = row.createCell(0);
			cell.setCellValue("'" + (rowY + 1));
			if (rowY % 2 == 0) {
				cell.setCellStyle(cellStyleHighlight);
			} else {
				cell.setCellStyle(cellStyleNormal);
			}

			int max = 1;
			for (int rowX = 0; rowX < data.length; rowX++) {
				cell = row.createCell(rowX + 1);
				if (rowY % 2 == 0) {
					cell.setCellStyle(cellStyleHighlight);
				} else {
					cell.setCellStyle(cellStyleNormal);
				}
				Object obj = data[rowX].get(rowY);
				if (obj != null) {
					if (obj.getClass() == Long.class) {
						cell.setCellValue("0x" + Long.toHexString((Long) obj));
					} else if (obj.getClass() == Date.class) {
						cell.setCellValue(obj.toString().trim());
					} else {
						cell.setCellValue(obj.toString().trim());
					}
					if (obj.toString().trim().split("\n").length > max) {
						max = obj.toString().trim().split("\n").length;
					}
				}
			}
			row.setHeight((short) (rowHeight * max));
		}
		//		if (AllRegisters.time.size() < 20000) {
		//			for (int x = 0; x < columnNames.length; x++) {
		//				sheet.autoSizeColumn(x);
		//				d.jProgressBar.setString("General register worksheet, auto resize column : " + x);
		//			}
		//		}

		//fpu
		sheet = wb.createSheet("FPU");
		columnNames = new String[] { "row no.", "time", "ptime", "instruction", "status", "control", "tag", "operand", "fip", "fcs", "fdp", "fds" };
		data = new Vector[] { AllRegisters.time, AllRegisters.ptime, AllRegisters.instructions, AllRegisters.fpu_status, AllRegisters.fpu_control, AllRegisters.fpu_tag,
				AllRegisters.fpu_operand, AllRegisters.fip, AllRegisters.fcs, AllRegisters.fdp, AllRegisters.fds };
		row = sheet.createRow(0);

		for (int x = 0; x < columnNames.length; x++) {
			cell = row.createCell(x);
			cell.setCellValue(columnNames[x]);
			d.jProgressBar.setString("FPU worksheet, creating column : " + columnNames[x]);
		}

		for (int rowY = 0; rowY < AllRegisters.time.size() && rowY < max_row_limit_in_xls; rowY++) {
			d.jProgressBar.setString("General register worksheet, exporting row: " + rowY);
			row = sheet.createRow(rowY + 1);
			cell = row.createCell(0);
			if (rowY % 2 == 0) {
				cell.setCellStyle(cellStyleHighlight);
			} else {
				cell.setCellStyle(cellStyleNormal);
			}
			cell.setCellValue("'" + (rowY + 1));

			for (int y = 0; y < data.length; y++) {
				cell = row.createCell(y + 1);
				if (rowY % 2 == 0) {
					cell.setCellStyle(cellStyleHighlight);
				} else {
					cell.setCellStyle(cellStyleNormal);
				}
				Object obj = data[y].get(rowY);
				if (obj != null) {
					if (obj.getClass() == Long.class) {
						cell.setCellValue("0x" + Long.toHexString((Long) obj));
					} else if (obj.getClass() == Date.class) {
						cell.setCellValue(obj.toString().trim());
					} else {
						cell.setCellValue(obj.toString());
					}
				}
			}
		}
		//		if (AllRegisters.time.size() < 20000) {
		//			for (int x = 0; x < columnNames.length; x++) {
		//				sheet.autoSizeColumn(x);
		//				d.jProgressBar.setString("FPU worksheet, auto resize column : " + x);
		//			}
		//		}
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

	public static void exportTableModelToExcel(File file, int bytes[], String sheetName, long startAddress) {
		Workbook wb = new HSSFWorkbook();// Write the output to a file
		exportTableModelToExcel(file, bytes, sheetName, wb, startAddress);
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

	public static void exportTableModelToExcel(File file, int bytes[], String sheetName, Workbook wb, long startAddress) {
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet(sheetName);

		// column header
		Row row = null;
		Cell cell;
		int rowNo = 0;
		int columnNo = 1;
		for (int x = 0; x < bytes.length; x++) {
			if (x % 16 == 0) {
				row = sheet.createRow(rowNo);
				cell = row.createCell(0);
				cell.setCellValue(startAddress);
				rowNo++;
				columnNo = 0;
			} else {
				cell = row.createCell(columnNo);
				cell.setCellValue("0x" + Long.toHexString(bytes[x]));
				columnNo++;
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

	public static long getPhysicalAddress(long cr3, long linearAddress) {
		long pdNo = CommonLib.getValue(linearAddress, 22, 31);
		long ptNo = CommonLib.getValue(linearAddress, 12, 21);
		long offset = CommonLib.getValue(linearAddress, 0, 11);
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
		Long pde = CommonLib.getValue(CommonLib.getLong(bytes, 0), 12, 31) << 12;
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
		Long pageAddr = CommonLib.getValue(CommonLib.getLong(bytes, 0), 12, 31) << 12;
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
			map.put("software", properties.getProperty("software"));
			map.put("latestVersion", properties.getProperty("latestVersion"));
			map.put("url", properties.getProperty("url"));
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
}
