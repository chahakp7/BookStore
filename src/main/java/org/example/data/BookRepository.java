package org.example.data;

import org.example.model.Book;

import java.util.List;


public interface BookRepository extends Removeable<Book>, Persistable<Book>, Searchable<Book>{

    void delete(Book book);
    Book save(Book book);
    Book findById(int itemId);
    List<Book> findAll();

}
