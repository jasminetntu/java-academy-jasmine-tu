package com.pluralsight;

import java.util.Scanner;

public class FullNameGenerator {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("*** Welcome to the full name generator! ***\n");

        //get inputs
        System.out.print("Enter your...\nFirst name: ");
        String firstName = scnr.nextLine().trim();
        System.out.print("Middle name (press return if N/A): ");
        String middleName = scnr.nextLine().trim();
        System.out.print("Last name: ");
        String lastName = scnr.nextLine().trim();
        System.out.print("Suffix (press return if N/A): ");
        String suffix = scnr.nextLine().trim();

        //print full name
        System.out.print("\nFull name: " + firstName + " ");

        if (!middleName.isEmpty()) {
            System.out.print(middleName + " ");
        }

        System.out.print(lastName);

        if (!suffix.isEmpty()) {
            System.out.println(", " + suffix);
        }

        scnr.close();
    }
}