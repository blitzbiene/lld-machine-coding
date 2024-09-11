package org.lld.parkinglot.manager.parkingspotmanager;

import org.lld.parkinglot.entities.parkingspot.TwoWheelerParkingSpot;

import java.util.ArrayList;
import java.util.UUID;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager{
    private static final int parkingCapacity = 150;
    public TwoWheelerParkingSpotManager() {
        super(new ArrayList<>(parkingCapacity));
        for(int i=0;i<parkingCapacity;i++){
            super.parkingSpotList.add(i, new TwoWheelerParkingSpot(UUID.randomUUID().toString()));
        }
        System.out.println(super.parkingSpotList.size());

    }
}
