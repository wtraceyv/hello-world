package project_one_src;

import java.util.GregorianCalendar; 

/**
 * class representation of a Daily Appointment, 
 * extended from abstract Appointment 
 * CSE 271, B
 * @author Wallisan
 * Instructor: Dr. Stephan 
 * 3/10/17
 */
public class Daily extends Appointment {

	public Daily(String description, int year, int month, int dayOfMonth) {
		super(description, year, month, dayOfMonth);
	}

	/**
	 * Determine whether this Appointment occurs on the given date 
	 * @return true if parameterized date is on calendar daily and therefore
	 * valid, or if date is on any other day after that (since its daily starting 
	 * from the instantiated Daily date), false if parameterized date comes 
	 * before the instantiated (so the Daily Appointment was not established yet)
	 */
	public boolean occursOn(int year, int month, int day){
		if (this.getCalendar().before(new GregorianCalendar(year,month,day)) || 
			this.getCalendar().equals(new GregorianCalendar(year,month,day))){
				return true; 
		}
		return false; 
	}
	
	/**
	 * @return this Appointment's AppointmentType 
	 */
	public AppointmentType getAppointmentType(){
		return AppointmentType.DAILY; 
	}
	
	/**
	 * Override toString() to better represent this AppointmentType 
	 */
	public String toString(){
		return super.toString() + "\n*Daily, established on above date*"; 
	}
}
