package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    //        //Deck should have a public method that “builds” an arraylist of Card objects
    // need to add cards to the deck

    private ArrayList<Card> deck;

    public Deck() { //constructor for Deck
        deck = new ArrayList<Card>();
    }

    public void addCard(Card card) { //telling method to add card to ArrayList
        deck.add(card);
    }

    public String toString() {
        String output = "";
        for (Card card : deck) {
            output += card;
            output += "\n";
        }
        return output;
    }

    ;

    public Deck(boolean makeDeck) {
        deck = new ArrayList<Card> ();
        if (makeDeck) {
            for (Suit suit : Suit.values()) { //nested loop for Suits
                for (Rank rank : Rank.values()) { //nested loop for Rank
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }
    public void shuffle() { // need to shuffle deck
        Collections.shuffle(deck, new Random());
    }
    public Card takeCard() {//method that takes a copy of the first card from the deck array
        Card cardToTake = new Card(deck.get(0));
        deck.remove(0); //remove the card from the deck
        return cardToTake; //return the card
    }
    //print out the cards remaining in deck
    public int cardsRemaining() {
        return deck.size();
    }
}
