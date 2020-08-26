package Chapter7;

public class SponsoredConcert extends Concert{
    private String aSponsorName;            //new fields for the sponsor information
    private int aSponsorTime;

    public SponsoredConcert(String pTitle, String pPerformer, int pTime, String pSponsorName, int pSponsorTime){
        super(pTitle,pPerformer,pTime);     //subclass constructor
        aSponsorName=pSponsorName;
        aSponsorTime=pSponsorTime;
    }

    @Override
    public int time() {
        return super.time()+aSponsorTime;
    }

    @Override
    public String extra() {
        return super.extra() + "sponsored by "+aSponsorName;
    }
}
