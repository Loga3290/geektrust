package com.example.geektrust.model.water;

import com.example.geektrust.model.aparment.Apartment;

import java.util.Map;

public class TankerWater implements WaterType {

    Map<Double, Double> slabMap;
    public TankerWater(Map<Double, Double> slabMap) {
        this.slabMap = slabMap;
    }

    @Override
    public Double calculateLitres(Apartment apartment) {
        return Double.valueOf(apartment.getNoOfGuests() * apartment.getLitrePerPerson() * apartment.getNoOfDaysInMonth());
    }

    @Override
    public Double calculateCost(Double totalLitres) {
        Double totalCost = 0d;
        //top down approach to find the cost
        for(Map.Entry<Double, Double> entry : slabMap.entrySet()){
            if(totalLitres > entry.getKey()){
                totalCost += (totalLitres - entry.getKey()) * entry.getValue();
                totalLitres = entry.getKey();
            }
        }
        return totalCost;
    }
}
