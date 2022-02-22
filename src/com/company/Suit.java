package com.company;

public enum Suit {
    Clubs("Clubs"),
    Diamonds("Diamonds"),
    Hearts("Hearts"),
    Spades("Spades");

    String suitName;
    Suit(String suitName) {
        this.suitName = suitName;
    }
    public String toString(){
        return suitName;
    }
}
