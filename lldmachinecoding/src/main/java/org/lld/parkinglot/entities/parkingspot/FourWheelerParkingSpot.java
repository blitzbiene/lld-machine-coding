package org.lld.parkinglot.entities.parkingspot;

public class FourWheelerParkingSpot extends ParkingSpot{

    private static final float price = 30;
    public FourWheelerParkingSpot(String parkingSpotId) {
        super(parkingSpotId, price);
    }

}
