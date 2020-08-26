package Chapter2exercise1;

public class Card
{
    private Rank aRank;
    private Suit aSuit;
    private Boolean aIsJoker=false;

    /**
     * Creates a new card object.
     *
     * @param pRank The rank of the card.
     * @param pSuit The suit of the card.
     * @pre pRank != null
     * @pre pSuit != null
     */
    public Card(Rank pRank, Suit pSuit)
    {
        assert pRank != null && pSuit != null;
        aRank = pRank;
        aSuit = pSuit;
    }
    public Card(){
        aIsJoker=true;
        aRank=null;
        aSuit=null; //not really desirable, but this will do for now.
    }

    /**
     * @return The rank of the card.
     */
    public Rank getRank()
    {
        if(aIsJoker){
            System.out.println("The Joker card does not have a Rank or Suit");
            return aRank;
        }
        else return aRank;
    }

    /**
     * @return The suit of the card.
     */
    public Suit getSuit()
    {
        if(aIsJoker){
            System.out.println("The Joker card does not have a Rank or Suit");
            return aSuit;
        }
        else return aSuit;
    }
    //COPY CONSTRUCTOR
    public Card(Card pCard){
        aRank = pCard.aRank;
        aSuit = pCard.aSuit;
    }
}

//exercise 4: Modify class Card to support the concept of a "Joker"
//(a special card that is not in any suit) while keeping the class
// as encapsulated as possible.