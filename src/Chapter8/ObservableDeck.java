package Chapter8;

public interface ObservableDeck {
    void addObserver(DeckObserver pObserver);
    void removeObserver(DeckObserver pObserver);
}
