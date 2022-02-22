package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<Card>();
    }

    public void takeCardFromDeck(Deck deck) {
        hand.add(deck.takeCard());
    }

    public String toString() {
        String output = " ";
        for (Card card : hand) {
            output += card + " - ";
        }
        return output;
    }

    public int calculatedValue() { //need to calculate value in hand
        int value = 0;
        //hold for something for aces? Probably an IF statement
        for (Card card : hand) {
            value += card.getValue();
        }
        return value;
    }
}

