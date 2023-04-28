import java.util.Random;
public class fairyTale {
    private boolean luckyDuck;
    private boolean undeadPotion;

    public fairyTale() {
        luckyDuck = false;
        undeadPotion = false;
    }

    public boolean getLuckyDuck() {
        return luckyDuck;
    }

    public boolean getUndeadPotion() {
        return undeadPotion;
    }

    public boolean winPrize(String selection) {

        boolean win = false;
        Random rand = new Random();
        int compChoice = rand.nextInt(4)+1;// selects a random number between 1 and 4
        int number = Integer.parseInt(selection);

        if (number == compChoice) {
            win = true;
        }
        return win;
    }

}
