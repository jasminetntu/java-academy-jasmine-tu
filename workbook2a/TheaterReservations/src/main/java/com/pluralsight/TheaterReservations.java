package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("*** Theater Reservations ***");

        //get inputs
        System.out.print("Enter your first & last name: ");
        String name = scnr.nextLine().trim();
        String firstName = name.substring(0, name.indexOf(" "));
        String lastName = name.substring(name.indexOf(" ") + 1);

        System.out.print("Date to reserve (MM/dd/yyyy): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate reservationDate = LocalDate.parse(scnr.nextLine().trim(), formatter);

        System.out.print("Number of tickets to reserve: ");
        int numTickets = scnr.nextInt();

        // # ticket(s) reserved for (date) under (LastName, FirstName)
        System.out.println();
        if (numTickets == 1) {
            System.out.printf(numTickets + " ticket reserved for " + reservationDate + " under %s, %s.\n", lastName, firstName);
        }
        else if (numTickets > 1){
            System.out.printf(numTickets + " tickets reserved for " + reservationDate + " under %s, %s.\n", lastName, firstName);
        }
        else {
            System.out.println("Invalid number of tickets.");
        }

        scnr.close();
    }
}