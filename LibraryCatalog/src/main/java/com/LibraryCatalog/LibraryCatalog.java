package com.LibraryCatalog;

import javax.swing.SwingUtilities;

import com.LibraryCatalog.ui.patron.KioskHome;

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