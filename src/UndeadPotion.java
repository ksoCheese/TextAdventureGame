public class UndeadPotion extends Items {
    private boolean used;

    public UndeadPotion() {
        this.name = "Undead Potion";
        this.used = false;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean isUsed() {
        return used;
    }

    @Override
    public void useItem(Hero hero) {
        setUsed(true);
        hero.setHealth(hero.getMaxHealth() / 2);
        System.out.println("You used the Undead Potion! Your health is partially restored!");
    }

}
