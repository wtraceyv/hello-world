package project_one_src;

import java.util.GregorianCalendar;

/**
 * representation of a Onetime Appointment, 
 * extends from abstract Appointment 
 * CSE 271, B
 * @author Wallisan
 * Instructor: Dr. Stephan 
 * 3/10/17
 */
public class Onetime extends Appointment{
	
	public Onetime(String description, int year, int month, int dayOfMonth){
		super(description, year, month, dayOfMonth); 
	}
	
	/**
	 * Determine whether this Appointment occurs on the given date
	 * @return true if the appointment does occur on the exact given date
	 */
	public boolean occursOn(int year, int month, int day){
		if (!this.getCalendar().equals(new GregorianCalendar(year,month,day))){
			return false; 
		}
		return true; 
	}
	
	/**
	 * @return this Appointment's AppointmentType 
	 */
	@Override
	public AppointmentType getAppointmentType(){
		return AppointmentType.ONETIME;
	}
	
	/**
	 * Override toString() to better represent this AppointmentType 
	 */
	public String toString(){
		return super.toString() + "\n*Onetime; only occurs on this specific date*"; 
	}
}
