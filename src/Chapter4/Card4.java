package Chapter4;

import java.util.Comparator;
import java.util.Optional;

/**
 * Implementation of a playing card. This class yields immutable objects.
 * This version of the class also implements the Comparable interface and
 * compares cards by rank, with an undefined order for cards of the same rank.
 * The class also includes a static factory method to create Comparator
 * objects that can compare cards according to their rank.
 */
public class Card4 implements Comparable<Card4>
{
    private Optional<Rank> aRank;
    private Optional<Suit> aSuit;
    private Optional<Joker> aJoker;
    private enum Joker
    {
      WHITE,BLACK
    }
    /**
     * Creates a new card object.
     *
     * @param pRank The rank of the card.
     * @param pSuit The suit of the card.
     * @pre pRank != null
     * @pre pSuit != null
     */
    public Card4(Rank pRank, Suit pSuit)
    {
        assert pRank != null && pSuit != null;
        aRank = Optional.of(pRank);
        aSuit = Optional.of(pSuit);
        aJoker = Optional.empty();          //Optional.empty() is a way of setting something to null, properly designed
    }

    public Card4(boolean pIsWhite){
        aRank= Optional.empty();
        aSuit= Optional.empty();
        if(pIsWhite) aJoker= Optional.of(Joker.WHITE);
        else aJoker= Optional.of(Joker.BLACK);
    }
    public boolean isJoker(){
        return aJoker.isPresent();
    }   //.isPresent() is a way of checking if it's null
    public boolean isWhiteJoker(){
        return (aJoker.isPresent()&&aJoker.get()==Joker.WHITE);
    }
    public boolean isBlackJoker(){
        return(aJoker.isPresent()&&aJoker.get()==Joker.BLACK);
    }
    //.get() will return the value, if there is any.
    /**
     * @return The rank of the card.
     */
    public Rank getRank()
    {
        return aRank.get();
    }

    /**
     * @return The suit of the card.
     */
    public Suit getSuit()
    {
        return aSuit.get();
    }

    @Override
    public int compareTo(Card4 pCard)
    {
        //return aRank.compareTo(pCard.aRank);
        if(this.isJoker()&&pCard.isJoker()){
            return aJoker.get().compareTo(pCard.aJoker.get());
        }else if(this.isJoker()&& !pCard.isJoker()){
            return 1;
        }else if(!isJoker()&&pCard.isJoker()){
            return -1;
        }else{
            return aRank.get().compareTo(pCard.aRank.get());
        }
    }
}