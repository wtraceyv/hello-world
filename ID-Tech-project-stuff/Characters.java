import java.util.Scanner;  
import java.util.Random; 

public class Characters {
	
	String name = "default"; 
	int money = 100; // do change this if you want 
	int atmMoney = 1000000; // this too 
	int drinks = 0; 
	boolean isAlive = true; 
	boolean isInMall = false; 
	boolean isInCasino = false; //ADD LOCATION TO ADVENTURE TO TURN OFF WHEN LEAVING
	public boolean isInBar = false;
	static Scanner prompt = new Scanner(System.in);
	static Scanner promptNumber = new Scanner(System.in); 
	static Random luck = new Random(); 
	//boolean inBounds = true; USE IF NEEDED 
	
	public static int[] coordinates = {0,0};
	public static int[] mallCoordinates = {-1,0}; // up/back vs right/left
	public static int[] rightCoordinates = {0,0}; 
	public static int[] barCoordinates = {-1,0}; 
	public void moveNorth(){
		this.coordinates[0] ++;
		this.mallCoordinates[1] ++; 
		this.rightCoordinates[1] --; 
		this.barCoordinates[0] --; 
	}
	public void moveEast(){
		this.coordinates[1] ++;
		this.mallCoordinates[0] --; 
		this.rightCoordinates[0] ++; 
		this.barCoordinates[1]--; 
	}
	public void moveSouth(){
		this.coordinates[0] --;
		this.mallCoordinates[1] --;
		this.rightCoordinates[1] ++; 
		this.barCoordinates[0] ++; 
	}
	public void moveWest(){
		this.coordinates[1] --;
		this.mallCoordinates[0] ++;
		this.rightCoordinates[0] --;
		this.barCoordinates[1] ++; 
	}
	//////////////////////ARRIVING AT PLACES/// burger shot///////////////////////////////////
	public static void frontOfBurgerPlace(){
		System.out.println("You're in front of the local burger joint. You face down the sidewalk, such that the joint is to your left, and you notice a blaring casino farther down the walk.");
	}
	public void burgerShot(){
		String foodStop = "no"; 
		while (foodStop.equalsIgnoreCase("no")){
			System.out.println("Welcome to Burger Shot duuuuude! We like, totally have the\n'Heart Stopper' BURGER\nSeldom Bought SALAD\nArtery Cloggin' ARTICHOKES\nTUBULAR!");
			System.out.println("*Pick something, or leave.*");
			String foodChoice = prompt.nextLine(); 
			if (foodChoice.equalsIgnoreCase("burger")){
				if (this.money >= 5){
					System.out.println("Sure! That'll be 5 dollars.");
					this.money -= 5; 
					System.out.println("*currently hoping you don't die of a ... ehem ... HEART ATTACK*");
				}
				else {System.out.println("Oh, you look a little broke hombre. Maybe try the salad?");}
			}
			else if (foodChoice.equalsIgnoreCase("salad")){
				if (this.money >= 4){
					System.out.println("Sounds like a safe choice, huh bro? 4 dollars.");
					this.money -= 4; 
				}
				else {System.out.println("Not even enough for a salad bro! You're not looking for donations, right?"); } 
			}
			else if (foodChoice.equalsIgnoreCase("artichokes")){
				System.out.println("Haha you're kidding, right bro?");
			}
			else if (foodChoice.equalsIgnoreCase("leave")){
				System.out.println("Thanks for visiting, bro.");
				System.out.println("*Between you and me... that guy didn't sound so bright. He WOULD work at 'Burger Shot'*"); 
				this.moveEast();
				foodStop = "yes"; 
			}
		}
	}
	// ENTERING MALL PROMPT
	public static void intoMall(){
		System.out.println("Hm, the mall entrance. A theater to your right, laser tag to your left, and an atm beyond that laser tag center. Interesting.");
	}
	// laser tag location
	public void laserTag(){
		int laserTagLuck = luck.nextInt(100); 
		if (laserTagLuck <= 50){
			System.out.println("Oops, they're closed at the moment.");
			this.moveNorth(); 
		}
		else {
			int luckyWin = luck.nextInt(5)+17; 
			int luckyLose = luck.nextInt(5)+6; 
			System.out.println("You play a rousing game with the local kids, to their defeat " + luckyWin + " to " + luckyLose);
			this.moveNorth();
		}
	}
	// THEATER LOCATION
	public void theater(){
		System.out.println("Ah, the theater.");
		System.out.println("Will it be Star Wars VIII or I?");
		String theaterAnswer = prompt.nextLine(); 
		if (theaterAnswer.equalsIgnoreCase("i")){
			System.out.println("       _______.___________.    ___      .______         ");
			System.out.println("      /       |           |   /   \\     |   _  \\        ");
			System.out.println("     |   (----`---|  |----`  /  ^  \\    |  |_)  |       ");
			System.out.println("      \\  \\       |  |      /  /_\\  \\   |      /        ");
			System.out.println("  .----)   |      |  |     /  _____  \\  |  |\\  \\----.   ");
			System.out.println("  |_______/       |__|    /__/     \\__\\ | _| `._____|   ");
			System.out.println("                                                        ");
			System.out.println("  ____    __    ____  ___      .______          _______.");
			System.out.println("  \\   \\  /  \\  /   / /   \\     |   _  \\        /       |");
			System.out.println("   \\   \\/    \\/   / /  ^  \\    |  |_)  |      |   (----`");
			System.out.println("    \\            / /  /_\\  \\   |      /        \\   \\    ");
			System.out.println("     \\    /\\    / /  _____  \\  |  |\\  \\----.----)   |   ");
			System.out.println("      \\__/  \\__/ /__/     \\__\\ | _| `._____|_______/    ");
			try {
			    Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			System.out.println("Wrong!");
			this.money -= 40; 
			System.out.println("Looks like they knocked you out and stole 40 dollars from you... tisk tisk. Everyone knows the first one sucks.");
			this.moveSouth();
		}
		else {
			System.out.println("Oh yeah sorry that movie isn't out yet..."); 
			this.moveSouth();
		}
	}
	// moving forward in the bar  
	public void barDrink(){
		if (this.drinks < 5){
			System.out.println("Welllll, now that you're here, might as well have a pint.");
			System.out.println("1 - redbull, $5\n2 - Monster, $4\n3 - sprite, $2\n4 - Samantha's Special coffee");
			int drinkChoice = promptNumber.nextInt(); //ADD REJECTION IF NO MONEY
			if(drinkChoice == 1){
				System.out.println("Five bucks, please. You have fun with that, hombre.");
				this.money -= 5; 
				this.moveNorth();
				this.drinks ++; 
			}
			else if (drinkChoice == 2){
				System.out.println("In soviet Russia, Monster drinks YOU! HAHAHAhahaheheheh...");
				System.out.println("Four bucks...");
				this.money -= 4; 
				this.moveNorth();
				this.drinks ++;
			}
			else if (drinkChoice == 3){
				System.out.println("I'm proud of you, bud. And two dollar Sprite's a good choice.");
				this.money -= 2; 
				this.moveNorth();
			}
			else if (drinkChoice == 4){
				System.out.println("My girlfriend invented this for me! It's delicious, I promise.\nThree dollars, please.");
				this.money -= 3;
				this.moveNorth();
			}
		}
		else if (this.drinks >= 5){
			System.out.println("Uh, you look like you've had a few too many. You can have coffee or sprite.");
			System.out.println("1 - sprite, $2\n2 - Samantha's Special coffee");
			int drinkChoice = promptNumber.nextInt(); 
			if (drinkChoice == 1){
				System.out.println("I'm proud of you, bud. And two dollar Sprite's a good choice.");
				this.money -= 2; 
				this.moveNorth();
				this.drinks = 0; 
			}
			else if (drinkChoice == 2){
				System.out.println("My girlfriend invented this for me! It's delicious, I promise.\nThree dollars, please.");
				this.money -= 3;
				this.moveNorth();
				this.drinks = 0; 
			}
		}
	}
	////////////////////////////
	// moving right in bar
	public void barFight(){
		System.out.println("OUCH, that guy WAS burly. Definitely didn't like that look you gave him");
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println("Hey, kid? You alive?");
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		this.death();
	}
	
	// ATM OR MONEY METHODS ////////////
	public void withdraw(int amount){
		if (amount <= this.atmMoney) {
			this.money += amount;
			this.atmMoney -= amount;
		}
		else {System.out.println("You're not THAT rich! No way!");
		}
	}
	public void deposit(int amount){
		if (amount <= this.money){
			this.money -= amount;
			this.atmMoney += amount;
		} 
		else {System.out.println("You're going to need to earn that money before you save it...");
		}
	}
	public void atmArrive(){
		String atmAnswer = "no"; 
		while (atmAnswer.equalsIgnoreCase("no")){
			System.out.println("Well, what'll it be? Withdraw? Deposit? Leave? We haven't got all day, you know. At least I don't.");
			String atmChoice = prompt.nextLine(); 
			if (atmChoice.equalsIgnoreCase("deposit")){
				System.out.println("How much are you depositing?");
				int depositAmount = promptNumber.nextInt(); 
				deposit(depositAmount); 
				moneyCheck(); 
			}
			else if (atmChoice.equalsIgnoreCase("withdraw")){
				System.out.println("How much are you withdrawing?");
				int withdrawAmount = promptNumber.nextInt(); 
				withdraw(withdrawAmount); 
				moneyCheck(); 
			}
			else if (atmChoice.equalsIgnoreCase("leave")){
				System.out.println("Alrighty then.");
				moneyCheck(); 
				this.moveNorth();
				atmAnswer = "yes"; 
			}
		}
	}
	public void moneyCheck(){
		System.out.println("Looks like you've got " + this.money + " dollars in pocket, " + this.atmMoney + " in the ATM.");
	}
	////////////////DONE ATM METHODS////////////
	
	////////////CHECK MAP////////////////////////////////////////////////
	public void mapCheck(){
		if(this.isInMall == true){
			System.out.println("-------------------------------------------");
			System.out.println("|____                              |      |");
			System.out.println("|    |                     the     |   |  |");
			System.out.println("|    | -Casino            road >   |      |");
			System.out.println("|    |                             |   |  |");
			System.out.println("|    |                             |      |");
			System.out.println("|____|                             |   |  |");
			System.out.println("|    |                             |      |");
			System.out.println("|    | -Burger Shot                |   |  |");
			System.out.println("|____|                gas station  |      |");
			System.out.println("|____| -A wall                ^__  |   |  |");
			System.out.println("|    | -The mall             |   | |      |");
			System.out.println("|  0 |  X  tae-kwon-dojo     |   | |   |  |");
			System.out.println("|____|__ ____ ____^___ ______|   |_|      |");
			System.out.println("|     the bar|        |            |   |  |");
			System.out.println("|-----------------------------------------|");
			System.out.println("'X' = your starting point.");
			System.out.println("'0' = your current location.");
			System.out.println("");
			try {
			    Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		else if (this.isInBar == true){
			System.out.println("-------------------------------------------");
			System.out.println("|____                              |      |");
			System.out.println("|    |                     the     |   |  |");
			System.out.println("|    | -Casino            road >   |      |");
			System.out.println("|    |                             |   |  |");
			System.out.println("|    |                             |      |");
			System.out.println("|____|                             |   |  |");
			System.out.println("|    |                             |      |");
			System.out.println("|    | -Burger Shot                |   |  |");
			System.out.println("|____|                gas station  |      |");
			System.out.println("|____| -A wall                ^__  |   |  |");
			System.out.println("|    | -The mall             |   | |      |");
			System.out.println("|    |  X  tae-kwon-dojo     |   | |   |  |");
			System.out.println("|____|__ ____ ____^___ ______|   |_|      |");
			System.out.println("|     the bar|        |            |   |  |");
			System.out.println("|        0                                |");
			System.out.println("|-----------------------------------------|");
			System.out.println("'X' = your starting point.");
			System.out.println("'0' = your current location.");
			System.out.println("");
			try {
			    Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		else if (this.isInCasino == true){
			System.out.println("-------------------------------------------");
			System.out.println("|____                              |      |");
			System.out.println("|    |                     the     |   |  |");
			System.out.println("|    | -Casino            road >   |      |");
			System.out.println("| 0  |                             |   |  |");
			System.out.println("|    |                             |      |");
			System.out.println("|____|                             |   |  |");
			System.out.println("|    |                             |      |");
			System.out.println("|    | -Burger Shot                |   |  |");
			System.out.println("|____|                gas station  |      |");
			System.out.println("|____| -A wall                ^__  |   |  |");
			System.out.println("|    | -The mall             |   | |      |");
			System.out.println("|    |  X  tae-kwon-dojo     |   | |   |  |");
			System.out.println("|____|__ ____ ____^___ ______|   |_|      |");
			System.out.println("|     the bar|        |            |   |  |");
			System.out.println("|-----------------------------------------|");
			System.out.println("'X' = your starting point.");
			System.out.println("'0' = your current location.");
			System.out.println("");
			try {
			    Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		else if (this.coordinates[0] == 2 && this.coordinates[1] == 0){
			System.out.println("-------------------------------------------");
			System.out.println("|____                              |      |");
			System.out.println("|    |                     the     |   |  |");
			System.out.println("|    | -Casino            road >   |      |");
			System.out.println("|    |                             |   |  |");
			System.out.println("|    |                             |      |");
			System.out.println("|____|                             |   |  |");
			System.out.println("|    |                             |      |");
			System.out.println("|    | 0 -Burger Shot              |   |  |");
			System.out.println("|____|                gas station  |      |");
			System.out.println("|____| -A wall                ^__  |   |  |");
			System.out.println("|    | -The mall             |   | |      |");
			System.out.println("|    |  X  tae-kwon-dojo     |   | |   |  |");
			System.out.println("|____|__ ____ ____^___ ______|   |_|      |");
			System.out.println("|     the bar|        |            |   |  |");
			System.out.println("|-----------------------------------------|");
			System.out.println("'X' = your starting point.");
			System.out.println("'0' = your current location.");
			System.out.println("");
			try {
			    Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		else if (this.coordinates[0] == 1 && this.coordinates[1] == 0){
			System.out.println("-------------------------------------------");
			System.out.println("|____                              |      |");
			System.out.println("|    |                     the     |   |  |");
			System.out.println("|    | -Casino            road >   |      |");
			System.out.println("|    |                             |   |  |");
			System.out.println("|    |                             |      |");
			System.out.println("|____|                             |   |  |");
			System.out.println("|    |                             |      |");
			System.out.println("|    | -Burger Shot                |   |  |");
			System.out.println("|____|                gas station  |      |");
			System.out.println("|____| 0 -A wall              ^__  |   |  |");
			System.out.println("|    | -The mall             |   | |      |");
			System.out.println("|    |  X  tae-kwon-dojo     |   | |   |  |");
			System.out.println("|____|__ ____ ____^___ ______|   |_|      |");
			System.out.println("|     the bar|        |            |   |  |");
			System.out.println("|-----------------------------------------|");
			System.out.println("'X' = your starting point.");
			System.out.println("'0' = your current location.");
			System.out.println("");
			try {
			    Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		else if (this.coordinates[0] == 0 && this.coordinates[1] == 0){
			System.out.println("-------------------------------------------");
			System.out.println("|____                              |      |");
			System.out.println("|    |                     the     |   |  |");
			System.out.println("|    | -Casino            road >   |      |");
			System.out.println("|    |                             |   |  |");
			System.out.println("|    |                             |      |");
			System.out.println("|____|                             |   |  |");
			System.out.println("|    |                             |      |");
			System.out.println("|    | -Burger Shot                |   |  |");
			System.out.println("|____|                gas station  |      |");
			System.out.println("|____|   -A wall              ^__  |   |  |");
			System.out.println("|    | -The mall             |   | |      |");
			System.out.println("|    |  0  tae-kwon-dojo     |   | |   |  |");
			System.out.println("|____|__ ____ ____^___ ______|   |_|      |");
			System.out.println("|     the bar|        |            |   |  |");
			System.out.println("|-----------------------------------------|");
			System.out.println("'X' = your starting point.");
			System.out.println("'0' = your current location.");
			System.out.println("");
			try {
			    Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		else if (this.coordinates[0] == 3 && this.coordinates[1] == 0){
			System.out.println("-------------------------------------------");
			System.out.println("|____                              |      |");
			System.out.println("|    |                     the     |   |  |");
			System.out.println("|    | -Casino            road >   |      |");
			System.out.println("|    | 0                           |   |  |");
			System.out.println("|    |                             |      |");
			System.out.println("|____|                             |   |  |");
			System.out.println("|    |                             |      |");
			System.out.println("|    | -Burger Shot                |   |  |");
			System.out.println("|____|                gas station  |      |");
			System.out.println("|____|   -A wall              ^__  |   |  |");
			System.out.println("|    | -The mall             |   | |      |");
			System.out.println("|    |     tae-kwon-dojo     |   | |   |  |");
			System.out.println("|____|__ ____ ____^___ ______|   |_|      |");
			System.out.println("|     the bar|        |            |   |  |");
			System.out.println("|-----------------------------------------|");
			System.out.println("'X' = your starting point.");
			System.out.println("'0' = your current location.");
			System.out.println("");
			try {
			    Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		
	}
	public void death(){
		System.out.println("_________________________________________________________________ ");
		System.out.println("|                                                                |");
		System.out.println("|     W A S T E D                                                |");
		System.out.println("|                                       wasted                   |");
		System.out.println("|                                                                |");
		System.out.println("|                                                                |");
		System.out.println("|    w     a     s     t     e     d            WASTED           |");
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println("|                                                                |");
		System.out.println("|      wasted                                                    |");
		System.out.println("|                                                                |");
		System.out.println("|                 wasted                    wasted               |");
		System.out.println("|                                                                |");
		System.out.println("|                           W   A   S   T   E   D                |");
		System.out.println("|________________________________________________________________|");
		this.isAlive = false; 
	}
}//class close 