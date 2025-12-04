/**
 * 
 * This interface will be used by various classes to sort an array <code>Integer</code> objects.
 * You will write three classes that implement this interface:
 * 
 * <ol>
 * <li>Merge Sort</li>
 * <li>Quick Sort</li>
 * <li>Heap Sort</li>
 * </ol>
 * 
 * @author Sameh A. Fakhouri
 *
 */

public interface SortInterface<T extends Comparable <? super T>> {

	/**
	 * 
	 * This method is called to sort the given array of objects. At the
	 * completion of this method, the array will be sorted.
	 * 
	 * Please note that the objects in the array must either implements
	 * the Comparable interface or the must extend a class that does.
	 * 
	 * @param arrayToSort This is the array that contains all the objects
	 * that need to be sorted.
	 */
	public void sort(T[] arrayToSort);
	
}
