package edu.miamioh.traceywd;

import java.util.ArrayList;

/**
 * Class to model a Student, extending from Person, 
 * who can have a list of courses to take, a major to accomplish, 
 * and an "endGPA", or cumulative semester GPA granted 
 * by an Instructor. 
 * CSE 271, B
 * @author Walter Tracey 
 * Instructor: Dr. Stephan
 * 3/28/2017
 */
public class Student extends Person {
	
	private String major; 
	private ArrayList<Course> courses; 
	private double endGPA; 

	public Student(String email, String ID, String major, double endGPA) {
		super(email, ID); 
		setMajor(major); 
		setEndGPA(endGPA); 
		courses = new ArrayList<Course>(); 
	}

	/**
	 * Get this Student's String form major. 
	 * @return major, this Student instance's major in String form
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * Smart set Student's instance var major so that majors 
	 * of 0 length can't be instantiated. 
	 * @param major, the desired String form of this Student's major
	 */
	public void setMajor(String major) {
		if (major.length()==0){
			major = "Undeclared Major";
			return; 
		}
		this.major = major;
	}

	/**
	 * Get this Student's current cumulative GPA, as assigned 
	 * by an Instructor. 
	 * @return endGpa, this Student's current cumulative GPA
	 */
	public double getEndGPA() {
		return endGPA;
	}

	/**
	 * Smart set a starting GPA; can't be > 4.0 or < 0.0. 
	 * @param endGPA, the desired GPA for this Student instance
	 */
	public void setEndGPA(double endGPA) {
		if (endGPA < 0 || endGPA > 4){
			this.endGPA = 0.0; 
			return; 
		}
		this.endGPA = endGPA;
	}
	
	/**
	 * Get this Student instance's list of registered Courses. 
	 * @return courses, this Student's instance var ArrayList of 
	 * Courses in which he/she is currently enrolled. 
	 */
	public ArrayList<Course> getCourses(){
		return this.courses; 
	}
	
	/**
	 * Add a Course to this Student's list of Courses to take.
	 * For access and use by AdminStaff.  
	 * @param toTake, the new Course to be taken by this Student.
	 */
	public void addCourse(Course toTake){
		this.courses.add(toTake); 
	}
	
}
