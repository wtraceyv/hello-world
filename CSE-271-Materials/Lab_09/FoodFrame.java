package edu.miamioh.traceywd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Extends JFrame to create a menu for the world famous 
 * Spaghetteria, featuring a GUI with 10 buttons for adding 
 * generic menu foods, fields and a button for adding unique/unpopular items, 
 * and a text area and button for showing a running tab of 
 * items added and totaling the cost of the items with tax and tip 
 * at set rates. 
 * @author Walter Tracey 
 * Instructor: Dr. Stephan 
 * 4/4/2017
 * CSE 271, B
 */
public class FoodFrame extends JFrame {
	
	// Several constants to be changed as desired that 
	// affect frame dimensions and end calculations for the bill 
	private static final int FRAME_WIDTH = 550; 
	private static final int FRAME_HEIGHT = 550; 
	private static final double TIP_RATE = .15; 
	private static final double TAX_RATE = .07;
	private static final int TEXT_FIELD_LENGTH = 12; 

	private double currentTotal = 0; // duh 
	
	private JPanel panel = new JPanel(); 
	private JFrame mainFrame = new JFrame("Spaghetteria Menu!"); 
	
	// for "unpopular items" adding, second to last grouping
	private JTextField obscureOptionItem;
	private JTextField obscureOptionPrice;
	private JButton obscureAddButton; 
	
	// the last components to be added and used in the frame
	private JTextArea tabArea;
	private JLabel totalLabel;
	private JButton calculate; 
	
	// all the basic buttons to add generic menu foods 
	private FoodButton firstOption = new FoodButton("Pepperoni Pizza",10.75); 
	private FoodButton secondOption = new FoodButton("Cheese Pizza",9.25);
	private FoodButton thirdOption = new FoodButton("Mozzerella Sticks",8.50);
	private FoodButton fourthOption = new FoodButton("Spaghetti",10.00);
	private FoodButton fifthOption = new FoodButton("Double Betty Spaghetti",17.25);
	private FoodButton sixthOption = new FoodButton("Deep Pan Pizza",13.00);
	private FoodButton seventhOption = new FoodButton("Piece of Lasagna",5.50);
	private FoodButton eighthOption = new FoodButton("Full Lasagna",11.25);
	private FoodButton ninthOption = new FoodButton("Full Family Lasagna",20.99);
	private FoodButton tenthOption = new FoodButton("Personal Pizza",5.25); 

	/**
	 * The constructor constructs...things 
	 * Like FoodFrames! 
	 */
	public FoodFrame() {
		loadComponentsAndPanel();  
		configureMainFrame(); 
	}
	
	/**
	 * Main to get everything running (decided not to make
	 * another class for this).
	 * @param args, command line arguments (unused) 
	 */
	public static void main(String[] args){
		FoodFrame testFrame = new FoodFrame(); 
	}
	
	/**
	 * Helper method that groups all loading helper methods together, 
	 * further clearing up the FoodFrame constructor. 
	 * 'Cause I heard you like helper methods. 
	 */
	private void loadComponentsAndPanel(){
		// seriously, if you like helper methods here you go: 
		loadBasicOptions();
		loadObscureOptionItems(); 
		loadTab(); 
		loadCalculation(); 
	}
	
