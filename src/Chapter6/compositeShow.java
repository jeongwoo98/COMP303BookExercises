package Chapter6;
import java.util.*;

public class compositeShow implements Show, Iterable<Show>{
    private final List<Show> aShows = new ArrayList<>();

    //Constructor
    public compositeShow(Show... pShows){   //This is some notation to remember. Sed client code to see how this works
        if(pShows.length<2||pShows.length>5){
            throw new IllegalArgumentException("Arguments should be between two and five shows inclusively");
        }
        aShows.addAll(Arrays.asList(pShows));  //Collection of objects wrapped into an array
    }

    /**
     * @return A description of the show.
     */
    public String description(){
        StringJoiner description = new StringJoiner(";","[","]");
        for(Show show: aShows){
            description.add(show.description());
        }
        return description.toString();
    }

    /**
     * @return The running time of the show, in minutes.
     */
    public int runningTime(){
        int time=0;
        for(Show show: aShows){
            time += show.runningTime();
        }
        return time;
    }

    @Override
    public Show copy() {
        compositeShow copy = new compositeShow();
        for(Show show : aShows){
            copy.aShows.add(show.copy());   //essential to copy, want deep copying
        }
        return copy;
    }


    public Show copy2(){
        List<Show> copies = new ArrayList<>();
        for(Show show:aShows){
            copies.add(show.copy());
        }
        //return new compositeShow(copies.toArray(new Show[copies.size()]));
        Show[] copyArray = new Show[copies.size()]; //first convert list of shows to an array of shows
        copyArray = copies.toArray(copyArray);
        return new compositeShow(copyArray);
    }

    /**
     * For exercise 7:
     * Benefit: Avoid having this behaviour defined for Movie or Concert, in which this behaviour doesn't even make sense
     * Disadvantage: requires client code that works instances of Show to explicitly check whether an instance can be unpacked or not
     * ex.
     * Show show = ...;
     * if( show instanceof CompositeShow )
     * {
     *    for( Show subshow : show )
     *    { /* ... *}
     * }
     */
    @Override
    public Iterator<Show> iterator() {
        return aShows.iterator();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null) return false;
        if(getClass()!=obj.getClass()) return false;
        compositeShow other = (compositeShow) obj;
        return aShows.equals(other.aShows); //This works because we know the behaviour of List.equals
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(aShows);
    }
}
