package com.example.geektrust.factories.aparment;

import lombok.Data;

@Data
public class TwoBedRoomApartment implements Apartment {

    private Integer noOfGuests = 0;
    private final Integer noOfPersons = 3;
    private final Integer litrePerPerson = 10;

    @Override
    public void addGuest(Integer guests) {
        this.noOfGuests += guests;
    }


}
