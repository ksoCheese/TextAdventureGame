import java.util.Random;
public class Enemy {

    private String enemy;
    private String boss;

    private boolean beatBoss;

//    public Enemy {
//
//        beatBoss = false;
//    }

    Random rand = new Random();
    String[] enemies = {"Zombie","Skeleton","Alien","Werewolf", "Banshee", "Venomous Spider", "Poisonous Toad",
            "Mummy", "Rabid Wolf", "Vampire", "Flesh-Eating Plant", "Jackal", "Mutant", "Goblin", "Centaur"};


    String[] bosses = {"Rob Zombie", "Skeletor", "Marilyn Manson", "The Iron Sheik", "Dr. Octopus", "Karen",
            "Darth Vader", "Voldemort", "Hans Gruber", "Cruella Deville", "Freddy Kruger", "Dr. Evil", "Pin Head"};

    public String getEnemy() {

        return enemy = enemies[rand.nextInt(enemies.length)];
    }
    public String getBoss() {

        return boss = bosses[rand.nextInt(bosses.length)];

    }

    public boolean bossFight() {    // when you beat boss you get an undead potion.

        beatBoss = true;
        return beatBoss;
    }

}