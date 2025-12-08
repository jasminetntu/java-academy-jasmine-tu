package com.demo.springdemo;

import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcArtistDao implements ArtistDao {
    private final DataSource dataSource;

    public JdbcArtistDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Artist> getAll() {
        List<Artist> artists = new ArrayList<>();

        String sql = "SELECT id, name, album_title, song_title FROM Artists";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Artist artist = new Artist(
                        rs.getString("name"),
                        rs.getString("album_title"),
                        rs.getString("song_title")
                );
                // if you later add an id field to Artist, set it here
                artists.add(artist);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return artists;
    }

    @Override
    public Artist getById(int id) {
        Artist artist = null;

        String query = "SELECT * FROM springdemo.artists WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    artist = new Artist(resultSet.getString("name"), resultSet.getString("album_title"),
                            resultSet.getString("song_title"));
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return artist;
    }

    @Override
    public int insert(Artist artist) {
        int rows = 0;

        String query = """
                INSERT INTO springdemo.artists (name, album_title, song_title)
                VALUES (?, ?, ?)""";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, artist.getName());
            preparedStatement.setString(2, artist.getAlbumTitle());
            preparedStatement.setString(3, artist.getSongTitle());

            // execute query & print rows
            rows = preparedStatement.executeUpdate();
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

        return rows;
    }

    @Override
    public int update(int id, Artist artist) {
        int rows = 0;
        String query = """
                     UPDATE springdemo.artists SET name = ?, album_title = ?, song_title = ?
                     WHERE id = ?;""";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, artist.getName());
            preparedStatement.setString(2, artist.getAlbumTitle());
            preparedStatement.setString(3, artist.getSongTitle());
            preparedStatement.setLong(4, id);

            // execute query & display rows updated
            rows = preparedStatement.executeUpdate();
            System.out.printf("Rows updated: %d%n", rows);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public int delete(int id) {
        int rows = 0;
        String query = """
                     DELETE FROM springdemo.artists
                     WHERE id = ?;""";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            // execute query & display rows updated
            rows = preparedStatement.executeUpdate();
            System.out.printf("Rows updated: %d%n", rows);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return rows;
    }
}