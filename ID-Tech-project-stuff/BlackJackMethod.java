////////GOOD BLACK JACK CLASS/////////
import java.util.Random;
import java.util.Scanner;

public class BlackJackMethod {
	static int totalPlayer = 0;
	static int totalDealer = 0;
	
	public static int casino(int money){
		Characters mainDude = new Characters(); 
		Scanner response = new Scanner(System.in); 
		boolean isInCasino = true; 
		while(isInCasino == true){
			System.out.println("You are in a casino they have Blackjack, Rock Paper Scissors, and Slot Machines.");
			System.out.println("Do you want to stay in the casino?");
			String Choice = response.nextLine(); 
			if (Choice.equalsIgnoreCase("yes")){
				isInCasino = true; 
			}
			else if (Choice.equalsIgnoreCase("no")){
				System.out.println("Thanks for visiting");
				isInCasino = false; 
				mainDude.moveEast(); 
				return money; 
			}
			System.out.println("You have $" + money);
			System.out.println("Blackjack is played by bet, Rock Paper Scissors is always a $5 buy-in, Slot Machines are $5.");
			System.out.println("To play Blackjack enter 1, to play Rock Paper Scissors enter 2, to use Slot Machines enter 3.");
			Scanner game = new Scanner(System.in);
			int chooseGame = game.nextInt();
			if(chooseGame == 1 ){
				if(money <= 0){
					System.out.println("You're broke M8!");
				}
				else{
				money = Blackjack(money);
				}
			}
			else if(chooseGame == 2){
				if(money <= 0){
					System.out.println("You're broke M8!");
				}
				else if (money > 0){
					boolean win = RPSbattle();
					if( win == true){
						System.out.println("Congrats! You win $5");
						money += 5;
						System.out.println("You have $" + money);
					}
					else if(win == false){
						System.out.println("Bad luck! You're out $5");
						money -= 5;
						System.out.println("You have $" + money);
					}
				}
			}
			else if(chooseGame == 3){
				money -= 5; 
				int result = slotMachine();
				if(result == 2){
					System.out.println("JACKPOT!");
					money += 10000;
				}
				else if(result == 1){
					System.out.println("Nice!");
					money += 500;
				}
				else if(result == 0){
					System.out.println("Winner!");
					money += 100;
				}
				else{
					System.out.println("bad luck");
				}
			}
		}
	
		return money; 
	}
	public static int slotMachine(){
		Random slot = new Random();
		int slotOne = slot.nextInt(6);
		int slotTwo = slot.nextInt(6);
		int slotThree = slot.nextInt(6);
		System.out.print("| " + symbol(slotOne));
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.print(" " + symbol(slotTwo));
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println(" " + symbol(slotThree) + " |"); 
		
		int symbolOne = 6;
		int symbolTwo = 6;
		int symbolThree = 6;
		if (slotOne == 1 || slotOne == 4){symbolOne = 1;}
		else if (slotOne == 0 || slotOne == 3 || slotOne == 5){symbolOne = 0;}
		if (slotTwo == 1 || slotTwo == 4){symbolTwo = 1;}
		else if (slotTwo == 0 || slotTwo == 3 || slotTwo == 5){symbolTwo = 0;}
		if (slotThree == 1 || slotThree == 4){symbolThree = 1;}
		else if (slotThree == 0 || slotThree == 3 || slotThree == 5){symbolThree = 0;}
		
		if(symbolOne == symbolTwo && symbolTwo == symbolThree){
			if(slotOne == 2){
				return 2;
			}
			else if(slotOne == 1 || slotOne == 4){
				return 1;
			}
			else if(slotOne == 0 || slotOne == 3 || slotOne == 5){
				return 0;
			}
		}
		else{
			return 3;
		}
		return 3;
		}
	public static String symbol(int slot){
		if(slot == 0 || slot == 3 || slot == 5){
			return "lemon";
		}
		else if(slot == 1 || slot == 4){
			return "cherry";
		}
		else if(slot == 2){
			return "$";
		}
		return "";
	} 
	public static int Blackjack(int money) {
		boolean redeal; 
		Scanner move = new Scanner(System.in);
		Scanner getBet = new Scanner(System.in);
		
		// while loop to play multiple games
		
		while(money >= 0){
			boolean keepPlaying;
			System.out.println("There is a $50 buy-in, do you want to play?");
			Scanner playing = new Scanner(System.in);
			String input = playing.nextLine();
			if(input.equalsIgnoreCase("yes") && money > 0){
				money -= 50; 
				keepPlaying = true;
			}
			else if (input.equalsIgnoreCase("no")){
				keepPlaying = false;
				//playing.close();
				return money;
			}
			//playing.close();
			totalPlayer = 0;
			totalDealer = 0;
			
			boolean gameOver = false;
			System.out.println("You have " + "$" + money);
			System.out.println("How much would you like to bet? ");
			int bet = getBet.nextInt();
			redeal = false;
			System.out.println("The dealer has " + dealDealer() + ", " + dealDealer());
			System.out.println("Their total is " + totalDealer);
			System.out.println("You have " + dealPlayer() + ", " + dealPlayer());
			System.out.println("Your total is " + totalPlayer);
		
			// if anyone is dealt a hand over 21 it starts a new game
			if(totalDealer > 21 || totalPlayer > 21){
				System.out.println("Re-deal!");
				money += 50; 
				redeal = true;
				gameOver = true;
			}

			while(totalPlayer <= 21 && totalDealer <= 21 && gameOver == false){
				
				System.out.println("Hit or Stay?");
				
				String playerInput2;
				playerInput2 = move.nextLine();
				
				if(playerInput2.equalsIgnoreCase("Hit")){
					System.out.println("You got " + dealPlayer());
					System.out.println("Your total is: " + totalPlayer);
					System.out.println("The dealer has: " + totalDealer);
					
				}
				else if(playerInput2.equalsIgnoreCase("Stay") && totalDealer >= 17){
					if(totalPlayer < totalDealer){
						System.out.println("You Lose!");
						money -= bet;
						System.out.println("You have " + "$" + money);
						gameOver = true;
					}
					else{
						System.out.println("You Win!");
						money += bet;
						System.out.println("You have " + "$" + money);
						gameOver = true;
					}
				}
				// makes dealer hit if they have less than 17
				if(totalDealer < 17){
					System.out.println("Dealer Hits");
					System.out.println("Dealer gets " + dealDealer());
					System.out.println("The dealer now has " + totalDealer);
				}
		}
			
		// takes away your bet from your money if players total is more than 21
		if(totalPlayer > 21 && redeal == false){
			System.out.println("You Lose!");
			money -= bet;
			gameOver = true;
		// gives you your bet if dealers total is more than 21
		}
		else if(totalDealer > 21 && redeal == false){
			System.out.println("You Win!");
			money += bet;
			gameOver = true;
		}
	}
		
	// if you run out of money
	System.out.println("You are out of money!");
	System.out.println(money);
	return money;
	}
	
