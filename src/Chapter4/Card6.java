package Chapter4;
//flyweight implementation of card: all about ensuring uniqueness of the object instances.

public class Card6 {
    //data structure to hold the flyweight instances
    private static final Card6[][] CARDS= new Card6
            [Suit.values().length][Rank.values().length];   //DATA STRUCTURE
    static{
        for(Suit suit: Suit.values()){
            for(Rank rank: Rank.values()){
                CARDS[suit.ordinal()][rank.ordinal()]= new Card6(suit,rank);   //INITIALIZE CACHE
            }
        }
    }

    private Card6(Suit pSuit,Rank pRank){   //PRIVATE CONSTRUCTOR
        aSuit = pSuit;
        aRank = pRank;
    }
    //get the UNIQUE instance of Card6 with associated rank and suit.
    public static Card6 getCard(Suit pSuit, Rank pRank){
        return CARDS[pRank.ordinal()][pSuit.ordinal()];
    }
    private final Suit aSuit;
    private final Rank aRank;


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
