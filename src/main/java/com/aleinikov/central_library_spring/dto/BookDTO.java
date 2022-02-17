package com.aleinikov.central_library_spring.dto;

import com.aleinikov.central_library_spring.entities.Library;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class BookDTO {

    private Long id;
    private String title;
    private String author;
    private Date orderDate;
    private String customer;
    private Library library;

    public BookDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDTO bookDTO = (BookDTO) o;
        return Objects.equals(id, bookDTO.id) && Objects.equals(title, bookDTO.title) && Objects.equals(author, bookDTO.author) && Objects.equals(orderDate, bookDTO.orderDate) && Objects.equals(customer, bookDTO.customer) && Objects.equals(library, bookDTO.library);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, orderDate, customer, library);
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", orderDate=" + orderDate +
                ", customer='" + customer + '\'' +
                ", library=" + library +
                '}';
    }
}
