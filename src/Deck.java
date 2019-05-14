import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a standard card deck with 52 cards.
 * (No jokers)
 *
 * I decided to use an ArrayList as a datastructure for
 * the deck because of its amortized O(1) time complexity
 * for most tasks. Using a List structure also allows
 * for the Collections.sort() and Collections.shuffle()
 * to sort and shuffle the deck using minimal time and space.
 * Another benefit is that we can swap the datastructure to
 * other List structures with minimal effort if the systems
 * requirements change. That means we don't need to change
 * shuffle or sort methods, as they will adapt to the
 * given structure.
 */
class Deck {

    private ArrayList<Card> cardsInDeck;

    Deck() {
        // Reserves 52 memory positions to prevent
        // re-allocations during first initialization.
        cardsInDeck = new ArrayList<>(52);
        produceCards();
    }

    /**
     * Fills the deck with cards.
     */
    private void produceCards() {
        for (int i = 0; i < Suit.values().length; i++) {
            for (int j = 0; j < Rank.values().length; j++) {
                cardsInDeck.add(new Card(
                        Suit.values()[i],
                        Rank.values()[j]));
            }
        }
    }

    /**
     * Sorts the deck.
     * Collections.sort() uses a modified mergesort
     * with a time complexity of O(n log n).
     */
    void sort() {
        Collections.sort(cardsInDeck);
    }

    /**
     * Shuffles the deck.
     * Runs in O(N).
     */
    void shuffle() {
        Collections.shuffle(cardsInDeck);
    }

    /**
     * Pulls and prints the top card from the deck.
     */
    void pull() {
        Card card = cardsInDeck.remove(cardsInDeck.size() - 1);
        String cardSuit = card.getCardSuit().name();
        String cardRank = card.getCardRank().name();
        String format = "%-5s %-7s\n";
        System.out.format(format, cardRank, cardSuit);
    }

    /**
     * Pulls and prints all cards from the deck, one by one.
     */
    void pullAndPrintAllCards() {
        while (!cardsInDeck.isEmpty()) {
            pull();
        }
    }

    ArrayList<Card> getCardsInDeck() {
        return cardsInDeck;
    }
}
