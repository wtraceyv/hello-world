package lab_three_src;

/**
 * class to model Student object based on their 
 * quiz scores, average of those scores, and name
 * @author Wallisan
 * Instructor: Dr. Stephan 
 * CSE 271, B 
 * 15 February, 2017
 */
public class Student {
	
	// instance vars track individual's stats 
	private String name; 
	private int totalScore; 
	private int numberQuizzesTaken; 
	
	/**
	 * construct student object with a name 
	 * and starting score if > 0
	 * @param name
	 * @param initialTotalQuizScore
	 */
	public Student(String name, int initialTotalQuizScore){
		setName(name);  
		setTotalScore(initialTotalQuizScore);  
	}

		/**
		 * @return registered name of Student object 
		 */
	public String getName() {
		return name;
	}

	/**
	 * Reset name of Student object as different 
	 * than in constructor; defaults to "No-name" 
	 * if parameter is blank 
	 * @param name
	 */
	public void setName(String name) {
		if (name.equals("")){
			this.name = "No-name"; 
			return; 
		}
		this.name = name;
	}

	/**
	 * @return int representing Student object's 
	 * current recorded total score 
	 */
	public int getTotalScore() {
		return totalScore;
	}

	/**
	 * sets Student's total score if within range 
	 * of positive ints; defaults to -1 if not 
	 * @param totalScore
	 */
	public void setTotalScore(int totalScore) {
		if (totalScore < 0 || totalScore > Integer.MAX_VALUE){
			this.totalScore = -1; 
			return; 
		}
		this.totalScore = totalScore;
	}
	
	/**
	 * adds new quiz's score as parameter to total, 
	 * increments quizzes taken for use in average 
	 * method
	 * @param score
	 */
	public void addQuiz(int score){
		// make sure new score is valid 
		if (score < 0 || score > 100){
			return; 
		}
		// score is valid, increment number taken for 
		// average method and add score 
		numberQuizzesTaken++; 
		totalScore += score; 
	}// end addQuiz() 
	
	/**
	 * @return truncated int average of quiz scores archived for student 
	 */
	public int getAverageScore(){
		return (int) (this.totalScore / this.numberQuizzesTaken); 
	}
	
}// end Student class 
