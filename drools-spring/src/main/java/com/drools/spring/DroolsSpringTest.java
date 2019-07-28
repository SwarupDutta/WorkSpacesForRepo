package com.drools.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javainuse.model.Product;
import com.javainuse.service.ProductServiceImpl;

public class DroolsSpringTest {

	public static void main(String args[]) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductServiceImpl bean = ((ProductServiceImpl) applicationContext
				.getBean("ProductServiceImpl"));

		Product product = new Product();
		product.setType("gold");

		bean.CalculateDiscount(product);

		showDiscount(product);
	}

	private static void showDiscount(Product product) {
		System.out.println("The discount is " + product.getDiscount());
	}
}