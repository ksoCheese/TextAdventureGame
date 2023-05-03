import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //class objects
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        setGame gameLevel = new setGame();
        Enemy enemyList = new Enemy();
        fairyTale fairy = new fairyTale();
        Objects object = new Objects();

        gameLevel.gameIntro();

        // difficulty determined

        String userInput = scan.nextLine();
        gameLevel.setLevel(userInput);

        //player variables

        var hero = new Hero(100, 50, 3);

        //game variables
        int healthPotionDropChance = gameLevel.getHealthPotionDropChance();
        int healthPotionHealing = gameLevel.getHealthPotionHealing();
        int fairyEncounter = gameLevel.getFairyEncounter();
        boolean luckyDuck = object.getLuckyDuck();
        boolean undeadPotion = object.getUndeadPotion();
        boolean maxHealthPotion = object.getMaxHealthPotion();

        int end = gameLevel.getVictoryCount();

        // enemy variables
        int maxEnemyHealth = gameLevel.getMaxEnemyHealth();
        int enemyAttackDamage = gameLevel.getEnemyAttackDamage();
        //String[] enemies = enemyList.enemies;
        //String[] bosses = enemyList.bosses;

        boolean running = true;   // will be part of a while loop , game runs until condition false
        int counter = 0;  // keep track of victories

        GAME: //label "Game" is name of this while loop
        while(running) {
            System.out.println("---------------------------------------------------------");

//            if (luckyDuck) {
//
//                enemyAttackDamage = gameLevel.useLuckyDuck(); //calls method to use duck , enemy attack 0
//                luckyDuck = false;
            //}
            if (maxHealthPotion) {
                hero.setHealth(gameLevel.useMaxHealthPotion());
                undeadPotion = false;
            }

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemyList.getEnemy();
            System.out.println("\t*** " + enemy + " has appeared!  ***\n");

            /// nested while loop continues while fighting
            while(enemyHealth > 0){
                System.out.println("\tYour HP: "+ hero.getHealth()+ "  potions("+hero.getNumHealthPotions()+")");
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                String input = scan.nextLine();
                if(input.equals("1"))   {
                    int damageDealt = rand.nextInt(hero.getAttackDamage());
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    if (luckyDuck){
                        System.out.println("\t> You dodge "+ enemy+ "'s strike!");
                        damageTaken = 0;
                        luckyDuck = false;
                    }
                    enemyHealth -= damageDealt;

                    hero.takeDamage(damageTaken);


                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You received " + damageTaken + " in retaliation!");

                    if(hero.getHealth() < 1){  // break out of loop if health gone
                        System.out.println("\n> You are too weak to fight :( ");
                        break;
                    }
                }
                else if(input.equals("2"))   {  // stays in fight loop
                        hero.usePotion(healthPotionHealing);

                }
                else if(input.equals("3"))   {  // breaks out of fight loop and continues outer game loop
                    System.out.println("\t> You run away from the " + enemy + "!");
                    continue GAME;
                }
                else{
                    System.out.println("\t  !!! Invalid command!!! ");
                }
            }

            if (hero.getHealth() < 1){ // after breaking out of game loop, will print this then break out of game loop
                if (undeadPotion) {
                    System.out.println("\n\t  Weak, you drink the UNDEAD POTION....Your energy restored!");
                    undeadPotion = false;
                    continue GAME;
                } else {
                    System.out.println("\n\t  You limp out of the dungeon, weak from battle.");
                    break;
                }
            }

            counter++; // when breaks out of fighting loop, will add win because option 2 drinks potion and continues
            //fight, option 3 will run and restart game loop. health < 1 ends game. so this increments when won fight
            System.out.println("----------------------------------------------------------");
            System.out.println("\t *** " + enemy + " was defeated! ***");
            System.out.println("\t *** You have " + hero.getHealth() + "HP left. ***");

            if (counter == end){    // engage in final boss fight


                System.out.println("\n *** VICTORY! YOU'VE DEFEATED THE FINAL ENEMY ***");
                System.out.println("\n\tYou've defeated " + counter + " enemies!");
                System.out.println("\n *** You pick up the treasure and hold it victoriously! ***");
                break;

            }

            if(rand.nextInt(100) < healthPotionDropChance) {  //while in game loop after a fight
                hero.addHealthPotion();

                System.out.println("\n\t *** The " + enemy + " dropped a health potion! ***");
                System.out.println("\t *** You now have " + hero.getNumHealthPotions() + " health potion(s). ***");
            }

            if(rand.nextInt(100) < fairyEncounter) {  // while in game, can meet fairy

                fairy.meetFairy();
                String selection = scan.nextLine();
                boolean prize = fairy.winPrize(selection); //calls fairyTale method
                if (prize){
                    // if true, you won. Instantiate prize object
                    System.out.println("*** YOU WON... ");
                    boolean choice = rand.nextBoolean();

                    if (choice) {
                        luckyDuck = true;
                        System.out.println("*** A LUCKY DUCK! Your next enemy will be weak at first!  ***");

                    }else{
                        maxHealthPotion = true;
                        System.out.println("*** MAX HEALTH POTION!  Restores all health next fight! ***");
                    }
//                    else {
//                        undeadPotion = true;
//                        System.out.println("*** UNDEAD POTION! Brings you back from near death!  ***");
//                    }

                }else
                    System.out.println("\t Sorry, you selected wrong, must be your unlucky day!");

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
