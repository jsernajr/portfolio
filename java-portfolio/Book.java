public class Book {
    private String id;
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String id, String title, String author, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkOut() {
        if (isAvailable) {
            isAvailable = false;
        }
    }

    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        String status = isAvailable ? "✅ Available" : "❌ Checked Out";
        return String.format("[%s] %s by %s (ISBN: %s) - %s", id, title, author, isbn, status);
    }
}
