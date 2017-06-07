package project_one_src;

import java.io.FileNotFoundException;
import java.util.GregorianCalendar; // for making anonymous Appointments easily
import java.util.Scanner; 

/**
 * Class to test the myriad of classes throughout this 
 * Appointment-themed project 
 * CSE 271, B
 * @author Wallisan
 * Instructor: Dr. Stephan 
 * 3/10/17
 */
public class AppointmentsTester {

	public static void main(String[] args) throws FileNotFoundException {
		// make some AppointmentBooks to use 
		AppointmentBook myBook = new AppointmentBook(); 
		AppointmentBook bookToLoadTo = new AppointmentBook(); 
		AppointmentBook officialTestBook = new AppointmentBook(); 
		
		// shortly testing toString, Appointments, load, save, etc. 
		Daily eat = new Daily("Eat",1998,7,9);  
		myBook.add(eat.getAppointmentType(), eat.getDescription(), eat.getCalendar());
		myBook.add(AppointmentType.ONETIME, "Get some $ from the rich debtor; he owes me 15 #### %!", new GregorianCalendar(2017,2,2));
		AppointmentBook.save(myBook.getAppointment(0), "testy");
		bookToLoadTo.load("testy");
		System.out.println("Testing toString with \'eat\' Daily Appointment:");
		System.out.println(myBook.getAppointment(0) + "\n");
		System.out.println("Print eat Appointment which was saved statically to testy.txt,\nthen loaded onto a fresh AppointmentBook from that file:");
		System.out.println(bookToLoadTo.getAppointment(0) + "\n");
		
		System.out.println("*************OFFICAL TESTING TIME; INPUT INCOMING*************\n");
		
		// a little cache of various Appointments to use in the real mandated test 
		Monthly getPaycheck = new Monthly("Get your hard-earned monies, boi!",2016,1,15); 
		Monthly band = new Monthly("Play with your bomb rock band!",2010,4,10); 
		Onetime talk = new Onetime("Talk to the bro!",2017,1,15); 
		Onetime turnIn = new Onetime("Turn in your PROJECT, WALTER!!!",2017,3,10); 
		Daily cry = new Daily("Cry...\'cause that\'s what you do.",1998,7,9); 
		// real testing involving user input 
		// add some Appointments
		officialTestBook.add(getPaycheck.getAppointmentType(), getPaycheck.getDescription(), getPaycheck.getCalendar());
		officialTestBook.add(eat.getAppointmentType(),eat.getDescription(),eat.getCalendar());
		officialTestBook.add(band.getAppointmentType(),band.getDescription(), band.getCalendar());
		officialTestBook.add(talk.getAppointmentType(),talk.getDescription(),talk.getCalendar());
		officialTestBook.add(cry.getAppointmentType(),cry.getDescription(),cry.getCalendar());
		officialTestBook.add(turnIn.getAppointmentType(),turnIn.getDescription(),turnIn.getCalendar());
		// create Scanner, do user interaction and grab date pieces
		Scanner user = new Scanner(System.in); 
		System.out.println("Enter a date, and we'll show you the stored Appointments in officialTestBook\nwhich occur on that day.");
		System.out.print("Month: ");
		String month = user.nextLine(); 
		System.out.print("Day of month: ");
		String dayOfMonth = user.nextLine(); 
		System.out.print("Year: ");
		String year = user.nextLine(); 
		user.close();// gotta close those pesky Scanners, tell you huwhat
		// loop through all the Appointments; if applicable, print it out 
		System.out.println("All found Appointments (if blank, none found):\n");
		for (int i = 0; i < officialTestBook.getAmountAppointments();i++){
			if (officialTestBook.getAppointment(i).occursOn(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(dayOfMonth))){
				System.out.println(officialTestBook.getAppointment(i)+"\n");
			}
		}
		System.out.println("END");
		
	}
}// end AppointmentsTester class 
