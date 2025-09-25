package com.pluralsight;

//exercise 1
public class VariableApp {
    public static void main(String[] args) {
        // Step 1:
        String favColor = "dark green";
        int yearStartedClass = 2025;
        char midInitial1 = 'T';
        char midInitial2 = 'N';
        boolean hasPets = false;
        String niceMessage = "It’s always the little things you remember people by, " +
                "all the little things they did because they wanted to do them for you.";

        System.out.println("My favorite color is " + favColor + "."
                + "\nI started Year Up United in " + yearStartedClass + "."
                + "\nMy middle initials are " + midInitial1 + midInitial2 + ".");
        if (hasPets) {
            System.out.println("I have pets!");
        }
        else {
            System.out.println("I don't have pets. :(");
        }
        System.out.println("This is a quote I like:\n\"" + niceMessage + "\"");

        //Step 2
        int numDaysInWeek = 7;
        double priceCoffee = 4.99;
        char favLetter = 'R';
        boolean isRaining = true;

        System.out.println("\nThere are " + numDaysInWeek + " days in a week."
                + "\nThe price of coffee at my local cafe is $" + priceCoffee + "."
                + "\nMy favorite letter is " + favLetter + ".");
        if (isRaining) {
            System.out.println("It's raining today.");
        }
        else {
            System.out.println("It's not raining today!");
        }
    }
}