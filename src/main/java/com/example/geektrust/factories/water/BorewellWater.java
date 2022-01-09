package com.example.geektrust.factories.water;

import com.example.geektrust.factories.aparment.Apartment;
import com.example.geektrust.util.Util;

public class BorewellWater implements WaterType {

    private Integer noOfDays = 30;
    private double costPerLitre = 1.5;

    @Override
    public Integer calculateLitres(Apartment apartment, String ratio) {
        int totalWaterConsumed = apartment.getNoOfPersons() * apartment.getLitrePerPerson() * noOfDays;
        return Util.getLitres(ratio, totalWaterConsumed, 1);
    }

    @Override
    public Double calculateCost(Integer litres) {
        return litres * costPerLitre;
    }
}
