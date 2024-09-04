package com.example.crud.service;

import com.example.crud.dto.BookDTO;
import com.example.crud.entity.Book;
import com.example.crud.exception.NotFoundException;
import com.example.crud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll().stream().collect(Collectors.toList());
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found with id: " + id));
    }

    public Book createBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, BookDTO bookDTO) {
        Book existingBook = getBookById(id);
        existingBook.setTitle(bookDTO.getTitle());
        existingBook.setAuthor(bookDTO.getAuthor());
        return bookRepository.save(existingBook);
    }

    public void deleteBook(Long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
    }
}
