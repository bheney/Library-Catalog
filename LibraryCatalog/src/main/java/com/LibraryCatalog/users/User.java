package main.java.com.LibraryCatalog.users;
import java.util.Date;
import org.mindrot.jbcrypt.BCrypt;

public class User {
    // Attributes
    private String firstName;
    private String lastName;
    private Date dob;
    private String street;
    private String phone;
    private String libraryCardNumber;
    private Date issue;
    private String email;
    private String zip;
    private String hash;

    // Constructor
    // TODO: This should maybe be a Builder pattern. Constructor is pretty cluttered
    public User(String firstName, String lastName, Date dob, String street, String phone, String libraryCardNumber, Date issue, String email, String zip, String hash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.street = street;
        this.phone = phone;
        this.libraryCardNumber = libraryCardNumber;
        this.issue = issue;
        this.email = email;
        this.zip = zip;
        this.hash = hash;
    }
    
    public boolean checkPassword(String password) { // Will not compile with byte[] password
    	return BCrypt.checkpw(password, getHash());
    }
    
    public String getFirstName() {
    	return firstName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public Date getDOB() {
    	return dob;
    }
    
    public String getStreet() {
    	return street;
    }
    
    public String getPhone() {
    	return phone;
    }
    public String getCardNumber() {
    	return libraryCardNumber;
    }
    
    public Date getIssue() {
    	return issue;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public String getZip() {
    	return zip;
    }

    public String getHash() {
    	return hash;
    }
}
