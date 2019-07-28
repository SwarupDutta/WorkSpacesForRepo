package com.poc.spring.mains;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.poc.spring.services.BusinessServiceImpl;
import com.poc.spring.services.BusinessService;
 

public class Main {
    public static void main(String args[]) {
    	
    	
    	
        ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-Business.xml");
        BusinessService businessService = (BusinessService)appContext.getBean("businessService");

        businessService.doSomeThing();
        businessService.doBajeThing();

    }
}