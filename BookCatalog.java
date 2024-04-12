import java.util.ArrayList;
import java.util.List;
public class BookCatalog {
    private List<Book> books;

    // Constructor
    public BookCatalog() {
        this.books = new ArrayList<>();
    }

    // Method to add a new book to the catalog
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Method to edit an existing book in the catalog
    public void editBook(String ISBN, String title, String author, int year, String genre) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                book.setTitle(title);
                book.setAuthor(author);
                book.setYear(year);
                book.setGenre(genre);
                System.out.println("Book edited successfully.");
                return;
            }
        }
        System.out.println("Book not found for editing.");
    }

