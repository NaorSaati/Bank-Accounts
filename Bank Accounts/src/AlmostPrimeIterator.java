import java.util.Iterator;

public class AlmostPrimeIterator implements Iterator<Integer> {
	
	private DynamicArray<Integer> array;
	private int c;
	
	
    public static void main (String[] args) {
    	AlmostPrimeIterator x = new AlmostPrimeIterator(6);
    	System.out.println(x.next());
    	System.out.println(x.next());
    	System.out.println(x.next());
    	System.out.println(x.next());
    }
	//Complete the following method
    public AlmostPrimeIterator(int start){
    	this.c = start-1;
    }

	//Complete the following method
    public boolean hasNext(){
    	return true;
    }

	//Complete the following method
    public Integer next(){
    	c++;
    	while (!isAP(this.c)) {
    		c = this.c +1;
    		}
    	return c;
    	
    }
    
    

    
    
    public static boolean isAP(int ap) {
    	// AlmostPrime
    	int counter = 0;
    	int i = 2;
    	boolean isAP = true;
    	while (isAP & counter <=2 & i<ap) {
    		if (isPrime(i)) {
    			if (ap%i == 0) {
        			counter = counter + 1;
        			if ((ap/i)%i == 0)
        				isAP = false;
        		}
        		if(counter == 3)
        			isAP = false;
    		}
    		i = i+1;
    	}
     	return isAP & counter!=0;
    }
    
    
    public static boolean isPrime(int p) {
    	boolean isPrime = true;
    	for (int i = 2; i*i <= p & isPrime; i++)
    		if (p%i == 0)
    			isPrime = false;
    	return isPrime;
    }
    
}
