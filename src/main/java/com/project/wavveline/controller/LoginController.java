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
import java.sql.ResultSet;

public class LoginController {

    @FXML
    private TextField userField;
    @FXML
    private PasswordField passwordField;

    public void loginHandler(ActionEvent actionEvent) {
        String username = userField.getText();
        String password = passwordField.getText();
        UserDAO userDAO = new UserDAO();

        try {
           ResultSet resultSet = userDAO.findUser(username, password);

            if (resultSet !=null && resultSet.next()){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/wavveline/Messenger.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();

                String name = resultSet.getString("name");
                String title = resultSet.getString("title");
                System.out.println("Login Sucessful!");
                System.out.println("Welcome " + name + " - " + title);
                Stage currentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
                currentStage.close();
                stage.setTitle("WavVeLine Messenger");
                stage.setScene(scene);
                stage.show();

            } else {
                System.out.println("Unable to login!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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
