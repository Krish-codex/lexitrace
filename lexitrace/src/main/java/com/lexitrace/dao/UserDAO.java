package com.lexitrace.dao;

import com.lexitrace.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class UserDAO {

    private Connection conn;

    public UserDAO() throws SQLException {
        conn = DatabaseManager.getConnection();
    }

    // REGISTER WITH HASHING
    public boolean register(String username, String password) throws SQLException {

        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

        String sql = "INSERT IGNORE INTO users (username, password) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, hashed);
            return ps.executeUpdate() > 0;
        }
    }

    // LOGIN WITH HASH CHECK
    public User login(String username, String password) throws SQLException {

        String sql = "SELECT * FROM users WHERE username = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("password");

                if (BCrypt.checkpw(password, storedHash)) {
                    return new User(rs.getInt("id"), rs.getString("username"));
                }
            }
        }
        return null;
    }
}
