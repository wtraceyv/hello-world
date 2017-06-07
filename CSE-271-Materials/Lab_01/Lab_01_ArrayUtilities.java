package lab_one_src;

/**
 * Class to store methods related to arrays 
 * @author Walter Tracey 
 * Instructor: Dr. Stephan 
 * CSE 271, Sec. B
 * 27 January, 2017 
 */

public class Lab_01_ArrayUtilities {
	
	/**
	 * Return an array of specified length, filled with ints 
	 * within given range. 
	 * @param length, desired amount of random numbers
	 * @param fromNum, starting number of random number range 
	 * @param toNum, last possible number in random num range 
	 * @return int array of specified length with ints from range given
	 */
	public static int[] buildIntArray(int length, int fromNum, int toNum){
		int[] end = new int[length]; 
		for (int i = 0; i < end.length; i++){
			// start with random decimal, extend by multiplying out to range,
			// add one to cancel out 0-indexing of arrays 
			end[i] = (int) (Math.random() * (Math.abs(toNum-fromNum)+1)) + fromNum; 
		}
		return end; 
	}// end buildIntArray() method 
	
	/**
	 * Swap given indices' values in given array 
	 * @param nums, array to swap values in
	 * @param i first index of int to swap 
	 * @param j second index of int to swap
	 */
	public static void swap(int[] nums, int i, int j){
		// make sure I know which index comes first 
		int first = i; 
		int second = j; 
		if (j < i){
			first = j;
			second = i; 
		}
		// have a variable for making sure I don't lose first value
		int saved = -1; 
		// loop through and do what's necessary 
		for (int k = 0; k < nums.length; k++){
			if (k==first){
				saved = nums[k]; 
				nums[k] = nums[second]; 
			}
			if (k==second){
				nums[k] = saved; 
			}
		}
	}// end swap() method
	
}// end Lab_01_ArrayUtilities class 
