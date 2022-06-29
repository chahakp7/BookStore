package org.example.data;

import org.example.model.User;

import java.util.List;

public interface UserRepository extends Searchable<User> {
    boolean validate(String username, String password);
    User findByUsername(String username);


}
