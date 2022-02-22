package com.company;

public class BlackJack {// this class will house most of the game logic later
    //declare 3 private ints named win, loss, push to set up tracking (think RPS scoreboard)
    //Deal 2 cards to player
    //Deal 2 cards to dealer, one showing
    //Compare hand values - Blackjack?
    //Ask Player to hit or stand
    //After player turn, dealer draws until reaches 17 -bonus
    //Determine win or lose, add to tracking -bonus
    //Shuffle and give player option to play again or quit
    private Deck deck;
    private Dealer dealer;
    private Player player;

    public BlackJack() { //Constructor for Blackjack, creates variables, starts game
        deck = new Deck(true);
        dealer = new Dealer();
        player = new Player();

        deck.shuffle();
        deal();
    }
    private void deal() {
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        dealer.printDealerDraw();
        player.printHand();
    }
}
