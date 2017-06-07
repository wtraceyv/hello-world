package edu.miamioh.traceywd;

public class DesignedClassesGUITester {
	
	public static void main(String[] args) {
		
		/** construct all the objects to be used in testing */ 
		
		// Create an AdminStaff to setup classes later on
		// Use to test ID and email smart setters also 
		AdminStaff josh = new AdminStaff("blahblahATGMAIL!","2y3f4");
		System.out.println("Created AdminStaff instance.\nUsed ID \'2y3f4\'; should be invalidated and changed to random sequence.");
		System.out.println("Current AdminStaff ID: " + josh.getIdentification());
		System.out.println("Used email \'blahblahATGMAIL!\', should invalidate and set to default email.");
		System.out.println("Current AdminStaff email: " + josh.getEmail()+"\n");
		// create Instructor to use methods later 
		Instructor harden = new Instructor("mharden@uc.k12.in.us","94837",50000); 
		Instructor thatCanadianGuy = new Instructor("mdstephan@miamioh.edu","39472",120000); 
		// create some LectureHalls at which to assign Courses 
		LectureHall benton = new LectureHall("Benton Hall",200); 
		LectureHall peabody = new LectureHall("Peabody Hall",230);
		LectureHall shideler = new LectureHall("Shideler Hall",300); 
		// create some Courses Students can take and Instructors can teach 
		Course chemistry = new Course("Chemistry"); 
		Course physics = new Course("Physics"); 
		Course oop = new Course("Object Oriented Programming"); 
		// finally, create some Students to take those classes and have grades manipulated
		Student me = new Student("traceywd@miamioh.edu","87473","Computer Science",4.0); 
		Student broski = new Student("tmigoski@gmail.com","938f8","Musical Education",3.9); 
		Student sam = new Student("shart@bsu.edu","28375","Awesomeness Education",4.0); 
		
		/** Do some actions with all these objects and prove they work */ 
		
		// assign harden to some classes, prove I did 
		josh.assignInstructor(harden, chemistry);
		josh.assignInstructor(harden, physics);
		josh.assignInstructor(thatCanadianGuy, oop);
		System.out.println("Assigned chemistry then physics Courses to Instructor harden.");
		System.out.println("First Course's courseName to teach should be Chemistry:\nSaved: "+harden.getTaughtCourses().get(0).getCourseName());
		System.out.println("Second should be Physics:\nSaved: "+harden.getTaughtCourses().get(1).getCourseName());
		System.out.println( );
		// add some Students and prove it 
		josh.enrollStudent(me, chemistry);
		josh.enrollStudent(me, physics);
		josh.enrollStudent(me, oop);
//		josh.enrollStudent(broski, chemistry);
//		josh.enrollStudent(sam, chemistry);
//		josh.enrollStudent(sam, physics);
		System.out.println("Enrolled some Students in classes. I am enrolled in all three.");
		System.out.println("Printing first three registered Courses (courseNames) of \'me\' object should show (no errors):");
		System.out.println("Chemistry, Physics, Object Oriented Programming.\nActual:");
		System.out.println(me.getCourses().get(0).getCourseName()+", "+me.getCourses().get(1).getCourseName()+", "+me.getCourses().get(2).getCourseName()+".");
		System.out.println("Likewise, showing emails of students enrolled in Object Oriented Programming (just me)\nshould yield my email (traceywd@miamioh.edu).\nActual:");
		System.out.println(oop.getRegisteredStudents().get(0).getEmail());
		System.out.println("Grabbing the email of the OOP Instructor should accordingly give Dr. Stephan's, since I assigned him to the class.\nActual:");
		System.out.println(oop.getCourseInstructor().getEmail()+"\n");
		// assign a LectureHall to a Course 
		System.out.println("Object Oriented Programming should currently be at a default hall (hasn't been scheduled yet):\n"+oop.getCourseLocation().getLectureHallName());
		josh.scheduleLectureHall(benton, oop);
		josh.scheduleLectureHall(peabody, chemistry);
		System.out.println("Assigned that class a hall: Benton Hall. Grabbing the courseLocation.getLectureHallName should yield this.\nActual:\n"+oop.getCourseLocation().getLectureHallName()+"\n");
		System.out.println("END");
	}

}
