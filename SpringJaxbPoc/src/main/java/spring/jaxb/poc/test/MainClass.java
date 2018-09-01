package spring.jaxb.poc.test;

import java.io.FileNotFoundException;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.XmlMappingException;


import spring.jaxb.poc.marshallerunmarshaller.CustomeMarshallerUnMarshaller;


public class MainClass {

	public static void main(String[] args) throws XmlMappingException, FileNotFoundException {
		
		// Get the CustomeMarshallerUnMarshaller which contains reference of org.springframework.oxm.jaxb.Jaxb2Marshaller
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
       CustomeMarshallerUnMarshaller oCustomeMarshallerUnMarshaller=(CustomeMarshallerUnMarshaller) appContext.getBean("marshallerunmarshaller");
     
       // Get the instance of CollegeDepartment
        spring.jaxb.poc.domains.CollegeDepartment oCollegeDepartment=appContext.getBean("CollegeDepartment", spring.jaxb.poc.domains.CollegeDepartment.class);
        
        // Marshall it using customMarshal method which intern uses void org.springframework.oxm.jaxb.Jaxb2Marshaller.marshal(Object graph, Result result) throws XmlMappingException of org.springframework.oxm.jaxb.Jaxb2Marshaller 
        oCustomeMarshallerUnMarshaller.customMarshal(oCollegeDepartment);
        
        // Unmarshall using customUnMarshal which intern uses Object org.springframework.oxm.jaxb.Jaxb2Marshaller.unmarshal(Source source) throws XmlMappingException of org.springframework.oxm.jaxb.Jaxb2Marshaller
        Object domainObject=oCustomeMarshallerUnMarshaller.customUnMarshal();
            System.out.println(domainObject);
            domainObject=null;
        
       
          // Same for   EmployeeDepartment
         spring.jaxb.poc.domains.EmployeeDepartment oEmployeeDepartment=appContext.getBean("EmployeeDepartment", spring.jaxb.poc.domains.EmployeeDepartment.class);
         oCustomeMarshallerUnMarshaller.customMarshal(oEmployeeDepartment);
         domainObject=oCustomeMarshallerUnMarshaller.customUnMarshal();
         System.out.println(domainObject);

        
      
	}

} 
