package com.pluralsight;

import java.util.Scanner;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        MainApp app = new MainApp();
        Scanner scnr = new Scanner(System.in);

        ArrayList<Player> players = new ArrayList<>();
        Deck deck = new Deck();
        deck.shuffle();

        System.out.println("""
                ===========================
                |     ♥️ BlackJack ♣️     |
                ===========================""");
        int numPlayers = app.getNumPlayers(scnr);

        //get player names & dealTwo 2 cards
        for (int i = 1; i <= numPlayers; ++i) {
            System.out.print("Enter name of Player " + i + ": ");
            Player player = new Player(scnr.nextLine());
            player.dealTwo(deck);
            players.add(player);
        }

        //take turns to hit/stay
        for (int i = 0; i < numPlayers; ++i) {
            Player currPlayer = players.get(i);
            System.out.printf("\n♣️ %s's Turn (Hand value: %d)\n", currPlayer.getName(), currPlayer.getHandValue());
            boolean isValid = false;

            while (!isValid) {
                System.out.print("> Hit (H) or Stay (S)?: ");
                String choice = scnr.nextLine().trim().toLowerCase();

                switch (choice) {
                    case "h" -> {
                        currPlayer.hit(deck);
                        isValid = true;
                    }
                    case "s" -> {
                        System.out.println("You chose to stay.");
                        isValid = true;
                    }
                    default -> System.out.println("Invalid choice. Enter H or S.");
                }
            }
        }

        //display final hands & find winner
        System.out.println("\n♣️ Final Player Hands");

        int maxValue = 0;
        Player winner = null;

        for (Player p : players) {
            p.displayHand();
            System.out.println("Total: " + p.getHandValue());

            //update max if applicable
            if (p.getHandValue() > maxValue && p.getHandValue() <= 21) {
                maxValue = p.getHandValue();
                winner = p;
            }
        }

        if (winner == null) {
            System.out.println("\nNo winner! All bust.");
        }
        else {
            System.out.println("\n🏆 Winner: " + winner.getName() + " with " + maxValue + " points!");
        }

        scnr.close();
    }

    public int getNumPlayers(Scanner scnr) {
        int numPlayers;

        while (true) {
            System.out.print("\nEnter number of players: ");
            try {
                numPlayers = Integer.parseInt(scnr.nextLine().trim());

                if (numPlayers < 2) {
                    System.out.println("Must be at least 2. Try again.");
                }
                else {
                    return numPlayers;
                }
            } catch (NumberFormatException e) {
                System.out.println("Must be a number. Try again.");
            }
        }

    }
}
