package lab_five_src;

public class EmployeeTester {

	public static void main(String[] args) {
		// test Employee constructor 
		Employee newGuy = new Employee("Jimbo",20000); 
		System.out.println("Employee object's name should be Jimbo, salary 20,000.");
		System.out.println("Name: " + newGuy.getName() + "\nSalary: " + newGuy.getSalary());
		// test toString 
		System.out.println("toString should print:\nHi! My name is Jimbo, working here on a 20000 unit salary.");
		System.out.println("Actual toString:\n" + newGuy + "\n");
		
		// test Manager constructor 
		Manager slightlyHigherUpGuy = new Manager("Boris",35000,"Human Resources"); 
		System.out.println("Manager object's name should be Boris, salary 35,000. Department is Human Resources.");
		System.out.println("Name: "+slightlyHigherUpGuy.getName()+"\nSalary: "+slightlyHigherUpGuy.getSalary()+ 
				"\nDepartment: "+slightlyHigherUpGuy.getDepartment());
		// test toString
		System.out.println("toString should print:\nHi! My name is Boris, working here on a 35000 unit salary." +
				"\nMore specifically, I'm a manager in the Human Resources department."); 
		System.out.println("Actual toString:\n" + slightlyHigherUpGuy + "\n");
		
		// test Executive constructor 
		Executive boss = new Executive("Bill",100000,"Finances","the CEOs' corner"); 
		System.out.println("Executive is named Bill, salary 100,000, dept. Finances, office location \"the CEOs' corner\"");
		System.out.println("Name: "+boss.getName()+"\nSalary: "+boss.getSalary() + 
				"\nDepartment: "+boss.getDepartment()+"\nOffice Location: "+boss.getOfficeLocation()); 
		System.out.println("toString should print:\nHi! My name is Bill, working here on a 100000 unit salary."
				+"\nMore specifically, I'm a manager in the Finances department." + 
				"\nYet more specifically, I'm an executive! My office is at the CEOs' corner.");
		System.out.println("Actual toString:\n"+boss);
	}

}// end EmployeeTester class
