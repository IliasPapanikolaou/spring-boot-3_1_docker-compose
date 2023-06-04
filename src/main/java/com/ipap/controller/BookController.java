package com.ipap.controller;

import com.ipap.entity.Book;
import com.ipap.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> modifyBook(@PathVariable int id, @RequestBody Book book) {
        return bookRepository.findById(id).map(b -> {
            b.setName(book.getName());
            return ResponseEntity.ok(bookRepository.save(b));
        }).orElse(ResponseEntity.badRequest().build());
    }
}
