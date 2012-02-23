package com.peterbochs.sourceleveldebugger;

import java.io.File;

public class DwarfLine implements Comparable<DwarfLine> {
	public File file;
	public int lineNo;
	public long pc;
	public String archiveMember;

	public DwarfLine() {
	}

	public DwarfLine(long pc) {
		this.pc = pc;
	}

	@Override
	public int compareTo(DwarfLine o) {
		return o.pc > pc ? -1 : 1;
	}
}
