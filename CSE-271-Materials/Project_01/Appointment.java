package project_one_src;

import java.util.GregorianCalendar; 

/**
 * abstract class to define and/or mandate the basic 
 * attributes and behaviors of any of the extended 
 * AppointmentTypes  
 * CSE 271, B
 * @author Wallisan
 * Instructor: Dr. Stephan 
 * 3/10/17
 */
public abstract class Appointment {
	
	// required instance vars of any Appointment 
	private String description; 
	private GregorianCalendar calendar; 
	
	public Appointment(String description, int year, int month, int dayOfMonth){
		setDescription(description);  
		setCalendar(year,month,dayOfMonth); 
	}
	
	/**
	 * All types of Appointment must give own implementation for
	 * checking if Appointment object occurs on given date 
	 * @param year
	 * @param month
	 * @param day
	 * @return whether Appoinment object occurs on given date 
	 */
	public abstract boolean occursOn(int year, int month, int day);

	/**
	 * Smart set Appointment object's description; 
	 * will automatically replace necessary parsing symbols $,#,% so parsing isn't 
	 * messed up by those symbols being in the description  
	 * @param description
	 */
	public void setDescription(String description){
		// can't go on if String is null 
		if (description!=null && description.length()!=0){
			// loop through, taking any potential mess-up chars out 
			// and replacing with some reasonable placeholder 
			while (description.contains("$")){
				description = description.substring(0,description.indexOf("$")) + "[money]" + description.substring(description.indexOf("$")+1);
			}
			while (description.contains("#")){
				description = description.substring(0,description.indexOf("#")) + "[number]" + description.substring(description.indexOf("#")+1);
			}
			while (description.contains("%")){
				description = description.substring(0,description.indexOf("%")) + "[percent]" + description.substring(description.indexOf("%")+1);
			}
			this.description = description; 
		} else {
			this.description = "Some activity"; 
		}
	}
	
	/**
	 * @return this Appointment instance's description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * smart set calendar of type GregorianCalendar 
	 * * * * * * * * * * MAKE SMARTER? BETTER OBJECT MANIPULATION * *
	 * Leniency is explained in second header of Calendar java SE 8 API; 
	 * its throwing exceptions will help validate given dates.  
	 * 'hopeful.getTime()' forces java to do a computation, which actually 
	 * throws the Exception (Calendar will not throw the Exception, or correct 
	 * the date when leniency is true, until an impossible calculation 
	 * is encountered) 
	 * @param year
	 * @param month
	 * @param day
	 */
	public void setCalendar(int year, int month, int day){
		try{
			GregorianCalendar hopeful = new GregorianCalendar(year,month,day); 
			hopeful.setLenient(false);
			hopeful.getTime(); 
		} catch (Exception e){
			System.out.println("No valid date for Appointment, none made.");
		}
		// if flow makes it down here, date should be valid 
		this.calendar = new GregorianCalendar(year,month,day); 
	}
	
	/**
	 * @return GregorianCalendar type set at whatever Appointment's time is set to 
	 */
	public GregorianCalendar getCalendar(){
		return this.calendar; 
	}
	
	/**
	 * Every Appointment must provide its AppointmentType 
	 * through this method (base Appointment does not have a type; 
	 * must be abstract) 
	 * @return the AppointmentType of this Appointment instance 
	 * (from AppointmentType enum) 
	 */
	public abstract AppointmentType getAppointmentType();
	
	/**
	 * Override toString() to better represent an Appointment and 
	 * its pertinent information
	 */
	@Override
	public String toString(){
		return "Appointment to:\n" + this.description + "\nOn: " + 
				calendar.get(GregorianCalendar.MONTH) + "/" + 
				calendar.get(GregorianCalendar.DAY_OF_MONTH) + "/" + 
				calendar.get(GregorianCalendar.YEAR); 
	}
	
}// end Appointment abstract class 
