package poc.apache.chain.commands;

import org.apache.commons.chain.impl.ChainBase;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;

import poc.apache.chain.filters.SellVehicleExceptionHandler;

public class SellVehicleChain extends ChainBase {
	public SellVehicleChain() {
		super();
		addCommand(new SellVehicleExceptionHandler());
		addCommand(new GetCustomerInfo());
		addCommand(new TestDriveVehicle());
		addCommand(new NegotiateSale());
		addCommand(new ArrangeFinancing());
		addCommand(new CloseSale());
	}
	
}