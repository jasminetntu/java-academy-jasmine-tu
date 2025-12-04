package com.example.property;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.example.utility.InputValidator;

public class PropertyApp {
    public static void main(String[] args) {
        // TODO: Update to your MySQL configuration
        String url = "jdbc:mysql://localhost:3306/property?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "insert-password-here";

        PropertyDao dao = new PropertyDao(url, user, password);
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    viewAllProperties(dao);
                    break;
                case "2":
                    viewAvailableProperties(dao);
                    break;
                case "3":
                    searchByCity(dao, scanner);
                    break;
                case "4":
                    addPropertyFromInput(dao, scanner);
                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "0":
                    running = false;
                    System.out.println("Exiting app. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("=== PROPERTY MANAGEMENT ===");
        System.out.println("1. View all properties");
        System.out.println("2. View available properties");
        System.out.println("3. Search properties by city");
        System.out.println("4. Add a new property");
        System.out.println("5. Update a property");
        System.out.println("6. Delete a property");
        System.out.println("0. Exit");
    }

    // Option 1: View all
    private static void viewAllProperties(PropertyDao dao) {
        try {
            List<Property> properties = dao.getAllProperties();
            if (properties.isEmpty()) {
                System.out.println("No properties found.");
                return;
            }
            System.out.println("\n=== ALL PROPERTIES ===");
            for (Property p : properties) {
                System.out.println(p);
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching properties: " + e.getMessage());
        }
    }

    // Option 2: View available
    private static void viewAvailableProperties(PropertyDao dao) {
        try {
            List<Property> properties = dao.getAvailableProperties();
            if (properties.isEmpty()) {
                System.out.println("No properties found.");
                return;
            }
            System.out.println("\n=== AVAILABLE PROPERTIES ===");
            for (Property p : properties) {
                System.out.println(p);
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching properties: " + e.getMessage());
        }
    }

    // Option 3: Search by city
    private static void searchByCity(PropertyDao dao, Scanner scanner) {
        try {
            System.out.println("\n=== SEARCH PROPERTIES BY CITY ===");
            System.out.print("Enter city: ");
            String city = scanner.nextLine().trim();

            List<Property> properties = dao.getPropertiesByCity(city);
            if (properties.isEmpty()) {
                System.out.println("No properties in " + city + " found.");
                return;
            }
            System.out.println("\n=== PROPERTIES IN " + city.toUpperCase() + " ===");
            for (Property p : properties) {
                System.out.println(p);
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching properties: " + e.getMessage());
        }
    }

    // Option 4: Add a property via user input
    private static void addPropertyFromInput(PropertyDao dao, Scanner scanner) {
        InputValidator validator = new InputValidator(scanner);

        try {
            System.out.println("\n=== ADD NEW PROPERTY ===");
            String type = validator.getValidType();

            System.out.print("\nAddress: ");
            String address = scanner.nextLine().trim();

            System.out.print("\nCity: ");
            String city = scanner.nextLine().trim();

            System.out.print("\nPostal code: ");
            String postalCode = scanner.nextLine().trim();

            int bedrooms = validator.getInteger("Bedrooms (int): ");

            int bathrooms = validator.getInteger("Bathrooms (int): ");

            int squareMeters = validator.getInteger("Square meters (int): ");

            double monthlyRent = validator.getDouble("Monthly rent (e.g. 1450.00): ");

            boolean isAvailable = validator.getBoolean("Is available? (true/false): ");

            System.out.print("Notes (optional, press Enter to skip): ");
            String notes = scanner.nextLine().trim();
            if (notes.isEmpty()) {
                notes = null;
            }

            Property property = new Property(
                    type,
                    address,
                    city,
                    postalCode,
                    bedrooms,
                    bathrooms,
                    squareMeters,
                    monthlyRent,
                    isAvailable,
                    notes
            );

            int newId = dao.addProperty(property);
            System.out.println("Property added with ID: " + newId);
        } catch (SQLException e) {
            System.out.println("Database error while adding property: " + e.getMessage());
        }
    }
}