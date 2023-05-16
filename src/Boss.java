import java.util.Random;
public class Boss extends Character {

    public Boss(int maxEnemyHealth, int enemyAttackDamage) {
        this.health = maxEnemyHealth;
        this.attackDamage = enemyAttackDamage;
        setName(getRandomBossName());
    }
    @Override
    public void setName(String name) {
        this.name = getRandomBossName();
    }

    @Override
    String getName() {
        return name;
    }
    public String getRandomBossName() {

        Random rand = new Random();

        String[] bosses = {"Rob Zombie", "Skeletor", "Marilyn Manson", "The Iron Sheik", "Dr. Octopus", "Karen",
                "Darth Vader", "Voldemort", "Hans Gruber", "Cruella Deville", "Freddy Kruger", "Dr. Evil", "Pin Head"};

        return bosses[rand.nextInt(bosses.length)];
        }


    public String getBossName() {
        return name;
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

    public void takeDamage(int damageDealt) {
        health -= damageDealt;
    }
}
