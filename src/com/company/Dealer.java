package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Dealer {
    //Create a new class called Dealer
    //Dealer should have a method named “deal”, that returns two random Cards and removes them from the deck
    //Dealer should have a method named “hit”, that returns a random single card and removes it from the deck

    //used to create Array List that will simultaneously add cards to hand and remove from deck
    //need to create a new array List called hand
    private Hand hand; //setting a new Hand variable from Hand class

    public void setHand(Hand hand) {//setter
        this.hand = hand;
    }

    public Hand getHand() {
        return this.hand;
    }

    private void deal(Deck deck) { //deal method that sets 2 cards
        this.getHand().takeCardFromDeck(deck);
        getHand().takeCardFromDeck(deck);
    }

    private void hit(Deck deck) { //deal one card from deck
        this.getHand().takeCardFromDeck(deck);
    }
}



/*    Scanner scanner = new Scanner(System.in); //importing scanner for user hit
    boolean hitAgain = false;
    Deck testDeck = new Deck(true);


//    public Dealer() {

        //   public int hit() {//creating a method called hit that deals 1 card

//}*/
