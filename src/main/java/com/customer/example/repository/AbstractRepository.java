package com.customer.example.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class AbstractRepository {

    private Connection connection;
    private FileInputStream fileInputStream;
    private Properties properties;

    // Return connection to database
    public Connection getConnection() {
        if (connection != null)
            return connection;

        if (properties == null) {
            try {
                fileInputStream = new FileInputStream("application.properties");
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

}
