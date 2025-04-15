package com.example.carrental.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.carrental.model.Car;
import com.example.carrental.Service.CarService;


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

    @GetMapping("/{carId}")
    public Car getUserRentals(@PathVariable String carId) {
        return carService.getCarById(carId);
    }

    @DeleteMapping("/delete/{carId}")
    public void deleteCar(@PathVariable String carId) {
        carService.deleteCar(carId);
    }

    @PutMapping("/{carId}/price/{newPrice}")
    public Car updateCarPrice(@PathVariable String carId, @PathVariable double newPrice) {
        return carService.updateCarPrice(carId, newPrice);
    }
}
