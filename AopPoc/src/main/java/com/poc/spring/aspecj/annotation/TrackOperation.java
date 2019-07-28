package com.poc.spring.aspecj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;  

@Aspect  
public class TrackOperation{  
    @Pointcut("execution(* Operation.*(..))")  
    public void k(){}//pointcut name  
    
    @Pointcut("execution(* Operation.*(..))")  
    public void abcPointcut(){}  
    
    
   // @Pointcut("execution(* Operation.m*(..))")  


	 //Before
  /*  @Before("k()")
    public void myBeforeAdvice(JoinPoint jp)//it is advice  
	    {  
	        System.out.println("additional concern");  
	        //System.out.println("Method Signature: "  + jp.getSignature());  
	    } */
    //After
    
    /*@After("k()")
	 public void myAfterAdvice(JoinPoint jp)//it is advice  
	    {  
	        System.out.println("additional concern");  
	        //System.out.println("Method Signature: "  + jp.getSignature());  
	    } */
    //Around
    /*@Around("abcPointcut()")  

	 public Object myAroundAdvice(ProceedingJoinPoint pjp) throws Throwable   
	    {  
	        System.out.println("Additional Concern Before calling actual method");  
	        Object obj=pjp.proceed();  
	        System.out.println("Additional Concern After calling actual method");  
	        return obj;  
	    }  */
    //After returning
    
	/* @AfterReturning(  
	            pointcut = "execution(* Operation.*(..))",  
	            returning= "result") 
	 public void myAfterReturningAdvice(JoinPoint jp,Object result) throws Throwable   
	    {
		 
		 	System.out.println("additional concern");  
	        System.out.println("Method Signature: "  + jp.getSignature());  
	        System.out.println("Result in advice: "+result);  
	        System.out.println("end of after returning advice...");  
		 
	    }*/ 
    //After Throwing
    
	 @AfterThrowing(  
             pointcut = "execution(* Operation.*(..))",  
             throwing= "error")  
	 public void myAfterThrowingAdvice(JoinPoint jp,Throwable error) throws Throwable   
	    {System.out.println("additional concern");  
        System.out.println("Method Signature: "  + jp.getSignature());  
        System.out.println("Exception is: "+error);  
        System.out.println("end of after throwing advice...");  } 
}  
