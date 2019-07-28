package poc.drool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.drools.RuleBase;
import org.drools.agent.RuleAgent;

import poc.drool.models.Message;

public class RuleEngine {
	
	
	
	
	
    
    
	public void executeRule() throws IOException
    {
	    FileInputStream inStream=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/test.properties");

    	Properties properties=new Properties();
    	properties.load(inStream);inStream.close();

    //	RuleAgent agent=RuleAgent.newRuleAgent("/test.properties");
    	RuleAgent agent=RuleAgent.newRuleAgent(properties);

        RuleBase rules=agent.getRuleBase();
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        
        
        Message message1 = new Message();
        message1.setMessage("Hello World1");
        message1.setStatus(Message.GOODBYE);
        
        List<Message> messagelist=new ArrayList<Message>();
        messagelist.add(message);
        messagelist.add(message1);
        
        Map<String,List<Message>> oMap=new HashMap<String,List<Message>>();
        
        oMap.put("all", messagelist);
        System.out.println(oMap);
        rules.newStatelessSession().execute(oMap);
        System.out.println(oMap);
    }
    public static void main(String ...argv) throws IOException
    {
    	new RuleEngine().executeRule();
    }
    
    
}
