/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2020 
---------------------------------------*/
import java.util.Comparator;
import java.util.Iterator;

public class BankAccountsBinarySearchTree extends BinarySearchTree<BankAccount>{

	public BankAccountsBinarySearchTree(Comparator<BankAccount> myComparator) {
		super(myComparator);
	}
	
	    // Complete the following methods
	    public void balance(){
	    	List list = new DynamicArray<BankAccount>();
	    	Iterator<BankAccount> iter = this.iterator();
	    	Iterator<BankAccount> iter2 = this.iterator();
	    	while (iter.hasNext()) {
	    		list.add(iter.next());
	    	}
	    	while (iter2.hasNext()) {
	    		this.remove(iter2.next());
	    	}
	    	buildBalancedTree(list , 0, list.size()-1);
	    }
	    
	    private void buildBalancedTree(List<BankAccount> list, int low, int high) {
	    	int middle = (high+low)/2;
	        if (low==high) {
	        	this.insert(list.get(middle));
	        }
	        if (low < high) {
	        	this.insert(list.get(middle));
	        	buildBalancedTree(list, middle +1, high);
		        buildBalancedTree(list, low, middle -1);
	        }
	    }
}
