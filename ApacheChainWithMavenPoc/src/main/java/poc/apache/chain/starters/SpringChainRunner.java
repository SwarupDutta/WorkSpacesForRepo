package poc.apache.chain.starters;

import org.apache.commons.chain.impl.ChainBase;
import org.apache.commons.chain.impl.ContextBase;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringChainRunner {
	//private BeanFactory beanFactory;
	 
	public void runChain( String chainName ) {
		try {
			createChain ( chainName ).execute( new ContextBase() );
		}
		catch ( Exception exc ) {
			throw new RuntimeException(
					"Chain \"" + chainName + "\": Execution failed.", exc );
		}
	}
 
/*	public void setBeanFactory( BeanFactory beanFactory ) throws BeansException {
		this.beanFactory = beanFactory;
	}*/
 
	protected ChainBase createChain( String chainName ) {
		//return ( ChainBase ) this.beanFactory.getBean( chainName );
		
		
		return ( ChainBase ) new ClassPathXmlApplicationContext("applicationContext.xml").getBean( chainName );

	}
	
	
	public static void main(String arg[])
	{
		new SpringChainRunner().runChain("pingPongChain");
	} 
}
