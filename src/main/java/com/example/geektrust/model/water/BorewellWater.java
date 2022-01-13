package com.example.geektrust.model.water;

import com.example.geektrust.model.aparment.Apartment;
import com.example.geektrust.util.Util;

public class BorewellWater implements WaterType {

    private Integer noOfDays = 30;
    private double costPerLitre = 1.5;

    @Override
    public Double calculateLitres(Apartment apartment) {
        int totalWaterConsumed = apartment.getNoOfPersons() * apartment.getLitrePerPerson() * noOfDays;
        return Util.getLitres(apartment.getAllotmentRatio(), totalWaterConsumed, 1);
    }

    @Override
    public Double calculateCost(Double litres) {
        return litres * costPerLitre;
    }
}
