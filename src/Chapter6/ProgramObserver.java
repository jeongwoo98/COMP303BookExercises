package Chapter6;

public interface ProgramObserver {
    //push strategy:
    void showAdded(Show pShow, Day pDay);
    void showRemoved(Show pShow, Day pDay);
    void programCleared();
}
