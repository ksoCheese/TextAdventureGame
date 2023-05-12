public class HeroFactory {

        public Hero createHero(String levelInput) {

            int level = Integer.parseInt(levelInput);
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

    // handles generating boss object after final victory
}
