package Chapter3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class UniversalComparator implements Comparator<Hand>{
    public enum Order {ASCENDING, DESCENDING};
    private Order aOrder = Order.ASCENDING;     //can change this anytime!

    public UniversalComparator(){};             //just creates an ascending comparator
    public UniversalComparator(Order pOrder){   //specify the type of comparator
        aOrder=pOrder;
    }

    public int compare(Hand pHand1, Hand pHand2) {
        if (aOrder == Order.ASCENDING) {
            return pHand1.size() - pHand2.size();
        } else return pHand2.size() - pHand1.size();   //doesn't use any private variables
    }                                                  //of class Hand.

    public void setOrder(Order pOrder){         //Change ordering type after initializing
        aOrder=pOrder;
    }

//exercises 6,7 omitted.
    //Do exercise 9 only if you have time
}
