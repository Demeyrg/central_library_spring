package com.aleinikov.central_library_spring.controllers;

import com.aleinikov.central_library_spring.dto.BookDTO;
import com.aleinikov.central_library_spring.entities.Book;
import com.aleinikov.central_library_spring.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public List<BookDTO> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        BookDTO book = bookService.findById(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @PostMapping("/book")
    public BookDTO addNewBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/book/{id}")
    public BookDTO updateBook(@RequestBody Book book, @PathVariable Long id) {
        return bookService.update(book,id);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book with ID =" + id + " was deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/book/author/{author}")
    public ResponseEntity<?> getBookByTitleContains(@PathVariable String author) {
        return new ResponseEntity<>(bookService.findBookByAuthorContains(author),HttpStatus.OK);
    }

    @GetMapping("/book/title/{title}")
    public ResponseEntity<?> getBookByAuthorContains(@PathVariable String title) {
        return new ResponseEntity<>(bookService.findBookByTitleContains(title),HttpStatus.OK);
    }

    @GetMapping("/book/author/{author}/title/{title}")
    public ResponseEntity<?> getBookByAuthorContains(@PathVariable String author, @PathVariable String title) {
        return new ResponseEntity<>(bookService.findBookByAuthorContainsAndTitleContains(author,title),HttpStatus.OK);
    }
}
