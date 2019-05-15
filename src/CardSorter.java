import java.util.ArrayList;

/**
 * Mergesort implementation for sorting Cards. O(n log n)
 */
class CardSorter {

    /**
     * Merges two lists into one.
     * @param left  The left list to merge.
     * @param right The right list to merge.
     * @return      The merged list.
     */
    private static ArrayList<Card> merge(final ArrayList<Card> left, final ArrayList<Card> right) {
        final ArrayList<Card> merged = new ArrayList<>();
        while (!left.isEmpty() && !right.isEmpty()) {
            // Compares cards from both lists and allocates to new list accordingly.
            if (left.get(0).compareTo(right.get(0)) <= 0) {
                merged.add(left.remove(0));
            } else {
                merged.add(right.remove(0));
            }
        }
        merged.addAll(left);
        merged.addAll(right);
        return merged;
    }

    /**
     * Sorts by recursively dividing the list until they
     * hold only one card each. Then merges the list together,
     * comparing the cards and allocating them accordingly with
     * each merge.
     *
     * @param cards The cards to sort.
     */
    static void mergeSort(final ArrayList<Card> cards) {
        // If cards.size() == 1, the recursion is done and merging begins.
        if (cards.size() != 1) {
            final ArrayList<Card> left = new ArrayList<Card>();
            final ArrayList<Card> right = new ArrayList<Card>();
            // Split list into two sides
            boolean lSwitch = true;
            while (!cards.isEmpty()) {
                if (lSwitch) {
                    left.add(cards.remove(0));
                } else {
                    right.add(cards.remove(0));
                }
                lSwitch = !lSwitch;
            }
            // Recursively divide both sides
            mergeSort(left);
            mergeSort(right);
            // Merge sides
            cards.addAll(merge(left, right));
        }
    }
}
