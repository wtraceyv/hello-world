package edu.miamioh.traceywd;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Extended JPanel for all the button/text info-based 
 * UI in the chess game frame; placed in the frame's 
 * BorderLayout.SOUTH position. 
 * @author Walter Tracey
 * Instructor: Dr. Stephan
 * 4 May 2017
 */
public class InterfacePanel extends JPanel {
	
	private JPanel panel; 
	private JButton checkForProblems; 
	private JButton easyTip; 
	private static JTextField infoBar; 

	public InterfacePanel() {
		configurePanel(); 
	}
	
	/**
	 * Helper: configure main panel's basic attributes 
	 * and add pertinent components to it; add the panel
	 * to the actual instance. 
	 */
	private void configurePanel(){
		// CHANGE LAYOUT IF NEEDED!
		panel = new JPanel(); 
		panel.setLayout(new GridLayout(1,3));
		configureInfoBar(); 
		configureCheckButton(); 
		configureSimpleTipButton(); 
		add(panel); 
	}
	
	/**
	 * Configure the JTextField which will display various 
	 * alerts for the user as actions are performed on the 
	 * frame/ChessBoard. 
	 */
	private void configureInfoBar(){
		infoBar = new JTextField("Alerts appear here!"); 
		infoBar.setEditable(false);
		infoBar.setVisible(true);
		infoBar.setColumns(16);
		panel.add(infoBar); 
	}
	
	/**
	 * Setup and add to main panel the button w/ ActionListener in the UI interface area 
	 * that will allow a user to check their current 'partial solution'. 
	 * Clears previous markings on board before checking. Any actual warnings 
	 * are handled later in the ChessBoard class. 
	 */
	private void configureCheckButton(){
		checkForProblems = new JButton("Check solution"); 
		class CheckListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
					ChessBoard.resetAlerts();
					ChessBoard.scanHostileQueens();
			}
		}// end inner class 
		checkForProblems.addActionListener(new CheckListener());
		panel.add(checkForProblems); 
	}
	
	/**
	 * Setup and add to main panel the button w/ ActionListener in the UI interface area
	 * that will allow the user to highlight a ChessPiece where a queen can safely 
	 * be placed (without attacking other existing queens), given a place exists. 
	 * Otherwise, it is indicated that no spot exists. 
	 */
	private void configureSimpleTipButton(){
		easyTip = new JButton("Tip");
		class SimpleTipListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (ChessPiece.getPiecesPlaced()<8){
					ChessBoard.indicateRandomSafePlace();
				} else {
					infoStatement("Found solution; tips gone.");
				}
			}
		}// end inner class 
		easyTip.addActionListener(new SimpleTipListener());
		panel.add(easyTip); 
	}
	
	/**
	 * Public method allowing any class to alert the user in the designated 
	 * JTextArea UI section with any given message based on the situation. 
	 * @param newInfo, the message to display in the UI alert JTextArea. 
	 */
	public static void infoStatement(String newInfo){
		infoBar.setText(newInfo);
	}

}
