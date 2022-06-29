package org.example.data;

import org.example.model.User;

public interface Removeable<T> {
    void delete(T t);
}
