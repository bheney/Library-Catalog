package com.LibraryCatalog.ui.patron;

import javax.swing.*;
import com.LibraryCatalog.settings.AppSettings;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class KioskHome {
    private JLabel lblSignIn;
    private JLabel lblCardNumber;
    private JTextField textCardNumber;
    private JLabel lblPassword;
    private JPasswordField pswdPassword;
    private JButton btnSignIn;
    private JLabel lblSearch;
    private JComboBox<AppSettings.availableMedia> comboMediaType;
    private JComboBox<String> comboFieldSelect;
    private JButton btnSearch;
    private JButton btnAddCriterion;
    private JScrollPane scrollSearchCriteria;
    private JPanel initialSearchField;

    private AppSettings.availableMedia activeMediaType;
    private List<JPanel> criteria;

    public KioskHome() {
        // Initialize the list of Search Criteria
        criteria = new ArrayList<>();
        criteria.add(initialSearchField);

        // Call createUIComponents to initialize Swing components
        createUIComponents();

        // When the Media type changes
        comboMediaType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AppSettings.availableMedia mediaSelection = comboMediaType.getItemAt(comboMediaType.getSelectedIndex());
                setActiveMediaType(mediaSelection);
            }
        });

        // Add a new search criterion
        btnAddCriterion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addSearchCriterion();
            }
        });
    }

    private void createUIComponents() {
        comboMediaType = new JComboBox<>(AppSettings.availableMedia.values());
        comboFieldSelect = new JComboBox<>();
    }

    private void setActiveMediaType(AppSettings.availableMedia newMediaType) {
        activeMediaType = newMediaType;
        // Update the search field ComboBoxes
        for (JPanel panel : criteria) {
            JComboBox<String> box = null;
            for (Component component : panel.getComponents()) {
                if (component instanceof JComboBox) box = (JComboBox<String>) component;
            }
            if (box != null) {
                String currentSelection = (String) box.getSelectedItem();
                box.removeAllItems();
                for (String field : activeMediaType.searchFields) {
                    box.addItem(field);
                }
                if (currentSelection != null && activeMediaType.searchFields.contains(currentSelection)) {
                    box.setSelectedItem(currentSelection);
                }
            }
        }
    }

    private void addSearchCriterion() {
        JPanel newPanel = new JPanel();
        JTextField newTxtField = new JTextField();
        JComboBox<String> newComboBox = new JComboBox<>();
        newPanel.add(newTxtField);
        newPanel.add(newComboBox);
        for (String field : activeMediaType.searchFields) {
            newComboBox.addItem(field);
        }
        criteria.add(newPanel);
        scrollSearchCriteria.add(newPanel);
        scrollSearchCriteria.revalidate();
        scrollSearchCriteria.repaint();
    }
}
