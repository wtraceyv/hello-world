package edu.miamioh.traceywd;

/**
 * Class to model a Person with email and ID, 
 * (associated with a University) from which some other 
 * classes will extend. 
 * CSE 271, B
 * @author Walter Tracey 
 * Instructor: Dr. Stephan
 * 3/28/2017
 */
public class Person {
	
	private String email; 
	private String identification; 

	/**
	 * Construct a Person instance by 
	 * smart setting its parameters.
	 */
	public Person(String email, String identification) {
		setEmail(email); 
		setIdentification(identification); 
	}

	/**
	 * Get this Person's email address
	 * @return email, this instance email 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Smart set email to necessarily contain an "@" 
	 * and have length > 0, or else it is given a default
	 * @param email
	 */
	public void setEmail(String email) {
		if (!email.contains("@") || email.length()==0){
			this.email = "default-email@gmail.com"; 
			return; 
		}
		this.email = email;
	}

	/**
	 * Get this Person's ID number 
	 * @return identification, this instance's instance ID 
	 */
	public String getIdentification() {
		return identification;
	}

	/**
	 * Smart set identification to contain exactly 5 
	 * NUMBERS, or else it will be randomly chosen. 
	 * @param identification
	 */ 
	public void setIdentification(String identification) {
		 if (identification.length()!=5){
			 this.identification = randomGeneratedIDNum(); 
			 return; 
		 }
		 for (int i = 0; i < identification.length(); i++){
				if (!Character.isDigit(identification.charAt(i))){
					this.identification = randomGeneratedIDNum(); 
					return; 
				}
		 }
		 // if it makes it down here, it's fine:
		 this.identification = identification; 
	}
	
	/**
	 * Helper method to generate a new random ID# for a Person if the given 
	 * is invalid in any way (wrong length, char other than just numbers, etc.) 
	 * @return
	 */
	private String randomGeneratedIDNum(){
		String endNewID = ""; 
		for (int i = 0; i < 5; i++){
			int rand = (int) (10*Math.random());
			endNewID += rand; 
		}
		return endNewID; 
	}

}
