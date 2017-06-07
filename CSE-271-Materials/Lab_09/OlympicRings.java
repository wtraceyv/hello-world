package edu.miamioh.traceywd;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * Class to use Graphics and overriding capabilities 
 * to draw the olympic rings logo. Requires a runner 
 * class to set this extended JComponent on a frame. 
 * @author Walter Tracey 
 * Instructor: Dr. Stephan 
 * 4/4/2017
 * CSE 271, B
 */
public class OlympicRings extends JComponent{
	
	public static final int STANDARD_RING_SIZE = 150;
	public static final int START_COORDINATES_VALUE = 200;
	
	/**
	 * Overridden JComponent method paintComponent, drawing 
	 * in one method all 5 rings needed to create the olympic rings 
	 * correctly, automatically fixing themselves with respect to each other 
	 * as top constants are changed as desired. Frame size constant in main class 
	 * may need to be changed also for rings to be seen well. 
	 */
	@Override 
	public void paintComponent(Graphics g){
		drawRing(START_COORDINATES_VALUE, START_COORDINATES_VALUE, Color.BLUE, g);
		drawRing(START_COORDINATES_VALUE+STANDARD_RING_SIZE+3, START_COORDINATES_VALUE, Color.BLACK, g);
		drawRing(START_COORDINATES_VALUE+(2*STANDARD_RING_SIZE)+3, START_COORDINATES_VALUE, Color.RED, g);
		drawRing((int) (START_COORDINATES_VALUE+(.5*STANDARD_RING_SIZE)),(int) (START_COORDINATES_VALUE+(.5*STANDARD_RING_SIZE)), Color.YELLOW, g);
		drawRing((int) (START_COORDINATES_VALUE+(.5*STANDARD_RING_SIZE))+STANDARD_RING_SIZE+3,(int) (START_COORDINATES_VALUE+(.5*STANDARD_RING_SIZE)), Color.GREEN, g);
	}
	
	/**
	 * Basic method to draw one ring with an oval, used in paintComponent 5 times 
	 * to create the set of rings that make up the picture. 
	 * @param x, x-coordinate int on-screen of this ring in positive direction from top-left corner.
	 * @param y, y-coordinate int on-screen of this ring in downward direction from top-left corner.
	 * @param desiredColor, Color object representing desired color of this ring to be drawn. 
	 * @param g, Graphics object passed by java in the background with the paintComponent method. 
	 */
	public static void drawRing(int x, int y, Color desiredColor, Graphics g){
		g.setColor(desiredColor);
		g.drawOval(x, y, STANDARD_RING_SIZE, STANDARD_RING_SIZE);
	}

}
