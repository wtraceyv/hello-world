package project_one_src;
 
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar; 
import java.util.Scanner; 
import java.io.*;

/**
 * Class to represent a holder of Appointments, which includes 
 * some of its own methods such as saving one of its stored 
 * Appointments to a file or loading it back into this list.  
 * CSE 271, B
 * @author Wallisan
 * Instructor: Dr. Stephan 
 * 3/10/17
 */
public class AppointmentBook {

	// instance collection of Appointments 
	private ArrayList<Appointment> appointments; 
	
	public AppointmentBook(){
		// always start empty anyway; no modifying, setter
		this.appointments = new ArrayList<Appointment>(); 
	}
	
	/**
	 * Add an appointment type of given desc/topic and date
	 * to ArrayList of appointments in this AppointmentBook
	 * @param type, type of Appointment to add 
	 * @param description, desc attached to the Appointment
	 * @param year, year of Appointment's establishment
	 * @param month, month of Appointment's establishment 
	 * @param dayOfMonth, day of Appointment's establishment 
	 */
	public void add(AppointmentType type, String description, GregorianCalendar establishingDate){
		int year = establishingDate.get(Calendar.YEAR); 
		int month = establishingDate.get(Calendar.MONTH); 
		int dayOfMonth = establishingDate.get(Calendar.DAY_OF_MONTH); 
		switch(type){
			case ONETIME: 
				appointments.add(new Onetime(description,year,month,dayOfMonth)); 
				break; 
			case DAILY: 
				appointments.add(new Daily(description,year,month,dayOfMonth)); 
				break; 
			case MONTHLY: 
				appointments.add(new Monthly(description,year,month,dayOfMonth)); 
				break;
		}
	}// end add method
	
	/**
	 * Get Appointment at specified index of AppointmentBook 
	 * @param index desired within AppointmentBook list of Appointments
	 * @return the found Appointment at given index 
	 */
	public Appointment getAppointment(int index) throws IllegalArgumentException{
		return appointments.get(index); 
	}
	
	/**
	 * Get number of Appointments amassed in this AppointmentBook
	 * using size() method of array that holds them  
	 * @return amount of Appointments, number of Appointment objects 
	 * this AppointmentBook has amassed/stored 
	 */
	public int getAmountAppointments(){
		return appointments.size();
	}
	
	/**
	 * Save given appointment to a file with the given name (always text file) 
	 *   
	 * First paragraph of Part 3 explanation says "...having a method in the AppointmentBook 
	 * class that saves a specific SINGLE Appointment's data to a provided file AND a 
	 * separate method to load an Appointment's data..." etc. 
	 * In the next paragraph, it simply explains, "...save that takes in 
	 * any Appointment and file (or file location)...save the type, description, 
	 * and date to a file." 
	 * My assumption is that save() saves specifically one Appointment 
	 * to one file; there is nothing preventing another save on a file 
	 * from simply overwriting, because there was great ambiguity 
	 * regarding whether or not multiple Appointments should be able 
	 * to be saved to one file without overwriting, and generally 
	 * it is less cumbersome and more clear to just allow overwriting.
	 * 
	 * This save() method takes in the String form of a file save name, 
	 * and adds the .txt extension every time automatically, since 
	 * the file is for the program's use and not the user's (so the 
	 * extension should not be a pertinent decision for the user) 
	 * 
	 * @param app, appointment object to save 
	 * @param fileSaveName, name of file to save; will be saved w/ .txt extension added 
	 */
	public static void save(Appointment app, String fileSaveName) throws FileNotFoundException{
		// convert, add to a file
		PrintWriter pen = new PrintWriter(fileSaveName+".txt"); 
		String encoded = encodeAppointment(app); 
		pen.print(encoded+"\n");
		pen.close();
	}
	
	/**
	 * Find the file whose name (without extension) matches that in the given String, 
	 * and if found load that now-translated Appointment (add it to) into 
	 * the appointments list of the AppointmentBook instance load() is called on. 
	 * 
	 * Works, along with save(), under the assumption that only one Appointment 
	 * will ever be saved in one file each. 
	 * 
	 * @param fileLoadName, String form (without extension) of an already-saved 
	 * file from which to load into the AppointmentBook list of Appointments 
	 * the Appointment saved at that location 
	 */
	public void load(String fileLoadName){
		try{
			Scanner in = new Scanner(new File(fileLoadName+".txt")); 
			in.useDelimiter("\n"); 
			String appLine = ""; 
			while (in.hasNext()){
				appLine = in.next(); 
			}
			in.close();
			Appointment endAppointment = decodeSavedAppointment(appLine); 
			this.add(endAppointment.getAppointmentType(), endAppointment.getDescription(), endAppointment.getCalendar());
		} catch (FileNotFoundException e){
			System.out.println("File could not be found!\nNo Appointment loaded.");
		}
	}
	
