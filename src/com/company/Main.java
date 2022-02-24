package com.company;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a new repo in Github named BlackJack
        //In IntelliJ, create a new project named BlackJack
        //In the Terminal navigate to your BlackJack project location
        //In terminal, use git init
        //Copy the Github SSH key for your new Github repo
        //In Terminal Setup the git remote named origin by using the Github SSH key you copied earlier
        //Stage and commit the init changes to your local repo
        //Push changes to Github
        //Create a class called Card
        //A card should have at least 3 properties: suit, rank, and value
        //Create a new class called Deck
        //Deck should have a public method that “builds” an arraylist of Card objects
        //Assign each Card a Suit (Spades, Clubs, Diamond, and Heart)
        //Assigning each card a Rank (2-10, Jack, Queen, King, Ace)
        //Assigning each card a value to 2-11
        //This should be done to recreate the 52 unique cards in a deck
        //Create a new class called Dealer
        //Dealer should have a method named “deal”, that returns two random Cards and removes them from the deck
        //Dealer should have a method named “hit”, that returns a random single card and removes it from the deck
        //In your main class, deal the user a hand of two cards
        //Display the total of the two card values to the user
        //If the cards equal 21, declare Black Jack and congratulate the user.
        //If the cards are not equal to 21, ask the user to hit (get another card) or stay (take the current score and end the “hand)
        //Allow the user to keep getting cards until their value exceeds 21 or they choose to stay
        //Bonus: Can you figure out a way to handle Aces being worth 1 or 11?
        //Super Bonus: Can you handle the dealer also playing a hand to see who wins with the closest score to 21?
        System.out.println("Welcome to Blackjack");
        BlackJack blackjack = new BlackJack();

    }
}


/*        Deck testDeck = new Deck(true); //need to somehow get this under Dealer
        Hand testHand = new Hand();
        testDeck.shuffle();
        Dealer testDealer = new Dealer();
        int wins = 0; //used to set up Scoreboard
        int losses = 0;
        boolean startGame = true; //need to set the iteration
        boolean hitAgain = true;
        Scanner scanner = new Scanner(System.in);
//        int playAgain = 0;
//
//        while (startGame) {
//            System.out.println("Would you like to play? 1) Yes 2) No");
//            playAgain = scanner.nextInt();
//            scanner.nextLine();
//
//            if (playAgain == 1) {
//                testDeck.shuffle();
//                testHand.clear();
//        testDealer.deal(testDeck);
                testHand.takeCardFromDeck(testDeck); //need a method but dealing two cards for practice
                testHand.takeCardFromDeck(testDeck);
//        testDealer.deal(testDeck);


                System.out.println("Cards dealt " + testHand);
                System.out.println("The value of your cards is " + testHand.calculatedValue());


                int userChoice = 0;
                if (testHand.calculatedValue() == 21) {
                    System.out.println("Blackjack!");
                    wins++;
                    System.out.println("Wins " + wins + " Losses " + losses);
                } else if (testHand.calculatedValue() < 21) {
                    System.out.println("Would you like to 1) Hit or 2) Stay");
                    userChoice = scanner.nextInt();
                    //                   scanner.nextLine();
                }
                while (hitAgain == true)
                    if (userChoice == 1) {
                        testHand.takeCardFromDeck(testDeck);
                        System.out.println("Your cards are " + testHand);
                        System.out.println("The value of your cards is now " + testHand.calculatedValue());
                        if (testHand.calculatedValue() < 21) {
                            userChoice = scanner.nextInt();
                            scanner.nextLine();
                        } else if (testHand.calculatedValue() == 21) {
                            System.out.println("Twenty One!");
                            wins++;
                            hitAgain = false;
                        } else {
                            System.out.println("You busted!");
                            losses++;
                            hitAgain = false;
                        }
                        System.out.println("Wins " + wins + " Losses " + losses);

                    } else if (userChoice == 2) {
                        System.out.println("You finished with " + testHand.calculatedValue());
                        hitAgain = false;
                    }
//            } else if (playAgain == 2) {
//                System.out.print("Thanks for playing, you had " + wins + " and " + losses + " losses");
//                startGame = false;
//            } else {
//                System.out.println("Invalid response, 1) to Play Again 2) to quit");
//                playAgain = scanner.nextInt();
//                scanner.nextLine();
            }
        }*/
