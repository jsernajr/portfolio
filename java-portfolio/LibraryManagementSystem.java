import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    private List<Book> books;
    private static final String LIBRARY_NAME = "Digital Library System";

    public LibraryManagementSystem() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void checkOutBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                if (book.isAvailable()) {
                    book.checkOut();
                    System.out.println("✓ Successfully checked out: " + book.getTitle());
                } else {
                    System.out.println("✗ Book is not available for checkout.");
                }
                return;
            }
        }
        System.out.println("✗ Book not found in library.");
    }

    public void returnBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                book.returnBook();
                System.out.println("✓ Successfully returned: " + book.getTitle());
                return;
            }
        }
        System.out.println("✗ Book not found in library.");
    }

    public void searchByTitle(String title) {
        System.out.println("\n📚 Search Results for: \"" + title + "\"");
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with that title.");
        }
    }

    public void searchByAuthor(String author) {
        System.out.println("\n👤 Search Results by Author: \"" + author + "\"");
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by that author.");
        }
    }

    public void displayAllBooks() {
        System.out.println("\n📖 Complete Library Catalog (" + books.size() + " books)");
        System.out.println("=========================================");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayStatistics() {
        int available = 0;
        int checkedOut = 0;

        for (Book book : books) {
            if (book.isAvailable()) {
                available++;
            } else {
                checkedOut++;
            }
        }

        System.out.println("\n📊 LIBRARY STATISTICS");
        System.out.println("====================");
        System.out.println("Total Books: " + books.size());
        System.out.println("Available: " + available);
        System.out.println("Checked Out: " + checkedOut);
        System.out.println("Availability Rate: " + String.format("%.1f%%", 
                (available * 100.0) / books.size()));
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Add sample books
        library.addBook(new Book("B001", "Java Programming", "James Gosling", "978-0-134-69966-1"));
        library.addBook(new Book("B002", "Clean Code", "Robert Martin", "978-0-132-35088-2"));
        library.addBook(new Book("B003", "Design Patterns", "Gang of Four", "978-0-201-63361-0"));
        library.addBook(new Book("B004", "Effective Java", "Joshua Bloch", "978-0-134-68599-1"));
        library.addBook(new Book("B005", "Code Complete", "Steve McConnell", "978-0-735-61966-8"));

        library.displayAllBooks();

        // Simulate some transactions
        System.out.println("\n--- Processing Transactions ---");
        library.checkOutBook("B001");
        library.checkOutBook("B003");
        library.returnBook("B001");

        library.displayStatistics();
        library.searchByAuthor("Robert Martin");
        library.searchByTitle("Java");
    }
}
