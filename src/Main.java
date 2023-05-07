import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //class objects
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        //setGame gameLevel = new setGame();
        Fairy fairy = new Fairy(45);

        //player variables
        var hero = new Hero(100, 100, 50, 3, 30);

        setGame.gameIntro();

        // difficulty determined
        String selectLevel = scan.nextLine();
        setGame.setLevel(selectLevel);

        int end = setGame.getVictoryCount();

        boolean running = true;   // will be part of a while loop , game runs until condition false

        int counter = 0;  // keep track of victories

        GAME: //label "Game" is name of this while loop
        while(running) {
            System.out.println("---------------------------------------------------------");

            if (hero.hasMaxHealthPotion()) {
                hero.useMaxHealthPotion();
            }

            var enemy = new Enemy(75, 25, 50);
            int enemyHealth = enemy.getHealth();

            System.out.println("\t*** " + enemy.getEnemyName() + " has appeared!  ***\n");

            /// nested while loop continues while fighting
            while(enemyHealth > 0){
                System.out.println("\tYour HP: "+ hero.getHealth()+ "  potions("+hero.getNumHealthPotions()+")");
                System.out.println("\t" + enemy.getEnemyName() + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                String input = scan.nextLine();
                if(input.equals("1"))   {
                    int damageDealt = rand.nextInt(hero.getAttackDamage());
                    int damageTaken = rand.nextInt(enemy.getAttackDamage());

                    if (hero.hasLuckyDuck()){
                        System.out.println("\t> You dodge "+ enemy.getEnemyName() + "'s strike!");
                        damageTaken = 0;
                        hero.useLuckyDuck();
                    }

                    enemy.takeDamage(damageDealt);

                    hero.takeDamage(damageTaken);

                    System.out.println("\t> You strike the " + enemy.getEnemyName() + " for " + damageDealt + " damage.");
                    System.out.println("\t> You received " + damageTaken + " in retaliation!");

                    enemyHealth = enemy.getHealth();

                    if(hero.getHealth() < 1){  // break out of loop if health gone
                        System.out.println("\n> You are too weak to fight :( ");
                        break;
                    }
                } else if(input.equals("2"))   {  // stays in fight loop
                        hero.usePotion(hero.getHealthPotionHealing());
                } else if(input.equals("3"))   {  // breaks out of fight loop and continues outer game loop
                    System.out.println("\t> You run away from the " + enemy.getEnemyName() + "!");
                    continue GAME;
                } else{
                    System.out.println("\t  !!! Invalid command!!! ");
                }
            }

            if (hero.getHealth() < 1){ // after breaking out of game loop, will print this then break out of game loop
                if (hero.hasUndeadPotion()) {
                    hero.useUndeadPotion();
                    continue GAME;
                } else {
                    System.out.println("\n\t  You limp out of the dungeon, weak from battle.");
                    break;
                }
            }

            counter++; // when breaks out of fighting loop, will add win because option 2 drinks potion and continues
            //fight, option 3 will run and restart game loop. health < 1 ends game. so this increments when won fight
            System.out.println("----------------------------------------------------------");
            System.out.println("\t *** " + enemy.getEnemyName() + " was defeated! ***");
            System.out.println("\t *** You have " + hero.getHealth() + "HP left. ***");

            if (counter == end){    // engage in final boss fight

                System.out.println("\n *** VICTORY! YOU'VE DEFEATED THE FINAL ENEMY ***");
                System.out.println("\n\tYou've defeated " + counter + " enemies!");
                System.out.println("\n *** You pick up the treasure and hold it victoriously! ***");
                break;
            }
            if(rand.nextInt(100) < enemy.getHealthPotionDropChance()) {  //while in game loop after a fight
                hero.addHealthPotion();

                System.out.println("\n\t *** The " + enemy.getEnemyName() + " dropped a health potion! ***");
                System.out.println("\t *** You now have " + hero.getNumHealthPotions() + " health potion(s). ***");
            }
            if(rand.nextInt(100) < fairy.getFairyEncounterChance()) {  // while in game, can meet fairy

                fairy.meetFairy();

                if (fairy.winItem(fairy.getSelection())){
                    System.out.println("\t*** YOU WON... ");
                    Items itemWon = fairy.giftItem();
                    System.out.println("\tYou received: " + itemWon.getName());

                    if (itemWon instanceof LuckyDuck) {
                        hero.obtainLuckyDuck((LuckyDuck) itemWon);
                    } else if (itemWon instanceof maxHealthPotion) {
                        hero.obtainMaxHealthPotion((maxHealthPotion) itemWon);
                    } else if (itemWon instanceof UndeadPotion) {
                        hero.obtainUndeadPotion((UndeadPotion) itemWon);
                    }
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
            } else if(input.equals("2")){
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