	/**
	 * Encode the given Appointment so that it can be easily stored 
	 * in a file by save() and translated back into an Appointment 
	 * instance later to be represented in human-readable form again. 
	 * Encoding guide: 
	 * $: an Appointment begins now 
	 * Type is next; O,M,or D for onetime, monthly, or daily 
	 * Desc is next, unfiltered 
	 * # marker ends description 
	 * date is coded as "YEAR-MONTH-DAY", however Calendar stores it
	 * Appointment ends with a % 
	 * @param toConvert
	 * @return
	 */
	private static String encodeAppointment(Appointment toConvert){
		// establish type marker to use in encoding String 
		String typeMarker;
		if (toConvert.getAppointmentType()==AppointmentType.DAILY){
			typeMarker = new String("D"); 
		} else if (toConvert.getAppointmentType()==AppointmentType.MONTHLY){
			typeMarker = new String("M"); 
		} else {
			typeMarker = new String("O"); 
		}
		// return encoded String 
		return "$" + typeMarker + toConvert.getDescription()+"#"+ 
		toConvert.getCalendar().get(Calendar.YEAR) + "-" + 
		toConvert.getCalendar().get(Calendar.MONTH) + "-" + 
		toConvert.getCalendar().get(Calendar.DAY_OF_MONTH) + 
		"%"; 
	}
	
	/**
	 * Decode the String representation of an Appointment stored in a file
	 * that the load method is requesting to load from, return the 
	 * Appointment representation of it so load can add it to the appointments
	 * list of this AppointmentBook 
	 * @param encodedApp, the String that would be stored in a file and 
	 * found through load(), which is the raw form of the Appointment 
	 * to be translated back into an actual Appointment instance to 
	 * add to appointments field of this AppointmentBook 
	 * @return the Appointment instance representation of the appointment 
	 * String stored in the file from which the load() method is trying to load 
	 */
	private Appointment decodeSavedAppointment(String encodedApp){
		// end var to return, vars to hold its aggregated values before construction
		Appointment recovered; 
		AppointmentType currentTypeSaving = AppointmentType.DAILY; // just as default 
		String extractedDesc = ""; 
		encodedApp = encodedApp.substring(1); 
		
		// match and store correct AppointmentType 
		if (encodedApp.substring(0,1).equals("O")){
			currentTypeSaving = AppointmentType.ONETIME; 
		} else if (encodedApp.substring(0,1).equals("M")){
			currentTypeSaving = AppointmentType.MONTHLY; 
		} 
		encodedApp = encodedApp.substring(1); 
		
		// extract description 
		extractedDesc = encodedApp.substring(0, encodedApp.indexOf("#")); 
		encodedApp = encodedApp.substring(encodedApp.indexOf("#")+1); 
		
		// now parse for date numbers 
		// vars to grab pieces of Calendar (Strings so I can jump easily through): 
		String year = ""; 
		String month = ""; 
		String dayOfMonth = ""; 
		year = encodedApp.substring(0,encodedApp.indexOf("-")); 
		encodedApp = encodedApp.substring(encodedApp.indexOf("-")+1); 
		month = encodedApp.substring(0,encodedApp.indexOf("-"));
		encodedApp = encodedApp.substring(encodedApp.indexOf("-")+1);
		dayOfMonth = encodedApp.substring(0,encodedApp.indexOf("%"));
		
		// construct and return Appointment object 
		if (currentTypeSaving==AppointmentType.DAILY){
			recovered = new Daily(extractedDesc,Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(dayOfMonth)); 
		} else if (currentTypeSaving==AppointmentType.MONTHLY){
			recovered = new Monthly(extractedDesc,Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(dayOfMonth));
		} else {
			recovered = new Onetime(extractedDesc,Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(dayOfMonth));
		}
		return recovered;
	}// end super long decoding method 
	
}// end class AppointmentBook 
