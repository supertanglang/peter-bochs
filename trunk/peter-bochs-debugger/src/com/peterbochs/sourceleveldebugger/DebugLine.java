package com.peterbochs.sourceleveldebugger;

import java.io.File;

public class DebugLine implements Comparable<DebugLine> {
	public File file;
	public int lineNo;
	public long pc;
	public String archiveMember;

	public DebugLine() {
	}

	public DebugLine(long pc) {
		this.pc = pc;
	}

	@Override
	public int compareTo(DebugLine o) {
		return o.pc > pc ? -1 : 1;
	}
}
