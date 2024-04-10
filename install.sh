# Function to generate a random 256-bit string
generate_random_string() {
    openssl rand -hex 32
}

keyLine="private static final String keyString = \"\";"
ivLine="private static final String ivString = \"\";"
newKey=$(generate_random_string)
newIV=$(generate_random_string)
newKeyLine="private static final String keyString = \"$newKey\";"
newIVLine="private static final String ivString = \"$newIV\";"
appSettings="LibraryCatalog/src/main/java/com/LibraryCatalog/settings/AppSettings.java"

# Inject the encryption key into the source file
sed -i "s/$keyLine/$newKeyLine/g" $appSettings
sed -i "s/$ivLine/$newIVLine/g" $appSettings
# Compile the project
(cd LibraryCatalog || exit; mvn compile)
# Remove the encryption from the source file
sed -i "s/$newKeyLine/$keyLine/g" $appSettings
sed -i "s/$newIVLine/$ivLine/g" $appSettings