	/**
	 * Inner class to dictate basic button actions; sacrifices cohesion 
	 * in the interest of encapsulation and not using too many 
	 * ActionListeners or letting all of FoodFrame's instance variables 
	 * be public static so they are actually accessible. 
	 * When triggered, casts the source to a FoodButton and uses 
	 * its getters to add its food's price and label the order's 
	 * total and tab listing respectively. Also updates the total 
	 * label to show the total at the moment. 
	 */
	class FoodButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if (event.getSource() instanceof FoodButton){
				FoodButton toUse = (FoodButton) event.getSource(); 
				tabArea.append(toUse.getLabel()+"\n");
				currentTotal += toUse.getPrice(); 
				totalLabel.setText("Current total: " + currentTotal);
			} 
		}
	}
	
	/**
	 * ActionListener specifically for the button that adds an 
	 * 'unpopular' item to the tab along with its given price.
	 * Similar functionality to FoodButtonListener, but works 
	 * with some text fields to get the values needed.
	 */
	class OddItemButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			String food = obscureOptionItem.getText();
			double price = Double.parseDouble(obscureOptionPrice.getText());
			currentTotal += price; 
			tabArea.append(food+" "+price+"\n");
			totalLabel.setText("Current total: " + currentTotal);
		}
	}
	
	/**
	 * ActionListener specifically for the button that adds 
	 * in tax/tip information to the current total; also 
	 * changes "total" label and clears tab to indicate the tax/tip is 
	 * totaled in and the whole order should be done now. 
	 * Though it clears the tab, user can choose more foods and 
	 * add to already-accumulated order. To be truly cleared, user 
	 * must restart the program. 
	 */
	class CalculateListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			currentTotal = (currentTotal * FoodFrame.TAX_RATE) + currentTotal; 
			currentTotal = (currentTotal * FoodFrame.TIP_RATE) + currentTotal; 
			totalLabel.setText("Calculated w/ tax and tip: " + currentTotal);
			tabArea.setText("Total calculated.\n");
		}
	}
	
	/**
	 * Give all the main FoodButtons their ActionListener
	 * and add them to the main panel. 
	 */
	private void loadBasicOptions(){
		firstOption.addActionListener(new FoodButtonListener()); 
		secondOption.addActionListener(new FoodButtonListener());  
		thirdOption.addActionListener(new FoodButtonListener());  
		fourthOption.addActionListener(new FoodButtonListener()); 
		fifthOption.addActionListener(new FoodButtonListener()); 
		sixthOption.addActionListener(new FoodButtonListener()); 
		seventhOption.addActionListener(new FoodButtonListener()); 
		eighthOption.addActionListener(new FoodButtonListener()); 
		ninthOption.addActionListener(new FoodButtonListener()); 
		tenthOption.addActionListener(new FoodButtonListener()); 
		panel.add(firstOption); 
		panel.add(secondOption);
		panel.add(thirdOption);
		panel.add(fourthOption);
		panel.add(fifthOption);
		panel.add(sixthOption);
		panel.add(seventhOption);
		panel.add(eighthOption);
		panel.add(ninthOption);
		panel.add(tenthOption);
	}
	
	/**
	 * Add the text fields for entering the info for 
	 * unpopular items to the panel, create and add the button for 
	 * entering that item to the panel. 
	 * Also includes anonymous JLabels for the sake of 
	 * quick, easy labeling on the text fields. 
	 */
	private void loadObscureOptionItems(){
		obscureOptionItem = new JTextField("",FoodFrame.TEXT_FIELD_LENGTH); 
		obscureOptionPrice = new JTextField("",FoodFrame.TEXT_FIELD_LENGTH); 
		panel.add(new JLabel("Unique item: ")); 
		panel.add(obscureOptionItem); 
		panel.add(new JLabel("Unique item price: ")); 
		panel.add(obscureOptionPrice); 
		obscureAddButton = new JButton("Add your item"); 
		obscureAddButton.addActionListener(new OddItemButtonListener());
		panel.add(obscureAddButton); 
	}
	
	/**
	 * Configures and adds to the panel the 
	 * JTextArea "tab" that lists the foods added 
	 * along with their prices (w/ scroll pane! ooh!).
	 */
	private void loadTab(){
		tabArea = new JTextArea(16,20); 
		tabArea.setEditable(false);
		tabArea.setVisible(true);
		panel.add(tabArea); 
		panel.add(new JScrollPane(tabArea)); 
	}
	
	/**
	 * Load the button and actions that allow 
	 * the frame to show the calculation with taxes, etc., 
	 * also adding it to the main panel. 
	 */
	private void loadCalculation(){
		calculate = new JButton("Calculate w/ tax and tip"); 
		calculate.addActionListener(new CalculateListener());
		panel.add(calculate); 
		totalLabel = new JLabel("Current total: " + currentTotal); 
		panel.add(totalLabel);
	}
	
	/**
	 * Shape, configure the basic outer frame and 
	 * finally add the panel in with all its 
	 * added components. 
	 */
	private void configureMainFrame(){
		mainFrame.add(panel);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		mainFrame.setVisible(true);
	}
	
}
