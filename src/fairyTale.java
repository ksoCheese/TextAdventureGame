import java.util.Random;
public class fairyTale {


    public void meetFairy() {
        System.out.println("----------------------------------------------------------");
        System.out.println("\n\t *** YOU ENCOUNTER A FAIRY!!! ***");
        System.out.println("\tHello traveler!  Play a game and win a valuable prize!!");
        System.out.println("\n\tYou must select one of these four pouches...");
        System.out.println("\tIf you select correctly, you will win whatever is inside!");
        System.out.println("\n\tPick one: ");
        System.out.println("\t1. blue pouch");
        System.out.println("\t2. red pouch");
        System.out.println("\t3. green pouch");
        System.out.println("\t4. black pouch");
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
