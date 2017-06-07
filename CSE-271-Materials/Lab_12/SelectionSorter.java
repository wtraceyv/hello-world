package edu.miamioh.traceywd;

/**
 * Modified original class from text book to sort 
 * an array using selection sort LARGEST->SMALLEST
 * instead of smallest to largest. 
 * Code largely stolen from pg. 629/630 in Big Java Late Objects, 
 * modified to reverse sorting order.  
 * @author Walter Tracey 
 * Instructor: Dr. Stephan
 * CSE 271, B
 * 28 April, 2017
 */
public class SelectionSorter {
	
	/**
	 * Sort an array using selection sort. 
	 * @param a, the array to sort 
	 */
	public static void sort(int[] a){
		for (int i = 0; i < a.length - 1; i++){
			int maxPos = maximumPosition(a, i); 
			ArrayUtil.swap(a, maxPos, i);
		}
	}
	
	/**
	 * Find the maximum element in the tail end of the array. 
	 * @param a, array to sort 
	 * @param from, first position in 'a' to compare 
	 * @return position of the largest element in range a[from]...a[a.length-1]
	 */
	private static int maximumPosition(int[] a, int from){
		int maxPos = from; 
		for (int i = from + 1; i < a.length; i++){
			if (a[i] > a[maxPos]){
				maxPos = i; 
			}
		}
		return maxPos; 
	}
	
}
