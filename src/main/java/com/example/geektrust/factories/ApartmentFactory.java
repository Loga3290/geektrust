package com.example.geektrust.factories;

import com.example.geektrust.exception.WaterManagementException;
import com.example.geektrust.model.aparment.Apartment;
import com.example.geektrust.model.aparment.ThreeBedRoomApartment;
import com.example.geektrust.model.aparment.TwoBedRoomApartment;

public class ApartmentFactory {

    public static Apartment getApartment(String[] args){
        switch (args[1]){
            case "2" : return new TwoBedRoomApartment(3, 10, 30);
            case "3" : return new ThreeBedRoomApartment(5, 10, 30);
            default: throw new WaterManagementException("Invalid Apartment Room type");
        }
    }
}
