package com.pluralsight.NorthwindTradersAPI.daos;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {
    private DataSource dataSource;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();

        String sql = "SELECT productId, productName, categoryId, unitPrice FROM northwind.products;";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getInt("categoryId"),
                        rs.getInt("unitPrice")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Product getById(int id) {
        Product product = null;

        String sql = "SELECT productId, productName, categoryId, unitPrice FROM northwind.products WHERE productId = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    product = new Product(
                            rs.getInt("productId"),
                            rs.getString("productName"),
                            rs.getInt("categoryId"),
                            rs.getInt("unitPrice"));
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return product;
    }

    @Override
    public Product insert(Product product) {
        String sql = """
                INSERT INTO northwind.products (productName, categoryId, unitPrice)
                VALUES (?, ?, ?);""";

        int generatedKey = -1;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getCategoryId());
            ps.setDouble(3, product.getUnitPrice());

            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    generatedKey = keys.getInt(1);
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Something went wrong when inserting product.");
            e.printStackTrace();
        }

        return new Product((int) generatedKey, product.getProductName(), product.getCategoryId(), product.getUnitPrice());
    }

    @Override
    public void update(int id, Product product) {
        String sql = """
                UPDATE northwind.products
                SET productName = ?, categoryId = ?, unitPrice = ?
                WHERE productId = ?;""";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getCategoryId());
            ps.setDouble(3, product.getUnitPrice());
            ps.setInt(4, id);

            ps.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Something went wrong when updating product.");
            e.printStackTrace();
        }
    }
}
