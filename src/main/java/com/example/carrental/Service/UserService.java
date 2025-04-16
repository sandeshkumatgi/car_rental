package com.example.carrental.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.carrental.model.User;
import com.example.carrental.Repository.UserRepository;
import com.example.carrental.Singleton.AdminSingleton;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
            // Check DB for existing admin
            User existingAdmin = userRepository.findByRole("ADMIN");
            if (existingAdmin != null) {
                throw new IllegalStateException("Admin already exists in database.");
            }
        }
        return userRepository.save(user);
    }

    public void initializeAdminSingleton(String email) {
        User admin = userRepository.findByEmail(email);
        if (admin == null) {
            throw new IllegalStateException("Admin user not found with email: " + email);
        }
        AdminSingleton singleton = AdminSingleton.getInstance();
        if (!singleton.isInitialized()) {
            singleton.setAdmin(admin);
        }
    }

    public User getAdminFromSingleton() {
        return AdminSingleton.getInstance().getAdmin();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }
}
