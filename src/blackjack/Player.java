/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.List;

public class Player {

    private final String name;
    private List<Card> bet;

    public Player(String name, List<Card> bet) {
        this.name = name;
        this.bet = bet;
    }

    public List<Card> getBet() {
        return bet;
    }

    public void addCardBet(Card card) {
        bet.add(card);
    }

}
