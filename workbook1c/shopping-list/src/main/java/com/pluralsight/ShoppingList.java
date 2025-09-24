package com.pluralsight;

public class ShoppingList {
    public static void main(String[] args) {
        String[] list = {"apples", "bananas", "watermelon", "rice", "meat",
                "water bottles", "toilet paper", "napkins", "ice cream", "salad"};

        for (int i = 0; i < 10; ++i) {
            System.out.println((i + 1) + ". " + list[i]);
        }
    }
}