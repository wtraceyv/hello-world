package edu.miamioh.traceywd;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class to create a window that will do some 
 * basic currency calculations, showcasing a few 
 * advanced java GUI skills.
 * @author Walter Tracey 
 * Instructor: Dr. Stephan
 * 4/8/2017
 * CSE 271, B
 */
public class CurrencyConversionFrame extends JFrame {
	
	public static final int FRAME_WIDTH = 200; 
	public static final int FRAME_HEIGHT = 200; 
	public static final int DEFAULT_FIELD_LENGTH = 8; 
	public static final String[] CURRENCY_STRINGS = {"USD","EURO","GBP"}; 
	
	// all the big sections for organizing the window
	private JFrame mainFrame; 
	private JPanel resultsPanel; 
	private JPanel inputPanel; 
	private JPanel topInputPanel; 
	private JPanel bottomInputPanel; 
	
	// major components (no static labels; those are simply configured with the panels)
	private JLabel resultText; 
	private JComboBox<String> initialCur; 
	private JComboBox<String> endCur; 
	private JTextField toConvert; 
	private JButton calculate; 
	
	private double initialAmount; 
	
	/**
	 * example for usage of DecimalFormat found at:
	 * https://www.mkyong.com/java/java-display-double-in-2-decimal-points/
	 * some IllegalArgument problems were encountered with its usage in inner 
	 * class CalculateListener, but was fixed by general troubleshooting.
	 */
	private static DecimalFormat rounding = new DecimalFormat(".##"); 

	/**
	 * The constructor...constructs...the thing...
	 * with our beautiful load() method, of course. 
	 */
	public CurrencyConversionFrame() {
		load(); 
	}
	
	// main to kick everything off
	public static void main(String[] args){
		CurrencyConversionFrame frame = new CurrencyConversionFrame(); 
	}
	
	/**
	 * Enact all the compartmentalized configuring helper methods 
	 * in the appropriate order, then place this single method in the 
	 * frame's constructor to build everything. 
	 */
	private void load(){
		configureTopInputPanel();
		configureBottomInputPanel(); 
		configureInputPanel();
		configureResultsPanel();
		configureFrame();
	}
	
	/**
	 * Set up the basic frame's dimensions, title, 
	 * close operations, etc, and place the two 
	 * main panels in the appropriate positions on the 
	 * default BorderLayout. Pack() to start off with 
	 * components clearly visible and window efficiently 
	 * sized. 
	 * 
	 * Always place last in load(), as forming the frame requires that 
	 * the two main panels with all content be constructed, 
	 * or else null pointers will be plentiful. 
	 */
	private void configureFrame(){
		mainFrame = new JFrame("Currency Calculations"); 
		mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.add(resultsPanel,BorderLayout.NORTH); 
		mainFrame.add(inputPanel,BorderLayout.CENTER); 
		mainFrame.pack();
	}
	
	/**
	 * Create and add, in appropriate order, components of 
	 * the top grid section of the larger inputPanel, which holds the 
	 * combo boxes for choosing currencies and their labels. 
	 */
	private void configureTopInputPanel(){
		// create or just add (flow) JLabels and combo boxes 
		topInputPanel = new JPanel(); 
		JLabel from = new JLabel("From: "); 
		JLabel to = new JLabel("To: "); 
		initialCur = new JComboBox<String>(CURRENCY_STRINGS); 
		endCur = new JComboBox<String>(CURRENCY_STRINGS); 
		topInputPanel.add(from); 
		topInputPanel.add(initialCur); 
		topInputPanel.add(to); 
		topInputPanel.add(endCur); 
	}
	
