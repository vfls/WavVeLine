package com.project.wavveline;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Correctly load the FXML file from the resources directory
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/wavveline/Login.fxml"));

        // Check if the FXML file is found (this helps with debugging)
        if (fxmlLoader.getLocation() == null) {
            System.out.println("Error: FXML file not found.");
            return;
        }

        // Load the FXML file into the scene
        Scene scene = new Scene(fxmlLoader.load());

        // Set the stage properties
        stage.setTitle("WavVeline");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
