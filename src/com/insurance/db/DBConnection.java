//package com.insurance.db;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBConnection {
//    private static final String URL = "jdbc:mysql://localhost:3306/insurance_db";
//    private static final String USER = "root";
//    private static final String PASSWORD = "Mr#bond0025"; // Replace with your actual password
//
//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }
//}
package com.insurance.db;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

    public static Connection getConnection() {
        try {
            // Load properties from the config file
            Properties props = new Properties();
            InputStream input = new FileInputStream("resources/db_config.properties");
            props.load(input);

            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            // Return a new connection each time
            return DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to establish DB connection");
        }
    }
}
