
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
     * Compares two cards for sorting.
     * @param card The card to compare to.
     * @return     0 if the two cards are equal,
     *             negative if the card is greater than this card,
     *             positive if the card is lesser than this card.
     */
    @Override
    public int compareTo(Card card) {
        int suitComparison = this.suit.compareTo(card.suit);
        // Compares suits first. If the suits are equal, compares the ranks.
        if (suitComparison != 0) {
            return suitComparison;
        } else {
            return this.rank.compareTo(card.rank);
        }
    }
}

