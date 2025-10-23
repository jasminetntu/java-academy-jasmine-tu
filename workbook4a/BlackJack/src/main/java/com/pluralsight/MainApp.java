package com.pluralsight;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("*** BlackJack ***");
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter name of Player 1: ");
        Player player1 = new Player(scnr.nextLine());
        System.out.print("Enter name of Player 2: ");
        Player player2 = new Player(scnr.nextLine());

        Deck deck = new Deck();
        deck.shuffle();

        // deal 2 cards each player
        for (int i = 0; i < 2; i++) {
            Card card = deck.deal(); // get a card from the deck
            player1.deal(card); // deal that card to the hand

            card = deck.deal();
            player2.deal(card);
        }

        //display hands
        player1.displayHand();
        player2.displayHand();

        //determine winner
        if (player1.getHandValue() > player2.getHandValue()) {
            System.out.println(player1.getName() + " won with " + player1.getHandValue() + " points!");
        }
        else if (player1.getHandValue() < player2.getHandValue()) {
            System.out.println(player2.getName() + " won with " + player2.getHandValue() + " points!");
        }
        else {
            System.out.println("Tie with " + player1.getHandValue() + " points!");
        }

        scnr.close();
    }
}