	// convert random number to card name and keep track of how many points the player has
	
	public static String dealPlayer(){
		Random generator = new Random();
		int card = generator.nextInt(13);
		
		if(card == 0){
			totalPlayer += card + 1;
			return "ace";
		}
		else if(card == 1){
			totalPlayer += card + 1;
			return "two";
		}
		else if(card == 2){
			totalPlayer += card + 1;
			return "three";
		}
		else if(card == 3){
			totalPlayer += card + 1;
			return "four";
		}
		else if(card == 4){
			totalPlayer += card + 1;
			return "five";
		}
		else if(card == 5){
			totalPlayer += card + 1;
			return "six";
		}
		else if(card == 6){
			totalPlayer += card + 1;
			return "seven";
		}
		else if(card == 7){
			totalPlayer += card + 1;
			return "eight";
		}
		else if(card == 8){
			totalPlayer += card + 1;
			return "nine";
		}
		else if(card == 9){
			totalPlayer += card + 1;
			return "ten";
		}
		else if(card == 10){
			totalPlayer += card + 1;
			return "jack";
		}
		else if(card == 11){
			totalPlayer += card + 1;
			return "queen";
		}
		else if(card == 12){
			totalPlayer += card + 1;
			return "king";
		}
		return "";
	}
		
		
		
