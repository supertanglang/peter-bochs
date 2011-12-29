package peter.architecture;

import java.util.LinkedHashMap;

import com.petersoft.CommonLib;

public class DescriptorParser {
	public static LinkedHashMap<String, String> parseDescriptor(long value) {
		LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>();
		int b[] = CommonLib.getBytes(value);
		long bit[] = new long[64];
		for (int x = 0; x < 64; x++) {
			bit[x] = CommonLib.getBit(value, x);
		}

		if (bit[44] == 1 && bit[43] == 1) {
			hm.put("Type", "Code");

			long base = CommonLib.getLong(b[2], b[3], b[4], b[7], 0, 0, 0, 0);
			hm.put("Base", "0x" + Long.toHexString(base));

			long limit = CommonLib.getLong(b[0], b[1], b[6] & 0xf, 0, 0, 0, 0, 0);
			if (bit[55] == 1) {
				limit *= 4096;
			}
			hm.put("Limit", "0x" + Long.toHexString(limit));

			hm.put("G", String.valueOf(bit[55]));
			hm.put("D/B", String.valueOf(bit[54]));
			hm.put("AVL", String.valueOf(bit[52]));
			hm.put("P", String.valueOf(bit[47]));
			hm.put("DPL", String.valueOf(bit[45] + bit[46] << 1));
			hm.put("S", String.valueOf(bit[44]));
			hm.put("X", String.valueOf(bit[43]));
			hm.put("C/E", String.valueOf(bit[42]));
			hm.put("R/W", String.valueOf(bit[41]));
			hm.put("A", String.valueOf(bit[40]));
		} else if (bit[44] == 1 && bit[43] == 0) {
			hm.put("Type", "Data");

			long base = CommonLib.getLong(b[2], b[3], b[4], b[7], 0, 0, 0, 0);
			hm.put("Base", "0x" + Long.toHexString(base));

			long limit = CommonLib.getLong(b[0], b[1], b[6] & 0xf, 0, 0, 0, 0, 0);
			if (bit[55] == 1) {
				limit *= 4096;
			}
			hm.put("Limit", "0x" + Long.toHexString(limit));

			hm.put("G", String.valueOf(bit[55]));
			hm.put("D/B", String.valueOf(bit[54]));
			hm.put("AVL", String.valueOf(bit[52]));
			hm.put("P", String.valueOf(bit[47]));
			hm.put("DPL", String.valueOf(bit[45] + bit[46] << 1));
			hm.put("S", String.valueOf(bit[44]));
			hm.put("X", String.valueOf(bit[43]));
			hm.put("C/E", String.valueOf(bit[42]));
			hm.put("R/W", String.valueOf(bit[41]));
			hm.put("A", String.valueOf(bit[40]));
		} else {
			hm.put("Type", "Unknown" + "");
		}
		hm.put("Value", "0x" + Long.toHexString(value));
		return hm;
	}
}
