package com.project.wavveline.controller;

import com.project.wavveline.dao.UserDAO;
import com.project.wavveline.entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {
    @FXML
    private TextField userRField;

    @FXML
    private TextField passwordRField;

    @FXML
    private TextField emailRField;

    @FXML
    private TextField titleRField;

    @FXML
    private TextField nameRField;

    public void backHandler(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/wavveline/Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();

            Stage currentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();
            stage.setTitle("Back to Login");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException("Unable to load window: " + e.getMessage(), e);
        }
    }

    public boolean accountHandler(ActionEvent actionEvent) {
        String name = nameRField.getText();
        String password = passwordRField.getText();
        String email = emailRField.getText();
        String title = titleRField.getText();
        String username = userRField.getText();
        User user = new User(name, username, password, email, title);

        if (name.isEmpty() || username.isEmpty() || password.isEmpty() || email.isEmpty() || title.isEmpty()) {
            System.out.println("All fields are required.");
            return false;
        }
        try {
            UserDAO userDAO = new UserDAO();
            boolean isCreated = userDAO.createAccount(user);

            if (isCreated) {
                System.out.println("Account created successfully!");
                backHandler(actionEvent);
                return true;
            } else {
                System.out.println("Account creation failed. Please try again.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while creating the account: " + e.getMessage());
        }
        return false;
    }
}
