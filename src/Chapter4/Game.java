package Chapter4;
import java.util.Comparator;


public class Game
{
    private Comparator<Card> NULL_COMPARATOR = new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            return 0;   //ALL EQUAL: CORRELATES TO HAVING A NULL FOR A COMPARATOR
        }
    };
    private Comparator<Card> aComparator = NULL_COMPARATOR;
}

//When class Game is initialized, the comparison order is not determined.
//However, we do not wish to assign null to aComparator to help prevent bugs.
//Design a solution that does not change the type of the field. This means we can't use Optional<T>
//SOLUTION: NULL OBJECT DESIGN PATTERN