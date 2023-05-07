public class setGame {
    private static int victoryCount;
    public static void gameIntro(){

        System.out.println("---------------------------------------------------------");
        System.out.println("\n\tWelcome to the Dungeon!");
        System.out.println("\n\tDefeat your enemies and walk out victorious!!!");
        System.out.println("\n\tIf you defeat all enemies in the dungeon, you can claim your reward!!!");
        System.out.println("\nSelect your difficulty level: ");
        System.out.println(" 1. Regular");
        System.out.println(" 2. Difficult");
    }
    public static void setLevel(String levelInput){

        if(levelInput.equals("1")){
            victoryCount = 8;
        }
        else if(levelInput.equals("2")) {
            victoryCount = 15;
        }
        else
            System.out.println("Invalid Command");
    }


    public static int getVictoryCount()  { return victoryCount; }


}
