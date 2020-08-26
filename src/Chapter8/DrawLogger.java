package Chapter8;

public class DrawLogger implements DeckObserver {

    @Override
    public void cardDrawn(Deck pDeck) {
        System.out.println("Card Drawn: " + pDeck.lastCardDrawn().toString());
    }

    @Override
    public void cardPushed(Deck pDeck) {} //Do nothing

    @Override
    public void shuffled(Deck pDeck) {} //Do nothing
}
