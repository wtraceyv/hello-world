package lab_six_src;

/**
 * class to model a MovableCircle whose location is mandated 
 * by a "center" MovablePoint and extra radius instance variable; 
 * implements Movable 
 * @author Wallisan
 * Instructor: Dr. Stephan 
 * CSE 271, B
 * 3/3/2017
 */
public class MovableCircle implements Movable {
	
	private MovablePoint center; 
	private int radius;

	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
		center = new MovablePoint(x,y,xSpeed,ySpeed); 
		setRadius(radius); 
	}

	/**
	 * move MovableCircle "up" by moving its center accordingly (radius will follow) 
	 */
	@Override
	public void moveUp() {
		center.moveUp();
	}

	/**
	 * move MovableCircle "down" by moving its center accordingly (radius will follow) 
	 */
	@Override
	public void moveDown() {
		center.moveDown();
	}

	/**
	 * move MovableCircle "left" by moving its center accordingly (radius will follow) 
	 */
	@Override
	public void moveLeft() {
		center.moveLeft();
	}

	/**
	 * move MovableCircle "right" by moving its center accordingly (radius will follow) 
	 */
	@Override
	public void moveRight() {
		center.moveRight();
	}
	
	/**
	 * @return radius of MovableCircle instance 
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * smart set radius of MovableCircle instance 
	 * @param radius
	 */
	public void setRadius(int radius) {
		if (radius>0){
			this.radius = radius; 
		} else {
			this.radius = 1; 
		}
	}

	/**
	 * Override toString() to better represent applicable 
	 * values of a MovableCircle 
	 */
	@Override
	public String toString(){
		return "Circle of radius " + this.radius + ", with center of " + center; 
	}

}// end MovableCircle class 
