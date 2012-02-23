package com.peterbochs.instrument;

import java.util.HashMap;

public class Data {
	final static int minimumBlockSize = 4096;
	private static int totalSizeInBlock = 1024 * 1024; // assume minimum block

	public static ProfilingTableModel memoryProfilingZone;

	private static int[] memory = new int[totalSizeInBlock];

	public static int[] getMemory() {
		return memory;
	}

	// public static long getTotalsize() {
	// return totalSizeInBlock;
	// }

	private static long calculateNoOfBlock(long address, long endAddress, long blockSize) {
		long total = endAddress - address;
		long noOfBlock = total / blockSize;
		if (total % blockSize != 0) {
			noOfBlock++;
		}
		return noOfBlock;
	}

	public static long getColumnCount(long address, long endAddress, long blockSize) {
		long noOfBlock = calculateNoOfBlock(address, endAddress, blockSize);
		return (long) Math.ceil(Math.sqrt(noOfBlock));
	}

	public static long getRowCount(long address, long endAddress, long blockSize) {
		long noOfBlock = calculateNoOfBlock(address, endAddress, blockSize);
		return (long) Math.ceil((double) noOfBlock / getColumnCount(address, endAddress, blockSize));
	}

	public static synchronized void increaseMemoryReadCount(long address) {
		memory[(int) (address / minimumBlockSize)]++;
	}

	public static int[] getChartData(long address, long endAddress, long blockSize) {
		long noOfBlock = calculateNoOfBlock(address, endAddress, blockSize);
		int chartData[] = new int[(int) noOfBlock];

		int index = 0;
		int addressCounter = 0;
		for (long addr = address / minimumBlockSize; addr < endAddress / minimumBlockSize; addr++) {
			chartData[index] += memory[(int) addr];

			addressCounter += minimumBlockSize;
			if (addressCounter >= blockSize) {
				index++;
				addressCounter = 0;
			}
		}

		return chartData;
	}

	public static HashMap<String, Integer> getHotestAddressCount(Long address, long blockSize) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		long endBlockNumber = address / blockSize;
		long endAddress = (endBlockNumber + (blockSize / minimumBlockSize)) * blockSize;
		for (long blockNo = address / minimumBlockSize; blockNo < endAddress / minimumBlockSize; blockNo++) {
			if (blockNo * minimumBlockSize >= address && blockNo * minimumBlockSize < address + blockSize) {
				if (memory[(int) blockNo] > 0) {
					map.put("0x" + Long.toHexString(blockNo * minimumBlockSize) + "-0x" + Long.toHexString((blockNo + 1) * minimumBlockSize - 1), memory[(int) blockNo]);
				}
			}
		}
		return map;
	}
}
