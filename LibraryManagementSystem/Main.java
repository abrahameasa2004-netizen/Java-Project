package LibraryManagementSystem;

import java.util.Scanner;

public class Main 1{
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        // Sample data
        library.addBook(new Book(1, "Java Programming", "James Gosling"));
        library.addBook(new Book(2, "Effective Java", "Joshua Bloch"));
        library.addUser(new User(101, "Alice"));
        library.addUser(new User(102, "Bob"));

        int choice;
        do {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Show Books");
            System.out.println("2. Show Users");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> library.showBooks();
                case 2 -> library.showUsers();
                case 3 -> {
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    library.issueBook(bookId, userId);
                }
                case 4 -> {
                    System.out.print("Enter Book ID to return: ");
                    int bookId = sc.nextInt();
                    library.returnBook(bookId);
                }
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
