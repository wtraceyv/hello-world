package edu.miamioh.traceywd;

/**
 * Class to model a LectureHall with a name and capacity; 
 * setter methods are private, simply so outsiders can't 
 * change inherent properties of a LectureHall for no reason, 
 * but they can be smart set with the class constructor. 
 * This class doesn't exactly perform operations, but can 
 * feasibly exist to represent a LectureHall, which is not 
 * merely a name or a capacity, but an entity having both the 
 * properties of name and capacity. 
 * CSE 271, B
 * @author Walter Tracey 
 * Instructor: Dr. Stephan
 * 3/28/2017
 */
public class LectureHall {

	private String lectureHallName; 
	private int lectureHallCapacity; 
	
	public LectureHall(String name, int capacity) {
		setLectureHallName(name); 
		setLectureHallCapacity(capacity); 
	}

	/**
	 * Get this LectureHall's name. 
	 * @return lectureHallName, this LectureHall's name as String. 
	 */
	public String getLectureHallName() {
		return lectureHallName;
	}

	/**
	 * Smart set this LectureHall's name, ensuring it can't be of length 0.
	 * Private so that outside sources can't change its name for no reason.  
	 * @param lectureHallName, the desired name for this LectureHall
	 */
	private void setLectureHallName(String lectureHallName) {
		if (lectureHallName.length()==0){
			this.lectureHallName = "new weird, maybe-nonexistent Hall"; 
			return; 
		}
		this.lectureHallName = lectureHallName;
	}

	/**
	 * Get this LectureHall's capacity. 
	 * @return lectureHallCapacity, this particular LectureHall's capacity. 
	 */
	public int getLectureHallCapacity() {
		return lectureHallCapacity;
	}

	/**
	 * Smart set HallCapacity to be at least 50 places and no more 
	 * than 500 (that's just ridiculous). Private so capacity can't 
	 * magically be changed from outside the class, indicating some 
	 * change or construction on the LectureHall.  
	 * @param lectureHallCapacity, desired capacity for this LectureHall. 
	 */
	private void setLectureHallCapacity(int lectureHallCapacity) {
		if (lectureHallCapacity < 50 || lectureHallCapacity > 500){
			this.lectureHallCapacity = 50; 
			return; 
		}
		this.lectureHallCapacity = lectureHallCapacity;
	}

}
