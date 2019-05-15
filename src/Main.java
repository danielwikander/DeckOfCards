public class Main {

    public static void main(String[] args) {
        Deck deck1 = new Deck();
        System.out.println("\nDeck 1. Not shuffled, not sorted:\n");
        deck1.pullAndPrintAllCards();

        Deck deck2 = new Deck();
        deck2.alternativeShuffle();
//        deck2.shuffle();
        System.out.println("\nDeck 2. Shuffled, not sorted:\n");
        deck2.pullAndPrintAllCards();

        Deck deck3 = new Deck();
        deck3.alternativeShuffle();
        deck3.alternativeSort();
//        deck3.shuffle();
//        deck3.sort();
        System.out.println("\nDeck 3. Shuffled and sorted:\n");
        deck3.pullAndPrintAllCards();

    }
}
