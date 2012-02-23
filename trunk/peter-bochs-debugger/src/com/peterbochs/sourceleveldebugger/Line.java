package com.peterbochs.sourceleveldebugger;

public class Line {
	public enum CodeType {
		C, ASM
	};

	CodeType type;
	String code;
	int offset;
	int asmBytes[];
}
