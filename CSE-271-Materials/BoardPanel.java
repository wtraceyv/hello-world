package edu.miamioh.traceywd;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

/**
 * A panel to hold the ChessBoard instance; 
 * it is the chunk that is actually placed in the 
 * frame, so that there can also be a cleanly separate panel 
 * for user interface (buttons/info, etc.) within 
 * the frame. 
 * CSE 271, B
 * @author Walter Tracey 
 * Instructor: Dr. Stephan
 * 4 May 2017
 */
public class BoardPanel extends JPanel {
	
	private JPanel panel; 
	private ChessBoard chessBoard; 

	public BoardPanel() {
		constructPanel(); 
	}
	
	/**
	 * Helper method for constructing the panel, 
	 * so that potential changes in constructor 
	 * aren't overly difficult and cluttered. 
	 */
	private void constructPanel(){
		chessBoard = new ChessBoard(); 
		panel = new JPanel(); 
		panel.setLayout(new BorderLayout());
		panel.add(chessBoard, BorderLayout.CENTER); 
		add(panel);
	}
	
	/**
	 * Get this BoardPanel's ChessBoard instance.
	 * @return chessBoard, the ChessBoard instance of this BoardPanel. 
	 */
	public ChessBoard getChessBoard(){
		return chessBoard; 
	}

}
