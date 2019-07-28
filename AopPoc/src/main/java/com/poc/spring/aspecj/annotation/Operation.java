package com.poc.spring.aspecj.annotation;

public  class Operation{  
    public void msg(){
    	System.out.println("msg method invoked");
        System.out.println("Do Something Here  "+new Object(){}.getClass().getEnclosingMethod().getName());

    
    }  
    public int m(){System.out.println("m method invoked");return 2;}  
    public int k(){System.out.println("k method invoked");return 3;}  
    
    public void validate(int age)throws Exception{  
        if(age<18){  
        	
            throw new ArithmeticException("Not valid age");  
        }  
        else{  
            System.out.println("Do Something Here  "+new Object(){}.getClass().getEnclosingMethod().getName());

            System.out.println("Thanks for vote");  
        }  
        }  
}