package Chapter2exercise1;

/**
 * Represents the suit of a playing card.
 */
public enum Suit
{
    CLUBS, DIAMONDS, SPADES, HEARTS;

    public enum Color{
        RED, BLACK;
    }

    public Color color(){
        if(this ==CLUBS||this ==SPADES) return Color.BLACK;
        else return Color.RED;
    }
}

//Exercise 2.3: Modify the Suit enumerated type to include a method color()
//that returns the color of the suit. The return type should be a new enumerated type Color.
//Important thing to notice here is that we haven't created a new class for the color
//The color is an attribute of the suits. The COLORS depend on the SUITS.