import java.util.ArrayList;
import java.util.List;

public class BookStore {

    private List<Book> books = new ArrayList<>();

    // Add a book to the store's storage
    public void addBook(Book book) {
        books.add(book);
    }

    // Search for books matching title
    public List<Book> searchByTitle(String title) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                matchingBooks.add(book);
            }
        }
    return matchingBooks;
    }

    // Search for books matching author
    public List<Book> searchByAuthor(String author) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    public List<Book> searchByIsbn(String isbn) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getIsbn().toLowerCase().contains(isbn.toLowerCase())) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }
}
