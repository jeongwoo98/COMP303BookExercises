package Chapter7;

public abstract class AbstractShow implements Show{
    private Show aRecommended;
    private String aTitle;
    private int aTime;

    AbstractShow(String pTitle, int pTime){
        aTitle=pTitle;
        aTime=pTime;
    }

    @Override
    public AbstractShow clone() {
        try{
            return (AbstractShow) super.clone();
        }catch(CloneNotSupportedException e){
            return null;
        }
    }
    // For subtypes of Show that require a deeper copy (e.g., aggregates like CompositeShow
    // from Exercise 6.1), it will be necessary to make a copy of the mutable structures in the clone() method.

    public void setRecommended(Show pShow){
        aRecommended=pShow;
    }

    public Show getRecommended(){
        return aRecommended;
    }

    public String title(){
        return aTitle;
    }

    public int time(){
        return aTime;
    }

    public void setTitle(String pTitle)
    {
        aTitle = pTitle;
    }

    public void setTime(int pTime)
    {
        assert pTime>0;
        aTime = pTime;
    }

    // This is overloading, independently of where we locate the method. Although
    // the name of the method is the same, its signature (name and parameter types)
    // is different.
    public void setTime(int hours, int minutes){
        aTime = hours*60 + minutes;
    }

    //Abstract method!
    public final String description(){
        return String.format("%s: %s (%d minutes)", title(), extra(), time());
    }

    //Template Design pattern
    public abstract String extra();


}
