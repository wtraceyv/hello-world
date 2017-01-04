/** Group Project Team #13 -- CSE 174 - Section C
 * Walter Tracey, traceywd@miamioh.edu -- 75-80% contribution
 * Brendan Greenlee, greenlbt@miamioh.edu -- 20-25% contribution
 * Colin Duffy, duffyct2@miamioh.edu -- 0%
 * Yang Yu, yuy21@miamioh.edu -- 0%
 *
 * Instrustor: Vijayalakshmi Ramasamy
 * 9 December, 2016
 */

/**
 * Project Euler problems used:
 * 1, 2, 3, 7, 10, 25, 35
 * Also used 3rd problem on 2nd provided-loops problem sheet
 * A couple of methods also use file handling, but they're
 * pretty generic and just primes/fibonaccis
 */

import java.util.Scanner; // will need user input
import java.math.BigInteger;
import java.util.ArrayList;
import java.io.*;

/**
 * main problem-handling class;
 * holds the main and 3 other methods
 * that handle type-of-problem menus;
 * these methods call on other classes
 * to do actual work
 */

public class GroupProject {

   static Scanner user = new Scanner(System.in);// each class will need its own global Scanner; no discrepancies here

   public static void main (String[] args) throws Exception{// a small main....I'm just sayin'. Very modular!
      int currentChoice = 0;
      while (currentChoice!=7){
         System.out.println("How's about some math?");
         System.out.println("Choose a type of problem:\n1) Factor problem\n2) Fibonacci Problem\n3) Prime problem\n4) Write things to file\n5) Explanation/help area\n6) Values to test to solve actual Euler problems\n7) Quit");
         currentChoice = user.nextInt();
         switch(currentChoice){
            case 1: getFactorProblem();
            break;
            case 2: getFibonacciProblem();
            break;
            case 3: getPrimeProblem();
            break;
            case 4: writeSomething();
            break;
            case 5: getHelp();
            break;
            case 6: getEulerTestValues();
            break;
         }
      }
      System.out.println();
      System.out.println("Right-o, cheerio then, old chap.");
   }// end the Almighty Main

   // handle choosing of a factoring-related problem
   public static void getFactorProblem(){
      int currentFactorChoice = 0;
      while (currentFactorChoice!=3){
         System.out.println("Choose a factor problem:\n1) First Euler problem\n2) Largest prime factor of a number\n3) To main menu");
         currentFactorChoice = user.nextInt();
         switch (currentFactorChoice){
            case 1: FactorSet.firstFactorProblem();
            break;
            case 2: FactorSet.secondFactorProblem();
            break;
            case 3: System.out.println("***returning to main menu***\n");
            break;
            default: System.out.println("***default hit --> choose valid problem***\n");
            break;
         }
      }
   }

   // handle choosing of a Fibonacci-related problem
   public static void getFibonacciProblem(){
      int currentFibChoice = 0;
      while (currentFibChoice!=4){
         System.out.println("Choose a fibonacci problem:\n1) Second Euler problem; sum of evens to limit\n2) Find index of fibonacci number with so many digits\n3) Find fibonacci number at your index\n4) To main menu");
         currentFibChoice = user.nextInt();
         switch (currentFibChoice){
            case 1: FibonacciSet.firstFibonacciProblem();
            break;
            case 2: FibonacciSet.secondFibonacciProblem();
            break;
            case 3: FibonacciSet.thirdFibonacciProblem();
            break;
            case 4: System.out.println("***returning to main menu***\n");
            break;
            default: System.out.println("***default hit --> choose valid problem***\n");
            break;
         }
      }
   }

   // handle choosing of a prime-related problem
   public static void getPrimeProblem(){
      int currentPrimeChoice = 0;
      while (currentPrimeChoice!=4){
         System.out.println("Choose a prime problem:\n1) Find desired prime\n2) Sum of primes up to a limit\n3) Number of circular primes up to a limit\n4) To main menu");
         currentPrimeChoice = user.nextInt();
         switch (currentPrimeChoice){
            case 1: PrimeSet.firstPrimeProblem();
            break;
            case 2: PrimeSet.secondPrimeProblem();
            break;
            case 3: PrimeSet.thirdPrimeProblem();
            break;
            case 4: System.out.println("***returning to main menu***\n");
            break;
            default: System.out.println("***default hit --> choose valid problem***\n");
            break;
         }
      }
   }

