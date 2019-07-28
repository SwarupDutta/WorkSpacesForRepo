package poc.apache.chain.commands;

import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.config.ConfigParser;
import org.apache.commons.chain.impl.CatalogFactoryBase;
import org.apache.commons.chain.impl.ContextBase;

public class CatalogLoader {
	private static final String CONFIG_FILE = "chain-config.xml";
	private ConfigParser parser;
	private Catalog catalog;
	
	public CatalogLoader() {
		parser = new ConfigParser();
	}
	public Catalog getCatalog() throws Exception {
		if (catalog == null) {
		
	parser.parse(this.getClass().getClassLoader().getResource(CONFIG_FILE));		
	
		}
		catalog = CatalogFactoryBase.getInstance().getCatalog();
		return catalog;
	}
	
}