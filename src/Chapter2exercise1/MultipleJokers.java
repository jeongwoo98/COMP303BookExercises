package Chapter2exercise1;

public class MultipleJokers {
    private Rank aRank;
    private Suit aSuit;
    private Boolean aIsJoker;
    public enum JOKER{
        LowJoker, HighJoker, NotJoker;
    }
    public JOKER typeOfJoker;

    //Constructor for normal cards
    public MultipleJokers(Rank pRank, Suit pSuit)
    {
        assert pRank != null && pSuit != null;
        aRank = pRank;
        aSuit = pSuit;
        aIsJoker = false;
        typeOfJoker= JOKER.NotJoker;
    }
    //Constructor for Joker cards
    public MultipleJokers(JOKER jokertype){
        aIsJoker = true;
        typeOfJoker = jokertype;
        aRank=null;
        aSuit=null;
    }

   public Rank getRank(){
        return aRank;
   }
   public JOKER getTypeOfJoker(){
        return typeOfJoker;
   }
   public Suit getSuit(){
        return aSuit;
    }

}
//Sketch: An enumerated type seems like the right idea here to capture the type of joker.
// However, it is not a good idea to consider null to be a legal value for an enumerated type,
// so I would recommend including an enum value to represent the case where the card is not a joker.
// The issues of what to do with rank and suit of jokers is the same as for Exercise 4.
