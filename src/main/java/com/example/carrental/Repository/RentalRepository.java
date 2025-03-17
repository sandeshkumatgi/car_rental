package com.example.carrental.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.carrental.model.Rental;

@Repository
public interface RentalRepository extends MongoRepository<Rental, String> {
}
