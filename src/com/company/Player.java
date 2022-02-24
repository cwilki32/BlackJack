package com.company;

import java.util.Scanner;

public class Player {//separates player and dealer with new Class, both need setters and getters for Hand
    private Hand hand;
    Scanner scanner = new Scanner(System.in);

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
    }

    public void printHand() {
        System.out.print("Player has" + this.hand + "with a value of " + this.hand.calculatedValue() + ". ");
    }

    public void playerDecision(Deck deck) {
        int decision = 0;
        boolean hitAgain = true;

        while (hitAgain = true) {
            System.out.println("\n" + "Would you like to 1) Hit or 2) Stay?");
            decision = scanner.nextInt();
            hitAgain = false;
        }
        if (decision == 1) {
            this.hit(deck);
            if (this.getHand().calculatedValue() > 20) {
                return;
            }
            else {
                this.playerDecision(deck);
            }
        } else {
            System.out.println("You chose to stand");
        }
    }
}

