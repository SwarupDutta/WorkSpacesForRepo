package weblogicexamples;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.ejb.ActivationConfigProperty;

@MessageDriven(
		activationConfig = {
				@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") ,
				@ActivationConfigProperty(propertyName="connectionFactoryJndiName",propertyValue="jms/TestConnectionFactory"),
				@ActivationConfigProperty(propertyName="destinationJndiName", propertyValue="jms/TestJMSQueue")
		}
		,mappedName="jms/TestJMSQueue"
)

public class MyMDB implements MessageListener
{
	public void onMessage(Message message)
	{
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println("\n\n\t(mdb) MyMDB Received \n"+ textMessage.getText());
		}
		catch (JMSException e)
		{
			e.printStackTrace();
		}
	}
}
