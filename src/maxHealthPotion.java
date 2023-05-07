public class maxHealthPotion extends Items {

    private boolean used;
    public maxHealthPotion() {

        this.name = "Max Health Potion";
        this.used = false;
    }
    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean isUsed() {
        return used;
    }

    @Override
    public void useItem(Hero hero){
        setUsed(true);
        hero.setHealth(hero.getMaxHealth());
        System.out.println("You used the " + this.name + "! Your health is fully restored! ");
    }
}
