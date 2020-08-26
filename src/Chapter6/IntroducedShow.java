package Chapter6;

import java.util.Iterator;
import java.util.Objects;

public class IntroducedShow implements Show{
    private final String aSpeaker;
    private final int aSpeechTime;
    private final Show aShow;

    public IntroducedShow(String pSpeaker, int pSpeechTime, Show pShow){
        aSpeaker=pSpeaker;
        aSpeechTime=pSpeechTime;
        aShow=pShow;
    }
    //What becomes problematic here when we try to make a copy constructor?
    public IntroducedShow(IntroducedShow pIntroducedShow){
        aSpeaker = pIntroducedShow.aSpeaker;
        aSpeechTime = pIntroducedShow.aSpeechTime;
        // The problem for IntroducedShow is that it aggregates an instance of the interface
        // type Show. As a consequence of the polymorphism, the actual type of the
        // Show object aggregated may only be known at run-time, so it is not possible to
        // use a copy constructor in the source code without introducing a battery of inelegant
        // and unsafe checks.
        aShow = pIntroducedShow.aShow.copy();
        //aShow=pIntroducedShow.aShow; //THIS IS NOT A DEEP COPY. THIS IS A SHALLOW COPY
    }

    public String description(){
        return "["+aSpeaker+" introduces "+aShow.description()+"]";
    }

    public int runningTime(){
        return aSpeechTime + aShow.runningTime();
    }

    public Show copy(){
        return new IntroducedShow(aSpeaker,aSpeechTime,aShow.copy());
    }

    @Override
    public Iterator<Show> iterator() {
        return aShow.iterator();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null) return false;
        if(getClass()!=obj.getClass()) return false;
        IntroducedShow other = (IntroducedShow) obj;
        return aSpeaker.equals(other.aSpeaker)
                && aSpeechTime == other.aSpeechTime
                && aShow.equals(other.aShow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aShow,aSpeaker,aSpeechTime);
    }
}
