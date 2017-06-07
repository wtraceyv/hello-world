package edu.miamioh.traceywd;

/**
 * Class to demonstrate recursion with a method that 
 * reverses given Strings without any loops, only a 
 * recursive algorithm. 
 * @author Walter Tracey 
 * Instructor: Dr. Stephan
 * 4/8/2017
 * CSE 271, B
 */
public class Reverser {

	public static void main(String[] args){
		// print out some freaky examples 
		System.out.println("Hellkjahg");
		System.out.println("Reverse: " + reverse("Hellkjahg"));
		System.out.println("wata wata##ting tang");
		System.out.println("Reverse: " + reverse("wata wata##ting tang"));
		System.out.println("Hello.");
		System.out.println("Reverse: " + reverse("Hello."));
		System.out.println("###$$$%%%");
		System.out.println("Reverse: " + reverse("###$$$%%%"));
		System.out.println("1Tacocat2");
		System.out.println("Reverse: " + reverse("1TacocaT2"));
	}
	
	/**
	 * Reverse the given String's characters through 
	 * a purely recursive approach--no loops. 
	 * @param text, word to reverse 
	 * @return the given word with characters completely reversed 
	 */
	public static String reverse(String text){
		if (text.length()==1){
			return text;
		} else {
			return reverse(text.substring(1)) + text.substring(0, 1);  
		}
	}
}
