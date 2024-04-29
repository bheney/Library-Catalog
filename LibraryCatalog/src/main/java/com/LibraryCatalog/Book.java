package com.LibraryCatalog;
import java.util.ArrayList;
import java.util.List;


public class Book {
    // Inner class representing a Book
        private String ISBN;
        private String title;
        private String author;
        private int year;
        private String genre;
        private String availabilityStatus;
        private String location;

        // Constructor, getters, and setters
        public Book(String ISBN, String title, String author, int year, String genre, String availabilityStatus, String location) {
            this.ISBN = ISBN;
            this.title = title;
            this.author = author;
            this.year = year;
            this.genre = genre;
            this.availabilityStatus = availabilityStatus;
            this.location = location;
        }

        public String getISBN() {
            return ISBN;
        }

        public void setISBN(String ISBN) {
            this.ISBN = ISBN;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public String getAvailabilityStatus() {
            return availabilityStatus;
        }

        public void setAvailabilityStatus(String availabilityStatus) {
            this.availabilityStatus = availabilityStatus;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

    // BookCatalog methods
    private List<Book> books;

    // Constructor
    public Book() {
        this.books = new ArrayList<>();
    }

    // Method to add a new book to the catalog
    public void addBook(String ISBN, String title, String author, int year, String genre, String availabilityStatus, String location) {
        books.add(new Book(ISBN, title, author, year, genre, availabilityStatus, location));
        System.out.println("Book added successfully.");
    }

    // Method to edit an existing book in the catalog
    public void editBook(String ISBN, String title, String author, int year, String genre, String availabilityStatus, String location) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                book.setTitle(title);
                book.setAuthor(author);
                book.setYear(year);
                book.setGenre(genre);
                book.setAvailabilityStatus(availabilityStatus);
                book.setLocation(location);
                System.out.println("Book edited successfully.");
                return;
            }
        }
        System.out.println("Book not found for editing.");
    }


	// Method to delete a book from the catalog
    public void deleteBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
        System.out.println("Book deleted successfully.");
    }

    // Method to retrieve book details
    public Book getBookDetails(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null; // Book not found
    }

	public void setQuantity(int quantity) {
		// TODO Auto-generated method stub
		
	}

}

