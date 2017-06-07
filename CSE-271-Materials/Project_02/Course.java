package edu.miamioh.traceywd;

import java.util.ArrayList;

/**
 * Class to model a Course, which aggregates a list of Students 
 * enrolled in it, an Instructor for teaching it, and a location 
 * represented by a LectureHall object. 
 * I added a name instance var for the sake of more easily differentiating Courses. 
 * Course Instructor and Location start off as default, then AdminStaff MUST 
 * assign these at some point. This way it is easy to tell whether a Course 
 * is fully scheduled yet, and to prove that the AdminStaff powers to change these 
 * function correctly. 
 * 
 * There is no setter for the registeredStudents ArrayList because 
 * it is assumed we will always begin a Course and fill up the registry 
 * from the bottom up. This way, the Course attendance can't easily 
 * be modified from the outside without doing it one by one, as an 
 * instance of AdminStaff might. The ArrayList is initialized as empty
 * upon the construction of a new Course.
 * 
 * The action of adding Students will not be actively used 
 * by Course instances, but by an AdminStaff. The public getter/setter methods 
 * are necessary for the AdminStaff to change the Course's private 
 * instance vars. 
 * CSE 271, B
 * @author Walter Tracey 
 * Instructor: Dr. Stephan
 * 3/28/2017
 */
public class Course {

	private ArrayList<Student> registeredStudents; 
	private Instructor courseInstructor; 
	private LectureHall courseLocation; 
	private String courseName; 
	
	public Course(String name) {
		this.registeredStudents = new ArrayList<Student>(); 
		this.courseInstructor = new Instructor("default-instructor@gmail.com","00000",10000); 
		this.courseLocation = new LectureHall("Default Hall",100); 
		setCourseName(name); 
	}
	
	/**
	 * Add a new Student to this Course's list of registered Students.
	 * @param newStudent, the Student to register to this Course. 
	 */
	public void addStudent(Student newStudent){
		this.registeredStudents.add(newStudent); 
	}

	/**
	 * Get this Course instance's ArrayList representing the Students 
	 * registered in this course. 
	 * @return registeredStudents, this Course's list of Students 
	 * registered for this Course. 
	 */
	public ArrayList<Student> getRegisteredStudents() {
		return registeredStudents;
	}

	/**
	 * Get the Instructor object representing the assigned lecturer for 
	 * this course. 
	 * @return courseInstructor, the Instructor object representing the assigned lecturer.
	 */
	public Instructor getCourseInstructor() {
		return courseInstructor;
	}

	/**
	 * Set this Course's lecturer. Only to be used by AdminStaff. 
	 * @param courseInstructor, the desired Instructor object to assign to 
	 * lecturing for this Course. 
	 */
	public void setCourseInstructor(Instructor courseInstructor) {
		this.courseInstructor = courseInstructor;
	}

	/**
	 * Get the current location at which this Course is being taught. 
	 * @return courseLocation, a LectureHall object representing 
	 * this Course's current meeting location. 
	 */
	public LectureHall getCourseLocation() {
		return courseLocation;
	}

	/**
	 * Set this Course's meeting location. Only to be used by AdminStaff. 
	 * @param courseLocation, the desired LectureHall object representing 
	 * the new location of the meeting of this Course. 
	 */
	public void setCourseLocation(LectureHall courseLocation) {
		this.courseLocation = courseLocation;
	}

	/**
	 * Get the name of this Course in String format. 
	 * @return courseName, String representing the name of this Course. 
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Ensure Course names are not of 0 length, and set them. 
	 * @param courseName, String representing desired name of new Course. 
	 */
	public void setCourseName(String courseName) {
		if (courseName.length()==0){
			this.courseName = "new untitled course"; 
			return; 
		}
		this.courseName = courseName;
	}
	
}
