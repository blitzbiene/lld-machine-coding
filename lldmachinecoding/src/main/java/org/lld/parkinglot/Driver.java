package org.lld.parkinglot;

import org.lld.parkinglot.manager.parkinglotmanager.ParkingLotManager;

import java.util.Scanner;

public class Driver {
    public static boolean isProgramActive = true;
    public static  final Scanner scanner =  new Scanner(System.in);

    public static void main(String[] args) {
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        while(isProgramActive){
            System.out.println("Select from an option below:\n 1 for Parking Vehicle [1] \n 2 for exit from parking\n 3 To end this program\n");

            int option = scanner.nextInt();
            switch (option){
                case 1: parkingLotManager.handleEntry();
                        break;
                case 2: parkingLotManager.handleExit();
                break;
                case 3: isProgramActive =false;
                break;
                default:
            }
        }
    }

}
