package org.example.model;

public class AudioBook extends Book {
    private int timeLengthSeconds;

    public AudioBook(int itemId, double price, String title, String author, BookGenre bookGenre) {
        super(itemId, price, title, author, bookGenre);
    }

    public AudioBook(int itemId, double price, String title, String author, BookGenre bookGenre, int timeLengthSeconds) {
        super(itemId, price, title, author, bookGenre);
        this.timeLengthSeconds = timeLengthSeconds;
    }

    public int getTimeLengthSeconds() {
        return timeLengthSeconds;
    }

    public void setTimeLengthSeconds(int timeLengthSeconds) {
        this.timeLengthSeconds = timeLengthSeconds;
    }
}
