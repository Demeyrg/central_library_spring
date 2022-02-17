package com.aleinikov.central_library_spring.repositories;

import com.aleinikov.central_library_spring.entities.Book;
import com.aleinikov.central_library_spring.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByAuthorContains(String author);

    List<Book> findBooksByTitleContains(String title);

    List<Book> findBooksByAuthorContainsAndTitleContains(String author, String title);

    List<Book> findBooksByLibrary(Library library);
}
