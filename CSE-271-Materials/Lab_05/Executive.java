package lab_five_src;

public class Executive extends Manager {
	
	private String officeLocation; 

	// one constructor; uses super() 
	public Executive(String name, int salary, String department, String officeLocation) {
		super(name, salary, department);
		setOfficeLocation(officeLocation); 
	}
	
	/**
	 * smart set officeLocation
	 * @param location
	 */
	public void setOfficeLocation(String location){
		if (location!=null && location.length()!=0){
			this.officeLocation = location; 
		} else {
			this.officeLocation = "the corner of...uh, I'll get back to you"; 
		}
	}
	
	/**
	 * @return Executive's officeLocation
	 */
	public String getOfficeLocation(){
		return this.officeLocation; 
	}
	
	/**
	 * Override toString() to better suit Executive 
	 */
	@Override
	public String toString(){
		return super.toString() + "Yet more specifically, I'm an executive! My office is at " + this.getOfficeLocation() +".\n"; 
	}

}// end Executive class 
