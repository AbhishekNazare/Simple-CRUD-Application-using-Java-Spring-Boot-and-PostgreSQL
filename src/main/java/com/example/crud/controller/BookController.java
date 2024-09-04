package com.example.crud.controller;

import com.example.crud.dto.BookDTO;
import com.example.crud.dto.ErrorResponseDto;
import com.example.crud.entity.Book;
import com.example.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> createBook(@RequestBody BookDTO bookDTO) {
        bookService.createBook(bookDTO);
        String message = "Book created successfully";
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        bookService.updateBook(id, bookDTO);
        String message = "Book updated successfully";
        return ResponseEntity.ok().body(message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        String message = "Book deleted successfully";
        return ResponseEntity.ok().body(message);
    }
}