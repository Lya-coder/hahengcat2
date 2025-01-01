package com.todolistapp;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String TASKS_FILE = "tasks.txt";
    private static final String COMPLETED_TASKS_FILE = "completed.txt";

    public List<String> loadTasks() {
        return loadFromFile(TASKS_FILE);
    }

    public void saveTasks(List<String> tasks) {
        saveToFile(TASKS_FILE, tasks);
    }

    public void saveCompletedTasks(List<String> tasks) {
        saveToFile(COMPLETED_TASKS_FILE, tasks);
    }

    private List<String> loadFromFile(String fileName) {
        List<String> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
        }
        return tasks;
    }

    private void saveToFile(String fileName, List<String> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String task : tasks) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + fileName);
        }
    }
}
