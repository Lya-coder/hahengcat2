package com.todolistapp;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginPage {
    private Scene scene;

    public LoginPage(Stage stage, TaskManager taskManager) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (Authentication.verify(username, password)) {
                TaskPage taskPage = new TaskPage(stage, taskManager);
                stage.setScene(taskPage.getScene());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid username or password.");
                alert.showAndWait();
            }
        });

        layout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton);
        scene = new Scene(layout, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }
}
