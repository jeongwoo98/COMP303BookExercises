package Chapter3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
public class SortedHand implements Iterable<Card>, Comparable<SortedHand> {
    private final List<Card> aCards = new ArrayList<>();
    private final int aMaxCards;
    private Comparator<Card> aComparator;   //idk what to do with this...

    public SortedHand(int pMaxCards){       //Same as original
        aMaxCards=pMaxCards;                //sorted version needs a different constructor
    }

    public SortedHand(int pMaxCards, Comparator<Card> pOrder){
        aMaxCards=pMaxCards;
        aComparator=pOrder;
    }
    public boolean isFull(){
        return (aCards.size()==aMaxCards);
    }
    public boolean isEmpty(){
        return aCards.size()==0;
    }
    public void remove(Card pCard){
        aCards.remove(pCard);
    }
    public void add(Card pCard){
        if(!isFull()) aCards.add(pCard);
        aCards.sort(aComparator);
    }
    public boolean contains(Card pCard){
        return aCards.contains(pCard);
    }
    public Iterator<Card> iterator(){
        return aCards.iterator();
    }
    public int compareTo(SortedHand pHand1){
        return aCards.size()-pHand1.aCards.size();
    }
    public int size(){
        return aCards.size();
    }





}
