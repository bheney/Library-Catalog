package com.LibraryCatalog.catalog;

import java.util.HashSet;

public class Book extends Media {


    public Book(String title, String author, String isbn) {
        name = "Book";
        fields = new HashSet<>();
        fields.add(new Field("Title", title));
        fields.add(new Field("Author", author));
        fields.add(new Field("ISBN", isbn));
    }

}
