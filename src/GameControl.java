import java.util.Scanner;
public class GameControl {

    private static String level;
    private static int victoryCount;
    private static boolean running = true;

    public static boolean isRunning() {
        return running;
    }

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

    public static String getLevel() {
        return level;
    }

    public static int getVictoryCount()  { return victoryCount; }

    public static boolean exitGame(Scanner scan, int counter) {
        System.out.println("---------------------------------------------------------");
        System.out.println("What would you like to do now? ");
        System.out.println("1. Continue fighting");
        System.out.println("2. Exit dungeon");

        String input = scan.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command!");
            input = scan.nextLine();
        }
        if (input.equals ("1")) {
            System.out.println("You continue on your adventure");
        } else if(input.equals("2")){
            System.out.println("You exit the dungeon, tired from your battles. ");
            System.out.println("You've defeated " + counter + " enemies!");
            running = false;
        }
        return running;
    }

    public static void outro() {

        System.out.println("\n###########################################################");
        System.out.println("\n THANKS FOR PLAYING!!!");
        System.out.println("\n###########################################################");
    }
}
