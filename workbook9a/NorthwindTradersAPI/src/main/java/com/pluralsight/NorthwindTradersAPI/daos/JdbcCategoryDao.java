package com.pluralsight.NorthwindTradersAPI.daos;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCategoryDao implements CategoryDao {
    private DataSource dataSource;

    @Autowired
    public JdbcCategoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();

        String sql = "SELECT categoryId, categoryName FROM northwind.categories;";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("categoryId"),
                        rs.getString("categoryName")
                );
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    @Override
    public Category getById(int id) {
        Category category = null;

        String sql = "SELECT categoryId, categoryName FROM northwind.categories WHERE categoryId = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    category = new Category(rs.getInt("cateogryId"),
                            rs.getString("categoryName"));
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return category;
    }

    @Override
    public Category insert(Category category) {
        String sql = """
                INSERT INTO northwind.categories (categoryName)
                VALUES (?);""";

        int generatedKey = -1;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, category.getCategoryName());

            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    generatedKey = keys.getInt(1);
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Something went wrong when inserting category.");
            e.printStackTrace();
        }

        return new Category(generatedKey, category.getCategoryName());
    }

    @Override
    public void update(int id, Category category) {
        String sql = """
                UPDATE northwind.categories
                SET categoryName = ?
                WHERE categoryId = ?;""";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, category.getCategoryName());
            ps.setInt(2, id);

            ps.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Something went wrong when updating category.");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = """
                DELETE FROM northwind.categories
                WHERE categoryId = ?;""";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            ps.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Something went wrong when deleting category.");
            e.printStackTrace();
        }
    }
}
