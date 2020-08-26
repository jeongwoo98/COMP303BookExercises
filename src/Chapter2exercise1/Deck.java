package Chapter2exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a deck of playing cards. In this version, the cards in the
 * deck are stored in a list and the list of cards in the deck can
 * be obtained by client code using an immutable wrapper object.
 */

public class Deck
{
    private List<Card> aCards = new ArrayList<>();

    /**
     * Creates a new deck of 52 cards, shuffled.
     */
    public Deck()
    {
        shuffle();
    }

    /**
     * Reinitializes the deck with all 52 cards, and shuffles them.
     */
    public void shuffle()
    {
        aCards.clear();
        for( Suit suit : Suit.values() )
        {
            for( Rank rank : Rank.values() )
            {
                aCards.add( new Card( rank, suit ));
            }
        }
        Collections.shuffle(aCards);
    }

    /**
     * Places pCard on top of the deck.
     * @param pCard The card to place on top
     * of the deck.
     * @pre pCard !=null
     */
    public void push(Card pCard)
    {
        assert pCard != null;
        aCards.add(pCard);
    }

    /**
     * Draws a card from the deck: removes the card from the top
     * of the deck and returns it.
     * @return The card drawn.
     * @pre !isEmpty()
     */
    public Card draw()
    {
        assert !isEmpty();
        return aCards.remove(aCards.size() - 1);
    }

    /**
     * @return True if and only if there are no cards in the deck.
     */
    public boolean isEmpty()
    {
        return aCards.isEmpty();
    }

    /**
     * @return An unmodifiable list of all the cards in the deck.
     */
    /*public List<Card> getCards()
    {
        return Collections.unmodifiableList(aCards);
    }*/

   /* public List<Card> getCards(){
        return new ArrayList<>(aCards);
    }*/

   /*public List<Card> getCards(){
       ArrayList<Card> result = new ArrayList<>();
       for(Card card: aCards){
           result.add(new Card(card));
       }
       return result;
   }*/

  public Deck(Deck pDeck){
      for(Card card: pDeck.aCards){
          aCards.add(new Card(card));
      }
  }

}
//Add a method getCards() to the Deck class that returns the cards in the deck without breaking encapsulation.
//Since strings are immutable, we can just create a new reference to the same cards.This is shallow copying.
//We can never change string values, so this is okay
