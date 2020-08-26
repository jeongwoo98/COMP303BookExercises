package Chapter6;

public class scheduleTracker implements ProgramObserver {
    @Override
    public void showAdded(Show pShow, Day pDay) {
        System.out.println(pShow.description()+" added to schedule on "+pDay.toString());
    }

    @Override
    public void showRemoved(Show pShow, Day pDay) {
        System.out.println(pShow.description()+" removed from schedule on "+pDay.toString());
    }

    @Override
    public void programCleared() {
        System.out.println("Schedule cleared");
    }
}
