package com.example.geektrust.model.aparment;

import lombok.Data;

@Data
public abstract class Apartment {

    public Apartment(Integer litrePerPerson, Integer noOfDaysInMonth){
        this.litrePerPerson = litrePerPerson;
        this.noOfDaysInMonth = noOfDaysInMonth;
    }

    private final Integer noOfDaysInMonth;
    private String allotmentRatio = null;
    private final Integer litrePerPerson;
    private Integer noOfGuests = 0;

    public abstract Integer getNoOfPersons();
    public Integer getLitrePerPerson(){
        return this.litrePerPerson;
    }
    public void addGuest(Integer guests) {
        this.noOfGuests += guests;
    }
    public Integer getNoOfDaysInMonth(){
        return this.noOfDaysInMonth;
    }
}
