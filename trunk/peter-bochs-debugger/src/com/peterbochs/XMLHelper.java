package com.peterbochs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XMLHelper {
	public static void main(String[] args) {

		// createEmptyXML("history.xml");
		// createXML("history.xml", "history", "3", "2");
		// writeXMLNode("history.xml", "/", new Date(), "peter1");

		// test hashmap
		// HashMap hashmap = new HashMap();
		// hashmap.put("name", "peter cheung");
		// hashmap.put("mobile", "999");
		// hashmap.put("name", "david lee");
		// hashmap.put("mobile", "123");
		// hashMapToXML("history.xml", "history", hashmap);
		//
		// HashMap toHashmap = new HashMap();
		// toHashmap = xmltoHashMap("history.xml", "/history");
		// Set set = toHashmap.entrySet();
		// Iterator i = set.iterator();
		//
		// while (i.hasNext()) {
		// Map.Entry me = (Map.Entry) i.next();
		// System.out
		// .println("toHashmap : " + me.getKey() + "=" + me.getValue());
		// }
		// end test hashmap

		Vector vector = readXMLNode222("history.xml", "/history/good");
		for (int x = 0; x < vector.size(); x++) {
			System.out.println("read : " + vector.get(x));
		}

		// test vector
		Vector<HashMap> vector2 = xmltoVector222("history.xml", "/history/good");
		for (int x = 0; x < vector2.size(); x++) {
			HashMap toHashmap = vector2.get(x);
			Set set = toHashmap.entrySet();
			Iterator i = set.iterator();

			while (i.hasNext()) {
				Map.Entry me = (Map.Entry) i.next();
				System.out.println("toHashmap : " + me.getKey() + "=" + me.getValue());
			}
		}

		HashMap hashmap2 = new HashMap();
		hashmap2.put("name", "peter cheung");
		hashmap2.put("mobile", "999");
		vector2.add(hashmap2);
		hashmap2 = new HashMap();
		hashmap2.put("name", "david chow");
		hashmap2.put("mobile", "123");
		vector2.add(hashmap2);
		vectorToXML222("history.xml", "history", "good", vector2);
		vectorToXML222("history.xml", "history", "good2", vector2);
		// end test vector

		readXMLNode222("history.xml", "/history/mobile");
	}

	public static HashMap xmltoHashMap222(String xmlFile, String xpath) {
		try {
			XPathFactory factory = XPathFactory.newInstance();
			XPath xPath = factory.newXPath();
			// XPathExpression xPathExpression =
			// xPath.compile("/history");
			File xmlDocument = new File(xmlFile);
			InputSource inputSource = new InputSource(new FileInputStream(xmlDocument));
			// String root = xPath.evaluate("/", inputSource);
			NodeList nodes = (NodeList) xPath.evaluate(xpath, inputSource, XPathConstants.NODESET);
			HashMap hashmap = new HashMap();
			for (int x = 0; x < nodes.getLength(); x++) {
				hashmap.put(nodes.item(x).getNodeName(), nodes.item(x).getTextContent());
			}
			return hashmap;
		} catch (Exception ex) {
			return null;
		}
	}

	public static Vector<HashMap> xmltoVector222(String xmlFile, String xpath) {
		try {
			if (!new File(xmlFile).exists()) {
				return new Vector<HashMap>();
			}
			File xmlDocument = new File(xmlFile);
			InputSource inputSource = new InputSource();
			return xmlToVector222(new FileInputStream(xmlDocument), xpath);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new Vector<HashMap>();
		}
	}

	public static Vector<HashMap> xmlToVector222(InputStream is, String xpath) {
		try {
			XPathFactory factory = XPathFactory.newInstance();
			XPath xPath = factory.newXPath();
			InputSource inputSource = new InputSource(is);

			NodeList nodes = (NodeList) xPath.evaluate(xpath, inputSource, XPathConstants.NODESET);
			Vector<HashMap> vector = new Vector<HashMap>();

			for (int x = 0; x < nodes.getLength(); x++) {
				NodeList nodeList = nodes.item(x).getChildNodes();
				HashMap hashmap = new HashMap();
				for (int y = 0; y < nodeList.getLength(); y++) {
					Node node = nodeList.item(y);
					if (!node.getNodeName().equals("#text")) {
						hashmap.put(node.getNodeName(), node.getTextContent());
					}
				}
				vector.add(hashmap);
			}
			return vector;
		} catch (Exception ex) {
			ex.printStackTrace();
			return new Vector();
		}
	}

	public static void hashMapToXML222(String xmlFile, String xpath, HashMap hashmap) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();

			Element rootNode = document.createElement(xpath);
			document.appendChild(rootNode);

			Set set = hashmap.entrySet();
			Iterator i = set.iterator();

			while (i.hasNext()) {
				Map.Entry me = (Map.Entry) i.next();
				Element em = document.createElement(me.getKey().toString());
				em.appendChild(document.createTextNode(me.getValue().toString()));
				rootNode.appendChild(em);
				// System.out.println("write " +
				// me.getKey().toString() + "="
				// + me.getValue().toString());
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			FileOutputStream fo = new FileOutputStream(xmlFile);
			StreamResult result = new StreamResult(fo);
			transformer.transform(source, result);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void vectorToXML222(String xmlFile, String xpath, String parentNodeName, Vector<HashMap> vector) {
		File file = new File(xmlFile);
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			Document document;
			Element rootNode;
			if (file.exists()) {
				document = documentBuilder.parse(new File(xmlFile));
				rootNode = document.getDocumentElement();
			} else {
				document = documentBuilder.newDocument();
				rootNode = document.createElement(xpath);
				document.appendChild(rootNode);
			}

			for (int x = 0; x < vector.size(); x++) {
				Element parentNode = document.createElement(parentNodeName);
				rootNode.appendChild(parentNode);
				HashMap hashmap = vector.get(x);
				Set set = hashmap.entrySet();
				Iterator i = set.iterator();

				while (i.hasNext()) {
					Map.Entry me = (Map.Entry) i.next();
					// System.out.println("key=" +
					// me.getKey().toString());
					Element em = document.createElement(me.getKey().toString());
					em.appendChild(document.createTextNode(me.getValue().toString()));
					parentNode.appendChild(em);
					// System.out.println("write " +
					// me.getKey().toString() +
					// "="
					// + me.getValue().toString());
				}
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			FileOutputStream fo = new FileOutputStream(xmlFile);
			StreamResult result = new StreamResult(fo);
			transformer.transform(source, result);
		} catch (Exception ex) {
			file.delete();
			ex.printStackTrace();
		}
	}

	public static void createEmptyXML222(String xmlFile) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			FileOutputStream fo = new FileOutputStream(xmlFile);
			StreamResult result = new StreamResult(fo);
			transformer.transform(source, result);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void createXML222(String xmlFile, String xpath, String element, String data) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			Element rootElement = document.createElement(xpath);
			document.appendChild(rootElement);
			for (int i = 1; i <= 1; i++) {
				Element em = document.createElement(element);
				em.appendChild(document.createTextNode(data));
				rootElement.appendChild(em);
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			FileOutputStream fo = new FileOutputStream(xmlFile);
			StreamResult result = new StreamResult(fo);
			transformer.transform(source, result);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Vector<String> readXMLNode222(String xmlFile, String xpath) {
		try {
			XPathFactory factory = XPathFactory.newInstance();
			XPath xPath = factory.newXPath();
			// XPathExpression xPathExpression =
			// xPath.compile("/history");
			File xmlDocument = new File(xmlFile);
			InputSource inputSource = new InputSource(new FileInputStream(xmlDocument));
			// String root = xPath.evaluate("/", inputSource);
			NodeList nodes = (NodeList) xPath.evaluate(xpath, inputSource, XPathConstants.NODESET);
			Vector<String> vector = new Vector<String>();
			for (int x = 0; x < nodes.getLength(); x++) {
				vector.add(nodes.item(x).getTextContent());
			}
			return vector;
		} catch (Exception ex) {
			ex.printStackTrace();
			return new Vector();
		}
	}
}