   /**
    * method to print help for user if needed
    */
   public static void getHelp(){
      System.out.println();
      System.out.println("Welcome to our freaky little calculator!\n");
      System.out.println("Simply use the menus shown as the program runs -- \ninput an appropriate number and hit enter to choose something on a menu.");
      System.out.println("To use the menu option, \"Write primes to file\", \nchoose a file name for your output to go to, and find it created in the");
      System.out.println("same directory as this file. If you ask for more output with different data in the same file");
      System.out.println("name, the file will be overwritten with the new data.\n");
      System.out.println("Have fun with the \"calculator\"!\n");
   }

   /**
    * prints paragraph showing parameters needed to solve Euler problems
    * used in the program and their corresponding numbers on the site
    */
   public static void getEulerTestValues(){
      System.out.println("\nMost of the functions used here are inspired by prompts from ProjectEuler.net.");
      System.out.println("Below are the numbers of problems used and the values asked for on the site (which you can solve with this program):\n");
      System.out.println("First \"factors\" question >>> Euler problem 1 >>> test values: 3, 5, 1000");
      System.out.println("Second \"factors\" question >>> Euler problem 3 >>> test value, 600851475143");
      System.out.println("First \"fibonacci\" question >>> Euler problem 2 >>> test value, 4000000");
      System.out.println("Second \"fibonacci\" question >>> Euler problem 25 >>> test value, 1000");
      System.out.println("Third \"fibonacci\" question >>> taken from 2nd provided loops problem sheet");
      System.out.println("First \"prime\" question >>> Euler problem 7 >>> test value, 10001");
      System.out.println("Second \"prime\" question >>> Euler problem 10 >>> test value, 2000000");
      System.out.println("Third \"prime\" question >>> Euler problem 35 >>> test value, 1000000\n");
   }

   /**
    * method to prompt for what exactly to write to a file
    */
   public static void writeSomething() throws FileNotFoundException {
      int currentChoice = 0;
      while (currentChoice!=3){
         System.out.println("Preparing to write to file...");
         System.out.println("Choose what to write:\n1) Write primes up to limit\n2) Write fibonacci numbers up to limit\n3) Return to menu\n");
         currentChoice = user.nextInt();
         switch(currentChoice){
            case 1: writePrimes();
            break;
            case 2: writeFibonacci();
            break;
         }
         System.out.println("Returning to menu...\n");
      }
   }

   /**
    * handles process of taking input and writing primes
    * to file
    */
   public static void writePrimes() throws FileNotFoundException {
      int limit = 0;
      String fileName = "";
      System.out.print("Write to what file? ");
      fileName = user.next();
      System.out.print("Limit up to which to write primes to file: ");
      limit = user.nextInt();
      PrimeSet.storePrimes(limit, new File(fileName + ".txt"));
      System.out.println("...file written.\n");
   }

   /**
    * handles process of taking input and writing fibonaccis
    * to file
    */
   public static void writeFibonacci() throws FileNotFoundException {
      String fileName = "";
      System.out.print("Write to what file? "); // get file name, create File instance
      fileName = user.next();
      File file = new File(fileName + ".txt");
      ArrayList<Integer> fibSet = FibonacciSet.fibonacciWriteList();// get fibs list
      PrintWriter pen = new PrintWriter(file);// write into file
      for (int i = 0; i < fibSet.size()-1; i++){
         pen.println(fibSet.get(i));
      }
      pen.close();
      System.out.println("...file written.\n");
   }

}// END MENU/CONTROLLER CLASS



/**
 * class to hold all factor-related methods
 * >>> begins with prompting-methods with generic names --
 * they use helper methods at bottom of class for computations
 */
class FactorSet {

