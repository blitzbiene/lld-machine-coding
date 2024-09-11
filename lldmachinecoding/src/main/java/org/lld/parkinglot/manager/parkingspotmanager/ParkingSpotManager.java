package org.lld.parkinglot.manager.parkingspotmanager;

import org.lld.parkinglot.entities.parkingspot.ParkingSpot;
import org.lld.parkinglot.entities.vehicle.Vehicle;

import java.util.List;

public abstract class ParkingSpotManager {

     List<ParkingSpot> parkingSpotList;

    public ParkingSpotManager(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    private ParkingSpot findParkingSpace(){
        System.out.println(parkingSpotList.size());
        return parkingSpotList.stream().filter(x -> x.isEmpty()).findAny().orElse(null);
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot parkingSpot = this.findParkingSpace();
        System.out.println(parkingSpot);
        parkingSpot.parkVehicle(vehicle);
        return parkingSpot;
    }

    public void unParkVehicle(Vehicle vehicle){
        ParkingSpot parkingSpot = vehicle.getParkingSpot();
        System.out.println(vehicle.getTicket());
        System.out.println(vehicle.getParkingSpot());
        parkingSpot.unParkVehicle();
    }

    public ParkingSpot getParkingSpotByTicketId(String ticketId){
        System.out.println(parkingSpotList.size());
        return this.parkingSpotList.stream().filter(x -> x.getTicket().getTicketId().equals(ticketId)).findAny().orElse(null);
    }


}
