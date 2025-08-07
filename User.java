package LibraryManagementSystem;


import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Book> issuedBooks;

    public User(String name) {
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public boolean canIssueMoreBooks() {
        return issuedBooks.size() < 3;
    }

    public void addBook(Book book) {
        issuedBooks.add(book);
    }

    public void removeBook(Book book) {
        issuedBooks.remove(book);
    }

    public boolean hasIssuedBook(Book book) {
        return issuedBooks.contains(book);
    }
}
