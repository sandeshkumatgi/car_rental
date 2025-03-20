package com.example.carrental.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.example.carrental.model.Rental;
import com.example.carrental.Repository.RentalRepository;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    public Rental bookCar(Rental rental) {
        long days = ChronoUnit.DAYS.between(rental.getStartDate(), rental.getEndDate());
        rental.setTotalCost(days * 50); // Example price
        return rentalRepository.save(rental);
    }
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();  // Ensure this method exists
    }

    public List<Rental> getUserRentals(String userId) {
        return rentalRepository.findByuserId(userId);  // Ensure this method exists
    }
}
