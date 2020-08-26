package Chapter4;

import java.util.*;

/**
 * Represents a deck of playing cards. In this version, the cards in the
 * deck are stored in a list and the list of cards in the deck can
 * be obtained by client code using an immutable wrapper object.
 *
 * This version of the Deck class also implements {@link CardSource}
 * and has a sort() method to demonstrate the use of comparators.
 *
 * The Deck is also iterable: it fulfills the role of ConcreteIterable
 * in the Iterator design pattern.
 */
public class Deck4 implements Iterable<Card4>
{
    private List<Card4> aCards = new ArrayList<>();

    /**
     * Creates a new deck of 52 cards, shuffled.
     */
    public Deck4()
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
                aCards.add( new Card4(rank, suit));
            }
        }
        aCards.add(new Card4(true));
        aCards.add(new Card4(false));
        Collections.shuffle(aCards);
    }

    /**
     * Places pCard on top of the deck.
     * @param pCard The card to place on top
     * of the deck.
     * @pre pCard !=null
     */
    public void push(Card4 pCard)
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
    public List<Card4> getCards()
    {
        return Collections.unmodifiableList(aCards);
    }

    /**
     * Sorts the cards in the deck by ascending rank.
     */
    public void sort()
    {
        Collections.sort(aCards, new Comparator<Card4>()
        {
            public int compare(Card4 pCard1, Card4 pCard2)
            {
                return pCard1.getRank().compareTo(pCard2.getRank());
            }
        });
    }

    @Override
    public Iterator<Card4> iterator()
    {
        return aCards.iterator();
    }
}