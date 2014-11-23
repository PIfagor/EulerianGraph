package lib.develop;

import java.util.Iterator;


/**
 * 
 * @author Wise
 * 
 * @param <Data>
 */

public class Bag<Data> implements java.lang.Iterable<Data> {
	private Stack st;

	public Bag(Storage mode) {
		if (mode == Storage.ARRAY)
			st = new ArrayStack<>();
		else
			st = new LinkedStack<>();
	}

	public Bag()
	{
		this(Storage.ARRAY);
	}

	public void add(Data d) {
		st.push(d);
	}
	
	
	
	public int size() {
		return st.size();
	}
	
	
	@Override
	public Iterator<Data> iterator() {
		return st.iterator();
	}
	
//	public boolean isHaving(Data d)
//	{
//		for (Data it : this) {
//			if (it.equals(d))
//				return true;
//		}
//		return false;
//	}
}
