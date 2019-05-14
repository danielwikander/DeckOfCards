import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains all tests for the Deck class.
 * Each method from the Deck class has a nested
 * class containing the relevant tests for that method.
 *
 * The tests are named using the following format:
 * expectedBehavior_stateUnderTest()
 */
class DeckTest {
    private Deck deck;

    @AfterEach
    void tearDown() {
        deck = null;
    }

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Nested
    class ProduceCardsTest {

        @Test
        void isEqual_ifNewDeckHas52Cards() {
            ArrayList<Card> cardsInDeck = deck.getCardsInDeck();
            assertEquals(52, cardsInDeck.size());
        }
    }

    @Nested
    class shuffleTest {

        @Test
        void isTrue_ifDeckIsShuffled() {
            deck.shuffle();
            ArrayList<Card> shuffledDeck = deck.getCardsInDeck();

            boolean shuffled = false;
            for(int i = 1; i < shuffledDeck.size(); i++) {
                if(shuffledDeck.get(i - 1).compareTo(shuffledDeck.get(i)) > 0) {
                    shuffled = true;
                    break;
                }
            }
            assertTrue(shuffled);
        }
    }

    @Nested
    class sortTest {

        @Test
        void isTrue_ifDeckIsSorted() {
            deck.sort();
            ArrayList<Card> shuffledDeck = deck.getCardsInDeck();
            boolean sorted = true;
            for(int i = 1; i < shuffledDeck.size(); i++) {
                if (shuffledDeck.get(i - 1).compareTo(shuffledDeck.get(i)) > 0) {
                    sorted = false;
                }
            }
            assertTrue(sorted);
        }
    }

    @Nested
    class pullTest {

        @Test
        void isTrue_ifCardIsPulledFromDeck() {
            int amountOfCardsInDeck = deck.getCardsInDeck().size();
            deck.pull();
            assertEquals(deck.getCardsInDeck().size(),
                    amountOfCardsInDeck - 1);
        }
    }

    @Nested
    class pullAndPrintAllCardsTest {

        @Test
        void isTrue_ifAllCardsArePulledFromDeck() {
            deck.pullAndPrintAllCards();
            int amountOfCardsInDeck = deck.getCardsInDeck().size();
            assertEquals(0,
                    amountOfCardsInDeck);
        }
    }
}