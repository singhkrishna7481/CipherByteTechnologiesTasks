package com.cipher.library;

import java.util.*;

public class Library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        Admin admin = new Admin(books);
        User user = new User(books);

        while (true) {
            System.out.println("\n1. Admin Login\n2. User Login\n3. Exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Admin Access:");
                System.out.println("1. Add Book\n2. Remove Book\n3. Display All Books");
                int adminChoice = scanner.nextInt();

                switch (adminChoice) {
                    case 1:
                        System.out.println("Enter book title, author, and ISBN:");
                        String title = scanner.next();
                        String author = scanner.next();
                        String isbn = scanner.next();
                        admin.addBook(title, author, isbn);
                        break;

                    case 2:
                        System.out.println("Enter ISBN of the book to remove:");
                        isbn = scanner.next();
                        admin.deleteBook(isbn);
                        break;

                    case 3:
                        admin.displayAllBooks();
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } else if (choice == 2) {
                System.out.println("User Access:");
                System.out.println("1. View Books\n2. Issue Book\n3. Return Book");
                int userChoice = scanner.nextInt();

                switch (userChoice) {
                    case 1:
                        user.viewBooks();
                        break;

                    case 2:
                        System.out.println("Enter ISBN of the book to issue:");
                        String isbn = scanner.next();
                        System.out.println("Enter your name:");
                        String userName = scanner.next();
                        user.issueBook(isbn, userName);
                        break;

                    case 3:
                        System.out.println("Enter ISBN of the book to return:");
                        isbn = scanner.next();
                        user.returnBook(isbn);
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } else if (choice == 3) {
                System.out.println("Exiting system.");
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
    }
}
