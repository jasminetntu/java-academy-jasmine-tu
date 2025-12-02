package com.example.property;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyDao {
    private final String url;
    private final String user;
    private final String password;

    public PropertyDao(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    // Creates a new DB connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // 1. View all properties
    public List<Property> getAllProperties() throws SQLException {
        List<Property> properties = new ArrayList<>();
        String sql = "SELECT id, type, address, city, postal_code, bedrooms," +
        " bathrooms, square_meters, monthly_rent, is_available, notes " +
        "FROM property.PropertyTb";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Property p = new Property(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("postal_code"),
                        rs.getInt("bedrooms"),
                        rs.getInt("bathrooms"),
                        rs.getInt("square_meters"),
                        rs.getDouble("monthly_rent"),
                        rs.getBoolean("is_available"),
                        rs.getString("notes")
                );
                properties.add(p);
            }
        }
        return properties;
    }

    // 2. Add new property – returns generated id
    public int addProperty(Property property) throws SQLException {
        String sql = "INSERT INTO Property " +
                "(type, address, city, postal_code, bedrooms, bathrooms, " +
                " square_meters, monthly_rent, is_available, notes) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, property.getType());
            stmt.setString(2, property.getAddress());
            stmt.setString(3, property.getCity());
            stmt.setString(4, property.getPostalCode());
            stmt.setInt(5, property.getBedrooms());
            stmt.setInt(6, property.getBathrooms());
            stmt.setInt(7, property.getSquareMeters());
            stmt.setDouble(8, property.getMonthlyRent());
            stmt.setBoolean(9, property.isAvailable());
            stmt.setString(10, property.getNotes());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Inserting property failed, no rows affected.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // new ID
                } else {
                    throw new SQLException("Inserting property failed, no ID obtained.");
                }
            }
        }
    }

}