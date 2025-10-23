package com.pluralsight;

public class Card {
    private String suit;
    private String value;
    private boolean isFaceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = false;
    }

    public String getSuit() {
        if (isFaceUp) { // only return suit if card is face up
            return suit;
        } else {
            return "#";
        }
    }

    public String getValue() {
        if (isFaceUp) { // only return the value if the card is face up
            return value; // String value of the card (i.e. A, K, Q, J, 10, 9...)
        } else {
            return "#";
        }
    }

    public int getPointValue() {
        if (isFaceUp) { // only return the value if the card is face up
            if (value.equalsIgnoreCase("a")) {
                return 11; //a
            }
            else if (value.equalsIgnoreCase("k") || value.equalsIgnoreCase("q")
                    || value.equalsIgnoreCase("j")) {
                return 10; //k, q, j
            }
            else { //numeric cards
                return Integer.parseInt(value);
            }
        } else {
            return -1;
        }
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }
}