package com.aleinikov.central_library_spring.services;

import com.aleinikov.central_library_spring.entities.Book;
import com.aleinikov.central_library_spring.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseGet(Book::new);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findBookByAuthorContains(String author) {
        return bookRepository.findBookByAuthorContains(author);
    }

    public List<Book> findBookByTitleContains(String title) {
        return bookRepository.findBookByTitleContains(title);
    }

    public List<Book> findBookByAuthorContainsAndTitleContains(String author, String title) {
        return bookRepository.findBookByAuthorContainsAndTitleContains(author,title);
    }
}
