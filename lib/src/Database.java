import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Database {
    private static Database instace;
    private static Settings settings;
    private static Connection connection;

    private Database {
        settings = Settings.getSettings();

        // Load the JDBC driver
        try {
            Class.forName(settings.getDBDriver());
        } catch (ClassNotFoundException e) {
            // TODO: Handle this
            e.printStackTrace();
        }

        // Build a JDBC connection
        try {
            connection = DriverManager.getConnection(url, uname, password)
        }

    }


    public Database getDatabase {
        if (instace == null) {
            instace = new Database();
        }
        else return instace;
    }
}