	/**
	 * Create and add components of lower grid section to the inputPanel, 
	 * including the JTextField for entering the amount to convert, the calculate 
	 * button for enacting the conversion, and a JLabel. 
	 * Method is considerably longer than most due only to the inner 
	 * class ActionListener, which seems less cumbersome, better-placed, 
	 * more cohesive, etc, right in the method where the button is 
	 * created since it is only used for one component. 
	 */
	private void configureBottomInputPanel(){
		// form the panel, create the basic components to be added to it
		bottomInputPanel = new JPanel(); 
		JLabel inputLabel = new JLabel("To convert:"); 
		toConvert = new JTextField(DEFAULT_FIELD_LENGTH); 
		calculate = new JButton("Calculate");
		
		// local inner class ActionListener for the calculate button
		class CalculateListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				// catch, error message, return early on if currencies are the same
				if (initialCur.getSelectedIndex()==endCur.getSelectedIndex()){
					// apparently showMessageDialog is preferred to be called statically, so 
					// there is no instance of JOptionPane needed or constructed anywhere (Eclipse indicated this)
					JOptionPane.showMessageDialog(bottomInputPanel, "Please choose differing currencies!", "Bad input",JOptionPane.ERROR_MESSAGE,null);
					return; 
				}
				// safely parse the given amount and indicate results if currencies are indeed different
				initialAmount = Double.parseDouble(toConvert.getText());
				String formattedAmount = rounding.format(initialAmount); 
				String formattedEndAmount = rounding.format(convertCurrency(initialAmount,initialCur.getSelectedIndex(),endCur.getSelectedIndex())); 
				resultText.setText(""+formattedAmount+" "+CURRENCY_STRINGS[initialCur.getSelectedIndex()]+" = "+formattedEndAmount + " " + CURRENCY_STRINGS[endCur.getSelectedIndex()]);
			}
		}
		calculate.addActionListener(new CalculateListener());// add one of those suckers
		// add all new components, finishing this panel
		bottomInputPanel.add(inputLabel); 
		bottomInputPanel.add(toConvert); 
		bottomInputPanel.add(calculate); 
	}
	
	/**
	 * Format main input panel with GridLayout to hold 
	 * top/bottom input panels with actual components. 
	 */
	private void configureInputPanel(){
		inputPanel = new JPanel(new GridLayout(2,1)); 
		inputPanel.add(topInputPanel); 
		inputPanel.add(bottomInputPanel); 
	}
	
	/**
	 * Form resultsPanel with only the JLabel displaying results, 
	 * set it at default to some phrase before an actual calculation 
	 * is made. Reset text to show results when they are needed using 
	 * the ActionListener.
	 */
	private void configureResultsPanel(){
		resultsPanel = new JPanel(); 
		resultText = new JLabel("Convert ... those ... currencies!"); 
		resultsPanel.add(resultText); 
	}
	
	/**
	 * Method to convert some double amount of an initCurrency (USD, EURO, or GBP) into the 
	 * equivalent in the endCurrency (USD, EURO, or GBP), returning the result as a double. 
	 * Because the method is static and should be able to be used outside this frame class, 
	 * the final case where initCurrencyIndex and endCurrencyIndex are the same is accounted for, 
	 * returning simply the original amount given; however, this program accounts for that as an 
	 * error and does not perform the calculation anyway so it shouldn't be triggered here. 
	 * @param amount, double representing initial quantity of initial currency to convert
	 * @param initCurrencyIndex, int, index of initial currency JComboBox currently selected. Was originally 
	 * the String form, but making comparisons was not very functional (.equals() method 
	 * was not returning as expected, but works perfectly using only int indicators) 
	 * @param endCurrencyIndex, int, index of goal currency JComboBox currently selected. 
	 * @return a double representing the amount of the goal currency (endCurrency) equivalent 
	 * to the given quantity of original currency (initCurrency) 
	 */
	private static double convertCurrency(double amount,int initCurrencyIndex,int endCurrencyIndex){
		if (initCurrencyIndex==0&&endCurrencyIndex==1){
			return (amount/1.42);  
		} else if (initCurrencyIndex==0&&endCurrencyIndex==2){
			return (amount/1.64); 
		} else if (initCurrencyIndex==1&&endCurrencyIndex==0){
			return (amount*1.42); 
		} else if (initCurrencyIndex==1&&endCurrencyIndex==2){
			return (amount/1.13); 
		} else if (initCurrencyIndex==2&&endCurrencyIndex==0){
			return (amount*1.64); 
		} else if (initCurrencyIndex==2&&endCurrencyIndex==1){
			return (amount*1.13); 
		} else {
			return amount; 
		}
	}

}
