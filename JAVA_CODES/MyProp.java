package dhus;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.io.StringReader;
import java.util.*;
public class MyProp {
 
	public static void main(String[] args) throws FileNotFoundException {
	      Properties prop = new Properties();
	      String s = "Height=200\nWidth=15";

	      // create a new reader
	      StringReader reader = new StringReader(s);
	      FileReader in = new FileReader("D:/test.properties");
	      BufferedReader br = new BufferedReader(in);
	      try {
	         // load from input stream
	         //prop.load(reader);
	         prop.load(br);
	         // print the properties list from System.out
	        // prop.list(System.out);

	        // System.out.println(prop.getProperty("r"));
	         Set<Object> keys = prop.keySet();
	         for(Object k:keys){
	             String key = (String)k;
	             System.out.println(key+": "+prop.getProperty(key));
	         }
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      }
	   }
}
 

