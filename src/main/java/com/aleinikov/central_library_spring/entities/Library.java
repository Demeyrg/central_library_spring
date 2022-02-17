package com.aleinikov.central_library_spring.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "libraries")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "library",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    public Library() {
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

    public void addBook(Book book) {
        if (books.size() == 0)
            books= new ArrayList<>();
        books.add(book);
    }

    public void removeBook(Book book) {
        if (books.size() == 0)
            return;
        books.remove(book);
    }

    public List<Book> returnBooksList() {
        if (books == null)
            books = new ArrayList<>();
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(id, library.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", book=" + books +
                '}';
    }
}
