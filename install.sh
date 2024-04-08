# Function to generate a random 256-bit string
generate_random_string() {
    openssl rand -hex 32
}

keyLine="private static final String keyString = \"\";"
newKey=generate_random_string
newLine="private static final String keyString = $newKey;"
appSettings="lib/src/AppSettings.java"
libraryCatalog="lib/src/LibraryCatalog.java"

# Inject the encryption key into the source file
sed -i "s/$keyLine/$newLine/g" $appSettings
# Compile the project
javac $libraryCatalog
# Remove the encryption from the source file
sed -i "s/$newLine/$keyLine/g" $appSettings