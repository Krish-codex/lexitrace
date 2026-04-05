package com.lexitrace.dao;

import java.sql.*;

public class ProgressDAO {

    private Connection conn;

    public ProgressDAO() throws SQLException {
        conn = DatabaseManager.getConnection();
    }

    public void initProgress(int userId, int wordId) throws SQLException {

        String sql = "INSERT IGNORE INTO progress (user_id, word_id, next_review_at) VALUES (?, ?, NOW())";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, wordId);
            ps.executeUpdate();
        }
    }

    public void updateProgress(int userId, int wordId, int masteryLevel,
                               int correctCount, int incorrectCount) throws SQLException {

        String sql = """
            UPDATE progress
            SET mastery_level = ?,
                correct_count = ?,
                incorrect_count = ?,
                last_reviewed_at = NOW()
            WHERE user_id = ? AND word_id = ?
        """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, masteryLevel);
            ps.setInt(2, correctCount);
            ps.setInt(3, incorrectCount);
            ps.setInt(4, userId);
            ps.setInt(5, wordId);
            ps.executeUpdate();
        }
    }
}
