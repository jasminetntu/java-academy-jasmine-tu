package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        // exit if username & password aren't provided
        if (args.length != 2) {
            System.out.println("Application needs two arguments to run: " +
            "java com.pluralsight.UsingDriverManager <username> <password>");
            System.exit(1);
        }
        String username = args[0]; // otherwise, get CLI args from config
        String password = args[1];

        // create data source
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        boolean running = true;
        try (Scanner scnr = new Scanner(System.in)) {
            Main main = new Main();
            while (running) {
                System.out.print("""
                        What do you want to do?
                            1) Display all products
                            2) Display all customers
                            3) Display all categories
                            0) Exit
                        Select an option:\s""");
                String choice = scnr.nextLine().trim().toLowerCase();

                switch (choice) {
                    case "1" -> main.displayProducts(dataSource);
                    case "2" -> main.displayCustomers(dataSource);
                    case "3" -> {
                        main.displayCategories(dataSource);
                        main.displayProductsFromCategory(dataSource, scnr);
                    }
                    case "0" -> {
                        System.out.println("Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Invalid input. Try again!");
                }
            }
        }
    }

    private void displayProducts(BasicDataSource dataSource) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT productId, productName, unitPrice, unitsInStock FROM northwind.products " +
                     "ORDER BY productId")) {
            // execute query
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                // process results
                System.out.println("\n*** Northwind Products ***");
                System.out.printf("%-4s %-40s %-7s %-6s%n", "Id", "Name", "Price", "Stock");
                System.out.println("---- ---------------------------------------- ------- ------");

                while (resultSet.next()) {
                    int productId = resultSet.getInt("productId");
                    String productName = resultSet.getString("productName");
                    String unitPrice = String.format("%.2f", resultSet.getDouble("unitPrice"));
                    int unitsInStock = resultSet.getInt("unitsInStock");
                    System.out.printf("%-4s %-40s %-7s %-6d%n", productId, productName, unitPrice, unitsInStock);
                }
                System.out.println("---- ---------------------------------------- ------- ------\n");
            }
        }
        catch (SQLException e) {
            System.out.println("Something went wrong while working with database.");
            e.printStackTrace();
        }
    }

    private void displayCustomers(BasicDataSource dataSource) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT contactName, companyName, city, country, phone FROM northwind.customers " +
                     "ORDER BY country")) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // process results
                System.out.println("\n*** Northwind Customers ***");
                System.out.printf("%-30s %-40s %-20s %-15s %-15s%n",
                        "Contact Name", "Company Name", "City", "Country", "Phone");
                System.out.println("------------------------------ ---------------------------------------- -------------------- --------------- ---------------");

                while (resultSet.next()) {
                    String contactName = resultSet.getString("contactName");
                    String companyName = resultSet.getString("companyName");
                    String city = resultSet.getString("city");
                    String country = resultSet.getString("country");
                    String phone = resultSet.getString("phone");
                    System.out.printf("%-30s %-40s %-20s %-15s %-15s%n", contactName, companyName, city, country, phone);
                }
                System.out.println("------------------------------ ---------------------------------------- -------------------- --------------- ---------------\n");
            }
        }
        catch (SQLException e) {
            System.out.println("Something went wrong while working with database.");
            e.printStackTrace();
        }
    }

    private void displayCategories(BasicDataSource dataSource) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT categoryId, categoryName FROM northwind.categories " +
                             "ORDER BY categoryId")) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("\n*** Northwind Categories ***");
                System.out.printf("%-5s %-15s%n", "Id", "Name");
                System.out.println("----- ---------------");

                while (resultSet.next()) {
                    String categoryId = resultSet.getString("categoryId");
                    String categoryName = resultSet.getString("categoryName");
                    System.out.printf("%-5s %-15s%n", categoryId, categoryName);
                }
                System.out.println("----- ---------------\n");
            }
        }
        catch (SQLException e) {
            System.out.println("Something went wrong while opening connection.");
            e.printStackTrace();
        }
    }

    private void displayProductsFromCategory(BasicDataSource dataSource, Scanner scnr) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT productId, productName, unitPrice, unitsInStock FROM northwind.products " +
                             "WHERE categoryId = ? ORDER BY productId"
             )) {
            System.out.print("Enter category ID to search products by: ");
            int categoryId = Integer.parseInt(scnr.nextLine());
            preparedStatement.setInt(1, categoryId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("\n*** Northwind Products by Category ***");
                System.out.printf("%-4s %-40s %-7s %-6s%n", "Id", "Name", "Price", "Stock");
                System.out.println("---- ---------------------------------------- ------- ------");

                while (resultSet.next()) {
                    int productId = resultSet.getInt("productId");
                    String productName = resultSet.getString("productName");
                    String unitPrice = String.format("%.2f", resultSet.getDouble("unitPrice"));
                    int unitsInStock = resultSet.getInt("unitsInStock");
                    System.out.printf("%-4s %-40s %-7s %-6d%n", productId, productName, unitPrice, unitsInStock);
                }
                System.out.println("---- ---------------------------------------- ------- ------\n");
            }
        }
        catch (SQLException e) {
            System.out.println("Something went wrong while preparing query.");
            e.printStackTrace();
        }
        catch (NumberFormatException e) {
            System.out.println("Category ID must be an integer.\n");
        }
    }
}
