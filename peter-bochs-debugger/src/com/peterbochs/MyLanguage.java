package com.peterbochs;

public class MyLanguage {
	public static String getString(String str) {
		try {
			return PeterBochsDebugger.language.getString(str);
		} catch (Exception ex) {
			return str;
		}
	}
}
