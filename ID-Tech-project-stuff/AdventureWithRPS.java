////////////////////////////////////////UPDATED ADVENTUREWRPS CLASS////////
import java.util.Random;
import java.util.Scanner; //THERE IS userInput for words, userNumbers for numbers! DON'T FORGET TO CLOSE

public class AdventureWithRPS {
	public static void main(String[] args){
		Characters mainPerson = new Characters(); // create the person w/ initial values and methods
		Scanner prompt = new Scanner(System.in); // word inputs
		Scanner userNumbers = new Scanner(System.in); // number/money inputs 
		Random luckGenerator = new Random(); // randomness generator
		BlackJackMethod Casino = new BlackJackMethod(); // instance for use of 'casino' 
		
		//WHERE THE STORY STARTS
		System.out.println("So what's your name again?"); 
		mainPerson.name = prompt.nextLine(); 
		System.out.println("You appear to have woken up in front of some mall...in the corner of a large parking lot. With about $"  + mainPerson.money +" of pocket money. Nice.");
		System.out.println("Type 'money' to see your current supply. Type 'map' to see your location on a map.\nType 'straight', 'back', 'right', or 'left' to move in that direction.");
		System.out.println("Now just type a direction, I am your eyes! hehe");
		while(mainPerson.isAlive == true){
			//System.out.println("Outside coordinates: " + mainPerson.coordinates[0]+" "+mainPerson.coordinates[1]);
			//System.out.println("Mall coordinates: " + mainPerson.mallCoordinates[0] + " " + mainPerson.mallCoordinates[1]);
			System.out.println("Go somewhere"); // constantly printing stuff ^
			String newDirection = prompt.nextLine(); 
		
			// 'if' chains for directions
			if (newDirection.equalsIgnoreCase("map")){
				mainPerson.mapCheck();
			}
			if (mainPerson.isInMall == true){ // 'if' chain for directions INSIDE THE MALL
				if (newDirection.equalsIgnoreCase("straight")){
					mainPerson.moveWest();
				}
				else if (newDirection.equalsIgnoreCase("right")){
					mainPerson.moveNorth(); 
				}
				else if (newDirection.equalsIgnoreCase("back")){ 
					mainPerson.moveEast();
				}
				else if (newDirection.equalsIgnoreCase("left")){
					mainPerson.moveSouth();
				}
			}
			else if (mainPerson.isInBar == true){
				if (newDirection.equalsIgnoreCase("straight")){
					mainPerson.moveSouth();
				}
				else if (newDirection.equalsIgnoreCase("right")){
					mainPerson.moveWest(); 
				}
				else if (newDirection.equalsIgnoreCase("back")){ 
					mainPerson.moveNorth();
				}
				else if (newDirection.equalsIgnoreCase("left")){
					mainPerson.moveEast();
				}
			}
			else {
				if (newDirection.equalsIgnoreCase("straight")){
					mainPerson.moveNorth();
				}
				else if (newDirection.equalsIgnoreCase("right")){
					mainPerson.moveEast(); 
				}
				else if (newDirection.equalsIgnoreCase("back")){ 
					mainPerson.moveSouth();
				}
				else if (newDirection.equalsIgnoreCase("left")){
					mainPerson.moveWest();
				}
			}
			if (newDirection.equalsIgnoreCase("money")){
				mainPerson.moneyCheck();
			}
			
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		// 'if' chain for locations and activities
		if (mainPerson.coordinates[0] == 2 && mainPerson.coordinates[1] == 0){
			mainPerson.frontOfBurgerPlace(); 
		}
		else if (mainPerson.coordinates[0] == 1 && mainPerson.coordinates[1] == 0){
			mainPerson.isInMall = false; 
			System.out.println("A wall to your west...buildings ahead, mall behind.");
		}
		else if (mainPerson.coordinates[0] == 2 && mainPerson.coordinates[1] == 0){
			mainPerson.isInMall = false; 
		}
		else if (mainPerson.mallCoordinates[0]==0 && mainPerson.mallCoordinates[1]== 0){ // first frame of mall
			mainPerson.isInMall = true; 
			mainPerson.intoMall(); 
		}
		else if (mainPerson.mallCoordinates[0]==1 && mainPerson.mallCoordinates[1]== -1){
			//ARRIVING AT ATM 
			mainPerson.isInMall = true; 
			mainPerson.atmArrive(); 
		}
		else if (mainPerson.coordinates[0] == 2 && mainPerson.coordinates[1] == -1){
			mainPerson.burgerShot(); 
		}
		else if (mainPerson.coordinates[0] == 0 && mainPerson.coordinates[1] == 0){ // starting place 
			mainPerson.isInMall = false; 
			mainPerson.isInBar = false;  
			System.out.println("Well... back to your rather awkward starting place.");
			System.out.println("Stores ahead and right, bar behind, mall on your left.");
		}
		else if (mainPerson.mallCoordinates[0]==0 && mainPerson.mallCoordinates[1]== -1 && mainPerson.isInMall == true){
			mainPerson.laserTag(); 
		}
		else if (mainPerson.mallCoordinates[0]==0 && mainPerson.mallCoordinates[1]== 1){
			if (mainPerson.isInMall == true){
				mainPerson.theater(); 
			}
			else if (mainPerson.isInMall == false){
				System.out.println("Didn't you hear me? That's a wall, brother.");
				mainPerson.moveEast();
			}
		}
		else if (mainPerson.coordinates[0] == 3 && mainPerson.coordinates[1] == 0){
			System.out.println("OOOO, the casino! To the left! AH! DADDY NEEDS A NEW PAIR A SHOES!!");
		}
		else if (mainPerson.coordinates[0] == 3 && mainPerson.coordinates[1] == -1){
			mainPerson.money = Casino.casino(mainPerson.money);
		}
		else if (mainPerson.mallCoordinates[0]==1 && mainPerson.mallCoordinates[1]== 0){ // middle of hall, atm left
			System.out.println("There's the atm on the left."); 
		}
		else if (mainPerson.barCoordinates[0]== 0 && mainPerson.barCoordinates[1]== 0){ // bar entrance
			mainPerson.isInBar = true; 
			System.out.println("Ah, the bar you probably fell out of.");
			System.out.println("I see a helpful bartender on the left, and one who looks prepared to sell you something ahead.");
			System.out.println("I would not confront the burly man on the right...");
		}
		else if (mainPerson.barCoordinates[0]== 1 && mainPerson.barCoordinates[1]== 0){
			mainPerson.barDrink(); 
		}
		else if (mainPerson.barCoordinates[0]== 0 && mainPerson.barCoordinates[1]== -1){
			System.out.println("Hey, I reognize you! You were crazy last night.\nSome guy - maybe he had a ... kimono on? - stole your car keys and you got PISSED! Had to throw you out.\nGlad to see you're safe though.");
			mainPerson.moveWest();
		}
		else if (mainPerson.isInBar == true && mainPerson.barCoordinates[0]== 0 && mainPerson.barCoordinates[1]== 1){ // bar fight
			mainPerson.barFight();
		}
			
		
	
		} // ends while() 
	}

}//the class close
//////////////////////////////////////////////////////////////////////////////////
