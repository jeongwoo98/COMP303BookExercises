package Chapter7;

/**
 * Represents a show that consists of the screening of a single movie.
 */
public class Movie extends AbstractShow
{
    private int aYear;
    public Movie(String pTitle, int pYear, int pTime)
    {
        super(pTitle,pTime);
        aYear = pYear;
    }

    @Override
    public String extra() {
        return Integer.toString(aYear);
    }

    @Override
    public void setRecommended(Show pShow) {
        assert (pShow instanceof Movie);
        super.setRecommended(pShow);
    }

    @Override
    public Show getRecommended() {
        return super.getRecommended();
    }

    /* Violation of the Liskov Substitution Principle:
     * Adding an additional (checked) exception forces the clients of the
     * supertype to catch or propagate more exception types
     *
     * Violation of the Liskov Substitution Principle:
     * Adding a stricter precondition forces the clients of the supertype to do
     * additional input validation before providing an argument to the function
     */
    /*
    @Override
    public void setTitle(String pTitle) {
        throw new UnsupportedOperationException("This operation ain't supported");
    }

    @Override
    public void setTime(int pTime) {
        assert pTime>10;
        super.setTime(pTime);
    }*/


}
