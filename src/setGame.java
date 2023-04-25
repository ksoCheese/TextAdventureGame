public class setGame {

    private int health;
    private int attackDamage;
    private int numHealthPotions;
    private int enemyAttackDamage;
    private int maxEnemyHealth;   // percentage chance for enemy to drop health potion
    private int healthPotionHealing;
    private int healthPotionDropChance;

    private int victoryCount;


    public void setLevel(String levelInput){

        if(levelInput.equals("1")){
            health = 100;
            attackDamage = 50;
            numHealthPotions = 3;
            healthPotionDropChance = 50;
            healthPotionHealing = 30;
            maxEnemyHealth = 75;
            enemyAttackDamage = 25;
            victoryCount = 7;
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
        }
        else
            System.out.println("Invalid Command");
    }

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

    public int getVictoryCount()  { return victoryCount; }

//    public boolean youWin( int count) {
//        if (count == victory) {
//            return true;
//        }
//    }
}
