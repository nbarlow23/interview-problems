package deck;

import deck.Card.Suit;
import java.util.Random;

import static deck.Card.MAX_CARD_VAL;

public class Deck {
    private Card[] cards;
    private static final int DECK_SIZE = 52;

    Deck() {
        Suit[] suits = {Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES, Suit.CLOVES};
        cards = new Card[DECK_SIZE];

        for (int i = 0; i < DECK_SIZE; i++) {
            int value = i % MAX_CARD_VAL + 1;
            Suit suit = suits[i / MAX_CARD_VAL];
            cards[i] = new Card(value, suit);
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < DECK_SIZE; i++) {
            builder.append(cards[i]);
            builder.append('\n');
        }

        return builder.toString();
    }

    protected void sort() {

    }

    protected void shuffle() {
        for (int i = 0; i < DECK_SIZE; i++) {
            int rand = Math.abs(new Random().nextInt()) % DECK_SIZE;
            Card temp = cards[i];
            cards[i] = cards[rand];
            cards[rand] = temp;
        }
    }
}
