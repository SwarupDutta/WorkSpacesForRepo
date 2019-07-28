package poc.apache.chain.starters;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;

import poc.apache.chain.commands.SellVehicleChain;

public class ChainRunner {
	public static void main(String[] args) throws Exception {
		Command process = new SellVehicleChain();
		Context ctx = new ContextBase();
		process.execute(ctx);
	}
}
