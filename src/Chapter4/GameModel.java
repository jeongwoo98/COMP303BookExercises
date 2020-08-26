package Chapter4;

public class GameModel {
    private static final GameModel GAME_INSTANCE = new GameModel(); //a static final variable
    private final Deck aDeck = new Deck();// holding the reference to the instance
    private GameModel(){}   //private constructor
    public static GameModel getGameInstance(){
        return GAME_INSTANCE;
    }
    public void newGame(){                                          //initialize Deck by shuffling it again
       aDeck.shuffle();
    }
}


