package org.example.data;

import org.example.model.User;

import java.util.List;

public interface Searchable<T> {
    T findById(int id);
    public List<T> findAll();
}
