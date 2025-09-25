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

        if (size != 1 && size != 2) {
            System.out.println("Invalid option. Defaulting to regular size.");
            size = 1;
        }

        //loaded or not
        System.out.print("""
                \nWould you like the sandwich loaded?
                    Regular: +$1.00
                    Large: +$1.75
                Enter "true" or "false" exactly:\s""");
        boolean isLoaded = scnr.nextBoolean();

        //determine price
        double price = 0;
        if (size == 1) {
            price = 5.45;
            if (isLoaded) {
                price += 1;
            }
        }
        else {
            price = 8.95;
            if (isLoaded) {
                price += 1.75;
            }
        }

        //get age & discount if applicable
        System.out.print("\nHow old are you?: ");
        int age = scnr.nextInt();

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