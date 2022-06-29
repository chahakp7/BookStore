package org.example.model;

public class Book {
    private int itemId;
    private double price;
    private String title;
    private String author;
    private BookGenre bookGenre;

    public Book(int itemId, double price, String title, String author, BookGenre bookGenre) {
        this.itemId = itemId;
        this.price = price;
        this.title = title;
        this.author = author;
        this.bookGenre = bookGenre;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
    }
}