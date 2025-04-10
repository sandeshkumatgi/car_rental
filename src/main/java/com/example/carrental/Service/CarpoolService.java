package com.example.carrental.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.carrental.model.Carpool;
import com.example.carrental.Repository.CarpoolRepository;
import java.util.List;

@Service
public class CarpoolService {
    @Autowired
    private CarpoolRepository carpoolRepository;

    public Carpool createCarpool(Carpool carpool) {
        return carpoolRepository.save(carpool);
    }

    public List<Carpool> getAllCarpools() {
        return carpoolRepository.findAll();
    }

    public List<Carpool> getActiveCarpools() {
        return carpoolRepository.findByStatus("OPEN");
    }

    public List<Carpool> getUserCreatedCarpools(String userId) {
        return carpoolRepository.findByCreatorId(userId);
    }

    public List<Carpool> getUserJoinedCarpools(String userId) {
        return carpoolRepository.findByPassengerIdsContaining(userId);
    }

    public Carpool joinCarpool(String carpoolId, String userId) {
        Carpool carpool = carpoolRepository.findById(carpoolId)
            .orElseThrow(() -> new RuntimeException("Carpool not found"));
        
        if (carpool.addPassenger(userId)) {
            return carpoolRepository.save(carpool);
        }
        throw new RuntimeException("Cannot join carpool - it may be full or you're already a member");
    }

    public Carpool leaveCarpool(String carpoolId, String userId) {
        Carpool carpool = carpoolRepository.findById(carpoolId)
            .orElseThrow(() -> new RuntimeException("Carpool not found"));
        
        if (carpool.removePassenger(userId)) {
            return carpoolRepository.save(carpool);
        }
        throw new RuntimeException("User is not a member of this carpool");
    }

    public Carpool updateCarpoolStatus(String carpoolId, String status) {
        Carpool carpool = carpoolRepository.findById(carpoolId)
            .orElseThrow(() -> new RuntimeException("Carpool not found"));
        
        carpool.setStatus(status);
        return carpoolRepository.save(carpool);
    }
}