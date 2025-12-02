package com.example.property;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
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
                    addPropertyFromInput(dao, scanner);
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
        System.out.println("3. Add a new property");
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
            System.out.println("=== ALL PROPERTIES ===");
            for (Property p : properties) {
                System.out.println(p);
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching properties: " + e.getMessage());
        }
    }

    // Option 2: View all
    private static void viewAvailableProperties(PropertyDao dao) {
        try {
            List<Property> properties = dao.getAvailableProperties();
            if (properties.isEmpty()) {
                System.out.println("No properties found.");
                return;
            }
            System.out.println("=== ALL PROPERTIES ===");
            for (Property p : properties) {
                System.out.println(p);
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching properties: " + e.getMessage());
        }
    }

    // Option 3: Add a property via user input
    private static void addPropertyFromInput(PropertyDao dao, Scanner scanner) {
        try {
            System.out.println("=== ADD NEW PROPERTY ===");
            System.out.print("Type (HOUSE/APARTMENT): ");
            String type = scanner.nextLine().trim().toUpperCase();

            System.out.print("Address: ");
            String address = scanner.nextLine().trim();

            System.out.print("City: ");
            String city = scanner.nextLine().trim();

            System.out.print("Postal code: ");
            String postalCode = scanner.nextLine().trim();

            System.out.print("Bedrooms (int): ");
            int bedrooms = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Bathrooms (int): ");
            int bathrooms = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Square meters (int): ");
            int squareMeters = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Monthly rent (e.g. 1450.00): ");
            double monthlyRent = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Is available? (true/false): ");
            boolean isAvailable = Boolean.parseBoolean(scanner.nextLine().trim());

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
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input. Property not added.");
        } catch (SQLException e) {
            System.out.println("Database error while adding property: " + e.getMessage());
        }
    }
}