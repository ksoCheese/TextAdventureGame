
public class Hero extends Character{

    private int maxHealth;
    private int numHealthPotions = 3;
    private int healthPotionHealing;
    private LuckyDuck luckyDuck = null;
    private UndeadPotion undeadPotion = null;
    private maxHealthPotion maxHealthPotion = null;

    public Hero (int health, int maxHealth, int attackDamage, int numHealthPotions, int healthPotionHealing){
        this.health = health;
        this.maxHealth = maxHealth;
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

    public int setMaxHealth(int maxHealth) {
        return this.maxHealth = maxHealth;
    }
    public int getMaxHealth() { return maxHealth; }

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

    public int getHealthPotionHealing() { return healthPotionHealing; }

    public void setHealthPotionHealing(int healthPotionHealing) {
        this.healthPotionHealing = healthPotionHealing;
    }
    
    // Check if Hero has a LuckyDuck
    public boolean hasLuckyDuck() {
        return luckyDuck != null;
    }

    // Obtain a LuckyDuck
    public void obtainLuckyDuck(LuckyDuck item) {
        this.luckyDuck = item;
    }

    // Check if Hero has an UndeadPotion
    public boolean hasUndeadPotion() {
        return undeadPotion != null;
    }

    // Obtain an UndeadPotion
    public void obtainUndeadPotion(UndeadPotion item) {
        this.undeadPotion = item;
    }

    // Check if Hero has a MaxHealthPotion
    public boolean hasMaxHealthPotion() {
        return maxHealthPotion != null;
    }

    // Obtain a MaxHealthPotion
    public void obtainMaxHealthPotion(maxHealthPotion item) {
        this.maxHealthPotion = item;
    }

    // Use LuckyDuck
    public void useLuckyDuck() {
        if (hasLuckyDuck()) {
            luckyDuck.useItem(this);
            luckyDuck = null;
        }
    }
    // Use UndeadPotion
    public void useUndeadPotion() {
        if (hasUndeadPotion()) {
            undeadPotion.useItem(this);
            undeadPotion = null;
        }
    }

    // Use MaxHealthPotion
    public void useMaxHealthPotion() {
        if (hasMaxHealthPotion()) {
            maxHealthPotion.useItem(this);
            maxHealthPotion = null;
        }
    }
    // warrior vs wizard   warrior has more combat,  wizard has more magic
// difficulty determines health level and number of potions you start with



}

