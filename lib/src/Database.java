import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
class Database {
    private static Database instace;
    private static Settings settings;

    private Database {
        settings = Settings.getSettings();
        try {
            Class.forName(settings.getDBDriver());
        } catch (ClassNotFoundException e) {
            // TODO: Handle this
            e.printStackTrace();
        }

    }


    public Database getDatabase {
        if (instace == null) {
            instace = new Database();
        }
        else return instace;
    }
}