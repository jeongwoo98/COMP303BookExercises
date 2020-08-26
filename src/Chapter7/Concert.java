package Chapter7;

/**
 * Represents a concert.
 */
public class Concert extends AbstractShow
{
    //private String aTitle;
    private String aPerformer;
    //private int aTime;

    //  Change the code of Concert so that the field aPerformer is private.
    //  What are possible solutions for accessing this information?

    public Concert(String pTitle, String pPerformer, int pTime)
    {
        super(pTitle,pTime);
        aPerformer = pPerformer;
    }


    @Override
    public String extra() {
        return "by "+aPerformer;
    }
}
