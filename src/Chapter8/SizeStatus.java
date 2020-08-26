package Chapter8;

public class SizeStatus implements DeckObserver {
    private int deckSize = -1;

    @Override
    public void cardDrawn(Deck pDeck) {
        if(pDeck.getSize()>=0){
            System.out.println("Deck size: "+pDeck.getSize());
        }else{
            System.out.println("Size unknown");
        }
    }

    @Override
    public void cardPushed(Deck pDeck) {
        if(pDeck.getSize()>=0){
            System.out.println("Deck size: "+pDeck.getSize());
        }else{
            System.out.println("Size unknown");
        }
    }

    @Override
    public void shuffled(Deck pDeck) {
        System.out.println("Deck size: "+ pDeck.getSize());
    }
}
