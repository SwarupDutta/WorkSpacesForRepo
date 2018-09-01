package spring.jexl.poc.jexlengine;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JexlTest {

	public static void main(String[] args) throws IOException  {
		
		ApplicationContext appContext=new ClassPathXmlApplicationContext("appContext.xml");
		CustomJexlEngine CustomJexlEngine=appContext.getBean("customJexlEngine",CustomJexlEngine.class);
		CustomJexlEngine.evaluateExpression();
		CustomJexlEngine.executeScript();
		CustomJexlEngine.executeScriptForEach();
	}

}
//http://hmkcode.com/spring-profile-xml-configuration/