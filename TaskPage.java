package com.todolistapp;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TaskPage {
    private Scene scene;

    public TaskPage(Stage stage, TaskManager taskManager) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        ListView<String> taskListView = new ListView<>();
        taskListView.getItems().addAll(taskManager.getTasks());

        TextField newTaskField = new TextField();
        Button addButton = new Button("Add Task");
        addButton.setOnAction(e -> {
            String task = newTaskField.getText();
            if (!task.isEmpty()) {
                taskManager.addTask(task);
                taskListView.getItems().add(task);
                newTaskField.clear();
            }
        });

        Button deleteButton = new Button("Delete Task");
        deleteButton.setOnAction(e -> {
            String selectedTask = taskListView.getSelectionModel().getSelectedItem();
            if (selectedTask != null) {
                taskManager.deleteTask(selectedTask);
                taskListView.getItems().remove(selectedTask);
            }
        });

        Button completeButton = new Button("Complete Task");
        completeButton.setOnAction(e -> {
            String selectedTask = taskListView.getSelectionModel().getSelectedItem();
            if (selectedTask != null) {
                taskManager.completeTask(selectedTask);
                taskListView.getItems().remove(selectedTask);
            }
        });

        layout.getChildren().addAll(newTaskField, addButton, deleteButton, completeButton, taskListView);
        scene = new Scene(layout, 400, 300);
    }

    public Scene getScene() {
        return scene;
    }
}
