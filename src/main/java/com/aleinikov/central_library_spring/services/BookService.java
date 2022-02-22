package com.aleinikov.central_library_spring.services;

import com.aleinikov.central_library_spring.dto.BookDTO;
import com.aleinikov.central_library_spring.dto.mapper.BookDtoMapper;
import com.aleinikov.central_library_spring.entities.Book;
import com.aleinikov.central_library_spring.exception_hadnlers.exceptions.BookNotFoundException;
import com.aleinikov.central_library_spring.repositories.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    private final BookDtoMapper bookDtoMapper;

    public BookService(BookRepository bookRepository,
                       BookDtoMapper bookDtoMapper) {
        this.bookRepository = bookRepository;
        this.bookDtoMapper = bookDtoMapper;
    }

    @Transactional(readOnly = true)
    public List<BookDTO> findAll() {
        return bookDtoMapper.bookListToDtoList(bookRepository.findAll());
    }

    @Transactional(readOnly = true)
    public BookDTO findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("id", id.toString()));
        return bookDtoMapper.toDto(book);
    }

    public BookDTO saveBook(Book book) {
        Book savedBook = bookRepository.save(book);
        return bookDtoMapper.toDto(savedBook);
    }

    public BookDTO update(Book book, Long id) {
        findById(id);
        book.setId(id);
        return bookDtoMapper.toDto(bookRepository.save(book));
    }

    public void deleteBook(Long id) {
        findById(id);
        bookRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<BookDTO> findBookByAuthorContains(String author) {
        List<Book> bookByAuthor = bookRepository.findBooksByAuthorContains(author);
        if (bookByAuthor.size() == 0)
            throw new BookNotFoundException("author", author);
        return bookDtoMapper.bookListToDtoList(bookByAuthor);
    }

    @Transactional(readOnly = true)
    public List<BookDTO> findBookByTitleContains(String title) {
        List<Book> bookByTitle = bookRepository.findBooksByTitleContains(title);
        if (bookByTitle.size() == 0)
            throw new BookNotFoundException("title", title);
        return bookDtoMapper.bookListToDtoList(bookByTitle);
    }

    @Transactional(readOnly = true)
    public List<BookDTO> findBookByAuthorContainsAndTitleContains(String author, String title) {
        List<Book> bookByAuthorAndTitle = bookRepository.findBooksByAuthorContainsAndTitleContains(author, title);
        if (bookByAuthorAndTitle.size() == 0)
            throw new BookNotFoundException("author or title", title + " and " + author);
        return bookDtoMapper.bookListToDtoList(bookByAuthorAndTitle);
    }


}
