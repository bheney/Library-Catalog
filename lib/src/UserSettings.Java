import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class UserSettings implements Serializable {
    // Singleton Implementation
    private static UserSettings instance;
    private UserSettings() {

    }

    public static UserSettings getSettings() {
        if (instance == null) {
            instance = new UserSettings();
        }
        return instance;
    }

    // Saving, loading, and encryption
    /*
    Some of these settings are sensitive (Database access credentials, etc...)
    However, Library staff should not need to re-enter this information each time the application is restarted
    These settings need to be available and cannot be hashed, so we must rely on encryption to store them locally
     */
    public static SealedObject encrypt(Serializable object)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
            InvalidKeyException, IOException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance(AppSettings.settingsEncryptionAlgorithm);
        cipher.init(Cipher.ENCRYPT_MODE, AppSettings.settingsEncryptionKey, AppSettings.settingsIV);
        return new SealedObject(object, cipher);
    }

    public static Serializable decrypt(SealedObject sealedObject) throws NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException,
            ClassNotFoundException, BadPaddingException, IllegalBlockSizeException,
            IOException {

        Cipher cipher = Cipher.getInstance(AppSettings.settingsEncryptionAlgorithm);
        cipher.init(Cipher.ENCRYPT_MODE, AppSettings.settingsEncryptionKey, AppSettings.settingsIV);
        return (Serializable) sealedObject.getObject(cipher);
    }

    // Database Settings
    public enum supportedDB {
        MySQL,
    }
    private supportedDB dbType;
    private String dbURL;
    private String dbUsername;
    private String dbPassword;

    public void setDBType(supportedDB dbType) {this.dbType = dbType;}
    public supportedDB getDbType() {return dbType;}

    public String getDBDriver() throws ClassNotFoundException {
        switch (dbType) {
            case MySQL:
                return "com.mysql.cj.jdbc.Driver";
            default:
                throw new ClassNotFoundException("Unsupported database type.");
        }
    }


}