   static Scanner user = new Scanner(System.in);

   // looks complicated, really just handles input validation
   // (first problem will take three parameters from user)
   public static void firstFactorProblem (){ // give more accurate method name for problem solved...
      int firstMultiple = 0, secondMultiple = 0, limit = 0;
      System.out.println("Sum up all multiples of x and y, up to a limit...");
      while (firstMultiple < 1 || firstMultiple > 100){
         System.out.print("First multiple (1-100): ");
         firstMultiple = user.nextInt();
      }
      while (secondMultiple < 1 || secondMultiple > 100){
         System.out.print("Second multiple (1-100): ");
         secondMultiple = user.nextInt();
      }
      while (limit < 1 || limit > 10000000){
         System.out.print("Limit (1-10000000): ");
         limit = user.nextInt();
      }
      sumMultiples(firstMultiple, secondMultiple, limit);
   }

   public static void secondFactorProblem(){
      long userAnswer = 0;
      System.out.println("Find largest prime factor");
      while (userAnswer <= 1L || userAnswer > 1000000000000L){
         System.out.print("Choose a number (2-1000000000000): ");
         userAnswer = user.nextLong();
      }
      System.out.println("Greatest prime factor of " + userAnswer +": " + greatestPrimeFactor(userAnswer)+"\n");
   }

   /**
    * does work of project Euler problem 1, but taking user input
    * so that answers may vary beyond that
    *
    * @param firstMultiple, the first type of multiple the user wishes to
    * include in the sum
    * @param secondMultiple, same as first, but some other multiple 1-100
    * @param limit, the number up to which to find multiples and add to the sum
    */
   public static void sumMultiples(int firstMultiple, int secondMultiple, int limit){
      int total = 0;
      for (int i = 1; i < limit; i++){
         if (i % firstMultiple == 0 || i % secondMultiple == 0){
            total += i;
         }
      }
      System.out.println("Sum of multiples of " + firstMultiple + " and " + secondMultiple + ", up to " + limit + ": " + total + "\n");
   }

   /**
    * returns greatest prime factor of given number
    * (long types, just in case it's huge, like in the real problem)
    * based lightly on explanation by authors associated with Project Euler's site
    *
    * @param n, number to be factored down to greatest prime factor
    * @return long value representing largest prime factor of parameter n
    */
   public static long greatestPrimeFactor(long n){
      int lastFactor = 0;
      if (n%2==0){
         lastFactor = 2;
         n /= 2;
         while (n%2==0)
            n/=2;
      }
      else
         lastFactor = 1;
      int factor = 3;
      int maxFactor = (int) Math.sqrt(n);
      while (n>1 && factor<=maxFactor){
         if (n%factor==0){
            n/=factor;
            lastFactor=factor;
            while (n%factor==0){
               n/=factor;
            }
            maxFactor=(int) Math.sqrt(n);
         }
         factor+=2;
      }
      if (n==1)
         return lastFactor;
      else
         return n;
   }

}// END FACTOR SET CLASS



/**
 * class to hold all fibonacci-related methods
 * >>> begins with prompting-methods with generic names --
 * they use helper methods at bottom of class for computations
 */
class FibonacciSet {

  static Scanner user = new Scanner(System.in);

  public static void firstFibonacciProblem(){
      int userAnswer = 0;
      System.out.println("Find the sum of even fibonacci terms up to a limit");
      while (userAnswer <= 1 || userAnswer > 10000000){
         System.out.print("Choose a limit (2-10000000) (4 million in actual problem): ");
         userAnswer = user.nextInt();
      }
      eulerProblem2(userAnswer);
  }

  public static void secondFibonacciProblem(){
      int userAnswer = 0;
      System.out.println("Find index of first fibonacci number with specified number of digits");
      while (userAnswer < 2 || userAnswer > 5000){
        System.out.println("Choose number of digits of fibonacci number to be found (2-5000 digits): ");
        userAnswer = user.nextInt();
      }
      System.out.println("First fibonacci num with " + userAnswer + " digits: " + digitFib(userAnswer)+"\n");
  }

