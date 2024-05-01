package main.java.com.LibraryCatalog.settings;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Arrays;

public class AppSettings {
    // Singleton Pattern
    private static AppSettings instance;
    public static final String settingsEncryptionAlgorithm = "AES/CBC/PKCS5Padding (128)";

    // install.sh will inject a unique 256-bit encryption key here
    // this provides each installation with its own secret key
    private static final String keyString = "c7dbfa07b2984b96eb6ff47e6b0c4291d6ca1c2d6600fcc4fef4d6052619239c90be2e97a9e882ecd0ed6771d2d6b418f01e7a7f74fcbc1e9e1542b2298c7d9d5710966ea2c354e5367cb88dff5447375b8b963a3a5369f11d4dc0d2e95fcb0dc5072c745025752558f5c4f11562023741850b4fe794cfdf714d41cf1ad44026";
    private static final String ivString = "22efe6f86dd6e6c520242e12487280e42bf17fcf21a75139782f88128cee944cace96852a338f2ec3b0d94a788c5f6069b390f7f99988e7a02e8214ea7f500ce9d00fad393431e98b371361931bed18a7edcf97d5db0ebabb0cada8d904674647b049b9acd60f8a3bad7a130bb6bef411387d94aee90d15e8e108cc7fad5f925";
    private static final byte[] keyBytes;
    private static final byte[] ivBytes;
    public static final SecretKey settingsEncryptionKey;
    public static final IvParameterSpec settingsIV;
    public static final Pattern dbSanitizationFilter;
    
    static {
	    // Convert the raw string to a SecretKey
	    keyBytes = keyString.getBytes();
	    ivBytes = ivString.getBytes();
	    settingsEncryptionKey = new SecretKeySpec(keyBytes, 0, 256, "AES");
	    settingsIV = new IvParameterSpec(ivBytes, 0, 32);
	
	    // Database Sanitization Regex
	    dbSanitizationFilter = Pattern.compile("[^a-zA-Z0-9\\s]");
    }
    
    // Media Types
    public enum availableMedia {
            BOOK("Book",
                    new String[] {"Title", "Author", "ISBN"}),
            FILM("Film",
                    new String[] {"Title", "Director", "Year"}),
            PERIODICAL("Periodical",
                    new String[] {"Publication", "Edition", "Volume"});


            public final String label;
            public final List<String> searchFields;

            private availableMedia(String label, String[] searchFields){
                this.label = label;
                this.searchFields = new ArrayList<>(List.of(searchFields));
            }

            public String toString() {return label;}

            public static String[] getLabels() {
                return Arrays.stream(values())
                        .map(availableMedia::toString)
                        .toArray(String[]::new);
            }
    }

    // Constructor
    private AppSettings(){}

    public static AppSettings getSettings() {
        if (instance==null){
            instance = new AppSettings();
            return instance;
        }
        else return instance;
    }
}