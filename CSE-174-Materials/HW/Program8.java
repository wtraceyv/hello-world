/** Walter Tracey 
  * Instructor: Vijayalakshmi Ramasamy 
  * CSE 174, Section C 
  * 30 October 2016
  */ 

// class that performs some date formatting with methods
// according to specific conditions 

import java.util.Scanner; 

public class Program8 {
   public static void main (String[] args){
      Scanner user = new Scanner(System.in); 

      // take input, make vars to store date parts and use easier below 
      // works, since these are local to the main 
      System.out.print("Enter a date: "); 
      String userDate = user.nextLine();
      int month = parseMonth(userDate); 
      int day = parseDay(userDate); 
      int year = parseYear(userDate); 

      // sure to filter out all bad dates from start: 
      if (isValid(month,day,year)){
         // use methods to do all formatting and display info 
         System.out.println(dateString(month,day,year));
         System.out.println("Days in " + getMonthName(month) + ", " + year + ": " + daysInMonth(isLeapYear(year),month)); 
         System.out.println("Days remaining in " + year + ": " + daysRemaining(month,day,year)); 
         System.out.println("Leap year: " + leapYearString(year)); 
         System.out.println("Next day: " + nextDateString(month, day, year)); 
      }
      else {
         System.out.println("This is not a valid date."); 
      }
   }// END MAIN

   /** below 3 methods use String formatting 
    * to parse user's input date into month, day, year 
    * for use as parameters in other methods. 
    * Uses Integer class method parseInt() to 
    * easily convert Strings into ints so calculations
    * can be done 
    */ 

   public static int parseMonth(String date){
      date = date.substring(0,date.indexOf("-"));
      return Integer.parseInt(date);  
   }

   public static int parseDay(String date){
      date = date.substring(date.indexOf("-")+1);
      date = date.substring(0,date.indexOf("-")); 
      return Integer.parseInt(date); 
   }

   public static int parseYear(String date){
      date = date.substring(date.indexOf("-")+1); 
      date = date.substring(date.indexOf("-")+1); 
      return Integer.parseInt(date); 
   }

   /** checks whether year is a leap year -- 
    * only returns true or false 
    */ 

   public static boolean isLeapYear(int year){
      if (year % 4 == 0){
         if (year % 100 != 0){
            return true; 
         }
         else if (year % 100 == 0 && year % 400 == 0){
            return true; 
         }
      }
      else {
         return false; 
      }
      return false; 
   }

   /** helper method to print Leap year answer in main 
    * without using conditionals to clutter up main
    */ 

   public static String leapYearString(int year){
      if (isLeapYear(year)){
         return "yes"; 
      }
      else {
         return "no"; 
      }
   }

   /** checks how many days are in month -- 
    * good for user validation and finding the next 
    * valid day to use for the next date 
    */ 

   public static int daysInMonth(boolean leap, int month){
      if (month < 1 || month > 12){
         return -1; 
      }
      else {
         if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            return 31; 
         }
         else if (month == 2 && leap){
            return 29; 
         }
         else {
            return 30; 
         }
      }
   }

   /** checks whether certain date is valid -- 
    * used several times in other methods for 
    * user validation
    */ 

   public static boolean isValid(int month, int day, int year){
      if (year < 0){
         return false; 
      }
      else if (month < 1 || month > 12){
         return false; 
      }
      else if (month == 2 && day > 28 && !isLeapYear(year)){
         return false; 
      }
      else if (day < 1 || day > 31){
         return false; 
      }
      else if (day > daysInMonth(isLeapYear(year),month)){
         return false; 
      }
      else {
         return true; 
      }
   }

   /** checks to see how many days are remaining 
    * in a year, including the current day, and 
    * returns -1 if date is invalid
    */ 
   public static int daysRemaining(int month, int day, int year){
      int daysSpent = 0;
      if (!isValid(month,day,year)){
         return -1; 
      } 
      else if (isLeapYear(year)){
         for (int i = 1; i < month; i++){
            daysSpent += daysInMonth(true,i);
         }
         daysSpent += day - 1;
         return 366 - daysSpent;  
      }
      else {
         for (int i = 1; i < month; i++){
            daysSpent += daysInMonth(false,i);
         }
         daysSpent += day - 1;
         return 366 - daysSpent + 1;
      }
   }


   /** Implemented "Gaussian Algorithm", Disparate Version on Wikipedia 
    * https://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week#Gauss.27s_algorithm
    */
   public static int dayOfWeek(int month, int day, int year){
      if (month <= 2){
         year--; 
      }
      month = shiftMonths(month); 
      int y = year % 100; 
      int c = year / 100; 
      int dow = (int) ((day + Math.floor(2.6 * month - 0.2) + y + Math.floor(y/4) + Math.floor(c/4) - (2*c)) % 7); 
      if (dow < 0){
         dow += 7; 
      }
      return dow; 
   }

   /** helper method to shift months for 
    * dayOfWeek with Gauss's method
    */ 
   public static int shiftMonths(int month){
      switch (month){
         case 1: return 11; 
         case 2: return 12; 
         case 3: return 1; 
         case 4: return 2; 
         case 5: return 3; 
         case 6: return 4; 
         case 7: return 5; 
         case 8: return 6; 
         case 9: return 7; 
         case 10: return 8; 
         case 11: return 9; 
         case 12: return 10; 
         default: return -1; 
      }
   }

   /** switch statements do NOT need break statements
    * when every case statement is a return, because 
    * return exits the statement and function, and so will never
    * reach the breaks anyway, as long as every possibility is down, 
    * including a default
    * 
    * below two methods just match integers to 
    * names of days or months for printing use 
    */ 

   public static String getDayName(int day){
      switch (day){
         case 0: return "Sunday"; 
         case 1: return "Monday"; 
         case 2: return "Tuesday"; 
         case 3: return "Wednesday";
         case 4: return "Thursday"; 
         case 5: return "Friday"; 
         case 6: return "Saturday";
         default: return "ERROR"; 
      }
   }

   public static String getMonthName(int month){
      switch (month){
         case 1: return "January"; 
         case 2: return "February"; 
         case 3: return "March"; 
         case 4: return "April"; 
         case 5: return "May"; 
         case 6: return "June"; 
         case 7: return "July"; 
         case 8: return "August"; 
         case 9: return "September"; 
         case 10: return "October"; 
         case 11: return "November"; 
         case 12: return "December"; 
         default: return "ERROR"; 
      }
   }

   /** below two methods encase the printing of a 
   * formatted date in a method for easy use, 
   * return "ERROR" if the date is not valid 
   */

   public static String dateString(int month, int day, int year){
      if (isValid(month,day,year)){
         return getDayName(dayOfWeek(month,day,year)) + ", " + getMonthName(month) + " " + day + ", " + year; 
      }
      else {
         return "ERROR"; 
      }
   }

   public static String nextDateString(int month, int day, int year){
      day++; 
      if (isValid(month,day,year)){
         return dateString(month,day,year); 
      }
      else if (month==12 && day == 32){
         day = 1; 
         month = 1; 
         year ++; 
         return dateString(month,day,year); 
      }
      else if (isValid(month+1,1,year)){
         return dateString(month+1,1,year); 
      }
      else {
         return "ERROR"; 
      }
   }

}// end class 
