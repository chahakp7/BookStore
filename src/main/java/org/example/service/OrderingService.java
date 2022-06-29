package org.example.service;

import org.example.data.OrderRepository;
import org.example.model.Book;
import org.example.model.Order;
import org.example.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderingService {
    private OrderRepository orderRepository;
    private BookService bookService;
    private AuthenticationService authenticationService;

    public OrderingService(OrderRepository orderRepository, BookService bookService, AuthenticationService authenticationService) {
        this.orderRepository = orderRepository;
        this.bookService = bookService;
        this.authenticationService = authenticationService;
    }

    public Order placeOrder(Book book, User customer){
        try {
            if (bookService.findById(book.getItemId()) != null && authenticationService.findById(customer.getUserId()) != null){
                Order order = new Order(book, customer, LocalDateTime.now());
                orderRepository.save(order);
                return order;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    List<Order> placeOrder(List<Book> books, User customer){
        List<Order> orders = new ArrayList<>();
        for (Book book :
                books) {
            try {
                if (bookService.findById(book.getItemId()) != null && authenticationService.findById(customer.getUserId()) != null) {
                    Order order = new Order(book, customer, LocalDateTime.now());
                    orders.add(order);
                    orderRepository.save(order);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return orders;
    }

    public List<Order> getOrdersForUser(User user){
        return orderRepository.findAll().stream().filter(order -> order.getUser().getUserId() == user.getUserId()).collect(Collectors.toList());
    }

    public List<Order> getOrdersForBook(Book book){
        return orderRepository.findAll().stream().filter(order -> order.getBookOrdered().getItemId() == book.getItemId()).collect(Collectors.toList());
    }
}
