package com.example.carrental.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.carrental.model.Rental;
import com.example.carrental.Service.RentalService;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    @Autowired
    private RentalService rentalService;

    @PostMapping("/book")
    public Rental bookCar(@RequestBody Rental rental) {
        return rentalService.bookCar(rental);
    }

    @GetMapping("/all")
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/{userId}")
    public List<Rental> getUserRentals(@PathVariable String userId) {
        return rentalService.getUserRentals(userId);
    }
}