  public static void thirdFibonacciProblem(){
    int userAnswer = 0;
    System.out.println("Find the fibonacci number at your given index");
    while (userAnswer < 1 || userAnswer > 5000){
      System.out.println("Give index of number (1-5000): ");
      userAnswer = user.nextInt();
    }
    System.out.println("Fibonacci number at index " + userAnswer + ": " + findFibonacci(userAnswer)+"\n");
  }

   /**
    * finds sum of even fibonacci numbers up to specified limit,
    * then prints it
    *
    * @param desired limit
    */
  public static void eulerProblem2 (int limit){
      long sum = 0;
      int[] fibs = new int[10000000]; // arbitrary starting point
      // initialize first two values
      fibs[0] = 1;
      fibs[1] = 2;
      // loop through, do what must be done, brute force
      for (int tracker = 1; fibs[tracker] <= limit; tracker++){
         fibs[tracker+1] = fibs[tracker-1] + fibs[tracker];
         if (fibs[tracker] % 2 == 0){
            sum += fibs[tracker];
         }
      }
      System.out.println("Sum found: " + sum + "\n");
   }

   /**
    * generates fibonacci numbers, but through BigIntegers so
    * there is no overflow (no other datatype can handle 1000 digit-number
    * calculations) --> uses general algorithm instead of list
    * to keep memory down, though uses several variables
    *
    * @param digitsDesired, number of digits of fibonacci num to be found
    * @return index, index of found number where 1,1,2... in sequence
    * are (F)1,2,3... and so on
    */
   public static int digitFib(int digitsDesired){
      BigInteger first = BigInteger.ONE;
      BigInteger second = BigInteger.ONE;
      int index = 2;
      BigInteger next = BigInteger.ONE;
      while ((next.toString()).length() < digitsDesired){
         BigInteger inter = first.add(second);
         next = inter;
         first = second;
         second = next;
         index++;
      }
      return index;
   }

  /**
   * generate array of ints that represent fibonacci sequence,
   * fill it until desired index is hit and return that fibonacci number
   *
   * @param index, index of fib number desired
   * @return correct fib number at desired index
   */
  public static int findFibonacci(int index){
     int[] fibs = new int[10000000];
     fibs[0] = 1;
     fibs[1] = 1;
     int i = 0;
     for (i = 1; i < index; i++){
        fibs[i+1] = fibs[i-1] + fibs[i];
     }
     return fibs[i-1];
  }

  /**
   * creates list of fibonacci numbers w/ ArrayList
   * and handles some user input for writing fibonaccis to files
   *
   * @return ArrayList<Integer> of fibonaccis to loop through and print later
   */
  public static ArrayList<Integer> fibonacciWriteList() {
     int limit = 0;
     System.out.print("Choose limit up to which to write fibonacci numbers: ");
     limit = user.nextInt();
     ArrayList<Integer> fibs = new ArrayList<Integer>();
     fibs.add(1);
     fibs.add(1);
     for (int i = 1; fibs.get(i) < limit; i++){
        fibs.add(fibs.get(i-1)+fibs.get(i));
     }
     return fibs;
 }

}// END FIBONACCI SET CLASS


/**
 * class to hold all prime-related methods
 * >>> begins with prompting-methods with generic names --
 * they use helper methods at bottom of class for computations
 */
class PrimeSet {

   static Scanner user = new Scanner(System.in);

   public static void firstPrimeProblem(){
      int userAnswer = 0;
      while (userAnswer <= 0){
         System.out.print("Choose (first, second, etc.) prime number to find (1-1000000)");
         userAnswer = user.nextInt();
      }
      System.out.println("Your prime: " + (findPrime(userAnswer))+"\n");
   }

   public static void secondPrimeProblem(){
      int userAnswer = 0;
      while (userAnswer<=0 || userAnswer>10000000){
         System.out.print("Find sum of primes up to your limit (2-1000000)");
         userAnswer = user.nextInt();
      }
      System.out.println("Sum of primes up to " + userAnswer + ": " + sumPrimes(userAnswer) + "\n");
   }

