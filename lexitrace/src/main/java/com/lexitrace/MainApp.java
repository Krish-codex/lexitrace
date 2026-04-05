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

            userDAO.register("test", "1234");
            User user = userDAO.login("test", "1234");

            if (user == null) {
                System.out.println("login failed");
            } else {
                System.out.println("logged in: " + user.getUsername());

                var allWords = wordDAO.getAllWords();
                for (var w : allWords) {
                    progressDAO.initProgress(user.getId(), w.getId());
                }

                var userWords = wordDAO.getAllWordsForUser(user.getId());
                for (var w : userWords) {
                    progressDAO.updateProgress(user.getId(), w.getId(), 1, 1, 0);
                    System.out.println("done: " + w.getWord());
                }
            }

        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            e.printStackTrace();
        }

        Label label = new Label("LexiTrace");
        Scene scene = new Scene(new StackPane(label), 800, 600);
        stage.setScene(scene);
        stage.setTitle("LexiTrace");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
