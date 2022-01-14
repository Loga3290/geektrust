package com.example.geektrust.model.water;

import com.example.geektrust.model.aparment.Apartment;
import com.example.geektrust.util.Util;

public class CorporationWater implements WaterType {

    Integer costPerLitre;

    public CorporationWater(int costPerLitre) {
        this.costPerLitre = costPerLitre;
    }

    @Override
    public Double calculateLitres(Apartment apartment) {
        int totalWaterConsumed = apartment.getNoOfPersons() * apartment.getLitrePerPerson() * apartment.getNoOfDaysInMonth();
        return Util.getLitres(apartment.getAllotmentRatio(), totalWaterConsumed, 0);
    }

    @Override
    public Double calculateCost(Double litres) {
        return Double.valueOf(litres * costPerLitre);
    }
}
