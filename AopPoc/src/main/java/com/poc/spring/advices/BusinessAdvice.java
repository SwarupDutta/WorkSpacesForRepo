package com.poc.spring.advices;
 
import java.util.Arrays;
 
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
 
public class BusinessAdvice implements MethodInterceptor {
     
    //@Override
    public Object invoke(MethodInvocation method) throws Throwable {
    	
    	System.out.println("Pre part ofinvoke method of advice   "+new Object() {}.getClass().getName() +"  for method "+method.getMethod().getName()+ " with arguments "+Arrays.toString(method.getArguments()));
  
        method.proceed();
        
    	System.out.println("Post part invoke method of advice   "+new Object() {}.getClass().getName() +" for method "+method.getMethod().getName()+ " with arguments "+Arrays.toString(method.getArguments()));
  
        return null;
    }
}