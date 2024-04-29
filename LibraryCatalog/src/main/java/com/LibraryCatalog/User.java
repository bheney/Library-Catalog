package com.LibraryCatalog;
import java.util.Date;

public class User {
    // Attributes
    private String firstName;
    private String lastName;
    private Date dob;
    private String street;
    private String phone;
    private String libraryCardNumber;
    private String issue;
    private String email;
    private String zip;

    // Constructor
    public User(String firstName, String lastName, Date dob, String street, String phone, String libraryCardNumber, String issue, String email, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.street = street;
        this.phone = phone;
        this.libraryCardNumber = libraryCardNumber;
        this.issue = issue;
        this.email = email;
        this.zip = zip;
    }

    // Getters and setters for attributes
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(String libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    // Additional Methods
    public void updateUserInfo(String street, String phone, String email, String zip) {
        this.street = street;
        this.phone = phone;
        this.email = email;
        this.zip = zip;
    }

    public void changePassword(String newPassword) {
        // Logic to change the user's password
    }

    public void sendEmailVerification() {
        // Logic to send email verification
    }

    public void deleteAccount() {
        // Logic to delete the user's account and associated data
    }

}

