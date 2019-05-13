import java.util.Collections;
import java.util.Stack;

class Deck {

    private Stack<Card> cardsInDeck;

    Deck() {
        cardsInDeck = new Stack<>();
        produceCards();
    }

    /**
     * Produces a deck of cards.
     */
    private void produceCards() {
        for (int i = 0; i < Suit.values().length; i++) {
            for (int j = 0; j < Rank.values().length; j++) {
                cardsInDeck.add(new Card(Suit.values()[i], Rank.values()[j]));
            }
        }
    }

    /**
     * Sorts the deck.
     */
    void sort() {
        Collections.sort(cardsInDeck);
    }

    // Shuffles the deck
    void shuffle() {
        Collections.shuffle(cardsInDeck);
    }

    /**
     * Pulls and prints the top card from the deck.
     */
    void pull() {
        Card card = cardsInDeck.pop();
        String cardSuit = card.getCardSuit().name();
        String cardRank = card.getCardRank().name();
        String format = "%-5s %-7s\n";
        System.out.format(format, cardRank, cardSuit);
    }

    /**
     * Pulls and prints all cards from the deck, one by one.
     */
    void pullAndPrintAllCards() {
        System.out.println("Pulling all cards in the deck, one by one:");
        while (!cardsInDeck.isEmpty()) {
            pull();
        }
    }

}
