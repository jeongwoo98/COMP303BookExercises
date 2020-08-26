package Chapter3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class Hand implements Iterable<Card>, Comparable<Hand> {
    private final List<Card> aCards = new ArrayList<>();
    private final int aMaxCards;

    public Hand(int pMaxCards){
        aMaxCards = pMaxCards;
    }

    public void add(Card pCard){
        aCards.add(pCard);
    }
    public void remove(Card pCard){
        aCards.remove(pCard);
    }
    public Boolean contains(Card pCard){
        return aCards.contains(pCard);
    }
    public Boolean isEmpty(){
        return aCards.isEmpty();
    }
    public int size(){
        return aCards.size();
    }
    public Boolean isFull(){
        return (aCards.size()==aMaxCards);
    }

    //Find a way to provide access to the cards in the hand, respecting encapsulation
    //@override
    public Iterator<Card> iterator(){
        return aCards.iterator();
    }

    //Make it possible to compare two Hand objects using the Comparable interface.
    //Compare hands by increasing number of cards in the hand.
    //Write a small program to test your class. You do not need to handle the
    //case where the argument is null.
    public int compareTo(Hand pHand){
        return aCards.size()-pHand.aCards.size();
    }

    /*Extend the code of Hand to make it possible to compare two Hand objects using the
    Comparator interface. Implement two different hand comparison strategies, by increasing
    or decreasing number of cards in the hand. Define static factory methods in the Hand
    class to return anonymous instances of comparators for the different comparison strategies.
    You do not need to handle the case where the argument is null.
     */
    public static Comparator<Hand> createDescendingComparator(){    //implements not needed, factory method
        return new Comparator<Hand>(){                              //anonymous instance of comparator
            public int compare(Hand pHand1, Hand pHand2){
                return pHand2.aCards.size() - pHand1.aCards.size();
            }
        };
    }
    public static Comparator<Hand> createAscendingComparator(){
        return new Comparator<Hand>(){
            public int compare(Hand pHand1, Hand pHand2){
                return pHand1.aCards.size()-pHand2.aCards.size();
            }
        };
    }

    public static Comparator<Hand> createByRankComparator(Rank pRank){
        return new Comparator<Hand>(){
            public int compare(Hand pHand1, Hand pHand2){
                return countCards(pHand1, pRank) - countCards(pHand2, pRank);
            }
            private int countCards(Hand pHand, Rank pRank){
                int total =0;
                for(Card card: pHand){
                    if(card.getRank() == pRank) total++;
                }
                return total;
            }
        };
    }

    @Override
    public String toString() {
        return "Hand{" +
                "aCards=" + aCards +
                ", aMaxCards=" + aMaxCards +
                '}';
    }

    public static void main(String[]args){
        Hand hand1 = new Hand(5);
        Hand hand2 = new Hand(5);
        Deck deck = new Deck();
        deck.shuffle();
        hand1.add(deck.draw());
        hand2.add(deck.draw());
        hand2.add(deck.draw());
        hand1.add(new Card(Rank.ACE,Suit.CLUBS));
        hand1.add(new Card(Rank.ACE,Suit.CLUBS));
        List<Hand> handCollection = new ArrayList<>();
        handCollection.add(hand1);
        handCollection.add(hand2);
        //Hand1 should have more ace's than Hand2. Hence, comparing Hand1 to Hand2 should give -1
        System.out.println((Hand.createByRankComparator(Rank.ACE).compare(hand1, hand2)));
        Collections.sort(handCollection, createAscendingComparator());

    }
    //We shall skip over exercise 4 for the moment

}
