package com.cipher.library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class User {
    private List<Book> books;
    private Map<String, String> issuedBooks;

    public User(List<Book> books) {
        this.books = books;
        this.issuedBooks = new HashMap<>();
    }

    public void viewBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(String isbn, String userName) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && !book.isIssued()) {
                book.setIssued(true);
                issuedBooks.put(isbn, userName);
                System.out.println("Book issued to: " + userName);
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(String isbn) {
        if (issuedBooks.containsKey(isbn)) {
            for (Book book : books) {
                if (book.getIsbn().equals(isbn)) {
                    book.setIssued(false);
                    issuedBooks.remove(isbn);
                    System.out.println("Book returned successfully.");
                    return;
                }
            }
        }
        System.out.println("Invalid ISBN or book was not issued.");
    }
}