		// convert random number to card name and keep track of how many points the dealer has	public static String dealDealer(){
	public static String dealDealer(){
		Random generator = new Random();
		int card = generator.nextInt(13);
		
		if(card == 0){
			totalDealer += card + 1;
			return "ace";
		}
		else if(card == 1){
			totalDealer += card + 1;
			return "two";
		}
		else if(card == 2){
			totalDealer += card + 1;
			return "three";
		}
		else if(card == 3){
			totalDealer += card + 1;
			return "four";
		}
		else if(card == 4){
			totalDealer += card + 1;
			return "five";
		}
		else if(card == 5){
			totalDealer += card + 1;
			return "six";
		}
		else if(card == 6){
			totalDealer += card + 1;
			return "seven";
		}
		else if(card == 7){
			totalDealer += card + 1;
			return "eight";
		}
		else if(card == 8){
			totalDealer += card + 1;
			return "nine";
		}
		else if(card == 9){
			totalDealer += card + 1;
			return "ten";
		}
		else if(card == 10){
			totalDealer += card + 1;
			return "jack";
		}
		else if(card == 11){
			totalDealer += card + 1;
			return "queen";
		}
		else if(card == 12){
			totalDealer += card + 1;
			return "king";
		}
		return "";
	}

	public static boolean RPSbattle(){
			Scanner user = new Scanner(System.in); 
			Random computer = new Random(); 
			
			System.out.println("Think fast!");
			System.out.println("Type rock, paper, or scissors: ");
			
			String userChoice; // initializing choices 
			int computerChoice; 
			boolean tie = true; 
			boolean win = true; 
			
			
			while(tie == true){
				userChoice = user.nextLine(); // a choice is made
				computerChoice = computer.nextInt(2); // computer 'makes choice' 
					
				//matching words for computer
				String computerChoiceReal;
				if (computerChoice == 0){
					computerChoiceReal = "rock"; 
				}
				else if (computerChoice == 1){
					computerChoiceReal = "paper"; 
				}
				else {computerChoiceReal = "scissors"; } 
				System.out.println("Your choice: " + userChoice);
				System.out.println("Opponent choice: "+ computerChoiceReal);
					 
				// comparisons
				if (userChoice.equalsIgnoreCase("rock") && computerChoiceReal.equalsIgnoreCase("scissors")){
					System.out.println("You win! The opponent chose " + computerChoiceReal);  
					tie = false;  
					win = true; 
					return win; 
				}
				else if (userChoice.equalsIgnoreCase("scissors") && computerChoiceReal == "paper"){
					System.out.println("You win! The opponent chose " + computerChoiceReal);
					tie = false; 
					win = true; 
					return win; 
				}
				else if (userChoice.equalsIgnoreCase("paper") && computerChoiceReal == "rock"){
					System.out.println("You win! The opponent chose " + computerChoiceReal);
					tie = false;  
					win = true; 
					return win; 
				}
				else if (computerChoiceReal == "rock" && userChoice.equalsIgnoreCase("scissors")) {
					System.out.println("You lose! The opponent chose " + computerChoiceReal);
					tie = false;  
					win = false; 
					return win; 
				}
				else if (computerChoiceReal == "scissors" && userChoice == "paper"){
					System.out.println("You lose! The opponent chose " + computerChoiceReal);
					tie = false;
					win = false; 
					return win; 
				}
				else if (computerChoiceReal == "paper" && userChoice.equalsIgnoreCase("rock")) { 
					System.out.println("You lose! The opponent chose " + computerChoiceReal);
					tie = false;  
					win = false; 
					return win; 
				}
				else {
					System.out.println("No ties! Try again!"); 
				}
			}
		
				return win;
	}
}