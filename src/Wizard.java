//import java.util.Random;
//import java.util.Scanner;
//
//public class Wizard {  /// random encounter, will award spells that do different things.
//    // one spell deals 50% damage to enemy!
//    // one spell awards you 20 health points!
//    // one spell confuses enemy and they only deal 1 damage point
//
//
//
//        Random rand = new Random();
//        private  int wizardEncounterChance;
//        private String selection;
//
//        public void createWizard() {
//
//            int level = Integer.parseInt(GameControl.getLevel());
//            switch (level) {
//                case 1 -> {
//                    wizardEncounterChance = 50;
//                }
//                case 2 -> {
//                    wizardEncounterChance= 40;
//                }
//                default -> {
//                    System.out.println("Please choose 1 or 2: ");
//                }
//            }
//        }
//        public int getWizardEncounterChance() {
//            return wizardEncounterChance;
//        }
//
//        // public String getSelection() { return selection; }
//
//        public String meetWizard(Scanner scan) {
//            System.out.println("----------------------------------------------------------");
//            System.out.println("\n\t *** A WIZARD MATERIALIZES BEFORE YOU!!! ***");
//            System.out.println("\tHello traveler!  Your coming was foretold! Allow me to assist in your quest!!");
//            System.out.println("\n\tYou must select one of these 4 crystals...");
//            System.out.println("\tIf you select correctly, I will grant you one spell!");
//            System.out.println("\n\tPick one: ");
//            System.out.println("\t1. onyx crystal ");
//            System.out.println("\t2. opal crystal");
//            System.out.println("\t3. ruby crystal");
//            System.out.println("\t4. jade crystal");
//
//            return this.selection = scan.nextLine();
//
//        }
//
//        public boolean winCrystal(Scanner scan) {
//            int compChoice = rand.nextInt(4) + 1; // selects a random number between 1 and 4
//
//            int number;
//            while (true) {
//                try {
//                    number = Integer.parseInt(selection);
//                    if (number >= 1 && number <= 4) {
//                        break;
//                    } else {
//                        throw new NumberFormatException();
//                    }
//                } catch (NumberFormatException e) {
//                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
//                    selection = scan.nextLine();
//                }
//            }
//
//            return (number == compChoice);
//        }
//
//
//        public Items selectItem() {         /////////////// WORKING ON THIS CODE ////////////////
//            int itemSelected = rand.nextInt(3)+1;
//
//            if (itemSelected == 1){
//                return new Spell();
//            }
//            else if (itemSelected == 2) {
//                return new maxHealthPotion();
//            }
//            else
//                return new UndeadPotion();
//        }
//
//        public void rewardHero(Hero hero) {
//
//            System.out.println("\t*** YOU WON... ");
//            Items itemWon = this.selectItem();
//            System.out.println("\tYou received: " + itemWon.getName());
//
//            if (itemWon instanceof LuckyDuck) {
//                hero.obtainLuckyDuck((LuckyDuck) itemWon);
//            } else if (itemWon instanceof maxHealthPotion) {
//                hero.obtainMaxHealthPotion((maxHealthPotion) itemWon);
//            } else if (itemWon instanceof UndeadPotion) {
//                hero.obtainUndeadPotion((UndeadPotion) itemWon);
//            }
//
//        }
//
//}
