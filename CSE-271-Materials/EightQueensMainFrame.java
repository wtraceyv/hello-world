package edu.miamioh.traceywd;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * Extended JFrame for holding all the major panels of 
 * the ChessBoard program. 
 * CSE 271, B
 * @author Walter Tracey
 * Instructor: Dr. Stephan
 * 4 May 2017
 */
public class EightQueensMainFrame extends JFrame {
	
	public static final int PREFERRED_DIMENSIONS = 700; 
	
	private JFrame mainFrame; 
	private BoardPanel board;
	private InterfacePanel lowPanel; 

	public EightQueensMainFrame(){
		configureFrame(); 
		board = new BoardPanel(); 
		lowPanel = new InterfacePanel(); 
		mainFrame.add(board, BorderLayout.CENTER);
		mainFrame.add(lowPanel, BorderLayout.SOUTH);
		pack(); 
		mainFrame.setVisible(true); 
	}

	public static void main(String[] args) {
		EightQueensMainFrame getItOn = new EightQueensMainFrame();
	}
	
	/**
	 * Helper: setup the frame's basic attributes. 
	 */
	private void configureFrame(){
		mainFrame = new JFrame("Safely place 8 Queens!"); 
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(PREFERRED_DIMENSIONS, PREFERRED_DIMENSIONS);
	}
}
