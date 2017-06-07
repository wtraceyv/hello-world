package edu.miamioh.traceywd;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Class to create a window showcasing some menu 
 * and MouseListener skills; the background just 
 * changes colour in reaction to menu interactions 
 * or mouse clicks within the frame (on the panel). 
 * @author Walter Tracey 
 * Instructor: Dr. Stephan
 * 4/8/2017
 * CSE 271, B
 */
public class ColourPaletteViewer extends JFrame {
	
	public static final int FRAME_WIDTH = 400; 
	public static final int FRAME_HEIGHT = 400;  
	
	/**
	 * Change these colours to modify the choices --> 
	 * if so, you must also modify the configureMenuItems() method 
	 * by making the second parameters of the createColourItem() calls
	 * consistent with the names you want to be shown in the menu 
	 * for each colour choice.
	 */
	public static final Color[] COLOURS = {Color.red,Color.GREEN,Color.BLUE}; 

	// all primary frame components 
	private JFrame mainFrame; 
	private JPanel colourPanel; 
	private JMenuBar bar; 
	private JMenu colourMenu; 
	
	// an itty bitty constructor
	public ColourPaletteViewer(){
		load(); 
	}
	
	// main the kick things off 
	public static void main(String[] args){
		ColourPaletteViewer aViewer = new ColourPaletteViewer(); 
	}
	
	/**
	 * Ultimate helper method that calls all other helpers 
	 * in the appropriate order as to avoid exceptions, decluttering 
	 * the constructor yet further. 
	 */
	private void load(){
		configurePanel(); 
		configureMenu(); 
		configureMenuItems(); 
		configureFrame(); 
	}
	
	/**
	 * Set the frame's main attributes and add the most important 
	 * larger components to it, finishing construction. 
	 * Always use last, after other helper methods to avoid 
	 * NullPointerException. 
	 */
	private void configureFrame(){
		mainFrame = new JFrame("Color Chooser!"); 
		mainFrame.setVisible(true);
		mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setJMenuBar(bar);
		mainFrame.add(colourPanel); 
	}
	
	/**
	 * Create the individual choices to be in the colour choice 
	 * menu on the menu bar, and add them to that menu. 
	 */
	private void configureMenuItems(){
		JMenuItem first = createColourItem(COLOURS[0], "Red");
		JMenuItem second = createColourItem(COLOURS[1], "Green");
		JMenuItem third = createColourItem(COLOURS[2], "Blue"); 
		colourMenu.add(first); 
		colourMenu.add(second); 
		colourMenu.add(third); 
	}
	
	/**
	 * Set up the basic menu as a whole; instantiate the bar, 
	 * instantiate the menu, and add the menu to the bar. 
	 * Bar will be set as the frame's menu bar later. 
	 */
	private void configureMenu(){
		bar = new JMenuBar();  
		colourMenu = new JMenu("Colours");  
		bar.add(colourMenu); 
	}
	
	/**
	 * Create and configure the main panel that actually experiences 
	 * the colour changes. Also declares a MouseListener which is added 
	 * to the panel that allows the user to change the panel's colour 
	 * by clicking it. By default, clicks cycle through the COLOURS as 
	 * declared in the constant array at the top of the file from 
	 * left to right, one by one. 
	 */
	private void configurePanel(){
		class ColourMouseListener implements MouseListener{
			@Override
			public void mouseClicked(MouseEvent e) {
				if (colourPanel.getBackground().equals(COLOURS[0])){
					colourPanel.setBackground(COLOURS[1]);
				} else if (colourPanel.getBackground().equals(COLOURS[1])){
					colourPanel.setBackground(COLOURS[2]);
				} else {
					colourPanel.setBackground(COLOURS[0]); 
				}
			}
			/** do-nothing methods */ 
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		}// end MouseListener 
		colourPanel = new JPanel(); 
		colourPanel.addMouseListener(new ColourMouseListener());
		colourPanel.setBackground(Color.BLACK);
	}
	
	/**
	 * Create a JMenuItem that represents a new choice on the colour menu 
	 * in the frame's menu bar, which, when pressed (creates an ActionEvent), 
	 * changes the colour of the frame's only panel to the desired which is 
	 * defined within this method by programmer parameters. 
	 * @param newColour, Color to be set as the panel's background when 
	 * this item is clicked in the colour menu of the menu bar. 
	 * @param title, text to show within the menu which should indicate 
	 * what colour this button will paint on the panel when chosen. 
	 * @return colourItem, a JMenuItem representing the given colour which 
	 * will, when added to the colour menu, be able to change the colour of 
	 * the panel to the desired when pressed (creating an ActionEvent which 
	 * is handled by MenuListener inner class in this method). 
	 */
	private JMenuItem createColourItem(final Color newColour, final String title){
		JMenuItem colourItem = new JMenuItem(title); 
		
		class MenuListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				colourPanel.setBackground(newColour);
			}
		}
		colourItem.addActionListener(new MenuListener());
		return colourItem; 
	}
	
}
