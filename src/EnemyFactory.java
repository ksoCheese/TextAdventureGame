public class EnemyFactory {

    public Enemy createEnemy(String levelInput) {

        int level = Integer.parseInt(levelInput);
        switch (level) {
            case 1 -> {
                return new Enemy(75, 25, 50);
            }
            case 2 -> {
                return new Enemy(85, 35, 40);
            }
            default -> {
                System.out.println("Please choose 1 or 2: ");
            }
        }
        return null;
    }

    public Boss createBoss(String levelInput) {

        int level = Integer.parseInt(levelInput);
        switch (level) {
            case 1 -> {
                return new Boss(100, 30);
            }
            case 2 -> {
                return new Boss(120, 40);
            }
            default -> {
                System.out.println("Please choose 1 or 2: ");
            }
        }
        return null;
    }

}
