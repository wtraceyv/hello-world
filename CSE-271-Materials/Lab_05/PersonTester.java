package lab_five_src;

/**
 * Class to test Person class and some classes which 
 * inherit from it (3 class to test)  
 * @author Wallisan
 * 2/24/2017
 * Instructor: Dr. Stephan 
 * CSE 271, B
 */
public class PersonTester {

	public static void main(String[] args) {
		// test Person constructor
		Person guyOnStreet = new Person("Hank Hill", "1956");
		System.out.println("Person name should be Hank Hill and year of birth, 1956.");
		System.out.println("Name: " + guyOnStreet.getName() + "\nYear of birth: " + guyOnStreet.getYearOfBirth());
		// test toString() of Person
		System.out.println("toString() should print:\nI'm a person! My name is Hank Hill, and "
				+ "I was born in 1956.\nActually prints:");
		System.out.println(guyOnStreet);// implicitly tests toString()
		
		// test Student constructor/methods
		Student me = new Student("Walter Tracey", "1998", "Computer Domination"); 
		System.out.println("Student name should be Walter Tracey and year of birth, 1998. Major is Computer Domination.");
		System.out.println("Name: " + me.getName() + "\nYear of birth: " +me.getYearOfBirth() +
				"\nMajor: " + me.getMajor());
		// test toString() of Student
		System.out.println("toString() should print:\nI'm a person! My name is Walter Tracey, and "
				+ "I was born in 1998.\nI'm also a student, my major being Computer Domination.\nActually prints:");
		System.out.println(me);// implicitly tests toString()
		
		// test Instructor constructor/methods
		Instructor harden = new Instructor("Myron Harden","1958",30000); 
		System.out.println("Instructor name should be Myron Harden and year of birth, 1958. Salary is 30000.");
		System.out.println("Name: " + harden.getName() + "\nYear of birth: " +harden.getYearOfBirth() +
				"\nSalary: " + harden.getSalary());
		// test toString() of Instrutor
		System.out.println("toString() should print:\nI'm a person! My name is Myron Harden, and "
				+ "I was born in 1958.\nI'm also an instructor. My salary happens to be 30000 units per year.\nActually prints:");
		System.out.println(harden);// implicitly tests toString()
	}

}// end PersonTester class 
