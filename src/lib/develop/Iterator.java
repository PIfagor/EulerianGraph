package lib.develop;

/**
 * 
 * @author Wise
 * 
 * @param <Data>
 */
public interface Iterator<Data> {
	boolean hasNext();

	Data next();

	void remove();

}
