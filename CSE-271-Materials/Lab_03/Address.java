package lab_three_src;

/**
 * Class to model an address, uses all 
 * taught norms of a java class 
 * 2/10/2017
 * @author Wallisan
 * Instructor: Dr. Stephan 
 * CSE 271, B
 */

public class Address {
	
	// Address vars 
	private int houseNumber; 
	private String street; 
	private String apartmentNumber; 
	private String city; 
	private String state; 
	private String zip; 
	 
	// one constructor for all and one for all but apartment num
	// if not applicable 
	public Address(int houseNumber, String street,
									String apartmentNumber, 
									String city, 
									String state, 
									String zip) {
		this.houseNumber = houseNumber; 
		this.street = street; 
		setApartmentNumber(apartmentNumber); 
		this.city = city; 
		this.state = state; 
		this.zip = zip; 
	}// end main constructor
	
	public Address(int houseNumber, String street,
									String city, 
									String state, 
									String zip) {
		this.houseNumber = houseNumber; 
		this.street = street;  
		this.city = city; 
		this.state = state; 
		setZip(zip); 
	}// end alt constructor
	
	/**
	 * returns String of street address on one line, 
	 * then city, state, and zip code on the next line 
	 * @return String of address to be printed 
	 */
	public String print() {
		return new String("" + this.houseNumber + " " + street + "\n"
				 + city + ", " + state + " " + zip); 
	}// end print() 
	
	/**
	 * @param other, an address to compare to
	 * @return whether current address' zip is 
	 * lower than that of the 'other' given in parameter
	 */
	public boolean comesBefore(Address other){
		if (Integer.parseInt(this.zip) < Integer.parseInt(other.zip)){
			return true; 
		}
		return false; 
	}// end comesBefore() 
	
	/**
	 * get house number
	 * @return houseNumber
	 */
	public int getHouseNumber() {
		return houseNumber;
	}
	
	/**
	 * set house number
	 */
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	/**
	 * get street
	 * @return street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * set street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * get apt number
	 * @return apartmentNumber
	 */
	public String getApartmentNumber() {
		return apartmentNumber;
	}

	/**
	 * set apt number 
	 */
	public void setApartmentNumber(String apartmentNumber) {
		// while the first character is a 0, 
		// cut it off until we get to real numbers 
		String aptNumberCopy = new String(apartmentNumber); 
		while (aptNumberCopy.substring(0,1)=="0"){
			aptNumberCopy = aptNumberCopy.substring(1); 
		}
		// if the end result is pos, set it, 
		// else set it to default -1
		if (Integer.parseInt(aptNumberCopy) > 0){
			this.apartmentNumber = apartmentNumber; 
		} else {
			this.apartmentNumber = "-1"; 
		}
	}

	/**
	 * get city
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * set city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * get state
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * set state 
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * get zip
	 * @return zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * set zip code 
	 */
	public void setZip(String zip) {
		if (zip.length()!=5){
			this.zip = "00000"; 
		} else {
			this.zip = zip; 
		}
	}
	
}// end Address class 
