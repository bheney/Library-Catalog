import javax.crypto.SecretKey;

public class AppSettings {
    public static final String settingsEncryptionAlgorithm = "AES/CBC/PKCS5Padding (128)";

    // install.sh will inject a unique 256-bit encryption key here
    // this provides each installation with its own secret key
    private static final String keyString = "";
    // Convert the raw string to a SecretKey
    private static final byte[] keyBytes = keyString.getBytes();
    public static final SecretKey settingsEncryptionKey = new SecretKeySpec(
            key=keyBytes,
            offset=0,
            len=256,
            algorithm="AES"
    );
    public static final
