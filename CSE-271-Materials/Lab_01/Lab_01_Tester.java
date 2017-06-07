package lab_one_src;

import java.io.*; 
import java.util.Arrays; 
import java.util.Scanner;

/**
 * Class to test Lab_01_ArrayUtilities class. 
 * Just uses main method to test 
 * @author Walter Tracey 
 * Instructor: Dr. Stephan 
 * CSE 271, Sec. B
 * 27 January, 2017 
 */

public class Lab_01_Tester {

	/**
	 * Demonstrate use of random CSE knowledge and 
	 * student-made Lab_01_ArrayUtilities class 
	 * @param args, command line arguments (irrelevant here) 
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter pen = new PrintWriter(new File("Lab_01_nums.txt"));// 'cause errbody need a PrintWriter 
		Scanner read = new Scanner(new File("words.txt")); // and errbody DEFINITELY need a Scanner
		
		// create list, print and write it 
		int[] testArray = Lab_01_ArrayUtilities.buildIntArray(20, 10, 29); 
		System.out.println(Arrays.toString(testArray));
		pen.println(Arrays.toString(testArray));
		
		// swap even indexes w/ right-adjacent index, then print and write 
		for (int i = 0; i < testArray.length-1; i++){
			if (i % 2 == 0){
				Lab_01_ArrayUtilities.swap(testArray, i, i+1);
			}
		}
		System.out.println(Arrays.toString(testArray));
		pen.println(Arrays.toString(testArray)); 
		
		// sort array, print and write it, close file 
		Arrays.sort(testArray);
		System.out.println(Arrays.toString(testArray));
		pen.println(Arrays.toString(testArray)); 
		pen.close(); 
		
		// count odd values and print it 
		int odds = 0; 
		for (int value : testArray){
			if (value % 2 != 0){
				odds++; 
			}
		}
		System.out.printf("Amount of odd values currently in array: %d\n", odds);
		
		/** read words in file char by char and print appropriate stats */ 
		// have vars to keep track of char types, store vowels to check against 
		int vowels = 0; 
		int consonants = 0; 
		int other = 0; 
		String[] vowelCache = {"a","e","i","o","u"}; 
		
		while (read.hasNext()){
			boolean characterAccountedFor = false; // flag so each char is only counted once  
			read.useDelimiter(""); 
			String current = read.next(); 
			current = current.toLowerCase(); // keep cases simple
			// determine if vowel
			for (int i = 0; i < vowelCache.length; i++){
				if (current.equals(vowelCache[i])&&!characterAccountedFor){
					vowels++;  
					characterAccountedFor = true; 
					break; 
				}
			}
			// determine if "other" (must NOT be carriage return), 
			// with methods of Character class. (hence the array, and Character constructor.) 
			// Used Java 7 Oracle API to determine how to do that ^
			char[] currentCharArray = current.toCharArray(); 
			Character charForMethodUse = new Character(currentCharArray[0]); 
			if (!(characterAccountedFor || Character.isLetter(charForMethodUse) 
										|| charForMethodUse.equals(new Character('\n')) 
										|| charForMethodUse.equals(new Character('\r')))){
				other++; 
				characterAccountedFor = true; 
			}
			// consonants should be any other unaccounted characters that aren't returns 
			if (!(characterAccountedFor || charForMethodUse.equals(new Character('\n')) 
										|| charForMethodUse.equals(new Character('\r')))){
				consonants++; 
			}
			
		}// end while() reading words.txt 
		System.out.printf("There were %d vowels, %d consonants, and %d other characters in the text file.", vowels, consonants, other);
		read.close();
		
	}// end main method

}// end Lab_01_Tester class 
