package lab_two_src;

import java.util.Scanner; 
import java.util.InputMismatchException; 

public class Lab2FloatingPoint {

	public static void main(String[] args) {
		Scanner user = new Scanner(System.in); 
		float newNum = 0; 
		float endSum = 0; 
		int badConsecutiveInputs = 0; 
		
		// explain situation, then ask for input until too many errors
		System.out.println("Give some floating point numbers to be added."); 
		System.out.println("The program will exit if you enter two invalid members in a row.");
		while (badConsecutiveInputs < 2) {
			System.out.print("New input: ");
			try {
				// try to store new float,
				// if successful, messups are reset and 
				// new float add; otherwise, follow catch 
				newNum = user.nextFloat(); 
				badConsecutiveInputs = 0; 
				endSum += newNum; 
			} catch (InputMismatchException e) {
				// alert to input error, add to messups 
				System.out.println("Invalid input!");
				badConsecutiveInputs++; 
			} finally {
				// fix the infinite "can't enter input" problem
				user.nextLine();
			}
		}
		System.out.println("Your total: " + endSum);
		
		user.close();
	}// end main 

}// end Lab2FloatingPoint class 
