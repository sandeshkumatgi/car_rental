package com.example.carrental.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// @Document(collection = "cars")
@Document(collection = "cars")
public class Car {
    @Id
    private String id;
    private String model;
    private double pricePerDay;
    private String status; // ✅ Add this field

    public Car() {}

    public Car(String model, double pricePerDay, String status) {
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public String getStatus() { // ✅ Add Getter
        return status;
    }

    public void setStatus(String status) { // ✅ Add Setter
        this.status = status;
    }
}