package Chapter6;
//Create a new class DoubleBill that represents a sequence of exactly two movies,
//but that is not a Decorator. Make sure your implementation respects the
//requirement expressed in Exercise 8.

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringJoiner;

public class DoubleBill implements Show{
    private final Movie aMovie1;
    private final Movie aMovie2;

    public DoubleBill(Movie pMovie1, Movie pMovie2){
        aMovie1=pMovie1;
        aMovie2=pMovie2;
    }

    public DoubleBill(DoubleBill pDoubleBill){
        aMovie1 = new Movie(pDoubleBill.aMovie1);
        aMovie2 = new Movie(pDoubleBill.aMovie2);
    }

    public String description(){
        StringJoiner description = new StringJoiner(";","[","]");
        description.add(aMovie1.description());
        description.add(aMovie2.description());
        return description.toString();
    }

    public int runningTime(){
        return (aMovie1.runningTime()+aMovie2.runningTime());
    }

    public Show copy(){
        return new DoubleBill(new Movie(aMovie1),new Movie(aMovie2));
    }

    @Override
    public Iterator<Show> iterator() {
        List<Show> aList = new ArrayList<>();
        aList.add(aMovie1);
        aList.add(aMovie2);
        return aList.iterator();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null || getClass()!=obj.getClass()) return false;
        DoubleBill other = (DoubleBill) obj;
        return aMovie1.equals(other.aMovie1)
                && aMovie2.equals(other.aMovie2);
    }
}
