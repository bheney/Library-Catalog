package main.java.com.LibraryCatalog;
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
}
