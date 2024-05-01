package main.java.com.LibraryCatalog.catalog;

public class Field {
    private final String fieldName;
    private String value;

    public Field(final String fieldName, final String value) {
        this.fieldName = fieldName;
        this.value = value;
    }
    public String getFieldName(){return fieldName;}
    public String getValue(){return value;}
    public void setValue(String value){this.value = value;}
}
