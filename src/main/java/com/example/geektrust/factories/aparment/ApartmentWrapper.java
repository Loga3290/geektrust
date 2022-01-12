package com.example.geektrust.factories.aparment;

import lombok.Data;

@Data
public class ApartmentWrapper {

    private static Apartment apartment = null;

    public static Apartment getInstance(){
            return apartment;
    }
    public static void init(Apartment apartmentParam){
        apartment = apartmentParam;
    }
}
