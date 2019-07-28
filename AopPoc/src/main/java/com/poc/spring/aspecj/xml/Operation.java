package com.poc.spring.aspecj.xml;

public  class Operation{  
    public void msg(){System.out.println("msg method invoked");}  
    public int m(){System.out.println("m method invoked");return 2;}  
    public int k(){System.out.println("k method invoked");return 3;}  
    
    public void validate(int age)throws Exception{  
        if(age<18){  
            System.out.println("Method name is  "+new Object(){}.getClass().getEnclosingMethod().getName());

            throw new ArithmeticException("Not valid age");  
        }  
        else{ 
            System.out.println("Do Something Here  "+new Object(){}.getClass().getEnclosingMethod().getName());

            System.out.println("Thanks for vote");  
        }  
        }  
}