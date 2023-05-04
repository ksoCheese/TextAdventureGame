public class setGame {

    //////       GAME INTRO HERE???????  WIN GAME MESSAGE HERE?
    //////       Can I create a  class with Static methods just to access the intro and victory method? or should i just do it in main?

    /// all below variables are assigned to other classes
    private int health;
    private int attackDamage;
    private int numHealthPotions;
    private int enemyAttackDamage;
    private int maxEnemyHealth;   // percentage chance for enemy to drop health potion
    private int healthPotionHealing;
    private int healthPotionDropChance;

    private int fairyEncounterChance;

    private int victoryCount;


    public void gameIntro(){

        System.out.println("---------------------------------------------------------");
        System.out.println("\n\tWelcome to the Dungeon!");
        System.out.println("\n\tDefeat your enemies and walk out victorious!!!");
        System.out.println("\n\tIf you defeat all enemies in the dungeon, you can claim your reward!!!");
        System.out.println("\nSelect your difficulty level: ");
        System.out.println(" 1. Regular");
        System.out.println(" 2. Difficult");
    }
    public void setLevel(String levelInput){

        if(levelInput.equals("1")){
            health = 100;
            attackDamage = 50;
            numHealthPotions = 3;
            healthPotionDropChance = 50;
            healthPotionHealing = 30;
            maxEnemyHealth = 75;
            enemyAttackDamage = 25;
            victoryCount = 8;
            fairyEncounterChance = 45;
        }

        else if(levelInput.equals("2")) {
            health = 75;
            attackDamage = 38;
            numHealthPotions = 2;
            healthPotionDropChance = 40;
            healthPotionHealing = 24;
            maxEnemyHealth = 85;
            enemyAttackDamage = 35;
            victoryCount = 15;
            fairyEncounterChance = 35;
        }
        else
            System.out.println("Invalid Command");
    }

    public int useMaxHealthPotion(){
        return health = 100;
    }

    public int useUndeadPotion() { return health = 60; }

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getNumHealthPotions() {
        return numHealthPotions;
    }

    public int getEnemyAttackDamage() {
        return enemyAttackDamage;
    }
    public int getMaxEnemyHealth() {
        return maxEnemyHealth;
    }
    public int getHealthPotionHealing() {
        return healthPotionHealing;
    }
    public int getHealthPotionDropChance() {
        return healthPotionDropChance;
    }

    public int getFairyEncounter()  { return fairyEncounterChance; }


    public int getVictoryCount()  { return victoryCount; }


}
