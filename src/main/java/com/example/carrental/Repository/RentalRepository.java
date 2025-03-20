package com.example.carrental.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.carrental.model.Rental;

public interface RentalRepository extends MongoRepository<Rental, String> {
    List<Rental> findByuserId(String userId);
}
