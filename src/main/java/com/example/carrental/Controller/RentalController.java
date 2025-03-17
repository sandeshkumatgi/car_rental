package com.example.carrental.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import com.example.carrental.Service.RentalService;

import com.example.carrental.model.Rental;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    @Autowired
    private RentalService rentalService;

    @PostMapping("/book")
    public Rental rentCar(@RequestParam String userId, @RequestParam String carId,
                          @RequestParam String startDate, @RequestParam String endDate) {
        return rentalService.rentCar(userId, carId, LocalDate.parse(startDate), LocalDate.parse(endDate));
    }
}

