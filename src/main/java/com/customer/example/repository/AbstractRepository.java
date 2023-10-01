package com.customer.example.repository;

import com.customer.example.exception.SqlException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public abstract class AbstractRepository {

    private Connection connection;
    private InputStream fileInputStream;
    private Properties properties;

    // Return connection to database
    public Connection getConnection() {
        if (connection != null)
            return connection;

        if (properties == null) {
            try {
                fileInputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
                properties = new Properties();

                properties.load(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        String url = properties.getProperty("database.properties.url");
        String username = properties.getProperty("database.properties.username");
        String password = properties.getProperty("database.properties.password");

        try {
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected ResultSet prepareStatement(String sql) {
        try (Connection connection = this.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException e) {
            throw new SqlException(e.getMessage());
        }
    }

}
