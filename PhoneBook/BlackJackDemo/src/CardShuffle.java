import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class CardShuffle {
    LinkedList<CardValue> deckOfCards;
    LinkedList<CardValue> discardDeck;
    Random randomNumbers = new Random();
    CardValue cv;
    int cards;
    int suitOfCard;
    int cardNumbers;
    LinkedList<CardValue> playerHand = new LinkedList<>();
    LinkedList<CardValue> dealerHand = new LinkedList<>();



    int moneyValue = 100;

    /**
     * constructor
     * this CardShuffle methods sets the 13 card values of deck with the 4 possible suits of cards
     */
    public CardShuffle() {
        deckOfCards = new LinkedList<>();
        discardDeck = new LinkedList<>();
        for (suitOfCard = 0; suitOfCard < 4; suitOfCard++) {
            for (cardNumbers = 1; cardNumbers <= 13; cardNumbers++) {
                deckOfCards.add(new CardValue(suitOfCard, cardNumbers));

            }
        }
    }

    /**
     * shuffles the 52 card deck
     */
    public void ShuffleDeck() {

        for (int i = deckOfCards.size() - 1; i > 0; i--) {

            cards = randomNumbers.nextInt(i + 1);
            cv = deckOfCards.get(cards);
            deckOfCards.set(cards, deckOfCards.get(i));
            deckOfCards.set(i, cv);
        }

        // DEBUG: Printing for sanity
        int i = 0;

        for (CardValue cv : discardDeck) {
            System.out.printf("Card #%d in discard pile: (%s)%n", ++i, cv);
            //System.out.printf("Card #%d in Deck: (%s, %s)%n", ++i, cv.ValueOfCard(), cv.SuitOfCard());
        }
        System.out.println("----------------------");
        i = 0;
        for (CardValue cv : deckOfCards) {
            System.out.printf("Card #%d in Deck: (%s)%n", ++i, cv);
            //System.out.printf("Card #%d in Deck: (%s, %s)%n", ++i, cv.ValueOfCard(), cv.SuitOfCard());
        }

    }

    /**
     * @return the new size of the deck
     */
    public int CardsLeft() {
        return deckOfCards.size();
    }

    /**
     * @return empty if the deck is empty or
     * removes and returns the first element of the deck
     */
    public CardValue CardDeal() {
        if (deckOfCards.isEmpty()) {
            if (discardDeck.isEmpty())
                return null;
            deckOfCards = discardDeck;
            discardDeck = new LinkedList<>();
            ShuffleDeck();
        }
        //discardDeck.add(deckOfCards.get(0));
        return deckOfCards.remove(0);
    }

    public CardValue TopCard() {
        return deckOfCards.peek();
    }
/*
    public void betValue(){
        Scanner keyboard = new Scanner(System.in);
        playerHand = new LinkedList<>();
        int moneyValue = 100;
        int betValue;
        System.out.println("you have $100 in your bank account.");
        System.out.println("how much would you like to play with?");
        betValue = keyboard.nextInt();
        moneyValue-=betValue;
        if (betValue<moneyValue){
            System.out.println("need more funds");
        }
        if ()
        }
        */

    public void Play() {
        Scanner keyboard = new Scanner(System.in);
        int betValue;
        boolean playerWin;

        System.out.println("you have " + moneyValue + " to bet with.");
        System.out.println("how much would you like to play with?");
        betValue = keyboard.nextInt();

        while (betValue>moneyValue){
            System.out.println("need more funds");
            System.out.println("you have " + moneyValue + " to bet with.");
            System.out.println("how much would you like to play with?");
            betValue = keyboard.nextInt();
        }
        moneyValue-=betValue;


        int playerHandTotal = 0, dealerHandTotal = 0;
        String word = "";

        playerHand = new LinkedList<>();
        dealerHand = new LinkedList<>();

        playerHand.add(CardDeal());
        dealerHand.add(CardDeal());

        playerHand.add(CardDeal());
        dealerHand.add(CardDeal());

        for (CardValue pC : playerHand) {
            playerHandTotal += pC.returnValue(playerHandTotal);
        }
        for (CardValue dC : dealerHand) {
            dealerHandTotal += dC.returnValue(dealerHandTotal);
        }
        playerWin = false;
        while (true) {
            System.out.println("Your hand total is " + playerHandTotal + ".");
            for (CardValue phC : playerHand) {
                System.out.printf("Player Card: %s%n", phC);
            }
            if (playerHandTotal == 21) {
                System.out.println("You win!");
                playerWin = true;
                System.out.println("your new total is " + moneyValue);
                break;
            }
            while (playerHandTotal < 22 && !word.equals("stand")) {
                System.out.println("would you like to hit or stand?");
                word = keyboard.next().toLowerCase();

                while (!word.equals("hit") && !word.equals("stand")) {
                    System.out.println("please enter hit or stand");
                    word = keyboard.next().toLowerCase();
                }
                if (word.equals("hit")) {
                    playerHand.add(CardDeal());
                    if (!playerHand.getLast().ValueOfCard().equals("Ace"))
                        playerHandTotal += playerHand.getLast().returnValue(playerHandTotal);
                    else
                        playerHandTotal += playerHand.getLast().returnValue();
                    System.out.println("Your hand total is " + playerHandTotal + ".");
                    for (CardValue phC : playerHand) {
                        System.out.printf("Player Card: %s%n", phC);
                    }
                } else {
                    System.out.println("Dealers turn");
                }
            }
            while (dealerHandTotal < 17 && (!deckOfCards.isEmpty() || !discardDeck.isEmpty())) {
                dealerHand.add(CardDeal());
                if (!dealerHand.getLast().ValueOfCard().equals("Ace"))
                    dealerHandTotal += dealerHand.getLast().returnValue(dealerHandTotal);
                else
                    dealerHandTotal += dealerHand.getLast().returnValue();
            }

            System.out.println("Dealer's hand total is " + dealerHandTotal + ".");
            for (CardValue dhC : dealerHand) {
                System.out.printf("dealer Card: %s%n", dhC);
            }
            if (playerHandTotal > 21) {
                System.out.println("Bust, You Lose");
                System.out.println("your new total is "+ moneyValue);
                break;
            } else if (dealerHandTotal > 21) {
                System.out.println("Dealers Loses");
                break;
            } else if (dealerHandTotal > playerHandTotal) {
                System.out.println("Dealer Wins");
                break;
            } else if (playerHandTotal > dealerHandTotal) {
                System.out.println("You Win");
                break;
            } else {
                System.out.println("tie game nobody wins");
                break;
            }

        }
        if (playerWin){
            moneyValue += (betValue * 2);
        }
        System.out.printf("Player %s $%d, new total $%d%n", (playerWin ? "wins":  "loses"), betValue, moneyValue);
        if(moneyValue<=0){
            System.out.println("game over");
            //System.out.println("Would you like to play again enter y or n");
        }
        discardDeck.addAll(playerHand);
        discardDeck.addAll(dealerHand);

    }
}