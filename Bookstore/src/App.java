import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        BookStore seed = new BookStore();

    seed.addBook(new Book("Animal Kingdom", "Johnny Sins", "69420A", 150));
    seed.addBook(new Book("Baldur's Gate", "Pichanon", "14592G", 250));
    seed.addBook(new Book("Garry Jenkins", "Pakin Leelawatwatana", "MLG1337", 300));

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a title, author, or ISBN to search: ");
    String searchString = scanner.nextLine();
    System.out.print("\n");

    List<Book> searchResultsByTitle = seed.searchByTitle(searchString);
    List<Book> searchResultsByAuthor = seed.searchByAuthor(searchString);
    List<Book> searchResultsByISBN = seed.searchByIsbn(searchString);
    
    displaySearchResults("Title", searchResultsByTitle);
    displaySearchResults("Author", searchResultsByAuthor);
    displaySearchResults("ISBN", searchResultsByISBN);

    scanner.close();
    }

    private static void displaySearchResults(String category, List<Book> books) {
        System.out.println("Search Results by " + category + ":");
        if (books.isEmpty()) {
            System.out.println("No matching books found.\n");
        } else {
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Price: $" + book.getPrice() + "\n");
            }
        }
    }
}
