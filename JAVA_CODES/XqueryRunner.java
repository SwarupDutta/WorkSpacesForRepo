package com.test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.CharBuffer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xquery.*;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import net.sf.saxon.xqj.SaxonXQDataSource;

public class XqueryRunner
	{
	public static void main(String[] args) throws XQException, TransformerException, SAXException, IOException, ParserConfigurationException {
		XQDataSource xqds = new SaxonXQDataSource();
		XQConnection conn = xqds.getConnection();
		XQExpression expr = conn.createExpression();
	    BufferedReader reader = new BufferedReader( new FileReader ("books1.xq"));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String ls = System.getProperty("line.separator");

	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }
	        
		XQResultSequence result = expr.executeQuery(new String(stringBuilder));
		while (result.next()) { 
		    String str  = result.getSequenceAsString(null);
		    System.out.println(str);
		}
		result.close();
		expr.close();
		conn.close();
	}
	}

