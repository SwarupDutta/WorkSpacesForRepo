package com.test.xmljava.xml2string2xml;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XmlToString 
{
	public static String result="";
	public static void main(String argv[])
	{
		try
		{
		
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        Document doc = builder.parse("../Mytest/InputXml/1073917452.xml");
	        StringWriter stringWriter = new StringWriter(); 
	        Transformer transformer = TransformerFactory.newInstance().newTransformer(); 
	        transformer.transform(new DOMSource(doc), new StreamResult(stringWriter)); 
	        String strFileContent = stringWriter.toString(); //This is string data of xml file
	        System.out.println("The fil content is "+strFileContent);
	    }
		catch(Exception e)
		{
			System.out.println("Error in creating response xml");
			e.printStackTrace();
		}
		

	}
	
}
