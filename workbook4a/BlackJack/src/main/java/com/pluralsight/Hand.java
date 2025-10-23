package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    // Card is dealt to Hand, then Hand is responsible for storing card
    public void deal(Card card) {
        cards.add(card);
    }

    public int getSize() {
        return cards.size();
    }

    public boolean hasA() {
        for (Card c : cards) {
            c.flip();
            if (c.getValue().equalsIgnoreCase("a")) {
                return true;
            }
            c.flip();
        }
        return false;
    }

    // Hand uses methods of each card to determine value of each card & adds up all values
    public int getValue() {
        int value = 0;
        for (Card card : cards) {
            card.flip(); // turn the card over to see the value
            value += card.getPointValue();
            card.flip(); // hide the card again
        }

        if (value > 21 && hasA()) { //count ace as 1 if 11 causes hand to bust
            value -= 10;
        }

        return value;
    }

    public void viewHand() {
        for (int i = 0; i < cards.size(); ++i) {
            Card card = cards.get(i);
            card.flip();
            System.out.println("🃏 " + (i + 1) + ": " + cards.get(i).getSuit()
                    + " " + cards.get(i).getValue());
            card.flip();
        }
    }
}