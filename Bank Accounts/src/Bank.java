/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2020 
---------------------------------------*/
public class Bank {

	private BankAccountsBinarySearchTree namesTree;
	private BankAccountsBinarySearchTree accountNumbersTree;
	
	public Bank() {
		namesTree = new BankAccountsBinarySearchTree(new AccountComparatorByName());
		accountNumbersTree = new BankAccountsBinarySearchTree(new AccountComparatorByNumber());
	}

	public BankAccount lookUp(String name){
		// create an Entry with the given name, a "dummy" accountNumber (1) and zero balance
		// This "dummy" accountNumber will be ignored when executing getData
		BankAccount lookFor = new BankAccount(name, 1, 0);
		return namesTree.findData(lookFor);
	}
	
	public BankAccount lookUp(int accountNumber){
		// create an Entry with a "dummy" name, zero balance and the given accountNumber
		// This "dummy" name will be ignored when executing getData
		BankAccount lookFor = new BankAccount("dummy", accountNumber,0);
		return accountNumbersTree.findData(lookFor);
	}
	
	// END OF Given code -----------------------------------
	
	//Complete the following method
	public boolean add(BankAccount newAccount) {
	    if (lookUp(newAccount.getName()) == null & lookUp(newAccount.getAccountNumber()) == null) {
	    	namesTree.insert(newAccount);
	    	accountNumbersTree.insert(newAccount);
	    	return true;
	    }
	    return false;
	}

	//Complete the following method
	public boolean delete(String name){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(name);
		// complete this:
		if (toRemove != null) {
			namesTree.remove(toRemove);
			accountNumbersTree.remove(toRemove);
			return true;
		}
		return false;
	}
	
	//Complete the following method
	public boolean delete(int accountNumber){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(accountNumber);
		// complete this:
		if (toRemove != null) {
			namesTree.remove(toRemove);
			accountNumbersTree.remove(toRemove);
			return true;
		}
		return false;
	}
	
	//Complete the following method
	public boolean depositMoney(int amount, int accountNumber){
		BankAccount account = lookUp(accountNumber);
	    if (account != null) {
	    	return account.depositMoney(amount);
	    }
	    return false;
	}

	//Complete the following method
	public boolean withdrawMoney(int amount, int accountNumber){
		BankAccount account = lookUp(accountNumber);
	    if (account != null) {
	    	if (account.withdrawMoney(amount)) {
	    		account.withdrawMoney(amount);
	    		return true;
	    	}
	    }
	    return false;
	}

    //Complete the following method
	public boolean transferMoney(int amount, int accountNumber1, int accountNumber2) {
		BankAccount account1 = lookUp(accountNumber1);
		BankAccount account2 = lookUp(accountNumber2);
		if (account1 != null & account2 != null) {
			if (account1.getBalance() >= amount) {
				account1.withdrawMoney(amount);
				return account2.depositMoney(amount);
			}
		}
		return false;		
	}
   
	//Complete the following method
    public boolean transferMoney(int amount, int accountNumber, String name) {
    	BankAccount accountNum = lookUp(accountNumber);
    	BankAccount accountStr = lookUp(name);
    	if (accountNum != null & accountStr != null) {
        	if (accountNum.getBalance() >= amount) {
        		accountNum.withdrawMoney(amount);
        		return accountStr.depositMoney(amount);
        	}
    	}

    	return false;
    }
    
}
