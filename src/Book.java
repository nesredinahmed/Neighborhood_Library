public class Book {
    // Declare fields for each book's data
    private int id; // Unique ID for the book
    private String isbn; // ISBN number
    private String title; // Book title
    private boolean isCheckedOut; // Flag to check if book is checked out
    private String checkedOutTo; // Person's name who checked out the book

    // Constructor to initialize a Book object
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
         this.isCheckedOut = false; // By default, not checked out
        this.checkedOutTo = ""; // Empty string for no one
    }

    // Method to check out a book
    public void checkOut(String name) {
        this.isCheckedOut = true;
        this.checkedOutTo = name;
    }

    // Method to check in a book
    public void checkIn() {
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    // Getters for each property
    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    // Display format for available books
    public String toString() {
        return String.format("ID: %d | ISBN: %s | Title: %s", id, isbn, title);
    }

    // Display format for checked out books
    public String toCheckedOutString() {
        return String.format("ID: %d | ISBN: %s | Title: %s | Checked Out To: %s", id, isbn, title, checkedOutTo);
    }
}
