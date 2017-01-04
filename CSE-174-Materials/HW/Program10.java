import java.util.Scanner; 
import java.util.ArrayList; 

public class PrimeStuff{

   // global Scanner 
   static Scanner user = new Scanner(System.in); 

   public static void main(String[] args){
      int userChoice = idlePrompt(); 
      while (userChoice != 4){ 
         switch (userChoice){
            case 1: promptChoice1(); 
            break; 
            case 2: promptChoice2(); 
            break; 
            case 3: promptChoice3(); 
            break; 
         }
         userChoice = idlePrompt(); 
      }
   }// end main 

   /** 
    * 2 below methods provide input validation
    * and printing for the main menu 
    */

   public static int idlePrompt(){
      System.out.println("What would you like to do?"); 
      System.out.println("1) Check if a number is prime\n2) Factor a number\n3) List prime numbers\n4) Quit");
      System.out.print("Choice: "); 
      int userChoice = user.nextInt(); 
      while (!idlePromptValid(userChoice)){
         System.out.println("**** INVALID OPTION ****");
         System.out.println("What would you like to do?"); 
         System.out.println("1) Check if a number is prime\n2) Factor a number\n3) List prime numbers\n4) Quit");
         System.out.print("Choice: "); 
         userChoice = user.nextInt();
      }
      return userChoice; 
   }
   public static boolean idlePromptValid(int choice){
      if (choice < 1 || choice > 4)
         return false; 
      return true; 
   }

   /** 
    * below three methods use other methods
    * to perform all the possible menu options
    * in one modular implementation; 
    * all are 'void', since the other 
    * methods do calculations
    */

   public static void promptChoice1(){
      long n = checkBigValues();
      if (isPrime(n))
         System.out.println("---> " + n + " is prime."); 
      else 
         System.out.println("---> " + n + " is not prime."); 
   }

   public static void promptChoice2(){
      long n = checkBigValues(); 
      if (n == 1)
         System.out.println("---> 1 = 1"); 
      else {
         ArrayList<Long> factors = primeFactors(n); 
         System.out.print("---> " + n + " = " + factors.get(0) + " "); 
         for (int i = 1; i < factors.size(); i++){
            System.out.print("* " + factors.get(i) + " "); 
         }
         System.out.println();
      }
   }
   
   public static void promptChoice3(){
      long start = checkBigValues3(); 
      int numPrimes = 0; 
      int primesPerRow = 0; 
      // input validation for prime listing options
      while (numPrimes < 1 || numPrimes > 1000){
         System.out.print("How many primes (1-1000): "); 
         numPrimes = user.nextInt(); 
      }
      while (primesPerRow < 1 || primesPerRow > 20){
         System.out.print("How many primes per row (1-20): "); 
         primesPerRow = user.nextInt(); 
      }
      // find the primes 
      int primesFound = 0; // also can act as our 'tracker' for the array
      long[] primes = new long[numPrimes]; 
      for (; primesFound < numPrimes; start++){
         if (isPrime(start)){
            primes[primesFound] = start; 
            primesFound++; 
         }
      }
      // use method and primes array to print 
      printTable(primes,primesPerRow); 
   }

   public static ArrayList<Long> primeFactors(long n){
      ArrayList<Long> factors = new ArrayList<Long>(); 
      for (long possibleFactor = 2; possibleFactor <= n/possibleFactor; possibleFactor++){
         int instances = 0; 
         while (n % possibleFactor == 0){
            factors.add(possibleFactor);
            n /= possibleFactor;
         }
      }
      if (n > 1){
         factors.add(n); 
      }
      return factors; 
   }

   /**
    * @param a valid Long, as specified by checkBigNumbers() 
    * @return boolean indicating whether n is prime 
    */
   public static boolean isPrime(long n){
      if (n < 2)
         return false; 
      else {
         for (int i = 2; i < n; i++){
            if (n % i == 0)
               return false; 
         }
      }
      return true; 
   }

   /**
    * Prints a table using nested for loops according
    * to how many numbers need printed and how many 
    * numbers should be in each row 
    *
    * @param primes is the list of primes whose length is needed, and numbers needed to print
    * @param primesPerRow specifies how many numbers long each row is 
    */

   public static void printTable(long[] primes, int primesPerRow){
      int primesTracker = 0; 
      int rows = primes.length / primesPerRow; 
      int biggestNumLength = Integer.MIN_VALUE; 
      String spaces = ""; 
      if (primes.length % primesPerRow != 0){
         rows += 1;  
      }
      for (int i = primes.length - primesPerRow - 1; i < primes.length; i++){
         if (numberLength(primes[i]) > biggestNumLength){
            biggestNumLength = numberLength(primes[i]);
         }
      }
      ///////
      for (int i = 0; i < biggestNumLength; i++){
         spaces+=" "; 
      }
      ///////
      for (int i = 0; i < rows; i++){
         for (int j = 0; j < primesPerRow && primesTracker < primes.length; j++){
            System.out.printf("  " + "%" + biggestNumLength + "d",primes[primesTracker]);
            primesTracker++; 
         }
         System.out.println(); 
      }
      System.out.println(); 
   }

   /**
    * Locks user in menu until user enters 
    * a valid number in the natural Long range. 
    *
    * @return a valid Long int, usable with the methods written 
    */
   
   public static long checkBigValues(){
      System.out.print("Enter a number between 1 and " + Long.MAX_VALUE + ": ");
      long n = user.nextLong(); 
      while (n < 1 || n > Long.MAX_VALUE){
         System.out.print("Enter a number between 1 and " + Long.MAX_VALUE + ": "); 
         n = user.nextLong(); 
      }
      return n; 
   }
   
   public static long checkBigValues3(){
      System.out.print("Enter starting number between 1 and " + Long.MAX_VALUE + ": ");
      long n = user.nextLong(); 
      while (n < 1 || n > Long.MAX_VALUE){
         System.out.print("Enter starting number between 1 and " + Long.MAX_VALUE + ": "); 
         n = user.nextLong(); 
      }
      return n; 
   }
   
   public static int numberLength(long n){
      return (int) Math.floor(Math.log10(n) + 1); 
   }

}// end class 
