import java.util.Scanner;
import java.util.Random;

public class Game {

    Random rand = new Random();
    EnemyFactory enemyCreator = new EnemyFactory();
    HeroFactory heroCreator = new HeroFactory();
    Fairy fairy = new Fairy();
    Enemy enemy;
    Hero hero;
    Boss boss;

    public void createEnemy() {
        enemy = enemyCreator.createEnemy(GameControl.getLevel());
        System.out.println("---------------------------------------------------------");
        System.out.println("\t*** " + enemy.getName() + " has appeared!  ***\n");
    }
    public void createHero(Scanner scan) {
        hero = heroCreator.createHero(GameControl.getLevel());

        System.out.println("\t> What is your hero's name? : ");
        String name = scan.nextLine();
        hero.setName(name);
        System.out.println("\t*** " + hero.getName() + " is ready for battle! ***\n");
    }

    public void createBoss() {
        boss = enemyCreator.createBoss(GameControl.getLevel());
        System.out.println("----------------------------------------------------------");
        System.out.println("\t\n*** " + boss.getBossName() + " has appeared!!! *** ");
        System.out.println("\t\n ***  PREPARE FOR YOUR FINAL BATTLE!!  *** ");
    }
    public void createFairy() {
        fairy.createFairy();
    }

    public Enemy getEnemy() {
        return enemy;
    }
    public Hero getHero() { return hero; }
    public Fairy getFairy() { return fairy; }

    public void checkforFairyEncounter(Scanner scan) {
        if(rand.nextInt(100) < getFairy().getFairyEncounterChance()) {  // while in game, can meet fairy

            getFairy().meetFairy(scan);

            if (getFairy().winItem(scan)){
                getFairy().rewardHero(hero);

            }else
                System.out.println("\t Sorry, you selected wrong, must be your unlucky day!");
        }
    }

    public void engageEnemy() {
        System.out.println("---------------------------------------------------------");
        System.out.println("\tYour HP: "+ hero.getHealth()+ "  potions("+hero.getNumHealthPotions()+")");
        System.out.println("\t" + enemy.getName() + "'s HP: " + enemy.getHealth());
        System.out.println("\n\tWhat would you like to do?");
        System.out.println("\t1. Attack");
        System.out.println("\t2. Drink health potion");
        System.out.println("\t3. Run!");
    }

    public boolean enemyBattle(Scanner scan) {
        String selection = scan.nextLine();
        switch (selection) {
            case "1" -> {
                int damageDealt = rand.nextInt(hero.getAttackDamage());
                int damageTaken = rand.nextInt(enemy.getAttackDamage());
                if (hero.hasLuckyDuck()) {
                    hero.useLuckyDuck();
                    System.out.println("\t> You dodge " + enemy.getName() + "'s strike!");
                    damageTaken = 0;

                }
                enemy.takeDamage(damageDealt);
                hero.takeDamage(damageTaken);
                System.out.println("\t> You strike the " + enemy.getName() + " for " + damageDealt + " damage.");
                System.out.println("\t> You received " + damageTaken + " in retaliation!");
                if (hero.getHealth() < 1) {  // break out of loop if health gone
                    System.out.println("\n> You are too weak to fight :( ");
                    //break label:
                    return false;
                }
            }
            case "2" ->   // stays in fight loop
                    hero.usePotion(hero.getHealthPotionHealing());
            case "3" -> {   // breaks out of fight loop and continues outer game loop
                System.out.println("\t> You run away from the " + enemy.getName() + "!");
                return false;
            }
            default -> System.out.println("\t  !!! Invalid command!!! ");
        }
        return true;
    }
    public void defeatEnemyMsg() {
        System.out.println("----------------------------------------------------------");
        System.out.println("\t *** " + enemy.getName() + " was defeated! ***");
        System.out.println("\t *** You have " + hero.getHealth() + "HP left. ***");
    }

    public void engageBoss() {
        System.out.println("---------------------------------------------------------");
        System.out.println("\tYour HP: "+ hero.getHealth()+ "  potions("+hero.getNumHealthPotions()+")");
        System.out.println("\t" + boss.getBossName() + "'s HP: " + boss.getHealth());
        System.out.println("\n\tWhat would you like to do?");
        System.out.println("\t1. Attack");
        System.out.println("\t2. Drink health potion");

    }
    public Boss getBoss() {
        return boss;
    }

    public boolean bossFight(Scanner scan) {
        String selection = scan.nextLine();
        switch (selection) {
            case "1" -> {
                int damageDealt = rand.nextInt(hero.getAttackDamage());
                int damageTaken = rand.nextInt(boss.getAttackDamage());
                if (hero.hasLuckyDuck()) {
                    hero.useLuckyDuck();
                    System.out.println("\t> You dodge " + boss.getBossName() + "'s strike!");
                    damageTaken = 0;

                }
                boss.takeDamage(damageDealt);
                hero.takeDamage(damageTaken);
                System.out.println("\n\t> You strike the " + boss.getBossName() + " for " + damageDealt + " damage.");
                System.out.println("\t> You received " + damageTaken + " in retaliation!");
                if (hero.getHealth() < 1) {  // break out of loop if health gone
                    System.out.println("\n> You have been defeated!!!  :( ");
                    //break label:
                    return false;
                }
            }
            case "2" ->   // stays in fight loop
                    hero.usePotion(hero.getHealthPotionHealing());

            default -> System.out.println("\t  !!! Invalid command!!! ");
        }
        return hero.getHealth() > 0;
    }

    public boolean oneMoreChance() {
        if (hero.hasUndeadPotion()) {
            hero.useUndeadPotion();
            return true;
        } else {
            System.out.println("\n\t" + hero.getName()+" limps out of the dungeon, weak from battle.");
            return false;
        }
    }

    public void checkForPotionDrop() {
        if(rand.nextInt(100) < enemy.getHealthPotionDropChance()) {  //while in game loop after a fight
            hero.addHealthPotion(enemy);
        }
    }

    public void victoryMsg(int counter) {
        System.out.println("\n *** VICTORY! YOU'VE DEFEATED THE FINAL ENEMY ***");
        System.out.println("\n\t" + hero.getName() + " defeated " + counter + " enemies and " + boss.getBossName()+"!!!");
        System.out.println("\n *** " + hero.getName() + " picks up the treasure and holds it victoriously! ***");
    }

    public void initializeGame(Scanner scan) {
        createHero(scan);
        createFairy();
    }
    public void startRound(Scanner scan) {
        int victories = 0;

        while (GameControl.isRunning()) {

            Hero hero = getHero();
            if (hero.hasMaxHealthPotion()) {
                hero.useMaxHealthPotion();
            }

            createEnemy();
            Enemy enemy = getEnemy();

            //Enemy fight loop
            while (enemy.getHealth() > 0) {
                engageEnemy();
                if (!enemyBattle(scan)) {
                    if (hero.getHealth() < 1) {
                        if (!oneMoreChance()) {
                            return;
                        }
                    }
                }
            }

            victories++;
            defeatEnemyMsg();

            // Boss fight
            if (victoryAchieved(victories)) {
                createBoss();
                Boss boss = getBoss();

                while (boss.getHealth() > 0) {
                    engageBoss();
                    if (!bossFight(scan) || hero.getHealth() < 1) {
                        return;
                    }
                    if (boss.getHealth() < 1) {
                        victoryMsg(victories);
                        return;
                    }
                }
            }

            checkForPotionDrop();
            checkforFairyEncounter(scan);

            GameControl.exitGame(scan, victories);
        }
    }

    public boolean victoryAchieved(int victories) {
        return victories >= GameControl.getVictoryCount();
    }
}

