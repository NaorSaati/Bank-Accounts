/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2020 
---------------------------------------*/
import java.util.Comparator;

public class AccountComparatorByNumber implements Comparator<BankAccount>{

	@Override
	//Complete the following method
	public int compare(BankAccount account1, BankAccount account2) {
	    if (account1.getAccountNumber() == account2.getAccountNumber())
	    	return 0;
	    else if (account1.getAccountNumber() < account2.getAccountNumber())
	    	return -1;
	    return 1;
	    
	}

}
