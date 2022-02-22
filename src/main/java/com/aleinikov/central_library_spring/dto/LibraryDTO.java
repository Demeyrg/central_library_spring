package com.aleinikov.central_library_spring.dto;

import java.util.ArrayList;
import java.util.List;

public class LibraryDTO {

    private Long id;
    private String name;
    private List<BookDTO> booksDTO;

    public LibraryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookDTO> getBooks() {
        return booksDTO;
    }

    public void setBooks(List<BookDTO> books) {
        booksDTO  = books;
    }

    public void addBook(BookDTO book){
        if (booksDTO == null)
            booksDTO= new ArrayList<>();
        booksDTO.add(book);
    }

    public void removeBook(BookDTO book) {
        if (booksDTO == null)
            return;
        booksDTO.add(book);
    }

    public void clearLibrary() {
        booksDTO.clear();
    }
}
