package org.example.model;

import java.time.LocalDateTime;

public class Order {
    private final int orderId;
    private static int nextId = 1;
    private Book bookOrdered;
    private User user;
    private LocalDateTime orderDateTime;

    public Order(Book bookOrdered, User user, LocalDateTime orderDateTime) {
        this.orderId = nextId;
        nextId++;
        this.bookOrdered = bookOrdered;
        this.user = user;
        this.orderDateTime = orderDateTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public Book getBookOrdered() {
        return bookOrdered;
    }

    public void setBookOrdered(Book bookOrdered) {
        this.bookOrdered = bookOrdered;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }
}
