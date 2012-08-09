package com.peterbochs.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.peterbochs.PeterBochsCommonLib;

public class TestGetLatestVersionInfo {

	public static void main(String[] args) {
		HashMap<String, String> map = PeterBochsCommonLib.checkLatestVersion();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			System.out.println(pairs.getKey() + " = " + pairs.getValue());
		}
	}

}
