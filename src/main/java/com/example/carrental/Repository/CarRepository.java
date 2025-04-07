package com.example.carrental.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.carrental.model.Car;

public interface CarRepository extends MongoRepository<Car, String> {
    Car findByModel(String model);
    // Car findById(String id);
}
