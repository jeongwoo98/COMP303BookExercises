package InheritanceExample;

import Chapter3.Rank;
import Chapter3.Suit;

public class Card
{
    private Chapter3.Rank aRank;
    private Chapter3.Suit aSuit;

    /**
     * Creates a new card object.
     *
     * @param pRank The rank of the card.
     * @param pSuit The suit of the card.
     * @pre pRank != null
     * @pre pSuit != null
     */
    public Card(Chapter3.Rank pRank, Chapter3.Suit pSuit)
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
}