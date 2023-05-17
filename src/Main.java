import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //class objects
        var scan = new Scanner(System.in);

        var gameplay = new Game();

        GameControl.gameIntro();

        GameControl.setLevel(scan);

        gameplay.initializeGame(scan);

        gameplay.startRound(scan);

        GameControl.outro();

    }
}
