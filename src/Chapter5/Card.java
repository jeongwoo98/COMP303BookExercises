package Chapter5;


public class Card {
    private Rank aRank;
    private Suit aSuit;


    public static Card get(Rank pRank, Suit pSuit){
        return new Card(pRank,pSuit);
    }
    /**
     * Creates a new card object.
     *
     * @param pRank The rank of the card.
     * @param pSuit The suit of the card.
     * @pre pRank != null
     * @pre pSuit != null
     */



    public Card(Rank pRank, Suit pSuit) {
        assert pRank != null && pSuit != null;
        aRank = pRank;
        aSuit = pSuit;
    }

    /**
     * @return The rank of the card.
     */
    public Rank getRank() {
        return aRank;
    }

    /**
     * @return The suit of the card.
     */
    public Suit getSuit() {
        return aSuit;
    }
}