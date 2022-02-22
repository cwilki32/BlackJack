package com.company;

public class Card {
    //        //A card should have at least 3 properties: suit, rank, and value - rank and value combined in enum
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) { //constructor for Card need getters for values
        this.suit = suit;
        this.rank = rank;
    }
    public int getValue() {
        return rank.rankValue;
    }
    public Suit getSuit() {
        return suit;
    }
    public Rank getRank() {
        return rank;
    }
    public String toString() {
        return("[" + rank + " of " + suit + "] ("+this.getValue()+")");
    }
    public Card(Card card) {
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }
}
