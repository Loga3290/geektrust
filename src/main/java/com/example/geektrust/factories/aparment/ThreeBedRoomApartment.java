package com.example.geektrust.factories.aparment;

import lombok.Data;

@Data
public class ThreeBedRoomApartment implements Apartment {

    private Integer noOfGuests = 0;
    private final Integer noOfPersons = 5;
    private final Integer litrePerPerson = 10;


    @Override
    public void addGuest(Integer guests) {
        this.noOfGuests += guests;
    }

}
