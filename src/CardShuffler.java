import java.util.ArrayList;
import java.util.Random;

/**
 * Shuffles a deck of cards. O(N)
 */
class CardShuffler {

    static void shuffle(ArrayList<Card> cards) {
        int n = cards.size();
        Random random = new Random();
        random.nextInt();
        // Go through list, swap card with random card between i and n
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(cards, i, change);
        }
    }

    private static void swap(ArrayList<Card> cards, int i, int change) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(change));
        cards.set(change, temp);
    }
}
