package lib.develop;

/**
 * 
 * @author Wise
 * 
 * @param <Data>
 */
public interface Queue<Data> {
	public void put(Data d);

	public Data front();

	public Data get();

	public int size();

	public boolean isEmpty();

	public void enqueue(Data d);

	public Data dequeue();
}
