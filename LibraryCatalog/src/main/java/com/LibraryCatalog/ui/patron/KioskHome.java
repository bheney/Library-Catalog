package main.java.com.LibraryCatalog.ui.patron;

import main.java.com.LibraryCatalog.settings.AppSettings;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class KioskHome {
    private JLabel lblSignIn;
    private JLabel lblCardNumber;
    private JTextField textCardNubmer;
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
        // Create the list of Search Criteria
        criteria = new ArrayList<>();
        criteria.add(initialSearchField);

        // When the Media type changes
        // TODO Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException: Cannot invoke "javax.swing.JComboBox.addActionListener(java.awt.event.ActionListener)" because "this.comboMediaType" is null
        comboMediaType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AppSettings.availableMedia mediaSelection = (AppSettings.availableMedia) comboMediaType.getSelectedItem();
                setActiveMediaType(mediaSelection);
            }
        });

        // Add a new search criteria
        btnAddCriterion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                scrollSearchCriteria.add(new JPanel());
                scrollSearchCriteria.revalidate();
                scrollSearchCriteria.repaint();
            }
        });
    }

    private void createUIComponents() {
        comboMediaType = new JComboBox<>(AppSettings.availableMedia.values());
        comboFieldSelect = new JComboBox<>();
    }

    private void setActiveMediaType(AppSettings.availableMedia newMediaType) {
        // Update the state
        activeMediaType = newMediaType;

        // Update the search field ComboBoxes
        for (JPanel panel : criteria){
            // Get the ComboBox instance
            JComboBox<String> box = null;
            for (Component component : panel.getComponents()) {
                if (component instanceof JComboBox) box = (JComboBox<String>) component;
            }
            // Store the current selection
            assert box != null;
            String currentSelection = (String) box.getSelectedItem();
            // Clear the old fields
            box.removeAllItems();
            // Add the new fields
            for (String field : activeMediaType.searchFields) {
                box.addItem(field);
            }
            // Restore the previous item
            if (currentSelection !=null && activeMediaType.searchFields.contains(currentSelection)){
                box.setSelectedItem(currentSelection);
            }
        }
    }

    private void addSearchCriterion() {
        // Create and build the new panel
        JPanel newPanel = new JPanel();
        JTextField newTxtField = new JTextField();
        JComboBox<String> newComboBox = new JComboBox<>();
        newPanel.add(newTxtField);
        newPanel.add(newComboBox);
        for (String field : activeMediaType.searchFields) {
            newComboBox.addItem(field);
        }

        // Add the search panel to the tracker
        criteria.add(newPanel);
    }
}


