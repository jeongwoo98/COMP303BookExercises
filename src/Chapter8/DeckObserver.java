package Chapter8;

public interface DeckObserver {
    void cardDrawn(Deck pDeck);
    void cardPushed(Deck pDeck);
    void shuffled(Deck pDeck);
}
