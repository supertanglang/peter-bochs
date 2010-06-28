package peter.instrument;

import java.util.HashSet;

public class Data {
	final static int totalSize = 4 * 1024 * 1024;
	final static int mbPerRow = 100 * 1024;
	final static int blockSize = 1024;
	final static int blockPerRow = mbPerRow / blockSize;
	final static int totalColumn = blockPerRow;
	final static int totalRow = totalSize / mbPerRow;

	private static int[] data = new int[totalColumn * totalRow];

	public static int[] getData() {
		return data;
	}

	public static synchronized void increaseMemoryReadCount(long address) {
		if (address / blockSize < data.length) {
			data[(int) (address / blockSize)]++;
		}
	}

	public static synchronized Integer getMemoryReadCount(long address) {
		if (address / blockSize < data.length) {
			return data[(int) (address / blockSize)];
		} else {
			return 0;
		}
	}

}
