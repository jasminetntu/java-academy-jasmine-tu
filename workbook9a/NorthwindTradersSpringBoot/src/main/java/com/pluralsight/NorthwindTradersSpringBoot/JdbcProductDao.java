package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component // This DAO will be used as the ProductDao implementation
public class JdbcProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        // Spring injects the configured DataSource and we wrap it in JdbcTemplate
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Maps a row from the Products + Categories join
     * to your Product domain object.
     */
    private static class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            int productId = rs.getInt("ProductID");
            String name = rs.getString("ProductName");
            String category = rs.getString("CategoryName");
            double price = rs.getBigDecimal("UnitPrice").doubleValue();

            return new Product(productId, name, category, price);
        }
    }

    /**
     * Inserts a new Product into the Northwind Products table.
     * CategoryID is resolved from the Categories table using CategoryName.
     * ProductID is AUTO_INCREMENT in the database, so the productId from the
     * object is not used here.
     */
    @Override
    public void add(Product product) {
        String sql = """
                INSERT INTO Products
                    (ProductName,
                     CategoryID,
                     QuantityPerUnit,
                     UnitPrice,
                     UnitsInStock,
                     UnitsOnOrder,
                     ReorderLevel,
                     Discontinued)
                VALUES
                    (
                        ?,
                        (SELECT CategoryID
                           FROM Categories
                          WHERE CategoryName = ?
                          LIMIT 1),
                        '',
                        ?,
                        0,
                        0,
                        0,
                        0
                    )
                """;

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            // 1 = ProductName
            ps.setString(1, product.getName());
            // 2 = CategoryName (used to look up CategoryID)
            ps.setString(2, product.getCategory());
            // 3 = UnitPrice
            ps.setBigDecimal(3, BigDecimal.valueOf(product.getPrice()));
            return ps;
        });
    }

    /**
     * Returns all Products, joined with their CategoryName.
     */
    @Override
    public List<Product> getAll() {
        String sql = """
                SELECT
                    p.ProductID,
                    p.ProductName,
                    p.UnitPrice,
                    COALESCE(c.CategoryName, '(no category)') AS CategoryName
                FROM Products p
                LEFT JOIN Categories c ON p.CategoryID = c.CategoryID
                ORDER BY p.ProductID
                """;

        return jdbcTemplate.query(connection -> {
            // No parameters here, but still explicitly using PreparedStatement
            PreparedStatement ps = connection.prepareStatement(sql);
            return ps;
        }, new ProductRowMapper());
    }

    @Override
    public void delete(int productId) {
        String sql = """
            UPDATE northwind.products
            SET discontinued = 1
            WHERE productID = ?
            """;

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, productId); // PreparedStatement parameter binding
            return ps;
        });
    }
}