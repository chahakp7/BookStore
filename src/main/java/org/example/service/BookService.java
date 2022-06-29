package org.example.service;

import org.example.data.BookRepository;
import org.example.model.Book;
import org.example.model.BookGenre;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public List<Book> getBooksOfGenre(BookGenre bookGenre){
        List<Book> books = getAllBooks();
        books.removeIf(book -> book.getBookGenre() != bookGenre);
        return books;
    }

    public List<Book> searchBookByTitle(String title){
        List<Book> books = getAllBooks();
        books.removeIf(book -> book.getTitle() != title);
        return books;
    }

    public List<Book> searchBooksByAuthorName(String bookAuthorNameToSearch){
        List<Book> books = getAllBooks();
        books.removeIf(book -> book.getAuthor() != bookAuthorNameToSearch);
        return books;
    }

    public Book findById(int itemId) throws Exception {
        Book findBook = bookRepository.findAll().stream()
                                .filter(book -> book.getItemId() == itemId)
                                .findFirst().orElseThrow(() -> new ItemNotFoundException());
        return findBook;
    }

}

class ItemNotFoundException extends Exception{
    public ItemNotFoundException() {
        System.out.println("Item not found");
    }
}
