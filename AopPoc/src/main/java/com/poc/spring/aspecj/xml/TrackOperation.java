package com.poc.spring.aspecj.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;  

  
public class TrackOperation{  
	 public void myBeforeAdvice(JoinPoint jp)//it is advice  
	    {  
	        System.out.println("Additional concern "+new Object() {}.getClass().getEnclosingMethod().getName());  
	        //System.out.println("Method Signature: "  + jp.getSignature());  
	    }  
	 public void myAfterAdvice(JoinPoint jp)//it is advice  
	    {  
	        System.out.println("Additional concern "+new Object() {}.getClass().getEnclosingMethod().getName());  
	        //System.out.println("Method Signature: "  + jp.getSignature());  
	    } 
	 
	 public Object myAroundAdvice(ProceedingJoinPoint pjp) throws Throwable   
	    {  
	        System.out.println("Additional Concern Before calling actual method");  
	        Object obj=pjp.proceed();  
	        System.out.println("Additional Concern After calling actual method");  
	        return obj;  
	    }  
	 
	 public void myAfterReturningAdvice(JoinPoint jp,Object result) throws Throwable   
	    {
		 
		 	System.out.println("additional concern");  
	        System.out.println("Method Signature: "  + jp.getSignature());  
	        System.out.println("Result in advice: "+result);  
	        System.out.println("end of after returning advice...");  
		 
	    } 
	 public void myAfterThrowingAdvice(JoinPoint jp,Throwable error) throws Throwable   
	    {System.out.println("additional concern");  
        System.out.println("Method Signature: "  + jp.getSignature());  
        System.out.println("Exception is: "+error);  
        System.out.println("end of after throwing advice...");  } 
}  
