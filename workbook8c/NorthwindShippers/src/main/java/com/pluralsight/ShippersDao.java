package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShippersDao {
    private final BasicDataSource dataSource;

    public ShippersDao(String username, String password) {
        dataSource = new BasicDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    // *** ACCESSORS ***

    public List<Shipper> getAllShippers() {
        List<Shipper> shippers = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("""
                     SELECT * FROM northwind.shippers;""")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Shipper temp = new Shipper(resultSet.getLong("shipperId"), resultSet.getString("companyName"), resultSet.getString("phone"));
                    shippers.add(temp);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return shippers;
    }

    // *** MUTATORS ***

    public void addShipper(String companyName, String phoneNumber) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("""
                     INSERT INTO northwind.shippers (companyName, phone)
                     VALUES (?, ?);""", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, phoneNumber);

            // execute query & print rows
            int rows = preparedStatement.executeUpdate();
            System.out.printf("Rows updated: %d%n", rows);

            // print primary keys
            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                while (keys.next()) {
                    System.out.printf("Key %d was added.%n", keys.getLong(1));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateShipper(long id, String phoneNumber) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("""
                     UPDATE northwind.shippers SET phone = ?
                     WHERE shipperId = ?;""")) {
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.setLong(2, id);

            // execute query & display rows updated
            int rows = preparedStatement.executeUpdate();
            System.out.printf("Rows updated: %d%n", rows);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeShipper(long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("""
                     DELETE FROM northwind.shippers
                     WHERE shipperId = ?;""")) {
            preparedStatement.setLong(1, id);

            // execute query & display rows updated
            int rows = preparedStatement.executeUpdate();
            System.out.printf("Rows updated: %d%n", rows);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
