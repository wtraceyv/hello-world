/** Walter Tracey 
 * Instructor: Vijayalakshmi Ramasamy
 * CSE 174, C 
 * 4 Decemeber, 2016
 */

// class to partially implement the game "Yahtzee"
// in form of a program 

import java.util.Scanner; 
import java.util.ArrayList;

public class Program12 {

   static Scanner user = new Scanner(System.in); // global Scanner 

   public static void main(String[] args){
      System.out.println("Welcome to Yahtzee!"); 
      int turns = 1; 
      int[] orig = {2,5,2,5,5}; // initialize dice 

      //roll(orig); // do first roll automatically 
      while (turns <= 3){// loop handles all three rolls (if needed)
         sort(orig); 
         System.out.println("Roll #" + turns + ": " + toString(orig));
         scoreChoices(orig); 
         
         String rerollChoice = "";
         while (!(rerollChoice.equals("y") || rerollChoice.equals("n")) && turns!=3){
            System.out.print("Roll again? "); 
            rerollChoice = user.nextLine();
         } 
         if (rerollChoice.equals("y"))
            reroll(orig); 
         else // break out, display score if user says "no"
            break; 
         turns++; 
      }
      System.out.println("Your score is " + maxScore(orig) + ". Goodbye."); 
   }// end main 

   // method to pick 5 new dry values for the 5 dice in input array 
   public static void roll(int[] dice){
      for (int i = 0; i < dice.length; i++){
         dice[i] = (int) ((Math.random()*6)+1); 
      }
   }

   // method to sort dice using bubble sort 
   public static void sort(int[] dice){
      boolean sorted = false; // flag for primary loop 
      while (!sorted){
         boolean noSwitches = true; 
         for (int i = 0; i < dice.length-1; i++){
            if (dice[i] > dice[i+1]){
               int temp = dice[i+1]; 
               dice[i+1] = dice[i]; 
               dice[i] = temp; 
               noSwitches = false; 
            }
         }
         if (noSwitches == true){
            sorted = true; 
         }
      }
   }// end sort 

   /** loops through dice, prints with space between each value 
    * 
    * @param current dice (to be printed)
    * @return String format of current dice 
    */ 
   public static String toString(int[] dice){
      String end = ""; 
      for (int i = 0; i < dice.length; i++){
         end += dice[i] + " "; 
      }
      return end; 
   }

   /** rerolls user-selected dice if choices are valid 
    * void --> modifies current dice; no @return needed
    *
    * @param current set of dice, array 
    */ 
   public static void reroll(int[] dice){
      boolean answerValid = false; 
      String rerollChoices = ""; 
      ArrayList<Integer> diceToReroll = new ArrayList<Integer>(); 
      while (answerValid==false){
         System.out.print("Indicate which dice to roll using y and n: "); 
         rerollChoices = user.nextLine(); 
         if (rerollChoices.length() != 5)
            continue; 
         for (int i = 0; i < rerollChoices.length(); i++){// parse through String
            if ((rerollChoices.charAt(i)!='y' && rerollChoices.charAt(i)!='n') || !rerollChoices.contains("y")){
               answerValid = false; 
            }
            else if (rerollChoices.charAt(i)=='y'){
               diceToReroll.add(i);
               answerValid = true;  
            }
            else if (rerollChoices.charAt(i)=='n'){
               answerValid = true; 
               continue; 
            }
         }// end String parsing 
      }
      for (int i = 0; i < diceToReroll.size(); i++){// reroll the specified dice 
         dice[diceToReroll.get(i)] = (int) ((Math.random()*5) + 1); 
      }
   }// end reroll method 

   /** checks for yahtzee; yes, return 50, else 0
    */ 
   public static int yahtzee(int[] dice){
      if (greatestOfAKind(dice)==5)
         return 50; 
      else 
         return 0;  
   }

   /** 
    * @param current dice 
    * @return sum of all dice values, IF there is a four of a kind, else 0 
    */ 
   public static int fourOfAKind(int[] dice){
      if (greatestOfAKind(dice) >= 4)
         return chance(dice); 
      return 0; 
   }

   /** 
    * @param current dice 
    * @return sum of all dice values, IF there is a three of a kind, else 0
    */ 
   public static int threeOfAKind(int[] dice){
      if (greatestOfAKind(dice) >= 3)
         return chance(dice);  
      return 0; 
   }

   /**
    * helper method to determine the greatest 
    * amount of the same number in the dice--
    * so, if there is a 4 of a kind, it'll return 
    * at least 4; if it has a yahtzee, 5, etc. 
    * 
    * @param int[] current dice values  
    * @return int of greatest amount of one value found 
    */
   public static int greatestOfAKind(int[] dice){
      int[] amountOfEachHere = amountOfEach(dice); 
      sort(amountOfEachHere); 
      return amountOfEachHere[amountOfEachHere.length-1]; 
   }

