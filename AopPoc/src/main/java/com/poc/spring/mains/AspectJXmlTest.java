package com.poc.spring.mains;
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.poc.spring.aspecj.xml.Operation;



public class AspectJXmlTest{  
    public static void main(String[] args){
    	
    	  
        ApplicationContext context = new ClassPathXmlApplicationContext("aspectJXmlcontext.xml");  
        Operation e = (Operation) context.getBean("opBean");  
       /* System.out.println("calling msg...");  
        e.msg();  
        System.out.println("calling m...");  
        e.m();  
        System.out.println("calling k...");  
        e.k();  */
        System.out.println("calling validate...");  
        try{  
            e.validate(19);  
        }catch(Exception e1){System.out.println(e1);}  
        System.out.println("calling validate again...");  
          
        try{  
            e.validate(11);  
        }catch(Exception e1){System.out.println("------"+e1);}  
    
    	
    	 
    }  
     
}  