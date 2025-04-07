package com.example.carrental.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.carrental.model.Car;
import com.example.carrental.Repository.CarRepository;
import com.example.carrental.model.Rental;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll(); // Ensure this method exists
    }

    public Car addBookingToCar(String carId, Rental rental) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found with ID: " + carId));

        List<Rental> currentBookings = car.getBookings();

        if (currentBookings == null) {
            currentBookings = new java.util.ArrayList<>();
        }

        currentBookings.add(rental);
        car.setBookings(currentBookings);

        return carRepository.save(car);
    }
}
