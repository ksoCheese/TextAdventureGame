import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //class objects
        var scan = new Scanner(System.in);
        var rand = new Random();
        var fairy = new Fairy(45);
        var heroCreator = new HeroFactory();
        var enemyCreator = new EnemyFactory();

        GameControl.gameIntro();

        // difficulty determined
        GameControl.setLevel(scan);

        Hero hero = heroCreator.createHero(GameControl.getLevel());

        int end = GameControl.getVictoryCount();

        boolean running = true;   // will be part of a while loop , game runs until condition false

        int counter = 0;  // keep track of victories

        GAME: //label "Game" is name of this while loop
        while(running) {
            System.out.println("---------------------------------------------------------");

            if (hero.hasMaxHealthPotion()) {
                hero.useMaxHealthPotion();
            }

            Enemy enemy = enemyCreator.createEnemy(GameControl.getLevel());


            System.out.println("\t*** " + enemy.getEnemyName() + " has appeared!  ***\n");

            /// nested while loop continues while fighting
            label:
            while(enemy.getHealth()  > 0){
                System.out.println("\tYour HP: "+ hero.getHealth()+ "  potions("+hero.getNumHealthPotions()+")");
                System.out.println("\t" + enemy.getEnemyName() + "'s HP: " + enemy.getHealth());
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                String input = scan.nextLine();
                switch (input) {
                    case "1" -> {
                        int damageDealt = rand.nextInt(hero.getAttackDamage());
                        int damageTaken = rand.nextInt(enemy.getAttackDamage());
                        if (hero.hasLuckyDuck()) {
                            hero.useLuckyDuck();
                            System.out.println("\t> You dodge " + enemy.getEnemyName() + "'s strike!");
                            damageTaken = 0;

                        }
                        enemy.takeDamage(damageDealt);
                        hero.takeDamage(damageTaken);
                        System.out.println("\t> You strike the " + enemy.getEnemyName() + " for " + damageDealt + " damage.");
                        System.out.println("\t> You received " + damageTaken + " in retaliation!");
                        if (hero.getHealth() < 1) {  // break out of loop if health gone
                            System.out.println("\n> You are too weak to fight :( ");
                            break label;
                        }
                    }
                    case "2" ->   // stays in fight loop
                            hero.usePotion(hero.getHealthPotionHealing());
                    case "3" -> {   // breaks out of fight loop and continues outer game loop
                        System.out.println("\t> You run away from the " + enemy.getEnemyName() + "!");
                        continue GAME;
                    }
                    default -> System.out.println("\t  !!! Invalid command!!! ");
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

                fairy.meetFairy(scan);

                if (fairy.winItem(scan)){
                    fairy.rewardHero(hero);

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
