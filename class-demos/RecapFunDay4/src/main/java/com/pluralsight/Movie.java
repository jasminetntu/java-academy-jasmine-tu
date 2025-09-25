package com.pluralsight;

import java.util.Scanner;

public class Movie {
    public static void main(String[] args) {
        String movieTitle = "Demon Slayer: Infinity Castle";
        int numFriends = 5;
        double pricePerPizzaSlice = 3.99;
        boolean hasPopcorn = true;

        //basic exercise
        System.out.println("My Example: "
                + "\n🎥 We’re watching " + movieTitle + " with " + numFriends + " friends."
                + "\n🍕 Pizza costs " + pricePerPizzaSlice + " per slice.");

        System.out.printf("For all of us, the total pizza cost is $%.2f.\n", pricePerPizzaSlice * (numFriends + 1));

        if (hasPopcorn) {
            System.out.println("Popcorn time! 🍿");
        }
        else {
            System.out.println("Time to get popcorn! 🍿");
        }

        //BONUS CHALLENGES
        System.out.println("\nNow, let's try with your inputs!");

        //1 - input from user
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter movie title: ");
        movieTitle = scnr.nextLine();
        System.out.print("How many friends are you going with?: ");
        numFriends = scnr.nextInt();
        System.out.print("What is the price of a pizza slice?: ");
        pricePerPizzaSlice = scnr.nextDouble();
        System.out.print("Is there popcorn? (true or false): ");
        hasPopcorn = scnr.nextBoolean();

        //2 - round pizza cost
        double totalPizzaCost = Math.round((numFriends + 1) * pricePerPizzaSlice * 100) / 100.0;

        //3 - dynamic message
        if (totalPizzaCost > 30) {
            System.out.println("Whoa, that's a lot of pizza! 🍕");
        }
        else {
            System.out.println("Nice budget-friendly movie night!");
        }

        if (hasPopcorn) {
            System.out.println("Popcorn time! 🍿");
        }
        else {
            System.out.println("Time to get popcorn! 🍿");
        }

        //4 - add drinks
        System.out.print("What is the price of a regular-size drink?: ");
        double drinkPrice = scnr.nextDouble();
        double totalDrinkPrice = (numFriends + 1) * drinkPrice;

        //5 - string formatting
        System.out.printf("\nMovie: %s | Guests (incl. you): %d | Total cost: $%.2f", movieTitle,
                numFriends + 1, totalPizzaCost + totalDrinkPrice);

        scnr.close();
    }
}
