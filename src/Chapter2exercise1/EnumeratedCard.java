package Chapter2exercise1;

public enum EnumeratedCard {
    ACE_CLUBS, TWO_CLUBS, THREE_CLUBS, FOUR_CLUBS, FIVE_CLUBS, SIX_CLUBS, SEVEN_CLUBS,
    EIGHT_CLUBS, NINE_CLUBS, TEN_CLUBS, JACK_CLUBS, QUEEN_CLUBS, KING_CLUBS,
    ACE_DIAMONDS, TWO_DIAMONDS, THREE_DIAMONDS, FOUR_DIAMONDS, FIVE_DIAMONDS, SIX_DIAMONDS, SEVEN_DIAMONDS,
    EIGHT_DIAMONDS, NINE_DIAMONDS, TEN_DIAMONDS, JACK_DIAMONDS, QUEEN_DIAMONDS, KING_DIAMONDS,
    ACE_SPADES, TWO_SPADES, THREE_SPADES, FOUR_SPADES, FIVE_SPADES, SIX_SPADES, SEVEN_SPADES,
    EIGHT_SPADES, NINE_SPADES, TEN_SPADES, JACK_SPADES, QUEEN_SPADES, KING_SPADES,
    ACE_HEARTS, TWO_HEARTS, THREE_HEARTS, FOUR_HEARTS, FIVE_HEARTS, SIX_HEARTS, SEVEN_HEARTS,
    EIGHT_HEARTS, NINE_HEARTS, TEN_HEARTS, JACK_HEARTS, QUEEN_HEARTS, KING_HEARTS;


    //CLUBS=0-12, DIAMONDS=13-25, SPADES=26-38, HEARTS=39-51
    //In original card implementation, have Ranks from 0-12, Suits from 0-3
    public Suit getSuit(){
        return Suit.values()[ordinal() / Rank.values().length]; //for now, Rank.values().length = 13
    }
    public Rank getRank(){
        return Rank.values()[ordinal() % Rank.values().length];
    }
    //static factory method (get)
    public static EnumeratedCard get(Rank pRank, Suit pSuit){
        return values()[13*pSuit.ordinal()+pRank.ordinal()];
    }
}
//FOR ENUMS, IMPORTANT STUFF IS:
//ORDINAL() --> RETURNS POSITION IN ENUMERATION
//VALUES()[0]--> RETURNS 0TH ENUMERATION
//VALUES().LENGTH --> RETURNS LENGTH OF THE FULL ENUMERATION

//With the two helper methods to get the suit and rank of the card, the answer is pretty close to the
//original one. To have to calculate the rank and suit from indices has lower understandability
//and robustness than simply storing the information directly. However, the fact that the Card is an
//immutable enumerated type gives us a number of benefits, such as the certainty that there will
// never be duplicate cards in a program. Although it is not possible to create a card dynamically by
// specifying a suit and a rank, this issue can be addressed easily using a static factory method (get).