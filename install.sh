#!/bin/bash

# Function to generate a random 256-bit string
generate_random_string() {
    openssl rand -hex 128 # 256-bit encryption, 2 bytes per word
}

keyLine="private static final String keyString = \"\";"
ivLine="private static final String ivString = \"\";"
newKey=$(generate_random_string)
newIV=$(generate_random_string)
newKeyLine="private static final String keyString = \"$newKey\";"
newIVLine="private static final String ivString = \"$newIV\";"
appSettings="LibraryCatalog/src/main/java/com/LibraryCatalog/settings/AppSettings.java"

# Inject the encryption key into the source file
sed -i "s~$keyLine~$newKeyLine~g" "$appSettings" || { echo "Error: Failed to replace key in source file"; exit 1; }
sed -i "s~$ivLine~$newIVLine~g" "$appSettings" || { echo "Error: Failed to replace iv in source file"; exit 1; }

# Compile the project
(cd LibraryCatalog || { echo "Error: Failed to change directory"; exit 1; }; mvn compile) || { echo "Error: Failed to compile project"; }

# Remove the encryption from the source file
sed -i "s~$newKeyLine~$keyLine~g" "$appSettings" || { echo "Error: Failed to restore key in source file"; exit 1; }
sed -i "s~$newIVLine~$ivLine~g" "$appSettings" || { echo "Error: Failed to restore iv in source file"; exit 1; }

echo "Script executed successfully"

