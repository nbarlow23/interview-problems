package deck;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.print(deck);
        deck.shuffle();
        System.out.print(deck);
    }

}
