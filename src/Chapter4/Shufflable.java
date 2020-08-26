package Chapter4;
/**
 * An object that can be shuffled, but can also be absent
 */
public interface Shufflable
{
    public static final Shufflable NULL_SHUFFLABLE = new Shufflable()
    {
        @Override
        public void shuffle()
        { /* Do nothing */ }
    };

    /**
     * Randomly reorder the objects that are the components
     * of this object.
     */
    void shuffle();
}

//ANOTHER NULL OBJECT PATTERN TO STUDY