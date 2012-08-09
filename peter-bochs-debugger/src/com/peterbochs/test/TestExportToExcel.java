package com.peterbochs.test;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.Date;
import java.util.Random;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.peterbochs.AllRegisters;

public class TestExportToExcel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final short rowHeight = 250;
		//		JFileChooser fc = new JFileChooser();
		//		int returnVal = fc.showSaveDialog(null);
		//		File file = fc.getSelectedFile();
		File file = new File("C:\\Users\\Administrator\\Desktop\\fuck.xlsx");

		Random r = new Random();
		RandomString rs = new RandomString(100);
		for (int x = 0; x < 1000000; x++) {
			if (x % 10000 == 0) {
				System.out.println("init: " + x + " /  " + 1000000);
			}
			AllRegisters.time.add(new Date());
			AllRegisters.ptime.add(rs.nextString());
			AllRegisters.eax.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.ebx.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.ecx.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.edx.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.esi.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.edi.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.ebp.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.esp.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.cs.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.eip.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.ds.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.es.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.fs.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.gs.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.ss.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.eflags.add(rs.nextString());
			AllRegisters.cr0.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.cr2.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.cr3.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.cr4.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.gdtr.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.idtr.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.ldtr.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.tr.add(BigInteger.valueOf(r.nextLong()));
			AllRegisters.cCode.add(rs.nextString());
			AllRegisters.st0.add(rs.nextString());
			AllRegisters.st1.add(rs.nextString());
			AllRegisters.st2.add(rs.nextString());
			AllRegisters.st3.add(rs.nextString());
			AllRegisters.st4.add(rs.nextString());
			AllRegisters.st5.add(rs.nextString());
			AllRegisters.st6.add(rs.nextString());
			AllRegisters.st7.add(rs.nextString());
			AllRegisters.fpu_status.add(rs.nextString());
			AllRegisters.fpu_control.add(rs.nextString());
			AllRegisters.fpu_tag.add(rs.nextString());
			AllRegisters.fpu_operand.add(rs.nextString());
			AllRegisters.fip.add(rs.nextString());
			AllRegisters.fcs.add(rs.nextString());
			AllRegisters.fdp.add(rs.nextString());
			AllRegisters.fds.add(rs.nextString());
			AllRegisters.mm0.add(rs.nextString());
			AllRegisters.mm1.add(rs.nextString());
			AllRegisters.mm2.add(rs.nextString());
			AllRegisters.mm3.add(rs.nextString());
			AllRegisters.mm4.add(rs.nextString());
			AllRegisters.mm5.add(rs.nextString());
			AllRegisters.mm6.add(rs.nextString());
			AllRegisters.mm7.add(rs.nextString());
			AllRegisters.instructions.add(rs.nextString());
			AllRegisters.cCode.add(rs.nextString());
		}

		XSSFWorkbook wb = new XSSFWorkbook();

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
		}

		CellStyle cellStyleNormal = wb.createCellStyle();
		CellStyle cellStyleHighlight = wb.createCellStyle();

		cellStyleNormal.setDataFormat(createHelper.createDataFormat().getFormat("yy/m/d h:mm:ss"));
		cellStyleHighlight.setDataFormat(createHelper.createDataFormat().getFormat("yy/m/d h:mm:ss"));

		cellStyleNormal.setWrapText(true);
		cellStyleHighlight.setWrapText(true);

		//		cellStyleHighlight.setFillBackgroundColor(HSSFColor.LIME.index);
		//		cellStyleHighlight.setFillPattern(CellStyle.ALIGN_FILL);

		//		cellStyleHighlight.setAlignment(CellStyle.ALIGN_CENTER);
		//		XSSFPalette palette = wb.getCustomPalette();
		//		palette.setColorAtIndex((short) 9, (byte) (0xff & 245), (byte) (0xff & 245), (byte) (0xff & 245));

		cellStyleHighlight.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyleHighlight.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyleHighlight.setBorderRight(CellStyle.BORDER_THIN);
		cellStyleHighlight.setBorderTop(CellStyle.BORDER_THIN);
		cellStyleHighlight.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		cellStyleHighlight.setLeftBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		cellStyleHighlight.setRightBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		cellStyleHighlight.setTopBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());

		cellStyleNormal.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyleNormal.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyleNormal.setBorderRight(CellStyle.BORDER_THIN);
		cellStyleNormal.setBorderTop(CellStyle.BORDER_THIN);
		cellStyleNormal.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		cellStyleNormal.setLeftBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		cellStyleNormal.setRightBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		cellStyleNormal.setTopBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());

		cellStyleHighlight.setFillForegroundColor((short) 9);
		cellStyleHighlight.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		// data
		for (int rowY = 0; rowY < AllRegisters.time.size(); rowY++) {
			if (rowY % 10000 == 0) {
				System.out.println(rowY + " /  " + AllRegisters.time.size());
			}
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
}

class RandomString {
	private static final char[] symbols = new char[36];
	static {
		for (int idx = 0; idx < 10; ++idx)
			symbols[idx] = (char) ('0' + idx);
		for (int idx = 10; idx < 36; ++idx)
			symbols[idx] = (char) ('a' + idx - 10);
	}

	private final Random random = new Random();
	private final char[] buf;

	public RandomString(int length) {
		if (length < 1)
			throw new IllegalArgumentException("length < 1: " + length);
		buf = new char[length];
	}

	public String nextString() {
		for (int idx = 0; idx < buf.length; ++idx)
			buf[idx] = symbols[random.nextInt(symbols.length)];
		return new String(buf);
	}

}
