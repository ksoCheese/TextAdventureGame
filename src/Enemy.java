import java.util.Random;
public class Enemy extends Character {

    static Random rand = new Random();

    private int healthPotionDropChance;

    public Enemy(int maxEnemyHealth, int enemyAttackDamage, int healthPotionDropChance) {

        this.health = getRandomEnemyHealth(maxEnemyHealth);
        this.attackDamage = enemyAttackDamage;
        this.healthPotionDropChance = healthPotionDropChance;
        setName(getRandomEnemyName());
    }
    @Override
    public void setName(String name) {
        this.name= getRandomEnemyName();
    }

    @Override
    public String getName() {
        return name;
    }
    private String getRandomEnemyName() {
        String[] enemies = {"Zombie", "Skeleton", "Alien", "Werewolf", "Banshee", "Venomous Spider", "Poisonous Toad",
                "Mummy", "Rabid Wolf", "Vampire", "Flesh-Eating Plant", "Jackal", "Mutant", "Goblin", "Centaur"};

        return enemies[rand.nextInt(enemies.length)];
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

}