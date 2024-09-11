package org.lld.parkinglot.manager.parkinglotmanager;

import org.lld.parkinglot.Driver;
import org.lld.parkinglot.entities.gate.EntryGate;
import org.lld.parkinglot.entities.gate.ExitGate;
import org.lld.parkinglot.entities.ticket.Ticket;
import org.lld.parkinglot.entities.vehicle.Vehicle;
import org.lld.parkinglot.entities.vehicle.VehicleType;
import org.lld.parkinglot.manager.parkingspotmanager.FourWheelerParkingSpotManager;
import org.lld.parkinglot.manager.parkingspotmanager.ParkingSpotManager;
import org.lld.parkinglot.manager.parkingspotmanager.TwoWheelerParkingSpotManager;

import java.util.Scanner;
import java.util.UUID;

public class ParkingLotManager {

    private EntryGate entryGate;
    private ExitGate exitGate;

    public ParkingLotManager() {
        ParkingSpotManager twoWheelerManager = new TwoWheelerParkingSpotManager();
        ParkingSpotManager fourWheelerManager = new FourWheelerParkingSpotManager();
        entryGate = new EntryGate(twoWheelerManager, fourWheelerManager);
        exitGate = new ExitGate(twoWheelerManager, fourWheelerManager);
    }

    public void handleEntry(){
        System.out.println("What's the vehicle type ? Enter 1 for two wheeler. Enter 2 for four wheeler.");
        switch (Driver.scanner.nextByte()){
            case 1: try{
                Ticket ticket = entryGate.handleVehicleEntry(new Vehicle(UUID.randomUUID().toString(), VehicleType.TWO_WHEELER));
                System.out.println("Hurray, Vehicle Parked. with ticket id. " + ticket.getTicketId());
            } catch (Exception e){
                System.out.println("Sorry we couldn't park your vehicle.");
            }
            break;
            case 2: try{
                Ticket ticket = entryGate.handleVehicleEntry(new Vehicle(UUID.randomUUID().toString(), VehicleType.FOUR_WHEELER));
                System.out.println("Hurray, Vehicle Parked. with ticket id. " + ticket.getTicketId());
            } catch (Exception e){
                System.out.println("Sorry we couldn't park your vehicle.");
            }
                break;
        }
    }

    public void handleExit(){
        System.out.println("Enter Ticket Id");
        Scanner scanner = new Scanner(System.in);
        String ticketId =  scanner.nextLine();
        System.out.println(ticketId);
        exitGate.handleVehicleExit(ticketId, VehicleType.TWO_WHEELER);
    }
}
