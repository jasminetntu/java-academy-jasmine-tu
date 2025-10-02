/**
 * Neighborhood Library
 * Workshop 2w
 * 10/03/2025
 * @author Jasmine Tu
 */
package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Book[] library = initializeLibrary();

        System.out.println("*** Welcome to the Neighborhood Library! ***");

        String choice = "";
        while (!choice.equalsIgnoreCase("x")) {
            printHomeScreen();
            choice = scnr.nextLine();

            switch (choice) { //available books
                case "1":
                    showAvailableBooks(scnr, library);
                    break;
                case "2": //checked out books
                    showCheckedOutBooks(scnr, library);
                    break;
                case "x": //exits loop
                    System.out.println("Thank you for visiting! Keep reading. :)");
                    break;
                default: //invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scnr.close();
    }

    /**
     * Initializes an array of 20 Books.
     * @return an array of Books
     */
    public static Book[] initializeLibrary() {
        return new Book[] {
                //20 books -> id, isbn, title
                new Book(1, "9780544336261", "The Giver"),
                new Book(2, "9781954839243", "The Great Gatsby"),
                new Book(3, "9780316769174", "The Catcher in the Rye"),
                new Book(4, "9780452262935", "1984"),
                new Book(5, "9780141439518", "Pride and Prejudice"),
                new Book(6, "9780393356250", "The Odyssey"),
                new Book(7, "9781365854088", "The Iliad"),
                new Book(8, "9781451673319", "Fahrenheit 451"),
                new Book(9, "9780060935467", "To Kill a Mockingbird"),
                new Book(10, "9781594631931", "The Kite Runner"),
                new Book(11, "9781594483851", "A Thousand Splendid Suns"),
                new Book(12, "9780525432722", "Someone Who Will Love You in All Your Damaged Glory: Stories"),
                new Book(13, "9781982185824", "I'm Glad My Mom Died"),
                new Book(14, "9780679734505", "Crime and Punishment"),
                new Book(15, "9781335430991", "Before the Coffee Gets Cold"),
                new Book(16, "9780525562047", "On Earth We're Briefly Gorgeous"),
                new Book(17, "9780618706419", "The Things They Carried"),
                new Book(18, "9780375842207", "The Book Thief"),
                new Book(19, "9780143127550", "Everything I Never Told You"),
                new Book(20, "9780062060624", "The Song of Achilles"),
        };
    }

    /**
     * Prints home screen with list of options/actions.
     */
    public static void printHomeScreen() {
        System.out.print("""
                \n--------------------------------
                What would you like to do?
                    1. Show Available Books
                    2. Show Checked Out Books
                    X. Exit
                Enter choice (1, 2, X):\s""");
    }

    /**
     * Displays list of all books (ID, ISBN, Title) that are not checked out.
     * Prompts user check out book w/ ID or return to home screen.
     * If user wants to check out book, prompts for name then checks out book.
     * @param scnr Scanner object
     * @param library array of Books
     */
    public static void showAvailableBooks(Scanner scnr, Book[] library) {
        //print available books
        System.out.println("\n----- Available Books -----");
        for (Book book : library) {
            if (!book.isCheckedOut()) {
                System.out.println(book);
            }
        }

        //vars for choices
        boolean isValid = false;
        String choice;
        String name;
        Book temp;

        //keep looping while user's input is invalid
        while (!isValid) {
            System.out.print("\nEnter book ID to check out, or 'R' to return to home: ");
            choice = scnr.nextLine();

            if (choice.equalsIgnoreCase("r")) {
                isValid = true; //if r, then return to home screen
            }
            else {
                try { //otherwise, check out book
                    temp = library[Integer.parseInt(choice) - 1];

                    //if id is valid & book is available, get full name
                    if (!temp.isCheckedOut()) {
                        System.out.print("Enter your full name: ");
                        name = scnr.nextLine();

                        temp.checkOut(name);
                        isValid = true;
                    }
                    else { //if book is unavailable
                        System.out.println("This book is already checked out. Please try again.");
                    }
                } catch (Exception e) { //if invalid id, keep looping
                    System.out.println("Invalid ID. Please try again.");
                }
            }
        }
    }

    /**
     * Displays list of all books (ID, ISBN, Title, Name of Lendee) that are checked out.
     * Prompts user to choose to check in book or return to home screen.
     * If user wants to check in, prompts for ID of book then checks in book.
     * @param scnr Scanner object
     * @param library array of Books
     */
    public static void showCheckedOutBooks(Scanner scnr, Book[] library) {
        //print unavailable books
        System.out.println("\n----- Checked Out Books -----");
        for (Book book : library) {
            if (book.isCheckedOut()) {
                System.out.println(book);
            }
        }

        //vars for choices
        boolean isValid = false;
        String choice;
        int id;
        Book temp;

        //keep looping while user's input is invalid
        while (!isValid) {
            System.out.print("\nEnter 'C' to check in book or 'R' to return to home: ");
            choice = scnr.nextLine();

            if (choice.equalsIgnoreCase("r")) {
                isValid = true; //if r, then return to home screen
            }
            else if (choice.equalsIgnoreCase("c")){
                //if c, check in book
                try {
                    //get valid id
                    System.out.print("Enter book ID: ");
                    id = Integer.parseInt(scnr.nextLine().trim());
                    temp = library[id - 1];

                    if (temp.isCheckedOut()) {
                        temp.checkIn();
                        isValid = true;
                    }
                    else {
                        System.out.println("This book is not checked out. Please try again.");
                    }
                } catch (Exception e) { //if invalid, keep looping
                    System.out.println("Invalid ID. Please try again.");
                }
            }
            else { //if not c or r, then invalid
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}