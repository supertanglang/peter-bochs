package com.peterbochs.sourceleveldebugger;

import java.io.File;

public class DisassembledCode {
	public File file;
	public String cCode;
	public int offset;
	public int bytes[];
	public String asmCode;

	public String toString() {
		return file.getAbsolutePath() + "," + cCode + "," + offset + "," + asmCode;
	}
}
