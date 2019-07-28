package com.test.xmljava.xml2string2xml;

import java.io.File;
import java.io.StringReader;
import java.util.Properties;
import java.util.Random;

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

public class StringToXml 
{
	
	public  static void main(String argv[])
	{
	try
	{
		
		String xmlToString="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"<note><to> Tove</to><from>Jani</from>"+"<heading>Reminder</heading><body>Don't forget me this weekend!</body></note>";
		System.out.println("The received string is "+xmlToString);
		Random rand = new Random();
		String xmlFileName=rand.nextInt()+".xml";
		if( xmlToString!=null)
		{
			DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docbuilder;

			docbuilder = docfactory.newDocumentBuilder();
			Document stringDocument = docbuilder.parse( new InputSource(new StringReader(xmlToString)));
			TransformerFactory tranFactory = TransformerFactory.newInstance();
			Transformer transformer = tranFactory.newTransformer();

			//Uncomment this if you need to remove the line -
			//&lt; ?xml version="1.0" encoding="UTF-8" standalone="no"?&gt;

			//transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

			//Uncomment this is you want to remove - standalone="no"
			//stringDocument.setXmlStandalone(true);

			Source source = new DOMSource(stringDocument);
			if(!new File(System.getProperty("user.dir")+"\\InputXml").exists())
				new File(System.getProperty("user.dir")+"\\InputXml").mkdirs();
			
			Result destination = new StreamResult( new File(System.getProperty("user.dir")+"/InputXml"+"/"+xmlFileName));
			//Result copydestination = new StreamResult( new File(System.getProperty("user.dir")+"/InputXml"+"/newOrderFile.xml"));

			transformer.transform( source, destination );
			//transformer.transform( source, copydestination );

		}
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	
}
}