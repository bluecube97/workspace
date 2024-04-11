package com.reference;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XmlConfig {
	public static String getXmlDao(String name){
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();		
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("C:/DevTool/workspace/servletProject/src/main/java/com/reference/Setting.xml");
			NodeList nodeList = doc.getElementsByTagName(name);

			if(nodeList != null && nodeList.getLength()>0) {
				return nodeList.item(0).getTextContent();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}