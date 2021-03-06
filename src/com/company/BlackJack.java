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
    //WHAT IS WRONG WITH MY BLACKJACK CALCULATOR, KEEPS FROM ENTERING WHILE LOOP?
    //how can I slow down program? add a pause?
    private Deck deck, discarded;
    private Dealer dealer;
    private Player player;
    Scanner scanner = new Scanner(System.in);
    private int wins = 0;
    private int losses = 0;
    private int pushes = 0;
    boolean keepPlaying = true;

    public BlackJack() { //Constructor for Blackjack, creates variables, starts game
        deck = new Deck(true);
        discarded = new Deck();
        dealer = new Dealer();
        player = new Player();

        while (keepPlaying) {
            int playDecision = 0;
            System.out.println("Would you like to play? 1) Yes or 2) No");
            playDecision = scanner.nextInt();
            if (playDecision == 1) {
                deck.shuffle();
                deal();
            } else if (playDecision == 2) {
                System.out.println("Thanks for playing BlackJack. You finished with " + wins + " wins "
                        + losses + " losses " + "and " + pushes + " pushes. Please come back soon");
                break;
            } else {
                System.out.println("Invalid option. 1) Yes 2) No");
                playDecision = scanner.nextInt();
            }
        }
    }


    public void deal() {
        if (wins > 0 || losses > 0 || pushes > 0) {
            System.out.println('\n');
            System.out.println("Starting Next Round.....");
            dealer.getHand().discardHand(discarded);
            player.getHand().discardHand(discarded);
        }
        if (deck.cardsRemaining() < 6) {
            deck.reloadDeck(discarded);
            pause();
        }

        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        dealer.printDealerDraw();
        player.printHand();

        //check for blackjack for both players - win, push, loss
        if (dealer.hasBlackjack()) {
            dealer.getHand();

            if (player.hasBlackjack()) {
                System.out.println("You both have Blackjack! Close, you push.");
                pushes++;
                System.out.println("You have " + wins + " wins " + +losses + " losses and " + pushes + " pushes."
                        + "\n");
                //keepPlaying = true;
                pause();
                deal();
            }
            else {
                System.out.println(". Dealer has  " + dealer.getHand() + ". Blackjack! Bummer, you lose.");
                losses++;
                System.out.println("You have " + wins + " wins " + +losses + " losses and " + pushes + " pushes."
                        + "\n");
                pause();
                deal();
                //keepPlaying = true;
            }
        }
        if (player.hasBlackjack()) {
            System.out.println("Blackjack! Congrats, you win.");
            wins++;
            System.out.println("You have " + wins + " wins " + +losses + " losses and " + pushes + " pushes."
                    + "\n");
            pause();
            deal();
           // keepPlaying = true;
        }

        //finish check, continue round
//                player.playerDecision(deck); can I move this to player Class? clean it up
//

        boolean hitAgain = true;
        while (hitAgain == true && player.getHand().calculatedValue() < 21) {
            System.out.println("Would you like to: 1) Hit or 2) Stay");
            int decision = 0;
            decision = scanner.nextInt();
            scanner.nextLine();
            hitAgain = false;

            if (decision == 1) {
                player.hit(deck, discarded);
                player.printHand();
//                System.out.println("Would you like to 1) Hit or 2) Stay");
                hitAgain = true;
                if (player.getHand().calculatedValue() > 21) {
                    System.out.println("You bust.");
                    keepPlaying = true;
                    break;
                } else {
                    hitAgain = true;
                }

            } else {
                System.out.println("You chose to stay with " + player.getHand().calculatedValue());
            }
        }

            if (player.getHand().calculatedValue() > 21) {
                System.out.println("You lose.");
                losses++;
                System.out.println("You have " + wins + " wins " + +losses + " losses and " + pushes + " pushes."
                        + "\n");
                deal();

            }

            while (dealer.getHand().calculatedValue() < 17) {

                System.out.println("Dealer has " + dealer.getHand() + dealer.getHand().calculatedValue());
                pause();
                dealer.hit(deck, discarded);
                System.out.println("Dealer hit.");
            }
            if (dealer.getHand().calculatedValue() > 21) {
                System.out.println("Dealer has " + dealer.getHand().calculatedValue() + ". Dealer busts. You win");
                wins++;
            }
            else if (dealer.getHand().calculatedValue() < player.getHand().calculatedValue()) {
                System.out.println("Dealer has " + dealer.getHand().calculatedValue() + " Player has "
                        + player.getHand().calculatedValue() + ". You win.");
                wins++;
            }
            else if (dealer.getHand().calculatedValue() > player.getHand().calculatedValue()) {
                System.out.println("Dealer has " + dealer.getHand().calculatedValue() + " Player has "
                        + player.getHand().calculatedValue() + ". You lose.");
                losses++;
            }
            else {
                System.out.println("Dealer also has " + dealer.getHand().calculatedValue() + " You push.");
                pushes++;
            }
            System.out.println("You have " + wins + " wins " + +losses + " losses and " + pushes + " pushes."
                    + "\n");
            pause();
            keepPlaying = true;

        }

        public static void pause () {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


