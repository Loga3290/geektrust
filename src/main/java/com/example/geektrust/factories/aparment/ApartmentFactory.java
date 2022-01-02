package com.example.geektrust.factories.aparment;

public class ApartmentFactory {

    public static Apartment getApartment(String[] args){
        switch (args[1]){
            case "2" : return new TwoBedRoomApartment();
            case "3" : return new ThreeBedRoomApartment();
            default: throw new RuntimeException("Invalid Bed Room type");
        }
    }
}
