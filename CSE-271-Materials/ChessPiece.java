package edu.miamioh.traceywd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A JPanel representing one colored square on a ChessBoard 
 * instance. Provides various public and private methods to 
 * facilitate functionality with regard to other ChessPiece
 * instances as well as mouse actions for use on the actual 
 * ChessBoard. 
 * CSE 271, B
 * @author Walter Tracey
 * Instructor: Dr. Stephan
 * 4 May 2017
 */
public class ChessPiece extends JPanel {
	
	public static final int LITTLE_IMAGE_DIMENSIONS = 40; 
	 
	private int[] currentLocation;
	private boolean piecePlaced = false;
	private static boolean[][] pieceMap = new boolean[8][8];
	private static int piecesPlaced = 0; 
	private JLabel queen;
	private ImageIcon queenPic; 
	private Color trueColor; 
	
	public ChessPiece(Color startColor, int[] startLocation) {
		super();
		configurePic(); 
		configurePiece(); 
		trueColor = startColor; 
		currentLocation = startLocation;
		this.setBackground(startColor);
	}// end constructor 
	
	/**
	 * Inner class for giving each piece its functionality, 
	 * including the appearing/disappearing of images, 
	 * storing the info regarding the newly-placed or -removed 
	 * piece, and restricting the placing of more than 8 pieces. 
	 */
	class PlaceListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			if (!piecePlaced && piecesPlaced<8){
				piecePlaced = true; 
				addPieceToMap(); 
				queen.setIcon(queenPic); 
				queen.setVisible(true);
				piecesPlaced++; 
			} else if (!piecePlaced && piecesPlaced==8){
				InterfacePanel.infoStatement("Already 8 Pieces!");
			} 
			else {
				piecePlaced = false; 
				removePieceFromMap();
				queen.setVisible(false);
				piecesPlaced--; 
			}
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}  
	}// end inner class
	
	/**
	 * Helper: Add this piece's MouseListener, setup/add 
	 * its visual attributes. 
	 */
	private void configurePiece(){
		this.addMouseListener(new PlaceListener());
		this.setLayout(new BorderLayout());
		queen = new JLabel(queenPic); 
		this.add(queen,BorderLayout.CENTER); 
		queen.setVisible(false);
		queen.setHorizontalAlignment(JLabel.CENTER);
	} // end configuration helper 
	
	/**
	 * Reformat the project-level image to be an appropriate size 
	 * that will fit in one ChessPiece when desired. Method found at: 
	 * http://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
	 */
	private void configurePic(){
		queenPic = new ImageIcon("974a726300be565dccb35c8acc6d2902_-chess-king-piece-clip-art-chess-king-clip-art_600-590.png"); 
		Image img = queenPic.getImage(); 
		Image newImg = img.getScaledInstance(LITTLE_IMAGE_DIMENSIONS,LITTLE_IMAGE_DIMENSIONS,Image.SCALE_SMOOTH); 
		queenPic = new ImageIcon(newImg); 
	}
	
	/**
	 * Determine whether the parameterized ChessPiece is 'attacking' any 
	 * other ChessPiece by looping through the set of placed or not-placed 
	 * queens and measuring their location with respect to the given. 
	 * If culprit is in the same row, same column, or diagonal (if conditional 
	 * for diagonal taken from lecture), the method will return the coordinates 
	 * of the queen being attacked. Otherwise, it will return a set of coordinates, 
	 * {-1,-1}, indicating culprit is not attacking any other piece. 
	 * @param culprit, the possibly attacking ChessPiece in question. 
	 * @return int[2] representing either the coordinates of a ChessPiece 
	 * being attacked, or a bad set indicating no ChessPiece is in danger by culprit. 
	 */
	public static int[] queenIsHostile(ChessPiece culprit){
		for (int row = 0; row < pieceMap.length; row++){ 
			for (int col = 0; col < pieceMap[row].length; col++){
				// if there is a queen, check if it's being attacked by culprit
				if (pieceMap[row][col]){
					// if a queen is either in the same row or column OR diagonal from another, 
					// AND isn't the same queen, it's being attacked 
					if (((culprit.currentLocation[0]==row && culprit.currentLocation[1]!=col) 
							|| (culprit.currentLocation[1]==col && culprit.currentLocation[0]!=row)) 
							|| piecesPlaced > 0 
							&& Math.abs(row-culprit.currentLocation[0])==Math.abs(col-culprit.currentLocation[1]) 
							&& (row!=culprit.currentLocation[0] && col!=culprit.currentLocation[1])){
						return new int[] {row,col}; 
					} 
				} 
			}
		}
		return new int[] {-1,-1}; 
	}// end hostile queen method 
	
	/**
	 * Public method for changing the background colour of the given 
	 * ChessPiece for the purposes of drawing UI attention to it. 
	 * @param toSignal, the ChessPiece whose backgroun colour must be changed. 
	 * @param colour, the Color constant representing the background colour 
	 * to use to point the user to the given ChessPiece. 
	 */
	public static void alertPiece(ChessPiece toSignal, Color colour) {
		toSignal.setBackground(colour);
	}
	
	/**
	 * Get the total number of queens currently placed on pieces. 
	 * @return piecesPlaced, the number of queens currently 
	 * placed. 
	 */
	public static int getPiecesPlaced(){
		return piecesPlaced; 
	}
	
	/**
	 * Get this ChessPiece's specific location as a 0-based array of length 2. 
	 * @return currentLocation, the 0-based array of length 2 representing 
	 * this ChessPiece's location on a ChessBoard. 
	 */
	public int[] getCurrentLocation(){
		return currentLocation; 
	}
	
	/**
	 * Get the JLabel used (visible or not depending on current state) on 
	 * a ChessPiece. 
	 * @return queen, the JLabel used on the ChessPieces. 
	 */
	public JLabel getQueenLabel(){
		return queen; 
	}
	
	/**
	 * Get the true color of this specific ChessPiece (the original 
	 * dark or light color based on its location on a generic chess board). 
	 * @return trueColor, this ChessPiece's original light or dark color 
	 * based on its location on a generic chess board. 
	 */
	public Color getTrueColor(){
		return trueColor; 
	}
	
	/**
	 * Render this Pieces value on the "pieceMap" true, which is a 2-d boolean array 
	 * representing placed or not-placed queens; indicates a queen has been placed 
	 * on this ChessPiece. 
	 */
	public void addPieceToMap(){
		pieceMap[this.getCurrentLocation()[0]][this.getCurrentLocation()[1]] = true; 
	}
	
	/**
	 * Render this Pieces value on the "pieceMap" false, which is a 2-d boolean array 
	 * representing placed or not-placed queens; indicates a queen has been removed 
	 * from this ChessPiece. 
	 */
	public void removePieceFromMap(){
		pieceMap[this.getCurrentLocation()[0]][this.getCurrentLocation()[1]] = false; 
	}
	
	/**
	 * Get the 2-d array boolean 'map' representing currently placed or not-placed 
	 * queens on the ChessBoard. 
	 * @return pieceMap, the 2-d array boolean 'map' representing currently placed or not-placed 
	 * queens on the ChessBoard. 
	 */
	public static boolean[][] getPieceMap(){
		return pieceMap; 
	}
	
	/**
	 * New toString() representation of a ChessPiece identifying its coordinates. 
	 */
	@Override 
	public String toString(){
		return "ChessPiece on map [" + currentLocation[0] +","+ currentLocation[1] + "]"; 
	}
	
}// end button class
   