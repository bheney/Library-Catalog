package main.java.com.LibraryCatalog;

import main.java.com.LibraryCatalog.dao.Database;
import main.java.com.LibraryCatalog.settings.UserSettings;
import main.java.com.LibraryCatalog.ui.patron.KioskHome;

import javax.swing.*;

public class LibraryCatalog {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KioskHome();
            }
        });

    }
}