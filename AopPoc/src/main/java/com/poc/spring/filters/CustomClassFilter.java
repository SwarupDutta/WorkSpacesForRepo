package com.poc.spring.filters;

import org.springframework.aop.ClassFilter;

public class CustomClassFilter implements ClassFilter{

	public boolean matches(Class<?> arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getClass().getName().contains("Service"));
		return !arg0.getClass().getName().contains("Service");
	}

}
