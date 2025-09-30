package com.pluralsight;

import java.util.Scanner;

public class StringPractice {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter your email address: ");
        String email = scnr.next().trim().toLowerCase();
        //assume case doesn't matter

        ValidateEmail(email);
        LoginChecker(scnr);
    }

    public static void ValidateEmail(String email) {
        boolean isValid = email.endsWith("@yearup.org");
        if (isValid) {
            System.out.println(email + " is valid.");
        } else {
            System.out.println(email + " is invalid.");
        }
    }

    private static void LoginChecker(Scanner scnr) {
        System.out.println("What is your password");
        String password = scnr.nextLine().trim();
        String correctPassword = "1234";

        if (password.equals(correctPassword)) {
            System.out.println("That is correct, you are logged in");
        } else {
            System.out.println("That is incorrect, try again");
        }

    }
}