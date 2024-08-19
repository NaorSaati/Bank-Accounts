
public class FilterByAccountNumber implements Filter<BankAccount> {
	private int minAN;
	private int maxAN;
    
    public FilterByAccountNumber(int minAccountNum, int maxAccountNum) {
        // Task 5d
    	minAN = minAccountNum;
    	maxAN = maxAccountNum;
    }

    public boolean accept(BankAccount element) {
        // Task 5d
        int AC = element.getAccountNumber();
        if ( minAN <= AC  & AC <= maxAN)
        	return true;
        return false;
    }
    
}
