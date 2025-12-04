import java.util.Random;
import java.util.Scanner;

public class MergeSort <T extends Comparable <? super T>> implements 
SortInterface<T>{

	@Override
	public void sort(T[] arrayToSort) {
		
		// divide
		sort(arrayToSort, 0, (arrayToSort.length - 1) );
		
	}
	
	/* 
	 * We are going to create a helper method that we will use 
	 * for dividing the arrayToSort into sub-arrrays until we only have
	 * one element in the sub-arrays.
	 */
	private void sort(T[] arrayToSort, int low, int high) {
		// The divide method is recursive
		if(high <= low) {
			return;
		}
		
		int mid = (low + high) / 2;
		sort(arrayToSort, low, mid);
		sort(arrayToSort, mid + 1, high);
		
		merge(arrayToSort, low, mid, high);
		
	}
	
	/*
	 * The following helper method will be used to iteratively
	 * go over the subarrays sorting and merging the values into a bigger
	 * array
	 */
	private void merge(T [] arrayToSort, int low, int mid, int high) {
		/*
		 * We had an error here in computing the length of the sub arrays.
		 * This is not fixed.
		 */
		int subArray1Length = (mid + 1) - low;
		int subArray2Length = (high - mid);
		
		Object [] leftSubArray = new Object[subArray1Length];
		Object [] rightSubArray = new Object[subArray2Length];
		
		/* I want to copy the unsorted values from the arrayToSort
		 * into the two sub-arrays that we have just created.
		 * 
		 * After I will not loop through while comparing the values from
		 * the two  sub-arrays, taking the smallest value from the two sub-arrays
		 * and placing into the bigger array in a sorted way.
		 * 
		 * Once we complete all the values from one of the sub-arrays, it means
		 * we are not only remaining with values in one sub-array.
		 * Now We just need to copy those remaining values from that sub-arrays into the bigger
		 * array.
		 */
		int leftSubArrayIndex = low;
		for(int i = 0; i < leftSubArray.length; i++ ) {
			leftSubArray[i] = arrayToSort[leftSubArrayIndex ];
			leftSubArrayIndex ++;
		}
		
		int rightSubArrayIndex = mid + 1;
		for(int i = 0; i < rightSubArray.length; i++ ) {
			rightSubArray[i] = arrayToSort[rightSubArrayIndex ];
			rightSubArrayIndex++;
		}
		
		int index = low;
		int i = 0;
		int j = 0;
		
		while(i < leftSubArray.length && j < rightSubArray.length) {
			if(((T)leftSubArray[i]).compareTo((T)rightSubArray[j]) < 0 ) {
				arrayToSort[index] = (T)leftSubArray[i];
				i++;
			}else {
				arrayToSort[index] = (T)rightSubArray[j];
				j++;
			}
			index++;
		}
		
		
		/* copy the remaining values for the left sub array if
		there are any remaining values
		*/
		while(i < leftSubArray.length ) {
			arrayToSort[index] = (T)leftSubArray[i];
			i++;
			index++;
		}
		
		/* copy the remaining values for the right sub array if
		there are any remaining values
		*/
		while(j < rightSubArray.length) {
			arrayToSort[index] = (T)rightSubArray[j];
			j++;
			index++;
		}
		
	}
	
	
	public static void main(String [] args) {
		MergeSort sort = new MergeSort();
		//Person<Integer> p1 = new Person<Integer>("A", 1, 30);
		//Person<Integer> p2 = new Person<Integer>("B", 3, 25);
		//Person<Integer> p3 = new Person<Integer>("C", 10, 50);
		//Person<Integer> p4 = new Person<Integer>("C", 20, 60);
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		int max = rand.nextInt(10)+ 8;
		
		
		Integer [] persons = new Integer[max];
		
		for(int i = 0; i < persons.length; i++) {
			persons[i] = rand.nextInt(100) + 5;
		}
		
		
		
		for(int i = 0; i < persons.length; i++) {
			System.out.print(persons[i] + " ");
		}
		System.out.println();
		sort.sort(persons);
		
		for(int i = 0; i < persons.length; i++) {
			System.out.print(persons[i] + " ");
		}
	}

}
