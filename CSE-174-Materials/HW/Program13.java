/** Walter Tracey 
 * Instructor: Vijayalakshmi Ramasamy 
 * CSE 174 Section C, last hw assignment
 * Dec. 9 2016
 */ 

// class to due calculations on a set 
// of imaginary lockers...

import java.util.Scanner; 
import java.util.Arrays;

public class Program13 {

   static Scanner user = new Scanner(System.in); // global Scanner 'cause why not 

   public static void main (String[] args){
      int numLockers = 0; // initialize 
      String showStages = ""; // initialize
      
      // use loops to guarantee good input ... gather needed values 
      while (numLockers <= 0){
         System.out.print("How many lockers? ");
         numLockers = user.nextInt(); 
      }
      while (!(showStages.equals("y") || showStages.equals("n"))){
         System.out.print("Show stages? (y/n)"); 
         showStages = user.next();
      }
      boolean[] mainLockers = new boolean[numLockers]; // init lockers (all false)
      
      // if/else branch to cover printStage() or !printStage()...
      if (showStages.equals("y"))
         computeWithStages(mainLockers); 
      else 
         computeWithoutStages(mainLockers); 
      endOpenStatement(mainLockers); // always show final message
   }// end main 

   /** 
    * prints current lockers as O's and -'s
    * 
    * @param current lockers
    */ 
   public static void printStage(boolean[] lockers){
      for (int i = 0; i < lockers.length; i++){
         if (lockers[i])
            System.out.print("O"); 
         else 
            System.out.print("-"); 
      }
      System.out.println(); 
   }
   
   /**
    * do necessary operations of switching for each student, 
    * printing lockers' status after each stage
    * 
    * @param current lockers 
    */ 
   public static void computeWithStages(boolean[] lockers){
      for (int i = 0; i < lockers.length; i++)// first kid always opens all 
         lockers[i] = true; 
      printStage(lockers);
      for (int multiples = 2; multiples < lockers.length+1; multiples++){
         for (int i = 0; i < lockers.length; i++){
            if ((i+1)%multiples==0){
               lockers[i] = !lockers[i];  
            }
         }
         printStage(lockers); 
      }
   }

   /** 
    * same as above, but does not include 
    * printing stages
    * 
    * @param current lockers 
    */
   public static void computeWithoutStages(boolean[] lockers){
      for (int i = 0; i < lockers.length; i++)// first kid always opens all 
         lockers[i] = true;
      for (int multiples = 2; multiples < lockers.length+1; multiples++){
         for (int i = 0; i < lockers.length; i++){
            if ((i+1)%multiples==0){
               lockers[i] = !lockers[i]; 
            }
         } 
      }
   }

   /**
    * displays which lockers are open as last statement 
    * in program --> always starts with 1 because 
    * algorithm always leaves first locker open
    * 
    * @param ending lockers 
    */ 
   public static void endOpenStatement(boolean[] lockers){
      System.out.print("Open: 1"); // 1 always open?
      for (int i = 1; i < lockers.length; i++){
         if (lockers[i])
            System.out.print(", " + (i+1)); 
      }
      System.out.println(); 
   }

}// end class 
