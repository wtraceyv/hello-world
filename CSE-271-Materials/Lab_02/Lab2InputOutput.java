package lab_two_src;

import java.util.Scanner; 
import java.io.*; 

/**
 * 2 February, 2017
 * CSE 271, Sec. B 
 * @author Walter Tracey 
 * Instructor: Dr. Stephan
 */

// class to use command line args (a file) 
// and output a modified version of it with name
// of user's choice 

public class Lab2InputOutput {

	public static void main(String[] args) throws FileNotFoundException {
		// grabbing, preparing file name before operations
		Scanner user = new Scanner(System.in); // 'cause errbody need a Scanner
		Scanner doc = new Scanner(new File(args[0])); // for reading file 
		System.out.print("Under what file name would you like your output?");
		String fileName = user.next(); 
		PrintWriter pen = new PrintWriter(new File(fileName + ".txt")); 
		
		// scan through given doc, output mods 
		// in new file 
		int lineNumber = 1; 
		while (doc.hasNextLine()) {
			pen.write("/* " + lineNumber + " */ " + doc.nextLine());
			lineNumber++; 
		}
		
		// close everything safely 
		user.close();
		doc.close();
		pen.close();
	}// end main 

}// end Lab2InputOutput class 
