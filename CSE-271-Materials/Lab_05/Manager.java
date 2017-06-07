package lab_five_src;

public class Manager extends Employee {
	
	private String department; 

	public Manager(String name, int salary, String department) {
		super(name, salary);
		setDepartment(department); 
	}
	
	/**
	 * smart set Manager department String 
	 * @param dept
	 */
	public void setDepartment(String dept){
		if (dept!=null && dept.length()!=0){
			this.department = dept; 
		} else {
			this.department = "Hygeine"; 
		}
	}
	
	/**
	 * @return String department of Manager
	 */
	public String getDepartment(){
		return this.department; 
	}
	
	/**
	 * Override toString() to better represent a Manager
	 */
	@Override
	public String toString(){
		return super.toString() + "More specifically, I'm a manager in the " + this.department + " department.\n"; 
	}

}// end Manager class 
