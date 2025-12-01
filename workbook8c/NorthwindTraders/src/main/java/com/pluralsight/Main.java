package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // load MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // open connection
        // DriverManager = classic/older way
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind",
                "root",
                "insertpasswordhere");

        // create statement
        Statement statement = connection.createStatement();

        // define query
        String query = "SELECT * FROM northwind.products";

        // execute query
        ResultSet resultSet = statement.executeQuery(query);

        // process results
        System.out.println("*** Northwind Products (ID & Name) ***");
        while (resultSet.next()) {
            String productName = resultSet.getString("ProductName");
            int productId = resultSet.getInt("ProductId");
            System.out.println("[" + productId + "] " + productName);
        }

        // close connection
        connection.close();
    }
}
