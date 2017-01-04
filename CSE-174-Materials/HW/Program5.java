/* Walter Tracey
* Instructor: Vijayalakshmi Ramasamy
* 2 October 2016
* CSE 174, Section C
*/

// class to parse and display properly
// user-input of a certain format
// including address, phone number, name, etc

//  //  //  //  //  TEST CASES //  //  //  //  //  //  //  //  //
// Some names with results:
// "     SMIth  ,  mARy  JeaN" ---> Mary J. Smith
// "  hart, sAMANTHA     jO" ---> Samantha J. Hart
// "Al-Asad, riJAH   maHMOUD" ---> Rijah M. Al-asad
// Phone numbers tested:
// "59 2- 29 1-   6789" ---> (592)291-6789
// "654- 4  8 5 -44 59" ---> (654)485-4459
// "    41 2- 412 -   4 567" ---> (412)412-4567
// Addresses tested:
// "45676 Looloo Avenue, Apt. 74, Greenville, Indiana 47003" --->
// 45676 Looloo Avenue, Apt. 74
// Greenville, Indiana 47003
// "12 Patterson Boulevard, New York City, New York 30472" --->
// 12 Patterson Boulevard
// New York City, New York 30472
// "345432 Blah Street, Blahblahville, Ohio 543789" --->
// 345432 Blah Street
// Blahblahville, Ohio 543789

import java.util.Scanner; // 'cause errbody need a Scanner

public class Program5 {
   public static void main (String[] args){

      Scanner user = new Scanner(System.in); // gotta have my OWN scanner

      // catch values, prepare for parsing, or go ahead and parse
      System.out.print("Name: ");
      String name = removeSpaces(user.nextLine());
      System.out.print("Phone: ");
      String phoneNumber = user.nextLine().replaceAll("\\D+",""); // phone number is basically parsed
      System.out.print("Address: ");
      String address = removeSpaces(user.nextLine());
      System.out.println();

   /** NAME PARSING */

      // declare needed strings to parse name
      String lastName;
      String restOfName;
      String firstName;
      String middleName;

      // to account for the area around the only comma
      lastName = name.substring(0,name.indexOf(",") + 1);
      if (Character.toString(lastName.charAt(lastName.length() - 1)).equals(",")){
         lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1,name.indexOf(",")).toLowerCase();
      }
      else {
         lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1,name.indexOf(" ")).toLowerCase();
      }

      // chop original down, use remains to gather other two names
      restOfName = name.substring(name.indexOf(",") + 1,name.length());
      restOfName = removeSpaces(restOfName);
      firstName = restOfName.substring(0,restOfName.indexOf(" "));
      firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1,firstName.length()).toLowerCase();

      restOfName = restOfName.substring(firstName.length(),restOfName.length());
      restOfName = removeSpaces(restOfName);
      middleName = restOfName.substring(0,restOfName.length());
      middleName = middleName.substring(0,1).toUpperCase() + ".";


      /** ADDRESS PARSING */


      // "if" block accounts for possibility of an apartment number
      String streetAddress;
      if (countOccurrences(address,",") == 3) {
         streetAddress = address.substring(0,address.indexOf(","));
         String apartmentNumber;
         String addressCopy = address; // to cut down into apartment # without losing ends
         addressCopy = addressCopy.substring(0,addressCopy.lastIndexOf(","));
         addressCopy = addressCopy.substring(0,addressCopy.lastIndexOf(","));
         addressCopy = addressCopy.substring(addressCopy.indexOf(",") + 1,addressCopy.length());
         apartmentNumber = addressCopy;
         streetAddress += "," + apartmentNumber;
      }
      else {
         streetAddress = address.substring(0,address.indexOf(",") );
      }

      // just copy original address and cut down to last section
      String lastAddressChunk = address.substring(streetAddress.length(), address.length());
      lastAddressChunk = lastAddressChunk.substring(2,lastAddressChunk.length());

      /** PRINT THINGS */

      System.out.println("***** Results *****");
      System.out.println(firstName + " " + middleName + " " + lastName);
      System.out.println("(" + phoneNumber.substring(0,3) + ")" + phoneNumber.substring(3,6) + "-" + phoneNumber.substring(6,phoneNumber.length()));
      System.out.println(streetAddress);
      System.out.println(lastAddressChunk);

   } // end main

   /**
    * custom class to cutoff whitespace where needed
    *
    * @return new String without spaces
    */
   public static String removeSpaces(String fragment){
      while (fragment.substring(0,1).equals(" ")){
         fragment = fragment.substring(1,fragment.length());
      }
      return fragment;
   }// cuts front-end white space off a String; don't forget to ASSIGN STRING AGAIN to use!

   /**
    * counts chars to see how many words/sections
    * will need to be parsed
    *
    * @return int however many occurences of the char are found
    */
   public static int countOccurrences(String string, String target){
      int occurrences = 0;
      for (int i = 0; i < string.length(); i++){
         if (Character.toString(string.charAt(i)).equals(target)){
            occurrences++;
         }
      }
      return occurrences;
   }
} // end class
