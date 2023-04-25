import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //system objects
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        setGame gameLevel = new setGame();
        Enemy enemyList = new Enemy();

        System.out.println("Welcome to the Dungeon!");
        System.out.println("Defeat your enemies and walk out victorious!!!");
        System.out.println("Select your difficulty level: ");
        System.out.println(" 1. Regular");
        System.out.println(" 2. Difficult");

        // difficulty determined

        String userInput = scan.nextLine();
        gameLevel.setLevel(userInput);

        //player variables
        int health = gameLevel.getHealth();
        int attackDamage = gameLevel.getAttackDamage();
        int numHealthPotions = gameLevel.getNumHealthPotions();

        //game variables
        int healthPotionDropChance = gameLevel.getHealthPotionDropChance();
        int healthPotionHealing = gameLevel.getHealthPotionHealing();
        int victory = gameLevel.getVictoryCount();

        // enemy variables
        int maxEnemyHealth = gameLevel.getMaxEnemyHealth();
        int enemyAttackDamage = gameLevel.getEnemyAttackDamage();
        String[] enemies = enemyList.enemies;

        boolean running = true;   // will be part of a while loop , game runs until condition false
        int counter = 0;  // keep track of victories

        GAME: //label "Game" is name of this while loop
        while(running) {
            System.out.println("---------------------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t*** " + enemy + " has appeared!  ***\n");

            /// nested while loop continues while fighting
            while(enemyHealth > 0){
                System.out.println("\tYour HP: "+ health+ "  potions("+numHealthPotions+")");
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                String input = scan.nextLine();
                if(input.equals("1"))   {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You received " + damageTaken + " in retaliation!");

                    if(health < 1){  // break out of loop if health gone
                        System.out.println("\t> You are too weak to fight :( ");
                        break;
                    }
                }
                else if(input.equals("2"))   {  // stays in fight loop
                    if(numHealthPotions > 0){
                        health += healthPotionHealing;
                        numHealthPotions--;
                        System.out.println("\t You drink the health potion, healing yourself for " + healthPotionHealing +"."
                                + "\n\t> You now have " + health + "HP."
                                + "\n\t> You have " + numHealthPotions + " health potions left.\n");
                    }
                    else{
                        System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!");
                    }
                }
                else if(input.equals("3"))   {  // breaks out of fight loop and continues outer game loop
                    System.out.println("\t> You run away from the " + enemy + "!");
                    continue GAME;
                }
                else{
                    System.out.println("\tInvalid command");
                }
            }

            if (health < 1){ // after breaking out of game loop, will print this then break out of game loop
                System.out.println("You limp out of the dungeon, weak from battle.");
                break;
            }

            counter++; // when breaks out of fighting loop, will add win because option 2 drinks potion and continues
            //fight, option 3 will run and restart game loop. health < 1 ends game. so this increments when won fight
            System.out.println("----------------------------------------------------------");
            System.out.println(" *** " + enemy + " was defeated! ***");
            System.out.println(" *** You have " + health + "HP left. ***");

            if (counter == victory){
                System.out.println("\n *** VICTORY! YOU'VE DEFEATED THE FINAL ENEMY ***");
                System.out.println("\n\tYou've defeated " + counter + " enemies!");
                System.out.println("\n ***You pick up the treasure and hold it victoriously! ***");
                break;

            }

            if(rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println("\t *** The " + enemy + " dropped a health potion! ***");
                System.out.println(" *** You now have " + numHealthPotions + " health potion(s). ***");
            }
            System.out.println("---------------------------------------------------------");
            System.out.println("What would you like to do now? ");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");

            String input = scan.nextLine();

            while(!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command!");
                input = scan.nextLine();
            }

            if (input.equals ("1")) {
                System.out.println("You continue on your adventure");
            }
            else if(input.equals("2")){
                System.out.println("You exit the dungeon, tired from your battles. ");
                System.out.println("You've defeated " + counter + " enemies!");
                break;
            }
        }

        System.out.println("\n###########################################################");
        System.out.println("\n THANKS FOR PLAYING!!!");
        System.out.println("\n###########################################################");

    }
}
