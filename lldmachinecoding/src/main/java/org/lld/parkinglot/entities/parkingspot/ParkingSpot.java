package org.lld.parkinglot.entities.parkingspot;

import org.lld.parkinglot.entities.ticket.Ticket;
import org.lld.parkinglot.entities.vehicle.Vehicle;

public abstract class ParkingSpot {
    private String parkingSpotId;
    private Vehicle vehicle;
    private float price;
    private boolean isEmpty;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private Ticket ticket;


    public ParkingSpot(String parkingSpotId, float price) {
        this.parkingSpotId = parkingSpotId;
        this.vehicle = null;
        this.price = price;
        this.isEmpty = true;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public float getPrice() {
        return price;
    }

    public boolean isEmpty() {
        return isEmpty;
    }



    public void parkVehicle(Vehicle vehicle){
        this.isEmpty = false;
        this.vehicle = vehicle;
    }

    public void unParkVehicle(){
        this.vehicle = null;
        this.isEmpty = true;
    }


}
