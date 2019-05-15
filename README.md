# DeckOfCards :hearts: :diamonds: :clubs: :spades:

A simple deck of cards in Java.
The deck can be shuffled and sorted and
cards can be pulled from the top of the deck.

#### Design decisions:
##### Deck:
  I decided to use an ArrayList as a datastructure for
  the deck because of its amortized O(1) time complexity
  for most tasks.
  Using the List structure also allows
  for the Collections.sort() and Collections.shuffle() 
  to sort and shuffle the deck using minimal time and space.
  I have also added my own mergesort and shuffle implementations 
  that can be used instead of the Collections library. (CardSorter.java & CardShuffler.java)
  
  But, using the Collections library means that 
  we can swap the datastructure to
  other List structures with minimal effort if the systems
  requirements change. That means we don't need to change
  our shuffle or sort methods if we switch datastructure, 
  as they will simply adapt to the given structure. 
  For the current structure (using an ArrayList) both implementations work fine.
  
##### Card:
  I decided to implement the Comparable interface on the Card class
  so that they can be compared for sorting. The class uses the compareTo()
  method to compare the ordinal values (their position in their respective enum declaration) from the cards Suit and Rank enums 
  (Suit.java, Rank.java). 
  
##### Tests:
  The tests are written using JUnit 5.2.
  Testmethods are written into nested classes, 
  with one class for each method that is being tested.
  
  Example of the structure:
```
ClassOneTest.java

  class ClassOneTest
    class ClassOneMethodOneTests
      Testmethod()
      Testmethod()
        
    class ClassOneMethodTwoTests
      Testmethod()
      Testmethod()
```
This structure gives a good overview of which test belongs to which method. 

Each testmethod is named using the following format:
```
expectedBehavior_conditionUnderTest()
```
