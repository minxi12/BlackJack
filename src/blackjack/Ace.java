package blackjack;

public class Ace extends Card {

    @Override
    public int getValue() {
        return 11;
    }

    public int getSecoundValue() {
        return 1;
    }
}
