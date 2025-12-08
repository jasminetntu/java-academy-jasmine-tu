package com.pluralsight;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // exit if username & password aren't provided
        if (args.length != 2) {
            System.out.println("Application needs two arguments to run: " +
                    "java com.pluralsight.UsingDriverManager <username> <password>");
            System.exit(1);
        }
        String username = args[0]; // otherwise, get CLI args from config
        String password = args[1];

        SakilaDataManager sakilaDM = null;
        try {
            sakilaDM = new SakilaDataManager(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // interact w/ database
        Main main = new Main();
        try (Scanner scnr = new Scanner(System.in)) {
            main.queryActorsByName(scnr, sakilaDM);
            main.queryFilmsByActor(scnr, sakilaDM);
        }
    }

    private void queryActorsByName(Scanner scnr, SakilaDataManager sakilaDM) {
        System.out.println("Let's search for actors!");

        System.out.print("Enter first name: ");
        String firstName = scnr.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scnr.nextLine();

        List<Actor> actors = sakilaDM.getActorsByName(firstName, lastName);

        if (actors.isEmpty()) {
            System.out.println("No matches found!");
        }
        else {
            System.out.println("ACTORS NAMED " + firstName.toUpperCase() + " " + lastName.toUpperCase());
            System.out.printf("%n%-5s %-20s %-20s%n", "ID", "First Name", "Last Name");
            System.out.println("----- -------------------- --------------------");
            for (Actor a : actors) {
                System.out.printf("%-5s %-20s %-20s%n", a.getActorId(), a.getFirstName(), a.getLastName());
            }
            System.out.println("----- -------------------- --------------------");
        }
    }

    private void queryFilmsByActor(Scanner scnr, SakilaDataManager sakilaDM) {
        System.out.println("\nLet's search for films!");

        int id = -1;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("\nEnter actor id: ");
                id = Integer.parseInt(scnr.nextLine());
                valid = true;
            }
            catch (NumberFormatException e) {
                System.out.println("Input must be a whole number.");
            }
        }

        List<Film> films = sakilaDM.getFilmsByActorId(id);

        if (films.isEmpty()) {
            System.out.println("No matches found!");
        }
        else {
            System.out.println("FILMS WITH ACTOR ID " + id);
            System.out.printf("%n%-5s %-20s %-140s %-15s %-5s%n", "ID", "Title", "Description", "Release Year", "Length");
            System.out.println("----- -------------------- -------------------------------------------------------------------------------------------------------------------------------------------- --------------- -----");
            for (Film f : films) {
                System.out.printf("%-5s %-20s %-140s %-15s %-5s%n", f.getFilmId(), f.getTitle(), f.getDescription(),
                        f.getReleaseYear(), f.getLength());
            }
            System.out.println("----- -------------------- -------------------------------------------------------------------------------------------------------------------------------------------- --------------- -----");
        }
    }
}