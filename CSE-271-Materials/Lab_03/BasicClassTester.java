package lab_three_src;

public class BasicClassTester {

	public static void main(String[] args) {
		Student me = new Student("Walter Tracey", 0); 
		System.out.println("My name is " + me.getName());
		me.setName("Walter D Tracey");
		System.out.println("My name is " + me.getName());
		me.setName("");
		System.out.println("My name is " + me.getName());
		me.setName("Walter D Tracey");
		me.addQuiz(100);
		me.addQuiz(-49);
		me.addQuiz(80);
		System.out.println("Current average: " + me.getAverageScore());
		System.out.println("Total score: " + me.getTotalScore());
	}
}
