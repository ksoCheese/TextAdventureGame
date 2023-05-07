import java.util.Random;
public class Enemy extends Character {

    static Random rand = new Random();

    private int healthPotionDropChance;
    private String enemyName;
    public Enemy(int maxEnemyHealth, int enemyAttackDamage, int healthPotionDropChance) {

        this.health = getRandomEnemyHealth(maxEnemyHealth);
        this.attackDamage = enemyAttackDamage;
        this.healthPotionDropChance = healthPotionDropChance;
        this.enemyName = getRandomEnemyName();
    }

    private String getRandomEnemyName() {
        String[] enemies = {"Zombie", "Skeleton", "Alien", "Werewolf", "Banshee", "Venomous Spider", "Poisonous Toad",
                "Mummy", "Rabid Wolf", "Vampire", "Flesh-Eating Plant", "Jackal", "Mutant", "Goblin", "Centaur"};

        return enemies[rand.nextInt(enemies.length)];
    }
    public String getEnemyName() {
        return enemyName;
    }
    public int getRandomEnemyHealth(int maxEnemyHealth) {
        return rand.nextInt(maxEnemyHealth);
    }

    @Override
    public void setHealth(int value) {
        health = value;
    }

    @Override
    int getHealth() {
        return health;
    }

    @Override
    int getAttackDamage() {
        return attackDamage;
    }

    public void takeDamage(int damageDealt) { health -= damageDealt; }

    public int getHealthPotionDropChance() {
        return healthPotionDropChance;
    }

    /////////////       CREATE A BOSS CLASS  that extends from character    /////////////


//    public String getBoss() {
//
//        Random rand = new Random();

//        String[] bosses = {"Rob Zombie", "Skeletor", "Marilyn Manson", "The Iron Sheik", "Dr. Octopus", "Karen",
////            "Darth Vader", "Voldemort", "Hans Gruber", "Cruella Deville", "Freddy Kruger", "Dr. Evil", "Pin Head"};

//        return bosses[rand.nextInt(bosses.length)];
//
//    }
//
//    private boolean beatBoss;

//    public Enemy {
//
//        beatBoss = false;
//    }
//    public boolean bossFight() {    // when you beat boss you get an undead potion.
//
//        beatBoss = true;
//        return beatBoss;
//    }



}