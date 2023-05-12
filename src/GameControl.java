import java.util.Scanner;
public class GameControl {

    private static String level;
    private static int victoryCount;

    public static void gameIntro(){

        System.out.println("---------------------------------------------------------");
        System.out.println("\n\tWelcome to the Dungeon!");
        System.out.println("\n\tDefeat your enemies and walk out victorious!!!");
        System.out.println("\n\tIf you defeat all enemies in the dungeon, you can claim your reward!!!");

    }
    public static void setLevel(Scanner scan){

        while (true) {
            System.out.println("\nSelect your difficulty level: ");
            System.out.println(" 1. Regular");
            System.out.println(" 2. Difficult");

            level = scan.nextLine();

            if (level.equals("1")) {
                victoryCount = 8;
                break;
            } else if (level.equals("2")) {
                victoryCount = 15;
                break;
            } else
                System.out.println("Invalid Command");
        }
    }


    public static int getVictoryCount()  { return victoryCount; }


    public static String getLevel() {
        return level;
    }
}
