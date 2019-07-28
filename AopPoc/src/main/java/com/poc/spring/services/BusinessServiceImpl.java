package com.poc.spring.services;
  
  
public class BusinessServiceImpl implements BusinessService{
    public void doSomeThing() {
        System.out.println(new Object(){}.getClass().getName()+"=>"+new Object(){}.getClass().getEnclosingMethod().getName());
    }

	public void doBajeThing() {
        System.out.println(new Object(){}.getClass().getName()+"=>"+new Object(){}.getClass().getEnclosingMethod().getName());
	}
}