package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class BlackJack {

    private List<Card> deck;

    public BlackJack(List<Card> deck) {
        this.deck = deck;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public List<Player> getWinner(Player player1, Player player2, Player player3, Player crupier) {
        List<Player> list = new ArrayList<>();

        while (getSumOfBet(crupier.getBet()) < 17 && this.deck.size() > 0) {
            crupier.addCardBet(this.deck.get(0));
            this.deck.remove(0);
        }

        if (!isBlackJack(crupier.getBet())) {
            if (isWinner(player1, crupier)) {
                list.add(player1);
            }
            if (isWinner(player2, crupier)) {
                list.add(player2);
            }
            if (isWinner(player3, crupier)) {
                list.add(player3);
            }
        }
        return list;
    }

    public boolean isWinner(Player player, Player crupier) {
        boolean result = false;
        if (isBlackJack(crupier.getBet())) {
            result = false;
        } else {
            if (isBlackJack(player.getBet())) {
                result = true;
            } else {
                int sumOfPlayer = getSumOfBet(player.getBet());
                int sumOfCrupier = getSumOfBet(crupier.getBet());
                if (sumOfCrupier > 21 && sumOfPlayer > 21) {
                    result = false;
                } else if (sumOfCrupier <= 21 && sumOfPlayer > 21) {
                    result = false;
                } else if (sumOfCrupier > 21 && sumOfPlayer <= 21) {
                    result = true;
                } //Se pone < porque solomente el jugador tiene cartas mas cerca al 21(no igual con Crupier)
                else //if(sumOfCrupier <= 21 && sumOfPlayer <= 21){
                {
                    result = sumOfPlayer > sumOfCrupier;
                }

            }
        }
        return result;
    }

    public boolean isBlackJack(List<Card> bet) {
        return getSumOfBet(bet) == 21 && bet.size() == 2;
    }

    public int getSumOfBet(List<Card> bet) {
        int sumOfBet = 0;
        int numberAce = 0;

        for (Card card : bet) {
            sumOfBet += card.getValue();
            if (card instanceof Ace) {
                numberAce++;
            }
        }

        while (sumOfBet > 21 && numberAce > 0) {
            Ace ace = new Ace();
            sumOfBet -= ace.getValue();
            sumOfBet += ace.getSecoundValue();
            numberAce--;
        }

        return sumOfBet;
    }
    
    
}
