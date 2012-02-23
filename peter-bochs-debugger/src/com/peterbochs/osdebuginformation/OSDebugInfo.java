package com.peterbochs.osdebuginformation;

import java.util.Date;

public class OSDebugInfo {
	String magicByte;
	long size;
	String xml;
	Date date;

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getMagicByte() {
		return magicByte;
	}

	public void setMagicByte(String magicByte) {
		this.magicByte = magicByte;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
