package com.pluralsight;

import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class SakilaDataManager {
    private final DataSource dataSource;

    public SakilaDataManager(String db, String user, String password) throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName("localhost");
        ds.setPortNumber(3306);
        ds.setDatabaseName("northwind");
        ds.setUser("root");
        ds.setPassword("Feroze1975$");

        // extra options same as your URL:
        ds.setUseSSL(false);
        ds.setAllowPublicKeyRetrieval(true);
        ds.setServerTimezone("UTC");

        this.dataSource = ds;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
