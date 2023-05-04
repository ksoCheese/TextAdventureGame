import java.util.Random;
public class Enemy extends Character {

    static Random rand = new Random();
    private int healthPotionDropChance;
    public Enemy(int maxEnemyHealth, int enemyAttackDamage, int healthPotionDropChance) {

        health = maxEnemyHealth;
        attackDamage = enemyAttackDamage;
        this.healthPotionDropChance = healthPotionDropChance;
    }

    public int getRandomEnemyHealth(int maxEnemyHealth) {
        return rand.nextInt(maxEnemyHealth);
    }

    @Override
    public void setHealth(int value) {

    }

    @Override
    int getHealth() {
        return health;
    }

    @Override
    int getAttackDamage() {
        return attackDamage;
    }

    public String getEnemyName() {

        String[] enemies = {"Zombie", "Skeleton", "Alien", "Werewolf", "Banshee", "Venomous Spider", "Poisonous Toad",
                "Mummy", "Rabid Wolf", "Vampire", "Flesh-Eating Plant", "Jackal", "Mutant", "Goblin", "Centaur"};

        return enemies[rand.nextInt(enemies.length)];
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