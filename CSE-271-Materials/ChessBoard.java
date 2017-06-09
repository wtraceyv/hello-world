package edu.miamioh.traceywd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 * A construct for holding ChessPiece instances which ultimately 
 * make up a visual and computerized "chess board". Also provides various 
 * constants and public and private methods to facilitate functionality. 
 * CSE 271, B
 * @author Walter Tracey 
 * Instructor: Dr. Stephan
 * 4 May 2017
 */
public class ChessBoard extends JComponent {
	
	public static final int LONG_SIDE_DIMENSIONS = 600; 
	public static final Color DEFAULT_LIGHT_COLOR = Color.WHITE; 
	public static final Color DEFAULT_DARK_COLOR = Color.BLACK; 
	public static final String LETTER_LABELS = "ABCDEFGH";  
	
	private static ChessPiece[][] accessiblePieces = new ChessPiece[8][8];
	private static JPanel cornerPanel; 
	private static JLabel cornerLabel; 
	private ImageIcon secretQueenPic; // shhhh...you didn't see anything 

	public ChessBoard() {
		configureBoard();  
	}
	
	/**
	 * Helper --> setup the basic attributes of the board, 
	 * then configure its grid with all the pieces, etc. 
	 * Etched border info found at JAVA SE 8 API w/ examples from: 
	 * https://docs.oracle.com/javase/tutorial/uiswing/components/border.html
	 */
	private void configureBoard(){
		// setup board 
		setVisible(true); 
		setOpaque(true);
		setPreferredSize(new Dimension(LONG_SIDE_DIMENSIONS,LONG_SIDE_DIMENSIONS));
		setLayout(new GridLayout(9,9));
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		// fill board 
		configureGrid();
	}
	
	/**
	 * Helper method; execute correct sequence of other helpers 
	 * that ultimately setup the board's pieces and guides. 
	 */
	private void configureGrid(){
		configureSecretPic(); 
		configureTopGuides(); 
		configureButtonsAndNumberGuides(); 
	}
	
	/**
	 * Helper; create/add in the correct order all the ChessPiece instances
	 * and save them, and setup the number guides in the leftmost column. 
	 */
	private void configureButtonsAndNumberGuides(){
		for (int i = 0, numberGuide = 1; i < 8; i++, numberGuide++){ // eight rows of 9 columns (first row already constructed) 
			// add a vertical number guide
			JPanel numberGuidePanel = new JPanel(); 
			JLabel numberLabel = new JLabel(""+numberGuide); 
			numberLabel.setHorizontalAlignment(JLabel.CENTER);
			numberGuidePanel.setLayout(new BorderLayout());
			numberGuidePanel.setBackground(DEFAULT_LIGHT_COLOR);
			numberGuidePanel.add(numberLabel); 
			add(numberGuidePanel);
			// add a bunch of chess spots
			for (int j = 0; j < 8; j++){
				ChessPiece newSpot = new ChessPiece(decideSquareColor(i,j),new int[] {i,j}); 
				add(newSpot); 
				accessiblePieces[i][j] = newSpot; 
			}
		}
	}

	/**
	 * Helper: configure the top panels serving as the alphabetic 
	 * piece guides, as well as the very top-left corner of the board. 
	 */
	private void configureTopGuides(){
		// setting up that "empty" corner
		cornerPanel = new JPanel(); 
		cornerPanel.setLayout(new BorderLayout());
		cornerLabel = new JLabel(secretQueenPic);
		cornerLabel.setVisible(false);
		cornerPanel.setBackground(Color.WHITE);
		cornerPanel.add(cornerLabel,BorderLayout.CENTER); 
		add(cornerPanel); 
		// fill in letters over top
		for (int i = 0; i < LETTER_LABELS.length(); i++){
			// every letter gets its own little panel, so I can set background colours
			JPanel guidePanel = new JPanel(); 
			JLabel letterLabel = new JLabel(LETTER_LABELS.substring(i,i+1));
			letterLabel.setHorizontalAlignment(JLabel.CENTER);
			guidePanel.setBackground(DEFAULT_LIGHT_COLOR);
			guidePanel.setLayout(new BorderLayout());
			guidePanel.add(letterLabel,BorderLayout.CENTER); 
			add(guidePanel); 
		} 
	}// end top guide helper
	
