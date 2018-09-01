package spring.poc.custom.freemarker;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import freemarker.template.TemplateException;

public class MainClass {

	public static void main(String[] args) throws BeansException, IOException, TemplateException {
		// TODO Auto-generated method stub
		 ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		 appContext.getBean("customFreeMarkerConfig",CustomFreeMarkerConfig.class).executeFreeMarker();;
		 
	}

}
