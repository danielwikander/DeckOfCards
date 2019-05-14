/**
 * Represents a card from a card deck.
 */
public class Card implements Comparable<Card> {
    private Rank rank;
    private Suit suit;

    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    Rank getCardRank() {
        return rank;
    }

    Suit getCardSuit() {
        return suit;
    }

    /**
     * Compares two cards for sorting purposes.
     * This method uses the ordinal values
     * of the suit and rank enums to calculate
     * the delta between two cards.
     * It starts by comparing the suits.
     * If the suits are equal, it compares ranks.
     * The delta is the integer value difference
     * between the two cards.
     *
     * @param card The card to compare to.
     * @return     0 if the two cards are equal,
     *             negative if the card is greater than this card,
     *             positive if the card is lesser than this card.
     */
    @Override
    public int compareTo(Card card) {
        int delta = this.suit.compareTo(card.suit);
        if (delta != 0) {
            return delta;
        } else {
            return this.rank.compareTo(card.rank);
        }
    }
}

