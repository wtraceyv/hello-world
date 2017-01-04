/**
 * Walter Tracey 
 * Instructor: Vijayalakshmi Ramasamy 
 * CSE 174 - C 
 * 18 September 2016
 */ 

// Class to print one word vertically in huge, saved letters as string literals

public class Program3{
   public static void main(String args[]){
      // Store each huge letter in constants
      final String LETTER_P = "***\n*  *\n***\n*\n*";
      final String LETTER_O = " *** \n*   *\n*   *\n*   *\n *** "; 
      final String LETTER_C = " ****\n*\n*\n*\n ****"; 
      final String LETTER_R = " ***\n*   *\n****\n*  *\n*   *"; 
      final String LETTER_N = "*   *\n**  *\n* * *\n*  **\n*   *"; 
      
      // Use one print statements with \n escapes to print 'popcorn'
      System.out.println(LETTER_P + "\n\n" + LETTER_O + "\n\n" + LETTER_P + "\n\n" + LETTER_C + "\n\n" + LETTER_O + "\n\n" + LETTER_R + "\n\n" + LETTER_N); 
   }// end main 
}// end class
