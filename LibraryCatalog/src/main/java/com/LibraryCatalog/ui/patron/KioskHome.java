package main.java.com.LibraryCatalog.ui.patron;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import main.java.com.LibraryCatalog.dao.UserDatabase;
import main.java.com.LibraryCatalog.users.User;
import main.java.com.LibraryCatalog.settings.AppSettings;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KioskHome {
    private JFrame frameKioskHome;
    private JComboBox<String> comboMediaType;
    private JTextField textFieldCardNumber;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                KioskHome window = new KioskHome();
                window.frameKioskHome.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public KioskHome() {
        initialize();
    }

    private void initialize() {
        frameKioskHome = new JFrame();
        frameKioskHome.setBounds(100, 100, 450, 300);
        frameKioskHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameKioskHome.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        Box horizontalBoxMainDivider = Box.createHorizontalBox();
        frameKioskHome.getContentPane().add(horizontalBoxMainDivider);

        Box verticalBoxSignOn = Box.createVerticalBox();
        horizontalBoxMainDivider.add(verticalBoxSignOn);

        JLabel lblSignOn = new JLabel("Sign On");
        verticalBoxSignOn.add(lblSignOn);
        lblSignOn.setVerticalAlignment(SwingConstants.TOP);

        JLabel lblCardNo = new JLabel("Card Number:");
        verticalBoxSignOn.add(lblCardNo);

        textFieldCardNumber = new JTextField();
        verticalBoxSignOn.add(textFieldCardNumber);
        textFieldCardNumber.setColumns(10);
        textFieldCardNumber.setText("123456789"); // Example card number

        JLabel lblPassword = new JLabel("Password:");
        verticalBoxSignOn.add(lblPassword);

        passwordField = new JPasswordField();
        verticalBoxSignOn.add(passwordField);
        passwordField.setText("password"); // Example password

        JButton btnSignOn = new JButton("Sign On");
        btnSignOn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Sign-in logic
                String cardNo = textFieldCardNumber.getText();
                String password = new String(passwordField.getPassword());
                if (cardNo.equals("123456789") && password.equals("password")) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password. Try again.");
                }
            }
        });
        verticalBoxSignOn.add(btnSignOn);

        Box verticalBoxSearch = Box.createVerticalBox();
        horizontalBoxMainDivider.add(verticalBoxSearch);

        JLabel lblSearch = new JLabel("Search");
        verticalBoxSearch.add(lblSearch);

        JLabel lblMediaType = new JLabel("Media Type:");
        verticalBoxSearch.add(lblMediaType);

        String[] mediaTypes = {"Books", "Periodicals", "Films"};
        comboMediaType = new JComboBox<>(mediaTypes);
        comboMediaType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedMedia = (String) comboMediaType.getSelectedItem();
                switch (selectedMedia) {
                    case "Books":
                        // Perform actions for Books
                        break;
                    case "Periodicals":
                        // Perform actions for Periodicals
                        break;
                    case "Films":
                        // Perform actions for Films
                        break;
                    default:
                        break;
                }
            }
        });
        verticalBoxSearch.add(comboMediaType);

        JScrollPane scrollPane = new JScrollPane();
        verticalBoxSearch.add(scrollPane);

        JButton btnAddCriterion = new JButton("Add Criterion");
        verticalBoxSearch.add(btnAddCriterion);

        JButton btnSearch = new JButton("Search");
        verticalBoxSearch.add(btnSearch);

        frameKioskHome.setVisible(true);
    }
}
