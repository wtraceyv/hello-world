package lab_five_src;

/**
 * class to model a Student, which logically extends Person
 * @author Wallisan
 * 2/24/2017
 * Instructor: Dr. Stephan 
 * CSE 271, B
 */
public class Student extends Person{
	
	private String major; 

	public Student(String name, String yearOfBirth, String major){
		super(name, yearOfBirth); 
		setMajor(major); 
	}
	
	/**
	 * smart set Student object's major String 
	 * @param major
	 */
	public void setMajor(String major){
		if (major!=null && major.length()!=0){
			this.major = major; 
		} else {
			this.major = "undeclared major"; 
		}
	}
	
	/**
	 * @return major String for this Student object
	 */
	public String getMajor(){
		return this.major; 
	}
	
	/**
	 * Override toString(), but utilize Person.toString() 
	 * to keep things concise (with super.toString()) 
	 */
	@Override 
	public String toString(){
		return super.toString() + "I'm also a student, my major being " + this.major + ".\n"; 
	}

}// end Student class
