package Chapter3;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public final class Client {
    private Client() {
    }

    /**
     * @param pArgs Not used here
     */
    public static void main(String[] pArgs) {

        Hand smallHand = new Hand(3);
        Hand bigHand= new Hand(10);

        Card testCard= new Card(Rank.ACE, Suit.CLUBS);
        bigHand.add(testCard);

        List<Hand> handList = new ArrayList<Hand>();
        handList.add(smallHand);
        handList.add(bigHand);
        Collections.sort(handList);
        System.out.println(handList.toString());
    }
}