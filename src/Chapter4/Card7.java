package Chapter4;
import java.util.HashMap;
import java.util.Map;
//flyweight implementation of Card class, but with maps.

public class Card7 {
    public static final Map<Integer,Card7> CARDS= new HashMap<Integer, Card7>();
    static {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                CARDS.put(suit.ordinal()+rank.ordinal(), new Card7(suit,rank));
            }
        }
    }
    private final Rank aRank;
    private final Suit aSuit;

    private Card7(Suit pSuit, Rank pRank){
        aSuit = pSuit;
        aRank = pRank;
    }

    public static Card7 getCard(Suit pSuit, Rank pRank){
        return CARDS.get(pSuit.ordinal()+pRank.ordinal());
    }



}
