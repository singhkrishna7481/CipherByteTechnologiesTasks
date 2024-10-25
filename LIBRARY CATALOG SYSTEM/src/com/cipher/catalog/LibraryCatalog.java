package com.cipher.catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryCatalog {
    private List<Book> catalog;

    public LibraryCatalog() {
        catalog = new ArrayList<>();
    }

    // Add a new book to the catalog
    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        catalog.add(book);
        System.out.println("Book added successfully: " + title);
    }

    // List all available books
    public void listBooks() {
        if (catalog.isEmpty()) {
            System.out.println("No books in the catalog.");
        } else {
            System.out.println("Listing all books:");
            for (Book book : catalog) {
                System.out.println(book);
            }
        }
    }

    // Search books by title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with the title: " + title);
        }
    }

    // Search books by author
    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book book : catalog) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by the author: " + author);
        }
    }

    // Main menu and interaction with users
    public static void main(String[] args) {
        LibraryCatalog library = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Catalog System");
            System.out.println("1. Add Book");
            System.out.println("2. List All Books");
            System.out.println("3. Search by Title");
            System.out.println("4. Search by Author");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;

                case 2:
                    library.listBooks();
                    break;

                case 3:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchByTitle(searchTitle);
                    break;

                case 4:
                    System.out.print("Enter author name to search: ");
                    String searchAuthor = scanner.nextLine();
                    library.searchByAuthor(searchAuthor);
                    break;

                case 5:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
