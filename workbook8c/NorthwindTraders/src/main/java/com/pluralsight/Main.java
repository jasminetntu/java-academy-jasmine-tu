package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
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

        // open connection
        Connection connection = DriverManager.getConnection( // DriverManager = classic/older way
                "jdbc:mysql://localhost:3306/northwind",
                username, password);

        // create statement
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT productId, productName, unitPrice, unitsInStock FROM northwind.products " +
                        "ORDER BY productId");

        // execute query
        ResultSet resultSet = preparedStatement.executeQuery();

        // process results
        System.out.println("*** Northwind Products ***");
        System.out.println(String.format("%-4s %-40s %-7s %-6s%n", "Id", "Name", "Price", "Stock") +
                "---- ---------------------------------------- ------- ------");
        while (resultSet.next()) {
            int productId = resultSet.getInt("productId");
            String productName = resultSet.getString("productName");
            String unitPrice = String.format("%.2f", resultSet.getDouble("unitPrice"));
            int unitsInStock = resultSet.getInt("unitsInStock");
            System.out.printf("%-4s %-40s %-7s %-6d%n", productId, productName, unitPrice, unitsInStock);
        }

        // close the resources
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
