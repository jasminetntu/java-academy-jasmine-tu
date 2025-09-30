package com.pluralsight;

import java.util.Scanner;

public class LoopPractice {
    public static void main(String[] args) {
        // *** class exercises ***
        //exercise 1
        System.out.println("Exercise 1:");
        for (int i = 1; i < 11; i++) {
            System.out.println(i + ". I will be a good developer!");
        }

        //exercise 2:
        System.out.println("\nExercise 2:");
        for (int i = 81; i >= 1; --i) {
            if (i == 1) { //remove plural days
                System.out.println(i + " more day left of Year Up Code academy.");
            }
            else {
                System.out.println(i + " more days left of Year Up Code academy.");
            }
        }

        // *** java-loops exercises ***
        //exercise 1 - even nums
        System.out.println("For Loop: Counting from 1 to 5");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println("Even iteration " + i);
            }
        }

        //exercise 2 - countdown timer
        System.out.println("\nWhile Loop: Counting down from 5");
        int j = 5;
        while (j > 0) {
            System.out.println("Countdown: " + j + "...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            j--;
        }
        System.out.println("Time's up!");

        //exercise 3 - input until exit
        System.out.println("\nDo...While Loop: Run at least once");

        Scanner scnr = new Scanner(System.in);
        String input;
        do {
            System.out.print("Enter some input or type 'exit': ");
            input = scnr.nextLine().trim();
        } while (!input.equalsIgnoreCase("exit"));


    }
}