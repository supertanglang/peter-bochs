package com.peterbochs.instrument;

public class MySHStub {
	public native String getSharedMemory();

	public static void main(String args[]) {
		System.loadLibrary("PeterBochs");
		MySHStub mySHStub = new MySHStub();
		while (true) {
			String s = mySHStub.getSharedMemory();
			// System.out.println("return=" + mySHStub.getSharedMemory());
		}
	}
}
