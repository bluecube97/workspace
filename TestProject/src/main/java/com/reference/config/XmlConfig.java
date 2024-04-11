package com.reference.config;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XmlConfig {
	public static String getXmlDAO(String name) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder
					.parse("C:/DevTool/workspace/TestProject/src/main/java/com/reference/config/setting.xml");
			NodeList nodeList = doc.getElementsByTagName(name);

			if (nodeList != null && nodeList.getLength() > 0) {
				return nodeList.item(0).getTextContent();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void UTFUCK(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		resp.setContentType("text/html; charset=UTF-8");
	}

}
