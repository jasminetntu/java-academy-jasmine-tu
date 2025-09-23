package com.pluralsight;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ShoppingList {
    public static void main(String[] args) {
        String[] list = {"apples", "bananas", "watermelon", "rice", "meat",
                "water bottles", "toilet paper", "napkins", "ice cream", "salad"};

        for (int i = 0; i < 10; ++i) {
            System.out.println((i + 1) + ". " + list[i]);
        }
    }
}