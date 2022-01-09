package com.example.geektrust.factories.water;

import com.example.geektrust.factories.aparment.Apartment;
import com.example.geektrust.util.Util;

public class CorporationWater implements WaterType {

    Integer costPerLitre = 1;
    private Integer noOfDays = 30;

    @Override
    public Integer calculateLitres(Apartment apartment, String ratio) {
        int totalWaterConsumed = apartment.getNoOfPersons() * apartment.getLitrePerPerson() * noOfDays;
        return Util.getLitres(ratio, totalWaterConsumed, 0);
    }

    @Override
    public Double calculateCost(Integer litres) {
        return Double.valueOf(litres * costPerLitre);
    }
}
