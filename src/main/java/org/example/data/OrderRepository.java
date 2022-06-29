package org.example.data;

import org.example.model.Book;
import org.example.model.Order;

import java.util.List;

public interface OrderRepository extends Persistable<Order>, Searchable<Order>{

}
