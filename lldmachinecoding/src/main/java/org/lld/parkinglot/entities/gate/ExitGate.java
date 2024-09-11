package org.lld.parkinglot.entities.gate;

import org.lld.parkinglot.entities.parkingspot.ParkingSpot;
import org.lld.parkinglot.entities.ticket.Ticket;
import org.lld.parkinglot.entities.vehicle.Vehicle;
import org.lld.parkinglot.entities.vehicle.VehicleType;
import org.lld.parkinglot.manager.parkingspotmanager.ParkingSpotManager;

public class ExitGate implements Gate{

    ParkingSpotManager twoWheeletParkingSpotManager;
    ParkingSpotManager fourWheelerParkingSpotManager;

    public ExitGate(ParkingSpotManager twoWheeletParkingSpotManager, ParkingSpotManager fourWheelerParkingSpotManager) {
        this.twoWheeletParkingSpotManager = twoWheeletParkingSpotManager;
        this.fourWheelerParkingSpotManager = fourWheelerParkingSpotManager;
    }

    public Vehicle handleVehicleExit(String ticketId, VehicleType vehicleType) {
        ParkingSpotManager parkingSpotManager = vehicleType == VehicleType.FOUR_WHEELER ? fourWheelerParkingSpotManager:twoWheeletParkingSpotManager;
        ParkingSpot parkingSpot = parkingSpotManager.getParkingSpotByTicketId(ticketId);
        Ticket ticket = parkingSpot.getTicket();
        parkingSpotManager.unParkVehicle(ticket.getVehicle());
        float cost = ticket.getParkingCost();
        System.out.println("Parking cost paid " + cost);
        return ticket.getVehicle();
    }
}
