package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("*** Cell Phone Service ***");

        CellPhone phone = new CellPhone();

        //get inputs & call setters
        System.out.print("What is the serial number?: ");
        phone.setSerialNumber(scnr.nextInt());
        scnr.nextLine(); //consume leftover \n

        System.out.print("What model is the phone?: ");
        phone.setModel(scnr.nextLine().trim());

        System.out.print("Who is the carrier?: ");
        phone.setCarrier(scnr.nextLine().trim());

        System.out.print("What is the phone number?: ");
        phone.setPhoneNumber(scnr.nextLine().trim());

        System.out.print("Who is the owner of the phone?: ");
        phone.setOwner(scnr.nextLine().trim());

        //print results w/ getters
        System.out.printf("""
                \nYour Phone:
                Serial Number: %d
                Model: %s
                Carrier: %s
                Phone Number: %s
                Owner: %s
                """, phone.getSerialNumber(), phone.getModel(), phone.getCarrier(),
                phone.getPhoneNumber(), phone.getOwner());

        scnr.close();
    }
}