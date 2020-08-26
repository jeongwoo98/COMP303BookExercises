package Chapter2exercise1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiDeck {
    //private List<Deck> aDecks= new ArrayList<>();
    private Deck[] aDecks;

    //constructor:
    public MultiDeck(int pNumberOfDecks){
        aDecks = new Deck[pNumberOfDecks];
        for(int i=0; i<aDecks.length;i++){
            aDecks[i]= new Deck();
        }
    }
    //copy constructor, SHALLOW
    /*public MultiDeck(MultiDeck pMultiDeck){
        aDecks = pMultiDeck.aDecks;
    }*/

    //copy constructor, DEEP
    public Deck[] getDecks(){
        Deck[] result = new Deck[aDecks.length];
        for(int i=0;i<result.length;i++){
            result[i]= new Deck(aDecks[i]);
        }
        return result;
    }

}
//Create a new class called MultiDeck that contains a list of decks
//(some card games require multiple decks). Make the class copyable through a copy constructor.
//First, make a shallow copy of the decks contained. Use the debugger to confirm that the decks
//in a multi-deck are shared between an original multi-deck and its copies. Then, use deep
//copying to make copied multi-decks fully distinct object graphs. Use design by contract and
//the assert statement to clarify the class's interface.

//Study question 8 and 9 later