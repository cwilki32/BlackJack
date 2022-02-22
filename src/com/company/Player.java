package com.company;

public class Player {//separates player and dealer with new Class, both need setters and getters for Hand
    private Hand hand;

    public Player() {
        this.hand = new Hand();

    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Hand getHand() {
        return this.hand;
    }
    public void hit(Deck deck) {
        this.hand.takeCardFromDeck(deck);
    }

    public boolean hasBlackjack() {//check player for Blackjack
        if (this.getHand().calculatedValue() == 21) {
            return true;
        } else {
            return false;
        }
    } public void printHand() {
        System.out.print("Player has" + this.hand + "with a value of " + this.hand.calculatedValue());
}

}
