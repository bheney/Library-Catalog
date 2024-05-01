package main.java.com.LibraryCatalog.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Pattern;

import main.java.com.LibraryCatalog.settings.AppSettings;
import main.java.com.LibraryCatalog.settings.UserSettings;

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
			// TODO Auto-generated catch block
			System.out.println("Cannot get Database Driver");
		}
        // Build a JDBC connection
        try {
			connection = DriverManager.getConnection(userSettings.getDbURL(), userSettings.getDbUsername(), userSettings.getDbPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot connect to Database");
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
    
    public Connection getConnection() {
    	return connection;
    }
}