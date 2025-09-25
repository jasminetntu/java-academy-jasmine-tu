package com.pluralsight;

import java.util.Scanner;

public class Format {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scnr.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scnr.nextLine();

        String fullName = formatName(firstName, lastName);
        System.out.println("\nFormatted name: " + fullName);
    }

    public static String formatName(String first, String last) {
        return last + ", " + first;
    }
}
