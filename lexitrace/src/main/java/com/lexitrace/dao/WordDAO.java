package com.lexitrace.dao;

import com.lexitrace.model.Word;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WordDAO {

    private Connection conn;

    public WordDAO() throws SQLException {
        conn = DatabaseManager.getConnection();
    }

    public int insertWord(Word word) throws SQLException {

        String sql = "INSERT INTO vocabulary (word, translation, language_pair) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, word.getWord());
            ps.setString(2, word.getTranslation());
            ps.setString(3, word.getLanguagePair());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        }
        return -1;
    }

    public List<Word> getAllWords() throws SQLException {

        List<Word> list = new ArrayList<>();
        String sql = "SELECT * FROM vocabulary";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Word w = new Word(
                        rs.getInt("id"),
                        rs.getString("word"),
                        rs.getString("translation"),
                        rs.getString("language_pair")
                );
                list.add(w);
            }
        }
        return list;
    }

    public List<Word> getAllWordsForUser(int userId) throws SQLException {

        List<Word> list = new ArrayList<>();

        String sql = """
            SELECT v.*
            FROM vocabulary v
            JOIN progress p ON v.id = p.word_id
            WHERE p.user_id = ?
        """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Word w = new Word(
                        rs.getInt("id"),
                        rs.getString("word"),
                        rs.getString("translation"),
                        rs.getString("language_pair")
                );
                list.add(w);
            }
        }
        return list;
    }
}
