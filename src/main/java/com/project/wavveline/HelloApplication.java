package com.project.wavveline;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/wavveline/Login.fxml"));

        if (fxmlLoader.getLocation() == null) {
            System.out.println("Error: FXML file not found.");
            return;
        }

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("WavVeline");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
