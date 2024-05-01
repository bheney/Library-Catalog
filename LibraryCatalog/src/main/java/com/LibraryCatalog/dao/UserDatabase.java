package main.java.com.LibraryCatalog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.LibraryCatalog.users.User;

public class UserDatabase {
	public enum UserFields {
	    FIRST_NAME("first"),
	    LAST_NAME("last"),
	    DOB("dob"),
	    STREET("street"),
	    PHONE("phone"),
	    CARD_NUMBER("card_number"),
	    ISSUE_DATE("issue_date"),
	    EMAIL("email"),
	    ZIP("zip"),
	    HASH("hash");
	    
	    private final String field;
		
	    UserFields(String dbName){
	    	this.field=dbName;
	    }
	    
	    public String getField() {
	    	return this.field;
	    }
	}
	
    private final static String INSERT_SQL;
    private final static String SELECT_BY_CARD_SQL;
    private final static Database db;

    static {
    	// Build the insertion SQL command

		INSERT_SQL = buildInsertString();
		
		// Build the retrieval SQL command
		SELECT_BY_CARD_SQL = buildRetrieveByCardString();
		
		db = Database.getDatabase();

    }
    public UserDatabase() {

    }
  
    public static void saveUser(User user) {
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {

            preparedStatement.setString(UserFields.FIRST_NAME.ordinal(), user.getFirstName());
            preparedStatement.setString(UserFields.LAST_NAME.ordinal(), user.getLastName());
            preparedStatement.setDate(UserFields.DOB.ordinal(), new java.sql.Date(user.getDOB().getTime()));
    		preparedStatement.setString(UserFields.STREET.ordinal(), user.getStreet());
    		preparedStatement.setString(UserFields.PHONE.ordinal(), user.getPhone());
            preparedStatement.setString(UserFields.CARD_NUMBER.ordinal(), user.getCardNumber());
            preparedStatement.setDate(UserFields.ISSUE_DATE.ordinal(), new java.sql.Date(user.getIssue().getTime()));
            preparedStatement.setString(UserFields. EMAIL.ordinal(), user.getEmail());
            preparedStatement.setString(UserFields.ZIP.ordinal(), user.getZip());
            preparedStatement.setString(UserFields.HASH.ordinal(), user.getHash());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }
    
    

    public static User getUserByCard(String cardNumber) throws SQLException {
        User user = null;
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CARD_SQL);

        preparedStatement.setString(1, cardNumber);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user = new User(
            		resultSet.getString(UserFields.FIRST_NAME.getField()),
            		resultSet.getString(UserFields.LAST_NAME.getField()),
            		new java.util.Date(resultSet.getDate(UserFields.DOB.getField()).getTime()),
            		resultSet.getString(UserFields.STREET.getField()),
            		resultSet.getString(UserFields.PHONE.getField()),
            		resultSet.getString(UserFields.CARD_NUMBER.getField()),
            		new java.util.Date(resultSet.getDate(UserFields.ISSUE_DATE.getField()).getTime()),
            		resultSet.getString(UserFields.EMAIL.getField()),
            		resultSet.getString(UserFields.ZIP.getField()),
            		resultSet.getString(UserFields.HASH.getField())
    		);
        }
        return user;
    }
    
    private static String buildInsertString() {
    	StringBuilder insert_sql = new StringBuilder("INSERT INTO users (");
    	int count = 0;
    	for (UserFields field : UserFields.values()) {
    		if (count > 0) {
    			insert_sql.append(", ");
    		}
    		insert_sql.append(field.getField());
    		count ++;
    	}
    	insert_sql.append(") VALUES (");
    	for (int i=0; i<=count; i++) {
    		if (i > 0) {
    			insert_sql.append(", ");
    		}
    		insert_sql.append("?");
    	}
    	insert_sql.append(")");
    	return insert_sql.toString();
    }
    
    private static String buildRetrieveByCardString() {
    	StringBuilder select_by_card_sql = new StringBuilder("SELECT");
    	int count = 0;
    	for (UserFields field : UserFields.values()) {
    		if (count > 0) {
    			select_by_card_sql.append(", ");
    		}
    		select_by_card_sql.append(field.getField());
    		count ++;
    	}
    	select_by_card_sql.append(" FROM users WHERE ");
    	select_by_card_sql.append(UserFields.CARD_NUMBER.getField());
    	select_by_card_sql.append(" = ?");
		return select_by_card_sql.toString();
    }
}
