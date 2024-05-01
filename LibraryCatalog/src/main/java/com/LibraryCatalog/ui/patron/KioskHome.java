package main.java.com.LibraryCatalog.ui.patron;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class KioskHome {

	private JFrame frameKioskHome;
	private JTextField textFieldCardNumber;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KioskHome window = new KioskHome();
					window.frameKioskHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KioskHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		
		JLabel lblPassword = new JLabel("Password:");
		verticalBoxSignOn.add(lblPassword);
		
		passwordField = new JPasswordField();
		verticalBoxSignOn.add(passwordField);
		
		JButton btnSignOn = new JButton("Sign On");
		verticalBoxSignOn.add(btnSignOn);
		
		Box verticalBoxSearch = Box.createVerticalBox();
		horizontalBoxMainDivider.add(verticalBoxSearch);
		
		JLabel lblSearch = new JLabel("Search");
		verticalBoxSearch.add(lblSearch);
		
		JLabel lblMediaType = new JLabel("Media Type:");
		verticalBoxSearch.add(lblMediaType);
		
		JComboBox comboBoxMediaType = new JComboBox();
		verticalBoxSearch.add(comboBoxMediaType);
		
		JScrollPane scrollPane = new JScrollPane();
		verticalBoxSearch.add(scrollPane);
		
		JButton btnAddCriterion = new JButton("Add Criterion");
		verticalBoxSearch.add(btnAddCriterion);
		
		JButton btnSearch = new JButton("Search");
		verticalBoxSearch.add(btnSearch);
	}

}
