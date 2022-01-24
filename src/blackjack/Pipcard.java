package blackjack;

import java.util.List;

public class Pipcard extends Card {

    private final int value;

    public Pipcard(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
