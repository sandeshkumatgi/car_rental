package com.example.carrental.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.carrental.model.Carpool;
import java.util.List;

public interface CarpoolRepository extends MongoRepository<Carpool, String> {
    List<Carpool> findByCreatorId(String creatorId);
    List<Carpool> findByPassengerIdsContaining(String passengerId);
    List<Carpool> findByStatus(String status);
}