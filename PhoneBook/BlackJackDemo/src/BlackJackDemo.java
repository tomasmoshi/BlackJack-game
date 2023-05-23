import java.util.Scanner;

/**
 * Write a description of class BlackJackDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BlackJackDemo {
    public static void main(String[] args) {
        int s = 0;
        int v = 0;
        CardShuffle cs = new CardShuffle();
        CardValue cv = new CardValue(s, v);

        int choice = 99;
        while (choice != 4) {
            choice = menu();
            switch (choice) {

                case 1:
                    System.out.println("lets begin a new game.");
                    cs.cardPlay();

                    break;
                case 2:
                    System.out.println("The rules of the game are:");
                    System.out.println("1. The hand with the highest total" +
                            " wins as long as it doesn't exceed 21."
                            + " A hand with higher than 21 is known as a bust");
                    System.out.println("2. Cards 2 through 10 are worth their face value," +
                            " and face cards (jack, queen, king) are also worth 10");
                    System.out.println("3. An ace's value is 11 unless this would cause the player to bust," +
                            " in which case it is worth 1.A hand in which an ace's value is counted as 11 " +
                            "is called a soft hand, because it cannot be busted if the player draws another card.");
                    System.out.println("4. if the player busts he loses, even if the dealer also busts (therefore Blackjack favors the dealer). ");
                    System.out.println("5. If both the player and the dealer have the same point value, it is called a push, and neither player nor dealer wins the hand.");
                    System.out.println("6.Each player has an independent game with the dealer, so it is possible for the dealer to lose to one player, but still beat the other players in the same round.");
                    System.out.println("The dealer gives two cards to each player, including himself. One of the dealer's two cards is face-up so all the players can see it, and the other is face down");
                    break;
                case 3:
                    System.out.println("here are some tests to make sure the program works?");
                    System.out.println("shuffling the deck and showing the size of the deck: ");
                    cs.ShuffleDeck();
                    System.out.println("the top card is: " + cs.TopCard());
                    System.out.println("dealing out the top card : " + cs.CardDeal());
                    break;
                case 4:
                    System.out.println("thank you and goodbye\n");
                    System.exit(0);
                    break;
            }
        }
    }

    public static int menu() {
        int choice = 99;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to the BlackJack enter a operation you wish to perform.");
        System.out.println("1. Start a new game\n" +
                "2. view rules of the game\n" +
                "3. test calls\n" +
                "4. Exit Program\n ");
        System.out.println("Enter Choice: ");
        try {
            choice = sc.nextInt();
            while (choice < 1 || choice > 4) {
                System.out.println("Please enter a valid menu choice: ");
                choice = sc.nextInt();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("!!Non Integer entered!!");
            sc.next();
            choice = 99;
        }
        System.out.println();
        return choice;
    }
}
