package com.example.geektrust.model.aparment;

import lombok.Data;

@Data
public abstract class Apartment {


    private Integer noOfGuests = 0;

    public abstract Integer getNoOfPersons();

    private String allotmentRatio = null;
    private final Integer litrePerPerson = 10;

    public Integer getLitrePerPerson(){
        return this.litrePerPerson;
    }
    public void addGuest(Integer guests) {
        this.noOfGuests += guests;
    }
}
