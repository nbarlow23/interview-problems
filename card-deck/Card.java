package deck;

public class Card {

    static final int MAX_CARD_VAL = 13;
    private static final String ACE_NUM = "1";
    private static final String JACK_NUM = "11";
    private static final String QUEEN_NUM = "12";
    private static final String KING_NUM = "13";
    private static final String ACE = "Ace";
    private static final String JACK = "Jack";
    private static final String QUEEN = "Queen";
    private static final String KING = "King";

    enum Suit {
        SPADES, CLOVES, HEARTS, DIAMONDS
    }

    private Suit suit;
    private int value;

    Card(int v, Suit s) {
        setValue(v);
        setSuit(s);
    }

    @Override
    public String toString() {
        String val = Integer.toString(value);

        switch (val) {
            case ACE_NUM:
                val = ACE; break;
            case JACK_NUM:
                val = JACK; break;
            case QUEEN_NUM:
                val = QUEEN; break;
            case KING_NUM:
                val = KING; break;
            default:
                break;
        }

        return val + " of " + suit.toString();
    }

    private void setSuit(Suit suit) {
        this.suit = suit;
    }

    private void setValue(int value) {
        if (value <= 0 || value > MAX_CARD_VAL) {
            return;
        }
        this.value = value;
    }
}
