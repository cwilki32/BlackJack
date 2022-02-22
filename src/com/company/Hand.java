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
        int aceCount = 0;       //BONUS - variable to count Aces Probably an IF statement
        for (Card card : hand) {
            value += card.getValue();
            if (card.getValue() == 11) {
                aceCount++;
            }
            if (value > 21 && aceCount >= 1) {// BONUS - saying we will reduce aceCount and value by 10
                aceCount--;
                value -= 10;
            }
        }
        return value;
    }

    public void clear() {
        hand.clear();
    }

    public Card getCard(int i) {
        return hand.get(i);
    }
}

