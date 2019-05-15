import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Tests are written using JUnit 5.2
 *
 * This class contains all tests for the Deck class.
 * Each method from the Deck class has a nested
 * class containing the relevant tests for that method.
 *
 * The tests are named using the following format:
 * expectedBehavior_conditionUnderTest()
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
    class shuffleTests {

        @Test
        void isTrue_ifFullDeckIsShuffled() {
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

        @Test
        void isTrue_ifNonFullDeckIsShuffled() {
            deck.pull();
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
    class sortTests {

        @Test
        void isTrue_ifFullDeckIsSorted() {
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

        @Test
        void isTrue_ifNonFullDeckIsSorted() {
            deck.pull();
            deck.sort();
            ArrayList<Card> shuffledDeck = deck.getCardsInDeck();
            boolean sorted = true;
            for (int i = 1; i < shuffledDeck.size(); i++) {
                if (shuffledDeck.get(i - 1).compareTo(shuffledDeck.get(i)) > 0) {
                    sorted = false;
                }
            }
            assertTrue(sorted);
        }
    }

    @Nested
    class pullTest {

        // Streams for analyzing System.err output
        private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        private final PrintStream originalErr = System.err;

        @BeforeEach
        void setUpErrorStream() {
            System.setErr(new PrintStream(errContent));
        }

        @AfterEach
        void restoreErrorStream() {
            System.setErr(originalErr);
        }

        @Test
        void isTrue_ifCardIsPulledFromDeck() {
            int amountOfCardsInDeck = deck.getCardsInDeck().size();
            deck.pull();
            assertEquals(deck.getCardsInDeck().size(),
                    amountOfCardsInDeck - 1);
        }

        @Test
        void isTrue_ifPrintsWhenDeckEmpty() {
            deck.pullAndPrintAllCards();
            deck.pull();
            assertEquals("DECK EMPTY\n",
                    errContent.toString());
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