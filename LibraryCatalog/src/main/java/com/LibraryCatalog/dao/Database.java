package com.LibraryCatalog.dao;

import com.LibraryCatalog.settings.UserSettings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Database {
    private static Database instance;
    private static UserSettings settings;
    private static Connection connection;

    private Database() {
        settings = UserSettings.getSettings();

        // Load the JDBC driver
        try {
            Class.forName(settings.getDBDriver());
        } catch (ClassNotFoundException e) {
            // TODO: Handle this
            e.printStackTrace();
        }

        // Build a JDBC connection
        try {
            connection = DriverManager.getConnection(settings.getDbURL(), settings.getDbUsername(), settings.getDbPassword());
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
}