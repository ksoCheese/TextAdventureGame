public abstract class Character {

    protected int health;
    protected int attackDamage;

    protected String name;


    public abstract void setHealth(int value);

    abstract int getHealth();

    abstract int getAttackDamage();

    public abstract void setName(String name);

    abstract String getName();

}
