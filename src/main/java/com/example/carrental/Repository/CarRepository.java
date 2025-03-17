package com.example.carrental.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.carrental.model.Car;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    Car findByModel(String model);
}
