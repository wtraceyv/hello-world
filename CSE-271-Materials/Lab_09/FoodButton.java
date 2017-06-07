package edu.miamioh.traceywd;

import javax.swing.JButton;

/**
 * Extends JButton to model a button which is associated 
 * with a certain food (with some name) and its associated price 
 * as instantiated. Used in FoodFrame.
 * @author Walter Tracey 
 * Instructor: Dr. Stephan 
 * 4/4/2017
 * CSE 271, B
 */
public class FoodButton extends JButton {
	
	private String food; 
	private double price;

	public FoodButton(String food, double price) {
		super(food+" "+price);
		this.food = food; 
		setPrice(price); 
	}

	/**
	 * Get this FoodButton's food instance var, its designated 
	 * food's name. 
	 * @return food, this FoodButton's designated food's name. 
	 */
	public String getFood() {
		return food;
	}

	/**
	 * Get this FoodButton's designated price for its 
	 * assigned food. 
	 * @return price, this FoodButton's designated food's 
	 * price as a double value. 
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Smart set this FoodButton's price to be 
	 * above 0 at all costs (although it's not 
	 * really checkable until after the Button is 
	 * constructed so its not entirely 
	 * necessary). 
	 * @param price, the desired price of the food 
	 * represented by this FoodButton. 
	 */
	public void setPrice(double price) {
		if (price < 0){
			this.price = 999; 
			return; 
		}
		this.price = price; 
	}
	
	/**
	 * Get this FoodButton's designated food's 
	 * "label", which is simply the food's name 
	 * and price to be displayed on a FoodButton 
	 * instance elsewhere if desired. 
	 * @return a String representing the preferred 
	 * thing to be displayed ON this instantiated FoodButton. 
	 */
	public String getLabel(){
		return this.food + " " + this.price; 
	}

}
