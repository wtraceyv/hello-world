/* Walter Tracey 
* Instructor: Vajayalakshmi Ramasamy
* CSE 174 C
* 11 September 2016
*/ 

// Class to solve problem P1.8 in Big Java: 
// Draw Piet Mondrian imitation with symbols and print statements

public class Art{
   public static void main (String[] args){
   // Store horizontal borders so they are the same lengths
      String horizontalBorder = "-------------------------"; 
  
      System.out.println(horizontalBorder); // top of "painting"

      // now all the random charaters to draw the painting: 
      System.out.println("|####|#####|@@@|%%%%%|###|");
      System.out.println("|####|#####|@@@|%%%%%|@@@|");
      System.out.println("|---|$$$$$$$$$$|-----|@@@|");
      System.out.println("|@@@|$$$$$$$$$$|#####|@@@|");
      System.out.println("|---|$$$$$$$$$$|-----|@@@|"); 
      System.out.println("|###|----------|%%%%%%%%%|"); 
      System.out.println("|###|#######|@@|%%%%%%%%%|"); 
      System.out.println("|###|#######|--|%%%%%%%%%|"); 
      System.out.println(horizontalBorder); // bottom of "painting"
   }
}
