
public class FilterByBalance implements Filter<BankAccount>{
	
	private int filterB;
	
	public FilterByBalance(int balanceThreshold) {
        // task 5c
		filterB = balanceThreshold;
	}
	
	@Override
	public boolean accept(BankAccount elem) {
		// task 5c
	    if (this.filterB <= elem.getBalance())
	    	return true;
	    return false;
	}
}
