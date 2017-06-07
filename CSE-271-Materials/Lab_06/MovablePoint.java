package lab_six_src;

/**
 * class to model a point with x and y coordinates, 
 * and x and y speeds to represent how many units 
 * are traversed in the desired direction when a 
 * move method is called 
 * @author Wallisan
 * Instructor: Dr. Stephan 
 * CSE 271, B
 * 3/3/2017
 */
public class MovablePoint implements Movable {
	
	// applicable Point instance vars 
	private int x; 
	private int y; 
	private int xSpeed; 
	private int ySpeed; 
	
	// one basic constructor; setters only required 
	// for speed vars 
	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		this.x = x; 
		this.y = y; 
		setxSpeed(xSpeed); 
		setySpeed(ySpeed); 
	}

	/**
	 * @return xSpeed of Point instance 
	 */
	public int getxSpeed() {
		return xSpeed;
	}

	/**
	 * smart set xSpeed of a MovablePoint 
	 * @param xSpeed
	 */
	public void setxSpeed(int xSpeed) {
		if (xSpeed>=0){
			this.xSpeed = xSpeed; 
		} else {
			xSpeed = 0; 
		}
	}

	/**
	 * @return ySpeed of Point instance 
	 */
	public int getySpeed() {
		return ySpeed;
	}

	/**
	 * smart set ySpeed of a MovablePoint 
	 * @param ySpeed
	 */
	public void setySpeed(int ySpeed) {
		if (ySpeed>=0){
			this.ySpeed = ySpeed; 
		} else {
			ySpeed = 0; 
		}
	}

	/**
	 * Cause MovablePoint instance to "move up" 
	 * by incrementing its y coordinate appropriately 
	 * with its current ySpeed value 
	 */
	@Override
	public void moveUp() {
		this.y += ySpeed; 
	}

	/**
	 * Cause MovablePoint instance to "move down" 
	 * by decrementing its y coordinate appropriately 
	 * with its current ySpeed value 
	 */
	@Override
	public void moveDown() {
		this.y -= ySpeed; 
	}

	/**
	 * Cause MovablePoint instance to "move left" 
	 * by decrementing its x coordinate appropriately 
	 * with its current xSpeed value 
	 */
	@Override
	public void moveLeft() {
		this.x -= xSpeed; 
	}

	/**
	 * Cause MovablePoint instance to "move right" 
	 * by incrementing its x coordinate appropriately 
	 * with its current xSpeed value 
	 */
	@Override
	public void moveRight() {
		this.x += xSpeed; 
	}
	
	/**
	 * Override toString() to better represent applicable 
	 * values of a MovablePoint 
	 */
	@Override
	public String toString(){
		return "point x="+this.x+", y="+this.y+"; xSpeed="+this.getxSpeed()+", ySpeed="+this.getySpeed();
	}

}// end MovablePoint class 
