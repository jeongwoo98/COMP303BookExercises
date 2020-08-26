package Chapter2exercise1;

public class Card2
{
    //Goal: represent a card as 6 Boolean values.
    //We know we can represent 2^6 = 64 cards, so 52 should be possible!
    //Simply an integer to binary conversion problem
    //Say that the high suit is the Heart and Spade suits, for red and black respectively
    private boolean aIsRed = false;
    private boolean aIsHighSuit = false;
    private boolean aRank1 = false;
    private boolean aRank2 = false;
    private boolean aRank3 = false;
    private boolean aRank4 = false;

    //With first two bits, we can determine the suit of the card
    //Each suit has twelve ranks, determine rank with 4 bits for sure.

    public Card2(Rank pRank, Suit pSuit)            //Our Constructor function
    {
        assert pRank != null && pSuit != null;      //Ignore this for now
        fromSuit(pSuit);
        fromRank(pRank);
    }

    private void fromSuit(Suit pSuit) {
        if (pSuit == Suit.HEARTS || pSuit == Suit.DIAMONDS) {
            aIsRed = true;
        }
        if (pSuit == Suit.HEARTS || pSuit == Suit.SPADES) {
            aIsHighSuit = true;
        }
    }

    private void fromRank(Rank pRank){
        int value = pRank.ordinal();
        aRank1 = (value%2 == 1);
        value /= 2;
        aRank2 = (value%2 == 1);
        value /= 2;
        aRank3 = (value%2 == 1);
        value /= 2;
        aRank4 = (value%2 == 1);
        value /= 2;
    }

    public Rank getRank()             //getter method for Rank
    {
        int value = 0;
        if(aRank4) value+=8;
        if(aRank3) value+=4;
        if(aRank2) value+=2;
        if(aRank1) value+=1;
        return Rank.values()[value];       //Returning an enumeration syntax
    }

    public Suit getSuit(){
        if(aIsRed){
            if(aIsHighSuit) return Suit.HEARTS;
            else return Suit.DIAMONDS;
        }else{
            if(aIsHighSuit) return Suit.SPADES;
            else return Suit.CLUBS;
        }
    }

    @Override
    public String toString()
    {
        return String.format("%s of %s", getRank(), getSuit());
    }

}
//The impact of this design on the maintainers of class Card is unnecessary complexity.
//Assuming they don't need to look at the source code, there is no impact on the users of the class,
//because the new implementation respects the original interface.