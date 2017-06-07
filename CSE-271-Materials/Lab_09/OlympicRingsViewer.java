package edu.miamioh.traceywd;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Class to use the OlympicRings class to draw 
 * the...you guessed it...olympic rings logo on a 
 * generic frame with whatever constant dimension values 
 * are set. 
 * @author Walter Tracey 
 * Instructor: Dr. Stephan 
 * 4/4/2017
 * CSE 271, B
 */
public class OlympicRingsViewer {
	
	public static final int STANDARD_FRAME_SIZE = 350;

	public static void main(String[] args) {
		// setup generic frame
		JFrame main = new JFrame("Olympic Rings!"); 
		main.setVisible(true);
		main.setSize(STANDARD_FRAME_SIZE, STANDARD_FRAME_SIZE);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add the component; will draw automatically
		JComponent rings =  new OlympicRings(); 
		main.add(rings); 
	}

}
