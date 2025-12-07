package com.pluralsight;

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

        // load MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");


        boolean running = true;
        try (Scanner scnr = new Scanner(System.in)) {
            Main main = new Main();
            while (running) {
                System.out.print("""
                        What do you want to do?
                            1) Display all products
                            2) Display all customers
                            0) Exit
                        Select an option:\s""");
                String choice = scnr.nextLine().trim().toLowerCase();

                switch (choice) {
                    case "1" -> main.displayProducts(username, password);
                    case "2" -> main.displayCustomers(username, password);
                    case "0" -> {
                        System.out.println("Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Invalid input. Try again!");
                }
            }
        }
    }

    private void displayProducts(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // open connection
            connection = DriverManager.getConnection( // DriverManager = classic/older way
                    "jdbc:mysql://localhost:3306/northwind",
                    username, password);

            // create statement
            preparedStatement = connection.prepareStatement(
                    "SELECT productId, productName, unitPrice, unitsInStock FROM northwind.products " +
                            "ORDER BY productId");

            // execute query
            resultSet = preparedStatement.executeQuery();

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
        catch (SQLException e) {
            System.out.println("Something went wrong while working with database.");
            e.printStackTrace();
        }
        finally {
            // close the resources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void displayCustomers(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // open connection
            connection = DriverManager.getConnection( // DriverManager = classic/older way
                    "jdbc:mysql://localhost:3306/northwind",
                    username, password);

            // create statement
            preparedStatement = connection.prepareStatement(
                    "SELECT contactName, companyName, city, country, phone FROM northwind.customers " +
                            "ORDER BY contactName");

            // execute query
            resultSet = preparedStatement.executeQuery();

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
        catch (SQLException e) {
            System.out.println("Something went wrong while working with database.");
            e.printStackTrace();
        }
        finally {
            // close the resources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
