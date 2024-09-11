package org.lld.parkinglot.manager.parkingspotmanager;

import org.lld.parkinglot.entities.parkingspot.FourWheelerParkingSpot;

import java.util.ArrayList;
import java.util.UUID;

public class FourWheelerParkingSpotManager extends ParkingSpotManager{

    private static final int parkingCapacity = 80;
    public FourWheelerParkingSpotManager(){
        super(new ArrayList<>(parkingCapacity));
        for(int i=0;i<parkingCapacity;i++){
            super.parkingSpotList.add(i, new FourWheelerParkingSpot(UUID.randomUUID().toString()));
        }
    }
}
