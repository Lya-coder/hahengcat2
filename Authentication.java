package com.todolistapp;

public class Authentication {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean verify(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}

