package com.LibraryCatalog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Pattern;

import com.LibraryCatalog.settings.AppSettings;
import com.LibraryCatalog.settings.UserSettings;

public class Database {
    private static Database instance;
    private static final UserSettings userSettings = UserSettings.getSettings();
    private static final AppSettings appSettings = AppSettings.getSettings();
    private static Connection connection;

    private Database() {

        // Load the JDBC driver
        try {
            Class.forName(userSettings.getDBDriver());
        } catch (ClassNotFoundException e) {
            // TODO: Handle this
            e.printStackTrace();
        }

        // Build a JDBC connection
        try {
            connection = DriverManager.getConnection(userSettings.getDbURL(), userSettings.getDbUsername(), userSettings.getDbPassword());
        } catch (SQLException e) {
            // TODO: Handle this
            e.printStackTrace();
        }

    }


    public static Database getDatabase() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public static String sanitize(String input){
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9\\s]");
        return pattern.matcher(input).replaceAll("");
    }
}