   public static void thirdPrimeProblem(){
      int userAnswer = 0;
      while (userAnswer<2 || userAnswer>10000000){
         System.out.print("Find amount of circular primes up to your limit (2-10000000): ");
         userAnswer = user.nextInt();
      }
      System.out.println("Number of circular primes below " + userAnswer +": " + amountCircularPrimes(userAnswer)+"\n");
   }

   /** helper method returns boolean[]
    * that indicates whether number at index is prime
    * using Sieve of Eratosthenes --
    * >>> https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
    *
    * @param limit --> amount of numbers that will be
    * given an index and boolean to indicate their primality
    */
   public static boolean[] sieveOfEratosthenes(int limit){
      boolean[] primes = new boolean[limit+1];
      primes[2] = true; // 2 is prime
      for (int i = 3; i <= limit; i+=2)// odd numbers are candidates
         primes[i] = true;
      for (int i = 3; i <= (int)Math.sqrt(limit); i+=2)// the sieve....
         if (primes[i])
            for (int j = i*i; j<=limit; j+=i << 1)
               primes[j] = false;
      return primes;
   }

   /**
    * method finds indicated prime;
    * 1 --> "first prime", yields 2, etc.
    *
    * @param primeWanted desired prime in list of primes
    */
   public static int findPrime(int primeWanted){
      boolean[] primes = sieveOfEratosthenes(20000000); // arbitrary starting size
      int primesFound = 0;
      int primesIndex = 0;
      while (primesFound != primeWanted){
         if (primes[primesIndex]){
            primesFound++;
         }
         primesIndex++;
      }
      return primesIndex-1;
   }

   /**
    * method prints sum of all prime numbers up
    * to the specified limit
    *
    * @param limit
    * @return long -- just in case the sum of found primes is very large
    */
   public static long sumPrimes(int limit){
      boolean[] primes = sieveOfEratosthenes(20000000);
      long sum = 0;
      for (int i = 0; i < limit; i++){
         if (primes[i])
            sum+=(i);
      }
      return sum;
   }

   /**
    * loops through all possible mutations of root, compares each to
    * a premade set array of prime booleans (so we don't have
    * to create several, a very inefficient and slow system),
    * and checking for primality with that list. Returns true
    * if all mutations are prime, and so confirming the "circular"
    * prime
    *
    * @param root, the starting number to mutate and check for circular primality
    * @param testSet, an array of booleans premade using the Sieve of Eratosthenes
    * that is used to quickly check for primality of intermediate elements
    * @return boolean indicating circular primality
    */
   public static boolean isCircular(int root, boolean[] testSet){
      String strRoot = Integer.toString(root); // String representation is easier to mutate
      for (int i = 0; i <= strRoot.length()-1; i++){
         strRoot = strRoot.substring(1,strRoot.length()) + strRoot.substring(0,1);
         if (!(testSet[Integer.parseInt(strRoot)]))
            return false;
      }
      return true;
   }

   /**
    * creates set of prime-related booleans for more efficient use
    * with isCircular() method, then searches through that boolean[]
    * testing for circular primality and adding to count if isCircular returns
    * true
    *
    * @param limit, the threshold up to which the user wishes to count circular primes
    * @return count, the number of circular primes found
    */
   public static int amountCircularPrimes(int limit){
      boolean[] testSet = sieveOfEratosthenes(1000000);
      int count = 0;
      for (int i = 0; i < limit; i++)
         if (isCircular(i,testSet))
            count++;
      return count;
   }

   /**
    * handles actual writing of primes into the file
    *
    * @param limit, limit up to which to write primes into file
    * @param file, the file where the printed primes will appear
    */
   public static void storePrimes(int limit, File file) throws FileNotFoundException{
      boolean[] set = sieveOfEratosthenes(limit);
      PrintWriter pen = new PrintWriter(file);
      pen.println("Have some primes:");
      for (int i = 0; i < limit; i++){
         if (set[i])
            pen.println(i);
      }
      pen.close();
   }

}// END PRIME SET CLASS
