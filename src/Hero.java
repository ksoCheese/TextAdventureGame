
public class Hero {

    //player variables
    private int health;
    private int attackDamage;

    private int numHealthPotions = 3;

    public Hero (int health, int attackDamage, int numHealthPotions){

        this.health = health;
        this.attackDamage = attackDamage;
        this.numHealthPotions = numHealthPotions;
    }
    public void setHealth(int value) {
        health = value;
    }

    public int getHealth() {
        return health;
    }
    public int getNumHealthPotions() {
        return numHealthPotions;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void takeDamage(int damageTaken) {
        health -= damageTaken;
    }

    public void usePotion(int healthFromPotion) {

        if(this.getNumHealthPotions() > 0){
            this.health += healthFromPotion;
            numHealthPotions--;

            System.out.println("\t You drink the health potion, healing yourself for " + healthFromPotion +"."
                    + "\n\t> You now have " + health + "HP."
                    + "\n\t> You have " + numHealthPotions + " health potions left.\n");
        }
        else{
            System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!");
        }
    }

    public void addHealthPotion() {
        numHealthPotions++;
    }


    // warrior vs wizard   warrior has more combat,  wizard has more magic
// difficulty determines health level and number of potions you start with



}

