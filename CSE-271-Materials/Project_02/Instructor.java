package edu.miamioh.traceywd;

import java.util.ArrayList;

/**
 * Class to model a university Instructor, extended 
 * from Person and accordingly with a list of Courses 
 * to teach, ability to change Student grades, etc. 
 * No taughtCourses setter since the AdminStaff is the entity 
 * meant to assign Instructors to Courses when need be; it is 
 * simply initialized as empty in the constructor. 
 * CSE 271, B
 * @author Walter Tracey 
 * Instructor: Dr. Stephan
 * 3/28/2017
 */
public class Instructor extends Person {

	private ArrayList<Course> taughtCourses; 
	private int salary; 
	
	public Instructor(String email, String ID, int salary) {
		super(email, ID); 
		taughtCourses = new ArrayList<Course>(); 
		setSalary(salary); 
	}
	
	/**
	 * Change the given Student's endGPA var to a new desired GPA.
	 * Private to preserve the idea that only Instructors should be 
	 * allowed to change Student grades (even though the setting method 
	 * in the Student class is public because that's the logical 
	 * way to do it at the moment).
	 * @param toGrade
	 * @param newGPA
	 */
	private void changeStudentGPA(Student toGrade, double newGPA){
		toGrade.setEndGPA(newGPA);
	}
	
	/**
	 * Get this Instructor instance's salary
	 * @return salary, this Instructor's salary 
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * Smart set this Instructor's salary (can't be less than 
	 * 5000 or greater than 5000000 dollars) 
	 * @param salary, the desired salary 
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	 * Get the ArrayList object holding the list of Courses this 
	 * Instructor has been assigned to teach. 
	 * @return taughtCourses, the ArrayList representing the list of 
	 * Courses this Instructor has been assigned to teach. 
	 */
	public ArrayList<Course> getTaughtCourses() {
		return taughtCourses;
	}
	
	/**
	 * Add given Course to list of Courses taught by this Instructor.
	 * To be used/assigned by an AdminStaff. 
	 * @param toTeach, the Course scheduled to be taught by this Instructor.
	 */
	public void addCourseToTeach(Course toTeach){
		this.taughtCourses.add(toTeach); 
	}

}
