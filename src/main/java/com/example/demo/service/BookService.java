package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Book addBook(Book book) {
        return repo.save(book);
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book borrowBook(Long id) {
        Book book = repo.findById(id).orElseThrow();
        if (book.isAvailable()) {
            book.setAvailable(false);
            return repo.save(book);
        }
        throw new RuntimeException("Book already borrowed");
    }

    public Book returnBook(Long id) {
        Book book = repo.findById(id).orElseThrow();
        if (!book.isAvailable()) {
            book.setAvailable(true);
            return repo.save(book);
        }
        throw new RuntimeException("Book is not borrowed");
    }
}

