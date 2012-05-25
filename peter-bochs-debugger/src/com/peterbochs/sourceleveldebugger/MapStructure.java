package com.peterbochs.sourceleveldebugger;

import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.TreeSet;
import java.util.Vector;

public class MapStructure {
	public static String mapFileContent;
	public static HashSet<File> archiveAndObjectFiles = new HashSet<File>();
	public static TreeSet<Function> functions = new TreeSet<Function>();
	public static Vector<Symbol> symbols = new Vector<Symbol>();
	public static Hashtable<String, Vector<DisassembledCode>> disassembledCodes = new Hashtable<String, Vector<DisassembledCode>>();
	public static Hashtable<File, Vector<DwarfLine>> dwarfLines = new Hashtable<File, Vector<DwarfLine>>();
	public static Vector<DwarfLine> allDwarfLines = new Vector<DwarfLine>();
	public static Vector<String> parsedFunctions = new Vector<String>();

	public static void updateAllDwarfLines() {
		allDwarfLines.clear();
		for (File file : dwarfLines.keySet()) {
			Vector<DwarfLine> vector = dwarfLines.get(file);
			for (DwarfLine line : vector) {
				allDwarfLines.add(line);
			}
		}
		Collections.sort(allDwarfLines);
	}

	public static Function findFunctionByFunctionName(String functionName) {
		for (Function function : functions) {
			if (function.name.equals(functionName)) {
				return function;
			}
		}
		return null;
	}

	public static Symbol findSymbolByFile(File file) {
		try {
			for (Symbol symbol : symbols) {
				if (symbol.file.getCanonicalFile().equals(file.getCanonicalFile())) {
					return symbol;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static Symbol findSymbolByFileAndSegmentName(File file, String segmentName) {
		try {
			for (Symbol symbol : symbols) {
				if (symbol.file.getCanonicalFile().equals(file.getCanonicalFile()) && symbol.segment.equals(segmentName)) {
					return symbol;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static Symbol findSymbolByFilenameOrObjectName(String name) {
		for (Symbol symbol : symbols) {
			if (symbol.functionNameOrObjectName.equals(name)) {
				return symbol;
			}
		}
		return null;
	}

	public static Symbol findSymbolByArchiveMember(String archiveMember, String segment) {
		for (Symbol symbol : symbols) {
			if (symbol.archiveMember.equals(archiveMember) && symbol.segment.equals(segment)) {
				return symbol;
			}
		}
		return null;
	}

	public static Symbol findSymbolByMemoryOffset(long memoryOffset) {
		for (Symbol symbol : symbols) {
			if (symbol.memoryOffset <= memoryOffset && memoryOffset < symbol.memoryOffset + symbol.length) {
				return symbol;
			}
		}
		return null;
	}

	public static DwarfLine findDwarfLineByAddress(long address) {
		//		for (File file : dwarfLines.keySet()) {
		//			Vector<DwarfLine> vector = dwarfLines.get(file);
		//			for (DwarfLine line : vector) {
		//				if (line.pc == address) {
		//					return line;
		//				}
		//			}
		//		}
		for (DwarfLine line : allDwarfLines) {
			if (line.pc == address) {
				return line;
			}
		}
		return null;
		//		int index = Collections.binarySearch(allDwarfLines, new DwarfLine(address));
		//		if (index < 0) {
		//			return null;
		//		} else {
		//			System.out.println("bingo");
		//			return allDwarfLines.get(index);
		//		}
	}

	public static DwarfLine findLastDwarfLineByAddress(long address) {
		DwarfLine l;
		for (File file : dwarfLines.keySet()) {
			Vector<DwarfLine> vector = dwarfLines.get(file);
			l = null;
			for (DwarfLine line : vector) {
				if (line.pc == address) {
					if (l != null && !l.archiveMember.equals(line.archiveMember)) {
						return null;
					} else {
						return l;
					}
				}

				l = line;
			}
		}
		return null;
	}
}
