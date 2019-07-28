package poc.apache.chain.filters;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;

public class SellVehicleExceptionHandler implements Filter {

	public boolean execute(Context context) throws Exception {
		System.out.println("Filter.execute() called.");
		return false;
	}

	public boolean postprocess(Context context,  Exception exception) {
		if (exception == null) 
		{
			System.out.println("Heey"+context.getClass());
			return false;
		}
		System.out.println("Exception "
                              + exception.getMessage()
                              + " occurred.");
		return true;
	}
}