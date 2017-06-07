package edu.miamioh.traceywd;

/**
 * Class to model a member/the members of the University AdminStaff. 
 * Performs many administrative aspects of University organization, including
 * assigning Instructors to teach Courses, enrolling Students in those 
 * Courses, and assigning LectureHalls in which to teach those Courses. 
 * CSE 271, B
 * @author Walter Tracey 
 * Instructor: Dr. Stephan
 * 3/28/2017
 */
public class AdminStaff extends Person {

	// no instance vars really necessary; 
	// each instance inherently has the necessary ID 
	// and name of a Person, and otherwise the class 
	// is just meant to do operations for other Classes. 
	
	public AdminStaff(String email, String identification) {
		super(email,identification); 
	}
	
	/**
	 * Enroll the given Student in the given Course by making the 
	 * according change to the Student's list of registered Courses, 
	 * AND adding that Student to the Course's list of Students. 
	 * @param newStudent, the Student to enroll in the Course. 
	 * @param toJoin, the Course in which to enroll the given Student. 
	 */
	public void enrollStudent(Student newStudent, Course toJoin){
		newStudent.addCourse(toJoin);
		toJoin.addStudent(newStudent);
	}
	
	/**
	 * Assign the given Course a location at which to be taught represented 
	 * by the given LectureHall object. 
	 * @param newLocation, the LectureHall object representing the new meeting 
	 * place for the given Course. 
	 * @param course, the Course being scheduled at the given LectureHall location. 
	 */
	public void scheduleLectureHall(LectureHall newLocation, Course course){
		course.setCourseLocation(newLocation);
	}
	
	/**
	 * Assign the given Instructor object to teach the given Course object by 
	 * appending the Instructor's instance list of Courses taught and setting
	 * the Instructor as courseInstructor within the Course object.  
	 * @param toAssign, the Instructor object representing the teacher who 
	 * will teach the given Course. 
	 * @param toBeTaught, the Course object representing the Course the 
	 * given Instructor will be teaching. 
	 */
	public void assignInstructor(Instructor toAssign, Course toBeTaught){
		toBeTaught.setCourseInstructor(toAssign);
		toAssign.addCourseToTeach(toBeTaught);
	}

}
