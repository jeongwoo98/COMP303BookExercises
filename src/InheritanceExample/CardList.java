package InheritanceExample;

import java.util.AbstractList;
import java.util.List;

public class CardList extends AbstractList<Card>  implements List<Card>{
    private final Card[] aCards;

    public CardList(Card[] pCards){
        assert pCards!= null;
        aCards=pCards;
    }

    @Override
    public Card get(int index) {
        return aCards[index];
    }

    @Override
    public int size() {
        return aCards.length;
    }
}
