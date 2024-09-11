package org.lld.parkinglot.entities.vehicle;

import org.lld.parkinglot.entities.parkingspot.ParkingSpot;
import org.lld.parkinglot.entities.ticket.Ticket;

public class Vehicle {

    private String vehicleNumber;
    private VehicleType vehicleType;

    private ParkingSpot parkingSpot;
    private Ticket ticket;

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
