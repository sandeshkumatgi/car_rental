package com.example.carrental.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.time.LocalDate;


import com.example.carrental.Repository.RentalRepository;

import com.example.carrental.model.Rental;

import com.example.carrental.Repository.CarRepository;

import com.example.carrental.model.Car;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private CarRepository carRepository;

    public Rental rentCar(String userId, String carId, LocalDate startDate, LocalDate endDate) {
        Optional<Car> car = carRepository.findById(carId);
        if (car.isPresent() && car.get().getStatus().equals("AVAILABLE")) {
            long days = ChronoUnit.DAYS.between(startDate, endDate);
            double totalCost = days * car.get().getPricePerDay();
            
            car.get().setStatus("RENTED");
            carRepository.save(car.get());

            Rental rental = new Rental(userId, carId, startDate, endDate, totalCost);
            return rentalRepository.save(rental);
        }
        return null;
    }
}
