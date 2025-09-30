package com.pluralsight;

import java.util.Scanner;

public class AddressBuilder {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        StringBuilder address = new StringBuilder();

        //title
        System.out.println("""
                *** Address Builder ***
                
                --- Please provide the following information:""");

        //get inputs & build string
        System.out.print("Full name: ");
        address.append(scnr.nextLine()).append("\n\nBilling Address:\n");

        //billing address
        System.out.print("\nBilling Street: ");
        address.append(scnr.nextLine().trim()).append("\n");
        System.out.print("Billing City: ");
        address.append(scnr.nextLine().trim()).append(", ");
        System.out.print("Billing State: ");
        address.append(scnr.nextLine().trim()).append(" ");
        System.out.print("Billing Zip: ");
        address.append(scnr.nextLine().trim()).append("\n\nShipping Address:\n");

        //shipping address
        System.out.print("\nShipping Street: ");
        address.append(scnr.nextLine().trim()).append("\n");
        System.out.print("Shipping City: ");
        address.append(scnr.nextLine().trim()).append(", ");
        System.out.print("Shipping State: ");
        address.append(scnr.nextLine().trim()).append(" ");
        System.out.print("Shipping Zip: ");
        address.append(scnr.nextLine().trim());

        //print
        System.out.println("\n--- Customer Information:\n" + address);

        //NOTE: toString() is unnecessary in print statements or w/ concatenation bc java does it implicitly

    }
}