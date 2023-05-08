public class HeroFactory {

        public Hero createHero(String userInput) {

            int level = Integer.parseInt(userInput);
            switch (level) {
                case 1 -> {
                    return new Hero(100, 100, 50, 3, 35);
                }
                case 2 -> {
                    return new Hero(75, 100, 40, 2, 30);
                }
                default -> {
                    System.out.println("Please choose 1 or 2:  ");
                }
            }
            return null;
        }
    //handles generating object for hero and enemy based on difficulty user sets

    // handles victory count needed to meet boss object

    // handles generating boss object after final victory
}
