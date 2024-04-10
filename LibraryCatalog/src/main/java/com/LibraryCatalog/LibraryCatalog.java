package com.LibraryCatalog;

import com.LibraryCatalog.dao.Database;
import com.LibraryCatalog.settings.UserSettings;

public class LibraryCatalog {
    public static void main(String[] args) {
        Database db = Database.getDatabase();
        UserSettings settings = UserSettings.getSettings();
    }
}