package Chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulates code that uses various card sources.
 */
public class Client
{
    /**
     * A utility method to draw up to pNumber cards from the source.
     * Mostly a demonstration of how to access an object through
     * an interface.
     *
     * @return A list of the cards drawn from the source.
     */
    /*public static List<Card> drawCards(CardSource pSource, int pNumber)
    {
        List<Card> result = new ArrayList<>();

        for( int i = 0; i < pNumber && !pSource.isEmpty(); i++ )
        {
            result.add(pSource.draw());
        }

        return result;
    }*/
    private Client(){}
    public static void main(String[] args){
        Card5 card1 = new Card5(Rank.FIVE, Suit.HEARTS);
        Card5 card2 = new Card5(Rank.FIVE,Suit.HEARTS);
        System.out.println(card1 ==card2);  //testing reference addresses
        System.out.println(card1.equals(card2));    //testing logical equality that was overwritten
        System.out.println(card1.hashCode());
        System.out.println(card2.hashCode());


        /*Card6 card1 = Card6.getCard(Suit.CLUBS,Rank.ACE);
        Card6 card2 = Card6.getCard(Suit.CLUBS,Rank.ACE);
        System.out.println(card1 == card2); //UNIQUE INSTANCES FLYWEIGHT

        Card7 card3 = Card7.getCard(Suit.HEARTS,Rank.QUEEN);
        Card7 card4 = Card7.getCard(Suit.HEARTS,Rank.QUEEN);
        System.out.println(card3 == card4); //UNIQUE INSTANCES FLYWEIGHT*/




    }
}