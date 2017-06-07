package lab_six_src;

/**
 * class to test two classes which implement Movable interface, 
 * including a new method that works for any of the two 
 * Movable types 
 * @author Wallisan
 * Instructor: Dr. Stephan 
 * CSE 271, B
 * 3/3/2017
 */
public class MovableTester {
	
	public static void main(String[] args) {
		// mandated testing 
		System.out.println("Performing some mandated testing...");
		Movable m1 = new MovablePoint(5,6,10,12); 
		System.out.println(m1);// whatever 
		m1.moveLeft();
		System.out.println(m1);// new values: x=-5,y=6
		Movable m2 = new MovableCircle(2,1,2,20,50); 
		System.out.println(m2);// whatever 
		m2.moveRight();
		System.out.println(m2 + "\n");// should show x=4,y=1
		
		// extra fun testing 
		Movable[] lesDancers = {new MovablePoint(1,1,3,3),new MovableCircle(0,0,1,1,5)};
		System.out.println("Let us track our two Movables in lesDancers");
		System.out.println(lesDancers[0] + "\n" + lesDancers[1]);
		System.out.println("Now, do the cha cha slide.");
		chaChaSlide(lesDancers); 
		System.out.println("Net movement is one xSpeed quantity left, one ySpeed quantity up.\nFirst should stop at (-2,4), other at (-1,1):");
		System.out.println(lesDancers[0]);
		System.out.println(lesDancers[1]);
	}
	
	/**
	 * method to make all given Movables dance the cha cha slide 
	 * @param dancers
	 */
	public static void chaChaSlide(Movable[] dancers){
		for (int i = 0; i < dancers.length; i++){
			dancers[i].moveLeft();
			dancers[i].moveRight();
			dancers[i].moveDown();
			dancers[i].moveUp();
			dancers[i].moveLeft();
			dancers[i].moveDown();
			dancers[i].moveUp();
			dancers[i].moveRight();
			dancers[i].moveLeft();
			dancers[i].moveDown();
			dancers[i].moveUp();
			dancers[i].moveUp();
		}
	}

}// end MovableTester class 
