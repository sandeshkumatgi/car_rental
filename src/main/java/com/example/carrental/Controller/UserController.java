package com.example.carrental.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.carrental.model.User;
import com.example.carrental.Service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

   @PostMapping("/register")
    public Map<String, Object> registerUser(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        User existingUser = userService.getUser(user.getEmail());

        if (existingUser != null) {
            response.put("message", "already registered");
            response.put("user", new User()); // empty user object
            return response;
        }

        User savedUser = userService.registerUser(user);
        response.put("message", "success");
        response.put("user", savedUser);
        return response;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        User u = userService.getUser(user.getEmail());
        if (u == null) {
            return null;
        }
        if (u.getPassword().equals(user.getPassword())) {
            return u;
        }
        return null;
    }
}