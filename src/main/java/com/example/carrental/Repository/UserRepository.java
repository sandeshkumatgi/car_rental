package com.example.carrental.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.carrental.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
