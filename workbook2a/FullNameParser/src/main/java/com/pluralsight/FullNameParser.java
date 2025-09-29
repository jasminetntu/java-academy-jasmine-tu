package com.pluralsight;

import java.util.Scanner;

public class FullNameParser {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("*** Full Name Parser ***");

        //get input
        System.out.print("Please enter your full name: ");
        String fullName = scnr.nextLine().trim();

        //get first/middle/last
        String[] name_arr = fullName.split(" ");

        //print result
        System.out.println("\nFirst name: " + name_arr[0]);

        System.out.print("Middle name: ");
        for (int i = 1; i < name_arr.length - 1; ++i) {
            System.out.print(name_arr[i] + " ");
        }

        System.out.println("\nLast name: " + name_arr[name_arr.length - 1]);
    }
}