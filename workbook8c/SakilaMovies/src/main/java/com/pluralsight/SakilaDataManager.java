package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SakilaDataManager {
    private final BasicDataSource dataSource;

    public SakilaDataManager(String username, String password) throws SQLException {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

//        MysqlDataSource ds = new MysqlDataSource();
//        ds.setServerName("localhost");
//        ds.setPortNumber(3306);
//        ds.setDatabaseName("sakila");
//        ds.setUser("root");
//        ds.setPassword("Feroze1975$");
//
//        // extra options same as your URL:
//        ds.setUseSSL(false);
//        ds.setAllowPublicKeyRetrieval(true);
//        ds.setServerTimezone("UTC");
//
//        this.dataSource = ds;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public List<Actor> getActorsByName(String firstName, String lastName) {
        List<Actor> actors = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                             """
                                 SELECT actor_id, first_name, last_name FROM sakila.actor
                                 WHERE first_name LIKE ? AND last_name LIKE ?
                                 ORDER BY actor_id""")) {

            // set params
            preparedStatement.setString(1, "%" + firstName + "%" );
            preparedStatement.setString(2, "%" + lastName + "%");

            // execute the query
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Actor temp = new Actor(resultSet.getInt("actor_id"),
                            resultSet.getString("first_name"), resultSet.getString("last_name"));
                    actors.add(temp);
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Something went wrong while processing database.");
            e.printStackTrace();
        }

        return actors;
    }

    public List<Film> getFilmsByActorId(int id) {
        List<Film> films = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     """
                         SELECT f.film_id, f.title, f.description, f.release_year, f.length
                            FROM sakila.film as f
                         INNER JOIN sakila.film_actor as fa
                            ON f.film_id = fa.film_id
                         INNER JOIN sakila.actor as a
                            ON a.actor_id = fa.actor_id
                         WHERE a.actor_id = ?""")) {

            // set params
            preparedStatement.setInt(1, id);

            // execute the query
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Film temp = new Film(resultSet.getInt("film_id"), resultSet.getString("title"),
                            resultSet.getString("description"), resultSet.getInt("release_year"),
                            resultSet.getInt("length"));
                    films.add(temp);
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Something went wrong while processing database.");
            e.printStackTrace();
        }

        return films;
    }
}
