package lab_three_src;

/**
 * class to act as a machine that tracks votes...
 * options are to vote democrat/republican or clear machine 
 * after creating it
 * @author Wallisan
 * Instructor: Dr. Stephan 
 * CSE 271, B 
 * 15 February, 2017
 */
public class VotingMachine {
	
	// instance vars to track tallies 
	private int democratVotes; 
	private int republicanVotes; 
	
	/**
	 * increment amount of republican votes 
	 * on this voting machine 
	 */
	public void voteRepublican(){
		this.republicanVotes++; 
	}
	
	/**
	 * increment amount of democrat votes 
	 * on this voting machine 
	 */
	public void voteDemocrat(){
		this.democratVotes++; 
	}
	
	/**
	 * @return amount current democrat votes
	 */
	public int getDemocratTallies(){
		return this.democratVotes; 
	}
	
	/**
	 * @return amount current republican votes
	 */
	public int getRepublicanTallies(){
		return this.republicanVotes; 
	}
	
	/**
	 * clear the machine of all amassed tallies
	 */
	public void clear(){
		this.democratVotes = 0; 
		this.republicanVotes = 0; 
	}
	
}// end VotingMachine class 
