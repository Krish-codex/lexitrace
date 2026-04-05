package com.lexitrace;

import com.lexitrace.dao.ProgressDAO;
import com.lexitrace.dao.UserDAO;
import com.lexitrace.dao.WordDAO;
import com.lexitrace.model.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        try {
            WordDAO wordDAO = new WordDAO();
            ProgressDAO progressDAO = new ProgressDAO();
            UserDAO userDAO = new UserDAO();

            // Register user (INSERT IGNORE handles duplicate safely)
            userDAO.register("test", "1234");
            User user = userDAO.login("test", "1234");

            if (user == null) {
                System.out.println("Login failed — check credentials.");
            } else {
                System.out.println("Logged in as: " + user.getUsername());

                // Get all vocabulary words
                var words = wordDAO.getAllWords();

                for (var w : words) {
                    // Init progress (safe — INSERT IGNORE skips duplicates)
                    progressDAO.initProgress(user.getId(), w.getId());

                    // Simulate correct answer
                    progressDAO.updateProgress(user.getId(), w.getId(), true);

                    System.out.println("Processed: " + w.getWord());
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        Label label = new Label("LexiTrace Running ✅");
        Scene scene = new Scene(new StackPane(label), 800, 600);

        stage.setScene(scene);
        stage.setTitle("LexiTrace");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
