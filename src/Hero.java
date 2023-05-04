
public class Hero extends Character{

    private int numHealthPotions = 3;
    private int healthPotionHealing;

    public Hero (int health, int attackDamage, int numHealthPotions, int healthPotionHealing){
        this.health = health;
        this.attackDamage = attackDamage;
        this.numHealthPotions = numHealthPotions;
        this.healthPotionHealing = healthPotionHealing;
    }

    @Override
    public void setHealth(int value) {
        health = value;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttackDamage() {
        return attackDamage;
    }

    public void takeDamage(int damageTaken) {
        health -= damageTaken;
    }

    public int getNumHealthPotions() {
        return numHealthPotions;
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

