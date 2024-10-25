package com.cipher.library;

import java.util.List;

class Admin {
    private List<Book> books;

    public Admin(List<Book> books) {
        this.books = books;
    }

    public void addBook(String title, String author, String isbn) {
        Book newBook = new Book(title, author, isbn);
        books.add(newBook);
        System.out.println("Book added successfully: " + title);
    }

    public void deleteBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        System.out.println("Book removed successfully!");
    }

    public void displayAllBooks() {
        System.out.println("List of all books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
