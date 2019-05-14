import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains all tests for the Card class.
 * Each method from the Card class has a nested
 * class containing the relevant tests for that method.
 *
 * The tests are named using the following format:
 * expectedBehavior_stateUnderTest()
 */
class CardTest {

    // Boundary limits for boundary tests
    private final int suitsUpperBoundary = Suit.values().length - 1;
    private final int ranksUpperBoundary = Rank.values().length - 1;
    private final int lowerBoundary = 0;

    private Card card;

    /**
     * Boundary tests for the Card constructor.
     */
    @Nested
    class CardConstructorTest {

        @AfterEach
        void tearDown() {
            card = null;
        }

        @Test
        void throwsException_whenSuitParamUnderLowerBoundary() {
            assertThrows(ArrayIndexOutOfBoundsException.class,
                    () -> card = new Card(
                            Suit.values()[lowerBoundary - 1],
                            Rank.values()[lowerBoundary]));
        }

        @Test
        void throwsException_whenRankParamUnderLowerBoundary() {
            assertThrows(ArrayIndexOutOfBoundsException.class,
                    () -> card = new Card(
                            Suit.values()[lowerBoundary],
                            Rank.values()[lowerBoundary - 1]));
        }

        @Test
        void throwsException_whenSuitParamOverHigherBoundary() {
            assertThrows(ArrayIndexOutOfBoundsException.class,
                    () -> card = new Card(
                            Suit.values()[suitsUpperBoundary + 1],
                            Rank.values()[lowerBoundary]));
        }


        @Test
        void throwsException_whenRankParamOverHigherBoundary() {
            assertThrows(ArrayIndexOutOfBoundsException.class,
                    () -> card = new Card(
                            Suit.values()[lowerBoundary],
                            Rank.values()[ranksUpperBoundary + 1]));
        }

        @Test
        void isEqual_whenSuitParamWithinLowerBoundary() {
            card = new Card(
                    Suit.values()[lowerBoundary],
                    Rank.values()[lowerBoundary]);

            assertEquals(card.getCardSuit(), Suit.values()[lowerBoundary]);
        }

        @Test
        void isEqual_whenRankParamWithinLowerBoundary() {
            card = new Card(
                    Suit.values()[lowerBoundary],
                    Rank.values()[lowerBoundary]);

            assertEquals(card.getCardRank(), Rank.values()[lowerBoundary]);
        }

        @Test
        void isEqual_whenSuitParamWithinUpperBoundary() {
            Card card = new Card(
                    Suit.values()[suitsUpperBoundary],
                    Rank.values()[lowerBoundary]);

            assertEquals(card.getCardSuit(), Suit.values()[suitsUpperBoundary]);
        }

        @Test
        void isEqual_whenRankParamWithinUpperBoundary() {
            Card card = new Card(
                    Suit.values()[lowerBoundary],
                    Rank.values()[ranksUpperBoundary]);

            assertEquals(card.getCardRank(), Rank.values()[ranksUpperBoundary]);
        }
    }

    /**
     * Tests for getCardRank()
     */
    @Nested
    class getCardRankTest {

        @Test
        void isEquals_whenRetrievesCorrectRank() {
            card = new Card(
                    Suit.values()[suitsUpperBoundary],
                    Rank.values()[ranksUpperBoundary]);

            assertEquals(card.getCardRank(), Rank.values()[ranksUpperBoundary]);
        }

    }

    /**
     * Tests for getCardSuit()
     */
    @Nested
    class getCardSuitTest {

        @Test
        void isEquals_whenRetrievesCorrectSuit() {
            card = new Card(
                    Suit.values()[suitsUpperBoundary],
                    Rank.values()[ranksUpperBoundary]);

            assertEquals(card.getCardSuit(), Suit.values()[suitsUpperBoundary]);
        }

    }

    /**
     * Tests for compareTo()
     */
    @Nested
    class compareToTests {

        /**
         * Compares two identical cards.
         * The returned int should be == 0.
         */
        @Test
        void isEqual_whenCardOneEqualsCardTwo() {
            Card cardOne = new Card(
                    Suit.values()[suitsUpperBoundary],
                    Rank.values()[ranksUpperBoundary]);
            Card cardTwo = new Card(
                    Suit.values()[suitsUpperBoundary],
                    Rank.values()[ranksUpperBoundary]);

            assertEquals(0, cardOne.compareTo(cardTwo));
        }

        /**
         * Compares two cards. cardOne has a greater suit than cardTwo.
         * The returned int should be > 0.
         */
        @Test
        void isTrue_whenCardOneSuitGreaterThanCardTwoSuit() {
            Card cardOne = new Card(
                    Suit.values()[lowerBoundary + 1],
                    Rank.values()[lowerBoundary]);
            Card cardTwo = new Card(
                    Suit.values()[lowerBoundary],
                    Rank.values()[lowerBoundary]);

            int delta = cardOne.compareTo(cardTwo);
            assertTrue(delta > 0);
        }

        /**
         * Compares two cards. cardOne has a lesser suit than cardTwo.
         * The returned int should be < 0.
         */
        @Test
        void isTrue_whenCardOneSuitLesserThanCardTwoSuit() {
            Card cardOne = new Card(
                    Suit.values()[lowerBoundary],
                    Rank.values()[lowerBoundary]);
            Card cardTwo = new Card(
                    Suit.values()[lowerBoundary + 1],
                    Rank.values()[lowerBoundary]);

            int delta = cardOne.compareTo(cardTwo);
            assertTrue(delta < 0);
        }

        /**
         * Compares two cards. The cards have the same suit.
         * cardOne has a greater rank than cardTwo.
         * The returned int should be > 0.
         */
        @Test
        void isTrue_whenCardSuitsEqual_And_CardOneRankGreaterThanCardTwoRank() {
            Card cardOne = new Card(
                    Suit.values()[lowerBoundary],
                    Rank.values()[lowerBoundary + 1]);
            Card cardTwo = new Card(
                    Suit.values()[lowerBoundary],
                    Rank.values()[lowerBoundary]);

            int delta = cardOne.compareTo(cardTwo);
            assertTrue(delta > 0);
        }

        /**
         * Compares two cards. The cards have the same suit.
         * cardOne has a lesser rank than cardTwo.
         * The returned int should be > 0.
         */
        @Test
        void isTrue_whenCardSuitsEqual_And_CardOneRankLesserThanCardTwoRank() {
            Card cardOne = new Card(
                    Suit.values()[lowerBoundary],
                    Rank.values()[lowerBoundary]);
            Card cardTwo = new Card(
                    Suit.values()[lowerBoundary],
                    Rank.values()[lowerBoundary + 1]);

            int delta = cardOne.compareTo(cardTwo);
            assertTrue(delta < 0);
        }
    }
    
}