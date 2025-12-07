package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // exit if username & password aren't provided
        if (args.length != 2) {
            System.out.println("Application needs two arguments to run: " +
                    "java com.pluralsight.UsingDriverManager <username> <password>");
            System.exit(1);
        }
        String username = args[0]; // otherwise, get CLI args from config
        String password = args[1];

        // create & configure datasource
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        // interact w/ database
        doSimpleQuery(dataSource);
    }

    private static void doSimpleQuery (DataSource dataSource) {
        // create connection and prepared statement
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(
                             """
                                 SELECT first_name, last_name, title FROM sakila.actor
                                 INNER JOIN sakila.film_actor
                                    ON sakila.actor.actor_id = sakila.film_actor.actor_id
                                 INNER JOIN sakila.film
                                    ON sakila.film.film_id = sakila.film_actor.film_id
                                 WHERE first_name LIKE ? AND last_name LIKE ?""")) {

            // Set any required parameters
            Scanner scnr = new Scanner(System.in);
            System.out.print("First Name: ");

            String firstName = scnr.nextLine();
            preparedStatement.setString(1, firstName);

            System.out.print("Last Name: ");

            String lastName = scnr.nextLine();
            preparedStatement.setString(2, lastName);
            // Execute the query

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("Your matches are: \n");
                    // Process the results
                    while (resultSet.next()) {
                        System.out.printf(
                                "first_name = %s, last_name = %s, title = %s;\n",
                                resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("title"));
                    }
                } else {
                    System.out.println("No matches!");
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
        }
    }
}
