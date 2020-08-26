package Chapter2exercise1;
public final class Client {
    private Client() {
    }

    /**
     * @param pArgs Not used here
     */
    public static void main(String[] pArgs) {

        Card2 myCard = new Card2(Rank.ACE, Suit.CLUBS);
        System.out.println(myCard);
        System.out.println(myCard.toString());
    }
}
