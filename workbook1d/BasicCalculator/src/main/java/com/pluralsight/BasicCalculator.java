package com.pluralsight;

import java.util.Scanner;

//exercise 3
public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        //get number inputs
        System.out.print("Enter the first number: ");
        double num1 = scnr.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scnr.nextDouble();

        //print options
        System.out.print("""
                \nPossible calculations:
                    (A)dd
                    (S)ubtract
                    (M)ultiply
                    (D)ivide
                Please select an option (corresponding letter):\s""");
        String choice = scnr.next();

        //perform calculation & print
        System.out.println();

        if (choice.equalsIgnoreCase("a")) {
            System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        }
        else if (choice.equalsIgnoreCase("s")) {
            System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
        }
        else if (choice.equalsIgnoreCase("m")) {
            System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
        }
        else if (choice.equalsIgnoreCase("d")) {
            System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
        }
        else {
            System.out.println("Invalid choice");
        }
    }
}
