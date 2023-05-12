import java.util.Random;
import java.util.Scanner;
public class Fairy {

    Random rand = new Random();
    private int fairyEncounterChance;
    private String selection;
    public int getFairyEncounterChance() {
        return fairyEncounterChance;
    }

    public Fairy(int fairyEncounterChance) {
        this.fairyEncounterChance = fairyEncounterChance;
    }

    public String getSelection() { return selection; }

    public String meetFairy(Scanner scan) {
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

        return this.selection = scan.nextLine();

    }

    public boolean winItem(Scanner scan) {
        int compChoice = rand.nextInt(4) + 1; // selects a random number between 1 and 4

        int number;
        while (true) {
            try {
                number = Integer.parseInt(selection);
                if (number >= 1 && number <= 4) {
                    break;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                selection = scan.nextLine();
            }
        }

        return (number == compChoice);
    }


    public Items selectItem() {
        int itemSelected = rand.nextInt(3)+1;

        if (itemSelected == 1){
            return new LuckyDuck();
        }
        else if (itemSelected == 2) {
            return new maxHealthPotion();
        }
        else
            return new UndeadPotion();
    }

    public void rewardHero(Hero hero) {

        System.out.println("\t*** YOU WON... ");
        Items itemWon = this.selectItem();
        System.out.println("\tYou received: " + itemWon.getName());

        if (itemWon instanceof LuckyDuck) {
            hero.obtainLuckyDuck((LuckyDuck) itemWon);
        } else if (itemWon instanceof maxHealthPotion) {
            hero.obtainMaxHealthPotion((maxHealthPotion) itemWon);
        } else if (itemWon instanceof UndeadPotion) {
            hero.obtainUndeadPotion((UndeadPotion) itemWon);
        }

    }
}
