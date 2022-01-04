package com.example.geektrust.factories.aparment;

import com.example.geektrust.exception.WaterManagementException;

public class ApartmentFactory {

    public static Apartment getApartment(String[] args)  {
        switch (args[1]){
            case "2" : return new TwoBedRoomApartment();
            case "3" : return new ThreeBedRoomApartment();
            default: throw new WaterManagementException("Invalid Apartment Room type");
        }
    }
}
