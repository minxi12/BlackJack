package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import blackjack.*;
import java.util.ArrayList;
import java.util.List;

public class BlackJackTest {

    @Test
    public void isWinner_player1_and_crupier_return_player1() {
        BlackJack blackJack = new BlackJack(null);
        //Player 1
        List<Card> betPlayer1 = new ArrayList<>();

        betPlayer1.add(new Ace());
        betPlayer1.add(new FigureCard());

        Player player1 = new Player("player1", betPlayer1);

        //Crupier
        List<Card> betCrupier = new ArrayList<>();

        betCrupier.add(new Ace());
        betCrupier.add(new Pipcard(5));
        betCrupier.add(new Pipcard(2));

        Player crupier = new Player("crupier", betCrupier);

        boolean player = blackJack.isWinner(player1, crupier);
        assert (true == player);
    }

    @Test
    public void bet_with_3_10_and_Ace_adds_14() {
        List<Card> bet = new ArrayList<>();
        bet.add(new Ace());
        bet.add(new Pipcard(3));
        bet.add(new Pipcard(10));

        BlackJack blackJack = new BlackJack(null);
        int sumOfBet = blackJack.getSumOfBet(bet);
        assert (sumOfBet == 14);
    }

    @Test
    public void bet_with_FigureCard_and_Ace_is_BlakJack() {
        List<Card> bet = new ArrayList<>();

        bet.add(new FigureCard());
        bet.add(new Ace());

        BlackJack blackJack = new BlackJack(bet);

        assert (blackJack.isBlackJack(bet));
    }

    @Test
    public void return_player1_when_we_present_case_1() {
        //Player 1
        List<Card> betPlayer1 = new ArrayList<>();

        betPlayer1.add(new FigureCard());
        betPlayer1.add(new Ace());

        Player player1 = new Player("Player1", betPlayer1);

        //Player 2
        List<Card> betPlayer2 = new ArrayList<>();

        betPlayer2.add(new Pipcard(10));
        betPlayer2.add(new Pipcard(5));
        betPlayer2.add(new Pipcard(6));

        Player player2 = new Player("Player2", betPlayer2);

        //Player 3
        List<Card> betPlayer3 = new ArrayList<>();

        betPlayer3.add(new Pipcard(3));
        betPlayer3.add(new Pipcard(6));
        betPlayer3.add(new Ace());
        betPlayer3.add(new Pipcard(3));
        betPlayer3.add(new Ace());
        betPlayer3.add(new FigureCard());

        Player player3 = new Player("Player3", betPlayer3);

        //Crupier
        List<Card> betCrupier = new ArrayList<>();

        betCrupier.add(new Pipcard(9));
        betCrupier.add(new Pipcard(7));

        Player crupier = new Player("Crupier", betCrupier);

        List<Player> listBase = new ArrayList<>();
        listBase.add(player1);

        List<Card> deck = new ArrayList<>();
        deck.add(new Pipcard(5));
        deck.add(new Pipcard(4));
        deck.add(new FigureCard());
        deck.add(new Pipcard(2));

        BlackJack blackJack = new BlackJack(deck);

        List<Player> listTest = blackJack.getWinner(player1, player2, player3, crupier);

        assert (listTest.equals(listBase));
    }

    @Test
    public void return_player1_player3_when_we_present_case_2() {
        //Player 1
        List<Card> betPlayer1 = new ArrayList<>();

        betPlayer1.add(new FigureCard());
        betPlayer1.add(new Pipcard(10));

        Player player1 = new Player("Player1", betPlayer1);

        //Player 2
        List<Card> betPlayer2 = new ArrayList<>();

        betPlayer2.add(new Pipcard(10));
        betPlayer2.add(new Pipcard(2));
        betPlayer2.add(new Pipcard(6));

        Player player2 = new Player("Player2", betPlayer2);

        //Player 3
        List<Card> betPlayer3 = new ArrayList<>();

        betPlayer3.add(new Pipcard(8));
        betPlayer3.add(new Pipcard(8));
        betPlayer3.add(new Pipcard(5));

        Player player3 = new Player("Player3", betPlayer3);

        //Crupier
        List<Card> betCrupier = new ArrayList<>();

        betCrupier.add(new Pipcard(5));
        betCrupier.add(new Pipcard(10));

        Player crupier = new Player("Crupier", betCrupier);

        List<Player> listBase = new ArrayList<>();
        listBase.add(player1);
        listBase.add(player3);

        List<Card> deck = new ArrayList<>();
        deck.add(new Ace());
        deck.add(new Pipcard(3));
        deck.add(new FigureCard());
        deck.add(new Pipcard(2));

        BlackJack blackJack = new BlackJack(deck);

        List<Player> listTest = blackJack.getWinner(player1, player2, player3, crupier);

        assert (listTest.equals(listBase));
    }
}
