package com.oomph.library.repository;

import com.oomph.library.model.Book;

import java.util.Map;

public interface IBookRepository {
    void addBook(Book book);
    Book getBook(String isbn);
    void removeBook(String isbn);
    boolean exists(String isbn);
}
