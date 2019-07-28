package poc.apache.chain.starters;

import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;

import poc.apache.chain.commands.CatalogLoader;

public class CatalogRunner {
	public static void main(String[] args) throws Exception {
		CatalogLoader loader = new CatalogLoader();
		Catalog sampleCatalog = loader.getCatalog();
		Command command = sampleCatalog.getCommand("sell-vehicle");
	//	Context ctx = new SellVehicleContext();
		Context ctx = new ContextBase();
		command.execute(ctx);
		
		
	}
}
