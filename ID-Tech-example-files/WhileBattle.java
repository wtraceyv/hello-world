import java.util.Random;
public class WhileBattle {

	public static void main(String[] args) {
		Random randomGenerator = new Random();

		System.out.println("Welcome to your DOOM");

		//setup
		int playerHealth = 120;
		int enemyHealth = 12;
		int playerAttack = 5;
		int enemyAttack = 3;
		int damage;
		int enemiesDefeated = 0;

		while (playerHealth>0){
			if (enemyHealth>0){
				System.out.println("Your HP: "+ playerHealth + " Enemy HP: " + enemyHealth);
			  // Player attack
        damage = playerAttack + randomGenerator.nextInt(3);
        System.out.println("You attack the enemy for " + damage + " damage.");
        enemyHealth -= damage;
			}
		}
	}// end main 
}
