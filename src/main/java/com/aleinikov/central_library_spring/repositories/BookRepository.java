package com.aleinikov.central_library_spring.repositories;

import com.aleinikov.central_library_spring.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBookByAuthorContains(String author);

    List<Book> findBookByTitleContains(String title);

    List<Book> findBookByAuthorContainsAndTitleContains(String author, String title);
}
