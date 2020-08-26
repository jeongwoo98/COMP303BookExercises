package Chapter4;
import java.util.Comparator;

/**
 * Implementation of a playing card. This class yields immutable objects.
 * This version of the class also implements the Comparable interface and
 * compares cards by rank, with an undefined order for cards of the same rank.
 * The class also includes a static factory method to create Comparator
 * objects that can compare cards according to their rank.
 */
public class Card5 implements Comparable<Card5>
{
    private Rank aRank;
    private Suit aSuit;

    /**
     * Creates a new card object.
     *
     * @param pRank The rank of the card.
     * @param pSuit The suit of the card.
     * @pre pRank != null
     * @pre pSuit != null
     */
    public Card5(Rank pRank, Suit pSuit)
    {
        assert pRank != null && pSuit != null;
        aRank = pRank;
        aSuit = pSuit;
    }

    /**
     * @return The rank of the card.
     */
    public Rank getRank()
    {
        return aRank;
    }

    /**
     * @return The suit of the card.
     */
    public Suit getSuit()
    {
        return aSuit;
    }

    @Override
    public int compareTo(Card5 pCard)
    {
        return aRank.compareTo(pCard.aRank);
    }

    @Override
    public boolean equals(Object obj){      //OVERWRITING .EQUALS()
        if(this==obj) return true;
        if(this.getClass() != obj.getClass()||obj==null) return false;
        Card5 other = (Card5) obj;
        return (aRank.equals(other.aRank)&&aSuit.equals(other.aSuit));
    }

    @Override
    public int hashCode() {     //OVERWRITING HASHCODE FUNCTION
        return aSuit.ordinal()*Rank.values().length + aRank.ordinal();
    }

    /**
     * Sample static factory method to create a comparator capable
     * of comparing cards by rank.
     *
     * @return The created comparator.
     */
    public static Comparator<Card5> createByRankComparator()
    {
        return new Comparator<Card5>()
        {
            public int compare(Card5 pCard1, Card5 pCard2)
            {
                return pCard1.aRank.compareTo(pCard2.aRank);
            }
        };
    }
}