package com.example.carrental.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.example.carrental.model.Car;
import com.example.carrental.model.Rental;
import com.example.carrental.Repository.CarRepository;
import com.example.carrental.Repository.RentalRepository;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private CarRepository carRepository;


    public Rental bookCar(Rental rental) {
    long days = ChronoUnit.DAYS.between(rental.getStartDate(), rental.getEndDate()) + 1;

    // Fetch car and calculate cost from car's price
    Car car = carRepository.findById(rental.getCarId())
        .orElseThrow(() -> new RuntimeException("Car not found with ID: " + rental.getCarId()));

    rental.setTotalCost(days * car.getPricePerDay());  // dynamic pricing

    // Save rental in collection
    Rental savedRental = rentalRepository.save(rental);

    // Append to car.bookings
    List<Rental> bookings = car.getBookings();
    if (bookings == null) bookings = new java.util.ArrayList<>();
    bookings.add(savedRental);
    car.setBookings(bookings);

    // Save updated car
    carRepository.save(car);

    return savedRental;
}

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();  // Ensure this method exists
    }

    public List<Rental> getUserRentals(String userId) {
        return rentalRepository.findByuserId(userId);  // Ensure this method exists
    }
}
