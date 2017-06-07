package project_one_src;

import java.util.GregorianCalendar;

/**
 * class representation of a Monthly Appointment, 
 * extended from abstract Appointment 
 * CSE 271, B
 * @author Wallisan
 * Instructor: Dr. Stephan 
 * 3/10/17
 */
public class Monthly extends Appointment {

	public Monthly(String description, int year, int month, int dayOfMonth) {
		super(description, year, month, dayOfMonth);
	}

	/**
	 * Determine whether this Appointment occurs on the given date
	 * @return true if given date is part of the set of days
	 * designated part of this monthly appointment 
	 */
	public boolean occursOn(int year, int month, int day){
		if (day==this.getCalendar().get(GregorianCalendar.DAY_OF_MONTH) &&
				(this.getCalendar().before(new GregorianCalendar(year,month,day)) || 
						this.getCalendar().equals(new GregorianCalendar(year,month,day)))){
			return true; 
		}
		return false; 
	}
	
	/**
	 * @return this Appointment's AppointmentType 
	 */
	@Override
	public AppointmentType getAppointmentType() {
		return AppointmentType.MONTHLY; 
	}
	
	/**
	 * Override toString() to better represent this AppointmentType 
	 */
	public String toString(){
		return super.toString() + "\n*Monthly, established this date*"; 
	}

}// end Monthly class 
