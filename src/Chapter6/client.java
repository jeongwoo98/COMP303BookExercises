package Chapter6;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class client {
    private static final Concert CONCERT = new Concert("Concert 1", "Artist X", 100);
    private static final Movie MOVIE1 = new Movie("Movie 1", 2017, 120);
    private static final Movie MOVIE2 = new Movie("Movie 2", 2018, 130);

    public static void main(String[] args){
        compositeShow exercise1 = new compositeShow(
                CONCERT, new compositeShow(MOVIE1,MOVIE2)
        );
        System.out.println(exercise1.description());
        /*
       IntroducedShow exercise2 = new IntroducedShow("Moon", 10,
               new compositeShow(CONCERT,
                       new compositeShow(MOVIE1, new IntroducedShow("Songyi", 12, MOVIE2)))
               );
       System.out.println(exercise2.description());
       //exercise 3-5 are just diagrams. Exercise 6 skip for now

        Program exercise15 = new Program();
        Command command1 = exercise15.createClearCommand();
        Command command2 = exercise15.createAddCommand(MOVIE1,Day.MONDAY);
        Command command3 = exercise15.createAddCommand(MOVIE2,Day.FRIDAY);
        Command command4 = exercise15.createRemoveCommand(Day.FRIDAY);

        command2.execute();
        System.out.println(exercise15.toString());
        command3.execute();
        System.out.println(exercise15.toString());
        command2.undo();
        System.out.println(exercise15.toString());*/


        Program p1 = new Program();
        scheduleTracker tracker = new scheduleTracker();
        p1.addObserver(tracker);

        p1.add(CONCERT, Day.FRIDAY);
        p1.add(MOVIE1, Day.MONDAY);
        p1.remove(Day.MONDAY);
        p1.clear();

    }

}
