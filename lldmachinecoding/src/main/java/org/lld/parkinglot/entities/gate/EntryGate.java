package org.lld.parkinglot.entities.gate;

import org.lld.parkinglot.entities.vehicle.VehicleType;
import org.lld.parkinglot.entities.parkingspot.ParkingSpot;
import org.lld.parkinglot.entities.ticket.Ticket;
import org.lld.parkinglot.entities.vehicle.Vehicle;
import org.lld.parkinglot.exceptions.VehicleTypeNotFoundException;
import org.lld.parkinglot.manager.parkingspotmanager.ParkingSpotManager;

import java.time.LocalDateTime;
import java.util.UUID;

public class EntryGate implements Gate{

    private ParkingSpotManager twoWheelerParkingManager;
    private ParkingSpotManager fourWheelerParkingManager;

    public EntryGate(ParkingSpotManager twoWheelerParkingManager, ParkingSpotManager fourWheelerParkingManager) {
        this.twoWheelerParkingManager = twoWheelerParkingManager;
        this.fourWheelerParkingManager = fourWheelerParkingManager;
    }

    public Ticket handleVehicleEntry(Vehicle vehicle) throws VehicleTypeNotFoundException{

        ParkingSpotManager parkingSpotManager;
        if(vehicle.getVehicleType() == VehicleType.FOUR_WHEELER){
            parkingSpotManager = fourWheelerParkingManager;
        } else if(vehicle.getVehicleType() == VehicleType.TWO_WHEELER){
            parkingSpotManager = twoWheelerParkingManager;
        } else{
            throw new VehicleTypeNotFoundException();
        }
        ParkingSpot parkingSpot = parkingSpotManager.parkVehicle(vehicle);
        Ticket ticket = new Ticket(UUID.randomUUID().toString(), LocalDateTime.now(), parkingSpot, vehicle);
        parkingSpot.setTicket(ticket);
        vehicle.setTicket(ticket);
        vehicle.setParkingSpot(parkingSpot);
        return ticket;
    }
}
