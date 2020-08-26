package Chapter6;
import java.util.*;

/**
 * Class responsible for managing a program that consists
 * of various shows presented on different days of one week.
 * Each day of the week must be associated with exactly one
 * Show object. If there is not show on a given day, a special
 * object of type show is used to represent a "non-show".
 */
public class Program
{
    private List<ProgramObserver> aObservers = new ArrayList<>();   //For applying observer pattern in chapter 8 exercises!
    private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);
    private static final Show NULL = createNullShow();  //field indicating if the show is a null show

    //constructor
    public Program() {
        this.clear();
    }

    //Chapter 8 extensions! Disregard for chapter 6 material!
    public void addObserver(ProgramObserver pObserver){
        aObservers.add(pObserver);
    }
    public void removeObserver(ProgramObserver pObserver){
        aObservers.remove(pObserver);
    }

    /**
     * Function Objects!
     */
    private static Show createNullShow(){
        return new Show(){
            @Override public String description() {return "";}
            @Override public int runningTime() { return 0; }
            @Override public Show copy() { return createNullShow(); }
            @Override public int hashCode() { return 0; }
            @Override public boolean equals(Object pObject) {
                return pObject != null && pObject.getClass() == this.getClass();
            }
            @Override public Iterator<Show> iterator() { return Collections.emptyIterator(); }
        };
    }
    // clients should also be able to determine if a given show is a Null show.
    public boolean isNull(Show pShow){
        return NULL.equals(pShow);
    }

    /**
     * Clear the program by removing all existing shows.
     */
    public void clear()
    {
        for(Day day: Day.values()){
            aShows.put(day, NULL);
        }
        for(ProgramObserver observer: aObservers){
            observer.programCleared();
        }
    }

    /**
     * Adds a new show to the program. Overrides any existing show
     * on that day.
     * @param pShow The show to add.
     * @param pDay The day when the show takes place.
     */
    public void add(Show pShow, Day pDay)
    {
        assert pShow != null && pDay != null;
        aShows.put(pDay,pShow);
        for(ProgramObserver observer: aObservers){
            observer.showAdded(pShow, pDay);
        }
    }


    /**
     * Removes a show from the program.
     * @param pDay The day when we want to zap the show.
     */
    public void remove(Day pDay)
    {
        assert pDay != null;
        Show showRemoved = aShows.remove(pDay);
        for(ProgramObserver observer: aObservers){
            observer.showRemoved(showRemoved, pDay);
        }
    }

    /**
     * @param pDay The day of the requested show.
     * @return A copy of the show on a given day.
     */
    public Show get(Day pDay)
    {
        assert pDay != null;
        return aShows.get(pDay);
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        for( Day day : aShows.keySet() )
        {
            if( aShows.containsKey(day))
            {
                result.append(String.format("%9s", day.name()))
                        .append(": ").append(aShows.get(day).description()).append("\n");
            }
        }
        return result.toString();
    }

    //Implement commands using anonymous classes (which will require you to write factory methods for them).
    public Command createClearCommand(){
        return new Command(){
            EnumMap<Day,Show> copyMap =new EnumMap<>(Day.class);
            @Override
            public void execute(){
                copyMap = aShows.clone();
                clear();
            }
            @Override
            public void undo() {
                for(Day day: Day.values()){
                    if(copyMap.get(day)!=NULL){
                        aShows.put(day, copyMap.get(day));
                    }
                }
            }
        };
    }

    public Command createAddCommand(Show pShow, Day pDay){
        return new Command(){
            @Override
            public void execute() {
                add(pShow,pDay);
            }

            @Override
            public void undo() {
                remove(pDay);
            }
        };
    }

    public Command createRemoveCommand(Day pDay){
        return new Command() {
            Show show = aShows.get(pDay);
            @Override
            public void execute() {
                show = aShows.get(pDay);
                remove(pDay);
            }

            @Override
            public void undo() {
                add(show,pDay);
            }
        };
    }

}