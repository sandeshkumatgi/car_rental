package com.example.carrental.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users") // ✅ Use plural collection name (recommended for MongoDB)
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String password; // Hash this in production
    private String role; // CUSTOMER or ADMIN

    // ✅ Default Constructor (Needed for MongoDB)
    public User() {}

    // ✅ Parameterized Constructor
    public User(String name, String email, String phone, String password, String role) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }

    // ✅ Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    // ✅ Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }

    // ✅ Optional: Override `toString()` for debugging
    @Override
    public String toString() {
        return "User{id='" + id + "', name='" + name + "', email='" + email + "', phone='" + phone + "', role='" + role + "'}";
    }
}
