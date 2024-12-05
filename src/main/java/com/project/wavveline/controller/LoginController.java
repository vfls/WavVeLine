package com.project.wavveline.controller;

import com.project.wavveline.dao.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField userField;
    @FXML
    private PasswordField passwordField;

    public void loginHandler(ActionEvent actionEvent) {
        String username = userField.getText();
        String password = passwordField.getText();
        UserDAO userDAO = new UserDAO();

        userDAO.findUser(username, password);


    }

    public void registerHandler(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/wavveline/Registration.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();

            Stage currentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();
            stage.setTitle("Create Account");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException("Unable to load account creation window: " + e.getMessage(), e);
        }
    }
}
