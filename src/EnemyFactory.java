public class EnemyFactory {

    public Enemy createEnemy(String userInput) {

        int level = Integer.parseInt(userInput);
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
}
