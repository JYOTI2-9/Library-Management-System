package LibraryManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add some books
        library.addBook(new Book("Java Programming"));
        library.addBook(new Book("Python Basics"));
        library.addBook(new Book("C++ Guide"));
        library.addBook(new Book("Data Structures"));
        library.addBook(new Book("Algorithms"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library Management System!");
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        User user = new User(userName);

        int choice = 0;
        do {
            System.out.println("\nHello, " + user.getName() + "! Choose an option:");
            System.out.println("1. Show all books");
            System.out.println("2. Issue a book");
            System.out.println("3. Return a book");
            System.out.println("4. Show my issued books");
            System.out.println("5. Show all issued books");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-6): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();  // consume newline

                switch (choice) {
                    case 1:
                        library.showAllBooks();
                        break;
                    case 2:
                        System.out.print("Enter book title to issue: ");
                        String issueTitle = scanner.nextLine();
                        System.out.println(library.issueBook(issueTitle, user));
                        break;
                    case 3:
                        System.out.print("Enter book title to return: ");
                        String returnTitle = scanner.nextLine();
                        System.out.println(library.returnBook(returnTitle, user));
                        break;
                    case 4:
                        System.out.println("\nYour issued books:");
                        if (user.getIssuedBooks().isEmpty()) {
                            System.out.println("No books issued.");
                        } else {
                            for (Book b : user.getIssuedBooks()) {
                                System.out.println("- " + b.getTitle());
                            }
                        }
                        break;
                    case 5:
                        library.showIssuedBooks();
                        break;
                    case 6:
                        System.out.println("Goodbye, " + user.getName() + "!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1-6.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // discard invalid input
            }

        } while (choice != 6);

        scanner.close();
    }
}
