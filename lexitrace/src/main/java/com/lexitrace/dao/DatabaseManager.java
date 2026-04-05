package com.lexitrace.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/lexitrace";
    private static final String USER = "root";
    private static final String PASSWORD = "7582728371@Sk";

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ MySQL Connected!");
        }
        return connection;
    }
}
