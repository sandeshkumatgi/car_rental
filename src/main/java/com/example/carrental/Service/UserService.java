package com.example.carrental.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.carrental.model.User;
import com.example.carrental.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll(); // Ensure this method exists in UserRepository
    }
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }
    
}