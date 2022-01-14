package com.example.geektrust.model.aparment;

public class ThreeBedRoomApartment extends Apartment {

    private Integer noOfPersons;
    public ThreeBedRoomApartment(Integer noOfPersons, Integer litrePerPerson, Integer noOfDaysInMonth){
        super(litrePerPerson, noOfDaysInMonth);
        this.noOfPersons = noOfPersons;
    }


    @Override
    public Integer getNoOfPersons() {
        return this.noOfPersons;
    }
}
