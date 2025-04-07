package com.example.carrental.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.carrental.model.Car;
import com.example.carrental.Service.CarService;
import com.example.carrental.model.Rental;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @GetMapping("/all")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping("/{carId}/book")
    public Car bookCar(@PathVariable String carId, @RequestBody Rental rental) {
        return carService.addBookingToCar(carId, rental);
    }

}
