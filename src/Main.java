import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //class objects
        var scan = new Scanner(System.in);

        var gameplay = new Game();

        GameControl.gameIntro();

        GameControl.setLevel(scan);

        gameplay.createHero(scan);

        gameplay.createFairy();


        int counter = 0;  // keep track of victories

        GAME: //label "Game" is name of this while loop
        while(GameControl.isRunning()) {
            Hero hero =gameplay.getHero();
            if (hero.hasMaxHealthPotion()) {
                hero.useMaxHealthPotion();
            }

            gameplay.createEnemy();
            Enemy enemy = gameplay.getEnemy();

            /// nested while loop continues while fighting
            while (enemy.getHealth() > 0) {
                gameplay.engageEnemy();

                if (!gameplay.enemyBattle(scan)) {
                    if (hero.getHealth() < 1) {
                        if (gameplay.oneMoreChance()) {
                            continue GAME;
                        } else{
                            break GAME;
                        }
                    } else {
                        continue GAME;
                    }
                }
            }

            // when breaks out of fighting loop, will add win because option 2 drinks potion and continues fight,
            // option 3 will run and restart game loop. health < 1 ends game. so this increments only when fight won
            counter++;
            gameplay.defeatEnemyMsg();

            if (counter == GameControl.getVictoryCount()){

                // engage in final boss fight
                gameplay.createBoss();
                Boss boss = gameplay.getBoss();

                while (boss.getHealth() > 0) {
                    gameplay.engageBoss();

                    if (!gameplay.bossFight(scan)){
                        break GAME;
                    }
                    if (hero.getHealth() < 1) {
                        break GAME;
                    }

                    if (boss.getHealth() < 1) {
                        gameplay.victoryMsg(counter);
                        break GAME;
                    }

                }
            }

            gameplay.checkForPotionDrop();

            gameplay.checkforFairyEncounter(scan);

            GameControl.exitGame(scan, counter);

        }

        GameControl.outro();


    }
}
