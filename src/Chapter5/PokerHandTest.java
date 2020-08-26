package Chapter5;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

//REFLECTION TO UNIT TEST PRIVATE METHODS
class PokerHandTest {
    private PokerHand aPokerHand;
    private static final Card card1 = new Card(Rank.EIGHT,Suit.HEARTS);
    private static final Card card2 = new Card(Rank.ACE, Suit.CLUBS);

    @Before
    private boolean isStraightFlush(){
        try{
            Method method = PokerHand.class.getDeclaredMethod("isStraightFlush");
            method.setAccessible(true);
            return (boolean) method.invoke(aPokerHand);
        }catch(ReflectiveOperationException e){
            fail();
            return false;
        }
    }

    @Test
    public void testIsAFlush(){
        Card card1 = new Card(Rank.ACE,Suit.HEARTS);
        Card card2 = new Card(Rank.TWO,Suit.HEARTS);
        Card card3 = new Card(Rank.THREE,Suit.HEARTS);
        Card card4 = new Card(Rank.FOUR, Suit.HEARTS);
        Card card5 = new Card(Rank.FIVE, Suit.HEARTS);
        aPokerHand = new PokerHand(card1,card2,card3,card4,card5);
        assertTrue(this::isStraightFlush);


    }




}