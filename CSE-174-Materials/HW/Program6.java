// Walter Tracey
// Instrusctor: Vijayalakshmi Ramasamy
// CSE 174 Section C
// 5 October 2016

// Class to time-test user on random
// multiplication and division problems

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Program6 {

   // global variables for main/written method variable crossovers
   private static int numberCorrect = 0;
   private static int multiplicationCorrect = 0;
   private static int divisionCorrect = 0;

   public static void main(String[] args){

      // initialize objects, vars
      Scanner user = new Scanner(System.in);
      int multLimit;
      int divLimit;
      int currentAnswer;
      ArrayList<Integer> currentNums = new ArrayList<Integer>();
      long startTime;
      long endTime;

      // Starting message
      System.out.println("Welcome to my math quiz!");
      System.out.println("This quiz will give you three multiplication problems,");
      System.out.println("and then three division problems.");
      System.out.println("-----------------------------------------------------");

      // preliminary values grabbed
      System.out.print("Enter the multiplication limit: ");
      multLimit = user.nextInt();
      System.out.print("Enter the division limit: ");
      divLimit = user.nextInt();
      System.out.println();
      System.out.println("The timer starts...now!");
      startTime = System.nanoTime();

      // BEGIN REAL GAME SECTION
      // multiplication problems:
      System.out.println("-MULTIPLICATION--------------------------------------");
      currentNums = generateMultiplication(multLimit);
      System.out.print(currentNums.get(0) + " * " + currentNums.get(1) + " = ");
      currentAnswer = user.nextInt();
      checkCorrect(currentAnswer, currentNums.get(0) * currentNums.get(1), currentNums.get(0), currentNums.get(1), "multiplication");
      currentNums = generateMultiplication(multLimit);
      System.out.print(currentNums.get(0) + " * " + currentNums.get(1) + " = ");
      currentAnswer = user.nextInt();
      checkCorrect(currentAnswer, currentNums.get(0) * currentNums.get(1), currentNums.get(0), currentNums.get(1), "multiplication");
      currentNums = generateMultiplication(multLimit);
      System.out.print(currentNums.get(0) + " * " + currentNums.get(1) + " = ");
      currentAnswer = user.nextInt();
      checkCorrect(currentAnswer, currentNums.get(0) * currentNums.get(1), currentNums.get(0), currentNums.get(1), "multiplication");
      System.out.println();

      // division problems:
      System.out.println("-DIVISION--------------------------------------------");
      currentNums = generateDivision(divLimit);
      System.out.print(currentNums.get(2) + " / " + currentNums.get(0) + " = ");
      currentAnswer = user.nextInt();
      checkCorrect(currentAnswer, currentNums.get(1), currentNums.get(2), currentNums.get(0), "division");
      currentNums = generateDivision(divLimit);
      System.out.print(currentNums.get(2) + " / " + currentNums.get(0) + " = ");
      currentAnswer = user.nextInt();
      checkCorrect(currentAnswer, currentNums.get(1), currentNums.get(2), currentNums.get(0), "division");
      currentNums = generateDivision(divLimit);
      System.out.print(currentNums.get(2) + " / " + currentNums.get(0) + " = ");
      currentAnswer = user.nextInt();
      checkCorrect(currentAnswer, currentNums.get(1), currentNums.get(2), currentNums.get(0), "division");
      System.out.println();

      endTime = Math.round((System.nanoTime() - startTime) / (Math.pow(10,9)));
      System.out.println("The timer stops...now! You answered in " + endTime + " seconds.\n");

      // end stats output:
      System.out.println("-RESULTS---------------------------------------------");
      System.out.printf("Multiplication score: " + multiplicationCorrect + " out of 3 (%.3f%%)%n", 100 * multiplicationCorrect/3.0);
      System.out.printf("Division score: " + divisionCorrect + " out of 3 (%.3f%%)%n", 100 * divisionCorrect/3.0);
      System.out.printf("Overall score: " + numberCorrect + " out of 6 (%.3f%%)%n", 100 * numberCorrect / 6.0);
   } // end main

   public static ArrayList<Integer> generateMultiplication(int limit){
      ArrayList<Integer> chosenNumbers = new ArrayList<Integer>();
      int firstFactor = (int) (1 + Math.sqrt(limit) * Math.random());
      int secondFactor = (int) (1 + firstFactor * Math.random());
      if (Math.random() < .5){
         firstFactor += secondFactor;
         secondFactor = firstFactor - secondFactor;
         firstFactor -= secondFactor;
      } // ocassionally switch the var values

      chosenNumbers.add(firstFactor);
      chosenNumbers.add(secondFactor);
      return chosenNumbers;
   } // end multiplication generator

   public static ArrayList<Integer> generateDivision(int limit){
      ArrayList<Integer> chosenNumbers = new ArrayList<Integer>();
      int dividend = (int) (1 + Math.sqrt(limit) * Math.random());
      int divisor = (int) (1 + dividend * Math.random());
      int product = dividend * divisor;
      chosenNumbers.add(dividend);
      chosenNumbers.add(divisor);
      chosenNumbers.add(product);
      return chosenNumbers;
   } // end division generator

   /**
    * check answers and issue printlines according to correctness
    */
   public static void checkCorrect(int userAnswer, int realAnswer, int firstNum, int secondNum, String probType){
      if (userAnswer == realAnswer){
         numberCorrect++;
         if (probType == "multiplication"){
            multiplicationCorrect++;
         }
         else {
            divisionCorrect++;
         }
      System.out.println("Yes! You have " + numberCorrect + " correct so far.");
      }
      else {
         if (probType.equals("multiplication")){
            System.out.println("Sorry, " + firstNum + " * " + secondNum + " = " + realAnswer + ". You have " + numberCorrect + " correct so far.");
         }
         else {
            System.out.println("Sorry, " + firstNum + " / " + secondNum + " = " + realAnswer + ". You have " + numberCorrect + " correct so far.");
         }
      }
   }

} // end class
