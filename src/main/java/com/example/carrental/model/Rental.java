package com.example.carrental.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "rentals") // Maps to the "rentals" collection in MongoDB
public class Rental {
    @Id
    private String id;
    private String userId;
    private String carId;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalCost;

    // ✅ Default Constructor (Needed for MongoDB)
    public Rental() {}

    // ✅ Parameterized Constructor
    public Rental(String userId, String carId, LocalDate startDate, LocalDate endDate, double totalCost) {
        this.userId = userId;
        this.carId = carId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
    }

    // ✅ Getters
    public String getId() { return id; }
    public String getUserId() { return userId; }
    public String getCarId() { return carId; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public double getTotalCost() { return totalCost; }

    // ✅ Setters
    public void setId(String id) { this.id = id; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setCarId(String carId) { this.carId = carId; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }

    // ✅ Optional: Override `toString()` for debugging
    @Override
    public String toString() {
        return "Rental{id='" + id + "', userId='" + userId + "', carId='" + carId + 
               "', startDate=" + startDate + ", endDate=" + endDate + ", totalCost=" + totalCost + "}";
    }
}
