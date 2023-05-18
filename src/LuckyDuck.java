public class LuckyDuck extends Items {
    private boolean used;

    public LuckyDuck() {
        this.name = "Lucky Duck";
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

        System.out.println("You used the Lucky Duck!");
    }

}
