package com.pluralsight;

public class LoopPractice {
    public static void main(String[] args) {
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

    }
}