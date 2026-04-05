package com.lexitrace.dao;

import java.sql.*;

public class ProgressDAO {

    private Connection conn;

    public ProgressDAO() throws SQLException {
        conn = DatabaseManager.getConnection();
    }

    // INIT PROGRESS (safe — won't duplicate)
    public void initProgress(int userId, int wordId) throws SQLException {

        String sql = "INSERT IGNORE INTO progress (user_id, word_id) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, wordId);
            ps.executeUpdate();
        }
    }

    // UPDATE PROGRESS AFTER QUIZ
    public void updateProgress(int userId, int wordId, boolean correct) throws SQLException {

        String sqlCorrect = """
            UPDATE progress
            SET mastery_level = mastery_level + 1,
                correct_count = correct_count + 1
            WHERE user_id = ? AND word_id = ?
        """;

        String sqlWrong = """
            UPDATE progress
            SET mastery_level = GREATEST(mastery_level - 1, 0),
                incorrect_count = incorrect_count + 1
            WHERE user_id = ? AND word_id = ?
        """;

        try (PreparedStatement ps = conn.prepareStatement(correct ? sqlCorrect : sqlWrong)) {
            ps.setInt(1, userId);
            ps.setInt(2, wordId);
            ps.executeUpdate();
        }
    }
}
