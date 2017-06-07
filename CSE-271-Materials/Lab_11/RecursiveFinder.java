package edu.miamioh.traceywd;

import java.util.Arrays;

/**
 * Class to use recursion to find the largest element 
 * in an array of ints without any loops; tests and displays 
 * results in main, printed to console.  
 * @author Walter Tracey 
 * Instructor: Dr. Stephan
 * 4/8/2017
 * CSE 271, B
 */
public class RecursiveFinder {

	public static void main(String[] args){
		// some test array of different numbers and length of arrays  
		int[] firstTest = {5,2,12,7,64,3,9,687,35}; 
		int[] secondTest = {4739,53,6,78}; 
		int[] thirdTest = {-35,-6,-53,5,-64}; 
		int[] fourthTest = {-35,-6,-53,-5,-64}; 
		
		// print out some examples of use
		System.out.println(largestElement(firstTest));
		System.out.println(largestElement(secondTest));
		System.out.println(largestElement(thirdTest));
		System.out.println(largestElement(fourthTest));
		System.out.println(largestElement(new int[] {}));// empty edge case example 
	}
	
	/**
	 * Find the largest element in a parameterized array 
	 * using only recursion and no loops. 
	 * @param list, array of ints to sort through and sift out the largest element
	 * @return the largest int element found in the given array 
	 */
	public static int largestElement(int[] list){
		if (list.length==0){
			return 0; 
		} else if (list.length==1){
			return list[0]; 
		} else {
			return Math.max(largestElement(Arrays.copyOf(list, list.length-1)), list[list.length-1]); 
		}
	}
}
