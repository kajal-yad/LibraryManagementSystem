package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*") // allow frontend
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @PutMapping("/{id}/borrow")
    public Book borrowBook(@PathVariable Long id) {
        return service.borrowBook(id);
    }

    @PutMapping("/{id}/return")
    public Book returnBook(@PathVariable Long id) {
        return service.returnBook(id);
    }
}

