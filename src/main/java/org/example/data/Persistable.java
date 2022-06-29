package org.example.data;


public interface Persistable<T>  {
    T save(T t);
}
