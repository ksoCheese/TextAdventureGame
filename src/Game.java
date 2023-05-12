import java.util.Scanner;

public class Game {
    EnemyFactory enemyCreator = new EnemyFactory();
    HeroFactory heroCreator = new HeroFactory();
    Enemy enemy;
    Hero hero;

    public void createEnemy() {
        enemy = enemyCreator.createEnemy(GameControl.getLevel());
        System.out.println("\t*** " + enemy.getEnemyName() + " has appeared!  ***\n");
    }
    public void createHero(Scanner scan) {
        hero = heroCreator.createHero(GameControl.getLevel());

        System.out.println("\t> What is your hero's name? : ");
        String name = scan.nextLine();
        hero.setHeroName(name);
        System.out.println("\t*** " + hero.getHeroName() + " is ready for battle! ***\n");
    }
    public Enemy getEnemy() {
        return enemy;
    }
    public Hero getHero() { return hero; }


}
