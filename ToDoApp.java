package com.todolistapp;

import javafx.application.Application;
import javafx.stage.Stage;

public class ToDoApp extends Application {

    private TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        LoginPage loginPage = new LoginPage(primaryStage, taskManager);
        primaryStage.setTitle("To-Do List App");
        primaryStage.setScene(loginPage.getScene());
        primaryStage.show();
    }
}
