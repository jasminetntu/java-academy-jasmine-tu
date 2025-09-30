package com.pluralsight;

import java.util.Scanner;

public class StringPractice {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter your email address: ");
        String email = scnr.next().trim().toLowerCase();
        //assume case doesn't matter

        ValidateEmail(email);
    }

    public static void ValidateEmail(String email) {
        boolean isValid = email.endsWith("@yearup.org");
        if (isValid) {
            System.out.println(email + " is valid.");
        }
        else {
            System.out.println(email + " is invalid.");
        }
    }
}