/**
 * Represents a single card from a deck of cards.
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
     * of the suit and rank enums (Suit.Java, Rank.java)
     * to calculate the delta between the cards.
     * Suits are compared first. If the suits are equal
     * then ranks are compared.
     * The method returns an integer with the value
     * difference between the two cards.
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

