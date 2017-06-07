package lab_five_src;

/**
 * class to model a Person, from which some other 
 * classes will extend logically  
 * @author Wallisan
 * 2/24/2017
 * Instructor: Dr. Stephan 
 * CSE 271, B
 */
public class Person {
	
	private String name; 
	private String yearOfBirth; 
	
	// one constructor 
	public Person(String name, String yearOfBirth){
		setName(name); 
		setYearOfBirth(yearOfBirth); 
	}
	
	/**
	 * smart set Person name 
	 * @param name
	 */
	public void setName(String name){
		if (name!=null && name.length()!=0){
			this.name = name; 
		}
		else {
			this.name = "No-name"; 
		}
	}
	
	/**
	 * @return name of Person object 
	 */
	public String getName(){
		return this.name; 
	}
	
	/**
	 * smart set year of birth 
	 * @param year
	 */
	public void setYearOfBirth(String year){
		if (((year.substring(0,1).equals("1") && year.substring(1,2).equals("9")) || 
				(year.substring(0,1).equals("2") && year.substring(1, 0).equals("0"))) 
				&& year.length()==4){
			this.yearOfBirth = year; 
		}
		else {
			this.yearOfBirth = "Unknown or godly year of birth"; 
		}
	}
	
	/**
	 * @return String of year of birth of Person object 
	 */
	public String getYearOfBirth(){
		return this.yearOfBirth;
	}
	
	/**
	 * Override toString() method to represent Person object 
	 */
	@Override 
	public String toString(){
		return "I'm a person! My name is " + this.name + ", and "
				+ "I was born in " + this.yearOfBirth + ".\n";  
	}
}
