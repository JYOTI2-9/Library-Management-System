
package LibraryManagementSystem;

public class Book {
    private String title;
    private User issuedTo;

    public Book(String title) {
        this.title = title;
        this.issuedTo = null;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return issuedTo != null;
    }

    public User getIssuedTo() {
        return issuedTo;
    }

    public void issueTo(User user) {
        this.issuedTo = user;
    }

    public void returnBook() {
        this.issuedTo = null;
    }

    @Override
    public String toString() {
        if (isIssued()) {
            return title + " [Issued to: " + issuedTo.getName() + "]";
        }
        return title + " [Available]";
    }
}
