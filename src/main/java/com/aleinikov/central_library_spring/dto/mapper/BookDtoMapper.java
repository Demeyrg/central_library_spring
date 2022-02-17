package com.aleinikov.central_library_spring.dto.mapper;

import com.aleinikov.central_library_spring.dto.BookDTO;
import com.aleinikov.central_library_spring.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDtoMapper {

    public BookDTO bookToDto(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setCustomer(book.getCustomer());
        bookDTO.setOrderDate(book.getOrderDate());
        bookDTO.setLibrary(book.getLibrary());
        return bookDTO;
    }

    public Book dtoToBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());
        book.setCustomer(bookDTO.getCustomer());
        book.setOrderDate(bookDTO.getOrderDate());
        book.setLibrary(bookDTO.getLibrary());
        return book;
    }

    public List<BookDTO> bookListToDtoList(List<Book> books) {
        List<BookDTO> booksDTO = new ArrayList<>();
        for (Book book:books)
            booksDTO.add(bookToDto(book));
        return booksDTO;
    }

    public List<Book> bookDtoListToBookList(List<BookDTO> booksDTOS) {
        List<Book> books = new ArrayList<>();
        for (BookDTO bookDTO:booksDTOS)
            books.add(dtoToBook(bookDTO));
        return books;
    }
}
