/**
 * Write a description of class CardValue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CardValue {

    // instance variables - replace the example below with your own
    private static final int SPADES = 0;
    private static final int HEARTS = 1;
    private static final int DIAMONDS = 2;
    private static final int CLUBS = 3;

    private static final int ACE = 1;

    private static final int JACK = 11;
    private static final int QUEEN = 12;
    private static final int KING = 13;
    int suit, value;

    /**
     * Constructor for objects of class CardValue
     */
    public CardValue(int s, int v) {
        suit = s;
        value = v;
    }

    public int returnSuit() {
        return suit;
    }

    public int returnValue() {
        return value;
    }

    public String SuitOfCard() {
        switch (suit) {
            case SPADES:
                return "Spades";
            case HEARTS:
                return "Hearts";
            case DIAMONDS:
                return "Diamonds";
            case CLUBS:
                return "Clubs";
            default:
                return "issue with suit";
        }
    }


    public int returnValue(int Ace) {
        if (value == 1) {
            if (Ace + 11 <= 21) {
                return 11;
            } else {
                return 1;
            }
        } else if (value > 10) {
            return 10;
        } else {
            return value;
        }
    }

    public String ValueOfCard() {
        switch (value) {

            case 1:
                return "Ace";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return "empty value";
        }
    }

    public String toString() {
        return ValueOfCard() + " of " + SuitOfCard();
    }
}