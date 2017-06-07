package lab_five_src;

public class Employee {
	
	private String name; 
	private int salary; 
	
	public Employee(String name, int salary){
		setName(name); 
		setSalary(salary); 
	}
	
	/**
	 * smart set name of Employee
	 * @param name
	 */
	public void setName(String name){
		if (name!=null && name.length()!=0){
			this.name = name; 
		} else {
			this.name = "No-name"; 
		}
	}
	
	/**
	 * @return name of Employee
	 */
	public String getName(){
		return this.name; 
	}
	
	/**
	 * smart set salary of Employee
	 * @param salary
	 */
	public void setSalary(int salary){
		// no one earns $10,000,000 salaries
		if (salary > 0 && salary < 10000000){
			this.salary = salary; 
		} else {
			this.salary = 0; 
		}
	}
	
	/**
	 * @return salary of Employee
	 */
	public int getSalary(){
		return this.salary; 
	}
	
	/**
	 * Override toString() to better represent an employee
	 */
	@Override
	public String toString(){
		return "Hi! My name is " + this.name + ", working here on a " + this.salary + " unit salary.\n"; 
	}
	
}// end Employee class 
