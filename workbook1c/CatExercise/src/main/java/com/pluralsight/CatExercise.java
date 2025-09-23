package com.pluralsight;

public class CatExercise {
    public static void main(String[] args) {
        String fullName = "Jasmine Tu";
        int age = 20;
        boolean likesCoffee = false;
        double heightInM = 1.615;

        System.out.println("Name: " + fullName);
        System.out.println("Age: " + age);
        System.out.println("Likes coffee? " + likesCoffee);
        System.out.println("Height (m): " + heightInM);

    }
}

/*
Exercise 2: Match Type
1. age -> int
2. whether light is on -> boolean
3. price of product -> double
4. single letter grade -> char
5. name -> String

Challenge: Debug
int age = "twenty"; // "twenty" is a String, but age is expecting an integer
boolean happy = "yes"; // "yes" is a String, but happy is expecting true or false
 */

