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
    private static final String keyString = "";
    private static final String ivString = "";
    // Convert the raw string to a SecretKey
    private static final byte[] keyBytes = keyString.getBytes();
    private static final byte[] ivBytes = ivString.getBytes();
    public static final SecretKey settingsEncryptionKey = new SecretKeySpec(keyBytes, 0, 256, "AES");
    public static final IvParameterSpec settingsIV = new IvParameterSpec(ivBytes, 0, 32);

    // Database Sanitization Regex
    public static final Pattern dbSanitizationFilter = Pattern.compile("[^a-zA-Z0-9\\s]");

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