	/**
	 * Helper: shhhh...setting up the secret picture shown 
	 * for when the user gets a correct solution to be a 
	 * reasonable size. 
	 */
	private void configureSecretPic(){
		secretQueenPic = new ImageIcon("Mercury.png"); 
		Image img2 = secretQueenPic.getImage(); 
		Image newImg2 = img2.getScaledInstance(70,60, Image.SCALE_SMOOTH); 
		secretQueenPic = new ImageIcon(newImg2); 
	}
	
	/**
	 * Determine whether a ChessPiece with the given 2d 0-based 
	 * indices should be the board's chosen light or dark square color. 
	 * (Based on personal observation) 
	 * @param row, the 0-based row of the piece whose color is questioned. 
	 * @param col, the 0-based column of the piece whose color is questioned.  
	 * @return the Color object representing either a board's dark or light color, 
	 * depending on its location in the board. 
	 */
	private static Color decideSquareColor(int row, int col){
		if ((row%2==0 && col%2==0) || (row%2!=0 && col%2!=0)){
			return DEFAULT_LIGHT_COLOR; 
		} else {
			return DEFAULT_DARK_COLOR; 
		}
	}
	
	/**
	 * Loop through all current ChessPieces and their states to determine 
	 * whether any are attacking another; if so, the first conflict is marked
	 * (backgrounds of the offending pieces are marked red).
	 * Primarily uses ChessPiece.queenIsHostile() for functionality. 
	 */
	public static void scanHostileQueens(){
		for (int row = 0; row < 8; row++){
			for (int col = 0; col < 8; col++){
				if (ChessPiece.getPieceMap()[row][col] && (ChessPiece.queenIsHostile(accessiblePieces[row][col])[0]!=-1)){
					// alert and return! 
					int[] victimCoords = ChessPiece.queenIsHostile(accessiblePieces[row][col]); 
					ChessPiece.alertPiece(accessiblePieces[row][col],Color.RED);
					ChessPiece.alertPiece(accessiblePieces[victimCoords[0]][victimCoords[1]],Color.RED);
					InterfacePanel.infoStatement("Conflict marked!");
					return; 
				}
			}
		}
		// if no conflicts, set everything back to normal state  
		resetAlerts(); 
	}
	
	/**
	 * Use ChessPiece public method functions to loop through all current ChessPieces 
	 * and search for a spot where a hypothetically placed queen would not 
	 * attack any others. If one is found, its background is marked yellow 
	 * and this is acknowledged in a message. Otherwise, a message acknowledges 
	 * that there are no safe spots to be found. 
	 */
	public static void indicateRandomSafePlace(){
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				// if placing a piece here would be safe, indicate that 
				if (ChessPiece.queenIsHostile(new ChessPiece(Color.DARK_GRAY,new int[] {i,j}))[0]==-1 
						&& !ChessPiece.getPieceMap()[i][j]){
					ChessPiece.alertPiece(accessiblePieces[i][j],Color.YELLOW);
					InterfacePanel.infoStatement("A piece can safely be placed!");
					return; 
				}
			}
		}
		// nothing was found; relay findings 
		InterfacePanel.infoStatement("No safe spot found.");
	}
	
	/**
	 * A way to declutter the ChessBoard when an action by the user 
	 * is safe and does not create a conflict or a tip suggestion---
	 * Loops through all existing ChessPieces and sets their backgrounds 
	 * back to their original color. Also verifies whether the current 
	 * arrangement is a solution; if so, it will be acknowledged by a 
	 * picture and message to the user. 
	 */
	public static void resetAlerts(){
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				accessiblePieces[i][j].setBackground(accessiblePieces[i][j].getTrueColor());
			}
		}
		if (ChessPiece.getPiecesPlaced()==8){
			InterfacePanel.infoStatement("You are the champion!");
			cornerPanel.setBackground(Color.PINK);
			cornerLabel.setVisible(true); 
			return; 
		}
		InterfacePanel.infoStatement("You're good. Continue!");
	}
	
	/**
	 * Get this ChessBoard's 2-d array containing the ChessPiece 
	 * instances that make up the board's main functionality; 
	 * essentially the only variable that isn't a constant of ChessBoard
	 * and could benefit a user without breaking functionality. 
	 * @return this ChessBoard's 2-d array cache of ChessPiece instances. 
	 */
	public static ChessPiece[][] getAccessiblePieces(){
		return accessiblePieces; 
	}

}// end ChessBoard class 
