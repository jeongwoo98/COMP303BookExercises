package Chapter8;


public class Client {
    public static void main(String[] pArgs) {
        Deck d1= new Deck();
        SizeStatus sizeChecker =new SizeStatus();
        DrawLogger drawChecker =new DrawLogger();

        d1.addObserver(sizeChecker);
        d1.addObserver(drawChecker);
        d1.shuffle();

        Card testCard= new Card(Rank.ACE, Suit.CLUBS);
        for(int i=0;i<7;i++) d1.draw();
        d1.push(testCard);
    }


}
