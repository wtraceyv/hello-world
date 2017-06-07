package lab_five_src;

/**
 * class to model an Instructor, logically inheriting from Person 
 * @author Wallisan
 * 2/24/2017
 * Instructor: Dr. Stephan 
 * CSE 271, B
 */
public class Instructor extends Person {

	private int salary; 
	
	public Instructor(String name, String yearOfBirth, int salary) {
		super(name, yearOfBirth);
		setSalary(salary); 
	}
	
	/**
	 * smart set int salary of Instructor object 
	 * @param salary
	 */
	public void setSalary(int salary){
		// no one earns $10,000,000 salaries
		if (salary > 0 && salary < 10000000){
			this.salary = salary; 
		} else {
			this.salary = 0; 
		}
	}
	
	/**
	 * @return salary int of current Instructor object 
	 */
	public int getSalary(){
		return this.salary; 
	}
	
	/**
	 * Override toString from Person to be more specific, 
	 * but utilize super's to be more concise 
	 */
	public String toString(){
		return super.toString() + "I'm also an instructor. My salary happens to be " + 
				Integer.toString(this.salary) + " units per year.\n"; 
	}

}// end Instructor class 
