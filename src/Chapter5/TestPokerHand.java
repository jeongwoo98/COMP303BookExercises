package Chapter5;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
//REFLECTION TO TEST PRIVATE METHODS
public class TestPokerHand {
    private PokerHand aPokerHand;
    private Boolean isStraightFlush(PokerHand pPokerHand){
        try{
            Method method = PokerHand.class.getDeclaredMethod("isStraightFlush");
            method.setAccessible(true);
            return (Boolean) method.invoke(pPokerHand);
        }
        catch(ReflectiveOperationException e){
            e.printStackTrace();
            fail();
            return false;
        }
    }

    @Test
    public void testIsAStraightFlush(){
        PokerHand hand = new PokerHand(Card.get(Rank.TWO, Suit.CLUBS),
                Card.get(Rank.THREE, Suit.CLUBS),
                Card.get(Rank.FOUR, Suit.CLUBS),
                Card.get(Rank.FIVE, Suit.CLUBS),
                Card.get(Rank.SIX, Suit.CLUBS));
        assertTrue(isStraightFlush(hand));
    }
    //Because there are only nine possible straight flushes per suit, we can cover all possible straight
    // flushes with 36 test cases. However, this only covers executions that result in a true outcome,
    // so it does not mean we can achieve exhaustive coverage with just 36 executions, as there are many
    // more hand configurations that will result in a false outcome.
    @Test
    public void testIsStraightFlush_WrongSuit()
    {
        PokerHand hand = new PokerHand(Card.get(Rank.TWO, Suit.CLUBS),
                Card.get(Rank.THREE, Suit.CLUBS),
                Card.get(Rank.FOUR, Suit.CLUBS),
                Card.get(Rank.FIVE, Suit.CLUBS),
                Card.get(Rank.SIX, Suit.DIAMONDS));
        assertFalse(isStraightFlush(hand));
    }

    @Test
    public void testIsStraightFlush_WrongRank()
    {
        PokerHand hand = new PokerHand(Card.get(Rank.TWO, Suit.CLUBS),
                Card.get(Rank.THREE, Suit.CLUBS),
                Card.get(Rank.FOUR, Suit.CLUBS),
                Card.get(Rank.FIVE, Suit.CLUBS),
                Card.get(Rank.SEVEN, Suit.CLUBS));
        assertFalse(isStraightFlush(hand));
    }




}
