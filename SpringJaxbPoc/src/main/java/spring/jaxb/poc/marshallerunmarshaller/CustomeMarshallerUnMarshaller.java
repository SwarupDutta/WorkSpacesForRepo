package spring.jaxb.poc.marshallerunmarshaller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.transform.stream.StreamResult;

import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import javax.xml.transform.stream.StreamSource;

public class CustomeMarshallerUnMarshaller {
	
	Jaxb2Marshaller oJaxb2Marshaller;

	public Jaxb2Marshaller getoJaxb2Marshaller() {
		return oJaxb2Marshaller;
	}

	public void setoJaxb2Marshaller(Jaxb2Marshaller oJaxb2Marshaller) {
		this.oJaxb2Marshaller = oJaxb2Marshaller;
	}
	
	public void customMarshal(Object domainObject) throws XmlMappingException, FileNotFoundException//object to xml
	{
		getoJaxb2Marshaller().marshal(domainObject, new StreamResult(new FileOutputStream("Domain.xml")));
	}
	public Object customUnMarshal() throws XmlMappingException, FileNotFoundException
	{
		return getoJaxb2Marshaller().unmarshal(new StreamSource(new FileInputStream("../SpringJaxbPoc/Domain.xml")));//xml to object
		
	}

}
