package com.example.geektrust.factories.aparment;

import lombok.Data;

@Data
public class ApartmentAndRatio {

    private ApartmentAndRatio(){

    }
    private ApartmentAndRatio(Apartment apartment, String allotmentRatio){
        this.apartment = apartment;
        this.allotmentRatio = allotmentRatio;
    }
    private Apartment apartment;
    private String allotmentRatio;

    public static ApartmentAndRatio apartmentAndRatio = new ApartmentAndRatio();
    public static ApartmentAndRatio getInstance(){
        if(apartmentAndRatio == null){
            return new ApartmentAndRatio();
        }
        return apartmentAndRatio;
    }
    public static void init(Apartment apartment, String allotmentRatio){
        apartmentAndRatio.apartment = apartment;
        apartmentAndRatio.allotmentRatio = allotmentRatio;
    }
}
