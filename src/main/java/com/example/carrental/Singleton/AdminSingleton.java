package com.example.carrental.Singleton;

import com.example.carrental.model.User;

public class AdminSingleton {
    private static AdminSingleton instance;
    private User admin;

    private AdminSingleton() {}

    public static synchronized AdminSingleton getInstance() {
        if (instance == null) {
            instance = new AdminSingleton();
        }
        return instance;
    }

    public synchronized void setAdmin(User admin) {
        if (this.admin != null) {
            throw new IllegalStateException("Admin already initialized.");
        }
        if (!"ADMIN".equalsIgnoreCase(admin.getRole())) {
            throw new IllegalArgumentException("User must have ADMIN role.");
        }
        this.admin = admin;
    }

    public User getAdmin() {
        return admin;
    }

    public boolean isInitialized() {
        return admin != null;
    }
}
