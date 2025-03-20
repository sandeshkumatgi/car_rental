package com.example.carrental.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
public class Car {
    @Id
    private String id;
    private String model;
    private String status; // AVAILABLE or RENTED
    private double pricePerDay;

    public Car() {}

    public Car(String model, String status, double pricePerDay) {
        this.model = model;
        this.status = status;
        this.pricePerDay = pricePerDay;
    }

    public String getId() { return id; }
    public String getModel() { return model; }
    public String getStatus() { return status; }
    public double getPricePerDay() { return pricePerDay; }

    public void setId(String id) { this.id = id; }
    public void setModel(String model) { this.model = model; }
    public void setStatus(String status) { this.status = status; }
    public void setPricePerDay(double pricePerDay) { this.pricePerDay = pricePerDay; }
}
