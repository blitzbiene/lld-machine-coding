package org.lld.parkinglot.entities.parkingspot;

public class TwoWheelerParkingSpot extends ParkingSpot{

    private static final float price = 15;
    public TwoWheelerParkingSpot(String parkingSpotId){
        super(parkingSpotId, price);
    }
}
