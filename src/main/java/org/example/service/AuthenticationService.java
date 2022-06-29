package org.example.service;

import org.example.data.UserRepository;
import org.example.model.User;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.security.spec.ECFieldF2m;

public class AuthenticationService {
    private UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User authenticate(String username, String password){
        if(userRepository.validate(username, password)){
            return userRepository.findByUsername(username);
        }
        return null;
    }

    public User findById(int Id) throws Exception {
        if (userRepository.findById(Id) == null){
            throw new UserNotFoundException();
        }
        return userRepository.findById(Id);
    }
}

class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        System.out.println("User not found");
    }
}
