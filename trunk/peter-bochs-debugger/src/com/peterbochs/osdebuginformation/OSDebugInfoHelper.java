package com.peterbochs.osdebuginformation;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/*
 * Please read/write the os debug information using this class,
 * If you want to extends the functions, please add your functions here, thanks
 */
public class OSDebugInfoHelper {
	static Vector<OSDebugInfo> list = new Vector<OSDebugInfo>();
	public static JOSDebugInformationPanel jOSDebugInformationPanel;

	public Vector<OSDebugInfo> getList() {
		return list;
	}

	public static void addData(String magicByte, long size, String xml) {
		OSDebugInfo info = new OSDebugInfo();
		info.setDate(new Date());
		info.setMagicByte(magicByte);
		info.setSize(size);

		xml = xml.trim();
		info.setXml(xml);

		// parse xml
		jOSDebugInformationPanel.getOsInfoTableModel().getData().clear();
		jOSDebugInformationPanel.getOsInfoTableModel().addRow("OS name", getXPath(xml, "//xml/os/name/text()"));
		jOSDebugInformationPanel.getOsInfoTableModel().addRow("uptime", getXPath(xml, "//xml/os/uptime/text()"));
		jOSDebugInformationPanel.getOsInfoTableModel().addRow("notes", getXPath(xml, "//xml/os/notes/text()"));

		jOSDebugInformationPanel.getKernelInfoTableModel().getData().clear();
		jOSDebugInformationPanel.getKernelInfoTableModel().addRow("name", getXPath(xml, "//xml/kernel/name/text()"));
		jOSDebugInformationPanel.getKernelInfoTableModel().addRow("version", getXPath(xml, "//xml/kernel/version/text()"));
		jOSDebugInformationPanel.getKernelInfoTableModel().addRow("address", getXPath(xml, "//xml/kernel/address/text()"));

		// modules
		jOSDebugInformationPanel.getKernelModuleInfoTableModel().getData().clear();
		NodeList subList = OSDebugInfoHelper.getXPathNodeList(xml, "//xml/kernel/modules/module");
		for (int x = 0; x < subList.getLength(); x++) {
			String name = OSDebugInfoHelper.getXPath(xml, "//xml/kernel/modules/module[" + (x + 1) + "]/name/text()");
			String address = OSDebugInfoHelper.getXPath(xml, "//xml/kernel/modules/module[" + (x + 1) + "]/address/text()");
			jOSDebugInformationPanel.getKernelModuleInfoTableModel().addRow(name, address);
		}

		// interrupts
		jOSDebugInformationPanel.getKernelInterruptInfoTableModel().getData().clear();
		subList = OSDebugInfoHelper.getXPathNodeList(xml, "//xml/kernel/interrupts/interrupt");
		for (int x = 0; x < subList.getLength(); x++) {
			String no = OSDebugInfoHelper.getXPath(xml, "//xml/kernel/interrupts/interrupt[" + (x + 1) + "]/no/text()");
			String address = OSDebugInfoHelper.getXPath(xml, "//xml/kernel/interrupts/interrupt[" + (x + 1) + "]/address/text()");
			String tssNo = OSDebugInfoHelper.getXPath(xml, "//xml/kernel/interrupts/interrupt[" + (x + 1) + "]/tssNo/text()");
			jOSDebugInformationPanel.getKernelInterruptInfoTableModel().addRow(no, address, tssNo);
		}

		// memory allocator
		jOSDebugInformationPanel.getKernelMemoryAllocatorTableModel().getData().clear();
		subList = OSDebugInfoHelper.getXPathNodeList(xml, "//xml/kernel/memoryAllocator/region");
		for (int x = 0; x < subList.getLength(); x++) {
			String address = OSDebugInfoHelper.getXPath(xml, "//xml/kernel/memoryAllocator/region[" + (x + 1) + "]/address/text()");
			String length = OSDebugInfoHelper.getXPath(xml, "//xml/kernel/memoryAllocator/region[" + (x + 1) + "]/length/text()");
			jOSDebugInformationPanel.getKernelMemoryAllocatorTableModel().addRow("region", "address=" + address + ", length=" + length);
		}
		subList = OSDebugInfoHelper.getXPathNodeList(xml, "//xml/kernel/memoryAllocator/allocatedRegion/region");
		for (int x = 0; x < subList.getLength(); x++) {
			String address = OSDebugInfoHelper.getXPath(xml, "//xml/kernel/memoryAllocator/allocatedRegion/region[" + (x + 1) + "]/address/text()");
			String length = OSDebugInfoHelper.getXPath(xml, "//xml/kernel/memoryAllocator/allocatedRegion/region[" + (x + 1) + "]/length/text()");
			String virtualAddress = OSDebugInfoHelper.getXPath(xml, "//xml/kernel/memoryAllocator/allocatedRegion/region[" + (x + 1) + "]/virtualAddress/text()");
			String process = OSDebugInfoHelper.getXPath(xml, "//xml/kernel/memoryAllocator/allocatedRegion/region[" + (x + 1) + "]/process/text()");
			jOSDebugInformationPanel.getKernelMemoryAllocatorTableModel().addRow("allocated region",
					"address=" + address + ", length=" + length + ", virtual address=" + virtualAddress + ", process=" + process);
		}

		// library
		jOSDebugInformationPanel.getOsInfoLibraryTableModel().getData().clear();
		subList = OSDebugInfoHelper.getXPathNodeList(xml, "//xml/libraries/library");
		for (int x = 0; x < subList.getLength(); x++) {
			String name = OSDebugInfoHelper.getXPath(xml, "//xml/libraries/library[" + (x + 1) + "]/name/text()");
			String status = OSDebugInfoHelper.getXPath(xml, "//xml/libraries/library[" + (x + 1) + "]/status/text()");
			jOSDebugInformationPanel.getOsInfoLibraryTableModel().addRow(name, status);
		}

		// process
		jOSDebugInformationPanel.getOsInfoProcessTableModel().getData().clear();
		subList = OSDebugInfoHelper.getXPathNodeList(xml, "//xml/processes/process");
		for (int x = 0; x < subList.getLength(); x++) {
			String PID = OSDebugInfoHelper.getXPath(xml, "//xml/processes/process[" + (x + 1) + "]/PID/text()");
			String name = OSDebugInfoHelper.getXPath(xml, "//xml/processes/process[" + (x + 1) + "]/name/text()");
			String tssNo = OSDebugInfoHelper.getXPath(xml, "//xml/processes/process[" + (x + 1) + "]/tssNo/text()");
			String backlink = OSDebugInfoHelper.getXPath(xml, "//xml/processes/process[" + (x + 1) + "]/backlink/text()");
			String status = OSDebugInfoHelper.getXPath(xml, "//xml/processes/process[" + (x + 1) + "]/status/text()");
			String cmdline = OSDebugInfoHelper.getXPath(xml, "//xml/processes/process[" + (x + 1) + "]/cmdline/text()");
			jOSDebugInformationPanel.getOsInfoProcessTableModel().addRow(PID, name, tssNo, backlink, status, cmdline);
		}
		// end parse xml
		list.add(info);
	}

	public static String getXPath(String xml, String xpathStr) {
		String str = null;
		ByteArrayInputStream is;
		if (xml.toLowerCase().startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")) {
			is = new ByteArrayInputStream(xml.getBytes());
		} else {
			is = new ByteArrayInputStream(("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xml).getBytes());
		}
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(is);
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr = xpath.compile(xpathStr);
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			if (nodes.getLength() > 0) {
				str = nodes.item(0).getNodeValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public static NodeList getXPathNodeList(String xml, String xpathStr) {
		String str = null;
		ByteArrayInputStream is;
		if (xml.toLowerCase().startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")) {
			is = new ByteArrayInputStream(xml.getBytes());
		} else {
			is = new ByteArrayInputStream(("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xml).getBytes());
		}
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(is);
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr = xpath.compile(xpathStr);
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			return (NodeList) result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
