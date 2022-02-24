package com.company;

import java.util.Scanner;

public class BlackJack {// this class will house most of the game logic later
    //declare 3 private ints named win, loss, push to set up tracking (think RPS scoreboard)
    //Deal 2 cards to player
    //Deal 2 cards to dealer, one showing
    //Compare hand values - Blackjack?
    //Ask Player to hit or stand
    //After player turn, dealer draws until reaches 17 -bonus
    //Determine win or lose, add to tracking -bonus
    //Shuffle and give player option to play again or quit

    //NEED SOMETHING TO RESET, MAYBE A DISCARD/EMPTY PLAYER HAND METHOD?
    //WHAT IS WRONG WITH MY BLACKJACK CALCULATOR, KEEPS FROM ENTERING WHILE LOOP
    private Deck deck;
    private Dealer dealer;
    private Player player;
    Scanner scanner = new Scanner(System.in);
    private int wins = 0;
    private int losses = 0;
    private int pushes = 0;

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
        //check for blackjack for both players - win, push, loss
//        if (dealer.hasBlackjack()) {
//            dealer.printDealerDraw();

//            if (player.hasBlackjack()) {
//                System.out.println("You both have Blackjack! Close, you push");
//                pushes++;
//                deal();
//            } else {
//                System.out.println("Dealer has Blackjack! Bummer, you lose.");
//                losses++;
//                deal();
//            }
//            if (player.hasBlackjack()) {
//                System.out.println("Blackjack! Congrats, you win.");
//                wins++;
//                deal();

        //finish check, continue round
//                player.playerDecision(deck);
//
        int decision = 0;
        boolean hitAgain = true;
        while (hitAgain == true) {
            System.out.println("Would you like to: 1) Hit or 2) Stay");
            decision = scanner.nextInt();
            scanner.nextLine();
            hitAgain = false;
        }
        if (decision == 1) {
            player.hit(deck);
            player.printHand();
            System.out.println("Would you like to 1) Hit or 2) Stay");
            hitAgain = true;
            if (player.getHand().calculatedValue() > 21) {
                System.out.println("You bust.");
                losses++;
                hitAgain = false;
            } else {
                decision = scanner.nextInt();
            }

            } else {
            System.out.println("You chose to stay");
            System.out.println("Dealer has " + dealer.getHand());
        }

            if (player.getHand().calculatedValue() > 21) {
                System.out.println("You have gone over 21. Player busts.");
                losses++;
                System.out.println("You have " + wins + " wins " + + losses+  " losses and " + pushes + " pushes.");
                player.getHand().clear();
                dealer.getHand().clear();
                deal();
            }

            while (dealer.getHand().calculatedValue() < 17) {
                dealer.hit(deck);
                System.out.println("Dealer hit.");
                System.out.println("Dealer has " + dealer.getHand() + dealer.getHand().calculatedValue());
            }
            if (dealer.getHand().calculatedValue() > 21) {
                System.out.println("Dealer busts. You win");
                wins++;
            } else if (dealer.getHand().calculatedValue() > player.getHand().calculatedValue()) {
                System.out.println("You lose.");
                losses++;
            } else {
                System.out.println("You push.");
                pushes++;
            }
            System.out.println("You have " + wins + " wins " + + losses+  " losses and " + pushes + " pushes.");
            player.getHand().clear();
            dealer.getHand().clear();
            deal();

        }
    }


