package LibraryManagementSystem;



import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book findBookByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    public void showAllBooks() {
        System.out.println("\n--- Book List ---");
        for (Book b : books) {
            System.out.println(b);
        }
        System.out.println("-----------------\n");
    }

    public void showIssuedBooks() {
        System.out.println("\n--- Issued Books ---");
        boolean found = false;
        for (Book b : books) {
            if (b.isIssued()) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books currently issued.");
        }
        System.out.println("-------------------\n");
    }

    public String issueBook(String title, User user) {
        Book book = findBookByTitle(title);
        if (book == null) {
            return "Book not found.";
        }
        if (book.isIssued()) {
            return "Book is already issued to " + book.getIssuedTo().getName() + ".";
        }
        if (!user.canIssueMoreBooks()) {
            return "You cannot issue more than 3 books.";
        }
        if (user.hasIssuedBook(book)) {
            return "You have already issued this book.";
        }

        book.issueTo(user);
        user.addBook(book);
        return "Book issued successfully: " + book.getTitle();
    }

    public String returnBook(String title, User user) {
        Book book = findBookByTitle(title);
        if (book == null) {
            return "Book not found.";
        }
        if (!book.isIssued()) {
            return "Book is not issued.";
        }
        if (!book.getIssuedTo().equals(user)) {
            return "You cannot return a book issued by another user.";
        }

        book.returnBook();
        user.removeBook(book);
        return "Book returned successfully: " + book.getTitle();
    }
}
