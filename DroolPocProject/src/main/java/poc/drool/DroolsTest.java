package poc.drool;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import poc.drool.models.Customer;


/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
            KnowledgeBase kbase = readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
            // go !
            Customer customer=new Customer();
            customer.setSeniority(6);
            ksession.insert(customer);
            ksession.fireAllRules();
            System.out.println(customer);

            logger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("rules/discount.drl"), ResourceType.DRL);
        
        KnowledgeBase kbase =kbuilder.newKnowledgeBase();
        
      /*  KnowledgeBuilderErrors errors = kbuilder.getErrors();
       
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());*/
        
        
        return kbase;
    }

    

}
//http://drools-moved.46999.n3.nabble.com/Getting-java-lang-NoSuchMethodError-org-drools-util-CompositeClassLoader-clone-Lorg-drools-util-Compe-td4019045.html