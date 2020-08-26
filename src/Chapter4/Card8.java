package Chapter4;
//Flyweight implementation of Card, but instead of pre-instantiating we instantiate by demand
public class Card8 {
    private static final Card8[][] CARDS = new Card8
            [Suit.values().length][Rank.values().length];
    private Suit aSuit;
    private Rank aRank;
    public static Card8 get(Suit pSuit, Rank pRank) {
        Card8 cardInstance = CARDS[pSuit.ordinal()][pRank.ordinal()];
        if(cardInstance==null){
            cardInstance= new Card8(pSuit,pRank);
            CARDS[pSuit.ordinal()][pRank.ordinal()]=cardInstance;
        }
        return cardInstance;
    }
    private Card8(Suit pSuit, Rank pRank){  //private constructor
        aSuit=pSuit;
        aRank=pRank;
    }
    public Rank getRank(){
        return aRank;
    }
    public Suit getSuit(){
        return aSuit;
    }
    @Override
    public String toString()
    {
        return String.format("%s of %s", aRank, aSuit);
    }
}