   /** checks whether current dice contains a 
    * large straight; if so, returns 40, otherwise 0
    */ 
   public static int largeStraight(int[] dice){
      for (int i = 0; i < dice.length-1; i++){
         if ((dice[i+1]-dice[i])!=1)
            return 0; 
      } 
      return 40; 
   }

   /** checks whether current dice contains a 
    * small straight; if yes, return 30, otherwise 0
    */ 
   public static int smallStraight(int[] dice){
      boolean passing = true; 
      for (int i  = 0; i < dice.length-1; i++){
         if (dice[i+1]-dice[i]!=1){
            passing = false; 
            break; 
         }
      } 
      if (passing)
         return 30; 
      else {
         for (int i = 1; i < dice.length-1; i++){
            if (dice[i+1]-dice[i]!=1)
               return 0; 
         }
      }
      return 30; 
   }

   /** checks whether the current dice 
    * contain a full house; return 25 if yes, 0 otherwise 
    */ 
   public static int fullHouse(int[] dice){
      if (threeOfAKind(dice)>0){
         if (greatestOfAKind(dice)==5)
            return 25; 
         else if (greatestOfAKind(dice)==3){
            sort(dice); 
            if ((dice[0]==dice[1]&&dice[1]!=dice[2]) || ((dice[0]==dice[1]&&dice[1]==dice[2])&&(dice[2]!=dice[3]&&dice[3]==dice[4])))
               return 25; 
         }
      }
      return 0; 
   }

   /** returns sum of all occurences 
    * of one certain value as it appears 
    * in current dice 
    */ 
   public static int sum(int[] dice, int key){
      int sum = 0; 
      for (int i = 0; i < dice.length; i++){
         if (dice[i] == key)
            sum+=key; 
      }
      return sum;
   }

   /** used in scoreChoices() --> 
    * @return total of individual dice values 
    */ 
   public static int chance(int[] dice){
      int sum = 0; 
      for (int i = 0; i < dice.length; i++)
         sum+=dice[i]; 
      return sum;  
   }

   /** prints all possible categories 
    * yielding player any score. Printed 
    * in order in which they appear on 
    * scoresheet 
    */ 
   public static void scoreChoices(int[] dice){
      for (int i = 0; i < 6; i++){
         if (sum(dice,(i+1))>0){
            System.out.println((i+1) + " total: " + sum(dice,(i+1))); 
         }
      } 
      if (threeOfAKind(dice)>0)
         System.out.println("3 of a kind: " + threeOfAKind(dice)); 
      if (fourOfAKind(dice)>0)
         System.out.println("4 of a kind: " + fourOfAKind(dice)); 
      if (fullHouse(dice)>0)
         System.out.println("full house: " + fullHouse(dice)); 
      if (smallStraight(dice)>0)
         System.out.println("small straight: " + smallStraight(dice)); 
      if (largeStraight(dice)>0)
         System.out.println("large straight: " + largeStraight(dice)); 
      if (yahtzee(dice)>0)
         System.out.println("yahtzee: " + yahtzee(dice)); 
      System.out.println("chance: " + chance(dice)); 
   }

   /** 
    * returns largest possible score from 
    * one category of yahtzee w/ current dice 
    */ 
   public static int maxScore(int[] dice){
      int endMax = 0; 
      for (int i = 0; i < dice.length; i++){
         if (sum(dice,(i+1))>endMax)
            endMax = sum(dice,(i+1));  
      }  
      if (chance(dice)>endMax)
         endMax = chance(dice); 
      if (threeOfAKind(dice)>endMax)
         endMax = threeOfAKind(dice);
      else if (fourOfAKind(dice)>endMax)
         endMax = fourOfAKind(dice); 
      else if (fullHouse(dice)>endMax)
         endMax = fullHouse(dice); 
      else if (smallStraight(dice)>endMax)
         endMax = smallStraight(dice); 
      else if (largeStraight(dice)>endMax)
         endMax = largeStraight(dice); 
      else if (yahtzee(dice)>endMax)
         endMax = yahtzee(dice); 
      return endMax; 
   }

   /** creates a new array 
    * that assigns each possible value 1-6 an index, 
    * then loops through the dice to figure out how 
    * many of each value is present. Useful as a helper in 
    * other methods 
    * 
    * @param current dice 
    * @return array representing amount of each value present in dice 
    */ 
   public static int[] amountOfEach(int[] dice){
      int[] end = {0,0,0,0,0,0}; 
      for (int i = 0; i < dice.length; i++){
         switch(dice[i]){
            case 1: end[0]++; 
            break; 
            case 2: end[1]++; 
            break; 
            case 3: end[2]++; 
            break; 
            case 4: end[3]++; 
            break; 
            case 5: end[4]++; 
            break; 
            case 6: end[5]++; 
            break; 
         }
      }
      return end; 
   }

}// end class 
