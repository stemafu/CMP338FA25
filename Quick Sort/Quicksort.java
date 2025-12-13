import java.util.Random;
import java.util.Scanner;

public class Quicksort <T extends Comparable <? super T>>
implements SortInterface<T>{



	@Override
	public void sort(T[] arrayToSort) {

		sort(arrayToSort, 0, arrayToSort.length -1 );

	}

	/*
	 * A helper method: divide
	 */
	private void sort(T[] arrayToSort, int low, int high) {

		/*
		 * base case
		 * if (high <= low) {
			return;
		}*/
		
		

		if(low < high) {
			int pivotIndex;

			// 
			pivotIndex = partition(arrayToSort, low, high);

			// left subarray of pivot index
			sort(arrayToSort, low, (pivotIndex - 1));
			sort(arrayToSort, (pivotIndex + 1), high );
		}
	}
	
	private int partition(T[] arrayToSort, int low, int high) {
		
		/* In the partition, we need to choose the pivot.
		 * There different ways for selecting the pivot including 
		 * the following:
		 * 1. the first index of the sub array
		 * 2. the last index of the sub array
		 * 3. random index of the sub array
		 * 
		 * 
		 */
		int pivotIndex = low;
		
		T pivotElement = arrayToSort[pivotIndex];
		
		
		/* I need to compare the pivot element with
		 * the elements in the sub array, moving all elements that
		 * are less than the pivot element to the left
		 * and those that are greater than or equal to the pivot element 
		 * to the right 
		 */
		
		int indexOfSmallerThanPivotVals = low ;
		
		for(int i = low + 1; i <= high; i++) {
			
			// left to right
			if(arrayToSort[i].compareTo(pivotElement) < 0) {
				//swap
				indexOfSmallerThanPivotVals++;
				T temp = arrayToSort[i];
				arrayToSort[i] = arrayToSort[indexOfSmallerThanPivotVals];
				arrayToSort[indexOfSmallerThanPivotVals] = temp;
				
			}
			
			
			
		
			
			
			
			//
		}
		
		
		/* Once we have completed moving all the values that are smaller
		 * that the pivot element to the left, we place the pivot element
		 * into it correct position in the to be sorted array and 
		 * we mark the location where we placed the pivot element
		 */
		
		T temp = arrayToSort[indexOfSmallerThanPivotVals];
		arrayToSort[indexOfSmallerThanPivotVals] = pivotElement;
		arrayToSort[low] = temp;
		


		return indexOfSmallerThanPivotVals ;
	}



	/*
	 * A partition helper method.
	 * 
	 * In the partition helper method, we will place
	 * all valued that are less than the pivot to the left
	 * and those that are greater or equal to the partition to
	 * the right of the pivot. This will leave the
	 * pivot element in its correct position in the sorted
	 * array.
	 */



	public static void main(String[] args) {
		Quicksort<Integer> sort = new Quicksort<Integer>();
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
