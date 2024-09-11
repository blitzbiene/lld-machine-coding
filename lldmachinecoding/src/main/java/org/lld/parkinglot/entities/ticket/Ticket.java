package org.lld.parkinglot.entities.ticket;

import org.lld.parkinglot.entities.parkingspot.ParkingSpot;
import org.lld.parkinglot.entities.vehicle.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {

    private String ticketId;
    private LocalDateTime issuedTime;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;

    public Ticket(String ticketId, LocalDateTime issuedTime, ParkingSpot parkingSpot, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.issuedTime = issuedTime;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public LocalDateTime getIssuedTime() {
        return issuedTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public float getParkingCost(){
        float price = parkingSpot.getPrice();
        Duration duration = Duration.between(issuedTime, LocalDateTime.now());
        long diffInMillis = duration.toMillis();
        float totalCost = price * diffInMillis;
        return totalCost;
    }
}
