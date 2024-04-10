package com.LibraryCatalog.settings;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class AppSettings {
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
}