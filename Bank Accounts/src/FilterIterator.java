import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.LinkedList;

public class FilterIterator<T> implements Iterator<T> {
	Iterator<T> iterator;
	Iterable<Filter<T>> filters;
	T next;
	boolean start; //did we started the scan?
	
	
	public FilterIterator(Iterable<T> elements, Iterable<Filter<T>> filters) {
	    // Task 5e
		this.iterator = elements.iterator();
		this.filters = filters;
		start = false;
	}
	
	@Override
	public boolean hasNext() { 
		//לפונקציה 2 תפקידים. האחד להחזיר אם קיים איבר שעונה על כל הפילטרים.
		// השני הוא לשים את האיבר הזה בנקסט. אם אין כזה ישים נאל בנקסט
	    // Task 5e
		start = true;   //נועד להבדיל בין נאל של ההתחלה לנאל של הסוף
		while(iterator.hasNext()) {
			next = iterator.next();
			boolean isLegall = true;
		    Iterator<Filter<T>> iterA = filters.iterator();
		    while (iterA.hasNext() & isLegall) {
		    	Filter<T> fil = iterA.next();
		    	if (!fil.accept(next))
		    		isLegall = false;
		    }
		    if (isLegall)
		    	return true;	
		}
		next = null;  //אם הגענו לכאן - אין עוד איברים
		return false;
	}

	@Override
	public T next() {
	    // Task 5e
		if (next == null & start) { // זה מוודא שעברנו על כל האיברים
			throw new NoSuchElementException("null");
		}
		if (next == null)  // מטפל במצב שבו מישהו קרא לנקסט לפני האז נקסט.
			hasNext();
		return next;
	}
}
