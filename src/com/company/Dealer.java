package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Dealer {
    //Create a new class called Dealer
    //Dealer should have a method named “deal”, that returns two random Cards and removes them from the deck
    //Dealer should have a method named “hit”, that returns a random single card and removes it from the deck

    //used to create Array List that will simultaneously add cards to hand and remove from deck
    //need to create a new array List called hand

    private Hand hand; //setting a new Hand variable from Hand class
    private Deck deck;
    Deck testDeck = new Deck(true);

    public Dealer() {
        this.hand = new Hand();
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Hand getHand() {
        return this.hand;
    }

    private void hit(Deck deck) { //deal one card from deck
        this.hand.takeCardFromDeck(deck);
    }

    private void deal(Deck deck) {//deal two cards
        this.hand.takeCardFromDeck(deck);
        this.hand.takeCardFromDeck(deck);
    }
    public boolean hasBlackjack() {
        if (this.getHand().calculatedValue() == 21) {
            return true;

        } else {
            return false;
        }
    }
    public void printDealerDraw() {
        System.out.println("The dealer is showing " + getHand().getCard(0));
    }
}

