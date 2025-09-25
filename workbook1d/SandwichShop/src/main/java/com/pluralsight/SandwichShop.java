package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to Jammy's Sandwich Shop! 🌸");

        //get size
        System.out.print("""
                \nWhich size would you like? 🥪
                   1. Regular: base price $5.45
                   2. Large: base price $8.95
                Enter 1 or 2:\s""");
        int size = scnr.nextInt();

        //determine base price
        double price = 5.45;
        if (size == 2) {
            price = 8.95;
        }
        else if (size != 1) {
            System.out.println("Invalid option. Defaulting to regular size.");
        }

        //get age
        System.out.print("\nHow old are you?: ");
        int age = scnr.nextInt();

        //discount if applicable
        if (age < 18) {
            System.out.println("Congrats! You're eligible for a student discount.");
            price -= price * 0.10;
        }
        else if (age >= 65) {
            System.out.println("Congrats! You're eligible for a senior discount.");
            price -= price * 0.20;
        }
        else {
            System.out.println("No discounts at the moment.");
        }

        //print cost
        System.out.printf("\nYour total is $%.2f.\nThank you for visiting!", price);

    }
}