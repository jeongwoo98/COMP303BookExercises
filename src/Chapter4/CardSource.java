package Chapter4;

/**
 * Represents an entity from which it is possible to obtain cards.
 */
public interface CardSource
{
    /**
     * Returns a card from the source.
     *
     * @return The next available card.
     * @pre !isEmpty()
     */
    Card draw();

    /**
     * @return True if there is no card in the source.
     */
    boolean isEmpty();
}