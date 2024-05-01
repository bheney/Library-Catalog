package main.java.com.LibraryCatalog.catalog;

import java.util.Set;

public abstract class Media {
    protected String barCode;
    protected String name;
    protected Set<Field> fields;

    public String getBarCode() {
        return barCode;
    }

    public Set<Field> getSearchFields() {
        return fields;
    }

    public String getType (){return name;}

}
