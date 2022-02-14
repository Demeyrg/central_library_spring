package com.aleinikov.central_library_spring.controllers;

import com.aleinikov.central_library_spring.entities.Book;
import com.aleinikov.central_library_spring.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        if (book.getId() == null)
            return new ResponseEntity<>("The book with this ID=" + id + " does not exist!", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @PostMapping("/book")
    public Book addNewBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return savedBook;
    }

    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book) {
        Book updatedBook = bookService.saveBook(book);
        return updatedBook;
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        Book book = bookService.findById(id);
        if (book.getId() == null)
            return new ResponseEntity<>("The book with this ID=" + id + " does not exist!", HttpStatus.BAD_REQUEST);
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book with ID =" + id + " was deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/books/author/{author}")
    public ResponseEntity<?> getBookByTitleContains(@PathVariable String author) {
        List<Book> books = bookService.findBookByAuthorContains(author);
        if (books.size() <= 0)
            return new ResponseEntity<>("The book with this author=\"" + author + "\" does not exist!"
                    , HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @GetMapping("/books/title/{title}")
    public ResponseEntity<?> getBookByAuthorContains(@PathVariable String title) {
        List<Book> books = bookService.findBookByTitleContains(title);
        if (books.size() <= 0)
        return new ResponseEntity<>("The book with this title=\"" + title + "\" does not exist!"
                , HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @GetMapping("/books/author/{author}/title/{title}")
    public ResponseEntity<?> getBookByAuthorContains(@PathVariable String author, @PathVariable String title) {
        List<Book> books = bookService.findBookByAuthorContainsAndTitleContains(author,title);
        if (books.size() <= 0)
            return new ResponseEntity<>("The book with this author=\"" + author
                    + "\" and title=\"" + title
                    + "\" does not exist!"
                    , HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(books,HttpStatus.OK);
    }
}
