package org.example.model;

public class EBook extends Book{
    private double sizeMegaBytes;

    public EBook(int itemId, double price, String title, String author, BookGenre bookGenre) {
        super(itemId, price, title, author, bookGenre);
    }
    public EBook(int itemId, double price, String title, String author, BookGenre bookGenre, double sizeMegaBytes) {
        super(itemId, price, title, author, bookGenre);
        this.sizeMegaBytes = sizeMegaBytes;
    }

    public double getSizeMegaBytes() {
        return sizeMegaBytes;
    }

    public void setSizeMegaBytes(double sizeMegaBytes) {
        this.sizeMegaBytes = sizeMegaBytes;
    }
}
