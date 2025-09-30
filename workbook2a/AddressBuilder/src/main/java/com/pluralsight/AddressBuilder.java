package com.pluralsight;

import java.util.Scanner;

public class AddressBuilder {
    public static void main(String[] args) {
        //Please provide the following information:
        //Full name: Grover Smith
        //Billing Street: 123 Main Street
        //Billing City: Middleton
        //Billing State: TX
        //Billing Zip: 75111
        //Shipping Street: 456 Big Sky Blvd
        //Shipping City: Outer Rim
        //Shipping State: TX
        //Shipping Zip: 75333

        Scanner scnr = new Scanner(System.in);
        StringBuilder address = new StringBuilder();

        System.out.println("*** Address Builder ***" +
                "\n\n--- Please provide the following information:");

        System.out.print("Full name: ");
        address.append(scnr.nextLine() + "\n\nBilling Address:\n");

        System.out.print("\nBilling Street: ");
        address.append(scnr.nextLine().trim() + "\n");
        System.out.print("Billing City: ");
        address.append(scnr.nextLine().trim() + ", ");
        System.out.print("Billing State: ");
        address.append(scnr.nextLine().trim() + " ");
        System.out.print("Billing Zip: ");
        address.append(scnr.nextLine().trim() + "\n\nShipping Address:\n");

        System.out.print("\nShipping Street: ");
        address.append(scnr.nextLine().trim() + "\n");
        System.out.print("Shipping City: ");
        address.append(scnr.nextLine().trim() + ", ");
        System.out.print("Shipping State: ");
        address.append(scnr.nextLine().trim() + " ");
        System.out.print("Shipping Zip: ");
        address.append(scnr.nextLine().trim());

        System.out.println("\n--- Customer Information:\n" + address.toString());

    }
}