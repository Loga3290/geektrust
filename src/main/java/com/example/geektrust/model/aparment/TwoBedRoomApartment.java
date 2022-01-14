package com.example.geektrust.model.aparment;

public class TwoBedRoomApartment extends Apartment {

    private Integer noOfPersons;

    public TwoBedRoomApartment(Integer noOfPersons, Integer litrePerPerson, Integer noOfDaysInMonth) {
        super(litrePerPerson, noOfDaysInMonth);
        this.noOfPersons = noOfPersons;
    }


    @Override
    public Integer getNoOfPersons() {
        return this.noOfPersons;
    }
}
