package com.example.carrental.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Document(collection = "carpools")
public class Carpool {
    @Id
    private String id;
    private String creatorId;
    private String source;
    private String destination;
    private LocalDateTime departureTime;
    private int maxPassengers;
    private List<String> passengerIds;
    private String status; // OPEN, FULL, CANCELLED, COMPLETED

    public Carpool() {
        this.passengerIds = new ArrayList<>();
        this.status = "OPEN";
    }

    public Carpool(String creatorId, String source, String destination, 
                  LocalDateTime departureTime, int maxPassengers) {
        this.creatorId = creatorId;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.maxPassengers = maxPassengers;
        this.passengerIds = new ArrayList<>();
        this.status = "OPEN";
    }

    // Getters
    public String getId() { return id; }
    public String getCreatorId() { return creatorId; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public int getMaxPassengers() { return maxPassengers; }
    public List<String> getPassengerIds() { return passengerIds; }
    public String getStatus() { return status; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setCreatorId(String creatorId) { this.creatorId = creatorId; }
    public void setSource(String source) { this.source = source; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
    public void setMaxPassengers(int maxPassengers) { this.maxPassengers = maxPassengers; }
    public void setPassengerIds(List<String> passengerIds) { this.passengerIds = passengerIds; }
    public void setStatus(String status) { this.status = status; }

    // Helper methods
    public boolean addPassenger(String passengerId) {
        if (passengerIds.size() < maxPassengers && !passengerIds.contains(passengerId)) {
            passengerIds.add(passengerId);
            if (passengerIds.size() == maxPassengers) {
                status = "FULL";
            }
            return true;
        }
        return false;
    }

    public boolean removePassenger(String passengerId) {
        boolean removed = passengerIds.remove(passengerId);
        if (removed && status.equals("FULL")) {
            status = "OPEN";
        }
        return removed;
    }
}