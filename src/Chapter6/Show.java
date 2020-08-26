package Chapter6;
public interface Show extends Iterable<Show>
{
    /**
     * @return A description of the show.
     */
    String description();


    /**
     * @return The running time of the show, in minutes.
     */
    int runningTime();

    Show copy();    //exercise 11

}
/*  Exercise 8: extends Iterable<Show>
    The advantage of this solution is that client code can be more polymorphic:

        Show show = ...;
        for( Show subshow : show )
        { / ... / } // Not executed if an empty iterator is returned. For movies, concert.
*/