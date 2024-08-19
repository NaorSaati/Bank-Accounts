import java.util.Iterator;

public class BankAccountFiltering {
    public static List<BankAccount> getAllValidAccounts(Iterable<BankAccount> accounts, 
                                                        int requiredBalance, 
                                                        int minAccountNumber, 
                                                        int maxAccountNumber) {
        // Task 5f
    	Filter<BankAccount> filter1 = new FilterByBalance(requiredBalance);
    	Filter<BankAccount> filter2 = new FilterByAccountNumber(minAccountNumber, maxAccountNumber);
    	List<Filter<BankAccount>> filterList = new DynamicArray();
    	filterList.add(filter1);
    	filterList.add(filter2);
    	List<BankAccount> ans = new DynamicArray();
    	FilterIterator<BankAccount> fi = new FilterIterator( accounts, filterList);
    	while(fi.hasNext()) {
    		ans.add(fi.next());
    	}
    	
    	return ans;
    }
}
