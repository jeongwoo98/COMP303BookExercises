package Chapter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Represents a deck of playing cards. In this version, the cards in the
 * deck are stored in a list and the list of cards in the deck can
 * be obtained by client code using an immutable wrapper object.
 */
public class Deck implements ObservableDeck
{
    private Optional<Card> aLastCardDrawn = Optional.empty();
    private List<Card> aCards = new ArrayList<>();
    private List<DeckObserver> aObservers = new ArrayList<>();
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

        for(DeckObserver observer: aObservers){
            observer.shuffled(this);
        }
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
        for(DeckObserver observer: aObservers){
            observer.cardPushed(this);
        }
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
        Card card = aCards.remove(aCards.size() - 1);
        aLastCardDrawn = Optional.of(card);
        for(DeckObserver observer : aObservers)
        {
            observer.cardDrawn(this);
        }
        return card;
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
    public List<Card> getCards()
    {
        return Collections.unmodifiableList(aCards);
    }

    @Override
    public void addObserver(DeckObserver pObserver) {
        aObservers.add(pObserver);
    }

    @Override
    public void removeObserver(DeckObserver pObserver) {
        aObservers.remove(pObserver);
    }

    public int getSize(){
        return aCards.size();
    }
    public Card lastCardDrawn(){
        return aLastCardDrawn.get();
    }
}