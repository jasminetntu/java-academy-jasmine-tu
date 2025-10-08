package com.pluralsight;

import java.util.Scanner;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class SearchEngineLogger {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        System.out.println("*** Search Engine Logger ***");

        BufferedWriter bufWriter = new BufferedWriter(new FileWriter("data/logs.txt"));
        String searchTerm = "";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm:ss a");

        //launch time
        LocalDateTime currDateAndTime = LocalDateTime.now();
        bufWriter.write(formatter.format(currDateAndTime) + " launch\n");

        //searches
        while (!searchTerm.equalsIgnoreCase("x")) {
            System.out.print("Enter a search term (X to exit): ");
            searchTerm = scnr.nextLine().trim();

            if (!searchTerm.equalsIgnoreCase("x")) {
                currDateAndTime = LocalDateTime.now();
                bufWriter.write(formatter.format(currDateAndTime) + " search : " + searchTerm + "\n");
            }
        }

        //exit time
        currDateAndTime = LocalDateTime.now();
        bufWriter.write(formatter.format(currDateAndTime) + " exit");

        scnr.close();
        bufWriter.close();
    }
}