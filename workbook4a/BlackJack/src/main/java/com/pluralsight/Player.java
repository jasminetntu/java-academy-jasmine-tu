package com.pluralsight;

public class Player {
    private String name;
    private Hand hand;

    // *** Constructors ***
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    // *** Getters ***
    public String getName() {
        return name;
    }

    public int getHandValue() {
        return hand.getValue();
    }

    // *** Setters ***

    //deals 2 cards to player
    public void dealTwo(Deck deck) {
        for (int i = 0; i < 2; i++) {
            Card card = deck.deal(); // get a card from the deck
            hand.deal(card); // deal that card to the hand
        }
    }

    public void hit(Deck deck) {
        System.out.println("You chose to hit.");
        Card card = deck.deal(); // get a card from the deck
        hand.deal(card); // deal that card to the hand
        card.flip();
        System.out.println("> You got a " + card.getSuit() + " " + card.getValue() + ".");
        card.flip();
    }

    // *** Other ***
    public void displayHand() {
        System.out.println("--- ♥️ " + name + "'s Hand ---");
        hand.viewHand();
    }
}
